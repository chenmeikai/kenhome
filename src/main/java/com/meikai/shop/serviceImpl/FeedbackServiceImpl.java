/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopFeedbackDao;
import com.meikai.shop.entity.TShopFeedback;
import com.meikai.shop.service.FeedbackService;

/**
 * 反馈
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("feedbackServiceImpl")
public class FeedbackServiceImpl extends BaseServiceImpl<TShopFeedback, Long> implements FeedbackService {

	
	@Autowired
	private TShopFeedbackDao feedbackDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(feedbackDao);
	}

	
	
	
	
}
