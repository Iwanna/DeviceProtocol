package com.lianchuang.mydeviceprotocollibrary.protocol;


import com.lianchuang.mydeviceprotocollibrary.protocol.utils.ConvertUitl;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class SuperUnit {
    /**
     * 高位
     */
    public int Hi_Value;

    /**
     * 低位
     */
    public int Lo_Value;

    /***
     *
     * @param nValue_hi 高位
     * @param nValue_lo 低位
     * @param No        位移
     */
    public void setnUnitValue(int nValue_hi,int nValue_lo,int No)
    {
        this.Hi_Value=nValue_hi;
        this.Lo_Value=nValue_lo;
        this.nUnitValue=(nValue_hi<<No)|nValue_lo;
        this.strValue = StringUtil.addLeft(Integer.toHexString(nUnitValue), nLength * 2);
    }

    /**
     *
     * @param nValue （值为0或1）
     * @param No （序号）
     */
    public void setUnitValue(int nValue,int No) {
        int value = nValue;
        value = value << No;
        this.nUnitValue = this.nUnitValue | value;
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

    /**
     * 名称
     */
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
        strValue = value;
        if(strValue.length()==0)
        {
            return;
        }
        //除数据字段外，其他字段将字符串数据换成整形
        nUnitValue = Integer.parseInt(strValue, 16);
    }

    /**
     *
     * @param value 赋值
     * @param flag （true：数值转换成整形，false：计算出数值的长度）
     */
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
     **/
    private int nLength;

    public int getnLength() {
        return nLength;
    }

    public void setnLength(int value) {
        nLength = value;
        setnEnd(nStart + nLength * 2);
    }

    public SuperUnit(String strValue, int nStart, int nLength) {
        this.strValue = strValue;
        this.nLength = nLength;
        this.nStart = nStart;
    }

    public SuperUnit(String strValue, int nLength) {
        this.strValue = strValue;
        this.nLength = nLength;
    }

    public SuperUnit(int nStart, int nLength) {
        this.nLength = nLength;
        this.nStart = nStart;
    }

    public SuperUnit(int nLength) {
        this.nLength = nLength;
    }

    public void Initial() {
        setnUnitValue(0);
    }
}