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

    public Customer() {}

    public Customer(String id, String name, String password) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
    }

    public Customer(String id, String name, String password, char gender, String email) {
        this(id,name,password);

//        this.id = id;
//        this.name = name;
//        this.password = password;
        this.setGender(gender);
        this.setEmail(email);
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
            System.out.println("身分證輸入錯誤");
        }
        
    }
        private static String firstCharStr = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
        private static String idRegExp = "^[A-Z][12][0-9]{8}$";
        public boolean checkId(String id){
            boolean result = false;
            if(id != null && id.matches(idRegExp)){
               //1.將第一碼英文字轉成對應數字
               char firstChar = id.charAt(0);
               int firstNumber = firstCharStr.indexOf(firstChar)+10;
               
               //2.依公式相加
               int sum = firstNumber/10 + firstNumber % 10 * 9;
               for (int i = 1; i<9; i ++){
                   sum += (id.charAt(i)-'0') * (9-i);
               }
               sum += id.charAt(9)-'0';
               
               //3.加總結果%10為0即正確
                return sum % 10 == 0;
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
        if (name!=null){
            name = name.trim();
            if (name.length()>0) {
                this.name = name;
                   return;
            }
        }
        System.out.println("沒打到名字啦");
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
        
    }
    
    private static int PASSWORD_MIN_LENGTH = 6;
    private static int PASSWORD_MAX_LENGTH = 20;

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        if (password != null
                && password.length() >= PASSWORD_MIN_LENGTH 
                && password.length() <= PASSWORD_MAX_LENGTH) {   
        this.password = password;
    }else{
            System.out.println("密碼必須"+PASSWORD_MIN_LENGTH+"~"+PASSWORD_MAX_LENGTH);
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
            System.out.println("你格式打錯惹");
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
            System.out.println("你他媽時光旅人?" );    
        }
    }
    public void setBirthday(int year, int month, int day){
//        this.birthday = LocalDate.of(year,month,day);
    		this.setBirthday(LocalDate.of(year, month,day ));
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

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"[id=" + id + ", 姓名=" + name + ", 密碼=" + password 
				+ ", \n性別=" + gender + ", email="+ email 
				+ ", \n生日=" + birthday + ", 地址=" + address 
				+ ", \n電話=" + phone + ", married="+ (married?"已婚":"未婚" )+ "]";
	}

    @Override
    public boolean equals(Object obj) {
        boolean rtn = false;
        if(this==obj) return true;
        
        if(obj instanceof Customer){
            Customer c = (Customer)obj;
            if(this.id!=null && this.id.equals(c.id)
                    && this.name!= null && this.name.equals(c.name)
                    && this.gender == c.gender){
                rtn = true;
            }
                    
        }
        return rtn;
    }
    
    
}
