/**
 * 
 */
package com.meikai.shop.serviceImpl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopSpuAttributeDao;
import com.meikai.shop.entity.TShopSpuAttribute;
import com.meikai.shop.service.SpuAttributeService;


/**
 * 商品-属性关联
 * @author meikai
 * @version 2017年10月24日 上午10:29:37
 */

@Service("spuAttributeServiceImpl")
public class SpuAttributeServiceImpl extends BaseServiceImpl<TShopSpuAttribute, Long> implements SpuAttributeService {

	
	@Autowired
	private TShopSpuAttributeDao spuAttributeDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(spuAttributeDao);
	}
    
	
	
	
}
