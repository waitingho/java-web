/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.VIP;

/**
 *
 * @author Patty Tai
 */
public class TestInstanceof {
    public static void main(String[] args) {
        try {
            Object o = new Object();
            Customer c = new Customer("A123456789", "張三豐", "123456");
            VIP v = new VIP("A223456781", "林梅莉", "123456", 'F', "marie.lin.tw@gmail.com", 20);
            
            System.out.println(o instanceof Object); //true
            System.out.println(c instanceof Object); //true
            System.out.println(v instanceof Object); //true
            
            System.out.println(o instanceof Customer); //false
            System.out.println(c instanceof Customer); //true
            System.out.println(v instanceof Customer); //true
            
            System.out.println(o instanceof VIP); //false
            System.out.println(c instanceof VIP); //false
            System.out.println(v instanceof VIP); //true
            
            Object o1 = null;
            Customer c1 = null;
            VIP v1 = null;
            
            System.out.println(o1 instanceof Object); //false
            System.out.println(c1 instanceof Object); //false
            System.out.println(v1 instanceof Object); //false
            
            System.out.println(o1 instanceof Customer); //false
            System.out.println(c1 instanceof Customer); //false
            System.out.println(v1 instanceof Customer); //false
            
            System.out.println(o1 instanceof VIP); //false
            System.out.println(c1 instanceof VIP); //false        
            System.out.println(v1 instanceof VIP); //false        
        } catch (VGBException ex) {
            Logger.getLogger(TestInstanceof.class.getName()).log(Level.SEVERE, "測試instanceof發生錯誤", ex);
        }
        
    }
}
