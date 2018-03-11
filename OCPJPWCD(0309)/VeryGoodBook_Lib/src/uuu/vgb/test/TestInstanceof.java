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
 * @author Administrator
 */
public class TestInstanceof {
    public static void main(String[] args) {
        try {
            Object o = new Object();
            Customer c = new Customer("A123456789","安安","123456");
            VIP v = new VIP("A123456789","喔喔","123456",'F',"fff@rrr.com",20);
            
            System.out.println(o instanceof Object);
            System.out.println(c instanceof Object);
            System.out.println(v instanceof Object);
            
            System.out.println("-------------8->----------------------");
            
            System.out.println(o instanceof Customer );
            System.out.println(c instanceof Customer );
            System.out.println(v instanceof Customer );
            
            System.out.println("-------------8->----------------------");
            
            System.out.println(o instanceof VIP );
            System.out.println(c instanceof VIP );
            System.out.println(v instanceof VIP );
        } catch (VGBException ex) {
            Logger.getLogger(TestInstanceof.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
