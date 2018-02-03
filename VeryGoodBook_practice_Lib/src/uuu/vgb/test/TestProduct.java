/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import uuu.vgb.entity.Product;

/**
 *
 * @author heweiting
 */
public class TestProduct {
    public static void main(String[] args) {
        Product p = new Product();
        System.out.println(p.id);//0
        System.out.println(p.name);//null
        System.out.println(p.unitprice);//0.0
        System.out.println(p.free);//false
        System.out.println(p.stock);//0
        System.out.println(p.description);//null
        System.out.println(p.photoUrl);//null
        
         p.id = 1;
         p.name = "跳跳蛋";
         p.unitprice = 9000;
         p.free = false;
         p.stock = 0;
         p.description = "地方媽媽專用";
         p.photoUrl = "yyyyy";
         System.out.println("id = " + p.id);
         System.out.println("name = " + p.name);
         System.out.println("uniprice = " + p.unitprice);
         System.out.println("free = " + p.free);
         System.out.println("stock = " + p.stock);
         System.out.println("description = " + p.description);
         System.out.println("photoUrl = " + p.photoUrl);
    }
}
