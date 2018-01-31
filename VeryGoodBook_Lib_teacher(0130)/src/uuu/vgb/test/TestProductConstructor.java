/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.test;
import uuu.vgb.entity.Product;

/**
 *
 * @author Patty Tai
 */
public class TestProductConstructor {
    public static void main(String[] args) {
        Product p = new Product(1, "Java SE 9 技術手冊",650, 20);
//        p.setId(1);
//        p.setName("Java SE 9 技術手冊");
//        p.setUnitPrice(650);
//        p.setStock(20);
        p.setPhotoUrl("http://im1.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/077/37/0010773787.jpg&w=85&h=120&v=5a3101af");
        p.setDescription("提供Java 9新功能快速索引,深入探討Java模組平臺系統,JDK基礎與IDE操作交相對照");
        
        System.out.println("p.id = " + p.getId());
        System.out.println("p.name = " + p.getName());
        System.out.println("p.unitPrice = " + p.getUnitPrice());
        System.out.println("p.stock = " + p.getStock());
        System.out.println("p.photoUrl = " + p.getPhotoUrl());
        System.out.println("p.description = " + p.getDescription());
    }
}
