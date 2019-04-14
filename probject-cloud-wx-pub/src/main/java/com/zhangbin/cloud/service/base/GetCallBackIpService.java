package com.zhangbin.cloud.service.base;

import java.util.List;

/**获取微信服务器IP地址
 * @author admin
 *
 */
public interface GetCallBackIpService {
	/**
	 * 获取微信服务器IP地址
	 * @return
	 */
	List<String> getCallBackIp();
}
