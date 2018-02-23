/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TSystemLogDao;
import com.meikai.shop.entity.TSystemLog;
import com.meikai.shop.service.LogService;

/**
 * 日志
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("logServiceImpl")
public class LogServiceImpl extends BaseServiceImpl<TSystemLog, Long> implements LogService {

	
	@Autowired
	private TSystemLogDao logDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(logDao);
	}
	
	
}
