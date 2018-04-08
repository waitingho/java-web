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
import uuu.vgb.service.CustomersDAO;

/**
 *
 * @author Administrator
 */
public class TestCustomersDAO {

    public static void main(String[] args) {
        try {
            CustomersDAO dao = new CustomersDAO();
            Customer c = null;

            c = dao.selectById("A123456770");//用身分證查詢客戶
            System.out.println("c = " + c);
            if (c == null) {
                c = new Customer();
                c.setId("A123456770");
                c.setName("乾乾");
                c.setGender(Customer.MALE);
                c.setEmail("eoeo@gmail.com");
                c.setPassword("123456");
                c.setBirthday("2012-02-20");
                c.setAddress("台北市士林區");
                c.setPhone("0922222222");
                c.setMarried(false);
                c.setBloodType(BloodType.O);
                dao.insert(c);
            } else {//有符合身分證的客戶
                c.setAddress("台北市士林區123");
                dao.update(c);
                System.out.println(dao.selectById("A123456770"));
            }
        } catch (VGBException ex) {
            Logger.getLogger(TestCustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
