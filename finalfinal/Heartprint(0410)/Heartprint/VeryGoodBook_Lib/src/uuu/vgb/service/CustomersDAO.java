/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.service;

import java.util.ArrayList;
import java.util.List;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.BloodType;
import uuu.vgb.entity.VIP;

/**
 * 針對vgb資料庫中customers資料表格 提供insert, update, select...
 *
 * @author Patty Tai
 */
public class CustomersDAO {//Data Access Object

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/vgb?zeroDateTimeBehavior=convertToNull";
    private static final String userid = "root";
    private static final String pwd = "1234";

    public static Connection getConnection() throws VGBException {
        try {
            //1. 載入Driver
            Class.forName(driver);

            try {
                //2. 建立連線
                Connection connection = DriverManager.getConnection(url, userid, pwd);
                return connection;
            } catch (SQLException ex) {
                Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, "建立連線失敗", ex);
                throw new VGBException("建立連線失敗", ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, "無法載入JDBC Driver:" + driver, ex);
            throw new VGBException("無法載入JDBC Driver:" + driver, ex);
        }
    }

    private static final String INSERT_SQL = "INSERT INTO customers "
            + "(id, name,password,gender,email,birthday, address,phone,married,blood_type, discount, type) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

    public void insert(Customer c) throws VGBException {
        try (
                //2.取得連線
                Connection connection = getConnection();
                //3.準備指令
                PreparedStatement pstmt = connection.prepareStatement(INSERT_SQL);) {
            //3.1 傳入?值
            pstmt.setString(1, c.getId());
            pstmt.setString(2, c.getName());
            pstmt.setString(3, c.getPassword());
            pstmt.setString(4, String.valueOf(c.getGender()));
            pstmt.setString(5, c.getEmail());
            pstmt.setString(6, c.getBirthday().toString());
            pstmt.setString(7, c.getAddress() != null ? c.getAddress() : "");
            pstmt.setString(8, c.getPhone());
            pstmt.setBoolean(9, c.isMarried());
            pstmt.setString(10, c.getBloodType() != null ? c.getBloodType().name() : null);
            if (c instanceof VIP) {
                pstmt.setInt(11, ((VIP) c).getDiscount());
            } else {
                pstmt.setInt(11, 0);
            }

            pstmt.setString(12, c.getClass().getSimpleName());

            //4. 執行指令
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                throw new VGBException("新增客戶失敗-身分證號已重複註冊", ex);
            }
            throw new VGBException("新增客戶失敗", ex);
        }
    }

    private static final String UPDATE_SQL = "UPDATE customers "
            + "SET name=?,password=?,gender=?,email=?,birthday=?,"
            + "address=?,phone=?,married=?,blood_type=?,discount=?,type=? "
            + "WHERE id=?";

    public void update(Customer c) throws VGBException {
        try (
                //2.取得連線
                Connection connection = getConnection();
                //3.準備指令
                PreparedStatement pstmt = connection.prepareStatement(UPDATE_SQL);) {
            //3.1 傳入?值            
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

            //4. 執行指令
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw new VGBException("修改客戶失敗", ex);
        }
    }

    public void delete(Customer c) throws VGBException {
        //TODO: 各自決定是否要完成
    }

    private static final String SELECT_BY_ID = "SELECT id, name,password,gender,email,birthday,"
            + "address,phone,married,blood_type,discount,type "
            + "FROM customers "
            + "WHERE id=?";

    public Customer selectById(String id) throws VGBException {
        Customer c = null;

        try (
                //2.取得連線
                Connection connection = getConnection();
                //3. 準備指令
                PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID);) {
            //3.1 傳入?值
            pstmt.setString(1, id);

            try (
                    //4.執行指令
                    ResultSet rs = pstmt.executeQuery();) {
                //5.處理rs
                while (rs.next()) {
                    String type = rs.getString("type");
                    if (type.equals("VIP")) {//Class.forName("類別完整名稱").newInstance()
                        c = new VIP();
                    } else {
                        c = new Customer();
                    }

                    c.setId(id);
                    c.setName(rs.getString("name"));
                    c.setPassword(rs.getString("password"));
                    c.setGender(rs.getString("gender").charAt(0));
                    c.setEmail(rs.getString("email"));
                    c.setBirthday(rs.getString("birthday"));
                    c.setAddress(rs.getString("address"));
                    c.setPhone(rs.getString("phone"));
                    c.setMarried(rs.getBoolean("married"));
                    String bType = rs.getString("blood_type");
                    if (bType != null) {
                        try {
                            c.setBloodType(BloodType.valueOf(bType));
                        } catch (RuntimeException ex) {
                            System.out.println("血型不正確:" + bType);
                        }
                    }

                    if (c instanceof VIP) {
                        ((VIP) c).setDiscount(rs.getInt("discount"));
                    }
                }
            }
        } catch (SQLException ex) {
            throw new VGBException("查詢客戶失敗", ex);
        }
        return c;
    }

    public List<Customer> selectAll() throws VGBException {
        List<Customer> list = new ArrayList<>();

        return list;
    }
}
