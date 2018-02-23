/**
 * 
 */
package com.meikai.controller.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TShopCartSku;
import com.meikai.shop.entity.TShopCategory;
import com.meikai.shop.entity.TShopMember;
import com.meikai.shop.entity.TShopShipAddress;
import com.meikai.shop.entity.TShopSku;
import com.meikai.shop.entity.TShopSkuAttributeOption;
import com.meikai.shop.entity.TShopSkuPicture;
import com.meikai.shop.entity.TShopSpu;
import com.meikai.shop.entity.TShopSpuPicture;
import com.meikai.shop.entity.TSystemArea;
import com.meikai.shop.service.AreaService;
import com.meikai.shop.service.CategoryService;
import com.meikai.shop.service.ShipAddressService;
import com.meikai.shop.service.SkuAttributeOptionService;
import com.meikai.shop.service.SkuPictureService;
import com.meikai.shop.service.SkuService;
import com.meikai.shop.service.SpuPictureService;
import com.meikai.shop.service.SpuService;
import com.meikai.util.PropertiesUtil;

/**
 * 商品管理器
 * @author meikai
 * @version 2017年11月7日 下午3:09:00
 */
@Controller("goodController")
@RequestMapping("/shop/good/")
public class GoodController {
	
	@Resource
	private CategoryService categoryService;
	
    @Resource
    private SkuService skuService;
    @Resource
    private SkuPictureService skuPictureService;
    @Resource
    private SpuService spuService;
    @Resource
    private SpuPictureService spuPictureService;
    @Resource
    private SkuAttributeOptionService skuOptionService;
    @Resource
    private ShipAddressService shipAddressServcie;
    @Resource
    private AreaService areaService;
    /**
     * 根据商品ID获得该商品
     * @param request
     * @param skuId
     * @return
     */
	@RequestMapping(value="view/{skuId}",method=RequestMethod.GET)
	public String view(HttpServletRequest request,@PathVariable("skuId")Long skuId) {
		
		/**
		 * 分类查看
		 */
		List<TShopCategory> rootCategorys = categoryService.getByparamList("parentId", 0);
		request.setAttribute("rootCategorys", rootCategorys);
		
		
						
		/**
		 * 商品
		 */
		TShopSku viewSku = skuService.getPlusById(skuId);
		request.setAttribute("viewSku", viewSku);
		
		

		
		if(viewSku != null) {
			
			/**
			 * 商品关键属性值ID集合
			 */
			List<Long>skuOptionIds= new ArrayList<Long>();
			List<TShopSkuAttributeOption> skuOptions =skuOptionService.getBySkuId(viewSku.getId());
			for(TShopSkuAttributeOption skuOption :skuOptions) {
				skuOptionIds.add(skuOption.getOptionId());
			}
			request.setAttribute("skuOptionIds", skuOptionIds);
			
			
			/**
			 * 商品图片
			 */
			List<TShopSkuPicture> skuPictures= skuPictureService.getBySkuId(skuId);
			if(!skuPictures.isEmpty())request.setAttribute("skuPictures", skuPictures);
			

			/**
			 * SPU
			 */
			TShopSpu viewSpu=spuService.getSpuAttrOptionsById(viewSku.getSpuId());
			request.setAttribute("viewSpu", viewSpu);
			
			/**
			 * SPU图片
			 */
			if(viewSpu !=null) {
				List<TShopSpuPicture> spuPictures =spuPictureService.getBySpuId(viewSpu.getId());
				request.setAttribute("spuPictures", spuPictures);
			}
			
			/**
			 * 推荐商品
			 */
			Map<String,Object> params =new HashMap<String,Object>();
			params.put("categoryId", viewSku.getCategoryId());
			params.put("skuSort", "SALE_AMOUNT");
			params.put("direction", "DESC");
			Integer currentPage =1;
			Integer pageSize =10;
			EntityPage<TShopSku> proomSkusPage =skuService.getByParamesAndPage(params, currentPage, pageSize);
			List<TShopSku> proomSkus =proomSkusPage.getList();
			request.setAttribute("proomSkus",proomSkus);
		}
		
		
		return "/all/shop/good/good-view";
	}
	
	
	/**
	 * 选择SKU
	 * @param optionIds
	 * @param spuId
	 * @return
	 */
	@RequestMapping(value="select",method=RequestMethod.POST)
	@ResponseBody
	public  Map<String,Object> select(@RequestParam("optionIds[]")Long[]optionIds,@RequestParam("spuId") Long spuId) {
	   Map<String,Object>data =new HashMap<String,Object>();
	   List<TShopSku> targetSkus =skuService.getByspuIdAndoptions(optionIds, spuId);
	   //如果唯一，则返回sku及相关图片
	   if (targetSkus.size()==1) {
		   TShopSku targetSku =targetSkus.get(0);
		   List<TShopSkuPicture> skuPictures =skuPictureService.getBySkuId(targetSku.getId());	
		   data.put("flag", true);
		   data.put("targetSku", targetSku);
		   data.put("skuPictures", skuPictures);
		   return data;
	   }else if(targetSkus.isEmpty()) {
		   data.put("flag", null);
		   return data;
	   }
	    data.put("flag", false);
		return data;		
	}
	
	
	/**
	 * 确认购买
	 * @param request
	 * @param session
	 * @param cartSkuIds
	 * @param model
	 * @return
	 */
	@RequestMapping(value="buy",method=RequestMethod.GET)
	public String buy(HttpServletRequest request, HttpSession session,Long skuId,Long skuNums){
		
		if(skuId ==null) {
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
		
		
		TShopSku sku =skuService.getPlusById(skuId);
		
		//确保商品没有下架，下架则不计这商品
		if(sku.getSkuStatu()==1) return null;			
		//判断库存，确保数量不得大于库存量
		if(skuNums>sku.getStocks()) return null;     
		
		//商品总计金额
		BigDecimal nums =new  BigDecimal(skuNums);			
	    allSum = sku.getSalePrice().multiply(nums);
		
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
		request.setAttribute("sku", sku);
		request.setAttribute("skuNums", skuNums);
		
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

	
		return "/all/shop/good/good-nowBuy";
	}

}
