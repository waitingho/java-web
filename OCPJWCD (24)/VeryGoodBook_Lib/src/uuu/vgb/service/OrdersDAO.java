/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.service;

import uuu.vgb.entity.Order;
import uuu.vgb.entity.VGBException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.OrderItem;
import uuu.vgb.entity.PaymentType;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.ShippingType;
import uuu.vgb.entity.Status;

/**
 *
 * @author Patty Tai
 */
public class OrdersDAO {

    private static final String INSERT_ORDER_SQL = "INSERT INTO orders "
            + "(id,customer_id,order_time,payment_type,payment_fee,"
            + "shipping_type,shipping_fee,receiver_name,receiver_email,receiver_phone,shipping_addr,status) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,0)";
    private static final String INSERT_ORDER_ITEM_SQL = "INSERT INTO order_items"
            + " (order_id,product_id,price,quantity)"
            + " VALUES (?,?,?,?)";

    public void insert(Order order) throws VGBException {
        if (order == null) {
            throw new IllegalArgumentException("新增訂單失敗，order物件不得為null");
        }
        try (Connection connection = RDBConnection.getConnection();//2. 建立連線
                PreparedStatement pstmt1 = connection.prepareStatement(INSERT_ORDER_SQL,
                        order.getId() <= 0 ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS); //3. 準備指令1
                PreparedStatement pstmt2 = connection.prepareStatement(INSERT_ORDER_ITEM_SQL); //3. 準備指令2
                ) {
            connection.setAutoCommit(false);
            try {
                //3.1 傳入指令1的?值
                pstmt1.setInt(1, order.getId());
                pstmt1.setString(2, order.getMember().getId());
                pstmt1.setString(3, order.getOrderTime().toString());
                pstmt1.setString(4, order.getPaymentType().name());
                pstmt1.setInt(5, order.getPaymentType().getFee());
                pstmt1.setString(6, order.getShippingType().name());
                pstmt1.setInt(7, order.getShippingType().getFee());
                pstmt1.setString(8, order.getReceiverName());
                pstmt1.setString(9, order.getReceiverEmail());
                pstmt1.setString(10, order.getReceiverPhone());
                pstmt1.setString(11, order.getShippingAddr());

                //4. 執行指令1
                pstmt1.executeUpdate();

                //5.讀取auto increment的key值
                if (order.getId() <= 0) {
                    try (ResultSet rs = pstmt1.getGeneratedKeys();) {
                        while (rs.next()) {
                            order.setId(rs.getInt(1));
                        }
                    }
                }

                //將orderitem存入order_items table中
                if (order.getOrderItemSet() != null && order.getOrderItemSet().size() > 0) {
                    for (OrderItem item : order.getOrderItemSet()) {
                        //3.1 傳入指令2的?值
                        pstmt2.setInt(1, order.getId());
                        pstmt2.setInt(2, item.getProduct().getId());
                        pstmt2.setDouble(3, item.getPrice());
                        pstmt2.setInt(4, item.getQuantity());

                        //4. 執行指令2
                        pstmt2.executeUpdate();
                    }
                }
                connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
                throw ex;
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            throw new VGBException("新增訂單失敗", ex);
        }
    }

    private static final String SELECT_ORDERS_BY_CUSTOMER_ID = "SELECT id,customer_id,"
            + "DATE_FORMAT(order_time,'%Y-%m-%dT%H:%i:%s') as order_time,"
            + "payment_type,payment_fee,payment_note,"
            + "shipping_type,shipping_fee,shipping_note,status,SUM(price*quantity) as total_amount "
            + "FROM orders LEFT JOIN order_items ON orders.id = order_items.order_id "
            + "WHERE customer_id=? "
            + "GROUP BY orders.id ORDER BY order_time DESC";

    public List<Order> selectOrdersByCustomerId(String customerId) throws VGBException {
        List<Order> list = new ArrayList<>();
        try (Connection connection = RDBConnection.getConnection(); //2. 建立連線
                PreparedStatement pstmt = connection.prepareStatement(SELECT_ORDERS_BY_CUSTOMER_ID); //3. 準備指令
                ) {
            //3.1 傳入?的值
            pstmt.setString(1, customerId);

            //4.執行指令
            try (ResultSet rs = pstmt.executeQuery()) {
                //5. 處理ResultSet
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setOrderTime(LocalDateTime.parse(rs.getString("order_time")));

                    Customer c = new Customer();
                    c.setId(rs.getString("customer_id"));
                    order.setMember(c);

                    order.setPaymentType(PaymentType.valueOf(rs.getString("payment_type")));
                    order.setPaymentFee(rs.getInt("payment_fee"));
                    order.setPaymentNote(rs.getString("payment_note"));

                    order.setShippingType(ShippingType.valueOf(rs.getString("shipping_type")));
                    order.setShippingFee(rs.getInt("shipping_fee"));
                    order.setShippingNote(rs.getString("shipping_note"));

                    order.setTotalAmount(rs.getDouble("total_amount"));
                    order.setStatus(rs.getInt("status"));

                    list.add(order);
                }
            }

        } catch (SQLException ex) {
            System.out.println("查詢歷史訂單失敗:" + ex);
            throw new VGBException("查詢歷史訂單失敗!", ex);
        }
        return list;
    }

    private static final String SELECT_ORDER_BY_ID = "SELECT orders.id,customer_id,customers.name as cust_name,"
            + "DATE_FORMAT(order_time, '%Y-%m-%dT%H:%i:%s') as order_time,"
            + "payment_type,payment_fee,payment_note,shipping_type,shipping_fee,shipping_note,status,"
            + "receiver_name,receiver_email,receiver_phone,shipping_addr,"
            + "product_id, products.name as prod_name,photo_url, price,quantity "
            + "FROM orders LEFT JOIN order_items ON orders.id = order_items.order_id "
            + "JOIN customers ON orders.customer_id = customers.id "
            + "LEFT JOIN products ON order_items.product_id = products.id "
            + "WHERE orders.id=?";

    public Order selectOrderById(int id) throws VGBException {
        Order order = null;
        try (Connection connection = RDBConnection.getConnection(); //2. 建立連線
                PreparedStatement pstmt = connection.prepareStatement(SELECT_ORDER_BY_ID) //3. 準備指令
                ) {
            //3.1 傳入?的值
            pstmt.setInt(1, id);

            //4.執行指令
            try (ResultSet rs = pstmt.executeQuery()) {
                //5. 處理ResultSet
                while (rs.next()) {
                    if (order == null) {
                        order = new Order();
                        order.setId(rs.getInt("id"));

                        Customer c = new Customer();
                        c.setId(rs.getString("customer_id"));
                        c.setName(rs.getString("cust_name"));
                        order.setMember(c);

                        order.setOrderTime(LocalDateTime.parse(rs.getString("order_time")));
                        order.setPaymentType(PaymentType.valueOf(rs.getString("payment_type")));
                        order.setPaymentFee(rs.getInt("payment_fee"));
                        order.setPaymentNote(rs.getString("payment_note"));

                        order.setShippingType(ShippingType.valueOf(rs.getString("shipping_type")));
                        order.setShippingFee(rs.getInt("shipping_fee"));
                        order.setShippingNote(rs.getString("shipping_note"));

                        order.setReceiverName(rs.getString("receiver_name"));
                        order.setReceiverEmail(rs.getString("receiver_email"));
                        order.setReceiverPhone(rs.getString("receiver_phone"));
                        order.setShippingAddr(rs.getString("shipping_addr"));

                        order.setStatus(rs.getInt("status"));
                    }
                    OrderItem item = new OrderItem();
                    item.setPrice(rs.getDouble("price"));
                    item.setQuantity(rs.getInt("quantity"));
//                    item.setColor(rs.getString("color"));
                    item.setOrderId(order.getId());

                    Product p = new Product();
                    p.setId(rs.getInt("product_id"));
                    p.setName(rs.getString("prod_name"));
                    p.setPhotoUrl(rs.getString("photo_url"));
                    item.setProduct(p);

                    order.add(item);
                }

            }

        } catch (SQLException ex) {
            System.out.println("查詢訂單明細失敗:" + ex);
            throw new VGBException("查詢訂單明細失敗!", ex);
        }
        return order;
    }

    private static final String UPDATE_STATUS_TO_PAID = "UPDATE orders SET status=" + Status.PAID.ordinal()
            + ", payment_note=? WHERE id=? AND customer_id=?"
            + " AND status=" + Status.NEW.ordinal()
            + " AND payment_type='" + PaymentType.ATM.name() + "'";

    public void updateStatusToPaid(int orderId, String customerId, String paymentNote) throws VGBException{
        try (Connection connection = RDBConnection.getConnection(); //2. 建立連線
                PreparedStatement pstmt = connection.prepareStatement(UPDATE_STATUS_TO_PAID) //3. 準備指令
                ) {
            //3.1 傳入?的值
            pstmt.setString(1, paymentNote);
            pstmt.setInt(2, orderId);
            pstmt.setString(3, customerId);
            
            //4. 執行指令
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("通知付款失敗-" + ex);
            throw new VGBException("通知付款失敗!", ex);
        }
    }
}
