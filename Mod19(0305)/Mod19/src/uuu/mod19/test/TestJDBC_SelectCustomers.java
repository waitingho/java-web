/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.mod19.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import uuu.vgb.entity.BloodType;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.VIP;

/**
 *
 * @author Patty Tai
 */
public class TestJDBC_SelectCustomers {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/vgb?zeroDateTimeBehavior=convertToNull";
    private static final String userid = "root";
    private static final String pwd = "1234";

    public static void main(String[] args) {
        String sql = "SELECT id, name,password,gender,email,birthday,"
                + "address,phone,married,blood_type,discount,type "
                + "FROM customers";
        try {
            //1. 載入JDBC Driver
            Class.forName(driver);

            try (
                    //2.建立Connection
                    Connection connection = DriverManager.getConnection(url, userid, pwd);
                    //3.建立Statement
                    Statement stmt = connection.createStatement();
                    //4.執行指令
                    ResultSet rs = stmt.executeQuery(sql);) {
                //5.處理resultset
                List<Customer> cutomersList = new ArrayList<>(5);
                while (rs.next()) {
                    String type = rs.getString("type");
                    Customer c = null;
                    if (type != null && type.equals("VIP")) {
                        c = new VIP();
                    } else {
                        c = new Customer();
                    }
                    try {
                        c.setId(rs.getString("id"));
                        c.setName(rs.getString("name"));
                        c.setPassword(rs.getString("password"));
                        c.setEmail(rs.getString("email"));
                        c.setGender(rs.getString("gender").charAt(0));
                        c.setBirthday(rs.getString("birthday"));
                        c.setAddress(rs.getString("address"));
                        c.setPhone(rs.getString("phone"));
                        c.setMarried(rs.getBoolean("married"));
                        String bType = rs.getString("blood_type");
                        if (bType != null) {
                            try {
                                c.setBloodType(BloodType.valueOf(bType));
                            } catch (RuntimeException ex) {
                                System.out.println("客戶(" + c.getId() + ")血型不正確: " + bType);
                            }
                        }
                        if (c instanceof VIP) {
                            ((VIP) c).setDiscount(rs.getInt("discount"));
                        }
                        System.out.println(c);
                        cutomersList.add(c);
                    } catch (VGBException ex) {
                        System.out.println(ex);
                    }
                }
                System.out.println("cutomersList = " + cutomersList);
                System.out.println("cutomersList = " + cutomersList.size());
            } catch (SQLException ex) {
                Logger.getLogger(TestJDBC_SelectCustomers.class.getName()).log(Level.SEVERE,
                        "無法建立連線", ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestJDBC_SelectCustomers.class.getName()).log(Level.SEVERE,
                    "無法載入JDBC Driver:" + driver, ex);
        }

    }
}
