/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.entity;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
//import java.time.LocalDate;

public class Customer {

    public static final char MALE = 'M';
    public static final char FEMALE = 'F';

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

    //for Open-Closed設計示範: bloodType(將用Enum來定義)
    private BloodType bloodType; //"O", "A", "B", "AB"

    public Customer() {
    }

    public Customer(String id, String name, String password) throws VGBException {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
    }

    public Customer(String id, String name, String password, char gender, String email) throws VGBException {
        this(id, name, password);
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

    public void setGender(char data) {
        if (data == MALE || data == FEMALE) {
            this.gender = data;
        } else {
            System.out.println("性別資料不正確");
            //TODO: 拋出錯誤
        }
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        int age = 0;

        //1.檢查客戶birthday!=null
        if (getBirthday() != null) {
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
    public void setId(String id) throws VGBException{
        if (this.checkId(id)) {
            this.id = id;
        } else {
            System.err.println("客戶身分證號不正確");            
            throw new VGBException("客戶身分證號不正確:" + id);            
        }
    }

    private static final String FIRST_CHAR_MAP_STRING = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
    private static final String ID_REG_EXP = "[A-Z][12][0-9]{8}";

    public static boolean checkId(String id) {
        boolean result = false;
        if (id != null && id.matches(ID_REG_EXP)) {
            //1.將第一碼英文字元轉成對應數字
            char firstChar = id.charAt(0);
            int firstNumber = FIRST_CHAR_MAP_STRING.indexOf(firstChar) + 10;

            //2. 依公式相加
            int sum = firstNumber / 10 + firstNumber % 10 * 9;
            for (int i = 1; i < 9; i++) {
                sum += (id.charAt(i) - '0') * (9 - i);
            }
            sum += id.charAt(9) - '0';

            //3.加總結果%10為0即正確
            return sum % 10 == 0;
        } else {
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
    public void setName(String name) throws VGBException {
        if (name != null) {
            name = name.trim();
            if (name.length() > 0) {
                this.name = name;
                return;
            }
        }
        System.out.println("客戶姓名必須有值");
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
        } else {
            String msg = "密碼必須" + PASSWORD_MIN_LENGTH + "~"
                    + PASSWORD_MAX_LENGTH + "個字";
            //System.out.println(msg);
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
        if (email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            this.email = email;
        } else {
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
    public void setBirthday(LocalDate birthday)throws VGBException {
        if (birthday != null && birthday.isBefore(LocalDate.now())) {
            this.birthday = birthday;
        } else if (birthday == null) {
//            System.out.println("客戶生日不得為null");
            throw new VGBException("客戶生日不得為null");
        } else {
            //System.out.println("客戶生日必須在今天之前");
            throw new VGBException("客戶生日必須在今天之前");
        }
    }

    public void setBirthday(int year, int month, int day) throws VGBException {        
            //this.birthday = LocalDate.of(year, month, day);
            try{
                this.setBirthday(LocalDate.of(year, month, day));        
            }catch(VGBException ex){
                //額外錯誤處理....
                throw ex;
            }
    }

    //13章時再來完成程式內容
    public void setBirthday(String date) throws VGBException {
        //若客戶生日是用java.time.LocalDate,則用以下的程式轉換字串為java.time.LocalDate物件    
        try {
            if (date != null) {
                date = date.replace("/", "-");
                LocalDate d = LocalDate.parse(date); //yyyy-MM-dd, unchecked exception: DateTimeParseException
                this.setBirthday(d);
            } else {
                this.setBirthday((LocalDate) null);
            }
        } catch (DateTimeParseException ex) {
//            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, 
//                    "客戶生日日期格式不正確!", ex);            
            throw new VGBException("客戶生日日期格式不正確!", ex);
        }

        //若客戶生日是用java.util.Date,則用以下的程式轉換字串為 java.util.Date 物件    
//        try {
//            java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date); //checked Exception: ParseException
//            this.setBirthday(d);
//        } catch (ParseException ex) {
//            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
                + "id=" + id + ", 姓名=" + name
                + ", 密碼=" + password
                + ", 性別=" + (gender == MALE ? "MALE" : (gender == FEMALE ? "FEMALE" : gender))
                + ",\nemail=" + email
                + ", 生日=" + birthday
                + ",\n地址=" + address
                + ", 電話=" + phone
                + ", " + (married ? "已婚" : "未婚") + "]";
    }

    @Override
    public boolean equals(Object obj) {
        boolean rtn = false;
        if (this == obj) {
            return true;
        }
        if (obj instanceof Customer) {
            Customer c = (Customer) obj;
            if (this.id != null && this.id.equals(c.id) //              && this.name!=null && this.name.equals(c.name)
                    //              && this.gender == c.gender 
                    ) {
                rtn = true;
            }
        }
        return rtn;
    }
}
