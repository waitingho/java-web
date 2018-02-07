/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.service;

import uuu.vgb.entity.Customer;

/**
 *
 * @author heweiting
 */
public class CustomerService {
    public Customer getCustomer(String id){
        Customer c = new Customer();
        c.setId(id);
        c.setName("你媽");
        c.setAddress("台北市士林");
        c.setEmail("www@www.w.tw");
        c.setGender('M');
        c.setMarried(true);
        return c;
    }
}
