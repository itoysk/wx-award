package org.kevin.wx.servlets;

import org.kevin.wx.dao.AwardDAO;
import org.kevin.wx.util.HttpConst;
import org.kevin.wx.util.HttpUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 推送消息的Servlet
 *
 * Created by itoysk on 2016/9/22.
 */
public class PushToUserServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String open_id = (String) session.getAttribute("open_id");

        boolean msg = false;

        if (open_id != null) {
            AwardDAO awardDAO = new AwardDAO();
            //查询该用户奖品后进行推送
            Map map = awardDAO.getUserAward(open_id);

            if(map != null) {
                //推送消息
                //向用户推送一条文本消息
                String send_text_json = "{\n" +
                        "    \"touser\": \""+open_id+"\", \n" +
                        "    \"msgtype\": \"text\", \n" +
                        "    \"text\": {\n" +
                        "        \"content\": \"你已进行过抽奖，结果为："+map.get("name")+"\"\n" +
                        "    }\n" +
                        "}";
                try {
                    HttpUtil.postHttpByJson(HttpConst.SEND_TEXT_URL,send_text_json);

                    //设置json返回标记
                    msg = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            response.setContentType("text/html;charset=UTF-8");
            try {
                PrintWriter out = response.getWriter();
                out.print(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
