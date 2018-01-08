package com.lianchuang.mydeviceprotocollibrary.protocol.enumeration;

/**
 * Created by Administrator on 2016/3/4 0004.
 */
public enum emErrorCodeValues {

    OK(0),								//正常
    UnKnownError(300),                  //未知错误
    HostConnectTimeOut(301),            //主机连接超时
    ServerConnectTimeOut(302),			//服务器连接超时
    CameraConnectTimeOut(303),			//服务器连接超时
    UnPermissionWifi(304),              //Wifi未授权
    NotAssignWifi(305),                 //未连接指定Wifi
    UnPermissionCamera(306),            //Camera未授权
    UnPermissionInternet(307),          //internet未授权
    ParameterError(308),                //参数错误
    SocketIOError(309),                 //套接字输入输出错误
    DataCRCError(310),                  //数据校验错误
    UnknownHost(311),					//未知名的主机
    UnknownServer(312),					//未知名的服务器
    SocketIsNull(313),					//套接字为空
    SocketRcvError(314),				//套接字接收错误
    SocketSendError(315),				//套接字发送错误
    DataFormatError(316),               //数据格式错误
    OutDated(317),						//过期入住
    InValidKey(318);					//无效的钥匙


    private final int value;

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    emErrorCodeValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
