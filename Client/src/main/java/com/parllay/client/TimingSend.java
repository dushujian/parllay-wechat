package com.parllay.client;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
/**
 * Created by dushujian on 14-8-20.
 */
public class TimingSend  {
    static class MyTask extends java.util.TimerTask {
        public void run() {
            System.out.println("开始");
            String param = "{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"type\":\"click\",\"name\":\"歌手简介\",\"key\":\"V1001_TODAY_SINGER\"},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}]}";;

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
        timer.schedule(new MyTask(),0,3000);// 在1秒后执行此任务
    }

}

