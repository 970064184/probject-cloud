package com.zhangbin.cloud.controller.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.domain.menu.OutWxMenu;
import com.zhangbin.cloud.domain.menu.WxMenu;
import com.zhangbin.cloud.domain.wechat.Req.WxXmlMessage;
import com.zhangbin.cloud.service.WeChatService;
import com.zhangbin.cloud.service.base.CheckSignatureService;
import com.zhangbin.cloud.service.menu.WxMenuButtonService;

/**微信入口
 * @author admin
 *
 */
@RestController
@RequestMapping("/restaurant-store/wechat")
public class WeChatController {
	
private static final Logger logger = LoggerFactory.getLogger("STORE");
	
	@Autowired
	private CheckSignatureService checkSignatureService;
	
	@Autowired
	private WeChatService weChatService;
	
	@Autowired
	private WxMenuButtonService wxMenuButtonService;
	
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
//		String convertToXml = JaxbUtil.convertToXml(obj);
		return obj;
	}
	
	@PostMapping(value="/createMenu",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void createMenu(@RequestBody WxMenu menu) {
		wxMenuButtonService.createMenu(menu);
	}
	
	@GetMapping(value = "/getMenu",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getMenu() {
		String menu = wxMenuButtonService.getMenu();
		return menu;
	}
	
}
