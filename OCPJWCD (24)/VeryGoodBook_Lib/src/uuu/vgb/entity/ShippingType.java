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
public enum ShippingType {
    SELF("自取"),HOME("送貨到府", 50), STORE("便利店", 65);
    
    private final String description;
    private final int fee;

    private ShippingType(String description){
        this(description, 0);
    }
    
    private ShippingType(String description, int fee) {
        this.description = description;
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public int getFee() {
        return fee;
    }   

    @Override
    public String toString() {
        return description + (fee>0?"-"+fee+"元":"");
    }
}
