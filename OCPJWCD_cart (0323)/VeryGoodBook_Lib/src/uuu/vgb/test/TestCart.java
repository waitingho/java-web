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
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.ProductService;

/**
 *
 * @author Patty Tai
 */
public class TestCart {
    public static void main(String[] args) {
        try {
            CustomerService cService = new CustomerService();
            Customer member = cService.login("A123456789", "123456");
            Customer member2 = cService.login("A123123123", "123456");
            ProductService pService = new ProductService();            
            
            Cart cart = new Cart();
            cart.setMember(member2);
            cart.addCartItem(pService.getProduct(1));
            System.out.println("加入1號1個 cart = " + cart);
            
            cart.addCartItem(pService.getProduct(2),2);            
            System.out.println("加入2號2個 cart = " + cart);
            
            cart.addCartItem(pService.getProduct(1), 2);
            System.out.println("加入1號2個 cart = " + cart);
            
            cart.updateCartItem(pService.getProduct(2), 1);
            System.out.println("修改2號2個 cart = " + cart);
            
            cart.addCartItem(pService.getProduct(51), 1);
            System.out.println("加入51號1個 cart = " + cart);            
            
        } catch (VGBException ex) {
            Logger.getLogger(TestCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
