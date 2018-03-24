/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.entity;

import java.util.Objects;

/**
 *
 * @author Patty Tai
 */
public class CartItem {
    private Product product;
    private String color;   
    

    public CartItem() {
    }

    public CartItem(Product product, String color) {
        this.product = product;
        this.color = color;
    }

    public Product getProduct() {
        return product;
    }

    public String getColor() {
        return color;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.product);
        hash = 71 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CartItem other = (CartItem) obj;
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CartItem{" + "產品=" + product + ",顏色=" + color + '}';
    }    
    
}
