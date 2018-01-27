/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import java.time.LocalDate;
import uuu.vgb.entity.Customer;

/**
 *
 * @author Administrator
 */
public class TestCustomer {
    public static void main(String[] args) {
        int i = 100;
        Customer c = new Customer();
        c.setId("A123123123");
        c.setName("令狐沖");
        c.setPassword("6666");
        c.setGender ('M');//only 'M' or 'F'
        c.setEmail("test@uuu.com");
        //c.birthday = new GregorianCalendar(1991,01,10).getTime();//for birthday: java.util.datacalendar要用.getTime()來抓下來成為date
//        c.setBirthday(LocalDate.of(1991,02,10));
        c.setBirthday(2000,05,5);
        c.setAddress("台北市復興北路99號14樓");
        c.setPhone("25149191");
        c.setMarried(true);
        
        System.out.println("c.id : "+c.getId());
        System.out.println("c.name : " + c.getName());
        System.out.println("c.getGender : " + c.getGender());
        System.out.println("c.password : " + c.getPassword());
        System.out.println("c.email : " + c.getEmail() );
        System.out.println("c.birthday : " + c.getBirthday());
        System.out.println("c.getAge() = " + c.getAge());
        System.out.println("c.address : " + c.getAddress());
        System.out.println("c.phone : " + c.getPassword());
        System.out.println("c.married : " + c.isMarried());
    }
}
