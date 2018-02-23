package com.meikai.reciever;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class QueueReceiver implements MessageListener{
	private Log log = LogFactory.getLog(getClass());
	
	

	@Override
	public void onMessage(Message message) {
		
		try {			
			String orderStr = ((TextMessage) message).getText();
			log.info("接收到的信息是:"+orderStr);
			
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
		
		// 休眠片刻
		try {
			Thread.sleep(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	
}
