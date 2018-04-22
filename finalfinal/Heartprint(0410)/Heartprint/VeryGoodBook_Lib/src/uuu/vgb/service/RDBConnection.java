/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import uuu.vgb.entity.VGBException;

/**
 *
 * @author Administrator
 */
public class RDBConnection {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/vgb?zeroDateTimeBehavior=convertToNull";
    private static final String userid = "root";
    private static final String pwd = "1234";

    public static Connection getConnection() throws VGBException {
        try {
            //1. 取得JNDI Context
            Context ctx = new InitialContext();
            if (ctx == null) {
                throw new VGBException("無法取得JNDI Context.");
            }
            //2.取得DataSource(Connection Pool)
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/vgb");
            if (ds == null) {
                throw new RuntimeException("DataSource could not be found.");
            }
            //3.從DataSource(Connection Pool)取得connection
            Connection connection;
            
                connection = ds.getConnection();
                System.out.println("從Connection Pool取得Connection:" + connection);
                return connection;
            } catch (Exception exp) {
                Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, "無法從Connection Pool取得Connection", exp);
                try {
                    //1. 載入Driver
                    Class.forName(driver);
                    try {
                        //2.建立連線
                        Connection connection = DriverManager.getConnection(url, userid, pwd);
                        System.out.println("建立了JDBC連線:" + connection);
                        return connection;
                    } catch (SQLException ex) {
                        Logger.getLogger(RDBConnection.class.getName()).log(Level.SEVERE, "建立連線失敗", ex);
                        throw new VGBException("建立連線失敗", ex);
                    }

                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(RDBConnection.class.getName()).log(Level.SEVERE, "無法載入JDBC Driver:" + driver, ex);
                    throw new VGBException("無法載入JDBC Driver:" + driver, ex);
                }
            }
        }
    }

