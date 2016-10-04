package org.kevin.wx.util;

import java.sql.*;
import java.util.Properties;

/**
 * Created by itoysk on 2016/9/22.
 */
public class JdbcUtil {
    private static String url = "jdbc:mysql://localhost:3306/wx";
    private static String username = "root";
    private static String password = "";
    private static String driverName = "com.mysql.jdbc.Driver";

    public JdbcUtil() {
        super();
    }

    static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                if(st!=null){
                    st.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                if(conn!=null){
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}