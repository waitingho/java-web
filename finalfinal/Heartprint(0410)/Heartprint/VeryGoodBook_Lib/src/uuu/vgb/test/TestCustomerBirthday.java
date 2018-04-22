/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.Customer;

/**
 *
 * @author Administrator
 */
public class TestCustomerBirthday {
    public static void main(String[] args) throws RuntimeException, Error{
        try{  
            System.out.println(0/0.0);
            
            Customer c = new Customer();
            c.setId("A123456789");
            System.out.println(c.getId());
            
            c.setBirthday(2019,10,10);
            c.setBirthday("2999/10/10");
            System.out.println("c.getBirthday()=" + c.getBirthday());
           
        }catch(Exception ex){
//            System.out.println("客戶資料(id,birthday)測試發生錯誤" + ex);
            Logger.getLogger(TestCustomerBirthday.class.getName()).log(Level.SEVERE, 
                    "客戶資料(id,birthday)測試發生錯誤",ex);
        }
    }
}
