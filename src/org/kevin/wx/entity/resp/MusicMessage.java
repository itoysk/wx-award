package org.kevin.wx.entity.resp;

/**
 * Created by itoysk on 2016/9/22.
 */
/**
 * 音乐消息
 *
 *
 */
public class MusicMessage extends BaseMessage {
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}