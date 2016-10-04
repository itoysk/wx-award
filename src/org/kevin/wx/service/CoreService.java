package org.kevin.wx.service;

import org.kevin.wx.entity.resp.TextMessage;
import org.kevin.wx.util.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by itoysk on 2016/9/22.
 */
public class CoreService {
    public static String getOpenId(HttpServletRequest request) {
        String str = null;
        // xml请求解析
        Map<String, String> requestMap = null;
        try {
            requestMap = MessageUtil.parseXml(request);
            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            str += fromUserName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;

    }

    public static String processRequest(HttpServletRequest request) {
        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "未知的消息类型！";
        try {
            // 调用parseXml方法解析请求消息
            Map requestMap = MessageUtil.parseXml(request);
            // 发送方帐号
            String fromUserName = (String) requestMap.get("FromUserName");
            // 开发者微信号
            String toUserName = (String) requestMap.get("ToUserName");
            // 消息类型
            String msgType = (String) requestMap.get("MsgType");
            //消息文本
            String content = (String) requestMap.get("Content");


            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT) && "抽奖".equals(content)) {
                respContent = "\n" +
                        "    <a href=\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx177b9a3366b821e8&redirect_uri=http%3a%2f%2fkevinoy.tunnel.2bdata.com%2fgoToCJ&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect\">点击进入抽奖啦</a>  \n";
            }



            // 设置文本消息的内容
            textMessage.setContent(respContent);

            // 将文本消息对象转换成xml
            respXml = MessageUtil.messageToXml(textMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }
}

