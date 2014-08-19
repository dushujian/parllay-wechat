package com.parllay.wechat;

import com.parllay.util.ServiceUtil;
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
public class SendServlet extends HttpServlet {
    Logger logger = Logger.getLogger(SendServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        PropertyConfigurator.configure("/home/dushujian/Desktop/parllay-wechat/Service/config/log4j.properties");
        logger.info(req.getRequestURL());
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String data = br.readLine();
        br.close();
        int success = 1; //标志参数是否传递正确
        logger.info(success);
        logger.info("The input parameters:" + data);
        logger.info(success);

        JSONObject inmsg = (JSONObject) JSONValue.parse(data);
        JSONObject outmsg = new JSONObject();

        if(ServiceUtil.isinexistenceKeyorNull(inmsg,"touser")||
                ServiceUtil.isinexistenceKeyorNull(inmsg,"msgtype"))
        {
            success = 0;
            logger.info(success);
        }
        else
        {
             String msgtype = (String)inmsg.get("msgtype");
            if(ServiceUtil.isinexistenceKeyorNull(inmsg,msgtype))
            {
                success = 0;
                logger.info(success);
            }
            else
            {
                if(msgtype.equals("mpnews")||
                        msgtype.equals("voice")||
                        msgtype.equals("image")||
                        msgtype.equals("mpvideo"))
                {
                    JSONObject msgjson = (JSONObject)inmsg.get(msgtype);
                    if(ServiceUtil.isinexistenceKeyorNull(msgjson,"media_id"))
                    {
                        success = 0;
                        logger.info(success);
                    }
                }
                else if(msgtype.equals("text"))
                {
                    JSONObject msgjson = (JSONObject)inmsg.get(msgtype);
                    if(ServiceUtil.isinexistenceKeyorNull(msgjson,"content"))
                    {
                        success = 0;
                        logger.info(success);
                    }
                }
                else
                {
                    success = 0;
                    logger.info("msgtype illegal!");
                }
            }
        }
        logger.info(success);
        if(1 == success)
        {
            outmsg.put("errcode", 0);
            outmsg.put("errmsg", "send job submission success");
            outmsg.put("msg_id", 34182);
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }
        else
        {
            logger.info("The parameter passed is not complete or illegal！");
            outmsg.put("errcode", 40004);
            outmsg.put("errmsg","invalid media type");
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }
        out.flush();
    }
}
