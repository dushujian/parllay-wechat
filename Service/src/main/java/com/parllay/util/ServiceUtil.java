package com.parllay.util;

import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;

/**
 * Created by dushujian on 14-8-15.
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

    public static boolean isinexistenceKeyorNull(JSONObject jobj, String key)
    {
        if(!jobj.containsKey(key))
            return true;
        else if(jobj.get(key) == null)
            return true;
        return false;
    }

    public static String sendResult()
    {
        StringBuffer result = new StringBuffer();
        result.append("<xml>\n" +
                "<ToUserName><![CDATA[gh_3e8adccde292]]></ToUserName>\n" +
                "<FromUserName><![CDATA[oR5Gjjl_eiZoUpGozMo7dbBJ362A]]></FromUserName>\n" +
                "<CreateTime>1394524295</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[MASSSENDJOBFINISH]]></Event>\n" +
                "<MsgID>1988</MsgID>\n" +
                "<Status><![CDATA[sendsuccess]]></Status>\n" +
                "<TotalCount>100</TotalCount>\n" +
                "<FilterCount>80</FilterCount>\n" +
                "<SentCount>75</SentCount>\n" +
                "<ErrorCount>5</ErrorCount>\n" +
                "</xml>");
        return result.toString();
    }
}
