/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopNoticeReceiverDao;
import com.meikai.shop.entity.TShopNoticeReceiver;
import com.meikai.shop.service.NoticeReceiverService;

/**
 * 通知接收人
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("noticeReceiverServiceImpl")
public class NoticeReceiverServiceImpl extends BaseServiceImpl<TShopNoticeReceiver, Long> implements NoticeReceiverService {

	
	@Autowired
	private TShopNoticeReceiverDao noticeReceiverDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(noticeReceiverDao);
	}
	
	
}
