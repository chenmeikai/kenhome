/**
 * 
 */
package com.meikai.util.xml;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 日志配置
 * 
 * @author chenmeikai
 *
 */
public class LogConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 操作名称 */
	private String operation;

	/** 请求URL */
	private String urlPattern;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
