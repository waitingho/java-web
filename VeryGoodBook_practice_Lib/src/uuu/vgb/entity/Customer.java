/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.entity;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author heweiting
 */
public class Customer {
   
        public String id;//必要PKey, ROCId
        public String name="";//必要
        public String password;
        public char gender;//必要Ｍ＝男 Ｆ＝女
        public String email;
        public Date birthday;
        public String address;
        public String phone;
        public boolean married = false;
        public int status = 1;
        
        
        public int getAge(){
            int thisYear = Calendar.getInstance().get(Calendar.YEAR);
            Calendar birthCalendar = Calendar.getInstance();
            birthCalendar.setTime(birthday);
            int birthYear = birthCalendar.get(Calendar.YEAR);
            
            return(thisYear-birthYear);
        }

    }

