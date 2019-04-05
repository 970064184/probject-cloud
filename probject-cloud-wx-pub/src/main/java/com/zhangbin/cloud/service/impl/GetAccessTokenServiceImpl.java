package com.zhangbin.cloud.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.conf.redis.RedisService;
import com.zhangbin.cloud.constant.WxConstants;
import com.zhangbin.cloud.constant.WxRequestUrl;
import com.zhangbin.cloud.domain.wechat.WxKey;
import com.zhangbin.cloud.service.base.GetAccessTokenService;
@Service
public class GetAccessTokenServiceImpl implements GetAccessTokenService{
	
	private static final Logger logger = LoggerFactory.getLogger("STORE");
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RedisService redisService;
	
	@Override
	public String getAccessToken() {
		logger.info("获取access_token接口");
		String redisKey = WxConstants.SRT_SHOP_WX_ACCESS_TOKEN;
		String accessToken="20_F05g_LL_mb7FAajVbMvKgs7pP7cw2N0RBffhKFo-StUQUIN03SVK0y4zCw_-XIUHUYA0Wo7R4wUXvq_1Z1t7ZGJ8fTIbp_F4kTN299yamts0YBBdM0zEiqssY6Hr_fpWWGZ4wpBYStl-0JKcNMYfAFAEDP";
		/*try {
			accessToken = redisService.get(WxKey.token,redisKey,String.class);
			logger.info("获取redis上的access_token：",accessToken);
			if("".equals(accessToken)){
				logger.info("请求微信获取access_token：",accessToken);
				String appid=WxConstants.WX_PUB_APPID;
//				String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+WxConstants.WX_PUB_SECRET;
				ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(WxRequestUrl.ACCESS_TOKEN, JSONObject.class);
				logger.info("请求微信获取access_token返回值",forEntity);
				JSONObject body = forEntity.getBody();
				accessToken = body.get("access_token").toString();
				redisService.set(WxKey.token,redisKey, accessToken);
			}
			logger.info("获取access_token：",accessToken);
			return accessToken;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取access_token接口异常");
		}*/
		return accessToken;
	}

}
