package org.kevin.wx.servlets;

import org.kevin.wx.dao.AwardDAO;
import org.kevin.wx.entity.Award;
import org.kevin.wx.util.HttpConst;
import org.kevin.wx.util.HttpUtil;
import org.kevin.wx.util.LotteryUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by itoysk on 2016/9/22.
 */
public class AwardServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //作手机号检验
        String phoneNum = (String) request.getSession().getAttribute("phoneNum");

        //获得用户open_id
        String open_id = (String) request.getSession().getAttribute("open_id");


        AwardDAO awardDAO = new AwardDAO();

        //获得所有奖品list
        List<Award> prizeArr = awardDAO.getAward();

        //抽奖后返回角度和奖品等级
        Object result[] = award(prizeArr);

        //记录获奖信息
        awardDAO.insertAwardMsg(phoneNum,(Integer) result[1],open_id);


        //返回json给前台
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("{\"angle\":\""+result[0]+"\",\"msg\":\""+result[2]+"\"}");
        System.out.println("转动角度:"+result[0]+"\t奖项ID:"+result[1]+"\t提示信息:"+result[2]);


//        //向用户推送一条文本消息
//        String send_text_json = "{\n" +
//                "    \"touser\": \""+open_id+"\", \n" +
//                "    \"msgtype\": \"text\", \n" +
//                "    \"text\": {\n" +
//                "        \"content\": \"你已进行过抽奖，结果为："+result[2]+"\"\n" +
//                "    }\n" +
//                "}";
//        HttpUtil.postHttpByJson(HttpConst.SEND_TEXT_URL,send_text_json);
    }

    //抽奖并返回角度和奖项
    public Object[] award(List<Award> prizeArr){
        //获得概率数组
        List<Double> orignalRates = new ArrayList<Double>(prizeArr.size());
        for (int i =0; i<prizeArr.size(); i++){
            orignalRates.add(prizeArr.get(i).getRate());
        }

        //获得奖项id
        int prizeIndex = LotteryUtil.lottery(orignalRates);
        Award award = prizeArr.get(prizeIndex);
        int prizeId = award.getId(); //根据概率获取奖项id
        //旋转角度
        int angle = new Random().nextInt(award.getMax_angle()-award.getMin_angle())+award.getMin_angle();
        String msg = award.getName();//提示信息
        return new Object[]{angle,prizeId,msg};
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
