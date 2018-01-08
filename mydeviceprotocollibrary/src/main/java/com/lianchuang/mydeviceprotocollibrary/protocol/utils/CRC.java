package com.lianchuang.mydeviceprotocollibrary.protocol.utils;

import com.lianchuang.mydeviceprotocollibrary.utils.StringUtil;

/**
 * Created by Administrator on 2017/05/05.
 */

public class CRC {
    public static String getCrc16Code(String crcString)
    {
        // 转换成字节数组
        byte[] creBytes = HexString2Bytes(crcString);

        // 开始crc16校验码计算
        CRCUtils crc16 = new CRCUtils();
        crc16.reset();
        crc16.update(creBytes);
        int crc = crc16.getCrcValue();
        // 16进制的CRC码

        String crcCode = Integer.toHexString(crc).toLowerCase();
        // 补足到4位
        if (crcCode.length() < 4)
        {
            // crcCode = StringUtil.lefgPadding(crcCode, '0', 4);
            //crcCode = crcCode.PadLeft(4, '0');
            crcCode = StringUtil.addLeft(crcCode,4);
        }
        return crcCode;
    }

    public static String RealHexToStr(String str)
    {
        String hText = "0123456789ABCDEF";
        StringBuilder bin = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            //bin.Append(hText[str[i] / 16]).Append(hText[str[i] % 16]).Append(' ');
            bin.append(hText.charAt(str.charAt(i) / 16)).append(hText.charAt(str.charAt(i) % 16)).append(' ');
        }
        return bin.toString();
    }

    /**
     * 十六进制字符串转换成字节数组
     *
     * @param hexstr
     * @return
     */
    public static byte[] HexString2Bytes(String hexstr)
    {
        byte[] b = new byte[hexstr.length() / 2];
        int j = 0;
        for (int i = 0; i < b.length; i++)
        {
            char c0 = hexstr.charAt(j++);
            char c1 = hexstr.charAt(j++);
            b[i] = (byte)((parse(c0) << 4) | parse(c1));
        }
        return b;
    }

    /**
     * 16进制char转换成整型
     *
     * @param c
     * @return
     */
    public static int parse(char c)
    {
        if (c >= 'a')
            return (c - 'a' + 10) & 0x0f;
        if (c >= 'A')
            return (c - 'A' + 10) & 0x0f;
        return (c - '0') & 0x0f;
    }
}
