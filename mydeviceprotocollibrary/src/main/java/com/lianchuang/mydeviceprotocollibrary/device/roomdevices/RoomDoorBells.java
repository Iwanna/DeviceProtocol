package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;


import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDevicesType;
import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDoorBellEffectiveBit;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * @author Law
 * @date 2017/6/13
 */
public class RoomDoorBells extends SuperDevice
{
    /****
     * 设置开关位
     */
    @Override
    public void setSw(int value)
    {
        super.setSw(value);
        setEffective(emDoorBellEffectiveBit.Switch);
    }
    /****
     * 设置有效位
     * @param state
     */
    private void setEffective(emDoorBellEffectiveBit state)
    {
        nEffectiveBit=0;
        nEffectiveBit = GetEffectiveBit(emDoorBellEffectiveBit.Switch.getValue()-1);
    }

    public RoomDoorBells()
    {
        super();
        setnDevType(emDevicesType.DoorBell.getValue());
        this.nLength = 2;
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
        if (strData.length() >= emDoorBellEffectiveBit.Switch.getValue() * 2 + 2) {
            this.setSw(Integer.parseInt(StringUtil.SubString(strData, emDoorBellEffectiveBit.Switch.getValue() * 2, 2), 16));
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
        this.nLength = 2;
        super.SetData();
    }
}
