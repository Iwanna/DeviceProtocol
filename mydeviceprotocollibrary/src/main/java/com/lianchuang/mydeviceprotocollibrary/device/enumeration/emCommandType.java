package com.lianchuang.mydeviceprotocollibrary.device.enumeration;

/**
 * Created by Administrator on 2015/12/16 0016.
 */
public enum emCommandType
{
    /// <summary>
    /// 房间设备读写
    /// </summary>
    Room_Dev(0x0001),                                           //房间设备
    /// <summary>
    /// 房间状态读写
    /// </summary>
    Status(0x0002),                                             //状态
    /// <summary>
    /// 房间组态读写
    /// </summary>
    GroupState(0x0003),                                          //组态、模式
    /// <summary>
    /// 房间RCU读写
    /// </summary>
    Rcu(0x0004),                                                //RCU（房控主机）
    /// <summary>
    /// 房间请求发送
    /// </summary>
    Request(0x0005),                                            //请求
    /// <summary>
    /// 文件传送
    /// </summary>
    Filetransfer(0x0006),                                       //文件传送
	/// <summary>
    /// 文件传送
    /// </summary>
	CommunicationAuthentication(0x0007),                        //通信认证
	/// <summary>
    /// 设备入网
    /// </summary>
	DeviceNetting(0x0008),										//设备入网
	/// <summary>
    /// ping设备
    /// </summary>
	DevicePing(0x0009);											//ping设备

    private final int value;

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    emCommandType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
