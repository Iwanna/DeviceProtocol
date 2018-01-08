package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;


import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDevicesType;
import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emLampEffectiveBit;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class RoomLamps extends SuperDevice {
    public static int SwitchOn = 1;
    private static final int maxColor = 255;
    /**
     * 黄色
     */
    private int colorYellow;
    public int getColorYellow() {
        return colorYellow;
    }
    public void setColorYellow(int value) {
        if (value > maxColor) {
            colorYellow = maxColor;
        } else if (value <= 1) {
            colorYellow = 1;
        } else {
            colorYellow = value;
        }
        setEffective(emLampEffectiveBit.ColorYellow);
    }

    /**
     * 白光
     */
    private int colorWhite;
    public int getColorWhite() {
        return colorWhite;
    }
    public void setColorWhite(int value) {
        if (value > maxColor) {
            colorWhite = maxColor;
        } else if (value <= 1) {
            colorWhite = 1;
        } else {
            colorWhite = value;
        }
        setEffective(emLampEffectiveBit.ColorWhite);
    }

    /**
     * 红光
     */
    private int colorRed;
    public int getColorRed() {
        return colorRed;
    }
    public void setColorRed(int value) {
        if (value > maxColor) {
            colorRed = maxColor;
        } else {
            colorRed = value;
        }
        setEffective(emLampEffectiveBit.ColorRed);
    }

    /**
     * 緑光
     */
    private int colorGreen;
    public int getColorGreen() {
        return colorGreen;
    }
    public void setColorGreen(int value) {
        if (value > maxColor) {
            colorGreen = maxColor;
        } else {
            colorGreen = value;
        }
        setEffective(emLampEffectiveBit.ColorGreen);
    }

    /**
     * 蓝光
     */
    private int colorBlue;
    public int getColorBlue() {
        return colorBlue;
    }
    public void setColorBlue(int value) {
        if (value > maxColor) {
            colorBlue = maxColor;
        } else {
            colorBlue = value;
        }
        setEffective(emLampEffectiveBit.ColorBlue);
    }

    /****
     * 设置开关位
     */
    @Override
    public void setSw(int value) {
        String devName = "灯带";
        if (value == 0) {
            if ((getStrDevName() == null) || (!getStrDevName().contains(devName))) {
                setColorWhite(255);
                setColorYellow(255);
            } else {
                setColorRed(0);
                setColorGreen(0);
                setColorBlue(0);
            }
        } else {
            if ((getStrDevName() == null) || (!getStrDevName().contains(devName))) {
                setColorWhite(1);
                setColorYellow(1);
            } else {
                setColorRed(255);
                setColorGreen(255);
                setColorBlue(255);
            }
        }
        super.setSw(value);
    }

    /****
     * 设置有效位
     * @param state
     */
    private void setEffective(emLampEffectiveBit state) {
        nEffectiveBit = 0;
        switch (state) {
            case ColorYellow:
            case ColorWhite:
                nEffectiveBit = 03;
                //nEffectiveBit = GetEffectiveBit(emLampEffectiveBit.ColorYellow.getValue()-1);
                //nEffectiveBit = GetEffectiveBit(emLampEffectiveBit.ColorWhite.getValue()-1);
                break;
            case ColorRed:
            case ColorGreen:
            case ColorBlue:
                nEffectiveBit = 31;
                //nEffectiveBit = GetEffectiveBit(emLampEffectiveBit.ColorGreen.getValue()-1);
                //nEffectiveBit = GetEffectiveBit(emLampEffectiveBit.ColorRed.getValue()-1);
                //nEffectiveBit = GetEffectiveBit(emLampEffectiveBit.ColorBlue.getValue()-1);
                break;
            default:
                break;
        }
    }

    public RoomLamps() {
        super();
        setnDevType(emDevicesType.Lamp.getValue());
        this.nLength = 6;
    }

    /****
     * 获取有效数据
     */
    @Override
    public String GetValidData() {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(colorYellow), 2);
        strData += StringUtil.addLeft(Integer.toHexString(colorWhite), 2);
        strData += StringUtil.addLeft(Integer.toHexString(colorRed), 2);
        strData += StringUtil.addLeft(Integer.toHexString(colorGreen), 2);
        strData += StringUtil.addLeft(Integer.toHexString(colorBlue), 2);

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
        strData += StringUtil.addLeft(Integer.toHexString(colorYellow), 2);
        strData += StringUtil.addLeft(Integer.toHexString(colorWhite), 2);
        strData += StringUtil.addLeft(Integer.toHexString(colorRed), 2);
        strData += StringUtil.addLeft(Integer.toHexString(colorGreen), 2);
        strData += StringUtil.addLeft(Integer.toHexString(colorBlue), 2);

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
        if (strData.length() >= (emLampEffectiveBit.ColorYellow.getValue() * 2 + 2)) {
            this.colorYellow = Integer.parseInt(StringUtil.SubString(strData, emLampEffectiveBit.ColorYellow.getValue() * 2, 2), 16);
        }
        if (strData.length() >= (emLampEffectiveBit.ColorWhite.getValue() * 2 + 2)) {
            this.colorWhite = Integer.parseInt(StringUtil.SubString(strData, emLampEffectiveBit.ColorWhite.getValue() * 2, 2), 16);
        }
        if (strData.length() >= (emLampEffectiveBit.ColorRed.getValue() * 2 + 2)) {
            this.colorRed = Integer.parseInt(StringUtil.SubString(strData, emLampEffectiveBit.ColorRed.getValue() * 2, 2), 16);
        }
        if (strData.length() >= (emLampEffectiveBit.ColorGreen.getValue() * 2 + 2)) {
            this.colorGreen = Integer.parseInt(StringUtil.SubString(strData, emLampEffectiveBit.ColorGreen.getValue() * 2, 2), 16);
        }
        if (strData.length() >= (emLampEffectiveBit.ColorBlue.getValue() * 2 + 2)) {
            this.colorBlue = Integer.parseInt(StringUtil.SubString(strData, emLampEffectiveBit.ColorBlue.getValue() * 2, 2), 16);
        }

        super.SetParam();
    }

    @Override
    public String OpenDevice() {
        return super.OpenDevice();
    }
}

