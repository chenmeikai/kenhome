/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.util.xml.LogConfig;

/**
 * 读取xml配置的日志对应映射
 * @author meikai
 * @version 2017年11月25日 下午3:14:32
 */

public interface LogConfigService {
	
	List<LogConfig> getAll();

}
