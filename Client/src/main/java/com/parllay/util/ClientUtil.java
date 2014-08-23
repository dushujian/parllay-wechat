package com.parllay.util;


import com.parllay.client.EventMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;

/**
 * Created by dushujian on 14-8-15.
 */
public class ClientUtil {
    //产生不重复随机数
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

    //产生固定范围随机数
    public static Integer RangeRandom(int rang)
    {
        Random random = new Random();
        return random.nextInt(rang);
    }


    //产生指定数量的普通消息
//    public  static String normalMsgs(int num, String type, Set mid)
//    {
//        StringBuilder nmes = new StringBuilder();
//        if(type.equals("text"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                nmes.append(NormalMessage.textMsg(RandomNum(mid)));
//            }
//        }
//
//        if(type.equals("image"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                nmes.append(NormalMessage.imgMsg(RandomNum(mid)));
//            }
//        }
//
//        if(type.equals("voice"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                nmes.append(NormalMessage.voiceMsg(RandomNum(mid)));
//            }
//        }
//
//        if (type.equals("video"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                nmes.append(NormalMessage.videoMsg(RandomNum(mid)));
//            }
//        }
//
//        if(type.equals("location"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                nmes.append(NormalMessage.locationMsg(RandomNum(mid)));
//            }
//        }
//
//        if(type.equals("link"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                nmes.append(NormalMessage.linkMsg(RandomNum(mid)));
//            }
//        }
//
//        return nmes.toString();
//
//    }
    //产生指定数量的事件消息
//    public  static String eventMsgs(int num, String type)
//    {
//        StringBuilder emes = new StringBuilder();
//        if(type.equals("subscribe"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                emes.append(EventMessage.subscribe());
//            }
//        }
//        if(type.equals("unsubscribe"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                emes.append(EventMessage.unsubscribe());
//            }
//        }
//        if(type.equals("scanUnsub"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                emes.append(EventMessage.scanUnsub());
//            }
//        }
//        if(type.equals("scan"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                emes.append(EventMessage.scan());
//            }
//        }
//        if(type.equals("location"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                emes.append(EventMessage.location());
//            }
//        }
//        if(type.equals("click"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                emes.append(EventMessage.click());
//            }
//        }
//        if(type.equals("view"))
//        {
//            for(int i = 0; i < num; i++)
//            {
//                emes.append(EventMessage.view());
//            }
//        }
//        return emes.toString();
//    }
//    //当前时间
//    public static String getStringDateShort() {
//        Date currentTime = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = formatter.format(currentTime);
//        return dateString;
//    }
}
