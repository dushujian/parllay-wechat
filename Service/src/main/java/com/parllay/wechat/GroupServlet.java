package com.parllay.wechat;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by dushujian on 14-8-18.
 */
public class GroupServlet extends HttpServlet {
    Logger logger = Logger.getLogger(GroupServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        PropertyConfigurator.configure("/home/dushujian/Desktop/parllay-wechat/Service/config/log4j.properties");
        logger.info(req.getRequestURL());
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String data = br.readLine();
        br.close();
        int success = 1; //标志参数是否传递正确
        logger.info("The input parameters:" + data);
        JSONObject childoutmsg = new JSONObject();
        JSONObject outmsg = new JSONObject();
        JSONObject name = null;

        if(StringUtils.isEmpty(req.getParameter("access_token")))
        {
            success = 0;
        }
        JSONObject group = (JSONObject)JSONValue.parse(data);
        if(!group.containsKey("group"))
        {
            success = 0;
        }
        else
        {
            name = (JSONObject)group.get("group");
            if(!name.containsKey("name"))
            {
                success = 0;
            }
        }

        if (1 == success)
        {
            childoutmsg.put("id", new Random().nextInt(1000));
            childoutmsg.put("name", name.get("name"));
            outmsg.put("group", childoutmsg);
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }

        else
        {
            outmsg.put("errcode", 40013);
            outmsg.put("errmsg", "invalid appid");
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }
        out.flush();
    }
}
