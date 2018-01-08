package com.lianchuang.mydeviceprotocollibrary.device.enumeration;

/**
 * Created by Administrator on 2017/03/29.
 */

public enum emIREffectiveBit {
    Switch(1);

    private final int value;

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    emIREffectiveBit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
