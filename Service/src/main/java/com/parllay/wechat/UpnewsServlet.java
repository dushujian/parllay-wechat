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
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dushujian on 14-8-17.
 */

public class UpnewsServlet extends HttpServlet {
    Logger logger = Logger.getLogger(UpnewsServlet.class);

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

        Set<Integer> mid = new HashSet<Integer>(); //存放不重复的媒体id
        JSONObject outmsg = new JSONObject();
        JSONObject articles = (JSONObject)JSONValue.parse(data);
        if(!ServiceUtil.isinexistenceKeyorNull(articles,"articles"))
        {
            JSONArray array = (JSONArray) articles.get("articles");
            logger.info(array);
            int size = array.size();
            if (size > 0 && size < 11) {
                for (int i = 0; i < size; i++) {
                    JSONObject jo = (JSONObject) array.get(i);
                    if(ServiceUtil.isinexistenceKeyorNull(jo,"thumb_media_id")||
                       ServiceUtil.isinexistenceKeyorNull(jo,"title") ||
                       ServiceUtil.isinexistenceKeyorNull(jo,"content"))
                    {
                         success = 0;
                        logger.error("The parameter passed is not complete(thumb_media_id,title,content)！");
                    }
                }
            }
            else
            {
                success =0;
                logger.error("articles out of boundary!");
            }
        }
        else
        {
            success = 0;
            logger.error("no param articles");
        }
        if (1 == success)
        {
            outmsg.put("created_at", ServiceUtil.getStringDateShort());
            outmsg.put("type","news");
            outmsg.put("MEDIA_ID", ServiceUtil.RandomNum(mid));
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }
        else {
            outmsg.put("errcode", 40004);
            outmsg.put("errmsg", "invalid media type");
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }
        out.flush();
    }
}
