/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.test;

import java.time.LocalDateTime;
import uuu.vgb.entity.Product;

/**
 *
 * @author Patty Tai
 */
public class TestObject {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.getClass().getName());
        System.out.println(Integer.toHexString(o.hashCode()));
        System.out.println(o);
        
        Product p = new Product();
        System.out.println(p.getClass().getName());
        System.out.println(p.getClass().getSimpleName());
        System.out.println(p);
        
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);
    }
}
