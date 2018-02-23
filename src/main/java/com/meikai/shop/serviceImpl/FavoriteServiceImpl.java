/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopFavoriteDao;
import com.meikai.shop.entity.TShopFavorite;
import com.meikai.shop.service.FavoriteService;

/**
 * 收藏
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("favoriteServiceImpl")
public class FavoriteServiceImpl extends BaseServiceImpl<TShopFavorite, Long> implements FavoriteService {

	
	@Autowired
	private TShopFavoriteDao favoriteDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(favoriteDao);
	}
	
	
}
