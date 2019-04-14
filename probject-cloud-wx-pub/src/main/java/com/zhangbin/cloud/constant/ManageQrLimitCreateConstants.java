package com.zhangbin.cloud.constant;

public enum ManageQrLimitCreateConstants {
	
	SCENE_STR("scene_str"),
	SCENE_ID("scene_id");
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private ManageQrLimitCreateConstants(String value) {
		this.value = value;
	}
	public static void main(String[] args) {
		String value2 = ManageQrLimitCreateConstants.SCENE_STR.value;
		System.out.println(value2);
	}
}
