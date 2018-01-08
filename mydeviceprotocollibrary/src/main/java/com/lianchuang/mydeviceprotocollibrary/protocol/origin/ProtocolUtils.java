package com.lianchuang.mydeviceprotocollibrary.protocol.origin;


import com.lianchuang.mydeviceprotocollibrary.protocol.utils.CRCCheck;
import com.lianchuang.mydeviceprotocollibrary.protocol.utils.ConvertUitl;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 */
public class ProtocolUtils
{
    public static ProtocolStruct cps = new ProtocolStruct();

    /**
     * 接收数据处理
     * @param strData
     */
    public static void DoGetRcvMsg(String strData) {
        cps.SetPackageUnit(strData);
    }

    /**
     * 发送数据处理
     * @return
     */
    public static String DoGetSendMsg() {
        return cps.GetMsgData();
    }

    /**
     * CRC校验
     * @param ps
     * @return
     */
    public static boolean CheckRcvData(ProtocolStruct ps) {
    	boolean bRet = false;
        int nCrcCode = ps.CrcCode.getnUnitValue();
        ps.CrcCode.Initial();
        String strRet=ps.GetMsgData();
        //数据包去头
        strRet = strRet.substring(6);
        //数据包去尾
        strRet = strRet.substring(0, strRet.length() - 6);
        //数据包去校验位
        strRet = strRet.substring(0, strRet.length() - 4);
        strRet= StringUtil.toLowerCase(strRet);
        int nTempCode= CRCCheck.GetCRC16(strRet);
        if (nCrcCode == nTempCode)
        {
            bRet = true;
            ps.CrcCode.setnUnitValue(nCrcCode);
        }
        return bRet;
    }

    /**
     * 将十进制数值填充完整十六进制数值
     * @param nValue
     * @param nLength
     * @return
     */
    public static String DoFillDataValue(int nValue, int nLength) {
        int nRet = 2 * nLength;
        String strRet = ConvertUitl.IntTohexString(nValue);
        strRet = StringUtil.addLeft(strRet, nRet);
        return strRet;
    }

    public static void SetAddress(Addressing address,String strAddress)
    {
        String[]arrAddress=strAddress.split(",");
        if(arrAddress.length>=1){
        address.HotelNo.setStrValue(arrAddress[0]);}
        if(arrAddress.length>=2){
        address.RegionNo.setStrValue(arrAddress[1]);}
        if(arrAddress.length>=3){
        address.BuildingNo.setStrValue(arrAddress[2]);}
        if(arrAddress.length>=4){
        address.FloorNo.setStrValue(arrAddress[3]);}
    }
}
