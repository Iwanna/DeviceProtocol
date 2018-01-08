package com.lianchuang.mydeviceprotocollibrary.protocol.utils;


import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

public class ConvertUitl {

    /**
     * 字符串转十六进制字符串
     * @param str 要转换的字符串
     * @return
     */
    public static String str2HexStr(String str)
    {

        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;

        for (int i = 0; i < bs.length; i++)
        {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }
    
    /** 
	  * 将两个ASCII字符合成一个字节； 
	  * 如："EF"--> 0xEF 
	  * @param src0 byte 
	  * @param src1 byte 
	  * @return byte 
	  */ 	  
	  public static byte uniteBytes(byte src0, byte src1) { 
		  byte _b0 = Byte.decode("0x" + new String(new byte[]{src0})).byteValue(); 
		  _b0 = (byte)(_b0 << 4); 
		  byte _b1 = Byte.decode("0x" + new String(new byte[]{src1})).byteValue(); 
		  byte ret = (byte)(_b0 ^ _b1); 
		  return ret; 
	  } 

    /**
     * 十六进制字符串转字节
     * @param src
     * @return
     */
    public static byte[] hexStr2Bytes(String src)
    {
    	if (null == src || 0 == src.length())return null;
		  src = src.replace(" ", "").toUpperCase();
		  byte[] ret = new byte[src.length() / 2]; 
		  byte[] tmp = src.getBytes(); 
		  for (int i = 0; i < (tmp.length / 2); i++)
			  ret[i] = uniteBytes(tmp[i*2], tmp[i*2+1]); 		  
		  return ret; 
//        int m,n;
//        int l=src.length()/2;
//        System.out.println(l);
//        byte[] ret = new byte[l];
//        for (int i = 0; i < l; i++)
//        {
//            m=i*2+1;
//            n=m+1;
//            //ret[i] = Byte.decode("0x" + src.substring(i*2, m) + src.substring(m,n));
//            ret[i] = Byte.decode("0x"+ com.lianchuang.hotelguest.util.StringUtil.SubString(src, i * 2, 2));
//            String strRet= com.lianchuang.hotelguest.util.StringUtil.SubString(src, i * 2, 2);
//        }
//
//        return ret;
    }
    
    //获取切分指令,分为2组 一组20字节,不足第1组的尾数补0，第二组为null。超出一组不足第2组的，第2组尾数补0.超出2组的不处理，是BUG
    public static String[] GetSubStr(String parentStr) {
		parentStr = parentStr.replace(" ", "").toUpperCase();
		int l = parentStr.length();
		String[] rs = new String[]{"",null};
 		if (l==40||l>80)rs[0] = parentStr;
 		if(l<40) {
 			for (int i = l; i < 40; i++) parentStr+="0";
 			rs[0] = parentStr;
 		}
 		if(l>40&&l<80){
 			rs[1]=parentStr.substring(40);
 			for (int i = l; i < 80; i++) rs[1]+="0";
  			rs[0] = parentStr.substring(0, 40);
	  	}
	  	return rs;
}

    private static String hexString="0123456789ABCDEF";
    /**
     * 将字符串编码成16进制数字,适用于所有字符（包括中文）
     */
    public static String encode(String str){
        byte[] bytes=null;
        //根据默认编码获取字节数组
        try {
            bytes=str.getBytes("GB2312");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        StringBuilder sb=new StringBuilder(bytes.length*2);
        //将字节数组中每个字节拆解成2位16进制整数
        for(int i=0;i<bytes.length;i++){
            sb.append(hexString.charAt((bytes[i]&0xf0)>>4));
            sb.append(hexString.charAt((bytes[i]&0x0f)>>0));
        }
        return sb.toString();
    }



    /**
     * Convert byte[] string to hex
     * @param src the byte[]
     * @return hex string
     */
    public static String bytesToHexString(byte[] src){

    //  StringBuilder stringBuilder = new StringBuilder("");
    //  if (src == null || src.length <= 0) {
    //          return null;
    //  }
    //  for (int i = 0; i < src.length; i++) {
    //          int v = src[i] & 0xFF;
    //          String hv = Integer.toHexString(v);
    //          if (hv.length() < 2) {
    //              stringBuilder.append(0);
    //          }
    //          stringBuilder.append(hv);
    //  }
    //  return stringBuilder.toString();
    	String result = "";
        for (int i = 0; i < src.length; i++) {
            String hexString = Integer.toHexString(src[i] & 0xFF);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            result += hexString.toUpperCase();
        }
        return result;
    }

    /**
     * Convert hex string to byte[]
     * @param hexString the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        if((hexString.length()%2)!=0)
            hexString = StringUtil.addLeft(hexString, hexString.length() + 1);
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    public static String IntTohexString(int value)
    {
        String strResult=Integer.toHexString(value);
        if(strResult.length()%2!=0)
            strResult= StringUtil.addLeft(strResult, strResult.length() + 1);
        return strResult;
    }

    /**
     * Convert char to byte
     * @param c char
     * @return byte
     */
    public static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sbu.append(IntTohexString((int)chars[i]));
        }
        return sbu.toString();
    }

    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
}
