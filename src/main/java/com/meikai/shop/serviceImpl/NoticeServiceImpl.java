/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopNoticeDao;
import com.meikai.shop.entity.TShopNotice;
import com.meikai.shop.service.NoticeService;

/**
 * 通知
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("noticeServiceImpl")
public class NoticeServiceImpl extends BaseServiceImpl<TShopNotice, Long> implements NoticeService {

	
	@Autowired
	private TShopNoticeDao noticeDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(noticeDao);
	}
	
	
}
