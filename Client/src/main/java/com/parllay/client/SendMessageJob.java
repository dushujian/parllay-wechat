package com.parllay.client;

import com.parllay.util.ClientUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dushujian on 14-8-22.
 */
public class SendMessageJob {
//    static class MyTask extends java.util.TimerTask {
//        public void run() {
//            String param = "";
//            for(int i = 0; i < 17; i++)
//            {
//                if(i>=0 && i<5)
//                {
//                    param = EventMessage.subscribe();
//                }
//                else if(5 == i)
//                {
//                    param = EventMessage.unsubscribe();
//                }
//                else if(i>5 && i<10)
//                {
//                    param = EventMessage.scan();
//                }
//                else if(10 == i)
//                {
//                    param = EventMessage.scanUnsub();
//                }
//                else if(i>10 && i<14)
//                {
//                    param = EventMessage.location();
//                }
//                else if(i>=14&i<16)
//                {
//                    param = EventMessage.click();
//                }
//                else
//                {
//                    param = EventMessage.view();
//                }
//                System.out.println(param);
//                try {
//                    URL url = new URL("http://localhost:8080/wechat-simulator");
//                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//                    connection.setRequestMethod("POST");
//                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//                    connection.setRequestProperty("Content-Length", Integer.toString(param.getBytes().length));
//                    connection.setUseCaches (false);
//                    connection.setDoInput(true);
//                    connection.setDoOutput(true);
//
//                    //Send request
//                    DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
//                    wr.write(param.getBytes());
//                    wr.flush ();
//                    wr.close ();
//
//                    //Get Response
//                    BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                    String line;
//                    while((line = rd.readLine()) != null) {
//                        System.out.println(line);
//                    }
//                    rd.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public static void main(String[] args) {

        // send event messages
        String param = "";
        for(int i = 0; i < 17; i++)
        {
            if(i>=0 && i<5)
            {
                param = EventMessage.subscribe(ClientUtil.RangeRandom(60));
            }
            else if(5 == i)
            {
                param = EventMessage.unsubscribe(ClientUtil.RangeRandom(60));
            }
            else if(i>5 && i<10)
            {
                param = EventMessage.scan(ClientUtil.RangeRandom(60),100000+ClientUtil.RangeRandom(900000));//Eventkey是六位整数
            }
            else if(10 == i)
            {
                param = EventMessage.scanUnsub(ClientUtil.RangeRandom(60),10000000+ClientUtil.RangeRandom(9000000));//evet八位整数
            }
            else if(i>10 && i<14)
            {
                param = EventMessage.location(ClientUtil.RangeRandom(60));
            }
            else if(i>=14&i<16)
            {
                param = EventMessage.click(ClientUtil.RangeRandom(60),ClientUtil.RangeRandom(3));
            }
            else
            {
                param = EventMessage.view(ClientUtil.RangeRandom(60),ClientUtil.RangeRandom(5));
            }
            System.out.println(param);
            try {
                URL url = new URL("http://localhost:8080/wechat-simulator");
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("Content-Length", Integer.toString(param.getBytes().length));
                connection.setUseCaches (false);
                connection.setDoInput(true);
                connection.setDoOutput(true);

                //Send request
                DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
                wr.write(param.getBytes());
                wr.flush ();
                wr.close ();

                //Get Response
                BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while((line = rd.readLine()) != null) {
                    System.out.println(line);
                }
                rd.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // send normal messages
        Set<Integer> mid = new HashSet<Integer>(); //存放不重复的媒体id
        param = "";
        for(int i = 0; i < 21; i++)
        {
            if(i>=0 && i<6)
            {
                param = NormalMessage.textMsg(ClientUtil.RandomNum(mid),ClientUtil.RangeRandom(60));
            }
            else if(i>=6 && i<11)
            {
                param = NormalMessage.imgMsg(ClientUtil.RandomNum(mid),ClientUtil.RangeRandom(60));
            }
            else if(i>=11 && i<15)
            {
                param = NormalMessage.voiceMsg(ClientUtil.RandomNum(mid),ClientUtil.RangeRandom(60));
            }
            else if(i>=15 && i<18)
            {
                param = NormalMessage.videoMsg(ClientUtil.RandomNum(mid),ClientUtil.RangeRandom(60));
            }
            else if(i>=18 && i<20)
            {
                param = NormalMessage.locationMsg(ClientUtil.RandomNum(mid),ClientUtil.RangeRandom(60));
            }
            else
            {
                param = NormalMessage.linkMsg(ClientUtil.RandomNum(mid),ClientUtil.RangeRandom(60),ClientUtil.RangeRandom(5));
            }
            System.out.println(param);
            try {
                URL url = new URL("http://localhost:8080/wechat-simulator");
//                    URL url = new URL("http://localhost:8080/wechat-simulator/menu/create");
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("Content-Length", Integer.toString(param.getBytes().length));
                connection.setUseCaches (false);
                connection.setDoInput(true);
                connection.setDoOutput(true);

                //Send request
                DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
                wr.write(param.getBytes());
                wr.flush ();
                wr.close ();

                //Get Response
                BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while((line = rd.readLine()) != null) {
                    System.out.println(line);
                }
                rd.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
