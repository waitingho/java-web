package uuu.mod19.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import uuu.vgb.entity.BloodType;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.VIP;

public class TestJDBC_SelectCustomerObj {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/vgb?zeroDateTimeBehavior=convertToNull";
    private static final String userid = "root";
    private static final String pwd = "1234";

    public static void main(String[] args) {
        String id = "' OR ''='"; //"1' OR '1'='1"; //"A123456789"
        String password = "123456";
        String sql = "SELECT id, name,password,gender,email,birthday,"
                + "address,phone,married,blood_type,discount,type "
                + "FROM customers "
                + "WHERE id=? AND password=?";

        try {
            //1. load JDBC Driver
            Class.forName(driver);

            try (
                    //2. 建立Connection
                    Connection connection = DriverManager.getConnection(url, userid, pwd);
                    //3. 準備PreparedStatement
                    PreparedStatement pstmt = connection.prepareStatement(sql);) {

                //3.1 傳入?對應的資料
                pstmt.setString(1, id);
                pstmt.setString(2, password);
                try (
                        //4.執行Statement
                        ResultSet rs = pstmt.executeQuery();
                ) {
                    //5.處理ResultSet
                    Customer c = null;
                    while (rs.next()) {
                        String type = rs.getString("type");
                        if (type.equals("VIP")) {
                            c = new VIP();
                        } else {
                            c = new Customer();
                        }

                        try {
                            c.setId(rs.getString("id"));
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
                                    System.out.println("血型不正確");
                                }
                            }

                            if (c instanceof VIP) {
                                ((VIP) c).setDiscount(rs.getInt("discount"));
                            }
                        } catch (VGBException ex) {
                            Logger.getLogger(TestJDBC_SelectCustomerObj.class.getName()).log(Level.SEVERE, "customer 資料不正確", ex);
                        }
                    }
                    System.out.println("c=" + c);
                    //TODO: }
                }
            } catch (SQLException ex) {
                Logger.getLogger(TestJDBC_SelectCustomerObj.class.getName()).log(Level.SEVERE, "無法連線", ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestJDBC_SelectCustomerObj.class.getName()).log(Level.SEVERE,
                    "load JDBC Driver failed: " + driver, ex);
        }
    }
}
