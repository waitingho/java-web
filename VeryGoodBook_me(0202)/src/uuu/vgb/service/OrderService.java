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
 * @author Administrator
 */
public class OrderService {
    public double order(Customer c, Product p, int quantity){
        double rtn = p.getUnitPrice()*quantity;
        //if(c instanceof VIP && !(p.getClass()== outlet.class){
        if(c instanceof VIP && !(p instanceof Outlet)){
            VIP v = (VIP)c;//同個東西當成不同物件用
//            System.out.println(v==c);
//            rtn = rtn*(100-((VIP) c).getDiscount()/100);
            rtn =rtn *(100-v.getDiscount())/100;
//            rtn *=(100-v.getDiscount())/100;//右邊先做 所以int/int=0(80/100=0)再算左邊 所以變成0
        }
        return rtn;
    }
}
