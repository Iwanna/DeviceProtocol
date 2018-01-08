package com.lianchuang.mydeviceprotocollibrary.protocol.origin;


import com.lianchuang.mydeviceprotocollibrary.protocol.constant.ConstantValues;

/**
 * @author Law
 */
public class Addressing {
    /**
     * 酒店编号
     */
    public DataUnit HotelNo = new DataUnit(ConstantValues.HotelNoStart, ConstantValues.HotelNoLength);
    /**
     * 区域号
     */
    public DataUnit RegionNo = new DataUnit(ConstantValues.RegionNoStart, ConstantValues.RegionNoLength);
    /**
     * 楼栋号
     */
    public DataUnit BuildingNo = new DataUnit(ConstantValues.BuildindNoStart, ConstantValues.BuildindNoLength);
    /**
     * 楼层号
     */
    public DataUnit FloorNo = new DataUnit(ConstantValues.FloorNoStart, ConstantValues.FloorNoLength);
    /**
     * 房间号
     */
    public DataUnit RoomNo = new DataUnit(ConstantValues.RoomNoStart, ConstantValues.RoomNoLength);
}
