package com.example.swpumapserv.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-15 12:38
 **/
public class DateHelper extends org.apache.commons.lang3.time.DateUtils {
    private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
            "yyyy.MM.dd HH:mm", "yyyy.MM", "yyyyMMddHHmmss", "yyyy-MM-dd-HH:mm:ss" };

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss",
     * "yyyy/MM/dd HH:mm", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    public static Date currentDateAdd(int days) {
        // 日期处理模块 (将日期加上某些天或减去天数)返回字符串
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
        return canlendar.getTime();
    }

    public static long getMillis(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();

    }

    /**
     * 得到分钟数
     *
     * @param date
     * @param date1
     * @return
     */
    public static int diffDateForMin(java.util.Date date, java.util.Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (60 * 1000));

    }

    /**
     * 获取多少天后的日期
     *
     * @param date
     * @param day
     * @return
     * @author c3gen
     */
    public static String getDate(Date date, int day) {
        // 格式化时间工具类
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 万年历获取对象
        Calendar calendar = Calendar.getInstance();
        // 设置时间为传进来的参数
        calendar.setTime(date);
        // 相隔天数
        calendar.add(Calendar.DAY_OF_MONTH, day);
        // 获取相隔天数后的日期
        Date tmp = calendar.getTime();
        // 转换为指定下格式
        String newday = sdf.format(tmp);
        // 返回
        return newday;

    }

    /**
     * 获取多少天后的日期
     *
     * @param date
     * @param day
     * @return
     */
    public static Date getDateFromNow(Date date, int day) {
        // 万年历获取对象
        Calendar calendar = Calendar.getInstance();
        // 设置时间为传进来的参数
        calendar.setTime(date);
        // 相隔天数
        calendar.add(Calendar.DAY_OF_MONTH, day);
        // 获取相隔天数后的日期
        Date tmp = calendar.getTime();
        // 返回
        return tmp;
    }

    /**
     * 某日所在月的第一天和最后一天
     *
     * @param date
     * @param month month =0 表示当前月 month=-1表示上个月
     * @return
     */

    public static Map<String, String> getFirstday_Lastday_Month(Date date, int month) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        Date theDate = calendar.getTime();

        // 上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);

        System.out.println(gcLast.getWeekYear());

        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
        day_first = str.toString();

        // 上个月最后一天
        calendar.add(Calendar.MONTH, 1); // 加一个月
        calendar.set(Calendar.DATE, 1); // 设置为该月第一天
        calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
        String day_last = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_last).append(" 23:59:59");
        day_last = endStr.toString();

        Map<String, String> map = new HashMap<String, String>();
        map.put("first", day_first);
        map.put("last", day_last);
        return map;
    }

    /**
     * 某年某日所在月的第一天和最后一天
     *
     * @param date
     * @param month month =0 表示当前月, month>0 表示上个月,month<0表示以后的月份,比如当前日期2017-12-12 那么 month =1 表示11月,month=-1 表示2018年1月
     * @param year year>0表示之前的年份,year=0表示今年,year <0 表示以后的年份,比如当前日期2017-12-12 那么 year =1 表示2016年,year=-1 表示2018年
     * @return
     */
    public static Map<String, String> getFirstday_Lastday_Month_Year(Date date, int month, int year) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        Date theDate = calendar.getTime();

        Calendar c2 = Calendar.getInstance();

        // 上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);

        StringBuffer day_first = new StringBuffer().append(c2.get(calendar.YEAR) - year).append("-")
                .append(c2.get(calendar.MONTH) + 1).append("-").append("01").append(" 00:00:00");

        // 上个月最后一天
        calendar.add(Calendar.YEAR, -year);
        calendar.add(Calendar.MONTH, 1); // 加一个月
        calendar.set(Calendar.DATE, 1); // 设置为该月第一天
        calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
        String day_last = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_last).append(" 23:59:59");
        day_last = endStr.toString();

        Map<String, String> map = new HashMap<String, String>();
        map.put("first", day_first.toString());
        map.put("last", day_last);
        return map;
    }

    /**
     * 获取某年当年月统计时间段
     *
     * @param date
     * @return
     */
    public static Map<String, String> getMomthDate(Date date, int year) {
        Map<String, String> map = new HashMap<>();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, year);
        Date y = c.getTime();
        String tempM = DateHelper.formatDate(y, "MM");
        String tempD = DateHelper.formatDate(y, "dd");
        String tempY = DateHelper.formatDate(y, "yyyy");
        String beginTime = "";
        String endTime = "";

        System.out.println(DateHelper.formatDate(date, "yyyy-MM-dd HH:mm:ss"));
        // 一月份
        if (Integer.valueOf(tempM) == 1) {

            if (Integer.valueOf(tempD) <= 20) {
                beginTime = (Integer.valueOf(tempY) - 1) + "-" + 11 + "-21 00:00:00";
                endTime = (Integer.valueOf(tempY) - 1) + "-" + 12 + "-20 23:59:59";
            } else {
                beginTime = (Integer.valueOf(tempY) - 1) + "-" + 12 + "-21 00:00:00";
                endTime = tempY + "-" + tempM + "-20 23:59:59";
            }

        } else {

            if (Integer.valueOf(tempD) <= 20) {
                beginTime = tempY + "-" + (Integer.valueOf(tempM) - 2) + "-21 00:00:00";
                endTime = tempY + "-" + (Integer.valueOf(tempM) - 1) + "-20 23:59:59";
            } else {
                beginTime = tempY + "-" + (Integer.valueOf(tempM) - 1) + "-21 00:00:00";
                endTime = tempY + "-" + tempM + "-20 23:59:59";
            }

        }
        map.put("first", beginTime);
        map.put("last", endTime);
        return map;
    }

    /**
     * 获取某年上个月月统计时间段
     *
     * @param date
     * @return
     */
    public static Map<String, String> getLastMomthDate(Date date, int year) {
        Map<String, String> map = new HashMap<>();
        Calendar c = Calendar.getInstance();
        // Date d = DateHelper.parseDate(date);
        c.setTime(date);
        c.add(Calendar.YEAR, year);
        Date y = c.getTime();
        String tempM = DateHelper.formatDate(y, "MM");
        String tempY = DateHelper.formatDate(y, "yyyy");
        String beginTime = "";
        String endTime = "";
        System.out.println(DateHelper.formatDate(date, "yyyy-MM-dd HH:mm:ss"));
        // 一月份
        if (Integer.valueOf(tempM) == 1) {
            beginTime = (Integer.valueOf(tempY) - 1) + "-" + 10 + "-21 00:00:00";
            endTime = (Integer.valueOf(tempY) - 1) + "-" + 11 + "-20 23:59:59";
        } else {
            beginTime = tempY + "-" + (Integer.valueOf(tempM) - 2) + "-21 00:00:00";
            endTime = tempY + "-" + (Integer.valueOf(tempM) - 1) + "-20 23:59:59";

        }
        map.put("first", beginTime);
        map.put("last", endTime);
        return map;
    }

}
