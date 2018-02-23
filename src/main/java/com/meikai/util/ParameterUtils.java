/**
 * 
 */
package com.meikai.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

/**
 * @author Administrator
 * @version 2017年8月26日 上午10:26:30
 *   参数处理工具
 */
public class ParameterUtils {
	public static Map<String, Object> getParametersMap(ServletRequest request) {
		Assert.notNull(request, "Request must not be null");
		Enumeration paramNames = request.getParameterNames();
		Map params = new TreeMap();
		while ((paramNames != null) && (paramNames.hasMoreElements())) {
			String paramName = (String) paramNames.nextElement();
			String[] values = request.getParameterValues(paramName);
			if ((values != null) && (values.length != 0)) {
				if (values.length > 1)
					params.put(paramName, values);
				else {
					params.put(paramName, (values[0] == null) ? null : values[0].trim());
				}
			}
		}
		return params;
	}

	public static Map<String, Object> getParametersMapStartingWith(ServletRequest request, String prefix) {
		Assert.notNull(request, "Request must not be null");
		Enumeration paramNames = request.getParameterNames();
		Map params = new TreeMap();
		if (prefix == null) {
			prefix = "";
		}
		while ((paramNames != null) && (paramNames.hasMoreElements())) {
			String paramName = (String) paramNames.nextElement();
			if (("".equals(prefix)) || (paramName.startsWith(prefix))) {
				String unprefixed = paramName.substring(prefix.length());
				String[] values = request.getParameterValues(paramName);
				if ((values != null) && (values.length != 0)) {
					if (values.length > 1)
						params.put(unprefixed, values);
					else {
						params.put(unprefixed, (values[0] == null) ? null : values[0].trim());
					}
				}
			}
		}
		return params;
	}

	public static List<String> getParametersList(ServletRequest request, String key) {
		List options = new ArrayList();
		String[] values = request.getParameterValues(key);
		for (String option : values) {
			if (StringUtils.isNotEmpty(option)) {
				options.add(option);
			}
		}
		return options;
	}
}
