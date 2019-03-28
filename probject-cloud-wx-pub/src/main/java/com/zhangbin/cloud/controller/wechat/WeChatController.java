package com.zhangbin.cloud.controller.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.domain.wechat.WxXmlMessage;
import com.zhangbin.cloud.service.CheckSignatureService;
import com.zhangbin.cloud.service.WeChatService;

/**微信入口
 * @author admin
 *
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {
	
private static final Logger logger = LoggerFactory.getLogger("STORE");
	
	@Autowired
	private CheckSignatureService checkSignatureService;
	
	@Autowired
	private WeChatService weChatService;
	
	@GetMapping(value="/checkSignature")
	@ResponseBody
	public String checkSignature(String signature,String timestamp,String nonce,String echostr)throws Exception{
		String result = checkSignatureService.checkSignature(signature,timestamp,nonce,echostr);
		return result;
	}
	
	@PostMapping(value="/checkSignature",produces="application/xml; charset=UTF-8")
	@ResponseBody
	public Object handler(@RequestBody WxXmlMessage wxXmlMessage)throws Exception{
		logger.info("微信消息，传入参数："+wxXmlMessage);
		Object obj= weChatService.handler(wxXmlMessage);
		return obj;
	}
}
