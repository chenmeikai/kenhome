/**********************************************
*Copyright 2016 fengxing Corporation
*
* 2016年4月15日 wangshu 创建文件
*
***********************************************/
package com.meikai.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * @what 队列-生产者
 * @description TODO
 */
@Component
public class QueueSender {
//	@Autowired
//	@Qualifier("jmsQueueTemplate")
	private JmsTemplate jmsTemplate;// 通过@Qualifier修饰符来注入对应的bean

	/**
	 * 发送一条消息到指定的队列（目标）
	 * 
	 * @param queueName
	 *            队列名称
	 * @param message
	 *            消息内容
	 */
	public void send(String queueName, final String message) {
		jmsTemplate.send(queueName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}

	/**
	 * @param jmsTemplate the jmsTemplate to set
	 */
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	
}
