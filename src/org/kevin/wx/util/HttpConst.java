package org.kevin.wx.util;

import okhttp3.MediaType;

/**
 * Created by itoysk on 2016/9/22.
 */
public class HttpConst {//JSON

    //授权信息
    public static final String APPID = "wx177b9a3366b821e8";
    public static final String APPSECRET = "5108a0cdac3df9b36e75d5fbfd24e5fc";

    //TOKEN信息
    public static  String TOKEN = "Xi65H46Nu09wlcuy9QG1nn7MDkW7K-7ygJVmLLtYRLWjpVfz-Q6mAPSWgY7yP0mx6UBC3NUZXkCt_AUkmuBY0k9pnLmWr0zs1hHbmhP6pGXc9Amwmp21oZv1CTIUFiM3HXIdAAADTE";

    //JSON
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    //获取token的url
    public static final String GET_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET;

    //创建菜单url
    public static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+TOKEN;

    //创建菜单JSON
    public static final String CREATE_MENU_JSON = " {\n" +
            "     \"button\":[\n" +
            "     {\t\n" +
            "          \"type\": \"scancode_push\", \n" +
            "          \"name\":\"码上抽奖\",\n" +
            "          \"key\":\"rselfmenu_0_0\",\n" +
            "          \"sub_button\": [ ]\n" +
            "      }]\n" +
            " }";

    //创建客服帐号Url
    public static final String CREATE_CUSTOM_URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token="+TOKEN;

    //创建客服帐号JSON
    public static final String CREATE_CUSTOM_JSON = "{\n" +
            "    \"kf_account\": \"gh@gh_5dc84b488a7e\", \n" +
            "    \"nickname\": \"客服1\", \n" +
            "    \"password\": \"123456\"\n" +
            "}";

    //发送文本消息url
    public static final String SEND_TEXT_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+TOKEN;


}
