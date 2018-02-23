/**
 * 
 */
package com.meikai.shop.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopAttrgroupDao;
import com.meikai.shop.entity.TShopAttrgroup;
import com.meikai.shop.service.AttrgroupService;

/**
 * 属性组-属性关联
 * @author meikai
 * @version 2017年10月18日 下午18:31:37
 */

@Service("attrgroupServiceImpl")
public class AttrgroupServiceImpl extends BaseServiceImpl<TShopAttrgroup, Long> implements AttrgroupService {

	
	@Autowired
	private TShopAttrgroupDao attrgroupDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(attrgroupDao);
	}

	
	
}
