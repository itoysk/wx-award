package org.kevin.wx.entity.resp;

/**
 * Created by itoysk on 2016/9/22.
 */
/**
 * 文本消息
 *
 *
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}