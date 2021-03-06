package com.zhangbin.cloud.domain.wechat.Req;

/**二维码详细信息
 * @author admin
 *
 */
public class SceneContent {
	/**场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）*/
	private String scene_id;
	/**场景值ID（字符串形式的ID），字符串类型，长度限制为1到64*/
	private String scene_str;
	public String getScene_id() {
		return scene_id;
	}
	public void setScene_id(String scene_id) {
		this.scene_id = scene_id;
	}
	public String getScene_str() {
		return scene_str;
	}
	public void setScene_str(String scene_str) {
		this.scene_str = scene_str;
	}
}
