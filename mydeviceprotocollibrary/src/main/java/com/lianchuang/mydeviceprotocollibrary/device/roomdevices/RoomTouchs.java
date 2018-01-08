package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;


import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDevicesType;
import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emTouchEffectiveBit;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class RoomTouchs extends SuperDevice
{
    public RoomTouchs()
    {
        super();
        setnDevType(emDevicesType.Bulb.getValue());
        this.nLength = 2;
    }

    @Override
    public String GetValidData()
    {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(this.getSw()), 2);
        return super.GetValidData();
    }

    @Override
    public void SetParam(String strValidData)
    {
        super.SetParam(strValidData);
        SetParam();
    }

    @Override
    public void SetParam()
    {
        if(strData.isEmpty()) {
            super.SetParam();
        }
        if (strData.length() >= 2) {
            this.nEffectiveBit = Integer.parseInt(StringUtil.SubString(strData, 0, 2), 16);
        }
        if (strData.length() >= emTouchEffectiveBit.Switch.getValue() * 2 + 2) {
            this.setSw(Integer.parseInt(StringUtil.SubString(strData, emTouchEffectiveBit.Switch.getValue() * 2, 2), 16));
        }
        super.SetParam();
    }

    @Override
    public void SetData()
    {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(this.getSw()), 2);
        this.nLength = 2;
        super.SetData();
    }
}
