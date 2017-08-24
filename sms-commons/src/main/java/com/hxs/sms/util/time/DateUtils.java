package com.hxs.sms.util.time;

import com.hxs.sms.util.log.LoggerUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    static SimpleDateFormat ldf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 转换最小时间
     *
     * @param date 日期时间
     * @return 最小时间的日期 00:00:00
     */
    public static Date toMinTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 转换为最大时间
     *
     * @param date 日期时间
     * @return 最大时间的日期 23:59:59
     */
    public static Date toMaxTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) {
        try {
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);

            return Integer.parseInt(String.valueOf(between_days));
        } catch (Exception e) {
            LoggerUtil.error(DateUtils.class, "计算两个日期之间相差的天数发生异常：" + e.getMessage(), e);
        }
        return 0;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(String smdate, String bdate) {
        try {
            Date startDate = sdf.parse(smdate);
            Date endDate = sdf.parse(bdate);

            return daysBetween(startDate, endDate);
        } catch (Exception e) {
            LoggerUtil.error(DateUtils.class, "计算两个日期之间相差的天数发生异常：" + e.getMessage(), e);
        }
        return 0;
    }

    public static String format(String format, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sdf.format(date);
    }

    public static String formatShort(Date date) {
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sdf.format(date);
    }

    public static String formatLong(Date date) {
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return ldf.format(date);
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
    }
}
