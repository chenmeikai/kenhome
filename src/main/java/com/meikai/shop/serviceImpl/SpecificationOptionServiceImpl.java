/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopSpecificationOptionDao;
import com.meikai.shop.entity.TShopSpecificationOption;
import com.meikai.shop.service.SpecificationOptionService;

/**
 * 规格值
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("specificationOptionServiceImpl")
public class SpecificationOptionServiceImpl extends BaseServiceImpl<TShopSpecificationOption, Long> implements SpecificationOptionService {

	
	@Autowired
	private TShopSpecificationOptionDao specificationOptionDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(specificationOptionDao);
	}
	
	
}
