/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;

/**
 *
 * @author Administrator
 */
public class TestCustomer {
    public static void main(String[] args) {
        try {
            int i = 100;
            
            Customer c = new Customer();
            c.setId("A12345789");
            c.setName("機機三比零");//去空白用name.trim
            c.setPassword("666666");
            c.setGender (Customer.MALE);//only 'M' or 'F'
            c.setEmail("test@uuu.com");
            //c.birthday = new GregorianCalendar(1991,01,10).getTime();//for birthday: java.util.datacalendar要用.getTime()來抓下來成為date
//        c.setBirthday(LocalDate.of(1991,02,10));
c.setBirthday(2011,05,5);
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
System.out.println(c);
System.out.println("**********************************");
Customer c1 = new Customer("A144442222","","123");
System.out.println(c1);
        } catch (VGBException ex) {
            Logger.getLogger(TestCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
