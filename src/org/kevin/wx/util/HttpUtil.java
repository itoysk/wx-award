package org.kevin.wx.util;

import net.sf.json.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by itoysk on 2016/9/21.
 */
public class HttpUtil {

    //创建okHttpClient对象
    public static final OkHttpClient mOkHttpClient = new OkHttpClient();


    /**
     * Get请求
     *
     * @param url
     * @return Response
     */
    public static String getHttp(String url) throws IOException
    {

        Request request = new Request.Builder().url(url).build();
        Response response = mOkHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


    /**
     * post请求
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String postHttpByJson(String url , String json) throws IOException {
        System.out.println(url);
        RequestBody body = RequestBody.create(HttpConst.JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = mOkHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 获取token
     *
     * @return
     */
    public static String getToken (){
        String result = null;
        try {
            result =  getHttp(HttpConst.GET_TOKEN);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

}
