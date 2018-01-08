package com.lianchuang.mydeviceprotocollibrary.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Law
 * @date 2017/6/13
 */
public class StringUtil {

    /**
     * 将字符串中的O转成0  I转成1
     * @param code
     * @return
     */

    public static String replace(String code){
        code = toUpperCase(code).replace("O","0").replace("I","1");
        return code;
    }

    /**
     * 字符串转成大写
     * @param code  要转换的字符串（可以包含非字母的字符）
     * @return
     */
    public static String toUpperCase(String code){
        return code.toUpperCase();
    }

    /**
     * 字符串转成小写
     * @param code  要转换的字符串（可以包含非字母的字符）
     * @return
     */
    public static String toLowerCase(String code){
        return code.toLowerCase();
    }

    /**
     * 在字符串左边填充0以达到指定长度(length)的字符串(若字符串本身长度超出length，则返回原字符串)
     *
     * @param data
     *            要填充的字符串
     * @param length
     *            要达到的长度
     * @return
     */
    public static String addLeft(String data, int length) {
        if (data.length() >= length) {
        	data=data.substring(0, length);
            return data;
        } else {
            int dataLength = data.length();
            StringBuilder stringBuilder = new StringBuilder(data);
            for (int i = 0; i < length - dataLength; i++) {
                //data = "0" + data;
                stringBuilder.insert(0,"0");
            }
            data = stringBuilder.toString();
        }
        return data;
    }

    /**
     * 在字符串右边填充0以达到指定长度(length)的字符串(若字符串本身长度超出length，则返回原字符串)
     *
     * @param data
     *            要填充的字符串
     * @param length
     *            要达到的长度
     * @return
     */
    public static String addRight(String data, int length) {
        if (data.length() >= length) {
            return data;
        } else {
            int dataLength = data.length();
            StringBuilder stringBuilder = new StringBuilder(data);
            for (int i = 0; i < length - dataLength; i++) {
                //data = data + "0";
                stringBuilder.append("0");
            }
            data = stringBuilder.toString();
        }
        return data;
    }

    /**
     * 在字符串任意一边填充字符以达到指定长度的字符串(若字符串本身长度超出指定长度，则返回原字符串)
     * @param data   要填充的原字符串
     * @param c	          要填充的字符
     * @param length 制定长度
     * @param type   指定右边填充或者左边填充(1:左边  0:右边)
     * @return
     */
    public static String addRandom(String data, char c, int length, int type) {
        if (data.length() >= length) {
            return data;
        } else {
            int dataLength = data.length();
            for (int i = 0; i < length - dataLength; i++) {
                //left
                if (type == 1) {
                    data = c+data;
                } else if (type == 0) {
                    data = data + c;
                }
            }
        }
        return data;
    }

    /**
     * 重复字符串
     *
     * @param data
     *            要重复的字符串
     * @param times
     *            要重复的次数
     * @return
     */
    public static String repeatString(String data, int times) {
        String result = data;
        if (times <= 0) {
            return null;
        }
        for (int i = 0; i < times; i++) {
            data += result;
        }
        return data;
    }

    /**
     * 替换字符，索引从1开始
     * */
    public static String replaceString(String data,int index,String strData)
    {
        String result=data;

        if(index>result.length()) {
            return result;
        }
        else
        {
            String strRet1=data.substring(0,index-1);
            String strRet2=data.substring(index);
            result=strRet1+strData+strRet2;
            return result;
        }
    }
    
    public static String replaceString(String data,int index,int length,String strData)
    {
    	String result=data;
        String strRet1="";
        if(index>result.length())
            return result;
        else
        {
            if(index>0) {
                strRet1 = data.substring(0, index - 1);
            }
            String strRet2=data.substring(index+length);
            String strRet3=strData;
        	for(int i=1;i<length;i++)
        	{
        		strRet3+=strData;
        	}
            
            result=strRet1+strRet3+strRet2;
            return result;
        }
    }
    
public static String removeString(String data,int index,String strData) {
		
    	String result=data;
    	if(index >result.length()) {
            return result;
        }
    	else
    	{
    		String strRet1=data.substring(0,index-1);
    		String strRet2=data.substring(index+strData.length());
    		result=strRet1+strRet2;
    		return result;
    	}
	}

    public static String SubString(String data,int start,int nLength)
    {
        data= data.substring(start,start+nLength);
        return  data;
    }

    public static List<String> TravelString(String data,String substr)
    {
        if(!data.endsWith(substr))
            data=data+substr;
        List<String> ls = new ArrayList<String>();
        int index;
        for (int i=0;i<data.length();)
        {
            index= data.indexOf(substr,i);
            ls.add(data.substring(i,index));
            i=index+substr.length();
        }
        return ls;
    }

    public static  String ReverseString(String data)
    {
        String strNewData="";
        for (int i=0;i<data.length();i++)
        {
            strNewData+=data.substring(data.length()-1-i,data.length()-i);
        }
        return strNewData;
    }
}
