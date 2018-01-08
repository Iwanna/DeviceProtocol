package com.lianchuang.mydeviceprotocollibrary.device.roomdevices;


import com.lianchuang.mydeviceprotocollibrary.device.enumeration.emDevicesType;

/**
 * @author Law
 * @date 2017/6/13
 */
public class DevicesContext
{

    /****
     * 获取设备对象
     * @param nDeviceType
     * @return
     */
    public static SuperDevice GetObj(int nDeviceType) {
        SuperDevice sd;
        if (nDeviceType == emDevicesType.Lamp.getValue()) {
            sd = new RoomLamps();
        } else if ((nDeviceType == emDevicesType.Bulb.getValue())||(nDeviceType == emDevicesType.RemoteSwitch.getValue())) {
            sd = new RoomBulbs();
        } else if (nDeviceType == emDevicesType.CenterAir.getValue()) {
            sd = new RoomCenterAirs();
        } else if (nDeviceType == emDevicesType.DoorBell.getValue()) {
            sd = new RoomDoorBells();
        } else if (nDeviceType == emDevicesType.Curtain.getValue()) {
            sd = new RoomCurtains();
        } else if (nDeviceType == emDevicesType.FootPrint.getValue()) {
            sd = new RoomFootPrints();
        } else if (nDeviceType == emDevicesType.Air.getValue()) {
            sd = new RoomAirs();
        } else if (nDeviceType == emDevicesType.Tv.getValue()) {
            sd = new RoomTvs();
        } else if (nDeviceType == emDevicesType.Body_IR.getValue()) {
            sd = new RoomIR();
        } else if(nDeviceType == emDevicesType.Lock.getValue()){
            sd = new RoomLock();
        } else if(nDeviceType == emDevicesType.Bluetooth.getValue()){
            sd = new RoomBluetooth();
        } else if (nDeviceType == emDevicesType.Group.getValue()) {
            //sd = new RoomAirs(35, 15);
            sd = new SuperDevice();
        } else {
            sd = new SuperDevice();
        }
        sd.setnDevType(nDeviceType);
        return sd;
    }
}


