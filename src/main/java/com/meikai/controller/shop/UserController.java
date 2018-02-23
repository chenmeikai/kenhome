/**
 * 
 */
package com.meikai.controller.shop;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aliyuncs.exceptions.ClientException;
import com.meikai.identifyingCode.CreateImageCode;
import com.meikai.plugin.aliyunSms.SendSms;
import com.meikai.shop.entity.TShopCart;
import com.meikai.shop.entity.TShopCartSku;
import com.meikai.shop.entity.TShopMember;
import com.meikai.shop.entity.TShopShipAddress;
import com.meikai.shop.entity.TSystemArea;
import com.meikai.shop.service.AreaService;
import com.meikai.shop.service.CartService;
import com.meikai.shop.service.CartSkuService;
import com.meikai.shop.service.MemberService;
import com.meikai.shop.service.ShipAddressService;
import com.meikai.util.IpUtils;
import com.meikai.util.MD5;
import com.meikai.util.PropertiesUtil;

/**
 * 用户
 * @author meikai
 * @version 2017年11月10日 下午1:25:44
 */
@Controller("userController")
@RequestMapping("/shop/user/")
public class UserController {
	
	@Resource
	private MemberService memberService;
	@Resource
	private CartService cartService;
	@Resource
	private CartSkuService cartSkuService;
	@Resource
	private AreaService areaServcie;
	@Resource
	private ShipAddressService shipAddressServcie;
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String loginPage(HttpServletRequest request) {
		
		//获得上一请求地址
		String retUrl = request.getHeader("Referer");
		request.getSession().setAttribute("redirect_url", retUrl);
		
		return "/all/shop/user/user-login";
	}
	
	/**
	 *  登录
	 * @param request
	 * @param phone
	 * @param password
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(HttpServletRequest request,String phone,String password) throws ServletException, IOException {
		
		Map<String,Object> flag =new HashMap<String,Object>();
		
		//验证手机号不为空
		if (phone ==null ||phone ==" ") {
			flag.put("valid", false);
			return flag ;
		}
		//验证该账号存在
		List<TShopMember> users = memberService.getByparamList("phone", phone);
		if(users.isEmpty() || users.size()!=1) {
			flag.put("valid", false);
			return flag ;
		}
		//最后验证密码是否一致
		TShopMember user =users.get(0);
		String validatePassword =MD5.getIntance().start(user.getCreateDate()+password);
		if(user.getPassword().equals(validatePassword)) {
			//设置登录的IP地址
			user.setLoginIp(IpUtils.getIpAddr(request));
			//设置登录次数+1
			Long loginNums =user.getLoginNums();
			user.setLoginNums(loginNums+1);
			//设置登录时间
			user.setLoginTime(new Date());
			//更新用户
			memberService.updateEntity(user);
			
			//设置要跳转的页面，登录前的页面
			String redirect_url =(String) request.getSession().getAttribute("redirect_url");
			if(redirect_url != null && ! redirect_url.equals(" ") ) {
				flag.put("target", redirect_url);
			}else {
				flag.put("target", request.getContextPath()+ "/shop/index");
			}
			//判断登录情形,如果登录前是商品添加到购物车的情形
			String loginType=(String) request.getSession().getAttribute("loginType");
			if(loginType !=null && loginType.equals("cart-add")) {
				request.getSession().removeAttribute("loginType");
				flag.put("rootUrl",request.getContextPath());
				flag.put("user", user);
			}
			
			//判断登录情形,如果登录前是请求被拦截，则跳转到该拦截请求			
			if(loginType !=null && loginType.equals("common_intercepter")) {
				request.getSession().removeAttribute("loginType");
				String targetUrL = (String) request.getSession().getAttribute("target_url");
				flag.put("target", targetUrL);
				request.getSession().removeAttribute("target_url");
			}
			
			
			request.getSession().setAttribute("user", user);
			
			/**
			 * 购物车商品数量
			 */
			//购物车是否存在，不存在则创建属于该用户的购物车
			List<TShopCart> carts =cartService.getByparamList("memberId", user.getId());
			if (carts.isEmpty()) {
				TShopCart newCart =new TShopCart();
				newCart.setMemberId(user.getId());
				newCart.setCreateDate(new Date());
				cartService.saveAddEntity(newCart);
				carts =cartService.getByparamList("memberId", user.getId());
			}
			TShopCart cart =carts.get(0);						
			List<TShopCartSku> cartSkus =cartSkuService.getByparamList("cartId",cart.getId());
			request.getSession().setAttribute("cartSkusKinds", cartSkus.size());
			
			
			flag.put("valid", true);
			return flag ;							
		}
		
		flag.put("valid", false);
		return flag ;
	}
	
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		
		//清空user
		request.getSession().removeAttribute("user");
		//清空购物车
		request.getSession().removeAttribute("cartSkusKinds");
		
		try {
			response.sendRedirect(request.getContextPath()+"/shop/index");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/all/shop/index/index";
	}
	
	
	/**
	 * 个人中心
	 * @return
	 */
	@RequestMapping(value="center",method=RequestMethod.GET)
	public String center(HttpServletRequest request) {
		
		TShopMember user =(TShopMember) request.getSession().getAttribute("user");

		
		/**
		 * 获取省份资料
		 */
		List<TSystemArea> rootAreas =areaServcie.getRoot();
		request.setAttribute("rootAreas", rootAreas);
        
		/**
		 * 收货地址
		 */
		List<TShopShipAddress> shipAddresses =shipAddressServcie.getWithNameByUserId(user.getId());
		if(!shipAddresses.isEmpty())
		request.setAttribute("shipAddresses", shipAddresses);
		
		return "/all/shop/user/user-center";
	}
	
	
	
	
	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String registerPage() {
		
		return "/all/shop/user/user-register";
	}
	
	
	/**
	 * 注册
	 * @param request
	 * @param userName
	 * @param phone
	 * @param password
	 * @param password2
	 * @param phoneCode
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> register(HttpServletRequest request,String userName,String phone,String password,String password2,String phoneCode) {
		
		Map<String,Object> result =new HashMap<String,Object>();
		
		//验证手机验证码是否超时
		Date getCodeTime = (Date) request.getSession().getAttribute("phoneTime");
		Calendar activeTime =Calendar.getInstance();
		activeTime.add(Calendar.MINUTE, -10);
		if(activeTime.getTimeInMillis()>getCodeTime.getTime()) {
			result.put("flag", false);
			return result;
		}
		
		
		// 手机验证规则
	    String regEx = "^1[0-9]{10}$";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(phone);
	    // 字符串是否与正则表达式相匹配
	    boolean phoneResult = matcher.matches();
		
		//校验用户名、密码是否两次输入一致，手机是否合法，是否没被注册，手机验证码是否一致
		String phoneVilidateCode = (String) request.getSession().getAttribute("phoneCode");
		if(userName ==null || userName ==" " || ! memberService.getByparamList("userName", userName).isEmpty() || 
				password ==null || password == " " || !password.equals(password2) || phoneResult ==false || ! memberService.getByparamList("phone", phone).isEmpty() || !phoneVilidateCode.equals(phoneCode)) {		 
			result.put("flag", false);
		 return result;
		}
		
		
		
		TShopMember newMember =new TShopMember();
		
		Date createDate = new Date();
		
		//设置创建时间
		newMember.setCreateDate(createDate);
		//设置登录时间
		newMember.setLoginTime(createDate);
		//设置登录次数
		newMember.setLoginNums((long)1);;
		//设置用户名
		newMember.setUserName(userName);
		//设置注册真实IP地址
        newMember.setCreateIp(IpUtils.getIpAddr(request));
        //设置登录真实IP地址
        newMember.setLoginIp(IpUtils.getIpAddr(request));
        //设置加密密码(时间+密码形式加密)
        newMember.setPassword(MD5.getIntance().start(createDate+password));
        //设置手机号
        newMember.setPhone(phone);
        //设置用户注册类型:手机
        newMember.setOpenType(2);
        //设置注册积分
        newMember.setIntegrate((long)100);
        //新增到数据库
        Long reply =memberService.saveAddEntity(newMember);
        if (reply ==1) {
        	request.getSession().setAttribute("user", newMember);
        	String indexUrl =request.getContextPath()+ "/shop/index";
        	String centerUrl =request.getContextPath()+ "/shop/user/center";
    		result.put("flag",true);
    		result.put("index", indexUrl);
    		result.put("center", centerUrl);
    		return result  ;
        }
        
        result.put("flag",true);
        return result  ;

				
		
	}
	
	/**
	 * 获取图片验证码
	 */
	@RequestMapping(value="getCodeImg",method=RequestMethod.GET)
	public void validateImg(HttpServletRequest request, HttpServletResponse response) {
		
		// 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        
        
        CreateImageCode imgCode = new CreateImageCode(100,30,5,10);
        request.getSession().setAttribute("imgCode", imgCode.getCode());
        try {
        	imgCode.write(response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取手机验证码
	 */
	@RequestMapping(value="getPhoneCode",method=RequestMethod.GET)
	@ResponseBody
	public boolean getPhoneCode(HttpServletRequest request,String phone) {
		
		//随机产生6位数
		Random random =new Random();
		random.nextInt();
		int num =random.nextInt(899999)+100000;
		String phoneCode =String.valueOf(num);
		System.out.println("发送的手机号码是"+phone);
		System.out.println("生成的验证码是："+phoneCode);
		//发送验证码
		try {
			SendSms.sendSms(phone, phoneCode);
			request.getSession().setAttribute("phoneCode", phoneCode);
			request.getSession().setAttribute("phoneTime", new Date());
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return true;
		
	}
	
	
	/**
	 * 验证用户名是否存在
	 */
	@RequestMapping(value="validateName",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> validateName(String userName) {
		
		Map<String,Object> flag =new HashMap<String,Object>();
		TShopMember validateMember = memberService.getByUniqueName(userName);
		if (validateMember ==null) {
			flag.put("valid", true);
			return flag;
		}else
			flag.put("valid",false);
		return flag;
	}
	
	/**
	 * 验证手机验证码是否正确
	 */
	@RequestMapping(value="validatePhone",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> validatePhone(HttpServletRequest request, String phone) {
		
		Map<String,Object> flag =new HashMap<String,Object>();
		if (phone ==null ||phone.equals(" ")){
			flag.put("valid",false);
			return flag;
		}
		
		List<TShopMember> validateMembers =memberService.getByparamList("phone", phone);
		
		
		if (validateMembers.isEmpty()) {
			flag.put("valid", true);
			return flag;
		}else
			flag.put("valid",false);
		return flag;
	}
	
	/**
	 * 验证图片验证码是否正确
	 */
	@RequestMapping(value="validateImg",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> validateImg(HttpServletRequest request, String validateCode) {
		
		Map<String,Object> flag =new HashMap<String,Object>();
		String imgCode =(String) request.getSession().getAttribute("imgCode");
		
		if (validateCode.equalsIgnoreCase(imgCode)) {
			flag.put("valid", true);
			return flag;
		}else
			flag.put("valid",false);
		return flag;
	}
	
	
	/**
	 * 验证手机验证码是否正确
	 */
	@RequestMapping(value="validatePhoneCode",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> validatePhoneCode(HttpServletRequest request, String phoneCode) {
		
		Map<String,Object> flag =new HashMap<String,Object>();
		String code =(String) request.getSession().getAttribute("phoneCode");
		
		if (phoneCode.equals(code)) {
			flag.put("valid", true);
			return flag;
		}else
			flag.put("valid",false);
		return flag;
	}
	
	
	/**
	 *  替换图片
	 * @param replaceFile
	 * @return
	 */
	@RequestMapping(value="replaceAvatar",method =RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> replacePicture(HttpServletRequest request,MultipartFile replaceFile) {
		
		 Map<String,Object>result =new HashMap<String,Object>();
		 String success ="true";
		 String fault ="false";
		 
		 TShopMember user = (TShopMember) request.getSession().getAttribute("user");
		
		 /**
		  * 原文件地址
		  */
	     String originalPath =PropertiesUtil.getProperty("realFilePath")+ user.getAvatar();
		
		
		if (replaceFile!=null && replaceFile.getOriginalFilename()!=null && replaceFile.getOriginalFilename().trim().length()>0) {  	   	     
			/**
			 * picture上传路径（+时间文件夹）
			 */
			//真实的上传根路径，读取存放在properties文件中的路径
		    String realUploadPath = PropertiesUtil.getProperty("realFilePath");
			 
		    //建立时间文件夹
	        SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");  
	        String datePath = sdf.format(new Date());
	        //最终真实路径
			String realuUploadBrandPath = realUploadPath+"/avatar"+datePath;
			//虚拟路径
		    String  fictitiousUploadPicturePath ="/avatar"+datePath;
           			    	  
           // 上传文件原始名称  
           String originFileName = replaceFile.getOriginalFilename();  
           // 新的文件名称  
           String newFileName = UUID.randomUUID()+originFileName.substring(originFileName.lastIndexOf(".")); 
           
             
           //如果路径文件夹不存在就创建  
           File dir=new File(realuUploadBrandPath);  
           if(!dir.exists()){  
               dir.mkdirs();  
           } 
                       
           // 新文件  
           File newFile = new File(realuUploadBrandPath+File.separator+newFileName);  
             
           // 将内存中的文件写入磁盘  
           try {
        	   replaceFile.transferTo(newFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
             
           // 文件虚拟地址  
           String fictitiousFilePath =  fictitiousUploadPicturePath+newFileName;
           
           //设置图片地址
           user.setAvatar(fictitiousFilePath);
           //更新时间
           user.setUpdateDate(new Date());
           
           /**
            * 更新IP
            */
           
           //存储到数据库
           Long reply = memberService.updateEntity(user);		
           
           if(reply== 1) {    	    
  		        //删除旧文件
  		         File oldFile = new File(originalPath);
  		         if(oldFile.exists()&&oldFile.isFile()) oldFile.delete();
  		         request.getSession().removeAttribute("user");
  		         request.getSession().setAttribute("user", user);
  		         result.put("valid", success);
  		         result.put("newPath", PropertiesUtil.getProperty("fictitiousRoot")+ fictitiousFilePath);
  			     return result;
  		    }
  		    else
  		      //删除新传文件	 
  			  if(newFile.exists()&&newFile.isFile()) newFile.delete();	
              result.put("valid", fault);
  		      return result;
	   }		        
		 result.put("valid", fault);
		 return result;	
	}
	
	/**
	 * 更新用户
	 * @param request
	 * @param userName
	 * @param nickname
	 * @param sex
	 * @param birthday
	 * @param province
	 * @param city
	 * @param county
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(HttpServletRequest request,String userName,String nickname,Integer sex,String birthday,
			String province,String city,String county) {
		
		Map<String,Object> result =new HashMap<String,Object>();
		
		TShopMember user =(TShopMember) request.getSession().getAttribute("user");
		user.setUserName(userName);
		user.setNickname(nickname);
		user.setSex(sex);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date birth;
		try {
			birth = format.parse(birthday);
			user.setBirthday(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		user.setProvince(province);
		user.setCity(city);
		user.setCounty(county);
		
		 //更新时间
        user.setUpdateDate(new Date());
        
        /**
         * 更新IP
         */
		
		Long reply =memberService.updateEntity(user);
		
		if (reply==1) {
			request.getSession().removeAttribute("user");
			request.getSession().setAttribute("user", user);
			result.put("valid", "true");
			return result;
		}else
			result.put("valid","false");
		return result;
	}
	
	
}
