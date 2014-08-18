package com.parllay.util;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 * Created by dushujian on 14-8-13.
 */
public class ServiceUtil {
    public static Integer RandomNum(Set<Integer> mid)
    {
        int length = mid.size();
        int i = 0;
        Random random = new Random();
        do {
            i = random.nextInt();
            mid.add(i);
        }while(mid.size() == length);
        return  i;
    }
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
