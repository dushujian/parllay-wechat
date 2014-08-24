package com.parllay.client;

import com.parllay.util.ClientUtil;
import com.parllay.util.Constants;

import java.util.Date;

/**
 * Created by dushujian on 14-8-22.
 */
public class NormalMessage {
    public static String textMsg(int msgId,int userid){
        return  " <xml>\n" +
                " <ToUserName><![CDATA[parllay]]></ToUserName>\n" +
                " <FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName> \n" +
                " <CreateTime>" + ClientUtil.getTime() + "</CreateTime>\n" +
                " <MsgType><![CDATA[text]]></MsgType>\n" +
                " <Content><![CDATA[this is a test]]></Content>\n" +
                " <MsgId>"+msgId+"</MsgId>\n" +
                " </xml>\n";
    }
    public  static  String imgMsg(int msgId,int userid)
    {
        return "<xml>\n" +
                " <ToUserName><![CDATA[parllay]]></ToUserName>\n" +
                " <FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>\n" +
                " <CreateTime>" + ClientUtil.getTime() + "</CreateTime>\n" +
                " <MsgType><![CDATA[image]]></MsgType>\n" +
                " <PicUrl><![CDATA[this is a url]]></PicUrl>\n" +
                " <MediaId><![CDATA[media_id]]></MediaId>\n" +
                " <MsgId>"+msgId+"</MsgId>\n" +
                " </xml>";
    }
    public static String voiceMsg(int msgId,int userid)
    {
        return "<xml>\n" +
                "<ToUserName><![CDATA[parllay]]></ToUserName>\n" +
                "<FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>\n" +
                " <CreateTime>" + ClientUtil.getTime() + "</CreateTime>\n" +
                "<MsgType><![CDATA[voice]]></MsgType>\n" +
                "<MediaId><![CDATA[media_id]]></MediaId>\n" +
                "<Format><![CDATA[Format]]></Format>\n" +
                " <MsgId>"+msgId+"</MsgId>\n" +
                "</xml>";
    }
    public static String videoMsg(int msgId,int userid)
    {
        return "<xml>\n" +
                "<ToUserName><![CDATA[parllay]]></ToUserName>\n" +
                "<FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>\n" +
                " <CreateTime>" + ClientUtil.getTime() + "</CreateTime>\n" +
                "<MsgType><![CDATA[video]]></MsgType>\n" +
                "<MediaId><![CDATA[media_id]]></MediaId>\n" +
                "<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>\n" +
                " <MsgId>"+msgId+"</MsgId>\n" +
                "</xml>";
    }

    public  static String locationMsg(int msgId,int userid)
    {
        return "<xml>\n" +
                "<ToUserName><![CDATA[parllay]]></ToUserName>\n" +
                "<FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>\n" +
                " <CreateTime>" + ClientUtil.getTime() + "</CreateTime>\n" +
                "<MsgType><![CDATA[location]]></MsgType>\n" +
                "<Location_X>23.134521</Location_X>\n" +
                "<Location_Y>113.358803</Location_Y>\n" +
                "<Scale>20</Scale>\n" +
                "<Label><![CDATA[位置信息]]></Label>\n" +
                " <MsgId>"+msgId+"</MsgId>\n" +
                "</xml> ";
    }

    public static String linkMsg(int msgId,int userid,int urlid)
    {
        return "<xml>\n" +
                "<ToUserName><![CDATA[parllay]]></ToUserName>\n" +
                "<FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>\n" +
                " <CreateTime>" + ClientUtil.getTime() + "</CreateTime>\n" +
                "<MsgType><![CDATA[link]]></MsgType>\n" +
                "<Title><![CDATA[公众平台官网链接]]></Title>\n" +
                "<Description><![CDATA[公众平台官网链接]]></Description>\n" +
                "<Url><![CDATA["+Constants.ViewEventKeys[urlid] +"]]></Url>\n" +
                " <MsgId>"+msgId+"</MsgId>\n" +
                "</xml> ";
    }
}
