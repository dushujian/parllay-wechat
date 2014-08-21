package com.parllay.wechat;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by dushujian on 14-8-20.
 */
public class GetmenuServlet extends HttpServlet {
    Logger logger = Logger.getLogger(GetmenuServlet.class);
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        logger.info(req.getRequestURL());
        out.print("{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"}," +
                "{\"type\":\"click\",\"name\":\"歌手简介\",\"key\":\"V1001_TODAY_SINGER\"}," +
                "{\"name\":\"菜单\",\"sub_button\":[" +
                "{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"}," +
                "{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\"}," +
                "{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}]}");
        out.flush();
        out.close();
    }
}
