package com.lianchuang.mydeviceprotocollibrary.protocol.origin;


import com.lianchuang.mydeviceprotocollibrary.protocol.constant.ConstantValues;
import com.lianchuang.mydeviceprotocollibrary.protocol.utils.ConvertUitl;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;



/**
 * @author Law
 * 数据包组成单元
 */
public class DataUnit {
    /**
     * 数据（整形表示）
     * */
    private int nUnitValue;

    public int getnUnitValue() {
        return nUnitValue;
    }

    public void setnUnitValue(int nValue) {
        nUnitValue = nValue;
        strValue = StringUtil.addLeft(Integer.toHexString(nValue), nLength * 2);
    }
    
    private String strNameValue;
    public void setNameValue(String strValue){
    	strNameValue=strValue;
    }
    public String getNameValue() {
		return strNameValue;
	}

    /**
     * 数据（字符串）
     * */
    private String strValue;

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String value) {
        if((value.length()%2)!=0)
            value=StringUtil.addLeft(value,value.length()+1);
        strValue = value;

        if (nStart != ConstantValues.ValidDataStart) {
            //除数据字段外，其他字段将字符串数据换成整形
            nUnitValue = Integer.parseInt(strValue, 16);
        } else {
            //协议数据字段获取字段长度
            nLength = ConvertUitl.hexStringToBytes(strValue).length;
        }
    }
    
    public void setStrValue(String value,boolean flag) {
        strValue = value;
        if(strValue.length()==0)
        {
            return;
        }
        if(flag)
        {
            //除数据字段外，其他字段将字符串数据换成整形
            nUnitValue = Integer.parseInt(strValue, 16);
        }
        else
        {
            //协议数据字段获取字段长度
            nLength = ConvertUitl.hexStringToBytes(strValue).length;
        }
    }

    /**
     * 长度
     * */
    private int nLength;

    public int getnLength() {
        return nLength;
    }

    public void setnLength(int value) {
        nLength = value;
        setnEnd(nStart + nLength * 2);
    }

    /**
     * 起始位置
     * */
    public int nStart;
    /**
     * 结束位置
     * */
    private int nEnd;

    public int getnEnd() {
        return nEnd;
    }

    public void setnEnd(int value) {
        nEnd = value;
    }

    public DataUnit(String strValue, int nStart, int nLength) {
        this.strValue = strValue;
        this.nLength = nLength;
        this.nStart = nStart;
    }

    public DataUnit(String strValue, int nLength) {
        this.strValue = strValue;
        this.nLength = nLength;
    }

    public DataUnit(int nStart, int nLength) {
        this.nLength = nLength;
        this.nStart = nStart;
        this.strValue = StringUtil.addLeft(Integer.toHexString(nUnitValue), nLength * 2);
    }

    public DataUnit(int nLength) {
        this.nLength = nLength;
    }

    public void Initial() {
    	setnUnitValue(0);
    }
}