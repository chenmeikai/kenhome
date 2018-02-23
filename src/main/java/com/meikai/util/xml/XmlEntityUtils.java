package com.meikai.util.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.io.IOUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.core.io.ClassPathResource;
import com.meikai.util.CommonParams;



/**
 * Utils - 系统设置
 * 读取和设置setting xml配置文件
 * 
 * @author Mounate Yan。
 * @version 1.0
 */
public final class XmlEntityUtils {
	
	/** BeanUtilsBean */
	@SuppressWarnings("unused")
	private static final BeanUtilsBean beanUtils;

	static {
		ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean() {
			@Override
			public String convert(Object value) {
				if (value != null) {
					Class<?> type = value.getClass();
					if (type.isEnum() && super.lookup(type) == null) {
						super.register(new EnumConverter(type), type);
					} else if (type.isArray() && type.getComponentType().isEnum()) {
						if (super.lookup(type) == null) {
							ArrayConverter arrayConverter = new ArrayConverter(type, new EnumConverter(type.getComponentType()), 0);
							arrayConverter.setOnlyFirstToString(false);
							super.register(arrayConverter, type);
						}
						Converter converter = super.lookup(type);
						return ((String) converter.convert(String.class, value));
					}
				}
				return super.convert(value);
			}

			@Override
			public Object convert(String value, @SuppressWarnings("rawtypes") Class clazz) {
				if (clazz.isEnum() && super.lookup(clazz) == null) {
					super.register(new EnumConverter(clazz), clazz);
				}
				return super.convert(value, clazz);
			}

			@Override
			public Object convert(String[] values, @SuppressWarnings("rawtypes") Class clazz) {
				if (clazz.isArray() && clazz.getComponentType().isEnum() && super.lookup(clazz.getComponentType()) == null) {
					super.register(new EnumConverter(clazz.getComponentType()), clazz.getComponentType());
				}
				return super.convert(values, clazz);
			}

			public Object convert(Object value, @SuppressWarnings("rawtypes") Class targetType) {
				if (super.lookup(targetType) == null) {
					if (targetType.isEnum()) {
						super.register(new EnumConverter(targetType), targetType);
					} else if (targetType.isArray() && targetType.getComponentType().isEnum()) {
						ArrayConverter arrayConverter = new ArrayConverter(targetType, new EnumConverter(targetType.getComponentType()), 0);
						arrayConverter.setOnlyFirstToString(false);
						super.register(arrayConverter, targetType);
					}
				}
				return super.convert(value, targetType);
			}
		};

		DateConverter dateConverter = new DateConverter();
		dateConverter.setPatterns(CommonParams.DATE_PATTERNS);
		convertUtilsBean.register(dateConverter, Date.class);
		beanUtils = new BeanUtilsBean(convertUtilsBean);
	}

		

	/**
	 * 不可实例化
	 */
	private XmlEntityUtils() {
	}

	/**
	 * 获取xml配置文件某节点名的信息存储到对应的实体类中(注意：该节点名的节点，其第一个属性的值不能与相同节点名的第一个属性值相同，否则不能唯一映射实体类)
	 * xmlPath:xml路径，nodeName：节点名，attr1:节点的第一个属性名（其值对应实体类的属性名），attr2:节点的第二个属性名（其值对应实体类的属性值）    entity：映射的实体类
	 * 如<setting attr1="currencyUnit" attr2="元"/>
	 * @return 映射实体类
	 */
	public static Object get(String xmlPath,String nodeName,String attr1,String attr2, Object entity) {		

			try {
				File shopxxXmlFile = new ClassPathResource(xmlPath).getFile();
				Document document = new SAXReader().read(shopxxXmlFile);
				@SuppressWarnings("unchecked")
				List<Element> elements = document.selectNodes(nodeName);
				for (Element element : elements) {
					String name = element.attributeValue(attr1);
					String value = element.attributeValue(attr2);
					try {
						beanUtils.setProperty(entity, name, value);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		    return entity;
	}
	
	

	/**
	 * 设置xml的节点值，根据映射的实体类
	 * xmlPath:xml路径，nodeName：节点名，attr1:节点的第一个属性名（其值对应实体类的属性名），attr2:节点的第二个属性名（其值对应实体类的属性值）    entity：映射的实体类
	 * 如<setting attr1="currencyUnit" attr2="元"/>
	 *            
	 */
	@SuppressWarnings("unchecked")
	public static void set(String xmlPath,String nodeName,String attr1,String attr2, Object entity) {
		try {
			File settingXmlFile = new ClassPathResource(xmlPath).getFile();
			Document document = new SAXReader().read(settingXmlFile);
			List<Element> elements = document.selectNodes(nodeName);
			for (Element element : elements) {
				try {
					String name = element.attributeValue(attr1);
					String value = beanUtils.getProperty(entity, name);
					Attribute attribute = element.attribute(attr2);
					attribute.setValue(value);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}

			FileOutputStream fileOutputStream = null;
			XMLWriter xmlWriter = null;
			try {
				OutputFormat outputFormat = OutputFormat.createPrettyPrint();
				outputFormat.setEncoding("UTF-8");
				outputFormat.setIndent(true);
				outputFormat.setIndent("	");
				outputFormat.setNewlines(true);
				fileOutputStream = new FileOutputStream(settingXmlFile);
				xmlWriter = new XMLWriter(fileOutputStream, outputFormat);
				xmlWriter.write(document);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (xmlWriter != null) {
					try {
						xmlWriter.close();
					} catch (IOException e) {
					}
				}
				IOUtils.closeQuietly(fileOutputStream);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}