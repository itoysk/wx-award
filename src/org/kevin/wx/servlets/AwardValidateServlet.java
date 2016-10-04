package org.kevin.wx.servlets;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.kevin.wx.dao.AwardDAO;
import org.kevin.wx.util.SignUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by itoysk on 2016/9/22.
 */
public class AwardValidateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String phone = request.getParameter("phone");


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        AwardDAO awardDAO = new AwardDAO();
        Boolean result = false;
        //验证手机号是否未抽奖
        result =  awardDAO.awardValidate(phone);

        if (result == true) {
            //把手机号保存到session，用于在获奖后记录获奖信息
            HttpSession session = request.getSession();
            session.setAttribute("phoneNum",phone);
           out.print("true");
        }
        else {
            out.print("false");
        }
        out.close();
    }


}
