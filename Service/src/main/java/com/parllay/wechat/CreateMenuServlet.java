package com.parllay.wechat;

import com.parllay.util.ServiceUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONArray;
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
 * Created by dushujian on 14-8-20.
 */
public class CreateMenuServlet extends HttpServlet
{
    Logger logger = Logger.getLogger(CreateMenuServlet.class);
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        logger.info(req.getRequestURL());
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String data = br.readLine();
        br.close();
        int success = 1; //标志参数是否传递正确
        logger.info("The input parameters:" + data);

        JSONObject outmsg = new JSONObject();
        JSONObject inmsg = (JSONObject) JSONValue.parse(data);
        if(req.getParameter("access_token") == null)
        {
            success = 0;
            logger.error("no access_token param");
        }
        if (ServiceUtil.isinexistenceKeyorNull(inmsg,"button"))
        {
            success = 0;
            logger.error("no button param!");
        }
        else
        {
            JSONArray array = (JSONArray) inmsg.get("button");
            if(array.size() > 0 && array.size() < 4)
            {
                for (int i = 0; i < array.size(); i++)
                {
                    JSONObject button = (JSONObject) array.get(i);
                    if (ServiceUtil.isinexistenceKeyorNull(button,"name"))
                    {
                        success = 0;
                        logger.error("no button name param");
                    }
                    if (button.containsKey("sub_button"))
                    {
                        JSONArray sub_array =  (JSONArray)button.get("sub_button");
                        if(sub_array.size()>0 && sub_array.size()<6)
                        {
                            for (int j = 0; j < array.size(); j++)
                            {
                                JSONObject sub_button = (JSONObject)sub_array.get(j);
                                if(ServiceUtil.isinexistenceKeyorNull(sub_button,"type")||
                                        ServiceUtil.isinexistenceKeyorNull(sub_button,"name"))
                                {
                                    String type = (String)sub_button.get("type");
                                    if(type.equals("click"))
                                    {
                                        if (ServiceUtil.isinexistenceKeyorNull(sub_button,"key"))
                                        {
                                            success = 0;
                                            logger.error("type is click but no key param");
                                        }
                                    }
                                    else if(type.equals("view"))
                                    {
                                        if (ServiceUtil.isinexistenceKeyorNull(sub_button,"url"))
                                        {
                                            success = 0;
                                            logger.error("type is view but no url param");
                                        }
                                    }
                                }
                            }
                        }
                        else
                        {
                            success = 0;
                            logger.error("sub_button out of boundary!");
                        }
                    }
                    else if(ServiceUtil.isinexistenceKeyorNull(button,"type"))
                    {
                        success = 0;
                        logger.error("no type param");
                    }
                    else
                    {
                        String type = (String)button.get("type");
                        if(type.equals("click"))
                        {
                            if (ServiceUtil.isinexistenceKeyorNull(button,"key"))
                            {
                                success = 0;
                                logger.error("type is click but no key param");
                            }
                        }
                        else if(type.equals("view"))
                        {
                            if (ServiceUtil.isinexistenceKeyorNull(button,"url"))
                            {
                                success = 0;
                                logger.error("type is view but no url param");
                            }
                        }
                    }
                }
            }
            else
            {
                success = 0;
                logger.info("button out of boundary!");
            }
        }

        if (1 == success)
        {
            outmsg.put("errcode",0);
            outmsg.put("errmsg","ok");
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }
        else
        {
            outmsg.put("errcode",40018);
            outmsg.put("errmsg","invalid button");
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }
        out.flush();
        out.close();
    }
}