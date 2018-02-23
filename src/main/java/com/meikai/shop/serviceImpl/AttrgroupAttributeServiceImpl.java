/**
 * 
 */
package com.meikai.shop.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopAttrgroupAttributeDao;
import com.meikai.shop.entity.TShopAttrgroupAttribute;
import com.meikai.shop.service.AttrgroupAttributeService;

/**
 * 属性组-属性关联
 * @author meikai
 * @version 2017年10月18日 下午18:31:37
 */

@Service("attrgroupAttributeServiceImpl")
public class AttrgroupAttributeServiceImpl extends BaseServiceImpl<TShopAttrgroupAttribute, Long> implements AttrgroupAttributeService {

	
	@Autowired
	private TShopAttrgroupAttributeDao attrgroupAttributeDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(attrgroupAttributeDao);
	}

	
	
}
