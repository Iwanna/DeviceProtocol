package com.lianchuang.mydeviceprotocollibrary.protocol;


import com.lianchuang.mydeviceprotocollibrary.protocol.constant.Constants;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class ProtocolStructure {
    /**
     * 包长度
     */
    public SuperUnit DataPackage = new SuperUnit(Constants.DataPackageStart, Constants.DataPackageLength);
    /**
     * 任务Id
     */
    public SuperUnit TaskId = new SuperUnit(Constants.TaskIdStart, Constants.TaskIdLength);
    /**
     * 操作
     */
    public SuperUnit Operate=new SuperUnit(Constants.OperateStart,Constants.OperateLength);
    /**
     * 设备类型
     */
    public SuperUnit DevType=new SuperUnit(Constants.DeviceTypeStart,Constants.DeviceTypeLength);
    /**
     * 子类型
     */
    public SuperUnit SubType=new SuperUnit(Constants.SubTypeStart,Constants.SubTypeLength);
    /**
     * 通信方式
     */
    public  SuperUnit CommunicationStyle=new SuperUnit(Constants.CommunicationStylesStart,Constants.CommunicationStylesLength);
    /**
     * 寻址
     */
    public SuperUnit Addressing=new SuperUnit(Constants.AddressingStart,Constants.AddressingLength);
    /**
     * 区栋层房号
     */
    public Addresses Address = new Addresses();

    /**
     * 地址类型
     */
    public SuperUnit AddrType=new SuperUnit(Constants.AddrTypeStart,Constants.AddrTypeLength);
    /**
     * 寻址
     */
    public SuperUnit AddrMap=new SuperUnit(Constants.AddrMapStart,Constants.AddrMapLength);
    /**
     * 保留字段
     */
    public SuperUnit Reserve=new SuperUnit(Constants.ReserveStart,Constants.ReserveLength);
    /**
     * 指令类型
     */
    public SuperUnit InstructionType=new SuperUnit(Constants.InstructionTypeStart,Constants.InstructionTypeLength);
    /**
     * 内容长度
     */
    public SuperUnit ContentLength=new SuperUnit(Constants.ContentLengthStart,Constants.ContentLengths);
    /**
     * 内容
     */
    public SuperUnit Content=new SuperUnit(Constants.ContentStart,0);
    /**
     * 错误代码
     */
    public SuperUnit ErrorCode = new SuperUnit(Constants.ErrorCodeStart, Constants.ErrorCodeLengths);
    /**
     * 有效数据
     */
    public SuperUnit ValidData = new SuperUnit(Constants.ValidDataStart, 0);
    /**
     * CRC校验码
     */
    public SuperUnit CRCCode=new SuperUnit(Constants.CRCLength);

    /**
     * 获取发送消息数据
     * @return
     */
    public String GetMsgData() {
        String strRet = "";

        DataPackage.setnUnitValue(Constants.TotalLength + Content.getStrValue().length()/2);

        ContentLength.setnUnitValue(Content.getStrValue().length()/2);
        DevType.setnUnitValue(Constants.DT_GATEWAY);
        SubType.setnUnitValue(0xff);
        AddrType.setnUnitValue(Constants.AT_ID);
        Reserve.setnUnitValue(0x00000000);


        /**
         * 包头
         */
        strRet += Constants.HEADER;
        /**
         * 数据包长度
         */
        strRet += DataPackage.getStrValue();
        /**
         * 任务Id
         */
        strRet += TaskId.getStrValue();
        /**
         * 操作类型
         */
        strRet += Operate.getStrValue();
        /**
         * 设备类型
         */
        strRet += DevType.getStrValue();
        /**
         * 子类型
         */
        strRet += SubType.getStrValue();
        /**
         * 通信方式
         */
        strRet += CommunicationStyle.getStrValue();
        /**
         * 房间地址
         */
        strRet += Address.RegionNo.getStrValue() + Address.BuildingNo.getStrValue() + Address.FloorNo.getStrValue() + Address.RoomNo.getStrValue();
        /**
         * 地址类型
         */
        strRet += AddrType.getStrValue();
        /**
         * 寻址
         */
        strRet += AddrMap.getStrValue();
        /**
         * 预留字段
         */
        strRet += Reserve.getStrValue();
        /**
         * 指令类型
         */
        strRet += InstructionType.getStrValue();
        /**
         * 内容长度
         */
        strRet += ContentLength.getStrValue();
        /**
         * 内容
         */
        if (Content.getStrValue() != null) {
            strRet += Content.getStrValue();
        }
        /**
         * CRC校验码
         */
        strRet += CRCCode.getStrValue();
        /**
         * 包尾
         */
        strRet += Constants.TAIL;
        strRet = StringUtil.toLowerCase(strRet);
        return strRet;
    }

    public String GetOriginalMsgData(ProtocolStructure ps) {
        String strRet = "";
        /**
         * 包头
         */
        strRet += Constants.HEADER;
        /**
         * 数据包长度
         */
        strRet += ps.DataPackage.getStrValue();
        /**
         * 任务Id
         */
        strRet += ps.TaskId.getStrValue();
        /**
         * 操作类型
         */
        strRet += ps.Operate.getStrValue();
        /**
         * 设备类型
         */
        strRet += ps.DevType.getStrValue();
        /**
         * 子类型
         */
        strRet += ps.SubType.getStrValue();
        /**
         * 通信方式
         */
        strRet += ps.CommunicationStyle.getStrValue();
        /**
         * 房间地址
         */
        strRet += ps.Address.RegionNo.getStrValue() + ps.Address.BuildingNo.getStrValue() + ps.Address.FloorNo.getStrValue() + ps.Address.RoomNo.getStrValue();
        /**
         * 地址类型
         */
        strRet += ps.AddrType.getStrValue();
        /**
         * 寻址
         */
        strRet += ps.AddrMap.getStrValue();
        /**
         * 预留字段
         */
        strRet += ps.Reserve.getStrValue();
        /**
         * 指令类型
         */
        strRet += ps.InstructionType.getStrValue();
        /**
         * 内容长度
         */
        strRet += ps.ContentLength.getStrValue();
        /**
         * 内容
         */
        if (Content.getStrValue() != null) {
            strRet += ps.Content.getStrValue();
        }
        /**
         * CRC校验码
         */
        strRet += ps.CRCCode.getStrValue();
        /**
         * 包尾
         */
        strRet += Constants.TAIL;
        strRet = StringUtil.toLowerCase(strRet);
        return strRet;
    }

    /**
     * 协议各部分内容赋值
     * @param strData
     */
    public void SetPackageUnit(String strData) {

        this.DataPackage.setStrValue(StringUtil.SubString(strData, DataPackage.nStart * 2, DataPackage.getnLength() * 2));
        this.TaskId.setStrValue(StringUtil.SubString(strData, TaskId.nStart * 2, TaskId.getnLength() * 2), false);
        this.Operate.setStrValue(StringUtil.SubString(strData, Operate.nStart * 2, Operate.getnLength() * 2));
        this.DevType.setStrValue(StringUtil.SubString(strData, DevType.nStart * 2, DevType.getnLength() * 2));
        this.SubType.setStrValue(StringUtil.SubString(strData, SubType.nStart * 2, SubType.getnLength() * 2));
        this.CommunicationStyle.setStrValue(StringUtil.SubString(strData, CommunicationStyle.nStart * 2, CommunicationStyle.getnLength() * 2));
        this.Addressing.setStrValue(StringUtil.SubString(strData, Addressing.nStart * 2, Addressing.getnLength() * 2), false);
        this.Address.RegionNo.setStrValue(StringUtil.SubString(strData, Address.RegionNo.nStart * 2, Address.RegionNo.getnLength() * 2));
        this.Address.BuildingNo.setStrValue(StringUtil.SubString(strData, Address.BuildingNo.nStart * 2, Address.BuildingNo.getnLength() * 2));
        this.Address.FloorNo.setStrValue(StringUtil.SubString(strData, Address.FloorNo.nStart * 2, Address.FloorNo.getnLength() * 2));
        this.Address.RoomNo.setStrValue(StringUtil.SubString(strData, Address.RoomNo.nStart * 2, Address.RoomNo.getnLength() * 2));
        this.AddrType.setStrValue(StringUtil.SubString(strData, AddrType.nStart * 2, AddrType.getnLength() * 2));
        this.AddrMap.setStrValue(StringUtil.SubString(strData, AddrMap.nStart * 2, AddrMap.getnLength()*2));
        this.Reserve.setStrValue(StringUtil.SubString(strData, Reserve.nStart * 2, Reserve.getnLength() * 2));
        this.InstructionType.setStrValue(StringUtil.SubString(strData, InstructionType.nStart * 2, InstructionType.getnLength() * 2));
        this.ContentLength.setStrValue(StringUtil.SubString(strData, ContentLength.nStart * 2, ContentLength.getnLength() * 2));
        this.ErrorCode.setStrValue(StringUtil.SubString(strData, ErrorCode.nStart * 2, ErrorCode.getnLength() * 2));
        this.ValidData.setnLength(ContentLength.getnUnitValue() - ErrorCode.getnLength());
        this.Content.setnLength(ContentLength.getnUnitValue());
        this.Content.setStrValue(StringUtil.SubString(strData, Content.nStart * 2, Content.getnLength() * 2), false);
        if (this.ValidData.getnLength() != 0) {
            this.ValidData.setStrValue(StringUtil.SubString(strData, ValidData.nStart * 2, Content.getnLength() * 2 - ErrorCode.getnLength() * 2), false);
            this.CRCCode.nStart = this.Content.nStart + this.Content.getnLength();
            this.CRCCode.setStrValue(StringUtil.SubString(strData, CRCCode.nStart * 2, CRCCode.getnLength() * 2));
        } else if (this.ValidData.getnLength() == 0) {
            this.CRCCode.nStart = this.Content.nStart + this.Content.getnLength();
            this.CRCCode.setStrValue(StringUtil.SubString(strData, CRCCode.nStart * 2, CRCCode.getnLength() * 2), false);
        }
    }
}




