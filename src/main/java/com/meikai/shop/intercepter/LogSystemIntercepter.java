/**
 * 
 */
package com.meikai.shop.intercepter;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.meikai.shop.entity.TSystemLog;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.service.LogConfigService;
import com.meikai.shop.service.LogService;
import com.meikai.shop.service.ManagerService;
import com.meikai.util.CommonParams;
import com.meikai.util.IpUtils;
import com.meikai.util.xml.LogConfig;


/**
 * 日志记录
 * @author meikai
 * @version 2017年11月25日 下午4:10:01
 */

public class LogSystemIntercepter extends HandlerInterceptorAdapter {

	/** 默认忽略参数 */
	private static final String[] DEFAULT_IGNORE_PARAMETERS = new String[] { "password", "rePassword", "currentPassword" };

	/** antPathMatcher */
	private static AntPathMatcher antPathMatcher = new AntPathMatcher();

	/** 忽略参数 */
	private String[] ignoreParameters = DEFAULT_IGNORE_PARAMETERS;

	@Resource
	private LogConfigService logConfigService;
	@Resource
	private LogService logService;
	@Resource
	private ManagerService managerService;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		System.out.println("进入日志记录拦截器");
		
		TSystemManager manager = (TSystemManager) request.getSession().getAttribute("manager");
		
		List<LogConfig> logConfigs = logConfigService.getAll();
		if (logConfigs != null) {
			String path = request.getServletPath();
			for (LogConfig logConfig : logConfigs) {
				if (antPathMatcher.match(logConfig.getUrlPattern(), path)) {
					String managerName = manager.getManagerName();
					//操作动作
					String operation = logConfig.getOperation();
					//操作人
					String operator = managerName;
					//操作内容，操作时存入request
					String content = (String) request.getAttribute(CommonParams.LOG_ATTRIBUTE);
					//操作Ip地址
					String ip = IpUtils.getIpAddr(request);
					//清除request的操作内容属性
					request.removeAttribute(CommonParams.LOG_ATTRIBUTE);
					StringBuffer parameter = new StringBuffer();
					Map<String, String[]> parameterMap = request.getParameterMap();
					if (parameterMap != null) {
						for (Entry<String, String[]> entry : parameterMap.entrySet()) {
							String parameterName = entry.getKey();
							if (!ArrayUtils.contains(ignoreParameters, parameterName)) {
								String[] parameterValues = entry.getValue();
								if (parameterValues != null) {
									for (String parameterValue : parameterValues) {
										parameter.append(parameterName + " = " + parameterValue + "\n");
									}
								}
							}
						}
					}
					TSystemLog log = new TSystemLog();
					log.setOperation(operation);
					log.setOperator(operator);
					log.setContent(content);
					log.setParameter(parameter.toString());
					log.setOperateIp(ip);
					log.setCreateDate(new Date());
					logService.saveAddEntity(log);
					break;
				}
			}
		}
	}

	/**
	 * 设置忽略参数
	 * 
	 * @return 忽略参数
	 */
	public String[] getIgnoreParameters() {
		return ignoreParameters;
	}

	/**
	 * 设置忽略参数
	 * 
	 * @param ignoreParameters
	 *            忽略参数
	 */
	public void setIgnoreParameters(String[] ignoreParameters) {
		this.ignoreParameters = ignoreParameters;
	}

}