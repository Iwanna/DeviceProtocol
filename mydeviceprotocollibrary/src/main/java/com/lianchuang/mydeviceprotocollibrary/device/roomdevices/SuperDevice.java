package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;


import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class SuperDevice
{
    //********************属性******************************//
    /**设备类型*/
    private int nDevType;
    public void setnDevType(int devType)
    {
        nDevType=devType;
    }
    public  int getnDevType()
    {
        return nDevType;
    }
    /**设备ID*/
    private int nDevId;
    public void setnDevId(int devId){nDevId=devId;}
    public int getnDevId(){return nDevId;}
    /**设备名称*/
    private String strDevName;
    public void setStrDevName(String strName){strDevName=strName;}
    public String getStrDevName(){return strDevName;}
    /**设备参数*/
    public String strData="";
    public void setStrData(String strRet)
    {
        strData=strRet;
    }
    public String getStrData()
    {
        return strData;
    }

    /**开关位*/
    private int sw;
    public int getSw()
    {
        return sw;
    }
    public void setSw(int nSw)
    {
        sw=nSw;
    }
    /**有效位*/
    public int nEffectiveBit;
    public void setnEffectiveBit(int value)
    {
        nEffectiveBit=value;
    }
    public int getnEffectiveBit()
    {
        return nEffectiveBit;
    }
    /**字节长度*/
    public int nLength;
    public int getnLength()
    {
        return nLength;
    }
    public void setnLength(int value)
    {
        nLength=value;
    }

    //**********************闲置*****************************//
    /**房间号*/
    public int nRoomId;
    /**设备地址*/
    public String strDevMac;
    public void setStrDevMac(String strMac){strDevMac=strMac;}
    public String getStrDevMac(){return strDevMac;}

    /**设备编号*/
    public int nDevNo;
    public void setnDevNo(int devNo)
    {
        nDevNo=devNo;
    }
    public int getnDevNo()
    {
        return nDevNo;
    }

    /**子设备编号*/
    public int nSubDevNo;
    public void setnSubDevNo(int subDevNo)
    {
        nSubDevNo=subDevNo;
    }
    public int getnSubDevNo()
    {
        return nSubDevNo;
    }

    public SuperDevice()
    {
        this.sw=0;
        this.nDevId=0;
        //this.nDevType=0;
        //this.nDevNo=0;
        //this.nSubDevNo=0;
        this.nEffectiveBit=0;
    }

    /**
     * 获取有效数据
     * @return
     */
    public String GetValidData()
    {
        //设备ID号占两个字节
        String strRet=StringUtil.addLeft(Integer.toHexString(nDevId),4);
        strRet = strRet + strData;
        return strRet;
    }

    /**
     * 设置参数
     * @param strValidData
     */
    public void SetParam(String strValidData)
    {
        this.nDevId = Integer.parseInt(StringUtil.SubString(strValidData, 0, 4), 16);
        this.strData = strValidData.substring(4);
    }

    public void SetData() { }

    public void SetParam() { }

    public int GetEffectiveBit(int nNo)
    {
        String strBin=StringUtil.addLeft(Integer.toBinaryString(nEffectiveBit),8);
        if(nNo>=strBin.length()) {
            nNo = strBin.length() - 1;
        }
        strBin= StringUtil.replaceString(strBin,strBin.length()-nNo,"1");
        return Integer.parseInt(strBin,2);
    }

    public String OpenDevice()
    {
        String strRet = StringUtil.addLeft(Integer.toHexString(nDevType), 2)+
                StringUtil.addLeft(Integer.toHexString(nDevNo), 2) +
                StringUtil.addLeft(Integer.toHexString(nSubDevNo), 2);
        strRet = strRet + strData;
        return strRet;
    }
}
