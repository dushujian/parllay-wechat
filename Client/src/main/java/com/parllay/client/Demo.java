package com.parllay.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * Created by dushujian on 14-8-13.
 */
public class Demo {
    public static void main(String[] args) throws IOException {

//        String param = "{\"filter\":{\"group_id\":\"2\"},\"text\":{\"content\":\"CONTENT\"},\"msgtype\":\"text\"}";
//        String param = "{\"articles\":[{\"thumb_media_id\":\"1\",\"author\":\"xxx\",\"title\":\"happy\",\"content\":\"content\"},{\"thumb_media_id\":\"1\",\"author\":\"xxx\",\"title\":\"happy\",\"content\":\"content\"}]}";
//        String param = "{\"group\":{\"name\":\"test\"}}";
//        String param = "{\"touser\":[\"OPENID1\",\"OPENID2\"],\"mpnews\":{\"media_id\":\"123dsdajkasd231jhksad\"},\"msgtype\":\"mpnews\"}";
        String param = "{\"button\":[{\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"type\":\"click\",\"name\":\"歌手简介\",\"key\":\"V1001_TODAY_SINGER\"},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}]}";
//        URL url = new URL("http://121.40.138.37:8080/wechat-simulator/message/mass/sendall");
//        URL url = new URL("http://121.40.138.37:8080/wechat-simulator/groups/create?access_token=ACCESS_TOKEN");
        URL url = new URL("http://121.40.138.37:8080/wechat-simulator/menu/create");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        connection.setRequestProperty("Content-Length", Integer.toString(param.getBytes().length));
//        connection.setRequestProperty("Content-Language", "en-US");

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
        System.out.println(new Date());
        rd.close();

    }
}
