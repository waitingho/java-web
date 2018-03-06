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

/**
 *
 * @author Patty Tai
 */
public class TestCustomerBloodType {
    public static void main(String[] args) {
        try {
            Customer c = new Customer("A123456789", "張三豐", "123456");
            c.setBloodType(BloodType.AB); //AB
            System.out.println("c.bloodType:" + c.getBloodType());
            
            c.setBloodType(BloodType.valueOf("AB"));
            System.out.println("c.bloodType:" + c.getBloodType());
            
            BloodType[] bloodTypeValues = BloodType.values();
            for(int i=0;i<bloodTypeValues.length;i++){
                System.out.println(bloodTypeValues[i].toString());
                System.out.println(bloodTypeValues[i].name());
                System.out.println(bloodTypeValues[i].ordinal());
                System.out.println(bloodTypeValues[i].getCode());
            }
            System.out.println("************");
            
            switch(c.getBloodType()){
                case O:
                case AB:
                    System.out.println("有95折折扣");
                    break;
                case A:
                case B:
                    System.out.println("無折扣");
                    break;
                default:
                    System.out.println("無此種資料的折扣");
            }
        } catch (VGBException ex) {
            Logger.getLogger(TestCustomerBloodType.class.getName()).log(Level.SEVERE, "測試客戶血型發生錯誤!", ex);
        }
    }
}
