/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.service;

import java.util.List;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Order;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.VIP;

/**
 *
 * @author Patty Tai
 */
public class OrderService {
    private OrdersDAO dao = new OrdersDAO();

    public void createOrder(Order order) throws VGBException {
        dao.insert(order);
    }

    public List<Order> getOrdersByCustomerId(String customerId) throws VGBException {
        return dao.selectOrdersByCustomerId(customerId);
    }

    public Order getOrderById(int id) throws VGBException {
        return dao.selectOrderById(id);
    }
    
    //用來示範instanceof和casting，但是其實不需要
    public double order(Customer c, 
            Product p, int quantity){
        double rtn = p.getUnitPrice() * quantity;
        //if(c instanceof VIP && !(p.getClass() == Outlet.class)){
        if(c instanceof VIP && !(p instanceof Outlet)){            
            VIP v = (VIP)c;
            //System.out.println(v==c);//true
            //rtn = rtn * (100 - ((VIP)c).getDiscount())/100;
            rtn = rtn * (100 - v.getDiscount()) / 100;
            
//            rtn *= (100D - v.getDiscount())/100;//rtn =  (double)(rtn * ((100 - v.getDiscount())/100))
        }
        return rtn;
    }   

    public void updateStatusToPaid(int orderId, String customerId, String bank,String fiveCode, 
            double amount, String transferDate, String transferTime) throws VGBException {
        StringBuilder paymentNote = new StringBuilder("轉帳銀行:");
        paymentNote.append(bank).append(',');
        paymentNote.append("後5碼:").append(fiveCode).append(',');
        paymentNote.append("金額:").append(amount).append(',');
        paymentNote.append("時間:").append(transferDate).append(' ').append(transferTime);
        dao.updateStatusToPaid(orderId, customerId, paymentNote.toString());
    }
}
