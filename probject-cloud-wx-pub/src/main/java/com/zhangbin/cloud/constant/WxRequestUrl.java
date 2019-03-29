package com.zhangbin.cloud.constant;

public class WxRequestUrl {
	/**创建二维码ticket*/
	public static final String QRCODE_CREATE="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
	/**通过ticket换取二维码*/
	public static final String SHOWQRCODE="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
}
