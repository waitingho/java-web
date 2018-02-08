/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.mod13.test;

/**
 *
 * @author Patty Tai
 */
public class TestErrors {
    static{
        String ageStr = "1234";        
        int i = Integer.parseInt(ageStr);
        System.out.println("i = " + i);
    }
    
    public static void main(String[] args) {
        //if(args!=null){
        try{
            main(null);
//        }catch(Error err){
//            System.out.println("err:" + err);
        } finally{
            System.out.println("The End");
        }
//        }else{
//            System.out.println("The End");
//        }
    }
}
