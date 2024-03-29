package cn.connext.toolback.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CommonUtil {
    private static final long MILLIS_PER_DAY = 86400000L;
    private static final long TIME_ZONE_OFFSET = TimeZone.getDefault().getRawOffset();

    //考虑到勤务指挥室8：30换班
    private static final long eightThirtyMills=30600000L;

    /**
     * 获取指定时间当日 00:00:00 时刻的时间戳
     */
    public static Long getDayZeroTimestamp(Date date) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(simpleDateFormat.format(date)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /**
     * 传入一个时间，获取当天的交班时间，其实就是以早上8：30为界
     */
    public static Long getChangeDutyClassTime(Date date){
        Long zeroTime=getDayZeroTimestamp(date);
        return zeroTime+eightThirtyMills;
    }

    /**
     * 传入一个时间，获取前天的零点。（获取上个班次）
     */
    public static Long getLastDayZeroTime(Date date){
        Long todayZeroTime=getDayZeroTimestamp(date);
        return todayZeroTime-MILLIS_PER_DAY;
    }

    /**
     * 传入一个时间，返回排班时间
     */
    public static Date getTrueDutyClassDate(Date date){
        Long todayZeroTime=getDayZeroTimestamp(date);
        Long changeDutyClassTime= CommonUtil.getChangeDutyClassTime(new Date());
        Long curDateTime=new Date().getTime();
        if(curDateTime>changeDutyClassTime){
            return new Date(todayZeroTime);
        }else{
            return new Date(todayZeroTime-MILLIS_PER_DAY);
        }
    }
}
