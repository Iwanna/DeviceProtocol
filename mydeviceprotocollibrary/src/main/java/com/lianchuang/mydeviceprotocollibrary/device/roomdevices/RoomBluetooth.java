package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;


import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emBluetoothEffectiveBit;
import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDevicesType;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class RoomBluetooth extends SuperDevice {

    /**
     * @param value 透传蓝牙数据位（20）
     */
    @Override
    public void setSw(int value) {
        super.setSw(value);
        setEffective();
    }

    private void setEffective() {
        nEffectiveBit = GetEffectiveBit(emBluetoothEffectiveBit.Switch.getValue() - 1);
    }

    public RoomBluetooth() {
        super();
        setnDevType(emDevicesType.Bluetooth.getValue());
        this.nLength = 21;
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

        this.nLength = 21;
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
        if (strData.length() >= (emBluetoothEffectiveBit.Switch.getValue() * 2 + 2)) {
            this.setSw(Integer.parseInt(StringUtil.SubString(strData, emBluetoothEffectiveBit.Switch.getValue() * 2, 2), 16));
        }

        super.SetParam();
    }
}
