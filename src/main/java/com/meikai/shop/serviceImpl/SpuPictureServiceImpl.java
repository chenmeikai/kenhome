/**
 * 
 */
package com.meikai.shop.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopSpuPictureDao;
import com.meikai.shop.entity.TShopSpuPicture;
import com.meikai.shop.service.SpuPictureService;

/**
 * 商品图片
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("spuPictureServiceImpl")
public class SpuPictureServiceImpl extends BaseServiceImpl<TShopSpuPicture, Long> implements SpuPictureService {

	
	@Autowired
	private TShopSpuPictureDao spuPictureDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(spuPictureDao);
	}
    
	/**
	 * 根据SpuId获得关联图片
	 */
	@Override
	public List<TShopSpuPicture> getBySpuId(Long spuId) {
		// TODO Auto-generated method stub
		return spuPictureDao.getBySpuId(spuId);
	}
	
	
	
	
}
