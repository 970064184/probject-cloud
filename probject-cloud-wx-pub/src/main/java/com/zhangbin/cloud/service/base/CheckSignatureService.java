package com.zhangbin.cloud.service.base;

/**
 * @author admin
 *
 */
public interface CheckSignatureService {
	
	String checkSignature(String signature, String timestamp, String nonce, String echostr);
}