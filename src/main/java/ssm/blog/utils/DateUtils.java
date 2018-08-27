package ssm.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangshuxuan
 * @date 2018/8/27 19:34
 * 日期工具类
 */
public class DateUtils {

    /**
     * 日期对象转字符串
     * @param date
     * @param format
     * @return
     */

    public static String formatDate(Date date, String format){
        String result="";
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        if(date!=null){
            result=sdf.format(date);
        }
        return result;
    }

    /**
     * 按照yyyyMMddhhmmss 获取当前日期
     * @return
     */
    public static String getCurrentDateStr() {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(date);
    }
}
