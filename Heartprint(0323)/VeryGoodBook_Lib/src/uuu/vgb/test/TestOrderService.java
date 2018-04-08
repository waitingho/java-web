/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;


import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.VIP;
import uuu.vgb.service.OrderService;

/**
 *
 * @author Administrator
 */
public class TestOrderService {
    public static void main(String[] args) {
        try {
            Customer c1 = new Customer("A123456789","安安","123456",'M',"eee@eee.com.tw");
            System.out.println("c1 = " + c1);
            
            Product p = new Product(
                    1,"ipad4",15000);
            
            System.out.println("p = " + p);
            
            OrderService service = new OrderService();
            double amount = service.order(c1,p,2);
            
            System.out.println("c1購買2台,amount ="  + amount);
            System.out.println("******************************");
            
            VIP vip = new VIP();
            vip.setId("A123456789");
            vip.setName("恩恩");
            vip.setPassword("5555555");
            vip.setGender('F');
            vip.setEmail("fff@ff.fff.ff");
            vip.setDiscount(20);
            System.out.println("vip = " + vip);
            
            Outlet outlet = new Outlet(2,"ipad2",15000,5,50);
            
            System.out.println("outlet = " + outlet);
            System.out.println("**************************");
            
            double amount2 = service.order(vip, p,2);
            System.out.println("vip買p,2台,amount2 = " + amount2);
            
            double amount3 = service.order(c1, outlet, 2);
            System.out.println("c1買outlet,2台"+"amount3 = " + amount3);
            
            double amount4 = service.order(vip, outlet, 2);
            System.out.println("vip買outlet,2台"+"amount4 = " + amount4);
        } catch (VGBException ex) {
            Logger.getLogger(TestOrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
