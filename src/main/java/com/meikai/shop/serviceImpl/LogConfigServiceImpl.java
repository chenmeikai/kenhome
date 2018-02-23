/**
 * 
 */
package com.meikai.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.meikai.shop.service.LogConfigService;
import com.meikai.util.CommonParams;
import com.meikai.util.xml.LogConfig;

/**
 * 读取xml配置的日志映射
 * @author meikai
 * @version 2017年11月25日 下午3:18:09
 */
@Service("logConfigService")
public class LogConfigServiceImpl implements LogConfigService {
    
	@Override
	public List<LogConfig> getAll() {
		
		    List<LogConfig> logConfigs =new ArrayList<LogConfig>();
		
			File shopxxXmlFile;
			try {
				shopxxXmlFile = new ClassPathResource(CommonParams.SETTING_XML_PATH).getFile();
			
			    Document document;
		        document = new SAXReader().read(shopxxXmlFile);

			    @SuppressWarnings("unchecked")
			    List<Element> elements = document.selectNodes("framework/logConfig");
			    for (Element element : elements) {
				   String operation = element.attributeValue("operation");
				   String urlPattern = element.attributeValue("urlPattern");

					 LogConfig logConfig =new LogConfig();
					 logConfig.setOperation(operation);
					 logConfig.setUrlPattern(urlPattern);
					 logConfigs.add(logConfig);
	                		
			   }
			   
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return logConfigs;
	 }

}
