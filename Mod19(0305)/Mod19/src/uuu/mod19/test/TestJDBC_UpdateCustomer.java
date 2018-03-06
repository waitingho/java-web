/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.mod19.test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.BloodType;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.VIP;

/**
 *
 * @author Patty Tai
 */
public class TestJDBC_UpdateCustomer {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/vgb?zeroDateTimeBehavior=convertToNull";
    private static final String userid = "root";
    private static final String pwd = "1234";
    private static final String sql = "UPDATE customers "
            + "SET name=?,password=?,gender=?,email=?,birthday=?,"
            + "address=?,phone=?,married=?,blood_type=?,discount=?,type=? "
            + "WHERE id=?";

    public static void main(String[] args) {
        Customer c = new Customer();
        try {
            c.setId("A123123123");
            c.setName("李四方");
            c.setGender(Customer.MALE);
            c.setEmail("four.lee.tw@hotmail.com"); //*
            c.setPassword("123456");
            c.setBirthday("2001-12-25");
            c.setAddress("台北市復興北路99號12F"); //*
            c.setPhone("0987654321");
            c.setMarried(false);
            c.setBloodType(BloodType.O);
        } catch (VGBException ex) {
            System.out.println(ex);
        }

        try {
            //1. 載入Driver
            Class.forName(driver);

            try (
                    //2. 建立連結
                    Connection connection = DriverManager.getConnection(url, userid, pwd);
                    //3. 準備指令
                    PreparedStatement pstmt = connection.prepareStatement(sql);) {
                //3.1傳入?的值
                pstmt.setString(1, c.getName());
                pstmt.setString(2, c.getPassword());
                pstmt.setString(3, String.valueOf(c.getGender()));
                pstmt.setString(4, c.getEmail());
                pstmt.setString(5, c.getBirthday().toString());
                pstmt.setString(6, c.getAddress() != null ? c.getAddress() : "");
                pstmt.setString(7, c.getPhone());
                pstmt.setBoolean(8, c.isMarried());
                pstmt.setString(9, c.getBloodType() != null ? c.getBloodType().name() : null);
                if (c instanceof VIP) {
                    pstmt.setInt(10, ((VIP) c).getDiscount());
                } else {
                    pstmt.setInt(10, 0);
                }

                pstmt.setString(11, c.getClass().getSimpleName());
                pstmt.setString(12, c.getId());
                
                //4.執行指令
                int row = pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(TestJDBC_UpdateCustomer.class.getName()).log(Level.SEVERE, "建立連線失敗", ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestJDBC_UpdateCustomer.class.getName()).log(Level.SEVERE, "無法載入JDBC Driver:" + driver, ex);
        }
    }
}
