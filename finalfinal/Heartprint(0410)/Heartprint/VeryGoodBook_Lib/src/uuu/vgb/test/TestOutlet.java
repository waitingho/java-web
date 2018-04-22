/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import uuu.vgb.entity.Outlet;

/**
 *
 * @author Administrator
 */
public class TestOutlet {
    public static void main(String[] args) {
        Outlet outlet = new Outlet();
        outlet.setId(1);
        outlet.setName("pig");
        outlet.setDiscount(5);
        outlet.setUnitPrice(660);
        
//        System.out.println("id = " + outlet.getId());
//        System.out.println("name = " + outlet.getName());
//        System.out.println("定價 = " + outlet.getListPrice());
//        System.out.println("售價 = " + outlet.getUnitPrice());
//        System.out.println("discount = " + outlet.getDiscount());
//        System.out.println("discount = " + outlet.getDiscountString());
        System.out.println("outlet:"+outlet);
        
        Outlet outlet2 = new Outlet(2,"ipad",15000,10,50);
        System.out.println(outlet2);
    }
    
}
