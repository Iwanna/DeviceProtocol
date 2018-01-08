package com.lianchuang.mydeviceprotocollibrary.protocol.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 计算日期的工具
 * @author Law
 * @date 2017/6/13
 */
public class DateUtil {


    public static long daysBetween(Calendar begin, Calendar end) {
        // 复制
        Calendar calendar = (Calendar) begin.clone();
        long daysBetween = 0;
        while(calendar.before(end)) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }
    
    
	@SuppressLint("SimpleDateFormat")
	public static long daysBetween(String begin,String end)throws Exception{
    	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
    	
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(format.parse(begin));
    	long time1 = cal.getTimeInMillis();
    	cal.setTime(format.parse(end));
    	long time2 = cal.getTimeInMillis();
    	long between = (time2 - time1) ;
    	return between;
    }
    /**
     * 计算当前日期与设定日期之间的天数
     *
     * @param year
     *            设定日期的年
     * @param month
     *            设定日期的月
     * @param day
     *            设定日期的天
     * @return
     * @throws Exception
     */
    public static long calDays(int year, int month, int day) throws Exception {
        GregorianCalendar calendar1 = new GregorianCalendar();
        // calendar月份会在当前基础减1
        calendar1.add(Calendar.MONTH, 1);
        
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        
        long restTime = calendar.getTimeInMillis() - calendar1.getTimeInMillis();
        long restDays = restTime / (1000 * 3600 * 24);

        return restDays;
    }
    
    public static long calMinutes(Date date,int type)throws Exception
    {
    	Date now=new Date();
    	String strNow=now.getHours()+":"+now.getMinutes();
    	Date reNow=strToDate(strNow, type);
    	
    	
    	
    	long restTime=date.getTime()-reNow.getTime();
    	long restMinutes=restTime/(1000*60);
   	
    	return restMinutes;
    }

    /**
     * 判断字符串是否为有效数字
     *
     * @param number
     * @return
     */
    public static boolean isValidNum(String number) {
        boolean isValid = false;
        // 有小数点情况:①-开头(可有可无) (0.一个 ) 多个数字 非零结尾 ②-开头(可有可无)非0至少一个 数字至少一个 .多个数字
        // 非零结尾 ③无小数点情况下:-开头(可有可无) 非0至少一个 数字结尾
        String expression = "(^-{0,1}(0.){1}[0-9]+[1-9]$)|(^-{0,1}(([1-9]+[0-9]+).){1}[0-9]+[1-9]$)|(^-{0,1}[1-9]+[0-9]+[0-9]$)";
        // String expression1 = "^-{0,1}(([1-9]+[0-9]+).){1}[0-9]+[1-9]$";
        // String expression2 = "^-{0,1}[1-9]+[0-9]+[0-9]$";
        isValid = matchPattern(expression, number);
        return isValid;

    }

    /**
     * 匹配是否成功
     *
     * @param expression
     *            要匹配的表达式
     * @param stringPattern
     *            匹配规则
     * @return
     */
    public static boolean matchPattern(String expression, String stringPattern) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(stringPattern);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * 判断两个时间是否重叠
     *
     * @param strStart1
     *            起始时间点1 如09:10
     * @param strEnd1
     *            结束时间点1
     * @param strStart2
     *            起始时间点2
     * @param strEnd2
     *            结束时间点2
     * @return
     */
    public static boolean isTimeOverlap(String strStart1, String strEnd1, String strStart2, String strEnd2, int type) {
        Date dStart1, dEnd1, dStart2, dEnd2;
        try {
            dStart1 = strToDate(strStart1, type);
            dEnd1 = strToDate(strEnd1, type);
            dStart2 = strToDate(strStart2, type);
            dEnd2 = strToDate(strEnd2, type);
            if (dStart1.equals(dStart2) && dEnd1.equals(dEnd2)) {
                return true;
            }
            if (dStart1.before(dStart2)) {
                if (dEnd2.before(dEnd1) || dEnd1.equals(dEnd2)) {
                    return true;
                } else
                    return false;
            } else {
                if (dEnd1.before(dEnd2)) {
                    return true;
                } else
                    return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }
    
    /***
     * 在传入的时间值上加上秒数
     * @param strTime
     * 				输入时间 如2015-08-06 14:41:30
     * @param seconds
     * 				分钟数 取正时为加时间 取负时为减时间
     * @return
     * @throws Exception
     */
    @SuppressLint("SimpleDateFormat")
	public static String timeAddSeconds(String strTime,int seconds) throws Exception{
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date oldTime=format.parse(strTime);
			oldTime.setTime(oldTime.getTime() + seconds * 1000);
			String currStrTime = format.format(oldTime);
			return currStrTime;
		}catch(ParseException e){
			throw new Exception("输入时间参数有误  正确格式为：yyyy-MM-dd HH:mm:ss");
		}
	}

    /**
     * 在传入的时间值上加上分钟数
     *
     * @param strTime
     *            输入时间 如2015-08-06 14:41:30
     * @param minutes
     *            分钟数 取正时为加时间 取负时为减时间
     * @return
     * @throws Exception
     */
    @SuppressLint("SimpleDateFormat")
	public static String timeAddMinute(String strTime, int minutes) throws Exception {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date oldTime = format.parse(strTime);
            oldTime.setTime(oldTime.getTime() + minutes * 60 * 1000);
            String currStrTime = format.format(oldTime);
            return currStrTime;
        } catch (ParseException e) {
            throw new Exception("输入时间参数有误  正确格式为：yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 在传入的时间值上加上天数
     *
     * @param strTime
     *            输入时间 如2015-08-06 14:41:30
     * @param days
     *            天数数 取正时为加时间 取负时为减时间
     * @return
     * @throws Exception
     */
    @SuppressLint("SimpleDateFormat")
	public static String timeAddDay(String strTime, int days) throws Exception {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date oldTime = format.parse(strTime);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(oldTime);
            calendar.add(Calendar.DAY_OF_YEAR, days);
            Date time = calendar.getTime();
            String currStrTime = format.format(time);
            return currStrTime;
        } catch (ParseException e) {
            throw new Exception("输入时间参数有误  正确格式为：yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 在传入的时间值上加上天数
     *
     * @param strTime
     *            输入时间 如2015-08-06 14:41:30
     * @param days
     *            天数数 取正时为加时间 取负时为减时间
     * @return
     * @throws Exception
     */
    @SuppressLint("SimpleDateFormat")
    public static String timeAddDay(String strTime, int days,SimpleDateFormat format) throws Exception {
        try {
            Date oldTime = format.parse(strTime);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(oldTime);
            calendar.add(Calendar.DAY_OF_YEAR, days);
            Date time = calendar.getTime();
            String currStrTime = format.format(time);
            return currStrTime;
        } catch (ParseException e) {
            throw new Exception("输入时间参数格式有误");
        }
    }

    /**
     * 在传入的时间值上加上小时数
     *
     * @param strTime
     *            输入时间 如2015-08-06 14:41:30
     * @param hours
     *            小时数 取正时为加时间 取负时为减时间
     * @return
     * @throws Exception
     */
    @SuppressLint("SimpleDateFormat")
	public static String timeAddHour(String strTime, int hours) throws Exception {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date oldTime = format.parse(strTime);
            oldTime.setTime(oldTime.getTime() + hours * 60 * 60 * 1000);
            String currStrTime = format.format(oldTime);
            return currStrTime;
        } catch (ParseException e) {
            throw new Exception("输入时间参数有误  正确格式为：yyyy-MM-dd HH:mm:ss");
        }

    }

    /**
     * 根据年月日计算星期
     *
     * @param year
     * @param month
     * @param day
     * @return 星期数 0~6 星期天~星期六
     */
    public static int getWeek(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        // calendar中默认1月是0
        calendar.set(year, month - 1, day);
        int week = 0;
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                week = 0;
                break;
            case Calendar.MONDAY:
                week = 1;
                break;
            case Calendar.TUESDAY:
                week = 2;
                break;
            case Calendar.WEDNESDAY:
                week = 3;
                break;
            case Calendar.THURSDAY:
                week = 4;
                break;
            case Calendar.FRIDAY:
                week = 5;
                break;
            case Calendar.SATURDAY:
                week = 6;
                break;
            default:
                break;
        }
        return week;

    }

    /**
     * 根据传入日期的时间字符串，获取时间或日期
     *
     * @param strDate
     *            输入日期 如2015-08-06 14:09:30
     * @param type
     *            0-取日期 1-取时间
     * @return
     * @throws Exception
     */
    @SuppressLint("SimpleDateFormat")
	public static String splitDate(String strDate, int type) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        String strf = null;
        SimpleDateFormat fOut = null;
        try {
            date = format.parse(strDate);
            if (type == 0) {
                fOut = new SimpleDateFormat("yyyy-MM-dd");
                strf = fOut.format(date);
                return strf;
            } else if (type == 1) {
                fOut = new SimpleDateFormat("HH:mm:ss");
                strf = fOut.format(date);
                return strf;
            }
        } catch (ParseException e) {
            throw new Exception("输入时间参数有误  正确格式为：yyyy-MM-dd HH:mm:ss");

        }
        return null;
    }

    /**
     * 字符串转日期类型
     *
     * @param strDate
     *            字符串时间
     * @param type
     *            字符串时间的形式 0:yyyy-MM-dd 1:HH:mm 其他:yyyy-MM-dd HH:mm
     * @return
     * @throws Exception
     */
    @SuppressLint("SimpleDateFormat")
	public static Date strToDate(String strDate, int type) throws Exception {
        SimpleDateFormat format = null;
        Date date = null;
        try {
            if (type == 0) {
                format = new SimpleDateFormat("yyyy-MM-dd");
                date = format.parse(strDate);
                return date;
            } else if (type == 1) {
                format = new SimpleDateFormat("HH:mm");
                date = format.parse(strDate);
                return date;
            } else {
                format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                date = format.parse(strDate);
                return date;
            }
        } catch (ParseException e) {
            throw new Exception("输入时间格式有误!");

        }
    }

    /**
     * 计算某年的开始日期与结束日期 如2015-09-01 2015-09-30
     *
     * @param year
     *            要计算的年份
     * @param month
     *            要计算的月份
     * @return
     */
    public static String[] getCurrentMonth(int year, int month) {
        String[] startEnd = { "", "" };
        int maxDays = 0;
        int currmonth = 0;
        int curryear = 0;
        if (year <= 0 || month <= 0) {
            Calendar currCalendar = Calendar.getInstance();
            System.out.println(currCalendar.getMaximum(Calendar.MONTH));
            Date currentDate = new Date();
            currCalendar.setTime(currentDate);
            currmonth = currCalendar.get(Calendar.MONTH) + 1;
            System.out.println(currmonth);
            curryear = currCalendar.get(Calendar.YEAR);
            System.out.println(curryear);
        } else {
            currmonth = month;
            curryear = year;
        }
        switch (currmonth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                maxDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDays = 30;
                break;
            case 2:
                if (curryear % 400 == 0 || (curryear % 100 == 0 && curryear % 4 == 0)) {// 闰年
                    maxDays = 29;
                } else {
                    maxDays = 28;
                }
                break;
            default:
                try {
                    throw new Exception("输入月份参数异常！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        StringBuffer start = new StringBuffer();
        start.append(curryear).append("-").append(currmonth).append("-").append("01");
        StringBuffer end = new StringBuffer();
        end.append(curryear).append("-").append(currmonth).append("-").append(maxDays);

        startEnd[0] = start.toString();
        startEnd[1] = end.toString();

        return startEnd;
    }

    /**
     * 去除掉小数点最末尾的0
     *
     * @return
     */
    public static String trim0(String num) {
        if (num.indexOf(".") >= 1) {
            num = num.replaceAll("0+?$", "");
            num = num.replaceAll("[.]$", ""); // 当没有小数位后 去除小数点
        }
        return num;
    }

    /**
     * 判断名字是否合法
     *
     * @param name
     * @return
     */
    public static boolean isNameLegal(String name) {
        String[] c = { "\\", ":", "?", "*", "|", "<", ">", "\\", "\"" };
        for (int i = 0; i < c.length; i++) {
            if (name.contains(c[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将输入的日期转换成对应的字符串
     *
     * @param date
     *            输入的日期
     * @param type
     *            转换格式 0：yyyy-MM-dd 1：HH:mm:ss 其他参数: yyyy-MM-dd HH:mm:ss
     * @return 对应时间的字符串
     */
    @SuppressLint("SimpleDateFormat")
	public static String dateToStr(Date date, int type) {
        SimpleDateFormat dateFormat;
        String dateString;
        switch (type) {
            case 0:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateString = dateFormat.format(date);
                break;
            case 1:
                dateFormat = new SimpleDateFormat("HH:mm:ss");
                dateString = dateFormat.format(date);
                break;
            default:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dateString = dateFormat.format(date);
                break;
        }
        return dateString;
    }

    public static String dateToStr(Date date)
    {
    	String dateString;
    	Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);      
        int month = c.get(Calendar.MONTH)+1;
        int day =  c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute =  c.get(Calendar.MINUTE);
        int sec =  c.get(Calendar.SECOND);
    	
    	dateString=Integer.toString(year);
    	if(month<10)
    		dateString+="0"+Integer.toString(month);
    	else
    		dateString+=Integer.toString(month);
    	if(day<10)
    		dateString+="0"+Integer.toString(day);
    	else
    		dateString+=Integer.toString(day);
    	if(hour<10)
    		dateString+="0"+Integer.toString(hour);
    	else
    		dateString+=Integer.toString(hour);
    	if(minute<10)
    		dateString+="0"+Integer.toString(minute);
    	else
    		dateString+=Integer.toString(minute);
    	if(sec<10)
    		dateString+="0"+Integer.toString(sec);
    	else
    		dateString+=Integer.toString(sec);
    	return dateString;
    }

}
