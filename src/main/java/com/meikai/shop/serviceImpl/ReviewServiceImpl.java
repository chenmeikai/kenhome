/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopReviewDao;
import com.meikai.shop.entity.TShopReview;
import com.meikai.shop.service.ReviewService;

/**
 * 评价
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("ReviewServiceImpl")
public class ReviewServiceImpl extends BaseServiceImpl<TShopReview, Long> implements ReviewService {

	
	@Autowired
	private TShopReviewDao reviewDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(reviewDao);
	}
	
	
}
