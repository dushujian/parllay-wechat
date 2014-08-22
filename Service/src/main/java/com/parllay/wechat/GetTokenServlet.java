package com.parllay.wechat;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dushujian on 14-8-22.
 */
public class GetTokenServlet extends HttpServlet {
    Logger logger = Logger.getLogger(GetTokenServlet.class);
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        logger.info(req.getRequestURL());
        JSONObject outmsg = new JSONObject();
        if(req.getParameter("grant_type") !=null &&
           req.getParameter("appid")  !=null &&
           req.getParameter("secret")  !=null   )
        {
            outmsg.put("access_token","ACCESS_TOKEN");
            outmsg.put("expires_in",7200);
            out.print(outmsg);
            logger.info("The output params:" + outmsg);
        }
        else
        {
            outmsg.put("errcode",40013);
            outmsg.put("errmsg","invalid appid");
            out.print(outmsg);
            logger.info("The output params:" + outmsg);
        }

    }
}
