package cn.tsh.study.util;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class RSAUtil {

	/**
	 * 加密算法RSA
	 */
	private static final String KEY_ALGORITHM = "RSA";

	/**
	 * RSA最大加密明文大小
	 */
	private static final int MAX_ENCRYPT_BLOCK = 117;

	/**
	 * RSA最大解密密文大小
	 */
	private static final int MAX_DECRYPT_BLOCK = 128;

	/**
	 * Method: decryptBASE64 <br/>
	 * description: 解码返回byte <br/>
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	/**
	 * Method: encryptBASE64 <br/>
	 * description: 编码返回字符串 <br/>
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	/**
	 * 获取base64加密后的字符串的原始公钥
	 *
	 * @param keyStr
	 * @return
	 * @throws Exception
	 */
	public static Key getPublicKeyFromBase64KeyEncodeStr(String keyStr) throws Exception {
		byte[] keyBytes = decryptBASE64(keyStr);
		// 取得公钥
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		Key publicKey = KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(x509KeySpec);
		return publicKey;
	}

	/**
	 * 获取base64加密后的字符串的原始私钥
	 *
	 * @param keyStr
	 * @return
	 * @throws Exception
	 */
	public static Key getPrivateKeyFromBase64KeyEncodeStr(String keyStr) throws Exception {
		byte[] keyBytes = decryptBASE64(keyStr);
		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		Key privateKey = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(pkcs8KeySpec);
		return privateKey;
	}

	/**
	 * Method: encrypt <br/>
	 * description: 公钥分段加密 <br/>
	 *
	 * @param dataStr
	 *            加密内容，明文
	 * @param publicKeyStr
	 *            公钥内容
	 * @return 密文
	 * @throws Exception
	 */
	public static String encrypt(String dataStr, String publicKeyStr) throws Exception {
		System.out.println("公钥分段加密开始");
		ByteArrayOutputStream out = null;
		String encodedDataStr = null;
		try {
			out = new ByteArrayOutputStream();
			byte[] data = dataStr.getBytes("utf-8");
			// 获取原始公钥
			Key decodePublicKey = getPublicKeyFromBase64KeyEncodeStr(publicKeyStr);
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, decodePublicKey);
			int inputLen = data.length;
			int offSet = 0;
			byte[] cache;
			int i = 0;
			// 对数据分段加密
			while (inputLen - offSet > 0) {
				if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
					cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
				} else {
					cache = cipher.doFinal(data, offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * MAX_ENCRYPT_BLOCK;
			}
			byte[] encryptedData = out.toByteArray();
			encodedDataStr = new String(encryptBASE64(encryptedData));
			System.out.println("公钥分段加密完毕");
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				out.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return encodedDataStr;
	}

	/**
	 * Method: encrypt <br/>
	 * description: 私钥分段解密 <br/>
	 *
	 * @param content
	 *            解密内容，密文
	 * @param privateKeyStr
	 *            私钥
	 * @return 明文
	 * @throws Exception
	 */
	public static String decrypt(String dataStr, String PrivateKey) throws Exception {
		System.out.println("私钥分段解密处理开始");

		ByteArrayOutputStream out = null;
		String decodedDataStr = null;
		try {
			out = new ByteArrayOutputStream();

			byte[] encryptedData = decryptBASE64(dataStr);
			// 获取原始私钥
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			Key decodePrivateKey = getPrivateKeyFromBase64KeyEncodeStr(PrivateKey);
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, decodePrivateKey);
			int inputLen = encryptedData.length;

			int offSet = 0;
			byte[] cache;
			int i = 0;
			// 对数据分段解密
			while (inputLen - offSet > 0) {
				if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
					cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
				} else {
					cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * MAX_DECRYPT_BLOCK;
			}
			byte[] decryptedData = out.toByteArray();
			decodedDataStr = new String(decryptedData, "utf-8");
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				out.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return decodedDataStr;
	}

}
