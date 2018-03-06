/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.BloodType;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;

/**
 *
 * @author Patty Tai
 */
public class TestCustomerService {

    public static void main(String[] args) {
        try {
            CustomerService dao = new CustomerService();        
            
            Customer c = null;
            
            c = dao.get("A123456770");   //用身分證號查詢客戶
            System.out.println("c = " + c);
            
            if (c == null) {//沒有符合身分證號的客戶則新增
                c = new Customer();                
                c.setId("A123456770");
                c.setName("王武");
                c.setGender(Customer.MALE);
                c.setEmail("five.wang.tw@gmail.com");
                c.setPassword("123456");
                c.setBirthday("2001-05-25");
                c.setAddress("台北市復興北路三段101號1F");
                c.setPhone(null);
                c.setMarried(false);
                c.setBloodType(BloodType.O);                
                dao.register(c);
            } else {//有符合身分證號的客戶則修改
                c.setAddress("台北市復興北路99號12F");
                dao.update(c);
                System.out.println(dao.get("A123456770"));
            }
        } catch (VGBException ex) {
            Logger.getLogger(TestCustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
