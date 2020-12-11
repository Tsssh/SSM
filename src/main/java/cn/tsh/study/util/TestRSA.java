package cn.tsh.study.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestRSA {
	public static void main(String[] args) throws Exception {
		// 公钥
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC+t++y0BfuYVvtVP4hBZP8jJjwBeCsOlKsn5Oa+2xVi6z20IPv8FMkh++B53UIpI7sqH2BLvS8Ore0lRDK3BRCx1orI/JMjnZeB7IabgQkorsDrH17kOopObcbrgGovvmiFGqJYN9w3cwtP9mUnd07p/4Shmh5lbShAXVT6FUcIwIDAQAB";
		// 私钥
		String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAL6377LQF+5hW+1U/iEFk/yMmPAF4Kw6Uqyfk5r7bFWLrPbQg+/wUySH74HndQikjuyofYEu9Lw6t7SVEMrcFELHWisj8kyOdl4HshpuBCSiuwOsfXuQ6ik5txuuAai++aIUaolg33DdzC0/2ZSd3Tun/hKGaHmVtKEBdVPoVRwjAgMBAAECgYA9vBCNEysL8Nvu4Ro52jJjB6fh2iU12tM0KZuACW6x6jqc0jZDDsn7Az2WETQjDhFtrcSicm6qF1+rxqze3Yp43Co3ZFmXv0hYo2aQ1onTFUdWp7nmDomLFL9+zOCxh2LHISFQx7No/6KXOWYypyegwM2Fxo2w4iDkvZnDg2G+IQJBAORYQpxMs/OXIvp3MY2QD05dAVJqUqGbWBeGZYEp2yTVqAeZgu8Y+0Y5a92kbL2RYCu/jZZb2nbANWPsUpYVjlsCQQDV0RarTneyyeVyp67qURFoCDvzAv34HzowkVqHsXjKblSbEBdNcyMJqhVlz4v4yjq3hDbV/Wxd/4MRkfhOGyPZAkAn3OScBqPvpXXcxcwny3twkbn2WktcnRLu4G598wGn14jC8uCxvum247VZ9ydonKVuXb1o/1YPHxTzAcGVI+Q7AkBksDfqp+L6UNU6LvjR4yc9RFNm1sveYmY2pNxq9goZ2ecBtowirsubK3s0HI6ftCv+a8ae8t5rTX3dck3qCiHRAkAcbuNkhJmu2Ms8PobAE6XPu2Sot1qo1UbAPOUjVMFviicPnMZQ7LiYRrOaOTox6zZrpmcj70tjV+OwIjTMFR7c";

		/**
		 * 加密及获取签名
		 */
		// 源报文(未加密)
		String msg = "加密ABC123测试";

		// 公钥加密得到密文并使用base64处理
		String enc_msg = RSAUtil.encrypt(msg, publicKey);
		BASE64Encoder encoder = new BASE64Encoder();
		enc_msg = encoder.encode(enc_msg.getBytes("UTF-8"));
		enc_msg = enc_msg.replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");
		System.out.println("加密密文："+enc_msg);

		// 根据源报文+私钥获得MD5签名
		String mac_info = MD5Util.getMD5(msg + privateKey);
		System.out.println("加密签名："+mac_info);

		/**
		 * 解密及验签
		 */
		// base64逆处理并用私钥解密
		BASE64Decoder decoder = new BASE64Decoder();
		enc_msg = new String(decoder.decodeBuffer(enc_msg), "UTF-8");
		String dec_msg = RSAUtil.decrypt(enc_msg, privateKey);
		System.out.println("解密明文："+dec_msg);


		// 验签
		String dec_mac = MD5Util.getMD5(dec_msg + privateKey);
		System.out.println("解密签名："+dec_mac);

		if (mac_info.equals(dec_mac)) {
			System.out.println("验签通过");
		} else {
			System.out.println("验签失败");
		}

	}
}
