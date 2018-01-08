package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;


import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDevicesType;
import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emTvEffectiveBit;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class RoomTvs extends SuperDevice
{
    /**
     * 频道
     */
    private int channel;
    public int getChannel()
    {
        return channel;
    }
    public void setChannel(int value)
    {
        channel=value;
        setEffective(emTvEffectiveBit.Channel);
    }

    /**
     * 音量
     */
    private int volume;
    static int maxVolume = 30;
    public int getVolume()
    {
        return volume;
    }
    public void setVolume(int value)
    {
        if (value > maxVolume) {
            volume = maxVolume;
        }
        else {
            volume = value;
        }

        setEffective(emTvEffectiveBit.Volume);
    }

    @Override
    public void setSw(int value)
    {
        super.setSw(value);
        setEffective(emTvEffectiveBit.Switch);
    }

    public RoomTvs()
    {
        super();
        setnDevType(emDevicesType.Tv.getValue());
        this.nLength=4;
    }

    private void setEffective(emTvEffectiveBit tvState)
    {
        //emTvEffectiveBit tvState=emTvEffectiveBit.Switch;
        nEffectiveBit=0;
        nEffectiveBit = GetEffectiveBit(emTvEffectiveBit.Switch.getValue()-1);
        switch (tvState)
        {
            case Switch:
                break;
            case Channel:
                nEffectiveBit = GetEffectiveBit(emTvEffectiveBit.Channel.getValue()-1);
                break;
            case Volume:
                nEffectiveBit = GetEffectiveBit(emTvEffectiveBit.Volume.getValue()-1);
                break;
            default:
                nEffectiveBit = GetEffectiveBit(emTvEffectiveBit.Switch.getValue()-1);
                nEffectiveBit = GetEffectiveBit(emTvEffectiveBit.Channel.getValue()-1);
                nEffectiveBit = GetEffectiveBit(emTvEffectiveBit.Volume.getValue()-1);
                break;
        }
    }

    @Override
    public String GetValidData()
    {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(this.getSw()), 2);
        strData += StringUtil.addLeft(Integer.toHexString(channel), 2);
        strData += StringUtil.addLeft(Integer.toHexString(volume), 2);
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
        if(strData.equals(null)) {
            return;
        }
        else {
            if (strData.length() >= 2) {
                this.nEffectiveBit = Integer.parseInt(strData.substring(0, 2), 16);
            }
            if (strData.length() >= emTvEffectiveBit.Switch.getValue() * 2 + 2) {
                this.setSw(Integer.parseInt(StringUtil.SubString(strData, emTvEffectiveBit.Switch.getValue() * 2, 2), 16));
            }
            if (strData.length() >= emTvEffectiveBit.Channel.getValue() * 2 + 2) {
                this.channel = Integer.parseInt(StringUtil.SubString(strData, emTvEffectiveBit.Channel.getValue() * 2, 2), 16);
            }
            if (strData.length() >= emTvEffectiveBit.Volume.getValue() * 2 + 2) {
                this.volume = Integer.parseInt(StringUtil.SubString(strData, emTvEffectiveBit.Volume.getValue() * 2, 2), 16);
            }
            super.SetParam();
        }
    }

    @Override
    public void SetData()
    {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(this.getSw()), 2);
        strData += StringUtil.addLeft(Integer.toHexString(channel), 2);
        strData += StringUtil.addLeft(Integer.toHexString(volume), 2);
        this.nLength = 4;
        super.SetData();
    }
}
