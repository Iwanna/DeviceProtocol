package com.lianchuang.mydeviceprotocollibrary.protocol.utils;

public class CRCCheck {

    static int Table_CRC[]=new int[]{ 					/*cnCRC_CCITT*/
            0x0000,0x1021,0x2042,0x3063,0x4084,0x50a5,0x60c6,0x70e7,0x8108,0x9129,
            0xa14a,0xb16b,0xc18c,0xd1ad,0xe1ce,0xf1ef,0x1231,0x0210,0x3273,0x2252,
            0x52b5,0x4294,0x72f7,0x62d6,0x9339,0x8318,0xb37b,0xa35a,0xd3bd,0xc39c,
            0xf3ff,0xe3de,0x2462,0x3443,0x0420,0x1401,0x64e6,0x74c7,0x44a4,0x5485,
            0xa56a,0xb54b,0x8528,0x9509,0xe5ee,0xf5cf,0xc5ac,0xd58d,0x3653,0x2672,
            0x1611,0x0630,0x76d7,0x66f6,0x5695,0x46b4,0xb75b,0xa77a,0x9719,0x8738,
            0xf7df,0xe7fe,0xd79d,0xc7bc,0x48c4,0x58e5,0x6886,0x78a7,0x0840,0x1861,
            0x2802,0x3823,0xc9cc,0xd9ed,0xe98e,0xf9af,0x8948,0x9969,0xa90a,0xb92b,
            0x5af5,0x4ad4,0x7ab7,0x6a96,0x1a71,0x0a50,0x3a33,0x2a12,0xdbfd,0xcbdc,
            0xfbbf,0xeb9e,0x9b79,0x8b58,0xbb3b,0xab1a,0x6ca6,0x7c87,0x4ce4,0x5cc5,
            0x2c22,0x3c03,0x0c60,0x1c41,0xedae,0xfd8f,0xcdec,0xddcd,0xad2a,0xbd0b,
            0x8d68,0x9d49,0x7e97,0x6eb6,0x5ed5,0x4ef4,0x3e13,0x2e32,0x1e51,0x0e70,
            0xff9f,0xefbe,0xdfdd,0xcffc,0xbf1b,0xaf3a,0x9f59,0x8f78,0x9188,0x81a9,
            0xb1ca,0xa1eb,0xd10c,0xc12d,0xf14e,0xe16f,0x1080,0x00a1,0x30c2,0x20e3,
            0x5004,0x4025,0x7046,0x6067,0x83b9,0x9398,0xa3fb,0xb3da,0xc33d,0xd31c,
            0xe37f,0xf35e,0x02b1,0x1290,0x22f3,0x32d2,0x4235,0x5214,0x6277,0x7256,
            0xb5ea,0xa5cb,0x95a8,0x8589,0xf56e,0xe54f,0xd52c,0xc50d,0x34e2,0x24c3,
            0x14a0,0x0481,0x7466,0x6447,0x5424,0x4405,0xa7db,0xb7fa,0x8799,0x97b8,
            0xe75f,0xf77e,0xc71d,0xd73c,0x26d3,0x36f2,0x0691,0x16b0,0x6657,0x7676,
            0x4615,0x5634,0xd94c,0xc96d,0xf90e,0xe92f,0x99c8,0x89e9,0xb98a,0xa9ab,
            0x5844,0x4865,0x7806,0x6827,0x18c0,0x08e1,0x3882,0x28a3,0xcb7d,0xdb5c,
            0xeb3f,0xfb1e,0x8bf9,0x9bd8,0xabbb,0xbb9a,0x4a75,0x5a54,0x6a37,0x7a16,
            0x0af1,0x1ad0,0x2ab3,0x3a92,0xfd2e,0xed0f,0xdd6c,0xcd4d,0xbdaa,0xad8b,
            0x9de8,0x8dc9,0x7c26,0x6c07,0x5c64,0x4c45,0x3ca2,0x2c83,0x1ce0,0x0cc1,
            0xef1f,0xff3e,0xcf5d,0xdf7c,0xaf9b,0xbfba,0x8fd9,0x9ff8,0x6e17,0x7e36,
            0x4e55,0x5e74,0x2e93,0x3eb2,0x0ed1,0x1ef0};
//			
//			/*
//		*********************************************************************************************************
//		** 函数名称 ：CRC_16(uchar *aData, uint aSize)
//		** 函数功能 ：计算16 位CRC值,采用半字节计算方法
//		** 入口参数 ：aData：表示要传输的数据首地址，aSize表示数据的字节个数
//		**				f:2表示发送数据求CRC，指针偏移2；1表示接收数据求CRC，指针偏移1
//		** 出口参数 ：所处理数据的CRC校验码
//		*********************************************************************************************************
//		*/
//
//		INT16U CRC_16(INT8U *aData, INT16U aSize) /*计算1 位CRC值，采用CRC-CCITT*/
//		{ 					/*　aData：表示要传输的数据首地址，aSize表示数据的字节个数*/
//		    static INT16U i; 
//		    static INT16U nAccum; 
//			nAccum=0; 
//		    for (i=0; i<aSize;i++)
//		    { 
//		        nAccum = (nAccum<<8)^Table_CRC[(nAccum>>8)^aData[i]]; 
//		    }
//		    return nAccum; 
//		}

    /**
     * 求CRC16
     * @param data
     * @param size
     * @return
     */
    public int CRC_16(int[] data,int size){
        int crc16=0;
        for(int i=0;i<size;i++){
            crc16 = (crc16<<8)^Table_CRC[(crc16>>8)^data[i]];
        }
        return crc16;
    }

    /**
     * 转无符号数
     * @param s
     * @return
     */
    public static int unsignedInt(int s){
        return s&0xffff;
    }

//	 public static int toUnsignedInt(short x) {
//	        return ((int) x) & 0xffff;
//	    }
    /**
     * 计算CRC16值
     * @param data 要转换的字符串
     * @param type 转换类型(一般为0)
     * @return CRC校验码(就是要放在传输数据后面的)
     */
    public static int getCRC16(String data, int type) {
        int nCurVal = 0;
        int crc =  unsignedInt(0xffff);
        if(data.length()%2!=0){
            data ="0"+data;
        }
//		int crc = Short.toUnsignedInt((short) 0xffff);
        // short crc = (short) 0xffff;
        for (int i = 0; i < data.length();) {
            if (type == 0) {
                nCurVal = Integer.parseInt(data.substring(i, i + 2), 16);
            } else {
                nCurVal =0;
            }
            crc ^= nCurVal;
            for (int j = 0; j < 8; j++) {
                if (crc % 2 == 1) {
                    crc >>= 1;
                    crc ^= 0xA001;
                } else {
                    crc >>= 1;
                }
            }
            if (type == 0) {
                i += 2;
            } else {
                i++;
            }
        }
        return (int) crc & 0xFFFF;
    }


    /// <summary>
    /// 获取CRC16校验码
    /// 成功返回16位校验码的int值；否则返回0
    /// </summary>
    /// <param name="strData">被校验的字符串</param>
    /// <returns>成功，返回16位校验码的int值；否则返回0</returns>
    public static int GetCRC16(String strData)
    {
        int nDataLen=strData.length();
        if (nDataLen % 2 != 0)
        {
            strData += "0";
            nDataLen++;
        }
        byte[] szData = new byte[strData.length()];
        int nRet;
        int CRC16Lo, CRC16Hi;                       //CRC寄存器
        int CL, CH, SaveHi, SaveLo;                //多项式码&HA001
        int i, flag;
        CRC16Lo = 0xFF;
        CRC16Hi = 0xFF;
        CL = 0x01;
        CH = 0xA0;
        char[] hexChars = strData.toCharArray();
        for (i = 0; i < nDataLen; i++)
        {
            szData[i] =(byte)(((int)hexChars[i])&0xFF);
            CRC16Lo ^= szData[i];
            for (flag = 0; flag < 8; flag++)
            {
                SaveHi = CRC16Hi;
                SaveLo = CRC16Lo;
                CRC16Hi >>= 1;                    //高位右移一位
                CRC16Lo >>= 1;                    //低位右移一位
                if ((SaveHi & 0x1) == 0x1)      //如果高位字节最后一位为1
                    CRC16Lo |= 0x80;              //则低位字节右移后前面补1
                if ((SaveLo & 0x1) == 0x1)      //'如果LSB为1，则与多项式码进行异或
                {
                    CRC16Hi ^= CH;
                    CRC16Lo ^= CL;
                }
            }
        }
        nRet = CRC16Hi * 256 + CRC16Lo;
        return nRet;

    }





//	
//	int PubFunc::GetCheckCRC16Code(const char * buf,int nEnd,int nType/*=0*/)//获得CRC16校验码
//	{
//		unsigned short crc=unsigned short(0xffff);
//		int nCurVal;
//		CString csBuff;
//		csBuff=buf;
//		for (i=0; i<nEnd;)
//		{
//			if (nType==0)
//			{
//				nCurVal=HexToDec(csBuff.Mid(i,2)); //从i开始取两位
//			}
//			else
//			{
//				nCurVal=buf[i];
//			}
//			
//			crc^=nCurVal;
//			for(j = 0; j < 8; j++)
//			{
//				if(crc&1)
//				{
//					crc>>=1;
//					crc^=0xA001;
//				}
//				else
//					crc>>=1;
//			}
//
//			if (nType==0)
//			{
//				i=i+2;
//			}
//			else
//			{
//				i++;
//			}
//		}
//		return int(crc) & 0xFFFF;
//	}

    /**
     * 十六进制转十进制
     * @return
     */
    public static int HexToDec(String hex) {
        return Integer.parseInt(hex, 16);
    }

    /**
     * 十进制转十六进制
     * @param dec
     * @return
     */
    public static String DecToHex(int dec){
        return Integer.toHexString(dec);
    }

    /**
     * 十进制转二进制
     * @param dec
     * @return
     */
    public static String DecToBin(int dec){
        return Integer.toBinaryString(dec);
    }

    /**
     * 二进制转十进制
     * @param bin
     * @return
     */
    public static int BinToDec(String bin){
        return Integer.parseInt(bin, 2);
    }

    /**
     * 二进制转十六进制
     * @param bin
     * @return
     */
    public static String binToHex(String bin){
        return Integer.toHexString(Integer.parseInt(bin, 2));
    }

    /**
     * 十六进制转二进制
     * @param hex
     * @return
     */
    public static String hexToBin(String hex){
        return Integer.toBinaryString(Integer.parseInt(hex, 16));
    }



}
