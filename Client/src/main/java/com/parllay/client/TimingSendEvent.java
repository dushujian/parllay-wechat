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
            System.out.println("开始");
            String param = "";
            for(int i = 0; i < 17; i++)
            {
                if(i>=0 && i<5)
                {
                    param = EventMessage.subscribe();
                }
                else if(5 == i)
                {
                    param = EventMessage.unsubscribe();
                }
                else if(i>5 && i<10)
                {
                    param = EventMessage.scan();
                }
                else if(10 == i)
                {
                    param = EventMessage.scanUnsub();
                }
                else if(i>10 && i<14)
                {
                    param = EventMessage.location();
                }
                else if(i>=14&i<16)
                {
                    param = EventMessage.click();
                }
                else
                {
                    param = EventMessage.view();
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
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(),0,60*60*1000);// 每1小时执行此任务
    }
}
