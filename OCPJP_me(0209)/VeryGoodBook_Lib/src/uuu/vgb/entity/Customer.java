/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.entity;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Customer {
    public static final char MALE ='M';
    public static final char FEMALE = 'F';
    
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
    private BloodType bloodType;//"O","A","B","AB"

    public Customer() {}

    public Customer(String id, String name, String password) throws VGBException {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
    }

    public Customer(String id, String name, String password, char gender, String email) throws VGBException {
        this(id,name,password);

//        this.id = id;
//        this.name = name;
//        this.password = password;
        this.setGender(gender);
        this.setEmail(email);
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
    
    
    
    
    public void setGender(char data){//data式區域變數
        if( data == MALE||data == FEMALE ){
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
    public void setId(String id)throws VGBException{
        if(this.checkId(id)){
            this.id = id;//名稱相同ㄉ話 用this.來抓屬性    
        }else{
            System.out.println("身分證輸入錯誤");
            throw new VGBException("身分證輸入錯誤"+ id);
        }
        
    }
       private static final String FIRST_CHAR_MAP_STRING = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
    private static final String ID_REG_EXP = "[A-Z][12][0-9]{8}";

    public static boolean checkId(String id) {
        boolean result = false;
        if (id != null && id.matches(ID_REG_EXP)) {
//            //1.將第一碼英文字元轉成對應數字
//            char firstChar = id.charAt(0);
//            int firstNumber = FIRST_CHAR_MAP_STRING.indexOf(firstChar) + 10;
//
//            //2. 依公式相加
//            int sum = firstNumber / 10 + firstNumber % 10 * 9;
//            for (int i = 1; i < 9; i++) {
//                sum += (id.charAt(i) - '0') * (9 - i);
//            }
//            sum += id.charAt(9) - '0';

            //3.呼叫getLastNumberFromId("前9碼的id"),取得最後一碼與現在id的最後一碼相同即為正確的id
            char lastChar = id.charAt(9);
            char genChar = getLastNumberFromId(id.substring(0, 9));
            return lastChar == genChar;
        } else {
            return false;
        }
    }

    public static char getLastNumberFromId(String id_9) {
        char firstChar = id_9.charAt(0);
        char lastChar = '\u0000';

        //1.將第一碼英文字元轉成對應數字 A~Z -> 10~35        
        int firstNumber = FIRST_CHAR_MAP_STRING.indexOf(firstChar) + 10;
//        System.out.println("firstNumber = " + firstNumber);
        assert (firstNumber >= 10 && firstNumber <= 35) : "firstNumber = " + firstNumber;

        //2. 依公式相加
        int data = (firstNumber / 10) * 1 + (firstNumber % 10) * 9;
        for (int i = 1; i < 9; i++) {
            int c = Integer.parseInt(id_9.charAt(i) + "") * (8 - i + 1);
            data += c;
        }
        assert (data > 0) : "data=" + data;

        //3. 產生最後一碼
        lastChar = (char) ((10 - (data % 10)) % 10 + '0');
        assert (lastChar >= '0' && lastChar <= '9') : "lastChar=" + lastChar;

        return lastChar;
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
    public void setName(String name) throws VGBException {
        if (name!=null){
            name = name.trim();
            if (name.length()>0) {
                this.name = name;
                   return;
            }
        }
        System.out.println("沒打到名字啦");
        throw new VGBException("客戶姓名必須有值");
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
    public void setPassword(String password) throws VGBException {
        if (password != null
                && password.length() >= PASSWORD_MIN_LENGTH 
                && password.length() <= PASSWORD_MAX_LENGTH) {   
        this.password = password;
    }else{
            String msg = "密碼必須"+PASSWORD_MIN_LENGTH+"~"+PASSWORD_MAX_LENGTH;
            System.out.println(msg);
            throw new VGBException(msg); 
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
    public void setBirthday(LocalDate birthday)throws VGBException {
        if(birthday!=null && birthday.isBefore(LocalDate.now())){
        	this.birthday = birthday;
    }else{
            if(birthday==null){
//                System.out.println("客戶生日不得為null");
                throw new VGBException("客戶生日不得為null");
            }else{
//                 System.out.println("你他媽時光旅人?" );
                 throw new VGBException("你他媽時空旅人?");
            }
        }
    }
    public void setBirthday(int year, int month, int day) throws VGBException{
//        this.birthday = LocalDate.of(year,month,day);
        try{
    		this.setBirthday(LocalDate.of(year, month,day ));
        }catch(VGBException ex){
        //額外錯誤處理...
                throw ex;
        }
    }
    //TODO:13章回來
    
    public void setBirthday(String date) throws VGBException{
        //若客戶生日是用java.time.LocalDate,則用以下ㄉ程式轉換為字串為java.time.LocalDate物件
        try{
//            if(date!=null){
                date = date.replace("/", "-");
                LocalDate d = LocalDate.parse(date);//yyyy-MM-dd unchecked exception: DatwTimeParesException
                this.setBirthday(d);
//            }else{
//                this.setBirthday((LocalDate)null);
//            }
         
        }catch(DateTimeParseException ex){
//            System.out.println("客戶生日日期格式不正確");
             Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, "客戶生日日期格式不正確", ex);
             throw new VGBException("客戶生日日期格式不正確",ex);
        }
        
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
                        +"[id=" + id + ", 姓名=" + name + ", 密碼=" + password 
                        + ", \n性別=" + (gender == MALE?"MALE":(gender == FEMALE?"FEMAL":gender))
                        + ", email="+ email 
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
