/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.Cart;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Order;
import uuu.vgb.entity.PaymentType;
import uuu.vgb.entity.ShippingType;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.ProductService;

/**
 *
 * @author Patty Tai
 */
public class TestOrder {
    public static void main(String[] args) {
        try {
            CustomerService cService = new CustomerService();
            Customer member = cService.login("A223456781", "123456");//VIP
            Customer member2 = cService.login("A123456789", "123456");//一般客戶
            ProductService pService = new ProductService();            
            
            Cart cart = new Cart();
            cart.setMember(member2);
            cart.addCartItem(pService.getProduct(1));            
            cart.addCartItem(pService.getProduct(2),2);                        
            cart.addCartItem(pService.getProduct(1), 2);            
            cart.updateCartItem(pService.getProduct(2), 1);            
//            cart.addCartItem(pService.getProduct(51), 1);
            System.out.println("cart = " + cart);    
            
            Order order = new Order();
            order.setMember(cart.getMember());             
            order.add(cart);
//            order.setPaymentType(PaymentType.ATM);
            order.setPaymentFee(order.getPaymentType().getFee());
            
            order.setShippingType(ShippingType.HOME);
            order.setShippingFee(ShippingType.HOME.getFee());
            
            order.setReceiverName(order.getMember().getName());
            order.setReceiverEmail(order.getMember().getEmail());
            order.setReceiverPhone(
                order.getMember().getPhone()!=null?order.getMember().getPhone():"25142222");
            order.setShippingAddr(
                order.getMember().getAddress()!=null?order.getMember().getAddress():"台北市復興北路99號2F");
            
            System.out.println("order = " + order);
            //OrdersDAO dao = new OrdersDAO();
            //dao.insert(order);
            
        } catch (VGBException ex) {
            Logger.getLogger(TestOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
