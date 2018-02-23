package com.meikai.util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wangshu
 * @date 2016年5月6日
 * @what json工具类
 * @description TODO
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectMapper objectMapper2 = new ObjectMapper();
    private static ObjectMapper objectMapper3 = new ObjectMapper();
    private static ObjectMapper objectMapper4 = new ObjectMapper();
    static{
    	objectMapper2.setSerializationInclusion(Include.NON_NULL);
    	objectMapper3.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, false);
    	objectMapper4.setSerializationInclusion(Include.ALWAYS);
    }
    /**
     * 对象序列化成json串
     * 
     * @param object
     * @return
     * @throws Exception
     */
    public static String toJSONStr(Object object) {
    	
        if (object != null) {
            try {
				return objectMapper.writeValueAsString(object);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
        }
        return null;
    }
    /**
     * 对象序列化成json串
     * 
     * @param object
     * @return
     * @throws Exception
     */
    public static String toJSONStrSeqRaw(Object object) {
    	
        if (object != null) {
            try {
				return objectMapper3.writeValueAsString(object);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
        }
        return null;
    }
    /**
     * 对象序列化成json串
     * 
     * @param object
     * @return
     * @throws Exception
     */
    public static String toJSONStrNonNull(Object object){
    	
        if (object != null) {
            try {
				return objectMapper2.writeValueAsString(object);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
        }
        return null;
    }

    /**
     * 对象序列化成json串
     * 
     * @param object
     * @return
     * @throws Exception
     */
    public static <T> T toObject(String string, Class<T> objClass){
        if (string != null && !"".equals(string)) {
            try {
				return objectMapper.readValue(string, objClass);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return null;
    }
    /**
     * 对象序列化成json串
     * 
     * @param object
     * @return
     * @throws Exception
     */
    public static String toObjectNoNDefault(Object object){
        if (object != null) {
            try {
				return objectMapper4.writeValueAsString(object);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
        }
        return null;
    }
    
    

}
