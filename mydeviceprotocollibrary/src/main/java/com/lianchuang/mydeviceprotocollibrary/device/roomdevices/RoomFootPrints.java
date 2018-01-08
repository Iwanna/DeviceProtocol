package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;


import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDevicesType;
import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emFootPrintEffectiveBit;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class RoomFootPrints extends SuperDevice {
    /**
     * 开片取电
     */
    private int cardStatus;

    /**
     * 手机取电
     */
    private int mobileStatus;

    public int getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(int value) {
        this.cardStatus = value;
    }

    public int getMobileStatus() {
        return mobileStatus;
    }

    public void setMobileStatus(int value) {
        this.mobileStatus = value;
    }

    /****
     * 设置开关位
     */
    @Override
    public void setSw(int value) {
        super.setSw(value);
        setEffective(emFootPrintEffectiveBit.Switch);
    }

    public RoomFootPrints() {
        super();
        setnDevType(emDevicesType.FootPrint.getValue());
        this.nLength = 4;
    }

    /****
     * 设置有效位
     * @param state
     */
    private void setEffective(emFootPrintEffectiveBit state) {
        nEffectiveBit = 0;
        nEffectiveBit = GetEffectiveBit(emFootPrintEffectiveBit.Switch.getValue() - 1);
        switch (state) {
            case Switch:
                break;
            case CardStatus:
                nEffectiveBit = GetEffectiveBit(emFootPrintEffectiveBit.CardStatus.getValue() - 1);
                break;
            case MobileStatus:
                nEffectiveBit = GetEffectiveBit(emFootPrintEffectiveBit.MobileStatus.getValue() - 1);
                break;
            default:
                nEffectiveBit = GetEffectiveBit(emFootPrintEffectiveBit.Switch.getValue() - 1);
                break;
        }
    }

    /****
     * 获取有效数据
     */
    @Override
    public String GetValidData() {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(this.getSw()), 2);
        strData += StringUtil.addLeft(Integer.toHexString(cardStatus), 2);
        strData += StringUtil.addLeft(Integer.toHexString(mobileStatus), 2);
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
        if (strData.length() >= emFootPrintEffectiveBit.Switch.getValue() * 2 + 2) {
            this.setSw(Integer.parseInt(StringUtil.SubString(strData, emFootPrintEffectiveBit.Switch.getValue() * 2, 2), 16));
        }
        if (strData.length() >= emFootPrintEffectiveBit.CardStatus.getValue() * 2 + 2) {
            this.cardStatus = Integer.parseInt(StringUtil.SubString(strData, emFootPrintEffectiveBit.CardStatus.getValue() * 2, 2), 16);
        }
        if (strData.length() >= emFootPrintEffectiveBit.MobileStatus.getValue() * 2 + 2) {
            this.mobileStatus = Integer.parseInt(StringUtil.SubString(strData, emFootPrintEffectiveBit.MobileStatus.getValue() * 2, 2), 16);
        }

        super.SetParam();
    }

    /****
     * 设置数据
     */
    @Override
    public void SetData() {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(this.getSw()), 2);
        strData += StringUtil.addLeft(Integer.toHexString(cardStatus), 2);
        strData += StringUtil.addLeft(Integer.toHexString(mobileStatus), 2);
        this.nLength = 4;
        super.SetData();
    }
}
