package com.zhangbin.cloud.constant;

public class WxRequestUrl {
	/**获取access_token*/
	public static final String ACCESS_TOKEN ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+WxConstants.WX_PUB_APPID+"&secret="+WxConstants.WX_PUB_SECRET;
	/**创建二维码ticket*/
	public static final String QRCODE_CREATE="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
	/**通过ticket换取二维码*/
	public static final String SHOWQRCODE="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
	/**获取微信服务器IP地址*/
	public static final String GETCALLBACKIP="https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=";
	/**自定义创建菜单*/
	public static final String MENU_CREATE="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	/**自定义菜单查询接口*/
	public static final String MENU_GET ="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
}
