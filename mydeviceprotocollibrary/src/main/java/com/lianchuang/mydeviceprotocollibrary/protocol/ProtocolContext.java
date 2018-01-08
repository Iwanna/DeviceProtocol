package com.lianchuang.mydeviceprotocollibrary.protocol;


import com.lianchuang.mydeviceprotocollibrary.protocol.utils.ConvertUitl;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;
import com.lianchuang.mydeviceprotocollibrary.protocol.constant.Constants;
import com.lianchuang.mydeviceprotocollibrary.protocol.utils.CRC;

/**
 * @author Law
 * @date 2017/6/13
 */
public class ProtocolContext
{
    public static ProtocolStructure cps = new ProtocolStructure();

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
     * 获取发送数据
     * @param ps
     * @return
     */
    public static String DoGetSendMsg(ProtocolStructure ps){
        return ps.GetMsgData();
    }

    /**
     * CRC校验
     * @param ps
     * @return
     */
    public static boolean CheckRcvData(ProtocolStructure ps) {
        boolean bRet = false;
        int nCrcCode = ps.CRCCode.getnUnitValue();
        ps.CRCCode.Initial();
        String strRet = ps.GetOriginalMsgData(ps);

        //数据包去头
        strRet = strRet.substring(Constants.HeaderLength * 2);
        //数据包去数据长度
        strRet = strRet.substring(Constants.DataPackageLength * 2);
        //数据包去尾
        strRet = strRet.substring(0, strRet.length() - Constants.TailLength * 2);
        //数据包去验证码字段
        strRet = strRet.substring(0, strRet.length() - Constants.CRCLength * 2);
        strRet = StringUtil.toLowerCase(strRet);
        int nTempCode = Integer.parseInt(CRC.getCrc16Code(strRet),16);
        if (nCrcCode == nTempCode) {
            bRet = true;
            ps.CRCCode.setnUnitValue(nCrcCode);
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
}
