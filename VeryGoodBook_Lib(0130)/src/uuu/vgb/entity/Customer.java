/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.entity;

import java.time.LocalDate;
import java.util.Calendar;
//import java.time.LocalDate;

public class Customer {
    //以下宣告了Customer物件的attribute(屬性,又稱member variable, field, object-variable, instance-variable)
    private String id; //必要, PKey, ROC Id
    private String name = ""; //必要    
    private String password = "123456"; //必要, 長度必須為6~20個字元
    private char gender; //必要, 'M':男, 'F':女
    private String email; //必要, email格式檢查(Regular Expression)
//    public Date birthday; //必要，需要import java.util.Date
    private LocalDate birthday; //必要，需要java.time.LocalDate(JDK 8)
    
    private String address;
    private String phone;
    private boolean married = false;
    
    //TODO: for Open-Closed設計示範: bloodType(將用Enum來定義)

    public Customer() {
    }

    public Customer(String id, String name, String password) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
    }

    public Customer(String id, String name, String password, char gender, String email) {
        this(id, name, password);
//        this.id = id;
//        this.name = name;
//        this.password = password;
        this.setGender(gender);
        this.setEmail(email);
    }
    
    public void setGender(char data){
        if(data=='M' || data=='F'){
            this.gender = data;
        }else{
            System.out.println("性別資料不正確");
            //TODO: 拋出錯誤
        }                
    }
    
    public char getGender(){
        return gender;
    }    
    
    public int getAge(){
        int age = 0;
        
        //1.檢查客戶birthday!=null
        if(getBirthday()!=null){
            //當birthday的型別為java.time.LocalDate(JDK 8才有)  
            int theYear = LocalDate.now().getYear();
            int birthYear = getBirthday().getYear();
            age = theYear - birthYear;

            //當birthday的型別為java.util.Date            
            Calendar calendar = Calendar.getInstance();
//            int theYear = calendar.get(Calendar.YEAR);
//            calendar.setTime(birthday);
//            int birthYear = calendar.get(Calendar.YEAR);            
//             age = theYear - birthYear;
        }               
        
        //2.回傳結果
        return age;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {        
        if(this.checkId(id)){
            this.id = id;
        }else{
            System.out.println("客戶身分證號不正確");
        }        
    }
    
    private String firstCharStr = "ABCDEFGHJKLMNPQRSTUVXYWZIO"; 
    public boolean checkId(String id){
        boolean result = false;
        if(id!=null && id.matches("[A-Z][12][0-9][0-9]{8}")){
            //1.將第一碼英文字元轉成對應數字
            char firstChar = id.charAt(0);
            int firstNumber = firstCharStr.indexOf(firstChar) + 10;
            
            //2. 依公式相加
            int sum = firstNumber/10 + firstNumber%10*9;
            for (int i=1;i<9;i++){
                sum += (id.charAt(i)-'0')*(9-i);
            }
            sum += id.charAt(9)-'0';  
            
            //3.加總結果%10為0即正確
            return sum%10 == 0;
        }else{
            return false;
        }        
    }     

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {                        
        if(name!=null){
            name = name.trim();
            if(name.length()>0){
                this.name = name;
                return;
            }
        }        
        System.out.println("客戶姓名必須有值");        
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        if(password!=null && 
                password.length()>=6 && password.length()<=20){
            this.password = password;
        }else{
            System.out.println("密碼必須6~20個字");
        }
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        if(email!=null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            this.email = email;
        }else{
            System.out.println("客戶email格式不正確");
        }
    }

    /**
     * @return the birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(LocalDate birthday) {
        if(birthday!=null && birthday.isBefore(LocalDate.now())){
            this.birthday = birthday;
        }else{
            System.out.println("出生日期必須在今天之前");
        }
    }
    
    public void setBirthday(int year, int month, int day){    	
        //this.birthday = LocalDate.of(year, month, day);        
    	this.setBirthday(LocalDate.of(year, month, day));
    }
    
    //TODO: 13章時再來完成程式內容
    public void setBirthday(String date){
        
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the married
     */
    public boolean isMarried() {
        return married;
    }

    /**
     * @param married the married to set
     */
    public void setMarried(boolean married) {
        this.married = married;
    }

	@Override
	public String toString() {		
		return this.getClass().getSimpleName()
			+"id=" + id + ", 姓名=" + name 
			+ ", 密碼=" + password 
			+ ", 性別=" + gender 
			+ ",\nemail=" + email 
			+ ", 生日=" + birthday 
			+ ",\n地址=" + address 
			+ ", 電話=" + phone 
			+ ", " + (married?"已婚":"未婚") + "]";
	}

    
    
}
