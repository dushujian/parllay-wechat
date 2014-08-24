package com.parllay.client;

import com.parllay.util.ClientUtil;
import com.parllay.util.Constants;

import java.util.Date;

/**
 * Created by dushujian on 14-8-22.
 */
public class EventMessage {
    public static String subscribe(int userid)
    {
        return "<xml>" +
                "<ToUserName><![CDATA[parllay]]></ToUserName>" +
                "<FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>" +
                "<CreateTime>" + ClientUtil.getTime() + "</CreateTime>" +
                "<MsgType><![CDATA[event]]></MsgType>" +
                "<Event><![CDATA[subscribe]]></Event>" +
                "</xml>";
    }
    public static String unsubscribe(int userid)
    {
        return "<xml>" +
                "<ToUserName><![CDATA[parllay]]></ToUserName>" +
                "<FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>" +
                "<CreateTime>" + ClientUtil.getTime() + "</CreateTime>" +
                "<MsgType><![CDATA[event]]></MsgType>" +
                "<Event><![CDATA[unsubscribe]]></Event>" +
                "</xml>";
    }
    public static String scanUnsub(int userid,int eventKeyid)
    {
        return "<xml><ToUserName><![CDATA[parllay]]></ToUserName>" +
                "<FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>" +
                "<CreateTime>" + ClientUtil.getTime() + "</CreateTime>" +
                "<MsgType><![CDATA[event]]></MsgType>" +
                "<Event><![CDATA[subscribe]]></Event>" +
                "<EventKey><![CDATA[qrscene_"+ eventKeyid +"]]></EventKey>" +
                "<Ticket><![CDATA[TICKET]]></Ticket>" +
                "</xml>";
    }
    public static String scan(int userid, int eventKeyid)
    {
        return "<xml>" +
                "<ToUserName><![CDATA[parllay]]></ToUserName>" +
                "<FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>" +
                "<CreateTime>" + ClientUtil.getTime() + "</CreateTime>" +
                "<MsgType><![CDATA[event]]></MsgType>" +
                "<Event><![CDATA[SCAN]]></Event>" +
                "<EventKey><![CDATA["+ eventKeyid +"]]></EventKey>" +
                "<Ticket><![CDATA[TICKET]]></Ticket>" +
                "</xml>";
    }

    public static String location(int userid)
    {
        return "<xml>" +
                "<ToUserName><![CDATA[parllay]]></ToUserName>" +
                "<FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>" +
                "<CreateTime>" + ClientUtil.getTime() + "</CreateTime>" +
                "<MsgType><![CDATA[event]]></MsgType>" +
                "<Event><![CDATA[LOCATION]]></Event>" +
                "<Latitude>23.137466</Latitude>" +
                "<Longitude>113.352425</Longitude>" +
                "<Precision>119.385040</Precision>" +
                "</xml>";
    }
    public static String click(int userid,int clickEventid)
    {
        return "<xml>" +
                "<ToUserName><![CDATA[parllay]]></ToUserName>" +
                "<FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>" +
                "<CreateTime>" + ClientUtil.getTime() + "</CreateTime>" +
                "<MsgType><![CDATA[event]]></MsgType>" +
                "<Event><![CDATA[CLICK]]></Event>" +
                "<EventKey><![CDATA["+Constants.ClickEventKeys[clickEventid]+"]]></EventKey>" +
                "</xml>";
    }
    public static String view(int userid, int viewEventid)
    {
        return "<xml>" +
                "<ToUserName><![CDATA[parllay]]></ToUserName>" +
                "<FromUserName><![CDATA["+ Constants.fromUsers[userid]+"]]></FromUserName>" +
                "<CreateTime>" + ClientUtil.getTime() + "</CreateTime>" +
                "<MsgType><![CDATA[event]]></MsgType>" +
                "<Event><![CDATA[VIEW]]></Event>" +
                "<EventKey><![CDATA["+Constants.ViewEventKeys[viewEventid]+"]]></EventKey>" +
                "</xml>";
    }
}
