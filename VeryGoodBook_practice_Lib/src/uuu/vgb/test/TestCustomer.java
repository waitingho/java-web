/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import java.util.GregorianCalendar;
import uuu.vgb.entity.Customer;

/**
 *
 * @author heweiting
 */
public class TestCustomer {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.id = "A12345";
        c1.name = "幹你娘";
        c1.gender = 'M';
        c1.password = "66666";
        c1.email = "eee@eee.eee";
        c1.address = "台北市士林";
        c1.phone = "333333";
        c1.married = false;
        c1.birthday = new GregorianCalendar(1998,10-1,15).getTime();
        System.out.println(c1);
        System.out.println("c1.id = " + c1.id);
        System.out.println("c1.name = " + c1.name);
        System.out.println("c1.gender = " + c1.gender); 
        System.out.println("c1.password = " + c1.password);
        System.out.println("c1.email = " + c1.email);
        System.out.println("c1.address = " + c1.address);
        System.out.println("c1.phone = " + c1.phone);
        System.out.println("c1.married = " + c1.married);
        System.out.println("c1.birthday = " + c1.birthday);
    }
}
