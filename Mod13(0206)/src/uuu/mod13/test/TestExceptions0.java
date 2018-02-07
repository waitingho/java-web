package uuu.mod13.test;

import java.time.LocalDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Patty Tai
 */
public class TestExceptions0 {

    public static void main(String[] args) {
        int i = 10;
        int j = 0, k;
        try{
            k = i / j; //當j為0會發生Unchecked Exception: java.lang.ArithmeticException: / by zero
            System.out.println("k = " + k);
        }catch(ArithmeticException ex){
            System.out.println("i/j 發生錯誤"+ex.getMessage());
        }
        
        String test = null;
        try{
            System.out.println(test.length()); //當test為null會發生Unchecked Exception: NullPointerException
        }catch(NullPointerException ex){
            System.out.println(ex);
        }        
        
        Date c = new java.util.Date(1000);      
        if(c instanceof java.sql.Date){
            ((java.sql.Date) c).setTime(2000); //當c參考到java.util.Date建立的物件會發生Unchecked Exception:ClassCastException
        }
        
        String s = "abcd";
        //當s的內容不是正確的十進位整數字串，以下程式會發生Unchecked Exception: java.lang.NumberFormatException: For input string: "abcd"
        try{
            k = Integer.parseInt(s, 10);
            System.out.println("k = " + k);
        }catch(NumberFormatException ex){
            System.out.println("整數資料格式不正確:" + s);
        }
        
        s = "1990/12/31";        
        try {
            Date d = DateFormat.getDateInstance().parse(s); //checked Exception: ParseException
            System.out.println("d = " + d);
//            Logger.getLogger(TestExceptions0.class.getName()).log(Level.INFO, "d = " + d);
        } catch (ParseException ex) {
            Logger.getLogger(TestExceptions0.class.getName()).log(
                    Level.SEVERE, "日期格式不正確!", ex);
        }
        

        s = "1990/12/11";   //ISO 8601     
        try{
            LocalDate d2 = LocalDate.parse(s);//unchecked Exception:DateTimeParseException
            System.out.println("d2 = " + d2);
        }catch(DateTimeParseException ex){ //需import java.time.format.DateTimeParseException
            System.out.println("日期格式不正確, 應為yyyy-MM-dd: " + s);
        }        
    }
}
