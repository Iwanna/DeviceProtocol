package com.lianchuang.mydeviceprotocollibrary.device.enumeration;

/**
 * Created by Administrator on 2016/1/29 0029.
 */
public enum emBulbEffectiveBit {

    Switch(1);

    private final int value;

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    emBulbEffectiveBit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
