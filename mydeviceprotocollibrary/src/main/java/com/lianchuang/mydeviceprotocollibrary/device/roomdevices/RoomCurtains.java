package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;

import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emCurtainEffectiveBit;
import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDevicesType;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class RoomCurtains extends SuperDevice
{
    /**
     * 位置
     */
    private int position;
    public int getPosition()
    {
        return position;
    }
    public void setPosition(int value)
    {
        position=value;
        setEffective(emCurtainEffectiveBit.Position);
    }

    /**
     * 反向标志
     */
    private int reverseFlag;
    public int getReverseFlag(){return reverseFlag;}
    public void setReverseFlag(int value){reverseFlag=value;}

    /****
     * 设置开关位
     */
    @Override
    public void setSw(int value)
    {
        super.setSw(value);
        setEffective(emCurtainEffectiveBit.Switch);
    }

    public RoomCurtains()
    {
        super();
        setnDevType(emDevicesType.Curtain.getValue());
        this.nLength = 4;
    }

    /****
     * 设置有效位
     * @param state
     */
    private void setEffective(emCurtainEffectiveBit state)
    {
        //nEffectiveBit=0;
        nEffectiveBit = GetEffectiveBit(emCurtainEffectiveBit.Switch.getValue()-1);
        switch (state)
        {
            case Switch:
                break;
            case Position:
                nEffectiveBit = GetEffectiveBit(emCurtainEffectiveBit.Position.getValue()-1);
                break;
            case ReverseFlag:
                nEffectiveBit = GetEffectiveBit(emCurtainEffectiveBit.ReverseFlag.getValue()-1);
                break;
            default:
                nEffectiveBit = GetEffectiveBit(emCurtainEffectiveBit.Switch.getValue()-1);
                break;
        }
    }

    /****
     * 获取有效数据
     */
    @Override
    public String GetValidData()
    {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(this.getSw()), 2);
        strData += StringUtil.addLeft(Integer.toHexString(position), 2);
        strData += StringUtil.addLeft(Integer.toHexString(reverseFlag),2);
        return super.GetValidData();
    }

    /****
     * 设置参数
     */
    @Override
    public void SetParam(String strValidData)
    {
        super.SetParam(strValidData);
        SetParam();
    }

    /****
     * 设置参数
     */
    @Override
    public void SetParam()
    {
        if(strData.isEmpty()) {
            super.SetParam();
        }
        if (strData.length() >= 2) {
            this.nEffectiveBit = Integer.parseInt(strData.substring(0, 2), 16);
        }
        if (strData.length() >= emCurtainEffectiveBit.Switch.getValue() * 2 + 2) {
            this.setSw(Integer.parseInt(StringUtil.SubString(strData, emCurtainEffectiveBit.Switch.getValue() * 2, 2), 16));
        }
        if (strData.length() >= emCurtainEffectiveBit.Position.getValue() * 2 + 2) {
            this.position = Integer.parseInt(StringUtil.SubString(strData, emCurtainEffectiveBit.Position.getValue() * 2, 2), 16);
        }
        if(strData.length() >= emCurtainEffectiveBit.ReverseFlag.getValue() *2 + 2) {
            this.position = Integer.parseInt(StringUtil.SubString(strData, emCurtainEffectiveBit.ReverseFlag.getValue() * 2, 2), 16);
        }
        super.SetParam();
    }

    /****
     * 设置数据
     */
    @Override
    public void SetData()
    {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(this.getSw()), 2);
        strData += StringUtil.addLeft(Integer.toHexString(position), 2);
        strData += StringUtil.addLeft(Integer.toHexString(reverseFlag),2);
        this.nLength = 4;
        super.SetData();
    }
}

