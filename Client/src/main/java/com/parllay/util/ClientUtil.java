package com.parllay.util;


import com.parllay.client.Message;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;

/**
 * Created by dushujian on 14-8-15.
 */
public class ClientUtil {
    //产生随机数
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

    //产生指定数量的消息
    public  static String msgs(int num, String type,Set mid)
    {
        StringBuilder mes = new StringBuilder();
        if(type.equals("text"))
        {
            for(int i = 0; i < num; i++)
            {
                mes.append(Message.textMsg(RandomNum(mid)));
            }
        }

        if(type.equals("image"))
        {
            for(int i = 0; i < num; i++)
            {
                mes.append(Message.imgMsg(RandomNum(mid)));
            }
        }

        if(type.equals("voice"))
        {
            for(int i = 0; i < num; i++)
            {
                mes.append(Message.voiceMsg(RandomNum(mid)));
            }
        }

        if (type.equals("video"))
        {
            for(int i = 0; i < num; i++)
            {
                mes.append(Message.videoMsg(RandomNum(mid)));
            }
        }

        if(type.equals("location"))
        {
            for(int i = 0; i < num; i++)
            {
                mes.append(Message.locationMsg(RandomNum(mid)));
            }
        }

        if(type.equals("link"))
        {
            for(int i = 0; i < num; i++)
            {
                mes.append(Message.linkMsg(RandomNum(mid)));
            }
        }

        return mes.toString();

    }
    //当前时间
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
