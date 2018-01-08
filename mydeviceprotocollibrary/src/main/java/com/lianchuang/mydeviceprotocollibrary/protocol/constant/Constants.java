package com.lianchuang.mydeviceprotocollibrary.protocol.constant;

/**
 * Created by Administrator on 2017/02/14.
 */

public class Constants {

    /////////////////////////////////////////////////////////////////////////////////////////
    //                                    宏定义                                          //
    /////////////////////////////////////////////////////////////////////////////////////////
    public final static String DEV_ALLOW="000c";                                        //允许入网
    public final static String DEV_STOP="000d";                                         //禁止入网
    public final static String DEV_CLEAR="000b";                                        //网络初始化
    /**
     * 包头
     */
    public final static String HEADER = "5A4B";                                        //包头
    /***
     * 包尾
     */
    public final static String TAIL = "7A6B";                                           //包尾
    /**
     * 地址类型
     */
    public final static int AT_MAC = 0x00;                                              //物理地址
    public final static int AT_ID = 0x01;                                               //编号
    public final static int AT_NAME = 0x02;                                             //名称
    public final static int AT_GROUP = 0x03;                                            //组号
    /**
     * 操作类型
     */
    public final static int OT_ACTION = 0x00;                                           //执行
    public final static int OT_ADD = 0x01;                                              //添加
    public final static int OT_MODIFY = 0x02;                                           //修改
    public final static int OT_DELETE = 0x03;                                           //删除
    public final static int OT_CHECK = 0x04;                                            //查看（获取）
    public final static int OT_SET = 0x05;                                              //设置
    public final static int OT_UPLOAD = 0x06;                                           //上传（返回）
    public final static int OT_CLEAR = 0x07;                                            //清空
    public final static int OT_RESET = 0x08;                                            //重置
    /**
     * 设备类型
     */
    public final static int DT_LOCK = 0x00;                                             //门锁
    public final static int DT_GATEWAY = 0x01;                                          //网关
    public final static int DT_CU = 0x02;                                               //主控制器
    public final static int DT_LIGHT = 0x03;                                            //受控设备
    public final static int DT_IT = 0x04;                                               //智能终端
    /**
     * 通信类型
     */
    public final static int CT_WIFI = 0x00;                                             //Wifi通信
    public final static int CT_ZIGBEE = 0x01;                                           //Zigbee通信
    public final static int CT_433 = 0x02;                                              //433通信
    public final static int CT_WIRELESS = 0x03;                                         //2.4G通信
    public final static int CT_BLUETOOTH = 0x04;                                        //蓝牙通信
    public final static int CT_232 = 0x05;                                              //232通信
    /**
     * 指令类型
     */
    public final static int IT_EKEY = 0x00;                                             //电子钥匙
    public final static int IT_PARAM = 0x01;                                            //参数
    public final static int IT_KEYCODE = 0x02;                                          //密码
    public final static int IT_ID = 0x03;                                               //ID
    public final static int IT_OPERATE = 0x04;                                          //操作指令
    public final static int IT_GROUP = 0x05;                                            //组态
    public final static int IT_TIMINGTASK = 0x06;                                       //定时任务
    public final static int IT_REQUEST = 0x07;                                          //请求
    public final static int IT_ALERT = 0x08;                                            //警报
    public final static int IT_DEV_TEST = 0x09;                                         //硬件测试
    public final static int IT_DEV = 0x0a;                                              //设备
    public final static int IT_STATUS = 0x0b;                                           //状态
    public final static int IT_FINGER = 0x0c;                                           //指纹
    public final static int IT_REMOTE = 0x0d;                                           //遥控
    public final static int IT_IDENTITY = 0x0e;                                         //身份证
    public final static int IT_NFC = 0x0f;                                              //NFC
    public final static int IT_KEY = 0x10;                                              //钥匙
    public final static int IT_OPERATE_RESULT = 0x20;                                   //操作结果
    public final static int IT_RECORDER = 0x21;                                         //记录

    public final static int IT_DEVLIST = 0x20;                                          //上传设备列表
    public final static int IT_RCV_DEVLIST = 0x21;                                      //接收设备列表
    public final static int IT_UPLOAD_GROUPFILE = 0x22;                                 //上传组态文件
    public final static int IT_RCV_GROUPFILE = 0x23;                                    //接收组态文件
    public final static int IT_GET_DEVSTATE = 0x24;                                     //获取设备状态
    public final static int IT_GET_DEVPARAM = 0x25;                                     //获取设备参数
    public final static int IT_LOG = 0x26;                                              //上传日志

    public final static int IT_ROOM_DEV_RW = 0x65;                                      //房间设备读写
    public final static int IT_STATUS_RW = 0x66;                                        //状态读写
    public final static int IT_GC_GROUP = 0x67;                                         //组态
    public final static int IT_ROOM_RCU_RW = 0x68;                                      //RCU读写
    public final static int IT_GC_REQUEST = 0x69;                                       //请求(105)
    public final static int IT_TRANSFER_FILE = 0x6a;                                    //文件(106)
    public final static int IT_COMMUNICATION_VERIFY = 0x6b;                             //通信认证(107)
    public final static int IT_DEVICE_NETTING = 0x6c;                                   //设备入网(108)
    public final static int IT_DEVICE_PING = 0x6d;                                      //通信测试(109)
    ///////////////////////////////使用状态/宏定义////////////////////////////////////////////
    public final static int US_NORMAL = 0x00;                                           //正常
    public final static int US_INITIAL = 0x01;                                          //初始化
    public final static int US_STOP = 0x02;                                             //停用
    public final static int US_INPUT = 0x03;                                            //输入
    ///////////////////////////////状态类型/宏定义////////////////////////////////////////////
    public final static int DS_SWITCH = 0x00;                                           //开关状态
    public final static int DS_ENERGY = 0x01;                                           //电量
    public final static int DS_CONNECT = 0x02;                                          //连接状态
    public final static int DS_USERMODE = 0x03;                                         //使用状态
    public final static int DS_ALL = 0xff;                                              //所有状态

    ///////////////////////////////文件代号的枚举/宏定义/////////////////////////////////////
    public final static String MODEMAP_FILE = "0001";                                   //组态文件
    public final static String DEVICE_FILE = "0002";                                    //设备文件
    public final static String KeyMAP_FILE = "0003";                                    //KeyMap文件
    public final static String ROOMINFO = "0004";                                       //房间信息文件
    public final static String ROOMNETINFO = "0005";                                    //房间网络信息文件
    public final static String CONFIG_SAVE = "0006";                                    //主机配置文件
    public final static String GROUPMAP_FILE = "0007";                                  //模式文件
    public final static String TIME_TASK_FILE = "0008";                                 //定时任务文件
    public final static String MQTT_FILE="0009";                                        //Mqtt文件

    ///////////////////////////////服务请求的枚举/宏定义/////////////////////////////////////
    public final static int CHECKOUT = 0x01;                                            //退房请求
    public final static int HELP = 0x02;                                                //请求服务
    public final static int CLEAN = 0x03;                                               //打扫卫生
    public final static int NODISTURB = 0x04;                                           //请勿打扰
    public final static int EMERGENCY = 0x05;                                           //紧急呼救
    public final static int HOLDON = 0x06;

    ///////////////////////////对RCU设置操作的枚举/宏定义/////////////////////////////////////
    public final static String CLIENT_MAC = "0001";                                     //物理地址
    public final static String CLIENT_IP_ADDR = "0002";                                 //IP地址
    public final static String CLIENT_WIFI_PASSWD = "0003";                             //Wifi密码
    public final static String CLIENT_ROOM_NUM = "0004";                                //房间编号
    public final static String CLIENT_RESET = "0005";                                   //路由器重启
    public final static String CLIENT_SSID = "0008";                                    //Wifi名称
    public final static String SERVER_IP_ADDR = "0006";                                 //前台服务器IP
    public final static String SERVER_PORT = "0007";                                    //前台服务器端口号
    public final static String CLIENT_CON_SSID = "000e";                                //桥接wifi名称
    public final static String CLIENT_CON_WIFI_PASSWD = "000f";                         //桥接wifi密码


    ///////////////////////////////通信类型枚举/宏定义/////////////////////////////////////
    public final static String SHAKE_REPLY = "03";                                      //握手回执包
    public final static String SHAKE_APPLY = "02";                                      //申请权限
    public final static String SHAKE_GRANT = "01";                                      //已授权
    public final static String TIME_OUT = "01";                                         //超时
    public final static String SUCCESS = "02";                                          //成功

    ///////////////////////////////数据包各部分起始长度/////////////////////////////////////////////
    /**
     * 包头
     */
    public final static int HeaderStart = 0;
    public final static int HeaderLength = 2;
    /**
     * 数据包长度
     */
    public final static int DataPackageStart = 2;
    public final static int DataPackageLength = 2;
    /**
     * 任务Id
     */
    public final static int TaskIdStart = 4;
    public final static int TaskIdLength = 16;
    /**
     * 操作
     */
    public final static int OperateStart = 20;
    public final static int OperateLength = 1;
    /**
     * 设备类型
     */
    public final static int DeviceTypeStart = 21;
    public final static int DeviceTypeLength = 1;
    /**
     * 子类型
     */
    public final static int SubTypeStart = 22;
    public final static int SubTypeLength = 1;
    /**
     * 通信方式
     */
    public final static int CommunicationStylesStart = 23;
    public final static int CommunicationStylesLength = 1;
    /**
     * 房间寻址
     */
    public final static int AddressingStart = 24;
    public final static int AddressingLength = 4;

    /**
     * 区
     */
    public final static int RegionNoStart = 24;
    public final static int RegionNoLength = 1;

    /**
     * 栋
     */
    public final static int BuildingNoStart = 25;
    public final static int BuildingNoLength = 1;

    /**
     * 层
     */
    public final static int FloorNoStart = 26;
    public final static int FloorNoLength = 1;

    /**
     * 房
     */
    public final static int RoomNoStart = 27;
    public final static int RoomNoLength = 1;


    /**
     * 地址类型
     */
    public final static int AddrTypeStart = 28;
    public final static int AddrTypeLength = 1;

    /**
     * 寻址
     */
    public final static int AddrMapStart = 29;
    public final static int AddrMapLength = 10;
    /**
     * 保留字段
     */
    public final static int ReserveStart = 39;
    public final static int ReserveLength = 4;

    /**
     * 指令类型
     */
    public final static int InstructionTypeStart = 43;
    public final static int InstructionTypeLength = 1;

    /**
     * 内容长度
     */
    public final static int ContentLengthStart = 44;
    public final static int ContentLengths = 2;

    /**
     * 内容
     */
    public final static int ContentStart = 46;



    /**
     * 错误代码
     */
    public final static int ErrorCodeStart = 46;
    public final static int ErrorCodeLengths = 2;

    /**
     * 有效数据
     */
    public final static int ValidDataStart = 48;

    /**
     * CRC校验码
     */
    public final static int CRCLength = 2;

    /**
     * 包尾
     */
    public final static int TailLength = 2;

    /**
     * 除内容字段外的总长度
     * ContentStart + CRCLength + TailLength
     */

    public final static int TotalLength = 50;
}
