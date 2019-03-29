package com.zhangbin.cloud.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.constant.WxConstants;
import com.zhangbin.cloud.service.GetAccessToken;
@Service
public class GetAccessTokenImpl implements GetAccessToken{
	
	private static final Logger logger = LoggerFactory.getLogger("STORE");
	
	@Override
	public String getAccessToken() {
		logger.info("获取access_token接口");
		String redisKey = WxConstants.SRT_SHOP_WX_ACCESS_TOKEN;
		String accessToken="20_6c2KxDUqY28W6W9jvOMVPADzoS2Rj3KmTMU9X7xAjehzqQlzj5ZQjKUmgPYVtddINDN4XTBoNAyyATCHPBlfMU7BxsQINdp2FMy1mx49Yb-4pUMcYJ7dQhf_QKYBWXjAGAGBC";
		/*try {
			accessToken = jedisCluster.get(WxKey.token,redisKey,String.class);
			logger.info("获取redis上的access_token：",accessToken);
			if("".equals(accessToken)){
				logger.info("请求微信获取access_token：",accessToken);
				String appid=WxConstants.WX_PUB_APPID;
				String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+WxConstants.WX_PUB_SECRET;
				ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(url, JSONObject.class);
				logger.info("请求微信获取access_token返回值",forEntity);
				JSONObject body = forEntity.getBody();
				accessToken = body.get("access_token").toString();
				jedisCluster.set(WxKey.token,redisKey, accessToken);
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
