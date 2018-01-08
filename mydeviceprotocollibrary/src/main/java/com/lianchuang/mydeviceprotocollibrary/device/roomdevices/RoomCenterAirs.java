package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;


import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emCenterAirEffectiveBit;
import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDevicesType;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class RoomCenterAirs extends SuperDevice
{
    private int maxTemp=30;
    private int minTemp=16;
    /**空调风速*/
    private int fanspeed;
    public int getFanspeed()
    {
        return fanspeed;
    }
    public void setFanspeed(int value)
    {
        fanspeed=value;
        setEffective(emCenterAirEffectiveBit.FanSpeed);
    }

    /**温度位*/
    private int temp;
    public int getTemp()
    {
        return temp;
    }
    public void setTemp(int value)
    {
        if (value > maxTemp)
        {
            temp = maxTemp;
        }
        else if(value < minTemp)
        {
            temp = minTemp;
        }
        else
            temp = value;

        setEffective(emCenterAirEffectiveBit.Temp);
    }

    /****
     * 设置开关位
     */
    @Override
    public void setSw(int value)
    {
        super.setSw(value);
        setEffective(emCenterAirEffectiveBit.Switch);
    }

    /****
     * 设置有效位
     * @param state
     */
    private void setEffective(emCenterAirEffectiveBit state)
    {
        nEffectiveBit=0;
        nEffectiveBit = GetEffectiveBit(emCenterAirEffectiveBit.Switch.getValue()-1);

        switch (state)
        {
            case Switch:
                break;
            case FanSpeed:
                nEffectiveBit = GetEffectiveBit(emCenterAirEffectiveBit.FanSpeed.getValue()-1);
                break;
            case Temp:
                nEffectiveBit = GetEffectiveBit(emCenterAirEffectiveBit.Temp.getValue()-1);
                break;
            default:
                nEffectiveBit = GetEffectiveBit(emCenterAirEffectiveBit.FanSpeed.getValue()-1);
                break;
        }
    }

    public RoomCenterAirs()
    {
        super();
        setnDevType(emDevicesType.CenterAir.getValue());
        this.nLength=4;
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
        strData += StringUtil.addLeft(Integer.toHexString(fanspeed), 2);
        strData += StringUtil.addLeft(Integer.toHexString(temp), 2);
        return super.GetValidData();
    }

    /****
     * 设置参数
     */
    @Override
    public void SetParam(String strValidData)
    {
        super.SetParam(strValidData);
        this.nEffectiveBit = Integer.parseInt(strData.substring(0, 2), 16);
        super.setSw(Integer.parseInt(StringUtil.SubString(strData, emCenterAirEffectiveBit.Switch.getValue() * 2, 2),16));
        this.fanspeed = Integer.parseInt(StringUtil.SubString(strData, emCenterAirEffectiveBit.FanSpeed.getValue() * 2, 2),16);
        this.temp = Integer.parseInt(StringUtil.SubString(strData, emCenterAirEffectiveBit.Temp.getValue() * 2, 2),16);
    }

    /****
     * 设置参数
     */
    @Override
    public void SetParam()
    {
        if(strData.isEmpty())
            super.SetParam();
        if (strData.length() >= 2)
            this.nEffectiveBit = Integer.parseInt(strData.substring(0, 2), 16);
        if (strData.length() >= (emCenterAirEffectiveBit.Switch.getValue() * 2 + 2))
            this.setSw(Integer.parseInt(StringUtil.SubString(strData, emCenterAirEffectiveBit.Switch.getValue() * 2, 2),16));
        if (strData.length() >= (emCenterAirEffectiveBit.FanSpeed.getValue() * 2 + 2))
            this.fanspeed = Integer.parseInt(StringUtil.SubString(strData, emCenterAirEffectiveBit.FanSpeed.getValue() * 2, 2),16);
        if(strData.length()>=(emCenterAirEffectiveBit.Temp.getValue() * 2 + 2))
            this.fanspeed = Integer.parseInt(StringUtil.SubString(strData, emCenterAirEffectiveBit.Temp.getValue() * 2, 2),16);
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
        strData += StringUtil.addLeft(Integer.toHexString(fanspeed), 2);
        strData += StringUtil.addLeft(Integer.toHexString(temp), 2);
        this.nLength = 4;
        super.SetData();
    }
}
