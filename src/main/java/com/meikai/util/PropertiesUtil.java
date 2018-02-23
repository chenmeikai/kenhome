/**
 * 
 */
package com.meikai.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 获取properties值工具
 * @author meikai
 * @version 2017年10月21日 下午10:29:47
 */
public class PropertiesUtil {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(PropertiesUtil.class);
    private static Properties props;
    static{
        loadProps();
    }
   
    synchronized static private void loadProps(){
        logger.info("开始加载properties文件内容.......");
        props = new Properties();
        InputStream in = null;
        try {
           //第一种,通过类加载器进行获取properties文件流
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream("kenhome-common.properties");
           //第二种,通过类进行获取properties文件流-->
            //in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            logger.error("jdbc.properties文件未找到");
        } catch (IOException e) {
            logger.error("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("jdbc.properties文件流关闭出现异常");
            }
        }
        logger.info("加载properties文件内容完成...........");
        logger.info("properties文件内容：" + props);
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
    
    
    /**
     * 根据properties文件，获取map集合
     * @param propertiesPath
     * @return Map
     */
    public static Map<String,String> getMap(String propertiesPath){
    	 
    	  Properties properties = new Properties(); 
    	  
    	  logger.info("开始加载properties文件内容.......");
  
          InputStream in = null;
          try {
             //第一种,通过类加载器进行获取properties文件流
              in = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesPath);
             //第二种,通过类进行获取properties文件流-->
              //in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
              properties.load(in);
              
          } catch (FileNotFoundException e) {
              logger.error("properties文件未找到");
          } catch (IOException e) {
              logger.error("出现IOException");
          } finally {
              try {
                  if(null != in) {
                      in.close();
                  }
              } catch (IOException e) {
                  logger.error("properties文件流关闭出现异常");
              }
          }
          
          @SuppressWarnings({ "unchecked", "rawtypes" })
		  Map<String, String> pros = new HashMap<String, String>((Map) properties);
          
          return pros;
  	
    	
    }
    
    
}