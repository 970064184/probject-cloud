package com.zhangbin.cloud.controller.wechat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.controller.wechat.service.CheckSignatureService;
import com.zhangbin.cloud.controller.wechat.service.WeChatService;

/**微信入口
 * @author admin
 *
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {
	
	private static final Logger logger = LoggerFactory.getLogger("STORE");
	
	@Autowired
	private RestTemplate restTemplate;
	
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
	
	@PostMapping(value="/checkSignature")
	public Object handler(@RequestBody WxXmlMessage wxXmlMessage)throws Exception{
		System.out.println(wxXmlMessage);
		Object obj= weChatService.handler(wxXmlMessage);
		return obj;
	}
	
	@RequestMapping(value="/receive",produces = "application/xml; charset=UTF-8")
	public void receive(HttpServletRequest request,HttpServletResponse response) throws Exception{
		/*String appid="wx089ca44287fedfb6";
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret=ac1922e1292095af88aef4488c5a5acf";
		ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(url, JSONObject.class);
		JSONObject body = forEntity.getBody();
		String accessToken = body.get("access_token").toString();*/
		String accessToken = "19_lYCj7hMVdIDCMAq33DuIZ7FZ7f73PdJZF8ronINzYq71fsjj4ZD3rFcz54PcvlW6ymiXS762sCk0PGtz4RBNl8UK6KIcrWNn8jBWe8Dj0AEYOi1udZXLNz3U_XdvdDIHERNb4noOX54_tCadQHGgAHABSR";
		logger.info("被动回复消息");
		String purl="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+accessToken;
		Map<String, Object> resMap = new HashMap<>();
		Map<String, Object> action_info = new HashMap<>();
		Map<String, Object> scene = new HashMap<>();
		scene.put("scene_id", "123");
		action_info.put("scene", scene);
		resMap.put("action_name", "QR_LIMIT_SCENE");
		resMap.put("action_info",action_info);
		ResponseEntity<JSONObject> postForEntity = restTemplate.postForEntity(purl, resMap, JSONObject.class);
		logger.info("模板消息发送返回值："+postForEntity);
		response.getWriter().println(postForEntity);
	}
	/**
	 * 模板消息
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	private void sendTemplateMsg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*String appid="wx79c9efd918cb0972";
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret=f9d45e59e3e159c045e4c69b2333bad6";
		ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(url, JSONObject.class);
		JSONObject body = forEntity.getBody();
		String accessToken = body.get("access_token").toString();*/
		String accessToken = "19_lYCj7hMVdIDCMAq33DuIZ7FZ7f73PdJZF8ronINzYq71fsjj4ZD3rFcz54PcvlW6ymiXS762sCk0PGtz4RBNl8UK6KIcrWNn8jBWe8Dj0AEYOi1udZXLNz3U_XdvdDIHERNb4noOX54_tCadQHGgAHABSR";
		logger.info("被动回复消息");
		InputStream inputStream = request.getInputStream();
		String strXML = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"))
		        .lines().collect(Collectors.joining(System.lineSeparator()));
		Map<String, String> map = XMLUtil.xmlToMap(strXML);
		logger.info("被动回复消息，传入参数："+map);
		String toUserName = map.get("ToUserName").toString();//开发者微信号
        String fromUserName = map.get("FromUserName").toString();//发送方帐号（一个OpenID）
        String createTime = map.get("CreateTime").toString();//消息创建时间 （整型）
		Map<String, Object> resMap = new HashMap<>();
		Map<String, Object> miniprogram = new HashMap<>();
		Map<String, Object> data = new HashMap<>();
		resMap.put("touser", fromUserName);
		String templateId="AjDGtIJBASE49Yxbx9dm11Jj5kt2bA7TrsqRgnaCBp0";
		resMap.put("template_id", templateId);
		miniprogram.put("appid", "/pages/customer/list/list");
		resMap.put("miniprogram", miniprogram);
		Map<String, Object> result = new HashMap<>();
		result.put("value", "恭喜你购买成功！");
		result.put("color", "#173177");
		data.put("first", result);
		resMap.put("miniprogram", data);
		logger.info("被动回复消息，传入参数："+resMap);
		String purl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken;
		ResponseEntity<JSONObject> postForEntity = restTemplate.postForEntity(purl, resMap, JSONObject.class);
		logger.info("模板消息发送返回值："+postForEntity);
		/*String xml ="<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
		 response.setHeader("Content-type", "application/xml;charset=UTF-8");  
	        response.setCharacterEncoding("UTF-8");  
		response.getWriter().println(xml);*/
		
	}
	/**
	 * 被动回复文本
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void sentMsg(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("被动回复消息");
		InputStream inputStream = request.getInputStream();
		String strXML = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"))
		        .lines().collect(Collectors.joining(System.lineSeparator()));
		Map<String, String> map = XMLUtil.xmlToMap(strXML);
		logger.info("被动回复消息，传入参数："+map);
		String toUserName = map.get("ToUserName").toString();//开发者微信号
        String fromUserName = map.get("FromUserName").toString();//发送方帐号（一个OpenID）
        String createTime = map.get("CreateTime").toString();//消息创建时间 （整型）
        String msgType = map.get("MsgType").toString();//消息类型
//        String event = map.get("Event").toString();//事件类型，SCAN
//        String eventKey = map.get("EventKey").toString();//事件KEY值，qrscene_为前缀，后面为二维码的参数值
//        String ticket = map.get("Ticket").toString();//二维码的ticket，可用来换取二维码图片
        String content = "";//消息内容
        
        
        String resContent ="<a data-miniprogram-appid=\"wx4d9e4415bbb1ffab\" data-miniprogram-path=\"pages/customer/list/list\""+content+"href=\"http://www.qq.com\">智慧餐厅小程序</a>";
        String resXmlStr="<xml><ToUserName><![CDATA["+fromUserName+"]]></ToUserName>" +//此处要填写 发送方帐号（一个OpenID）
                "<FromUserName><![CDATA["+toUserName+"]]></FromUserName>" +//此处填写开发者微信号
                "<CreateTime>"+createTime+"</CreateTime>" +
                "<MsgType><![CDATA["+msgType+"]]></MsgType>"+
                "<Content><![CDATA["+resContent+"]]></Content></xml>";
        logger.info("被动回复消息，响应参数："+resXmlStr);
        response.setHeader("Content-type", "application/xml;charset=UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        response.getWriter().println(resXmlStr);
	}
	

}
