/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopReviewRecallDao;
import com.meikai.shop.entity.TShopReviewRecall;
import com.meikai.shop.service.ReviewRecallService;

/**
 * 回复评价
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("reviewRecallServiceImpl")
public class ReviewRecallServiceImpl extends BaseServiceImpl<TShopReviewRecall, Long> implements ReviewRecallService {

	
	@Autowired
	private TShopReviewRecallDao reviewRecallDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(reviewRecallDao);
	}
	
	
}
