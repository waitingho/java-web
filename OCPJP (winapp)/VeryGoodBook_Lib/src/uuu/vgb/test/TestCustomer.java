/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.*;

/**
 *
 * @author Patty Tai
 */
public class TestCustomer {

    public static void main(String[] args) {
        int i;
        System.out.println(i = 100); //100    
        String id = "Z159026230";
        if (Customer.checkId(id)) {
            try {
                Customer c = new Customer();
                System.out.println("c.id:" + c.getId()); //null
                System.out.println("c.name:" + c.getName()); //""
                System.out.println("c.password:" + c.getPassword()); //123456
                System.out.println("c.gender:" + c.getGender()); //0x0000
                System.out.println("c.email:" + c.getEmail());//null
                System.out.println("c.birthday:" + c.getBirthday()); //null
                System.out.println("c.address:" + c.getAddress()); //null
                System.out.println("c.phone:" + c.getPhone()); //null
                System.out.println("c.married:" + c.isMarried()); //false
                System.out.println("*****************");
                c.setId(new String(id)); //A123456789, K162858100, Z159026230, A123123123
                c.setName("張三豐"); //"   張三豐    ", "    ", null
                c.setPassword("666666");
                c.setGender(Customer.MALE);
                c.setEmail("test@uuu.com");
//        c.birthday = new GregorianCalendar(2000,10-1,15).getTime(); //for birthday: java.util.Date
                c.setBirthday(LocalDate.of(2000, 10, 15));
//        c.setBirthday(2000,10,5);
                c.setAddress("台北市復興北路99號14F");
                c.setPhone("25149191");
                c.setMarried(true);

//        System.out.println("c.id:" + c.getId());
//        System.out.println("c.name:" + c.getName());
//        System.out.println("c.password:" + c.getPassword());
                System.out.println("c.gender:" + c.getGender());
//        System.out.println("c.email:" + c.getEmail());
//        System.out.println("c.birthday:" + c.getBirthday());
//        System.out.println("c.getAge():" + c.getAge());
//        System.out.println("c.address:" + c.getAddress());
//        System.out.println("c.phone:" + c.getPhone());
//        System.out.println("c.married:" + c.isMarried());
                System.out.println(c);
                System.out.println("*****************");
                Customer c1 = new Customer("A333333333", "", "123");
                System.out.println(c1);
            } catch (VGBException ex) {
                Logger.getLogger(TestCustomer.class.getName()).log(Level.SEVERE, "測試客戶資料發生錯誤", ex);
            }
        }
    }
}
