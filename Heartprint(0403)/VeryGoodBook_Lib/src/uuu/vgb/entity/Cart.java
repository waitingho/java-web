/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class Cart {

    private Customer member;
    private Map<CartItem, Integer> cart = new HashMap<>();

    public Customer getMember() {
        return member;
    }

    public void setMember(Customer member) {
        this.member = member;
    }

    //為cart提供mutator methods
    
    
    public void addCartItem(Product p, int q) {
       if (p == null) {
            throw new IllegalArgumentException("加入購物車的商品不得為null");
        }

        CartItem item = new CartItem(p);
        Integer oldQ = cart.get(item);
        if (oldQ != null) {
            cart.put(item, oldQ + q);
        } else {
            cart.put(item, q);
        }
    }

    public void addCartItem(Product p) {
        
        addCartItem(p, 1);
    }

    public void updateCartItem(Product p, int q) {
         CartItem item = new CartItem(p);
        cart.put(item, q);
        
    }

    public void removeCartItem(Product p) {
        removeCartItem(p);
    }

    //為cart提供accessors methods
    public boolean isEmpty() {//delegate method，查詢購物車是否為空的
        return cart.isEmpty();
    }

    public int size() {//delegate method，查詢購物車有幾項CartItem
        return cart.size();
    }

    public int getTotalQuantity() {
        int totalQ = 0;
        for (Integer q : cart.values()) {
            totalQ = totalQ + q;
        }
        return totalQ;
    }

    public Set<CartItem> getCartItemSet() { //查詢購物車的CartItemSet
        return cart.keySet();
    }

    public Integer getQuantity(CartItem key) {//查詢購物車中一項CartItemSet的購買數量
        return cart.get(key);
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (CartItem item : cart.keySet()) {
            double amount = item.getProduct().getUnitPrice() * this.getQuantity(item);
            if (member instanceof VIP && !(item.getProduct() instanceof Outlet)) {
                amount *= (100D - ((VIP) member).getDiscount()) / 100;
            }
            totalAmount = totalAmount + amount;
        }
        return totalAmount;
    }

    public double getTotalListAmount() {//計算折扣前總金額是幾元
        double totalAmount = 0;
        for (CartItem item : cart.keySet()) {
            double amount = item.getProduct().getUnitPrice() * this.getQuantity(item);
            totalAmount = totalAmount + amount;
        }
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Cart{" + "member=" + member + ", cart=" + cart
                + "共" + size() + "項, 共" + this.getTotalQuantity()
                + "件, 總金額: " + this.getTotalAmount()
                + "元, 折扣前總金額: " + this.getTotalListAmount()
                + "元}";
    }

}
