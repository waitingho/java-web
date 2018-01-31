/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.entity;

import java.time.LocalDate;

/**
 *
 * @author Administrator
 */
public class Customer {
    private String id;//必要,PKey, Roc Id, attribute(屬性), member variable, attribute, field, object-variable, instance-variable
    private String name = "";
    private String password = "123456";//長度必須6~20個字元
    private char gender;//必要,'M':男,'F':女
    private String email; //必要,格式檢查(Regular Expression)
//    public Date birthday; //必要, 需要import java.util.Date
//    public LocalData; //必須 需要java.time.Localdate
    private LocalDate birthday;
    private String address;
    private String phone;
    private boolean married = false;
    //藍色是關鍵字 綠色是屬性
    //TODO: for Open-Closed 設計示範:bloodType(將用Enum來定義)

    public Customer() {
    }

    public Customer(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Customer(String id, String name, String password, char gender, String email) {
        this(id,name,password);

//        this.id = id;
//        this.name = name;
//        this.password = password;
        this.gender = gender;
        this.email = email;
    }
    
    
    
    
    public void setGender(char data){//data式區域變數
        if( data == 'M'||data == 'F' ){
            gender = data;
        }else{
            System.out.println("性別資料不正確");
            //TODO:拋出資料
            
                 
        }
    }
    
    public char getGender(){
        return gender;
    }
    
    public int getAge(){
        int age = 0;
        
        //1.檢查客戶的birthday != null
        if( getBirthday() != null ){
            //當birthday的型別為java.time.LocalDates(JDK 8 才有)
            int theYear   = LocalDate.now().getYear();
            int birthYear = getBirthday().getYear();
            
            age = theYear - birthYear;


              //當birthday的型別為java.util.Date
//              Calendar calender = Calendar.getInstance();//百萬年曆翻到現在
//              int theYear = calender.get(Calendar.YEAR);//取出年
//              
//              calender.setTime(birthday);//翻到生日
//              int birthday = calender.get(Calendar.YEAR);//去出年
//              age = theYear - birthday;
        
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
        this.id = id;//名稱相同ㄉ話 用this.來抓屬性    
        }else{
            System.out.println("輸入錯誤");
        }
        
    }
        private String firstCharStr = "ABCDEFGHJKLMNPQRSTUVXZWZIO";
        public boolean checkId(String id){
            boolean result = false;
            if(id!=null && id.matches("[A-Z][12][0-9][0-9]{8}")){
                //1.將第一馬英文字轉成對應之數字
                
                char firstChar = id.charAt(0);
                int firstNumber = firstCharStr.indexOf(firstChar)+10;
                
                //2.依公式相加
                int sum = firstNumber/10 + firstNumber%10*9;
                for (int i = 1; i<9;i++){
                    sum+=(id.charAt(i)-'0')*(9-i);
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
        this.name = name;
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
        this.password = password;
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
        this.email = email;
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
        this.birthday = birthday;
    }
    
    public void setBirthday(int year, int month, int day){
        this.birthday = LocalDate.of(year,month,day);
    }
    //TODO:13章回來
    
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
}
