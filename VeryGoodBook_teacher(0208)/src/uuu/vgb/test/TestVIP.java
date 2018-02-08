/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.VIP;

/**
 *
 * @author Patty Tai
 */
public class TestVIP {

    public static void main(String[] args) {
        try {
            VIP vip = new VIP();
            vip.setId("A123123123");
            vip.setName("郝冶仁");
            vip.setEmail("richman1234-hau@uuu.com.tw");
            vip.setGender('M');
            vip.setPassword("123456");
            vip.setBirthday(2000, 6, 6);
            vip.setDiscount(20);

//        System.out.println("id:" + vip.getId());
//        System.out.println("name:" + vip.getName());
//        System.out.println("email:" + vip.getEmail());
//        System.out.println("gender:" + vip.getGender());
//        System.out.println("birthday:" + vip.getBirthday());
//        System.out.println("discount:" + vip.getDiscount());
//        System.out.println("discount:" + vip.getDiscountString());
            System.out.println("vip:" + vip);
        } catch (VGBException ex) {
            Logger.getLogger(TestVIP.class.getName()).log(Level.SEVERE, "測試VIP發生錯誤", ex);
        } catch(Exception ex){
            Logger.getLogger(TestVIP.class.getName()).log(Level.SEVERE, "測試VIP發生非預期錯誤", ex);
        }
    }
}
