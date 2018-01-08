package com.lianchuang.mydeviceprotocollibrary.protocol;


import com.lianchuang.mydeviceprotocollibrary.protocol.constant.Constants;

/**
 * @author Law
 * @date 2017/6/13
 */
public class Addresses {
    /**
     * 区域号
     */
    public SuperUnit RegionNo = new SuperUnit(Constants.RegionNoStart, Constants.RegionNoLength);
    /**
     * 楼栋号
     */
    public SuperUnit BuildingNo = new SuperUnit(Constants.BuildingNoStart, Constants.BuildingNoLength);
    /**
     * 楼层号
     */
    public SuperUnit FloorNo = new SuperUnit(Constants.FloorNoStart, Constants.FloorNoLength);
    /**
     * 房间号
     */
    public SuperUnit RoomNo = new SuperUnit(Constants.RoomNoStart, Constants.RoomNoLength);


}
