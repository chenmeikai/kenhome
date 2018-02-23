/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopSpecificationDao;
import com.meikai.shop.entity.TShopSpecification;
import com.meikai.shop.service.SpecificationService;

/**
 * 规格
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("specificationServiceImpl")
public class SpecificationServiceImpl extends BaseServiceImpl<TShopSpecification, Long> implements SpecificationService {

	
	@Autowired
	private TShopSpecificationDao specificationDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(specificationDao);
	}
	
	
}
