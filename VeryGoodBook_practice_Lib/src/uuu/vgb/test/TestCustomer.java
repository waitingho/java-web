/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import java.util.GregorianCalendar;
import uuu.vgb.entity.Customer;
import uuu.vgb.service.CustomerService;

/**
 *
 * @author heweiting
 */
public class TestCustomer {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.setId("A12345");
        c1.setName("幹你娘");
        c1.setGender('M');
        c1.setPassword ("66666");
        c1.setEmail("eee@eee.eee");
        c1.setAddress("台北市士林");
        c1.setPhone("333333");
        c1.setMarried(false);
        c1.setBirthday(new GregorianCalendar(2000,10-1,15).getTime());
        System.out.println(c1);
        System.out.println("c1.id = " + c1.getId());
        System.out.println("c1.name = " + c1.getName());
        System.out.println("c1.gender = " + c1.getGender()); 
        System.out.println("c1.password = " + c1.getPassword());
        System.out.println("c1.email = " + c1.getEmail());
        System.out.println("c1.address = " + c1.getAddress());
        System.out.println("c1.phone = " + c1.getPhone());
        System.out.println("c1.married = " + c1.isMarried());
        System.out.println("c1.birthday = " + c1.getBirthday());
        
//        int a = c1.getAge();
//        System.out.println(a);
//        System.out.println(c1.getAge());
        System.out.println("age = " + c1.getAge());
        System.out.println("********************");
        
        
        CustomerService service = new CustomerService();
        Customer customer = service.getCustomer("A123456789");
        System.out.println(customer);
        System.out.println("customer.id = " + customer.getId());
        System.out.println("customer.Name = " + customer.getName());
        System.out.println("customer.gender = " + customer.getGender());
        System.out.println("customer.address = " + customer.getAddress());
        System.out.println("customer.email = " + customer.getEmail());
        System.out.println("customer.married = " + customer.isMarried());
        
        System.out.println("****************************");
        
        c1 = new Customer("A123456789", "靠ㄟ","12345",'M',"eee@eee.eee.ee");
        System.out.println("id : " + c1.getId());
        System.out.println("名字 : " + c1.getName());
        System.out.println("密碼 : " + c1.getPassword());
        System.out.println("性別 : " + c1.getGender());
        System.out.println("email : " + c1.getEmail());
    }
}
