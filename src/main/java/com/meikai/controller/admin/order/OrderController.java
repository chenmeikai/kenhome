/**
 * 
 */
package com.meikai.controller.admin.order;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TShopAttribute;
import com.meikai.shop.entity.TShopAttributeOption;
import com.meikai.shop.entity.TShopBrand;
import com.meikai.shop.entity.TShopCategory;
import com.meikai.shop.entity.TShopCategoryAttribute;
import com.meikai.shop.entity.TShopCategoryBrand;
import com.meikai.shop.entity.TShopOrder;
import com.meikai.shop.entity.TShopSku;
import com.meikai.shop.entity.TShopSkuAttributeOption;
import com.meikai.shop.entity.TShopSkuPicture;
import com.meikai.shop.entity.TShopSpu;
import com.meikai.shop.entity.TShopSpuAttributeOption;
import com.meikai.shop.entity.TShopSpuPicture;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.exportExcel.ExcelSpu;
import com.meikai.shop.service.AttributeService;
import com.meikai.shop.service.BrandService;
import com.meikai.shop.service.CategoryAttributeService;
import com.meikai.shop.service.CategoryBrandService;
import com.meikai.shop.service.CategoryService;
import com.meikai.shop.service.OrderService;
import com.meikai.shop.service.SkuAttributeOptionService;
import com.meikai.shop.service.SkuPictureService;
import com.meikai.shop.service.SkuService;
import com.meikai.shop.service.SpuAttributeOptionService;
import com.meikai.shop.service.SpuPictureService;
import com.meikai.shop.service.SpuService;
import com.meikai.util.CommonParams;
import com.meikai.util.DateUtil;
import com.meikai.util.ExcelView;
import com.meikai.util.ParameterUtils;
import com.meikai.util.PropertiesUtil;

/**
 * 订单管理
 * @author meikai
 * @version 2017年10月21日 上午11:22:27
 */
@Controller("orderAdminController")
@RequestMapping("/admin/order/order/")
public class OrderController {
	
	 @Resource
	 private OrderService orderService;
	
	/**
	 * 订单中心
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="main",method =RequestMethod.GET)
	public String main(HttpServletRequest request) {
		
        
		return "all/admin/order/order/order-list";
		
	}
	
	@RequestMapping(value="getList",method =RequestMethod.GET)
	public String getList(HttpServletRequest request,Integer currentPage) {
		
        Integer pageSize = 10;
		
		if(currentPage==null ||currentPage <=0)currentPage =1;
				
		Map<String,Object> params =ParameterUtils.getParametersMap(request);
		
		EntityPage<TShopOrder> pageInfo =orderService.getByParamesAndPage(params, currentPage, pageSize);
		
		request.setAttribute("params", params);
		
		request.setAttribute("pageInfo", pageInfo);
		return "all/admin/order/order/load";
		
	}
	

}