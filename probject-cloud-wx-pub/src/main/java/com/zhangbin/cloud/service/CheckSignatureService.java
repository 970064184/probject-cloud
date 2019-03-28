package com.zhangbin.cloud.service;

public interface CheckSignatureService {
	
	String checkSignature(String signature, String timestamp, String nonce, String echostr);
}