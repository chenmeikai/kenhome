/**
 * 
 */
package com.meikai.util.xml;

/**
 * 配置bean
 * @author meikai
 * @version 2017年11月24日 下午6:51:51
 */

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Setting implements Serializable {

	private static final long serialVersionUID = -1478999889661796840L;
	
	/**
	 * 水印位置
	 */
	public enum WatermarkPosition {

		/** 无 */
		no,

		/** 左上 */
		topLeft,

		/** 右上 */
		topRight,

		/** 居中 */
		center,

		/** 左下 */
		bottomLeft,

		/** 右下 */
		bottomRight
	}
	
	/**
	 * 小数位精确方式
	 */
	public enum RoundType {

		/** 四舍五入 */
		roundHalfUp,

		/** 向上取整 */
		roundUp,

		/** 向下取整 */
		roundDown
	}

	
	/**
	 * 验证码类型
	 */
	public enum CaptchaType {

		/** 后台登录 */
		adminLogin,

		/** 其它 */
		other
	}
	/**
	 * 账号锁定类型
	 */
	public enum AccountLockType {

		/** 管理员 */
		admin
	}


	/** 缓存名称 */
	public static final String CACHE_NAME = "setting";

	/** 缓存Key */
	public static final Integer CACHE_KEY = 0;

	/** 分隔符 */
	private static final String SEPARATOR = ",";
	
	
	/** 网站名称 */
	private String siteName;

	/** 网站网址 */
	private String siteUrl;

	/** logo */
	private String logo;
	
	/** 联系人*/
	private String contact;

	/** 联系地址 */
	private String address;

	/** 联系电话 */
	private String phone;

	/** E-mail */
	private String email;

	/** 备案编号 */
	private String certtext;

	/** 账号锁定类型 */
	private AccountLockType[] accountLockTypes;
	
	/** 验证码类型 */
	private CaptchaType[] captchaTypes;

	/** 连续登录失败最大次数 */
	private Integer accountLockCount;

	/** 自动解锁时间 */
	private Integer accountLockTime;

	/** 上传文件最大限制 */
	private Integer uploadMaxSize;

	/** 允许上传图片扩展名 */
	private String uploadImageExtension;

	/** 允许上传Flash扩展名 */
	private String uploadFlashExtension;

	/** 允许上传媒体扩展名 */
	private String uploadMediaExtension;

	/** 允许上传文件扩展名 */
	private String uploadFileExtension;

	/** 图片上传路径 */
	private String imageUploadPath;
	
	/** Flash上传路径 */
	private String flashUploadPath;

	/** 媒体上传路径 */
	private String mediaUploadPath;

	/** 文件上传路径 */
	private String fileUploadPath;
	
	/** 价格精确位数 */
	private Integer priceScale;

	/** 价格精确方式 */
	private RoundType priceRoundType;
	
	/** 货币符号 */
	private String currencySign;

	/** 货币单位 */
	private String currencyUnit;

	/** 发件人邮箱 */
	private String smtpFromMail;

	/** SMTP服务器地址 */
	private String smtpHost;

	/** SMTP服务器端口 */
	private Integer smtpPort;

	/** SMTP用户名 */
	private String smtpUsername;

	/** SMTP密码 */
	private String smtpPassword;

	/** Cookie路径 */
	private String cookiePath;

	/** Cookie作用域 */
	private String cookieDomain;
	
	/** 是否开启开发模式 */
	private Boolean isDevelopmentEnabled;
	
	
	/** 商品图片(大)宽度 */
	private Integer largeProductImageWidth;

	/** 商品图片(大)高度 */
	private Integer largeProductImageHeight;

	/** 商品图片(中)宽度 */
	private Integer mediumProductImageWidth;

	/** 商品图片(中)高度 */
	private Integer mediumProductImageHeight;

	/** 商品缩略图宽度 */
	private Integer thumbnailProductImageWidth;

	/** 商品缩略图高度 */
	private Integer thumbnailProductImageHeight;

	/** 默认商品图片(大) */
	private String defaultLargeProductImage;

	/** 默认商品图片(小) */
	private String defaultMediumProductImage;

	/** 默认缩略图 */
	private String defaultThumbnailProductImage;

	/** 水印透明度 */
	private Integer watermarkAlpha;

	/** 水印图片 */
	private String watermarkImage;

	/** 水印位置 */
	private WatermarkPosition watermarkPosition;
	
	//附近参数 
	private Integer distance;
	
	//积分兑换比
	private Integer exchange;
	
	//评价开关
	private Boolean review ;

	//银行名称
	private String bank;
	//银行支行
	private String subbranch;
	//户名
	private String name;
	//账号
	private String account;
	//消费者
	private String customer;
	
	
	
	
	public String getSiteName() {
		return siteName;
	}


	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCerttext() {
		return certtext;
	}


	public void setCerttext(String certtext) {
		this.certtext = certtext;
	}


	public AccountLockType[] getAccountLockTypes() {
		return accountLockTypes;
	}


	public void setAccountLockTypes(AccountLockType[] accountLockTypes) {
		this.accountLockTypes = accountLockTypes;
	}


	public Integer getAccountLockCount() {
		return accountLockCount;
	}


	public void setAccountLockCount(Integer accountLockCount) {
		this.accountLockCount = accountLockCount;
	}


	public Integer getAccountLockTime() {
		return accountLockTime;
	}


	public void setAccountLockTime(Integer accountLockTime) {
		this.accountLockTime = accountLockTime;
	}


	public Integer getUploadMaxSize() {
		return uploadMaxSize;
	}


	public void setUploadMaxSize(Integer uploadMaxSize) {
		this.uploadMaxSize = uploadMaxSize;
	}


	public Integer getPriceScale() {
		return priceScale;
	}


	public void setPriceScale(Integer priceScale) {
		this.priceScale = priceScale;
	}


	public RoundType getPriceRoundType() {
		return priceRoundType;
	}


	public void setPriceRoundType(RoundType priceRoundType) {
		this.priceRoundType = priceRoundType;
	}


	public String getCurrencySign() {
		return currencySign;
	}


	public void setCurrencySign(String currencySign) {
		this.currencySign = currencySign;
	}


	public String getCurrencyUnit() {
		return currencyUnit;
	}


	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}


	public String getSmtpFromMail() {
		return smtpFromMail;
	}


	public void setSmtpFromMail(String smtpFromMail) {
		this.smtpFromMail = smtpFromMail;
	}


	public String getSmtpHost() {
		return smtpHost;
	}


	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}


	public Integer getSmtpPort() {
		return smtpPort;
	}


	public void setSmtpPort(Integer smtpPort) {
		this.smtpPort = smtpPort;
	}


	public String getSmtpUsername() {
		return smtpUsername;
	}


	public void setSmtpUsername(String smtpUsername) {
		this.smtpUsername = smtpUsername;
	}


	public String getSmtpPassword() {
		return smtpPassword;
	}


	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}


	public String getCookieDomain() {
		return cookieDomain;
	}


	public void setCookieDomain(String cookieDomain) {
		this.cookieDomain = cookieDomain;
	}


	public Integer getLargeProductImageWidth() {
		return largeProductImageWidth;
	}


	public void setLargeProductImageWidth(Integer largeProductImageWidth) {
		this.largeProductImageWidth = largeProductImageWidth;
	}


	public Integer getLargeProductImageHeight() {
		return largeProductImageHeight;
	}


	public void setLargeProductImageHeight(Integer largeProductImageHeight) {
		this.largeProductImageHeight = largeProductImageHeight;
	}


	public Integer getMediumProductImageWidth() {
		return mediumProductImageWidth;
	}


	public void setMediumProductImageWidth(Integer mediumProductImageWidth) {
		this.mediumProductImageWidth = mediumProductImageWidth;
	}


	public Integer getMediumProductImageHeight() {
		return mediumProductImageHeight;
	}


	public void setMediumProductImageHeight(Integer mediumProductImageHeight) {
		this.mediumProductImageHeight = mediumProductImageHeight;
	}


	public Integer getThumbnailProductImageWidth() {
		return thumbnailProductImageWidth;
	}


	public void setThumbnailProductImageWidth(Integer thumbnailProductImageWidth) {
		this.thumbnailProductImageWidth = thumbnailProductImageWidth;
	}


	public Integer getThumbnailProductImageHeight() {
		return thumbnailProductImageHeight;
	}


	public void setThumbnailProductImageHeight(Integer thumbnailProductImageHeight) {
		this.thumbnailProductImageHeight = thumbnailProductImageHeight;
	}


	public String getDefaultLargeProductImage() {
		return defaultLargeProductImage;
	}


	public void setDefaultLargeProductImage(String defaultLargeProductImage) {
		this.defaultLargeProductImage = defaultLargeProductImage;
	}


	public String getDefaultMediumProductImage() {
		return defaultMediumProductImage;
	}


	public void setDefaultMediumProductImage(String defaultMediumProductImage) {
		this.defaultMediumProductImage = defaultMediumProductImage;
	}


	public String getDefaultThumbnailProductImage() {
		return defaultThumbnailProductImage;
	}


	public void setDefaultThumbnailProductImage(String defaultThumbnailProductImage) {
		this.defaultThumbnailProductImage = defaultThumbnailProductImage;
	}


	public Integer getWatermarkAlpha() {
		return watermarkAlpha;
	}


	public void setWatermarkAlpha(Integer watermarkAlpha) {
		this.watermarkAlpha = watermarkAlpha;
	}


	public String getWatermarkImage() {
		return watermarkImage;
	}


	public void setWatermarkImage(String watermarkImage) {
		this.watermarkImage = watermarkImage;
	}


	public WatermarkPosition getWatermarkPosition() {
		return watermarkPosition;
	}


	public void setWatermarkPosition(WatermarkPosition watermarkPosition) {
		this.watermarkPosition = watermarkPosition;
	}


	public Integer getDistance() {
		return distance;
	}


	public void setDistance(Integer distance) {
		this.distance = distance;
	}


	public Integer getExchange() {
		return exchange;
	}


	public void setExchange(Integer exchange) {
		this.exchange = exchange;
	}


	public Boolean getReview() {
		return review;
	}


	public void setReview(Boolean review) {
		this.review = review;
	}


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}


	public String getSubbranch() {
		return subbranch;
	}


	public void setSubbranch(String subbranch) {
		this.subbranch = subbranch;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getCustomer() {
		return customer;
	}


	public void setCustomer(String customer) {
		this.customer = customer;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static String getCacheName() {
		return CACHE_NAME;
	}


	public static Integer getCacheKey() {
		return CACHE_KEY;
	}


	public static String getSeparator() {
		return SEPARATOR;
	}


	public String getSiteUrl() {
		return siteUrl;
	}


	public String getUploadImageExtension() {
		return uploadImageExtension;
	}


	public String getUploadFlashExtension() {
		return uploadFlashExtension;
	}


	public String getUploadMediaExtension() {
		return uploadMediaExtension;
	}


	public String getUploadFileExtension() {
		return uploadFileExtension;
	}


	public String getImageUploadPath() {
		return imageUploadPath;
	}


	public String getFlashUploadPath() {
		return flashUploadPath;
	}


	public String getMediaUploadPath() {
		return mediaUploadPath;
	}


	public String getFileUploadPath() {
		return fileUploadPath;
	}


	public String getCookiePath() {
		return cookiePath;
	}


	/**
	 * 设置网站网址
	 * 
	 * @param siteUrl
	 *            网站网址
	 */
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = StringUtils.removeEnd(siteUrl, "/");
	}


	/**
	 * 设置允许上传图片扩展名
	 * 
	 * @param uploadImageExtension
	 *            允许上传图片扩展名
	 */
	public void setUploadImageExtension(String uploadImageExtension) {
		if (uploadImageExtension != null) {
			uploadImageExtension = uploadImageExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
		}
		this.uploadImageExtension = uploadImageExtension;
	}

	/**
	 * 设置允许上传Flash扩展名
	 * 
	 * @param uploadFlashExtension
	 *            允许上传Flash扩展名
	 */
	public void setUploadFlashExtension(String uploadFlashExtension) {
		if (uploadFlashExtension != null) {
			uploadFlashExtension = uploadFlashExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
		}
		this.uploadFlashExtension = uploadFlashExtension;
	}

	/**
	 * 设置允许上传媒体扩展名
	 * 
	 * @param uploadMediaExtension
	 *            允许上传媒体扩展名
	 */
	public void setUploadMediaExtension(String uploadMediaExtension) {
		if (uploadMediaExtension != null) {
			uploadMediaExtension = uploadMediaExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
		}
		this.uploadMediaExtension = uploadMediaExtension;
	}

	/**
	 * 设置允许上传文件扩展名
	 * 
	 * @param uploadFileExtension
	 *            允许上传文件扩展名
	 */
	public void setUploadFileExtension(String uploadFileExtension) {
		if (uploadFileExtension != null) {
			uploadFileExtension = uploadFileExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
		}
		this.uploadFileExtension = uploadFileExtension;
	}

	/**
	 * 设置图片上传路径
	 * 
	 * @param imageUploadPath
	 *            图片上传路径
	 */
	public void setImageUploadPath(String imageUploadPath) {
		if (imageUploadPath != null) {
			if (!imageUploadPath.startsWith("/")) {
				imageUploadPath = "/" + imageUploadPath;
			}
			if (!imageUploadPath.endsWith("/")) {
				imageUploadPath += "/";
			}
		}
		this.imageUploadPath = imageUploadPath;
	}


	/**
	 * 设置Flash上传路径
	 * 
	 * @param flashUploadPath
	 *            Flash上传路径
	 */
	public void setFlashUploadPath(String flashUploadPath) {
		if (flashUploadPath != null) {
			if (!flashUploadPath.startsWith("/")) {
				flashUploadPath = "/" + flashUploadPath;
			}
			if (!flashUploadPath.endsWith("/")) {
				flashUploadPath += "/";
			}
		}
		this.flashUploadPath = flashUploadPath;
	}


	/**
	 * 设置媒体上传路径
	 * 
	 * @param mediaUploadPath
	 *            媒体上传路径
	 */
	public void setMediaUploadPath(String mediaUploadPath) {
		if (mediaUploadPath != null) {
			if (!mediaUploadPath.startsWith("/")) {
				mediaUploadPath = "/" + mediaUploadPath;
			}
			if (!mediaUploadPath.endsWith("/")) {
				mediaUploadPath += "/";
			}
		}
		this.mediaUploadPath = mediaUploadPath;
	}

	/**
	 * 设置文件上传路径
	 * 
	 * @param fileUploadPath
	 *            文件上传路径
	 */
	public void setFileUploadPath(String fileUploadPath) {
		if (fileUploadPath != null) {
			if (!fileUploadPath.startsWith("/")) {
				fileUploadPath = "/" + fileUploadPath;
			}
			if (!fileUploadPath.endsWith("/")) {
				fileUploadPath += "/";
			}
		}
		this.fileUploadPath = fileUploadPath;
	}

	
	/**
	 * 获取验证码类型
	 * 
	 * @return 验证码类型
	 */
	public CaptchaType[] getCaptchaTypes() {
		return captchaTypes;
	}

	/**
	 * 设置验证码类型
	 * 
	 * @param captchaTypes
	 *            验证码类型
	 */
	public void setCaptchaTypes(CaptchaType[] captchaTypes) {
		this.captchaTypes = captchaTypes;
	}
	/**
	 * 设置Cookie路径
	 * 
	 * @param cookiePath
	 *            Cookie路径
	 */
	public void setCookiePath(String cookiePath) {
		if (cookiePath != null && !cookiePath.endsWith("/")) {
			cookiePath += "/";
		}
		this.cookiePath = cookiePath;
	}

	/**
	 * 获取允许上传图片扩展名
	 * 
	 * @return 允许上传图片扩展名
	 */
	public String[] getUploadImageExtensions() {
		return StringUtils.split(uploadImageExtension, SEPARATOR);
	}

	/**
	 * 获取允许上传Flash扩展名
	 * 
	 * @return 允许上传Flash扩展名
	 */
	public String[] getUploadFlashExtensions() {
		return StringUtils.split(uploadFlashExtension, SEPARATOR);
	}

	/**
	 * 获取允许上传媒体扩展名
	 * 
	 * @return 允许上传媒体扩展名
	 */
	public String[] getUploadMediaExtensions() {
		return StringUtils.split(uploadMediaExtension, SEPARATOR);
	}

	/**
	 * 获取允许上传文件扩展名
	 * 
	 * @return 允许上传文件扩展名
	 */
	public String[] getUploadFileExtensions() {
		return StringUtils.split(uploadFileExtension, SEPARATOR);
	}
	/**
	 * 获取是否开启开发模式
	 * 
	 * @return 是否开启开发模式
	 */
	public Boolean getIsDevelopmentEnabled() {
		return isDevelopmentEnabled;
	}

	/**
	 * 设置是否开启开发模式
	 * 
	 * @param isDevelopmentEnabled
	 *            是否开启开发模式
	 */
	public void setIsDevelopmentEnabled(Boolean isDevelopmentEnabled) {
		this.isDevelopmentEnabled = isDevelopmentEnabled;
	}
	/**
	 * 设置精度
	 * 
	 * @param amount
	 *            数值
	 * @return 数值
	 */
	public BigDecimal setScale(BigDecimal amount) {
		if (amount == null) {
			return null;
		}
		int roundingMode;
		if (getPriceRoundType() == RoundType.roundUp) {
			roundingMode = BigDecimal.ROUND_UP;
		} else if (getPriceRoundType() == RoundType.roundDown) {
			roundingMode = BigDecimal.ROUND_DOWN;
		} else {
			roundingMode = BigDecimal.ROUND_HALF_UP;
		}
		return amount.setScale(getPriceScale(), roundingMode);
	}
	
}