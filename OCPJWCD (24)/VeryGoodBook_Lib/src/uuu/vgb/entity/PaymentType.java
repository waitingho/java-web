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
public enum PaymentType {
    FACE("面交", ShippingType.SELF), 
    ATM("ATM匯款", ShippingType.HOME, ShippingType.STORE), 
    HOME("貨到付款", 100, ShippingType.HOME); //STORE, CARD
    
    private final String description;
    private final int fee;
    private final ShippingType[] shippingTypeArray;

    private PaymentType(String description, ShippingType... shippingTypeArray){
        this(description,0, shippingTypeArray);
    }
    
    private PaymentType(String description, int fee, ShippingType... shippingTypeArray) {
        this.description = description;
        this.fee = fee;
        this.shippingTypeArray = shippingTypeArray;
    }

    public String getDescription() {
        return description;
    }

    public int getFee() {
        return fee;
    }

    public ShippingType[] getShippingTypeArray() {
        return shippingTypeArray;
    }

    @Override
    public String toString() {
        return description + (fee>0?"-"+fee+"元":"");
    }
}
