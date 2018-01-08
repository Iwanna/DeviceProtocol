package com.lianchuang.mydeviceprotocollibrary.device.enumeration;

/**
 * Created by Administrator on 2015/12/16 0016.
 */
public enum emDevicesType
{
	/*
	 * 组态
	 */
	Group(0),
    /*
    * 不可调光灯
    * */
    Bulb(1),
    /*
    * 中央空调
    * */
    CenterAir(2),
    /*
    * 门铃
    * */
    DoorBell(3),
    /*
    * 可调光灯
    * */
    Lamp(4),
    /*
    * 窗帘
    * */
    Curtain(5),
    /*
    * 人员计数器
    * */
    FootPrint(6),
    /*
    * 空调
    * */
    Air(7),
    /*
    * 电视
    * */
    Tv(8),
    /**
     * 红外
     */
    Body_IR(9),
    /**
     * 门锁
     */
    Lock(10),
    /**
     * 透传蓝牙
     */
    Bluetooth(11),
    /*
     *远程开关 
     */
    RemoteSwitch(16);
    

    private final int value;

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    emDevicesType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}