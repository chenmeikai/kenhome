package com.meikai.util;

import java.io.BufferedReader;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;


/**
 * @author wangshu
 * @date 2016年4月12日
 * @what TODO
 * @description TODO
 */
public class HttpUtils {

	private static Log log = LogFactory.getLog(HttpUtils.class);
	public static final String CHARSET_UTF8 = "UTF-8";
	public static final String CHARSET_GBK = "GBK";
	private static final CloseableHttpClient httpClient;

	/**
	 * 加载连接
	 */
	static {
		httpClient = buildSSLCloseableHttpClient();
	}

	private static CloseableHttpClient buildSSLCloseableHttpClient() {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				// 信任所有
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			// ALLOW_ALL_HOSTNAME_VERIFIER:这个主机名验证器基本上是关闭主机名验证的,实现的是一个空操作，并且不会抛出javax.net.ssl.SSLException异常。
			@SuppressWarnings("deprecation")
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return HttpClients.createDefault();
	}

	/**
	 * 执行get请求 默认值 编码：utf-8,超时时间：连接5s传输20s
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String url, Map<String, String> params) {
		String response = null;
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);// 连接时间
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);// 数据传输时间
			client.getParams().setParameter("http.protocol.content-charset", CHARSET_UTF8);

			HttpGet httpGet = new HttpGet(url);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				nvps.add(new BasicNameValuePair(key, params.get(key)));
			}

			String str = EntityUtils.toString(new UrlEncodedFormEntity(nvps, CHARSET_UTF8));
			httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + str));
			HttpResponse resp = client.execute(httpGet);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				response = EntityUtils.toString(resp.getEntity(), CHARSET_UTF8);
			} else {
				log.error(resp.getStatusLine().getStatusCode() + "|url:" + httpGet.getURI().toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return response;
	}

	public static String doGet(String url, Map<String, String> params, Integer connectionTime, Integer so) {
		String response = null;
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectionTime);// 连接时间
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, so);// 数据传输时间
			client.getParams().setParameter("http.protocol.content-charset", CHARSET_UTF8);

			HttpGet httpGet = new HttpGet(url);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				nvps.add(new BasicNameValuePair(key, params.get(key)));
			}

			String str = EntityUtils.toString(new UrlEncodedFormEntity(nvps, CHARSET_UTF8));
			httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + str));
			HttpResponse resp = client.execute(httpGet);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				response = EntityUtils.toString(resp.getEntity(), CHARSET_UTF8);
			} else {
				log.error(resp.getStatusLine().getStatusCode() + "|url:" + httpGet.getURI().toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return response;
	}

	public static String doGet(String url, Map<String, String> params, Map<String, String> headers,
			Integer connectionTime, Integer so) {
		String response = null;
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectionTime);// 连接时间
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, so);// 数据传输时间
			client.getParams().setParameter("http.protocol.content-charset", CHARSET_UTF8);

			HttpGet httpGet = new HttpGet(url);
			if (headers != null) {
				for (String key : headers.keySet()) {
					httpGet.addHeader(key, headers.get(key));
				}
			}
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				nvps.add(new BasicNameValuePair(key, params.get(key)));
			}

			String str = EntityUtils.toString(new UrlEncodedFormEntity(nvps, CHARSET_UTF8));
			httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + str));
			HttpResponse resp = client.execute(httpGet);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				response = EntityUtils.toString(resp.getEntity(), CHARSET_UTF8);
			} else {
				log.error(resp.getStatusLine().getStatusCode() + "|url:" + httpGet.getURI().toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return response;
	}

	/**
	 * 获取主机实际IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getRealIp(HttpServletRequest request) {
		String ipAddress = null;
		// ipAddress = request.getRemoteAddr();
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
					ipAddress = inet.getHostAddress();
				} catch (UnknownHostException e) {
					log.error(e.getMessage());
				}

			}

		}

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	/**
	 * 获取请求IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

	/**
	 * 执行post请求 默认值 编码：utf-8,超时时间：连接5s传输20s
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String doPost(String url, Map<String, String> params) {
		String response = null;

		try {
			DefaultHttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);// 连接时间
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);// 数据传输时间
			client.getParams().setParameter("http.protocol.content-charset", CHARSET_UTF8);

			HttpPost httpost = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				nvps.add(new BasicNameValuePair(key, params.get(key)));
			}

			httpost.setEntity(new UrlEncodedFormEntity(nvps, CHARSET_UTF8));
			HttpResponse resp = client.execute(httpost);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				response = EntityUtils.toString(resp.getEntity(), CHARSET_UTF8);
			} else {
				log.error(resp.getStatusLine().getStatusCode() + "|url:" + httpost.getURI().toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return response;
	}

	
	/**
	 * 执行post请求 默认值 编码：utf-8,超时时间：连接5s传输20s
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String doPost(String url, Map<String, String> params, int conTimeout, int soTimeout) {
		String response = null;

		DefaultHttpClient client = new DefaultHttpClient();
		try {
			client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, conTimeout);// 连接时间
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, soTimeout);// 数据传输时间
			client.getParams().setParameter("http.protocol.content-charset", CHARSET_UTF8);

			HttpPost httpost = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				nvps.add(new BasicNameValuePair(key, params.get(key)));
			}

			httpost.setEntity(new UrlEncodedFormEntity(nvps, CHARSET_UTF8));
			HttpResponse resp = client.execute(httpost);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				response = EntityUtils.toString(resp.getEntity(), CHARSET_UTF8);
			} else {
				log.error(resp.getStatusLine().getStatusCode() + "|url:" + httpost.getURI().toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return response;
	}

	public static String doPost(String url, Map<String, String> params, Map<String, String> headers,
			Integer connectionTime, Integer so) {
		String response = null;

		try {
			DefaultHttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectionTime);// 连接时间
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, so);// 数据传输时间
			client.getParams().setParameter("http.protocol.content-charset", CHARSET_UTF8);
			HttpPost httpost = new HttpPost(url);
			if (headers != null) {
				for (String key : headers.keySet()) {
					httpost.addHeader(key, headers.get(key));
				}
			}
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				nvps.add(new BasicNameValuePair(key, params.get(key) + ""));
			}

			httpost.setEntity(new UrlEncodedFormEntity(nvps, CHARSET_UTF8));
			HttpResponse resp = client.execute(httpost);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				response = EntityUtils.toString(resp.getEntity(), CHARSET_UTF8);
			} else {
				log.error(resp.getStatusLine().getStatusCode() + "|url:" + httpost.getURI().toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return response;
	}
	
	/**
	 * 执行post请求,发送json 默认值 编码：utf-8,超时时间：连接5s传输20s
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String doPostJsonString(String url, String jsonStr, Map<String, String> headers,Integer connectionTime, Integer so) {
		String response = null;
		try {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectionTime);// 连接时间
			httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, so);// 数据传输时间

			HttpPost httppost = new HttpPost(url);
			StringEntity myEntity = new StringEntity(jsonStr, CHARSET_UTF8);
			if (headers != null) {
				for (String key : headers.keySet()) {
					httppost.addHeader(key, headers.get(key));
				}
			}
			httppost.setEntity(myEntity);
			HttpResponse resp = httpclient.execute(httppost);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				response = EntityUtils.toString(resp.getEntity(), CHARSET_UTF8);
			} else {
				log.error(resp.getStatusLine().getStatusCode() + "|url:" + httppost.getURI().toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return response;
	}

	/**
	 * 执行post请求,发送json 默认值 编码：utf-8,超时时间：连接5s传输20s
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String doPostJsonString(String url, String jsonStr) {
		return doPostJsonString( url,  jsonStr, null, 10*1000,10*1000);
	}
	public static String doPostJsonString(String url, String jsonStr,Integer connectionTime, Integer so) {
		return doPostJsonString( url,  jsonStr, null, connectionTime,so);
	}
	/**
	 * 执行post请求,发送json 默认值 编码：utf-8,超时时间：连接5s传输20s
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String doPostJsonString(String url, String jsonStr, Map<String, String> headers) {
		return doPostJsonString( url,  jsonStr, headers, 10*1000,10*1000);
	}
	/**
	 * 读取json请求
	 * 
	 * @param request
	 * @return
	 */
	public static String readJSONString(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return json.toString();
	}
	
	public static String doHttpsGet2(String url, Map<String, String> params) {
		HttpClient httpClient = null;
		HttpGet httpGet = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpGet = new HttpGet(url);

			httpGet.setHeader("Content-Type", "application/xml");

			// 设置参数
			 List<NameValuePair> list = new ArrayList<NameValuePair>();
			 Iterator iterator = params.entrySet().iterator();
			 while(iterator.hasNext()){
			 Entry<String,String> elem = (Entry<String, String>)
			 iterator.next();
			 list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
			 }
			 
			HttpResponse response = httpClient.execute(httpGet);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "utf-8");
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
			log.error("移动订购异常|"+result);
		}
		return result;
	}
	public static String doHttpsGet(String url, Map<String, String> params) {
		return doHttpsGet(url, params, CHARSET_UTF8);
	}

	public static String doHttpsPost(String url, Map<String, String> params) {
		return doHttpsPost(url, params, CHARSET_UTF8,10000,10000);
	}
	public static String doHttpsPost(String url, Map<String, String> params, int conTimeout, int soTimeout) {
		return doHttpsPost(url, params, CHARSET_UTF8,conTimeout,soTimeout);
	}

	/**
	 * HTTP Post 获取内容
	 * 
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 */
	public static String doHttpsPost(String url, Map<String, String> params, String charset, int conTimeout, int soTimeout) {
		String result = null;
		if (org.apache.commons.lang.StringUtils.isBlank(url)) {
			return null;
		}
		try {
			List<NameValuePair> pairs = null;
			if (params != null && !params.isEmpty()) {
				pairs = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value));
					}
				}
			}
			HttpPost httpPost = new HttpPost(url);
			// 请求超时
			httpPost.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, conTimeout);
            // 读取超时
			httpPost.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, soTimeout);
			if (pairs != null && pairs.size() > 0) {
				httpPost.setEntity(new UrlEncodedFormEntity(pairs, charset));
			}
			CloseableHttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPost.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}

			EntityUtils.consume(entity);
			response.close();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;
	}

	/**
	 * HTTP Get 获取内容
	 * 
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 */
	public static String doHttpsGet(String url, Map<String, String> params, String charset) {
		if (org.apache.commons.lang.StringUtils.isBlank(url)) {
			return null;
		}
		try {
			if (params != null && !params.isEmpty()) {
				List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value));
					}
				}
				url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
			}
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpGet.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
			response.close();
			return result;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/**
	 * HTTP Post 获取内容
	 * 
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 */
	// public static String doPostAuthorization(String url, Map<String, String>
	// params,String nonce,String sign) {
	// String result = null;
	// if (org.apache.commons.lang.StringUtils.isBlank(url)) {
	// return null;
	// }
	// try {
	// List<NameValuePair> pairs = null;
	// if (params != null && !params.isEmpty()) {
	// pairs = new ArrayList<NameValuePair>(params.size());
	// for (Map.Entry<String, String> entry : params.entrySet()) {
	// String value = entry.getValue();
	// if (value != null) {
	// pairs.add(new BasicNameValuePair(entry.getKey(), value));
	// }
	// }
	// }
	// HttpPost httpPost = new HttpPost(url);
	// httpPost.setHeader("Authorization",
	// "sign=\""+sign+"\",nonce=\""+nonce+"\"");
	//
	// if (pairs != null && pairs.size() > 0) {
	// httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET_UTF8));
	// }
	// CloseableHttpResponse response = httpClient.execute(httpPost);
	// int statusCode = response.getStatusLine().getStatusCode();
	// if (statusCode != 200) {
	// httpPost.abort();
	// throw new RuntimeException("HttpClient,error status code :"+ statusCode);
	// }
	// HttpEntity entity = response.getEntity();
	// if (entity != null) {
	// result = EntityUtils.toString(entity, "utf-8");
	// }
	// EntityUtils.consume(entity);
	// response.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return result;
	// }
	//
	// /**
	// * HTTP Get 获取内容
	// * @param url 请求的url地址 ?之前的地址
	// * @param params 请求的参数
	// * @param charset 编码格式
	// * @return 页面内容
	// */
	// public static String doGetAuthorization(String url, Map<String, String>
	// params,String nonce,String sign){
	// if(org.apache.commons.lang.StringUtils.isBlank(url)){
	// return null;
	// }
	// try {
	// if(params != null && !params.isEmpty()){
	// List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
	// for(Map.Entry<String,String> entry : params.entrySet()){
	// String value = entry.getValue();
	// if(value != null){
	// pairs.add(new BasicNameValuePair(entry.getKey(),value));
	// }
	// }
	// url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs,
	// CHARSET_UTF8));
	// }
	// HttpGet httpGet = new HttpGet(url);
	// httpGet.setHeader("Authorization",
	// "sign=\""+sign+"\",nonce=\""+nonce+"\"");
	// CloseableHttpResponse response = httpClient.execute(httpGet);
	// int statusCode = response.getStatusLine().getStatusCode();
	// if (statusCode != 200) {
	// httpGet.abort();
	// throw new RuntimeException("HttpClient,error status code :" +
	// statusCode);
	// }
	// HttpEntity entity = response.getEntity();
	// String result = null;
	// if (entity != null){
	// result = EntityUtils.toString(entity, "utf-8");
	// }
	// EntityUtils.consume(entity);
	// response.close();
	// return result;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }

}
class SSLClient extends DefaultHttpClient {
	public SSLClient() throws Exception {
		super();
		SSLContext ctx = SSLContext.getInstance("TLS");
		X509TrustManager tm = new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		ctx.init(null, new TrustManager[] { tm }, null);
		SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		ClientConnectionManager ccm = this.getConnectionManager();
		SchemeRegistry sr = ccm.getSchemeRegistry();
		sr.register(new Scheme("https", 443, ssf));
	}
}