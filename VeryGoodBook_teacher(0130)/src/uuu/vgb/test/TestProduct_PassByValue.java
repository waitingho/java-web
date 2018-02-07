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
public class TestProduct_PassByValue {

    public static void main(String[] args) {
        //Test 1:
        int i = 1;
        int j = i;

        i++;
        System.out.println("i = " + i);//2
        System.out.println("j = " + j);//1

        Product p1 = new Product(1, "Java SE 9 技術手冊", 650);
        Product p2 = p1;
        Product p3 = new Product(p1.getId(), p1.getName(), p1.getUnitPrice());
        p1.setUnitPrice(p1.getUnitPrice() + 50);
        System.out.println("p1.getUnitPrice() = " + p1.getUnitPrice());//700
        System.out.println("p2.getUnitPrice() = " + p2.getUnitPrice());//700
        System.out.println("p3.getUnitPrice() = " + p3.getUnitPrice());//650

        //Test 2:
        System.out.println("***以下為Test2:**********************************************************");
        Product p4 = new Product(1, "Java SE 9 技術手冊", 650);
//        p4.setUnitPrice(p4.getUnitPrice()+50);
        System.out.println("p4.getUnitPrice() = " + p4.getUnitPrice()); //650

        AddPriceService service = new AddPriceService();

        service.addPrice(p4.getUnitPrice());                
        System.out.println("p4.getUnitPrice() = " + p4.getUnitPrice()); //650

        service.addPrice(p4);
        System.out.println("p4.getUnitPrice() = " + p4.getUnitPrice()); //700
    }
}

class AddPriceService {

    //pass by value
    public void addPrice(double price) {
        price = price + 50;
    }

    public void addPrice(Product p) {
        p.setUnitPrice(p.getUnitPrice() + 50);        
    }

    
//    public double addPrice(double price) {
//        return price + 50;
//    }
//
//    public double addPrice(Product p) {
//        return p.getUnitPrice() + 50;
//    }
}
