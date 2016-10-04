package org.kevin.wx.test;

import org.kevin.wx.util.HttpConst;
import org.kevin.wx.util.HttpUtil;

import java.io.IOException;

/**
 * Created by itoysk on 2016/9/21.
 */
public class HttpTest {

    public static void getToken(){
        String result = HttpUtil.getToken();
        System.out.println(result);
    }

    /**
     * 创建自定义菜单
     */
    public static void createMenu() throws IOException {
        String result = HttpUtil.postHttpByJson(HttpConst.CREATE_MENU_URL,HttpConst.CREATE_MENU_JSON);
        System.out.println(result);
    }

    /**
     * 创建客服帐号
     */
    public static void createCustomAccount() throws IOException {
        String result = HttpUtil.postHttpByJson(HttpConst.CREATE_CUSTOM_URL,HttpConst.CREATE_CUSTOM_JSON);
        System.out.println(result);
    }

    public static  void main(String[] args) throws IOException {
        //createMenu();
        //HttpUtil.getHttp("https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token="+HttpConst.TOKEN);
        getToken();
    }

}
