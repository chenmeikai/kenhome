/**
 * 
 */
package com.meikai.controller.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.meikai.shop.entity.TShopCart;
import com.meikai.shop.entity.TShopCartSku;
import com.meikai.shop.entity.TShopMember;
import com.meikai.shop.entity.TShopShipAddress;
import com.meikai.shop.entity.TShopSku;
import com.meikai.shop.entity.TSystemArea;
import com.meikai.shop.service.AreaService;
import com.meikai.shop.service.CartService;
import com.meikai.shop.service.CartSkuService;
import com.meikai.shop.service.ShipAddressService;
import com.meikai.shop.service.SkuService;
import com.meikai.util.PropertiesUtil;

/**
 * 购物车
 * @author meikai
 * @version 2017年11月10日 上午11:24:32
 */
@Controller("cartController")
@RequestMapping("/shop/cart/")
public class CartController {
	
	 @Resource
	 private SkuService skuService;
	 @Resource
	 private CartService cartService;
	 @Resource
	 private CartSkuService cartSkuService;
	 @Resource
	 private ShipAddressService shipAddressServcie;
	 @Resource
	 private AreaService areaService;
	
	 /**
	  * 购物车中心
	  * @param request
	  * @return
	  */
	@RequestMapping(value="center",method=RequestMethod.GET)
	public String center(HttpServletRequest request) {
		
		HttpSession session =request.getSession();
		TShopMember user =(TShopMember) session.getAttribute("user");
		if(user !=null) {
			//购物车商品集合
			List<TShopCartSku> cartSkus =cartSkuService.getWithSkuByUserId(user.getId());
		  request.setAttribute("cartSkus", cartSkus);
		}
		//推荐商品
		List<TShopSku> proomSkus =skuService.getByRandom((long)8);
		request.setAttribute("proomSkus", proomSkus);
		
		
		
		return "/all/shop/good/good-cart";
	}
	
	/**
	 * 添加商品到购物车
	 * @param request
	 * @param skuId
	 * @param nums
	 * @return
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> add(HttpServletRequest request,Long skuId,Integer nums) {
		
		Map<String,Object> result =new HashMap<String,Object>();
		String noUser="noUser";
		String noStocks="noStocks";
		String mistake ="mistake";
		String noSale ="noSale";
		String success="success";
		String systemWrong="systemWrong";
		
		TShopMember user =(TShopMember) request.getSession().getAttribute("user");
		//没有登录则返回
		if(user ==null) {
			request.getSession().setAttribute("loginType","cart-add");
			result.put("flag", noUser);			
			return result ;
		}
		//没有该商品，或者是已下架则返回
		TShopSku cartSku =skuService.getByID(skuId);
		if(cartSku ==null ||cartSku.getSkuStatu() ==1) {
			result.put("flag", noSale);
			return result ;
		}
		//库存不足，则返回
		if(cartSku.getStocks()<=0 ||nums >cartSku.getStocks()) {
			result.put("flag", noStocks);
			result.put("stocks", cartSku.getStocks());
			return result ;
		}
		//非法数量，则返回
		String validateNums =nums.toString();
		boolean flag = Pattern.matches("^[1-9]*[1-9][0-9]*$",validateNums);
		if(!flag) {
			result.put("flag", mistake);
			return result ;
		}
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
		
		Map<String,Object> params =new HashMap<String,Object>();
		params.put("cartID", cart.getId());
		params.put("skuId", skuId);
		List<TShopCartSku> cartSkus =cartSkuService.getByparamsList(params);
		//如果购物车没有该商品则添加进去
		if(cartSkus.isEmpty()) {
			TShopCartSku newCartSku =new TShopCartSku();
			newCartSku.setCartId(cart.getId());
			newCartSku.setSkuId(skuId);
			newCartSku.setNums(nums);
			newCartSku.setCreateDate(new Date());
			cartSkuService.saveAddEntity(newCartSku);			
			result.put("flag", success);
			//更新session当中的购物车商品种类数量
			List<TShopCartSku> cartSkuKinds =cartSkuService.getByparamList("cartId", cart.getId());
			request.getSession().setAttribute("cartSkusKinds", cartSkuKinds.size());
			result.put("cartSkusKinds", cartSkuKinds.size());
			return result ;
		}
		//如果购物车已存在商品，则添加数量
		if(cartSkus.size()==1) {
			TShopCartSku updateCartSku =cartSkus.get(0);
			Integer oldNums =updateCartSku.getNums();
			updateCartSku.setNums(nums+oldNums);
			updateCartSku.setUpdateDate(new Date());
			cartSkuService.updateEntity(updateCartSku);
			result.put("flag", success);
			//更新session当中的购物车商品种类数量
			List<TShopCartSku> cartSkuKinds =cartSkuService.getByparamList("cartId", cart.getId());
			request.getSession().setAttribute("cartSkusKinds", cartSkuKinds.size());
			result.put("cartSkusKinds", cartSkuKinds.size());
			return result ;
		}
		
		result.put("flag", systemWrong);
		return result;
	}
	
	/**
	 * 删除1种购物车商品
	 * @param session
	 * @param cartSkuId
	 * @return
	 */
	@RequestMapping(value="deleteSingle/{cartSkuId}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteSingle(HttpSession session,@PathVariable("cartSkuId")Long cartSkuId){
		
		Map<String,Object> result =new HashMap<String,Object>();
		//删除成功
		String success ="true";
		//删除失败
		String fall ="false";
		
		
		TShopCartSku cartSku =cartSkuService.getByID(cartSkuId);
		TShopMember user = (TShopMember) session.getAttribute("user");
		TShopCart cart =cartService.getByID(cartSku.getCartId());
		if(cart.getMemberId()!= user.getId()) {
			result.put("valid", fall);
			return result;
		}
		Long replay = cartSkuService.delete(cartSku.getId());
		if (replay !=1) {
			result.put("valid", fall);
			return result;
		}
		//更新session当中的购物车商品种类数量
		List<TShopCartSku> cartSkuKinds =cartSkuService.getByparamList("cartId", cart.getId());
		session.setAttribute("cartSkusKinds", cartSkuKinds.size());
	
		result.put("valid", success);
		return result;
	}
	
	/**
	 * 删除1种购物车商品
	 * @param session
	 * @param cartSkuId
	 * @return
	 */
	@RequestMapping(value="update/{cartSkuId}/{nums}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteSingle(HttpSession session,@PathVariable("cartSkuId")Long cartSkuId,@PathVariable("nums")Integer nums){
		
		Map<String,Object> result =new HashMap<String,Object>();
		//更新成功
		String success ="true";
		//更新失败
		String fall ="false";
		
		
		TShopCartSku cartSku =cartSkuService.getWithSkuById(cartSkuId);
		TShopMember user = (TShopMember) session.getAttribute("user");		
		if(cartSku.getUserId()!= user.getId()) {
			result.put("valid", fall);
			return result;
		}
		//如果数量大于库存，则数量为库存值
		if(nums >cartSku.getSku().getStocks()) 			
		nums =cartSku.getSku().getStocks().intValue();
		cartSku.setNums(nums);
		
		//将nums返回
		result.put("nums", nums);
		
		Long replay = cartSkuService.updateEntity(cartSku);
		if (replay !=1) {
			result.put("valid", fall);
			return result;
		}
		result.put("valid", success);
		return result;
	}
	
	/**
	 * 购买
	 * @param request
	 * @param session
	 * @param cartSkuIds
	 * @param model
	 * @return
	 */
	@RequestMapping(value="buy",method=RequestMethod.GET)
	public String buy(HttpServletRequest request, HttpSession session,Long[] cartSkuIds,ModelAndView model){
		
		if(cartSkuIds.length ==0) {
			return null ;
		}
		TShopMember user =(TShopMember) session.getAttribute("user");
		
		//总计价钱
		BigDecimal allSum = new  BigDecimal(0) ;
		
		//快递费 
		Double logisticPrice=Double.parseDouble(PropertiesUtil.getProperty("logistcisPrice"));
		
		//免邮费最低消费
		BigDecimal minOrderPrice =new BigDecimal(PropertiesUtil.getProperty("minOrderPrice"));
		
		//包含快递费用实付金额
		BigDecimal realyPrice =new  BigDecimal(0) ;
		
		List<TShopCartSku> cartSkus = new ArrayList<TShopCartSku>();
		for(Long cartSkuId :cartSkuIds) {
			TShopCartSku cartSku =cartSkuService.getWithSkuById(cartSkuId);
			if(cartSku.getUserId() != user.getId()) {
				return null;
			}
			//确保商品没有下架，下架则不计这商品
			if(cartSku.getSku().getSkuStatu()==1)break;			
			//判断库存，确保数量不得大于库存量
			if(cartSku.getNums()>cartSku.getSku().getStocks()) cartSku.setNums(cartSku.getSku().getStocks().intValue());          
			//商品小计金额
			BigDecimal nums =new  BigDecimal(cartSku.getNums());			
			BigDecimal smallSum = cartSku.getSku().getSalePrice().multiply(nums);
			//累计
			allSum=allSum.add(smallSum);
			cartSkus.add(cartSku);
		}
		//如果总计大于最低订单金额，快递费为0
		if (allSum.compareTo(minOrderPrice) !=-1) {
			logisticPrice =(double) 0;
		}
		//将快递费转换为BigDecemal格式
		BigDecimal logisticPrice2 =new BigDecimal(logisticPrice);
		//实付金额
		realyPrice=realyPrice.add(allSum).add(logisticPrice2);
		
		
		request.setAttribute("allSum", allSum);
		request.setAttribute("logisticPrice2", logisticPrice2);
		request.setAttribute("realyPrice", realyPrice);				
		request.setAttribute("cartSkus", cartSkus);
		
		/**
		 * 收货地址
		 */
		List<TShopShipAddress> shipAddresses =shipAddressServcie.getWithNameByUserId(user.getId());
		if(!shipAddresses.isEmpty())
		request.setAttribute("shipAddresses", shipAddresses);
		
		/**
		 * 获取省份资料
		 */
		List<TSystemArea> rootAreas =areaService.getRoot();
		request.setAttribute("rootAreas", rootAreas);

	
		return "/all/shop/good/good-cartBuy";
	}
	
	
    
}
