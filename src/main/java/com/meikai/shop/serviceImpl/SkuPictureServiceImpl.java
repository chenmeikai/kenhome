/**
 * 
 */
package com.meikai.shop.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopSkuPictureDao;
import com.meikai.shop.entity.TShopSkuPicture;
import com.meikai.shop.service.SkuPictureService;



/**
 * 单品-图片关联
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("skuPictureServiceImpl")
public class SkuPictureServiceImpl extends BaseServiceImpl<TShopSkuPicture, Long> implements SkuPictureService {

	
	@Autowired
	private TShopSkuPictureDao skuPictureDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(skuPictureDao);
	}
    
	/**
	 * 根据商品Id获得管理图片
	 */
	@Override
	public List<TShopSkuPicture> getBySkuId(Long skuId) {
		// TODO Auto-generated method stub
		return skuPictureDao.getBySkuId(skuId);
	}
	
	
}
