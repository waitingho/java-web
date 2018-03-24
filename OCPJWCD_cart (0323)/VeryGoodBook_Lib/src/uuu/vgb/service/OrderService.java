/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VIP;

/**
 *
 * @author Patty Tai
 */
public class OrderService {
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
}
