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
 * @author Administrator
 */
public class TestObject {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.getClass().getName());
        System.out.println(Integer.toHexString(o.hashCode()));
        System.out.println(o.toString());//沒內容所已出現類別名稱及記憶體位置
        
        Product p = new Product();
        System.out.println(p.getClass().getName());
        System.out.println(p.getClass().getSimpleName());
        System.out.println(p.toString());
        
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);
        
    }
}
