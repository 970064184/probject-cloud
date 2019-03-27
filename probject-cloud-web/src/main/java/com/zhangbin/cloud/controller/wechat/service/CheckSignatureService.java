package com.zhangbin.cloud.controller.wechat.service;

public interface CheckSignatureService {
	
	String checkSignature(String signature, String timestamp, String nonce, String echostr);
}