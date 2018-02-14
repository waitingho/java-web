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
    private String name = "";//必要
    private String password;
    private char gender;//必要Ｍ＝男 Ｆ＝女
    private String email;
    private Date birthday;
    private String address;
    private String phone;
    private boolean married = false;
    private int status = 1;

    public Customer() {
    }

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
        if (this.checkId(id)) {
            this.id = id;
        } else {
            System.out.println("身份證號不正確" + id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && (name.trim()).length() > 0) {

            this.name = name;
        } else {
            System.out.println("名字必須給值");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && (password = password.trim()).length() > 6) {
            this.password = password;
        } else {
            System.out.println("你他媽密碼長度不夠");
        }
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender == 'M' | gender == 'F') {
            this.gender = gender;
        } else {
            System.out.println("打錯 要Ｍ or Ｆ");
        }
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

    public int getAge() {
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        Calendar birthCalendar = Calendar.getInstance();
        birthCalendar.setTime(birthday);
        int birthYear = birthCalendar.get(Calendar.YEAR);

        return (thisYear - birthYear);
    }

    public boolean checkId(String id) {
        boolean result;
        if (id == null || (id = id.trim().toUpperCase()).length() != 10) {
            System.out.println("長度不正確");
            return false;
        }
        System.out.println(id);
         if(!id.matches("[A~Z][12][0-9]{8}")){
            System.out.println("格式不符");
            return false;
        }else{
             char firstChar = id.charAt(0);
             int firstNumber;
             if(firstChar >='A')
         }
        
    }

}
