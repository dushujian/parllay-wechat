package com.parllay.wechat;

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

/**
 * Created by dushujian on 14-8-19.
 */
public class SendallServlet extends HttpServlet {
    Logger logger = Logger.getLogger(SendallServlet.class);
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

        JSONObject inmsg = (JSONObject) JSONValue.parse(data);
        if(inmsg.containsKey("filter") && inmsg.containsKey("msgtype"))
        {
            JSONObject filter = (JSONObject)inmsg.get("filter");
            if(!filter.containsKey("group_id"))
            {
                success = 0;
            }

             String msgtyp = (String)inmsg.get("msgtyp");
        }
        else
        {
            success = 0;
        }

    }
}
