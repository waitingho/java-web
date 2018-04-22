/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import uuu.vgb.entity.Product;

/**
 *
 * @author Administrator
 */
public class TestProduct {
    public static void main(String[] args) {
        Product p = new Product(1,"誰說不能從武俠學物理？",320,10);
        p.setId(1);
        p.setName("誰說不能從武俠學物理？");
        p.setUnitPrice(320);
        p.setStock(10);
        p.setDescription("物理學說明萬物的運行原理武俠世界裡的力學與速度，遵守的是同一套定律嗎？");
        p.setPhotoUrl("http://im2.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/077/53/0010775306_bc_01.jpg&v=5a5f41d8&w=655&h=609");
        
        System.out.println("p.Id = " + p.getId());
        System.out.println("p.name = " + p.getName());
        System.out.println("p.unitPrice = " + p.getUnitPrice());
        System.out.println("p.stock = " + p.getStock());
        System.out.println("p.description= " + p.getDescription());
        System.out.println("p.photoUrl = " + p.getPhotoUrl());
        System.out.println("p:" + p);
               
    }
}
