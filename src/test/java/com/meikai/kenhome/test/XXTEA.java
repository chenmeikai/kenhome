/**
 * 
 */
package com.meikai.kenhome.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meikai.util.WebPathUtil;

public class XXTEA {
	private static final XXTEA instance = new XXTEA();
	private static final Logger log = LoggerFactory.getLogger(instance.getClass());
	private String key = null;
	
	public static XXTEA getInstance() {
		return instance;
	}
	
	public void init() {
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(WebPathUtil.getResourceFile("/verifykey.properties")));
			Properties prop = new Properties();
			prop.load(in);
			key = prop.getProperty("aesKey");
		} catch (IOException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();  //关闭连接
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getKey() {
		return key;
	}
	
    private XXTEA() {
    }

    private String base64Encode(byte[] data) {
        return new String(org.apache.commons.codec.binary.Base64.encodeBase64(data));
    }

    private byte[] base64Decode(String data) throws IOException {
        return org.apache.commons.codec.binary.Base64.decodeBase64(data.getBytes());
    }

    private byte[] base64Decode(byte[] data) throws IOException {
        return org.apache.commons.codec.binary.Base64.decodeBase64(data);
    }

    /**
     * Encrypt data with key.
     *
     * @param data
     * @param key
     * @return
     */
    public byte[] encrypt(byte[] data, byte[] key) {
        if (data.length == 0) {
            return data;
        }
        return toByteArray(encrypt(toIntArray(data, true), toIntArray(key, false)), false);
    }

    public String encryptWithBase64(byte[] data, byte[] key) {
        return base64Encode(encrypt(data, key));
    }

    public String encryptWithBase64(String data, byte[] key, String encoding)
            throws UnsupportedEncodingException {
        return base64Encode(encrypt(data.getBytes(encoding), key));
    }

    /**
     * Decrypt data with key.
     *
     * @param data
     * @param key
     * @return
     */
    public byte[] decrypt(byte[] data, byte[] key) {
        if (data.length == 0) {
            return data;
        }
        return toByteArray(decrypt(toIntArray(data, false), toIntArray(key, false)), true);
    }

    /**
     * @param data
     * @param key
     * @param encoding
     * @return
     * @throws IOException
     */
    public byte[] decryptWithBase64(String data, byte[] key, String encoding) throws IOException {
        if (null == data || data.length() == 0) {
            return new byte[0];
        }
        return decrypt(base64Decode(data), key);
    }

    /**
     * @param data
     * @param key
     * @return
     * @throws IOException
     */
    public byte[] decryptWithBase64(byte[] data, byte[] key) throws IOException {
        if (data.length == 0) {
            return data;
        }
        return decrypt(base64Decode(data), key);
    }

    /**
     * Encrypt data with key.
     *
     * @param v
     * @param k
     * @return
     */
    public int[] encrypt(int[] v, int[] k) {
        int n = v.length - 1;

        if (n < 1) {
            return v;
        }
        if (k.length < 4) {
            int[] key = new int[4];

            System.arraycopy(k, 0, key, 0, k.length);
            k = key;
        }
        int z = v[n], y = v[0], delta = 0x9E3779B9, sum = 0, e;
        int p, q = 6 + 52 / (n + 1);

        while (q-- > 0) {
            sum = sum + delta;
            e = sum >>> 2 & 3;
            for (p = 0; p < n; p++) {
                y = v[p + 1];
                z = v[p] += (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y) + (k[p & 3 ^ e] ^ z);
            }
            y = v[0];
            z = v[n] += (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y) + (k[p & 3 ^ e] ^ z);
        }
        return v;
    }

    /**
     * Decrypt data with key.
     *
     * @param v
     * @param k
     * @return
     */
    public int[] decrypt(int[] v, int[] k) {
        int n = v.length - 1;

        if (n < 1) {
            return v;
        }
        if (k.length < 4) {
            int[] key = new int[4];

            System.arraycopy(k, 0, key, 0, k.length);
            k = key;
        }
        int z = v[n], y = v[0], delta = 0x9E3779B9, sum, e;
        int p, q = 6 + 52 / (n + 1);

        sum = q * delta;
        while (sum != 0) {
            e = sum >>> 2 & 3;
            for (p = n; p > 0; p--) {
                z = v[p - 1];
                y = v[p] -= (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y) + (k[p & 3 ^ e] ^ z);
            }
            z = v[n];
            y = v[0] -= (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y) + (k[p & 3 ^ e] ^ z);
            sum = sum - delta;
        }
        return v;
    }

    /**
     * Convert byte array to int array.
     *
     * @param data
     * @param includeLength
     * @return
     */
    private int[] toIntArray(byte[] data, boolean includeLength) {
        int n = (((data.length & 3) == 0) ? (data.length >>> 2) : ((data.length >>> 2) + 1));
        int[] result;

        if (includeLength) {
            result = new int[n + 1];
            result[n] = data.length;
        } else {
            result = new int[n];
        }
        n = data.length;
        for (int i = 0; i < n; i++) {
            result[i >>> 2] |= (0x000000ff & data[i]) << ((i & 3) << 3);
        }
        return result;
    }

    /**
     * Convert int array to byte array.
     *
     * @param data
     * @param includeLength
     * @return
     */
    private byte[] toByteArray(int[] data, boolean includeLength) {
        int n = data.length << 2;

        ;
        if (includeLength) {
            int m = data[data.length - 1];

            if (m > n) {
                return null;
            } else {
                n = m;
            }
        }
        byte[] result = new byte[n];

        for (int i = 0; i < n; i++) {
            result[i] = (byte) ((data[i >>> 2] >>> ((i & 3) << 3)) & 0xff);
        }
        return result;
    }

}
