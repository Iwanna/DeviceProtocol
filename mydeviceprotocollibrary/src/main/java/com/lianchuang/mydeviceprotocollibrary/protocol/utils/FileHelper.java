package com.lianchuang.mydeviceprotocollibrary.protocol.utils;

import android.Manifest;
import android.content.Context;
import android.os.Environment;
import android.util.Log;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author Law
 * @date 2017/6/13
 */
public class FileHelper {
    private static final String TAG = "FileHelper";
    private Context mContext;
    public String mContent;
    // Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    public FileHelper(Context _mContext) {
        mContext = _mContext;
    }


    /**
     * 在手机本地硬盘中保存信息
     * @param fileName
     * @param content
     */
    public  void save(String fileName, String content) {

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = mContext.openFileOutput(fileName,
                    Context.MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 在手机本地硬盘中保存信息
     * @param fileName
     * @param content
     * @param AppendFlag
     */
    public static void save(String fileName, String content,boolean AppendFlag) {

        FileOutputStream fileOutputStream = null;
        try {
            File file=new File(Environment.getDataDirectory(), fileName);
            fileOutputStream=new FileOutputStream(file, AppendFlag);
            fileOutputStream.write(content.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取手机硬盘中保存的文件
     * @param fileName
     */
    public void read(String fileName) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = mContext.openFileInput(fileName);
            int len;
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
            while ((len = fileInputStream.read(buffer)) != -1) {
                byteArrayInputStream.write(buffer, 0, len);
            }
            String string = new String(byteArrayInputStream.toByteArray());
            this.mContent=string;
            Log.d(TAG, string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 保存到SD卡
     * @param fileName
     * @param content
     * @return
     */
    public static boolean saveToSDCard(String fileName, String content) {

        // judge weather the SDCard exits,and can be read and written
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return false;
        }

        FileOutputStream fileOutputStream = null;
        File file = new File(Environment.getExternalStorageDirectory(),
                fileName);
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 保存到SD卡
     * @param fileName
     * @param content
     * @param AppendFlag
     * @return
     */
    public static boolean saveToSDCard(String fileName,String content,Boolean AppendFlag)
    {
    	// judge weather the SDCard exits,and can be read and written
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return false;
        }

        FileOutputStream fileOutputStream = null;
        File file = new File(Environment.getExternalStorageDirectory(),
                fileName);
        try {
            fileOutputStream = new FileOutputStream(file, AppendFlag);
            fileOutputStream.write(content.getBytes());
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 下面是读取位于SDCard根目录下文件的操作方法
     * @param fileName
     * @return
     */
    public static String readFromSD(String fileName) {
        FileInputStream fileInputStream = null;
        File file = new File(Environment.getExternalStorageDirectory(),
                fileName);
        try {
            fileInputStream = new FileInputStream(file);
            int len;
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
            while ((len = fileInputStream.read(buffer)) != -1) {
                byteArrayInputStream.write(buffer, 0, len);
            }
            String string = new String(byteArrayInputStream.toByteArray());

            return string;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 下面是读取位于SDCard根目录下文件的操作方法
     * @param fileName
     * @return
     */
    public static String readSDFileData(String fileName) {
        String res=null;
        try{
            File file = new File(Environment.getExternalStorageDirectory(),
                    fileName);
            FileInputStream fin = new FileInputStream(file);
            int length = fin.available();
            byte [] buffer = new byte[length];
            fin.read(buffer);
            res = new String(buffer,"UTF-8");
            fin.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 读取手机硬盘中保存的文件
     * @param fileName
     * @return
     */
    public String readFileData(String fileName) {
        String res=null;
        try{
            FileInputStream fin = mContext.openFileInput(fileName);
            int length = fin.available();
            byte [] buffer = new byte[length];
            fin.read(buffer);
            res = new String(buffer,"UTF-8");
            fin.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 如果要使用文件名获取文件数据：首先获取资源id然后再通过id获取输入流
     * @param im
     * @return
     */
    public static String ReadRawFile(InputStream im)
    {
        // 如果要使用文件名获取文件数据：首先获取资源id然后再通过id获取输入流
        BufferedReader read = new BufferedReader(new InputStreamReader(im));
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            while((line = read.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if(read != null) {
                try {
                    read.close();
                    read = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(im != null) {
                try {
                    im.close();
                    im = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.v("", "result = " + sb.toString());
        return sb.toString();
    }

    /**
     * 根据文件路径读取数据
     * @param strPath 路径
     * @param hashMap 集合对象存取文件读完标志
     * @param k 分段读取文件
     * @return
     */
    public static String readFromPath(String strPath,HashMap<String, Boolean>hashMap,int k)
    {
    	FileInputStream fileInputStream = null;
    	File file=new File(strPath);
    	int length=1024;
    	try {
            fileInputStream = new FileInputStream(file);
            int len;
            byte[] buffer = new byte[length];

            ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
            while ((len = fileInputStream.read(buffer)) != -1) {
                byteArrayInputStream.write(buffer, 0, len);
            }
            buffer = new byte[length];
            len=byteArrayInputStream.toByteArray().length;
            if((k+1)*length<len){
            	hashMap.put("Flag", false);
				System.arraycopy(byteArrayInputStream.toByteArray(), k*length, buffer, 0, buffer.length);
			}
			else{
				hashMap.put("Flag", true);
				buffer = new byte[len-k*length];
				System.arraycopy(byteArrayInputStream.toByteArray(), k*length, buffer, 0, len-k*length);
			}
            /**String string = EncodingUtils.getString(buffer, "UTF-8");*/
            String string = new String(buffer,"UTF-8");
            return string;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
        	e.printStackTrace();
    	}finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String readFromSDCard(String strPath,HashMap<String, Boolean>hashMap,int k,int length)
    {
        FileInputStream fileInputStream = null;
        File file = new File(Environment.getExternalStorageDirectory(),
                strPath);
        //int length=1024;
        try {
            fileInputStream = new FileInputStream(file);
            int len;
            byte[] buffer = new byte[length];

            ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
            while ((len = fileInputStream.read(buffer)) != -1) {
                byteArrayInputStream.write(buffer, 0, len);
            }
            buffer = new byte[length];
            len=byteArrayInputStream.toByteArray().length;
            if((k+1)*length<len){
                hashMap.put("Flag", false);
                System.arraycopy(byteArrayInputStream.toByteArray(), k*length, buffer, 0, buffer.length);
            }
            else{
                hashMap.put("Flag", true);
                buffer = new byte[len-k*length];
                System.arraycopy(byteArrayInputStream.toByteArray(), k*length, buffer, 0, len-k*length);
            }
            String string = ConvertUitl.bytesToHexString(buffer);
            //String string = EncodingUtils.getString(buffer, "UTF-8");
            return string;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String readDataFromPath(String strPath,HashMap<String, Boolean>hashMap,int k)
    {
        FileInputStream fileInputStream = null;
        File file=new File(strPath);
        int length=1024;
        try {
            fileInputStream = new FileInputStream(file);
            int len;
            byte[] buffer = new byte[length];

            ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
            while ((len = fileInputStream.read(buffer)) != -1) {
                byteArrayInputStream.write(buffer, 0, len);
            }
            buffer = new byte[length];
            len=byteArrayInputStream.toByteArray().length;
            if((k+1)*length<len){
                hashMap.put("Flag", false);
                System.arraycopy(byteArrayInputStream.toByteArray(), k*length, buffer, 0, buffer.length);
            }
            else{
                hashMap.put("Flag", true);
                buffer = new byte[len-k*length];
                System.arraycopy(byteArrayInputStream.toByteArray(), k*length, buffer, 0, len-k*length);
            }
            String string = ConvertUitl.bytesToHexString(buffer);
            //String string = EncodingUtils.getString(buffer, "UTF-8");
            return string;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 根据文件路径读取数据
     * @param strPath 路径
     * @param hashMap 集合对象存取文件读完标志
     * @param k 分段读取文件
     * @return
     */
    public static String readFromPath(String strPath)
    {
        FileInputStream fileInputStream = null;
        File file=new File(strPath);
        int length=1024;
        try {
            fileInputStream = new FileInputStream(file);
            int len;
            byte[] buffer = new byte[length];

            ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
            while ((len = fileInputStream.read(buffer)) != -1) {
                byteArrayInputStream.write(buffer, 0, len);
            }
            String string = byteArrayInputStream.toString();
            return string;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    
    public static String findFile (File file, String keyword)   
    {   
        String res = "";   
        if (!file.isDirectory())   
        {   
            res = "不是目录";   
            return res;    
        }   
        //File[] files = new File(file.getPath()).listFiles();   
           
        res=SearchDir(file,keyword);
//        for (File f : files)   
//        {
//            if (f.getName().indexOf(keyword) >= 0)   
//            {   
//                res += f.getPath() + "\n";   
//            }   
//        }
          if (res.equals(""))   
        {   
            res = "没有找到相关文件";   
        }
        return res;
    }   
    
    private static String SearchDir(File f,String keyword)
    {
    	String res = "";   
    	if(f.isDirectory()){
    		File[] files=new File(f.getPath()).listFiles();
    		
    		for (File file : files) {
				if(file.isDirectory())
				{
					res=SearchDir(file,keyword);
					if(res.length()!=0)
						break;
				}
				else
				{
					if (f.getName().indexOf(keyword) >= 0)   
		            {   
		                res += f.getPath() + "\n";   
		            }   
				}
			}
    	}
    	return res;
    }
}
