package com.lianchuang.mydeviceprotocollibrary.device.enumeration;

/**
 * Created by Administrator on 2015/12/16 0016.
 */
public enum emTvEffectiveBit
{
    Switch(1),
    Channel(2),
    Volume(3);

    private final int value;

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    emTvEffectiveBit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}