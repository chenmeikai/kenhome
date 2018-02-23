/**
 * 
 */
package com.meikai.shop.serviceImpl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopSpuAttributeOptionDao;
import com.meikai.shop.entity.TShopSpuAttributeOption;
import com.meikai.shop.service.SpuAttributeOptionService;


/**
 * 商品-属性值关联
 * @author meikai
 * @version 2017年10月24日 上午10:29:37
 */

@Service("spuAttributeOptionServiceImpl")
public class SpuAttributeOptionServiceImpl extends BaseServiceImpl<TShopSpuAttributeOption, Long> implements SpuAttributeOptionService {

	
	@Autowired
	private TShopSpuAttributeOptionDao spuAttributeOptionDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(spuAttributeOptionDao);
	}
    
    /**
     * 根据SpuId删除关联属性值
     */
	@Override
	public Long deleteBySpuId(Long spuId) {
		// TODO Auto-generated method stub
		return spuAttributeOptionDao.deleteBySpuId(spuId);
	}
    
	
	
	
}
