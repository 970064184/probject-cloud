package com.zhangbin.cloud.test;

/**
 * 适配器
 * （相当于usb和键盘之间的转换器）
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void handleReq() {
        super.request();
    }
}
