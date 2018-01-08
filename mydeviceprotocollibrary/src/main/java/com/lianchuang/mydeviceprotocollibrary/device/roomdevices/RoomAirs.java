package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;


import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emAirEffectiveBit;
import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDevicesType;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class RoomAirs extends SuperDevice {
    /**
     * 温度位
     */
    private int temp;
    public int getTemp() {
        return temp;
    }
    public void setTemp(int value) {
        if (value > maxTemp) {
            temp = maxTemp;
        } else if (value < minTemp) {
            temp = minTemp;
        } else {
            temp = value;
        }

        setEffective(emAirEffectiveBit.Temp);
    }

    private int maxTemp = 28;

    public int getMinTemp() {
        return minTemp;
    }

    private int minTemp = 21;

    /**
     * 模式位
     */
    private int mode;
    public int getMode() {
        return mode;
    }
    public void setMode(int value) {
        mode = value;
        setEffective(emAirEffectiveBit.Mode);
    }

    /**
     * 定时位
     */
    private int timer;
    public int getTimer() {
        return timer;
    }
    public void setTimer(int value) {
        timer = value;
        setEffective(emAirEffectiveBit.Timer);
    }

    /**
     * 扫风
     */
    private int fan;
    public int getFan() {
        return fan;
    }
    public void setFan(int value) {
        fan = value;
        setEffective(emAirEffectiveBit.Fan);
    }

    @Override
    public void setSw(int value) {
        super.setSw(value);
        setEffective(emAirEffectiveBit.Switch);
    }

    public RoomAirs() {
        super();
        setnDevType(emDevicesType.Air.getValue());
        this.temp = 26;
        this.maxTemp = 28;
        this.minTemp = 21;
        this.mode = 1;
        this.timer = 0;
        this.fan = 0;
        this.nLength = 6;
    }

    public RoomAirs(int MaxTemp, int MinTemp) {
        super();
        setnDevType(emDevicesType.Air.getValue());
        this.temp = 15;
        this.maxTemp = MaxTemp;
        this.minTemp = MinTemp;
        this.mode = 1;
        this.timer = 0;
        this.fan = 0;
        this.nLength = 6;
    }

    /****
     * 设置有效位
     * @param airState
     */
    private void setEffective(emAirEffectiveBit airState) {
        //emAirEffectiveBit airState=emAirEffectiveBit.Switch;
        nEffectiveBit = 0;
        nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Switch.getValue() - 1);
        switch (airState) {
            case Switch:
                //break;
            case Temp:
                nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Temp.getValue() - 1);
                break;
            case Mode:
                nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Mode.getValue() - 1);
                break;
            case Timer:
                nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Timer.getValue() - 1);
                break;
            case Fan:
                nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Fan.getValue() - 1);
                break;
            default:
                nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Switch.getValue() - 1);
                nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Temp.getValue() - 1);
                nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Mode.getValue() - 1);
                nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Timer.getValue() - 1);
                nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Fan.getValue() - 1);
                break;
        }

        nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Switch.getValue()-1);
        nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Temp.getValue()-1);
        nEffectiveBit = GetEffectiveBit(emAirEffectiveBit.Mode.getValue()-1);
    }

    /****
     * 获取有效数据
     */
    @Override
    public String GetValidData() {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(this.getSw()), 2);
        strData += StringUtil.addLeft(Integer.toHexString(temp), 2);
        strData += StringUtil.addLeft(Integer.toHexString(mode), 2);
        strData += StringUtil.addLeft(Integer.toHexString(timer), 2);
        strData += StringUtil.addLeft(Integer.toHexString(fan), 2);

        return super.GetValidData();
    }

    /****
     * 设置参数
     */
    @Override
    public void SetParam(String strValidData) {
        super.SetParam(strValidData);
        SetParam();
    }

    /****
     * 设置数据
     */
    @Override
    public void SetData() {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(this.getSw()), 2);
        strData += StringUtil.addLeft(Integer.toHexString(temp), 2);
        strData += StringUtil.addLeft(Integer.toHexString(mode), 2);
        strData += StringUtil.addLeft(Integer.toHexString(timer), 2);
        strData += StringUtil.addLeft(Integer.toHexString(fan), 2);

        this.nLength = 6;
        super.SetData();
    }

    /****
     * 设置参数
     */
    @Override
    public void SetParam() {
        if (strData.isEmpty()) {
            super.SetParam();
        }
        if (strData.length() >= 2) {
            this.nEffectiveBit = Integer.parseInt(strData.substring(0, 2), 16);
        }
        if (strData.length() >= emAirEffectiveBit.Switch.getValue() * 2 + 2) {
            this.setSw(Integer.parseInt(StringUtil.SubString(strData, emAirEffectiveBit.Switch.getValue() * 2, 2), 16));
        }
        if (strData.length() >= emAirEffectiveBit.Temp.getValue() * 2 + 2) {
            this.temp = Integer.parseInt(StringUtil.SubString(strData, emAirEffectiveBit.Temp.getValue() * 2, 2), 16);
        }
        if (strData.length() >= emAirEffectiveBit.Mode.getValue() * 2 + 2) {
            this.mode = Integer.parseInt(StringUtil.SubString(strData, emAirEffectiveBit.Mode.getValue() * 2, 2), 16);
        }
        if (strData.length() >= emAirEffectiveBit.Timer.getValue() * 2 + 2) {
            this.timer = Integer.parseInt(StringUtil.SubString(strData, emAirEffectiveBit.Timer.getValue() * 2, 2), 16);
        }
        if (strData.length() >= emAirEffectiveBit.Fan.getValue() * 2 + 2) {
            this.fan = Integer.parseInt(StringUtil.SubString(strData, emAirEffectiveBit.Fan.getValue() * 2, 2), 16);
        }

        super.SetParam();
    }
}
