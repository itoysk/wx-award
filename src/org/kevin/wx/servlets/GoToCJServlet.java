package org.kevin.wx.servlets;

import net.sf.json.JSONObject;
import org.kevin.wx.dao.AwardDAO;
import org.kevin.wx.util.HttpConst;
import org.kevin.wx.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by itoysk on 2016/9/22.
 */
public class GoToCJServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //获得code
        String code = request.getParameter("code");

        //获得用户open_id
        String temp_json = HttpUtil.getHttp("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+ HttpConst.APPID+"&secret="+HttpConst.APPSECRET+"&code="+code+"&grant_type=authorization_code");
        JSONObject jsonObject = JSONObject.fromObject(temp_json);
        String openid = jsonObject.getString("openid");


//        //获得access_token
//        String access_token = jsonObject.getString("access_token");
//        //刷新access_token
//        String rrr = HttpUtil.getHttp("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+HttpConst.APPID+"&grant_type=refresh_token&refresh_token=REFRESH_TOKEN");
//        System.out.println("rrr: "+rrr);

        //open_id校验，如果该用户已经抽过奖，则跳转去提示页面
        AwardDAO awardDAO = new AwardDAO();
        boolean flag = awardDAO.awardValidateById(openid);
        if (flag == false) {
            response.sendRedirect("msg.html");
            return;
        }


        //将open_id保存进session

        session.setAttribute("open_id",openid);
        request.getRequestDispatcher("WEB-INF/html/cj.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
