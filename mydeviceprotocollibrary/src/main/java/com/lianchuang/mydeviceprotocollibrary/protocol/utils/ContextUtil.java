package com.lianchuang.mydeviceprotocollibrary.protocol.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


import com.lianchuang.mydeviceprotocollibrary.protocol.Addresses;
import com.lianchuang.mydeviceprotocollibrary.protocol.constant.Constants;
import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/04/26.
 */

public class ContextUtil {


    /****
     * 获取文件内容数组
     * @param context 上下文
     * @param strFileName 文件名字
     * @return 返回文件内容数组
     */
    public static String[] getFileStrings(Context context, String strFileName) {
        String strFileData=null;
        if(strFileData==null)
        {
            FileHelper fileHelper=new FileHelper(context);
            strFileData=fileHelper.readFileData(strFileName);
        }
        String[]strings;
        if(strFileData!=null) {
            if(strFileData.contains("\r\n"))
            {
                if(!strFileData.endsWith("\r\n"))
                    strFileData=strFileData+"\r\n";
                strings=strFileData.split("\r\n");
            }
            else if(strFileData.contains("\n"))
            {
                if(!strFileData.endsWith("\n"))
                    strFileData=strFileData+"\n";
                strings=strFileData.split("\n");
            }
            else {
                if(!strFileData.endsWith("\n"))
                    strFileData=strFileData+"\n";
                strings=strFileData.split("\n");
            }
        }
        else {
            strFileData="";
            if (!strFileData.endsWith("\n"))
                strFileData = strFileData + "\n";
            strings = strFileData.split("\n");
        }
        return strings;
    }

    /****
     * 获取文件内容数组
     * @param context 上下文
     * @param strFileName 文件名字
     * @return 返回文件内容数组
     */
    public static String[] getFileStringsFromSD(String strFileName) {
        String strFileData=FileHelper.readSDFileData(strFileName);
        String[]strings;
        if(strFileData!=null) {
            if(strFileData.contains("\r\n"))
            {
                if(!strFileData.endsWith("\r\n"))
                    strFileData=strFileData+"\r\n";
                strings=strFileData.split("\r\n");
            }
            else if(strFileData.contains("\n"))
            {
                if(!strFileData.endsWith("\n"))
                    strFileData=strFileData+"\n";
                strings=strFileData.split("\n");
            }
            else {
                if(!strFileData.endsWith("\n"))
                    strFileData=strFileData+"\n";
                strings=strFileData.split("\n");
            }
        }
        else {
            strFileData="";
            if (!strFileData.endsWith("\n"))
                strFileData = strFileData + "\n";
            strings = strFileData.split("\n");
        }
        return strings;
    }

    /**
     * 获取窗帘反向标志
     * @param context 上下文
     * @param nDevType 设备类型
     * @param strDevName 设备名称
     * @param strValidData 有效数据
     * @return
     */
    public static String getCurtainReverseFlag(Context context,int nDevType,String strDevName,String strValidData){
        String strRet="",devId,strDevId;
        int nType;
        String[]strings=getFileStrings(context,"key_map.txt");
        strDevId=strValidData.substring(0,4);
        for(int i=0;i<strings.length;i++)
        {
            if(strings[i].length()==0){continue;}
            int firstIndex=strings[i].indexOf(" ");
            int secondIndex=strings[i].indexOf(" ",firstIndex+1);
            int thirdIndex=strings[i].indexOf(" ",secondIndex+1);
            devId= StringUtil.SubString(strings[i],secondIndex-4,secondIndex);
            String devName;
            if(thirdIndex==-1){
                devName=strings[i].substring(secondIndex+1);
            }
            else{
                devName=StringUtil.SubString(strings[i],secondIndex+1,thirdIndex-secondIndex-1);
            }
            nType=Integer.parseInt(strings[i].substring(firstIndex-2, firstIndex), 16);
            if(nType== nDevType)
            {
                if(devName.contains(strDevName)&&(devId.equals(strDevId))){
                    if(strValidData.length()>=8) {
                        strRet = strValidData.substring(6, 8);
                    }
                }
            }
        }
        return strRet;
    }

    /**
     * 保存设备状态
     * @param sp
     * @param strDevState 设备状态
     */
    public static void saveAllDevState(SharedPreferences sp, String strDevState)
    {
        boolean bRet=false;
        Set<String> stateSet;
        Set<String>stateTempSet=new HashSet<>();
        //取出已存设备ID集合
        stateSet=sp.getStringSet("stateSet",null);

        if(stateSet==null){
            stateSet=new HashSet<>();
            //将新的添加
            stateSet.add(String.valueOf(strDevState));
        }
        else {
            //遍历现有集合是否包含设备状态
            for (String state : stateSet) {
                //如果子元素中包含设备ID
                if (state.contains(strDevState.substring(0, 4))) {
                    bRet = true;
                    state = strDevState;
                    stateTempSet.add(state);
                }
                else {//如果子元素中不包含设备ID
                    stateTempSet.add(state);
                }
            }
            if (!bRet) {
                stateTempSet.add(strDevState);
            }
            stateSet=stateTempSet;
        }
        sp.edit().putStringSet("stateSet",stateSet).commit();//保存设备状态
    }

    /**
     * 获取门铃状态
     * @param context 上下文
     * @param nDevType 设备类型
     * @param strDevName 设备名称
     * @param strValidData 优秀数据
     * @return
     */
    public static String getDoorBellState(Context context,int nDevType,String strDevName,String strValidData){
        String strRet="", strDevId,devId;
        int nType;
        String[]strings=getFileStrings(context,"key_map.txt");
        strDevId=strValidData.substring(0,4);
        for(int i=0;i<strings.length;i++)
        {
            if(strings[i].length()==0){continue;}
            int firstIndex=strings[i].indexOf(" ");
            int secondIndex=strings[i].indexOf(" ",firstIndex+1);
            int thirdIndex=strings[i].indexOf(" ",secondIndex+1);
            devId=StringUtil.SubString(strings[i],secondIndex-4,secondIndex);
            String devName;
            if(thirdIndex==-1){
                devName=strings[i].substring(secondIndex+1);
            }
            else{
                devName=StringUtil.SubString(strings[i],secondIndex+1,thirdIndex-secondIndex-1);
            }
            nType=Integer.parseInt(strings[i].substring(firstIndex-2, firstIndex), 16);
            if(nType== nDevType)
            {
                if(devName.contains(strDevName)&&(devId.equals(strDevId))){
                    if(strValidData.length()>=8) {
                        strRet = strValidData.substring(6, 8);
                    }
                }
            }
        }
        return strRet;
    }

    /**
     * 应用从后台推到前台
     * @param context 上下文
     * @param cls 界面
     */
    public static void backTofront(Context context, Activity cls)
    {
        //获取ActivityManager
        ActivityManager mAm = (ActivityManager) context.getSystemService(context.ACTIVITY_SERVICE);
        //获得当前运行的task
        List<ActivityManager.RunningTaskInfo> taskList = mAm.getRunningTasks(100);
        for (ActivityManager.RunningTaskInfo rti : taskList) {
            //找到当前应用的task，并启动task的栈顶activity，达到程序切换到前台
            if(rti.topActivity.getPackageName().equals(context.getPackageName())) {
                try {
                    Intent resultIntent = new Intent(context, Class.forName(rti.topActivity.getClassName()));
                    resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    context.startActivity(resultIntent);
                }catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        //若没有找到运行的task，用户结束了task或被系统释放，则重新启动MainActivity
        Intent resultIntent = new Intent(context, cls.getClass());
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(resultIntent);
    }

    /**
     * 获取房间地址
     * @param addr
     * @return
     */
    public static String getRoomAddr(Addresses addr){
        String strRet=null;
        int Region=addr.RegionNo.getnUnitValue(),Build=addr.BuildingNo.getnUnitValue(),
                Floor=addr.FloorNo.getnUnitValue(),RoomNum=addr.RoomNo.getnUnitValue();

        String[]strings=getFileStringsFromSD("roominfo.txt");
        for (int i = 0; i < strings.length; i++) {
            String strResult=strings[i];
            //1、南区|1、1栋|1、5层|1:1、南区-1栋-5层-501
            String strTemp1 = strResult.substring(0,strResult.indexOf("|"));
            //strTemp1=1、南区,strTemp2=1、1栋|1、5层|1:1、南区-1栋-5层-501
            String strTemp2 = strResult.substring(strResult.indexOf("|")+1);
            if(strTemp1.contains(Integer.toString(Region)))
            {
                //strTemp3=1、1栋
                String strTemp3=strTemp2.substring(0,strTemp2.indexOf("|"));
                if(strTemp3.contains(Integer.toString(Build)))
                {
                    //1、5层|1:1、南区-1栋-5层-501
                    strTemp2=strTemp2.substring(strTemp2.indexOf("|")+1);
                    //1、5层
                    strTemp3=strTemp2.substring(0,strTemp2.indexOf("|"));
                    if(strTemp3.contains(Integer.toString(Floor)))
                    {
                        //1:1、南区-1栋-5层-501
                        strTemp2=strTemp2.substring(strTemp2.indexOf("|")+1);
                        String strRoomNum=strTemp2.substring(strTemp2.indexOf(":")+1, strTemp2.indexOf("、"));
                        if(strRoomNum.equals(Integer.toString(RoomNum)))
                        {
                            strRet=strTemp2.substring(strTemp2.indexOf("、")+1);
                            break;
                        }else{continue;}
                    }
                    else {continue;}
                }
                else {continue;}
            }
        }
        return  strRet;
    }

    /****
     * 获取请求名称
     * @param nRequestId 请求ID
     * @return
     */
    public static String GetRequestName(int nRequestId) {
        String strRequestName = "";
        if (nRequestId == Constants.CHECKOUT) {
            strRequestName = "退房";
        } else if (nRequestId == Constants.CLEAN) {
            strRequestName = "清理";
        } else if (nRequestId == Constants.HELP) {
            strRequestName = "服务";
        } else if (nRequestId == Constants.NODISTURB) {
            strRequestName = "勿扰";
        } else if(nRequestId==Constants.EMERGENCY){
            strRequestName = "紧急呼救";
        } else if(nRequestId==Constants.HOLDON){
            strRequestName = "稍后";
        }
        return strRequestName;
    }
}
