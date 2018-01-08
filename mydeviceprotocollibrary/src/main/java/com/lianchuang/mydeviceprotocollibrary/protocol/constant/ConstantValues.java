package com.lianchuang.mydeviceprotocollibrary.protocol.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2015/12/14 0014.
 */
/// <summary>
/// 灯泡有效位
/// </summary>



public class ConstantValues {
    /////////////////////////////////////////////////////////////////////////////////////////
    //                                    宏定义                                         //
    /////////////////////////////////////////////////////////////////////////////////////////
	public final static boolean SHOW_TOAST=true;                                        //显示吐司
    public final static int SRC_ZIGBEE=0;                                               //Zigbee
    public final static int SRC_GUEST=1;                                                //客人手机
    public final static int SRC_STAFF=2;                                                //工作人员手机
    public final static int SRC_CLOUD=3;                                                //云端
    public final static int SRC_FRONT=4;                                                //前端PC
    ///////////////////////////////读写标志的枚举/宏定义/////////////////////////////////////
    public final static int READ_DATA = 0x00;                                          //读取
    public final static int WRITE_DATA = 0x01;                                         //设置、写入
    public final static int RECEIPT = 0x02;                                            //回执

    ///////////////////////////////命令类型的枚举/宏定义/////////////////////////////////////
    public final static int ROOM_DEV = 0x0001;                                           //房间设备
    public final static int ROOMSTATUS = 0x0002;                                     //状态
    public final static int GROUPSTATUS = 0x0003;                                   //组态、模式
    public final static int ROOMRCU = 0x0004;                                           //RCU（房控主机）
    public final static int REQUEST = 0x0005;                                             //请求
    public final static int FILETRANSFER = 0x0006;                                 //文件传送
    public final static int PICKERPOWER=0x0007;										//取电
    public final static int DEVICENETTING=0x0008;										//设备入网
    public final static int DEVICEPING=0x0009;											//ping设备
    

    ///////////////////////////////设备类型的枚举/宏定义/////////////////////////////////////
    public final static int LED_DEV = 0x01;                                            //灯
    public final static int AIR_DEV = 0x02;                                            //空调
    public final static int BEEP_DEV = 0x03;                                           //门铃
    public final static int TOUCH_DEV = 0x04;                                          //床头面板
    public final static int WIN_DEV = 0x05;                                            //窗帘
    public final static int PRO_DEV = 0x06;                                            //人员计数器
    public final static int POW_DEV = 0x07;                                            //总闸

    ///////////////////////////////房间状态的枚举/宏定义/////////////////////////////////////
    public final static int CYCLE_STATUS = 0x01;                                       //定时状态
    public final static int TEMPORARY_STATUS = 0x02;                                   //临时状态
    public final static int RESIDE_STATUS = 0x03;                                      //入住状态
    public final static int EMERGENCY_STATUS = 0x04;                                   //紧急状态

    ///////////////////////////对RCU设置操作的枚举/宏定义/////////////////////////////////////
    public final static String CLIENT_MAC = "0001";                                         //物理地址
    public final static String CLIENT_IP_ADDR = "0002";                                     //IP地址
    public final static String CLIENT_WIFI_PASSWD = "0003";                                 //Wifi密码
    public final static String CLIENT_ROOM_NUM = "0004";                                    //房间编号
    public final static String CLIENT_RESET = "0005";                                       //路由器重启
    public final static String CLIENT_SSID = "0008";                                       //Wifi名称
    public final static String SERVER_IP_ADDR="0006";
    public final static String SERVER_PORT="0007";
    public final static String CLIENT_CON_SSID="000e";
    public final static String CLIENT_CON_WIFI_PASSWD="000f";

    ///////////////////////////////服务请求的枚举/宏定义/////////////////////////////////////
    public final static int CHECKOUT = 0x01;                                           //退房请求
    public final static int HELP = 0x02;                                               //请求服务
    public final static int CLEAN = 0x03;                                              //打扫卫生
    public final static int NODISTURB = 0x04;                                          //请勿打扰
    public final static int EMERGENCY = 0x05;                                          //紧急呼救
    public final static int HOLDON = 0x06;                                             //请稍后

    ///////////////////////////////文件代号的枚举/宏定义/////////////////////////////////////
    public final static String MODEMAP_FILE = "0001";                                   //组态文件
    public final static String DEVICE_FILE = "0002";                                    //设备文件
    public final static String KeyMAP_FILE = "0003";                                    //KeyMap文件
    public final static String ROOMINFO="0004";											//房间信息文件
    public final static String ROOMNETINFO="0005";									    //房间网络信息文件
    public final static String CONFIG_SAVE="0006";										//主机配置文件
    public final static String GROUP_FILE="0007";										//模式文件
    public final static String TIME_TASK_FILE="0008";                                   //模式时间文件
    public final static String MQTT_FILE="0009";                                        //Mqtt文件

    public final static String HEADER = "242526";                                        //包头$%&
    public final static String TAIL = "232526";                                          		//结束#%&

    ///////////////////////////////数据包各部分起始长度/////////////////////////////////////
    public final static int HeaderStart = 0;
    public final static int PackageLengthStart = 3;
    public final static int WRFlagStart = 5;
    public final static int CommandTypeStart = 6;
    public final static int AddressingStart = 8;
    public final static int HotelNoStart = 8;
    public final static int RegionNoStart = 12;
    public final static int BuildindNoStart = 13;
    public final static int FloorNoStart = 14;
    public final static int RoomNoStart = 15;
    public final static int SessionidStart = 16;
    public final static int CheckinFlagStart = 18;

    public final static int SrcDevStart = 20;

    public final static int DataLengthStart = 21;
    public final static int ErrorCodeStart = 23;
    public final static int ValidDataStart = 25;

    public final static int MacLength = 6;
    public final static int IPLength = 4;
    public final static int WifiCodeLength = 16;
    public final static int RoomInfoLength = 8;

    public final static int SrcDevLength = 1;

    public final static int HeadLength = 3;
    public final static int DataPackageLength = 2;
    public final static int WRFlagLength = 1;
    public final static int CommandTypeLength = 2;
    public final static int AddressingLength = 8;
    public final static int HotelNoLength = 4;
    public final static int RegionNoLength = 1;
    public final static int BuildindNoLength = 1;
    public final static int FloorNoLength = 1;
    public final static int RoomNoLength = 1;
    public final static int SessionidLength = 2;
    public final static int CheckinFlagLength = 2;
    public final static int DataLength = 2;
    public final static int ErrorCodeLength = 2;
    public final static int CRCcodeLength = 2;
    public final static int TailLength = 3;
    public final static int TotalLength = 22;
    public static String ServerIP = "192.168.0.189";

    //***********************AUDIO*****************************//
    public static String Header="RIFF";
    public static String WaveFlag="WAVE";
    public static String FmtFlag="fmt ";
    public static String DataFlag="data";

    public static int SwitchOn=1;
    public static int SwitchOff=0;

    public static int MaxTemp=32;
    public static int MinTemp=15;
    
    public final static String DEV_CHANNEL_ID="000a";
    public final static String DEV_ALLOW="000c";
    public final static String DEV_PAD_ID="0009";
    public final static String DEV_STOP="000d";
    public final static String DEV_CLEAR="000b";
    public final static String DEV_JOIN="000e";
    
    
    
    public final static  int RegionNum=3;
    public final static  int BuildNum=10;
    public final static  int FloorNum=10;
    public final static  int RoomNum=10;

    public final static String hotelNum="hotel_num";
    public final static String hotelArea="in_area";
    public final static String hotelBuild="in_building";
    public final static String hotelTier="in_tier";
    public final static String hotelRoom="in_room";
    public final static String hotelServerIP="server_ip";
    public final static String hotelPort="ip_port";
    public final static String hotelSoundIP="sound_ip";
    public final static String hotelMasteryTime="get_mastery_time";
    public final static String hotelCheckOnLineTime="g_check_linein_time";
    public final static String hotelTouchTakePowerTime="g_touch_take_power_time";
    public final static String hotelTouchPowerCondition="draw_power_condition";
    public final static String hotelTakePowerCondition="take_power_condition";
    public final static String hotelCheckPowerCondition="check_power_condition";
    public final static String hotelAllowControlDev="allow_control_dev";
    public final static String hotelPhone="phone";
    public final static String hotelSleepMode="sleep_mode";
    public final static String hotelLock="lock";
    public final static String hotelTouch="touch";
    public final static String hotelOpenDoor="open_door";

    public final static int UpdateFileLength = 896;

    //***********************Register*****************************//
    /**
     * 保存id用的集合
     */
    public static Set<String> idSet = new HashSet<String>();
    
    public static Set<String> keySet=new HashSet<String>();

    public  static String id="";

    public  static String flag="";
    /**
     * 回显服务端返回的数据
     */
    public static String tips ="";
}
