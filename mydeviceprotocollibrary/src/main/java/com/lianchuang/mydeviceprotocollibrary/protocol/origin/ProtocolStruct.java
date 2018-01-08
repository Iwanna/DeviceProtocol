package com.lianchuang.mydeviceprotocollibrary.protocol.origin;


import com.lianchuang.mydeviceprotocollibrary.protocol.constant.ConstantValues;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

public class ProtocolStruct {
    /**
     * 包长度
     */
    public DataUnit PackageLength = new DataUnit(ConstantValues.PackageLengthStart, ConstantValues.DataPackageLength);

    /**
     * 读写标识
     */
    public DataUnit WRFlag = new DataUnit(ConstantValues.WRFlagStart, ConstantValues.WRFlagLength);
    /**
     * 命令类型
     */
    public DataUnit CommandType = new DataUnit(ConstantValues.CommandTypeStart, ConstantValues.CommandTypeLength);
    /**
     * 寻址
     */
    public Addressing Address = new Addressing();
    /**
     * 会话标识
     */
    public DataUnit SessionId = new DataUnit(ConstantValues.SessionidStart, ConstantValues.SessionidLength);
    /**
     * 入住标识
     */
    public DataUnit CheckInId = new DataUnit(ConstantValues.CheckinFlagStart, ConstantValues.CheckinFlagLength);
    /**
     * 来源标识
     */
    public DataUnit SrcDev =new DataUnit(ConstantValues.SrcDevStart,ConstantValues.SrcDevLength);
    /**
     * 数据长度
     */
    public DataUnit DataLength = new DataUnit(ConstantValues.DataLengthStart, ConstantValues.DataLength);
    /**
     * 错误代码
     */
    public DataUnit ErrorCode = new DataUnit(ConstantValues.ErrorCodeStart, ConstantValues.ErrorCodeLength);
    /**
     * 有效数据
     */
    public DataUnit ValidData = new DataUnit(ConstantValues.ValidDataStart, 0);
    /**
     * CRC校验码
     */
    public DataUnit CrcCode = new DataUnit(ConstantValues.CRCcodeLength);

    /**
     * 获取发送消息数据
     * @return
     */
    public String GetMsgData() {
    	String strRet = "";
        PackageLength.setnUnitValue(ConstantValues.TotalLength + ValidData.getnLength());
        DataLength.setnUnitValue(ValidData.getnLength()+ErrorCode.getnLength());
        strRet += ConstantValues.HEADER;
        strRet += PackageLength.getStrValue();
        strRet += WRFlag.getStrValue();
        strRet += CommandType.getStrValue();
        strRet += Address.HotelNo.getStrValue() + Address.RegionNo.getStrValue() +
                Address.BuildingNo.getStrValue() + Address.FloorNo.getStrValue() + Address.RoomNo.getStrValue();
        strRet += SessionId.getStrValue();
        strRet += CheckInId.getStrValue();
        strRet += SrcDev.getStrValue();
        strRet += DataLength.getStrValue();
        strRet += ErrorCode.getStrValue();
        if(ValidData.getStrValue()!=null)
        {
            strRet += ValidData.getStrValue();
        }
        strRet += CrcCode.getStrValue();
        strRet += ConstantValues.TAIL;
        strRet= StringUtil.toUpperCase(strRet);
        return strRet;
    }

    /**
     * 协议各部分内容赋值
     * @param strData
     */
    public void SetPackageUnit(String strData) {

        this.PackageLength.setStrValue(StringUtil.SubString(strData, PackageLength.nStart * 2, PackageLength.getnLength() * 2));
        this.WRFlag.setStrValue(StringUtil.SubString(strData,WRFlag.nStart * 2,WRFlag.getnLength()*2));
        this.CommandType.setStrValue(StringUtil.SubString(strData,CommandType.nStart * 2,CommandType.getnLength()*2));
        this.Address.HotelNo.setStrValue(StringUtil.SubString(strData,Address.HotelNo.nStart * 2,Address.HotelNo.getnLength()*2));
        this.Address.RegionNo.setStrValue(StringUtil.SubString(strData,Address.RegionNo.nStart * 2,Address.RegionNo.getnLength()*2));
        this.Address.BuildingNo.setStrValue(StringUtil.SubString(strData,Address.BuildingNo.nStart * 2,Address.BuildingNo.getnLength()*2));
        this.Address.FloorNo.setStrValue(StringUtil.SubString(strData,Address.FloorNo.nStart * 2,Address.FloorNo.getnLength()*2));
        this.Address.RoomNo.setStrValue(StringUtil.SubString(strData,Address.RoomNo.nStart * 2,Address.RoomNo.getnLength()*2));
        this.SessionId.setStrValue(StringUtil.SubString(strData, SessionId.nStart * 2, SessionId.getnLength() * 2));
        this.CheckInId.setStrValue(StringUtil.SubString(strData, CheckInId.nStart * 2, CheckInId.getnLength() * 2));
        this.SrcDev.setStrValue(StringUtil.SubString(strData,SrcDev.nStart*2,SrcDev.getnLength()*2));
        this.DataLength.setStrValue(StringUtil.SubString(strData, DataLength.nStart * 2, DataLength.getnLength() * 2));
        this.ErrorCode.setStrValue(StringUtil.SubString(strData, ErrorCode.nStart * 2, ErrorCode.getnLength() * 2));
        this.ValidData.setnLength(DataLength.getnUnitValue() - ErrorCode.getnLength());
        if(this.ValidData.getnLength()!=0) {
            this.ValidData.setStrValue(StringUtil.SubString(strData, ValidData.nStart * 2, ValidData.getnLength() * 2));
            this.CrcCode.nStart=this.ValidData.nStart+this.ValidData.getnLength();
            this.CrcCode.setStrValue(StringUtil.SubString(strData, CrcCode.nStart * 2, CrcCode.getnLength() * 2));
        }
        else if(this.ValidData.getnLength()==0){
            this.CrcCode.nStart=this.ValidData.nStart+this.ValidData.getnLength();
            this.CrcCode.setStrValue(StringUtil.SubString(strData, CrcCode.nStart * 2, CrcCode.getnLength() * 2),true);
        }
    }
}




