/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class Order {

    private int id;
    private Customer member;
    private LocalDateTime orderTime = LocalDateTime.now();

    private PaymentType paymentType;
    private int paymentFee;
    private String paymentNote;

    private ShippingType shippingType;
    private int shippingFee;
    private String shippingNote;

    private String receiverName;
    private String receiverEmail;
    private String receiverPhone;
    private String shippingAddr;

    private Set<OrderItem> orderItemSet = new HashSet<>();
    private double totalAmount;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void add(OrderItem item) {//DAO從資料庫查歷史訂單明細    
        orderItemSet.add(item);
    }

    public void add(Cart cart) {//from CheckOutServlet將購物車明細變成訂單明細
        if (cart == null || cart.isEmpty()) {
            throw new java.lang.IllegalArgumentException("購物車沒有明細，無法加入訂單");
        }
        for (CartItem cartItem : cart.getCartItemSet()) {
            OrderItem item = new OrderItem();
            item.setProduct(cartItem.getProduct());
            if (member instanceof VIP && !(cartItem.getProduct() instanceof Outlet)) {
                item.setPrice(cartItem.getProduct().getUnitPrice()
                        * (100 - ((VIP) member).getDiscount()) / 100);
            } else {
                item.setPrice(cartItem.getProduct().getUnitPrice());
            }
            item.setQuantity(cart.getQuantity(cartItem));

            orderItemSet.add(item); //****不要忘了
        }
    }

    public int size() {
        return orderItemSet.size();
    }

    public int getTotalQuantity() {
        int totalQ = 0;
        if (orderItemSet != null && orderItemSet.size() > 0) {
            for (OrderItem item : orderItemSet) {
                totalQ = totalQ + item.getQuantity();
            }
        }
        return totalQ;
    }

    public Set<OrderItem> getOrderItemSet() {
        //return Collections.unmodifiableSet(orderItemSet); //回傳不可變更內容的正本        
        return new HashSet<>(orderItemSet); //回傳 複本
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getMember() {
        return member;
    }

    public void setMember(Customer member) {
        this.member = member;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public int getPaymentFee() {
        return paymentFee;
    }

    public void setPaymentFee(int paymentFee) {
        this.paymentFee = paymentFee;
    }

    public String getShippingNote() {
        return shippingNote;
    }

    public void setShippingNote(String shippingNote) {
        this.shippingNote = shippingNote;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

   

    public String getPaymentNote() {
        return paymentNote;
    }

    public void setPaymentNote(String paymentNote) {
        this.paymentNote = paymentNote;
    }

    public ShippingType getShippingType() {
        return shippingType;
    }

    public void setShippingType(ShippingType shippingType) {
        this.shippingType = shippingType;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getShippingAddr() {
        return shippingAddr;
    }

    public void setShippingAddr(String shippingAddr) {
        this.shippingAddr = shippingAddr;
    }

    public double getTotalAmount() {
        if(orderItemSet!=null && orderItemSet.size()>0){
            double amount = 0;
            for(OrderItem item:orderItemSet){
                amount = amount + item.getPrice() * item.getQuantity();
            }
            return amount;
        }
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "訂單{" + "編號=" + id 
                + ", 訂購人=" + member + ",\n 訂購時間=" + orderTime 
                + ", 付款=(" + paymentType + ", 手續費=" + paymentFee + ", 備註=" + paymentNote + ")"
                + ", 貨運=(" + shippingType + ", 手續費=" + shippingFee + ",  備註=" + shippingNote + "),\n "
                + "收件人=(" + receiverName + ", " + receiverEmail + ", " + receiverPhone + "," + shippingAddr + "),\n"
                + orderItemSet + ", 總金額=" + getTotalAmount() + ", 狀態=" + status + '}';
    }

    
    }


