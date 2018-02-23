package com.meikai.util;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 网页文件路径工具
 * @author zhikai.chen
 * @since 2014-4-28
 */
public class WebPathUtil {
	
	private static String PATH;
	
	/**
	 * 获取项目路径
	 * @return 项目路径
	 */
	public static String PATH(){
		if(PATH==null){
			try {
				PATH=new DefaultResourceLoader().getResource("").getFile().getAbsolutePath();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return PATH;
	}
	
	/**
	 * 根据资源路径找到对应的目录或者文件
	 * @param resourcePath 资源路径
	 * @return 对应的目录或者文件
	 */
	public static File getResourceFile(String resourcePath) throws IOException{
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource(resourcePath);
		return resource.getFile();
	}
	
	/**
	 * 根据资源路径找到对应的目录或者文件
	 * @param resourcePath 资源路径
	 * @return 对应的目录或者文件
	 */
	public static Resource getResource(String resourcePath) throws IOException{
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource(resourcePath);
		return resource;
	}

}
