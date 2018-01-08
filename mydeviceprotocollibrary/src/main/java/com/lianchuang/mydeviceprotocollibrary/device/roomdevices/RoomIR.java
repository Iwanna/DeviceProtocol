package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;


import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDevicesType;
import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emIREffectiveBit;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class RoomIR extends SuperDevice {

    @Override
    public void setSw(int value) {
        super.setSw(value);
        setEffective();
    }

    private void setEffective() {
        nEffectiveBit = GetEffectiveBit(emIREffectiveBit.Switch.getValue() - 1);
    }

    public RoomIR() {
        super();
        setnDevType(emDevicesType.Body_IR.getValue());
        this.nLength = 2;
    }

    @Override
    public String GetValidData() {
        strData = "";
        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(this.getSw()), 2);
        return super.GetValidData();
    }

    @Override
    public void SetParam(String strValidData) {
        super.SetParam(strValidData);

        SetParam();
    }

    @Override
    public void SetData() {
        strData = "";

        strData += StringUtil.addLeft(Integer.toHexString(nEffectiveBit), 2);
        strData += StringUtil.addLeft(Integer.toHexString(super.getSw()), 2);

        this.nLength = 2;
        super.SetData();
    }

    @Override
    public void SetParam() {
        if (strData.isEmpty()) {
            super.SetParam();
        }
        if (strData.length() >= 2) {
            this.nEffectiveBit = Integer.parseInt(strData.substring(0, 2), 16);
        }
        if (strData.length() >= (emIREffectiveBit.Switch.getValue() * 2 + 2)) {
            this.setSw(Integer.parseInt(StringUtil.SubString(strData, emIREffectiveBit.Switch.getValue() * 2, 2), 16));
        }

        super.SetParam();
    }

    @Override
    public String OpenDevice() {
        return super.OpenDevice();
    }
}
