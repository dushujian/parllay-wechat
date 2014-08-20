package com.parllay.wechat;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dushujian on 14-8-18.
 */
public class GetgroupServlet extends HttpServlet {
    Logger logger = Logger.getLogger(GetgroupServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        PropertyConfigurator.configure("/home/dushujian/Desktop/parllay-wechat/Service/config/log4j.properties");
        logger.info(req.getRequestURL());

        JSONObject childoutmsg = new JSONObject();
        JSONObject outmsg = new JSONObject();
        if(req.getParameter("access_token") != null)
        {
            JSONArray group = new JSONArray();
            childoutmsg.put("id",0);
            childoutmsg.put("name","kkk");
            childoutmsg.put("count",36);
            group.add(childoutmsg);
            outmsg.put("group",group);
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }
        else
        {
            logger.error("no param access_token");
            outmsg.put("errcode", 40013);
            outmsg.put("errmsg", "invalid appid");
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }
        out.flush();
    }
}
