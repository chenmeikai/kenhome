/**
 * 
 */
package com.meikai.controller.shop;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TShopAttribute;
import com.meikai.shop.entity.TShopAttributeOption;
import com.meikai.shop.entity.TShopCartSku;
import com.meikai.shop.entity.TShopCategory;
import com.meikai.shop.entity.TShopMember;
import com.meikai.shop.entity.TShopOrder;
import com.meikai.shop.entity.TShopOrderItem;
import com.meikai.shop.entity.TShopShipAddress;
import com.meikai.shop.entity.TShopSku;
import com.meikai.shop.service.AreaService;
import com.meikai.shop.service.CartSkuService;
import com.meikai.shop.service.CategoryService;
import com.meikai.shop.service.OrderItemService;
import com.meikai.shop.service.OrderService;
import com.meikai.shop.service.ShipAddressService;
import com.meikai.shop.service.SkuService;
import com.meikai.util.PropertiesUtil;

/**
 * 订单中心
 * @author meikai
 * @version 2017年11月10日 上午11:24:32
 */
@Controller("orderController")
@RequestMapping("/shop/order/")
public class OrderController {
	
	 @Resource
	 private SkuService skuService;
	 @Resource
	 private CartSkuService cartSkuService;
	 @Resource
	 private ShipAddressService shipAddressService;
	 @Resource
	 private AreaService areaService;
	 @Resource
	 private CategoryService categoryService;
	 @Resource
	 private OrderService orderService;
	 @Resource
	 private OrderItemService orderItemService;
	
	 /**
	  * 订单中心
	  * @param request
	  * @return
	  */
	@RequestMapping(value="center",method=RequestMethod.GET)
	public String center(HttpServletRequest request,Integer orderStatu,Integer currentPage) {
		
		TShopMember user =(TShopMember) request.getSession().getAttribute("user");
		
		Integer pageSize =5;
		
		
		if(currentPage ==null ||currentPage ==0) currentPage =1;
				
		EntityPage<TShopOrder> pageInfo =orderService.getByStatuAndUserId(orderStatu, user.getId(), currentPage, pageSize);
		
		//回传参数
		request.setAttribute("orderStatu", orderStatu);
		request.setAttribute("currentPage", currentPage);
		
		
		request.setAttribute("pageInfo", pageInfo);
		
		
				
		return "/all/shop/order/order-center";
	}
	
	
	/**
	 * 确认订单（购物车）
	 * @param request
	 * @param session
	 * @param cartSkuIds
	 * @param shipAddressId
	 * @return
	 */
	@RequestMapping(value="cartAdd",method=RequestMethod.POST)
	public String cartAdd(HttpServletRequest request, HttpSession session,Long[] cartSkuIds,Long shipAddressId){
		
		if(cartSkuIds.length ==0) {
			return null ;
		}
		
		TShopMember user =(TShopMember) session.getAttribute("user");
		
		//新建订单对象
		TShopOrder newOrder =new TShopOrder();
		//产生订单号
		Date createDate =new Date();
		SimpleDateFormat fm =new SimpleDateFormat("yyyyMMddHHmmss");
		String createDate2 =fm.format(createDate);
		Random random =new Random();
		Integer ranNum =random.nextInt(899999)+100000;
		String orderNum =ranNum.toString();
		//订单号：随机数加时间
		String orderNo =createDate2+orderNum;
		//创建时间
		newOrder.setCreateDate(new Date());
		//订单号
		newOrder.setOrderNo(orderNo);
		
		/**
		 * 先将订单存储到数据库
		 */
		Long orderRepuly =orderService.saveAddEntity(newOrder);
		if(orderRepuly !=1) return null ;
		
		TShopOrder updateOrder =orderService.getByUniqueCode(orderNo);
		
				
		//总计价钱
		BigDecimal allSum = new  BigDecimal(0) ;
		
		//快递费 
		Double logisticPrice=Double.parseDouble(PropertiesUtil.getProperty("logistcisPrice"));
		
		//免邮费最低消费
		BigDecimal minOrderPrice =new BigDecimal(PropertiesUtil.getProperty("minOrderPrice"));
		
		//包含快递费用实付金额
		BigDecimal realyPrice =new  BigDecimal(0) ;
		
		//订单项目集合
		List<TShopOrderItem> orderItems = new ArrayList<TShopOrderItem>();
		for(Long cartSkuId :cartSkuIds) {
			TShopCartSku cartSku =cartSkuService.getWithSkuById(cartSkuId);
			if(cartSku.getUserId() != user.getId()) {
				return null;
			}
			//新建订单项目
			TShopOrderItem orderItem =new TShopOrderItem();
			
			//确保商品没有下架，下架则返回
			if(cartSku.getSku().getSkuStatu()==1) return null;			
			//判断库存，确保数量不得大于库存量
			if(cartSku.getNums()>cartSku.getSku().getStocks()) return null;          
			//商品小计金额
			BigDecimal nums =new  BigDecimal(cartSku.getNums());			
			BigDecimal smallSum = cartSku.getSku().getSalePrice().multiply(nums);
			
			//商品
			TShopSku sku= skuService.getPlusById(cartSku.getSkuId());
			
			//项目编号
			Random random2 =new Random();
			Integer ranNum2 =random2.nextInt(899999)+100000;
			String itemNum =ranNum2.toString();
			//项目号：随机数加时间
			String itemNo =createDate2+itemNum;			
			//设置项目编号
			orderItem.setItemNo(itemNo);
			//设置订单ID
			orderItem.setOrderId(updateOrder.getId());
			//设置订单编号
			orderItem.setOrderNo(orderNo);
			//设置商品ID
			orderItem.setSkuId(sku.getId());
			//设置商品编号
			orderItem.setSkuNo(sku.getSkuNo());
			//设置商品名
			orderItem.setSkuName(sku.getSkuName());
			//设置商品图片
			orderItem.setSkuPicture(sku.getPicture());
			//设置商品原价
			orderItem.setSkuOriginalPrice(sku.getOriginalPrice());
			//设置商品促销价
			orderItem.setSkuSalePrice(sku.getSalePrice());
			/**
			 * 设置分类
			 */			
			TShopCategory category =categoryService.getWithParentById(cartSku.getSku().getCategoryId());
			String rootCategoryName =category.getParentCategory().getParentCategory().getCategoryName();
			String secondCategoryName =category.getParentCategory().getCategoryName();
			String thirdCategoryName =category.getCategoryName();
			String categoryName=rootCategoryName+","+secondCategoryName+","+thirdCategoryName;
			orderItem.setSkuType(categoryName);
			/**
			 * 设置属性
			 */
			 StringBuffer sbuffer =new StringBuffer();
			for(TShopAttribute attribute :sku.getAttributes()) {
				StringBuffer ab = new StringBuffer();
				ab.append(attribute.getAttributeName());
				ab.append(":");
				for (TShopAttributeOption option :attribute.getOptions() ) {
					ab.append(" ");
					ab.append(option.getOptionName());	
					
				}
				String attributeOptionName= ab.toString();
				sbuffer.append(attributeOptionName);
				sbuffer.append(";");
			}
			String attributeOptionNames =sbuffer.toString();
			orderItem.setSkuAttribute(attributeOptionNames);
			//设置折率
			orderItem.setDiscountRate(sku.getDiscountRate());
			//设置折扣金额
			orderItem.setDiscountAmount(sku.getDiscountAmount());
			//设置商品数量
			orderItem.setSkuNum(cartSku.getNums());
			//设置小计金额
			orderItem.setSubtotalFee(smallSum);
			/**
			 * 添加到数据库
			 */
			Long itemReply =orderItemService.saveAddEntity(orderItem);
			if(itemReply !=1) {
				orderItemService.deleteByOrderId(updateOrder.getId());
			}			
			//累计
			allSum=allSum.add(smallSum);
			orderItems.add(orderItem);
		}
		
		
		//如果总计大于最低订单金额，快递费为0
		if (allSum.compareTo(minOrderPrice) !=-1) {
			logisticPrice =(double) 0;
		}
				
		//将快递费转换为BigDecemal格式
		BigDecimal logisticPrice2 =new BigDecimal(logisticPrice);
		
			
		//实付金额
		realyPrice=realyPrice.add(allSum).add(logisticPrice2);
		
		//设置订单商品种类数目
		updateOrder.setSkuCount(orderItems.size());
				
		//设置订单快递费
		updateOrder.setLogisticFee(logisticPrice2);	
		
		//设置商品总金额
		updateOrder.setGoodAmountTotal(allSum);
		
		//设置订单实付金额
		updateOrder.setOrderAmountTotal(realyPrice);
		
		/**
		 * 收货地址
		 */
		TShopShipAddress shipAddress =shipAddressService.getWithNameById(shipAddressId);
		
		
		//设置收货省份
		updateOrder.setShipProvince(shipAddress.getProvince());
		//设置收货省份
		updateOrder.setShipCity(shipAddress.getCity());
		//设置收货省份
		updateOrder.setShipCounty(shipAddress.getCounty());
		//设置详细收货地址
		updateOrder.setShipAddress(shipAddress.getAddress());
		//设置用户ID
		updateOrder.setMemberId(user.getId());
		
		//存储到数据库
		orderService.updateEntity(updateOrder);
		
		/**
		 * 将对于的购物车商品移除
		 */
		List<Long> deleteIds = new ArrayList<Long>();
		for(Long cartSkuId :cartSkuIds) {
			deleteIds.add(cartSkuId);
		}
		cartSkuService.deleteSome(deleteIds);
		
		/**
		 * 更新session
		 */
		List<TShopCartSku> cartSkus =cartSkuService.getWithSkuByUserId(user.getId());
		request.getSession().removeAttribute("cartSkusKinds");
		request.getSession().setAttribute("cartSkusKinds", cartSkus.size());
		
		request.setAttribute("payOrder", updateOrder);
					
		return "/all/shop/order/order-pay";
	}
	
	
	
	/**
	 * 确认订单（立即购买）
	 * @param request
	 * @param session
	 * @param cartSkuIds
	 * @param shipAddressId
	 * @return
	 */
	@RequestMapping(value="nowAdd",method=RequestMethod.POST)
	public String nowAdd(HttpServletRequest request, HttpSession session,Long skuId,Integer skuNums, Long shipAddressId){
		
		if(skuId ==null ||skuNums ==null) {
			return null ;
		}
		
		TShopMember user =(TShopMember) session.getAttribute("user");
		
		//新建订单对象
		TShopOrder newOrder =new TShopOrder();
		//产生订单号
		Date createDate =new Date();
		SimpleDateFormat fm =new SimpleDateFormat("yyyyMMddHHmmss");
		String createDate2 =fm.format(createDate);
		Random random =new Random();
		Integer ranNum =random.nextInt(899999)+100000;
		String orderNum =ranNum.toString();
		//订单号：随机数加时间
		String orderNo =createDate2+orderNum;
		//创建时间
		newOrder.setCreateDate(new Date());
		//订单号
		newOrder.setOrderNo(orderNo);
		
		/**
		 * 先将订单存储到数据库
		 */
		Long orderRepuly =orderService.saveAddEntity(newOrder);
		if(orderRepuly !=1) return null ;
		
		TShopOrder updateOrder =orderService.getByUniqueCode(orderNo);
		
				
		//总计价钱
		BigDecimal allSum = new  BigDecimal(0) ;
		
		//快递费 
		Double logisticPrice=Double.parseDouble(PropertiesUtil.getProperty("logistcisPrice"));
		
		//免邮费最低消费
		BigDecimal minOrderPrice =new BigDecimal(PropertiesUtil.getProperty("minOrderPrice"));
		
		//包含快递费用实付金额
		BigDecimal realyPrice =new  BigDecimal(0) ;
		
		//获得该商品
		TShopSku sku = skuService.getPlusById(skuId);
			
		//新建订单项目
		TShopOrderItem orderItem =new TShopOrderItem();
		
		//确保商品没有下架，下架则返回
		if(sku.getSkuStatu()==1) return null;			
		//判断库存，确保数量不得大于库存量
		if(skuNums>sku.getStocks()) return null; 
		
		//商品小计金额
		BigDecimal nums =new  BigDecimal(skuNums);			
		allSum = sku.getSalePrice().multiply(nums);
				
		//项目编号
		Random random2 =new Random();
		Integer ranNum2 =random2.nextInt(899999)+100000;
		String itemNum =ranNum2.toString();
		//项目号：随机数加时间
		String itemNo =createDate2+itemNum;			
		//设置项目编号
		orderItem.setItemNo(itemNo);
		//设置订单ID
		orderItem.setOrderId(updateOrder.getId());
		//设置订单编号
		orderItem.setOrderNo(orderNo);
		//设置商品ID
		orderItem.setSkuId(sku.getId());
		//设置商品编号
		orderItem.setSkuNo(sku.getSkuNo());
		//设置商品名
		orderItem.setSkuName(sku.getSkuName());
		//设置商品图片
		orderItem.setSkuPicture(sku.getPicture());
		//设置商品原价
		orderItem.setSkuOriginalPrice(sku.getOriginalPrice());
		//设置商品促销价
		orderItem.setSkuSalePrice(sku.getSalePrice());
		/**
		 * 设置分类
		 */			
		TShopCategory category =categoryService.getWithParentById(sku.getCategoryId());
		String rootCategoryName =category.getParentCategory().getParentCategory().getCategoryName();
		String secondCategoryName =category.getParentCategory().getCategoryName();
		String thirdCategoryName =category.getCategoryName();
		String categoryName=rootCategoryName+","+secondCategoryName+","+thirdCategoryName;
		orderItem.setSkuType(categoryName);
		/**
		 * 设置属性
		 */
		 StringBuffer sbuffer =new StringBuffer();
		for(TShopAttribute attribute :sku.getAttributes()) {
			StringBuffer ab = new StringBuffer();
			ab.append(attribute.getAttributeName());
			ab.append(":");
			for (TShopAttributeOption option :attribute.getOptions() ) {
				ab.append(" ");
				ab.append(option.getOptionName());	
				
			}
			String attributeOptionName= ab.toString();
			sbuffer.append(attributeOptionName);
			sbuffer.append(";");
		}
		String attributeOptionNames =sbuffer.toString();
		orderItem.setSkuAttribute(attributeOptionNames);
		//设置折率
		orderItem.setDiscountRate(sku.getDiscountRate());
		//设置折扣金额
		orderItem.setDiscountAmount(sku.getDiscountAmount());
		//设置商品数量
		orderItem.setSkuNum(skuNums);
		//设置小计金额
		orderItem.setSubtotalFee(allSum);
		/**
		 * 添加到数据库
		 */
		Long itemReply =orderItemService.saveAddEntity(orderItem);
		if(itemReply !=1) {
			orderItemService.deleteByOrderId(updateOrder.getId());
		}			
								
		//如果总计大于最低订单金额，快递费为0
		if (allSum.compareTo(minOrderPrice) !=-1) {
			logisticPrice =(double) 0;
		}
				
		//将快递费转换为BigDecemal格式
		BigDecimal logisticPrice2 =new BigDecimal(logisticPrice);
		
			
		//实付金额
		realyPrice=realyPrice.add(allSum).add(logisticPrice2);
		
		//设置订单商品种类数目
		updateOrder.setSkuCount(1);
				
		//设置订单快递费
		updateOrder.setLogisticFee(logisticPrice2);	
		
		//设置商品总金额
		updateOrder.setGoodAmountTotal(allSum);
		
		//设置订单实付金额
		updateOrder.setOrderAmountTotal(realyPrice);
		
		/**
		 * 收货地址
		 */
		TShopShipAddress shipAddress =shipAddressService.getWithNameById(shipAddressId);
		
		
		//设置收货省份
		updateOrder.setShipProvince(shipAddress.getProvince());
		//设置收货省份
		updateOrder.setShipCity(shipAddress.getCity());
		//设置收货省份
		updateOrder.setShipCounty(shipAddress.getCounty());
		//设置详细收货地址
		updateOrder.setShipAddress(shipAddress.getAddress());
		//设置用户ID
		updateOrder.setMemberId(user.getId());
		
		//存储到数据库
		orderService.updateEntity(updateOrder);
		
		
		request.setAttribute("payOrder", updateOrder);
					
		return "/all/shop/order/order-pay";
	}
	
	
	
	
	@RequestMapping(value="payPage",method=RequestMethod.GET)
	public String payPage(HttpServletRequest request,Long orderId){
		
		TShopOrder payOrder =orderService.getByID(orderId);
		
		request.setAttribute("payOrder", payOrder);
		
		
		return "/all/shop/order/order-pay";
	
	}
	
	/**
	 * 支付订单
	 * 
	 */
	@RequestMapping(value="pay",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> pay(HttpServletRequest request,Long orderId,String password){
		
		 Map<String,Object> result =new HashMap<String,Object>();
		
		
		
		/**
		 * 密令错误则返回
		 */
		if(password ==null ||!password.equals("chenmeikai123")) {
			result.put("valid", "password");
			return result;
		};
		
		TShopOrder updateOrder =orderService.getByID(orderId);
		//更新时间
		Date newDate =new Date();
		updateOrder.setUpdateDate(newDate);
		//支付时间
		updateOrder.setPayTime(newDate);
		//订单状态
		updateOrder.setOrderStatu(2);
		//更新到数据库
		Long reply = orderService.updateEntity(updateOrder);
		if(reply != 1) {
			result.put("valid", "false");
			return result;
		}
		
        result.put("valid", "true");
        String redirect =request.getContextPath()+"/shop/order/center";
		result.put("redirect", redirect);
		return result;		
	}
	
	/**
	 * 取消订单
	 */
	@RequestMapping(value="cancel/{orderId}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> cancel(HttpServletRequest request,@PathVariable("orderId")Long orderId){
		
	    Map<String,Object> result =new HashMap<String,Object>();
	    
	    TShopMember user =(TShopMember) request.getSession().getAttribute("user");
					
		TShopOrder updateOrder =orderService.getByID(orderId);
		
		if(user.getId() != updateOrder.getMemberId()) {
			result.put("valid", "illegle");
			return result;
		}
		
		/**
		 * 根据订单状态，做相关的取消动作
		 */		
		//更新时间
		Date newDate =new Date();
		updateOrder.setUpdateDate(newDate);
		//获得订单状态		
		Integer statu =updateOrder.getOrderStatu();
		
		/**
		 * 如果订单处于未付款状态下取消
		 */
		if(statu ==1) {
			updateOrder.setOrderStatu(9);
			orderService.updateEntity(updateOrder);
			result.put("valid", "true1");
			return result;
		}
		/**
		 * 如果订单处于已付款，未发货状态下取消，要将金额退返原账号，并返回结果，这里跳过金额退返过程
		 */
		if(statu ==2) {
			updateOrder.setOrderStatu(9);
			orderService.updateEntity(updateOrder);
			result.put("valid", "true2");
			return result;
		}
		
		/**
		 * 其它情况都返回错误
		 */
		result.put("valid", "false");
		return result;		
	}
	
	
	/**
	 * 删除订单
	 */
	@RequestMapping(value="delete/{orderId}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request,@PathVariable("orderId")Long orderId){
		
	    Map<String,Object> result =new HashMap<String,Object>();
	    
	    TShopMember user =(TShopMember) request.getSession().getAttribute("user");
					
		TShopOrder deleteOrder =orderService.getByID(orderId);
		
		if(user.getId() != deleteOrder.getMemberId()) {
			result.put("valid", "illegle");
			return result;
		}
		

		/**
		 * 判断订单是否是已经取消状态
		 */
		if( deleteOrder.getOrderStatu() !=9) {
			result.put("valid", "false");
			return result;
		}
		
		Long reply = orderService.delete(deleteOrder.getId());
		if (reply ==1) {
			result.put("valid", "true");
			return result;
		}
		result.put("valid", "false");
		return result;		
	}
	
	
    
}
