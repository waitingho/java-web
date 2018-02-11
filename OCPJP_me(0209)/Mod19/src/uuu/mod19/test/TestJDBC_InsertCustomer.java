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
 * @author Administrator
 */
public class TestJDBC_InsertCustomer {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/vgb?zeroDateTimeBehavior=convertToNull";
    private static final String userid = "root";
    private static final String pwd = "1234";
    
    public static void main(String[] args) {
        String sql ="INSERT INTO customers " 
                    +"(id,name,password,gender,email,birthday,address,phone,married,blood_type,discount,type) " 
                    +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        Customer c = new Customer();
        
        
        try{
        c.setId("A123123123");
        c.setName("嗨嗨");
        c.setGender(Customer.MALE);
        c.setEmail("ddd@dd.dd.ddd.dd");
        c.setPassword("123456");
        c.setBirthday("2012-02-02");
        c.setAddress("台北市");
        c.setPhone("0922222222");
        c.setMarried(false);
        c.setBloodType(BloodType.O);
        }catch(VGBException ex){
            System.out.println(ex);
        }
        try {
            //1.載入JDBC Driver
            Class.forName(driver);
            
            try (//2.建立connection
                Connection connection = DriverManager.getConnection(url, userid, pwd);
                
                //3.準備指令
                PreparedStatement pstmt = connection.prepareCall(sql);
               
                ){
                //3.1傳入?的值
                pstmt.setString(1, c.getId());
                pstmt.setString(2, c.getName());
                pstmt.setString(3, c.getPassword());
                pstmt.setString(4, String.valueOf(c.getGender()));
                pstmt.setString(5, c.getEmail());
                pstmt.setString(6, c.getBirthday().toString());
                pstmt.setString(7, c.getAddress()!=null?c.getAddress():"");
                pstmt.setString(8, c.getPhone());
                pstmt.setBoolean(9, c.isMarried());
                pstmt.setString(10, c.getBloodType()!=null?c.getBloodType().name():null);
                
                if(c instanceof VIP){
                    pstmt.setInt(11,((VIP)c).getDiscount());
                }else{
                    pstmt.setInt(11,0);
                }
                pstmt.setString(12,c.getClass().getSimpleName());
                
                
                int rows = pstmt.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(TestJDBC_InsertCustomer.class.getName()).log(Level.SEVERE, "無法建立連線", ex);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestJDBC_InsertCustomer.class.getName()).log(Level.SEVERE, 
                    "無法載入Driver:"+driver, ex);
        }
    }
}
