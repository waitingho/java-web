/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import uuu.vgb.entity.Product;
import uuu.vgb.service.ProductService;

/**
 *
 * @author heweiting
 */
public class TestProduct {
    public static void main(String[] args) {
        Product p = new Product();
        System.out.println(p.getId());//0
        System.out.println(p.getName());//null
        System.out.println(p.getUnitprice());//0.0
        System.out.println(p.isFree());//false
        System.out.println(p.getStock());//0
        System.out.println(p.getDescription());//null
        System.out.println(p.getPhotoUrl());//null
        
        System.out.println("**********************************");
    ProductService service = new ProductService();
    Product pp = service.getProduct(3);
        System.out.println(pp.getId());
        System.out.println(pp.getName());
        System.out.println(pp.getUnitprice());
        System.out.println(pp.getStock());
        System.out.println(service.calculateProductInventory(pp));
        System.out.println("************************************");
        
         p.setId(1); 
         p.setName("跳跳蛋"); 
         p.setUnitprice(9000);
         p.setFree(false);
         p.setStock(0);
         p.setDescription("地方媽媽專用");
         p.setPhotoUrl("yyyyy");
         System.out.println("id = " + p.getId());
         System.out.println("name = " + p.getName());
         System.out.println("uniprice = " + p.getUnitprice());
         System.out.println("free = " + p.isFree());
         System.out.println("stock = " + p.getStock());       
         System.out.println("description = " + p.getDescription());
         System.out.println("photoUrl = " + p.getPhotoUrl());
         
         System.out.println("****************************");
         
         p = new Product(10,"跳蛋",200,90);
         System.out.println(p.getId());
         System.out.println(p.getName());
         System.out.println(p.getUnitprice());
         System.out.println(p.getStock());
    }
}
