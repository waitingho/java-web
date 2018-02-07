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
   
        private String id;//必要PKey, ROCId
        private String name="";//必要
        private String password;
        private char gender;//必要Ｍ＝男 Ｆ＝女
        private String email;
        private Date birthday;
        private String address;
        private String phone;
        private boolean married = false;
        private int status = 1;
        
        public Customer(){}

    public Customer(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Customer(String id, String name, String password, char gender, String email) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
        this(id, name, password);
        this.gender = gender;
        this.email = email;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
        
        
        public int getAge(){
            int thisYear = Calendar.getInstance().get(Calendar.YEAR);
            Calendar birthCalendar = Calendar.getInstance();
            birthCalendar.setTime(birthday);
            int birthYear = birthCalendar.get(Calendar.YEAR);
            
            return(thisYear-birthYear);
        }

    }

