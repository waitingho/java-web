INSERT INTO orders 
(id,customer_id,order_time,payment_type,payment_fee,shipping_type,shipping_fee,receiver_name,receiver_email,receiver_phone,shipping_addr,status)
VALUES(?,?,?,?,?,?,?,?,?,?,?,0);

INSERT INTO order_items (order_id,product_id,price,quantity) VALUES (?,?,?,?);
