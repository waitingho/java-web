/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Order;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.OrdersDAO;

/**
 *
 * @author Patty Tai
 */
public class TestOrdersDAOSelectOrdersHistory {
    public static void main(String[] args) {
        try {
//            CustomerService cService = new CustomerService();
//            Customer member = cService.login("A123123123", "123456");
            
            OrdersDAO dao = new OrdersDAO();
            List<Order> list = dao.selectOrdersByCustomerId("A123456789");
            System.out.println("list = " + list);
            
            System.out.println(dao.selectOrderById(1));
            
        } catch (VGBException ex) {
            Logger.getLogger(TestOrdersDAOSelectOrdersHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
