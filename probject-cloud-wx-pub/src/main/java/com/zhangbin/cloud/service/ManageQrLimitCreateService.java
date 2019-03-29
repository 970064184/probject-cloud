package com.zhangbin.cloud.service;

import com.zhangbin.cloud.domain.wechat.Req.ManageQrLimitCreate;
import com.zhangbin.cloud.domain.wechat.Resp.OutManageQrLimitCreate;

/**生成二维码接口
 * @author admin
 *
 */
public interface ManageQrLimitCreateService {
	/**
	 * 生成二维码接口
	 * @param manageQrLimitCreate
	 * @return
	 */
	OutManageQrLimitCreate create(ManageQrLimitCreate manageQrLimitCreate);
	
	void showqrcode(OutManageQrLimitCreate out);
}
