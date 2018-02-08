package uuu.mod13.test;

import java.time.LocalDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
public class TestExceptions1 {    
    public static void main(String[] args) {
        try {
            
            int i = 10, j = 20, k;            
            k = i / j; //當j為0會發生Unchecked Exception: java.lang.ArithmeticException: / by zero
            System.out.println("k = " + k);
            
            if(k==1) return;
            
            String test = "";
            System.out.println(test.length()); //當test為null會發生Unchecked Exception: NullPointerException
            
            String s = "1234";
            //當s的內容不是正確的十進位整數字串，以下程式會發生Unchecked Exception: java.lang.NumberFormatException: For input string: "abcd"
            k = Integer.parseInt(s, 10);
            System.out.println("k = " + k);
            
            s = "1990/12/31";
            s = s.replace('/', '-');
            //Date d = DateFormat.getDateInstance().parse(s); //checked Exception: ParseException
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(s); //checked Exception: ParseException
            System.out.println("d = " + d);
            
            //s = "1990-12-11";   //ISO 8601     
            LocalDate d2 = LocalDate.parse(s);//unchecked Exception:DateTimeParseException
            System.out.println("d2 = " + d2);
        } catch(ArithmeticException ex){
            System.out.println("i/j 發生錯誤: "+ex.getMessage());
        } catch(NullPointerException ex){
            System.out.println("test或s字串不得為null!");
        } catch (NumberFormatException|ParseException|DateTimeParseException ex) {
            Logger.getLogger(TestExceptions1.class.getName()).log(
                    Level.SEVERE, "整數或日期格式不正確", ex);
        } catch(Exception ex){
//            Logger.getLogger(TestExceptions1.class.getName()).log(
//                    Level.SEVERE, "系統發非預期錯誤!", ex);            
            System.err.println(LocalDateTime.now() + ",系統發非預期錯誤!");
            ex.printStackTrace();
        } finally{        
            System.out.println("The End!");
        }
    }
    
}
