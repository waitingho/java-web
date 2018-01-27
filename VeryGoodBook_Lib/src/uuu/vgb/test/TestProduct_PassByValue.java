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
public class TestProduct_PassByValue {
    public static void main(String[] args) {
        int i =1;
        int j = i;
        i++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        
        Product p1 = new Product(1,"幹妳媽",650);
        Product p2 = p1;
        
        Product p3 = new Product(p1.getId(),p1.getName(),p1.getUnitPrice());
        p1.setUnitPrice(p1.getUnitPrice()+50);
        System.out.println("p1.getUnitPrice() = " + p1.getUnitPrice());//700
        System.out.println("p2.getUnitPrice() = " +p2.getUnitPrice() );//指向同個物件
        
        System.out.println("p3.getUnitPrice() = " +p3.getUnitPrice() );//不同物件
        
        //Test 2;
        System.out.println("********以下為Test2************");
        
        Product p4 = new Product(1,"幹妳媽",650);
        System.out.println("p4.getUnitPrice() = " + p4.getUnitPrice());
        
//        AddPriceService service = new AddPriceService();
        
//        service.addPrice(p4.getUnitPrice());
        
    }
}


class AddPriceServe{
    public void addPrice(double price){
         price = price + 50;
}
    
    public void addPrice(Product p){
        p.setUnitPrice(p.getUnitPrice()+50);
    }
}

//public double addPrice(double price){
//    return price +50;
//}
//}
