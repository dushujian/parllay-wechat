package com.parllay.client;

import com.parllay.util.ClientUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

/**
 * Created by dushujian on 14-8-22.
 */
public class TimingSendEvent {
    static class MyTask extends java.util.TimerTask {
        public void run() {
            Set<Integer> mid = new HashSet<Integer>(); //存放不重复的媒体id
            System.out.println("开始");
            String param = ClientUtil.eventMsgs(5,"subscribe") +
                    ClientUtil.eventMsgs(1,"unsubscribe") +
                    ClientUtil.eventMsgs(4,"scan") +
                    ClientUtil.eventMsgs(1,"scanUnsub") +
                    ClientUtil.eventMsgs(3,"location") +
                    ClientUtil.eventMsgs(2,"click") +
                    ClientUtil.eventMsgs(1,"view");
            System.out.println(param);
            try {
                URL url = new URL("http://localhost:8080/wechat-simulator/menu/create");
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

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(),0,60*60*1000);// 每1小时执行此任务
    }
}
