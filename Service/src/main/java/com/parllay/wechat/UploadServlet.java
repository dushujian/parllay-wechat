package com.parllay.wechat;

import com.parllay.util.ServiceUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dushujian on 14-8-13.
 */
public class UploadServlet extends HttpServlet {
    Logger logger = Logger.getLogger(UploadServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        logger.info(req.getRequestURL());
        JSONObject inmsg = new JSONObject();
        JSONObject outmsg = new JSONObject();
        Set<Integer> mid = new HashSet<Integer>(); //存放不重复的媒体id

//        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
//        String line = reader.readLine();

        if(req.getParameter("access_token") != null &&
                req.getParameter("type") != null &&
                req.getParameter("media") != null)
        {
            String type = req.getParameter("type");
            String media = req.getParameter("media");
            String access_token = req.getParameter("access_token");
            inmsg.put("type",type);
            inmsg.put("media", media);
            inmsg.put("access_token", access_token);
            logger.info("The incoming parameters:" + inmsg);
            outmsg.put("created_at", ServiceUtil.getStringDateShort());
            outmsg.put("type",type);
            outmsg.put("MEDIA_ID", ServiceUtil.RandomNum(mid));
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }

        else
        {
            logger.info("The parameter passed is not complete！");
            outmsg.put("errcode", 40004);
            outmsg.put("errmsg","invalid media type");
            logger.info("The output parameters:" + outmsg);
            out.print(outmsg);
        }

        out.flush();
        out.close();
    }
}
