/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;

/**
 *
 * @author Patty Tai
 */
public class CustomerService {
    private CustomersDAO dao = new CustomersDAO();
    
    //TO DO: 以下方法內容皆尚未完成
    public void register(Customer c) throws VGBException{
        dao.insert(c);
    }    
    
    public Customer login(String id, String pwd) throws VGBException{
        Customer c = dao.selectById(id);
        if(c==null || !c.getPassword().equals(pwd)){
            throw new VGBException("登入失敗, 帳號或密碼不正確");
        }
        return c;
    }    
    
    public void update(Customer c)throws VGBException{
        dao.update(c);
    }
    
    public Customer get(String id)throws VGBException{
        Customer c = dao.selectById(id);        
        return c;
    }
}
