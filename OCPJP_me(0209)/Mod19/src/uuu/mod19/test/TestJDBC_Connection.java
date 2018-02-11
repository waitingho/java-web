/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.mod19.test;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class TestJDBC_Connection {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/vgb?zeroDateTimeBehavior=convertToNull";
    private static final String userid = "root";
    private static final String pwd = "1234";
    
    public static void main(String[] args) {
        
        try {
            //1.載入JDBC Driver
            Class.forName(driver);
            
            try (//2.建立connection
                Connection connection = DriverManager.getConnection(url, userid, pwd);){
                
                System.out.println("連線成功: "+connection.getCatalog());
                
                //3.//4.這裡不示範
            } catch (SQLException ex) {
                Logger.getLogger(TestJDBC_Connection.class.getName()).log(Level.SEVERE, "無法建立連線", ex);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestJDBC_Connection.class.getName()).log(Level.SEVERE, 
                    "無法載入Driver:"+driver, ex);
        }
    }
}
