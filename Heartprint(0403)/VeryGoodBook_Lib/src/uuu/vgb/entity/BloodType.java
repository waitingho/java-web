/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.entity;

/**
 *
 * @author Administrator
 */
public enum BloodType {
    O,A(10),B(20),AB(30);//第一行一定要列出列舉值
    
    private final int code;
    
    private BloodType(){
        this(10);
    }

    private BloodType(int code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return super.toString()+'型'; //To change body of generated methods, choose Tools | Templates.
    }
    
}
