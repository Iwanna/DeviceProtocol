package com.lianchuang.mydeviceprotocollibrary.protocol.enumeration;

/**
 * Created by Administrator on 2015/9/6 0006.
 */
public class MyEnum {
  
	/**
     * 节点类型，即区域，楼栋，楼层，房间，房间类型
     */
    public enum NodeType {
        GROUP(0), DEVICE(1),TASK(2);

        private int value = 0;

        NodeType(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }
    
    /**
     * 动作类型:
     */
    public enum ActionType {
        ADD(1), DELETE(2), QUERY(3), UPDATE(4);

        private int value = 0;

        ActionType(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        public static ActionType valueOf(int value) { //  从int到enum的转换函数
            switch (value) {
                case 1:
                    return ADD;
                case 2:
                    return DELETE;
                case 3:
                    return QUERY;
                case 4:
                    return UPDATE;
                default:
                    return null;
            }
        }
    }

    /*
    连接类型
     */
    public enum ConType{
        ROOTHOST(1),HOST(2),SERVER(3),CAMERA(4);

        private int value = 0;

        ConType(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        public static ConType valueOf(int value) { //  从int到enum的转换函数
            switch (value) {
                case 1:
                    return ROOTHOST;
                case 2:
                    return HOST;
                case 3:
                    return SERVER;
                case 4:
                    return CAMERA;
                default:
                    return null;
            }
        }
    }

    /**
     * 指令类型
     */
    public enum InstrumentType{
        IT_ROOM_DEV_RW(0x65),                                            //房间设备读写
        IT_STATUS_RW(0x66),                                              //状态读写
        IT_GC_GROUP(0x67),                                               //组态
        IT_ROOM_RCU_RW(0x68),                                            //RCU读写
        IT_COMMUNICATION_VERIFY(0x69),                                   //通信认证
        IT_GC_REQUEST(0x6a),                                             //请求
        IT_TRANSFER_FILE(0x6b),                                          //文件
        IT_DEVICE_NETTING(0x6c),                                         //设备入网
        IT_DEVICE_PING(0x6d);                                            //通信测试
        private int value = 0;

        InstrumentType(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    public enum emDevicesType
    {
        /**
         * 组态
         */
        Group(0),
        /**
        * 灯
        * */
        Bulb(1),
        /**
        * 中央空调
        * */
        CenterAir(2),
        /**
        * 门铃
        * */
        DoorBell(3),
        /**
        * 灯
        * */
        Lamp(4),
        /**
        * 窗帘
        * */
        Curtain(5),
        /**
        * 人员计数器
        * */
        FootPrint(6),
        /**
        * 空调
        * */
        Air(7),
        /**
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
        * 排气扇
        * */
        ExhaustFan(1),
        /**
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

        public static emDevicesType valueOf(int value){
            switch (value){
                case 0:
                    return Group;
                case 1:
                    return Bulb;
                case 2:
                    return CenterAir;
                case 3:
                    return DoorBell;
                case 4:
                    return Lamp;
                case 5:
                    return Curtain;
                case 6:
                    return FootPrint;
                case 7:
                    return Air;
                case 8:
                    return Tv;
                case 9:
                    return Body_IR;
                case 10:
                    return Lock;
                case 16:
                    return RemoteSwitch;
                default:
                    return null;
            }
        }
    }
}
