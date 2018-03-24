/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.Book;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.VIP;
import uuu.vgb.service.OrderService;

/**
 *
 * @author Patty Tai
 */
public class TestOrderService {
    public static void main(String[] args) {
        try {
            Customer c1 = new Customer(
                    "A123456789", "張三豐", "123456", 'M',
                    "sammual.chang.tw@gmail.com"
            );
            System.out.println("c1 = " + c1);
            
            Product p = new Product(
                    1, "iPad mini 4", 15000
            );
            System.out.println("p = " + p);
            
            OrderService service = new OrderService();
            double amount = service.order(c1, p, 2);
            System.out.println("c1購買p,2台, amount = " + amount);//30000
            
            VIP vip = new VIP();
            vip.setId("A223456781");
            vip.setName("林梅莉");
            vip.setPassword("123456");
            vip.setGender('F');
            vip.setEmail("marie.lin.tw@gmail.com");
            vip.setDiscount(20);
            System.out.println("vip = " + vip);
            
            Outlet outlet = new Outlet(2, "iPad Mini 2",
                    15000, 5, 50
            );
            System.out.println("outlet = " + outlet);
            
            Book book = new Book();
            book.setId(3);
            book.setName("Java SE 9 研究手冊");
            book.setUnitPrice(620);
            book.setDiscount(5);
            book.setStock(20);
            
            double amount2 = service.order(vip, p, 2);
            System.out.println("vip買p,2台, amount2 = " + amount2);//24000
            
            double amount3 = service.order(c1, outlet, 2);
            System.out.println("c1買outlet,2台, amount3 = " + amount3);//15000
            
            double amount4 = service.order(vip, outlet, 2);
            System.out.println("vip買outlet,2台, " + "amount4 = " + amount4);//15000
            
            double amount5 = service.order(c1, book, 2);
            System.out.println("c1買book,2本, amount5 = " + amount5);//1178
            
            double amoun6 = service.order(vip, book, 2);
            System.out.println("vip買book,2本, amoun6 = " + amoun6);//1178
        } catch (VGBException ex) {
            Logger.getLogger(TestOrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
