package org.kevin.wx.dao;

import org.kevin.wx.entity.Award;
import org.kevin.wx.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by itoysk on 2016/9/22.
 */
public class AwardDAO {

    /**
     * 校验open_id是否抽过奖
     * @param open_id
     * @return
     */
    public boolean awardValidateById(String open_id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "select open_id from msg_award where open_id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, open_id);
            rs = ps.executeQuery();
            while(rs.next()){
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(rs, ps, conn);
        }
        return true;
    }

    /**
     * 校验手机号是否使用过
     * @param phone
     * @return
     * @throws Exception
     */
    public boolean awardValidate(String phone){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "select phone from msg_award where phone = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            while(rs.next()){
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(rs, ps, conn);
        }
        return true;
    }

    /**
     * 获得所有奖品列表
     * @return
     */
    public List<Award> getAward(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[][] obj = null;
        List<Award> list = new ArrayList<Award>();
        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from award";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            Award award = null;
            while(rs.next()){
                award = new Award();
                award.setId(rs.getInt("id"));
                award.setLevel(rs.getInt("level"));
                award.setName(rs.getString("name"));
                award.setRate(rs.getDouble("rate"));
                award.setCount(rs.getInt("count"));
                award.setMin_angle(rs.getInt("min_angle"));
                award.setMax_angle(rs.getInt("max_angle"));
                list.add(award);
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(rs, ps, conn);
        }
        if (list.size() != 0 && list != null){
            return list;
        }
        return null;
    }


    /**
     * 插入中奖信息
     * @param phone
     * @param prizeId
     */
    public void insertAwardMsg(String phone,int prizeId,String open_id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[][] obj = null;
        List<Award> list = new ArrayList<Award>();
        try {
            conn = JdbcUtil.getConnection();
            String sql = "insert into msg_award (phone,prize,time,open_id) values (?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1,phone);
            ps.setInt(2,prizeId);

            Date d = new Date();
            System.out.println(d);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateNowStr = sdf.format(d);
            ps.setString(3,dateNowStr);

            ps.setString(4,open_id);

            ps.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(rs, ps, conn);
        }

    }

    public Map<String,String> getUserAward(String open_id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[][] obj = null;
        Map<String,String> map = new HashMap<>();
        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from award,msg_award where award.id = msg_award.prize and msg_award.open_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,open_id);
            rs = ps.executeQuery();
            while(rs.next()){
                map.put("name",rs.getString("name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(rs, ps, conn);
        }
        return map;
    }
}
