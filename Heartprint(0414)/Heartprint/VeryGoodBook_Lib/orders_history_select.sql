
SELECT NOW(), DATE_FORMAT(NOW(), '%Y-%m-%dT%H:%i:%s.%x');

SELECT id,customer_id,DATE_FORMAT(order_time, '%Y-%m-%dT%H:%i:%s') as order_time,payment_type,payment_fee,payment_note,
                 shipping_type,shipping_fee,shipping_note,status,SUM(price*quantity) as total_amount
FROM orders JOIN order_items ON orders.id = order_items.order_id
WHERE customer_id="A123123123" 
GROUP BY orders.id 
ORDER BY order_time DESC;


SELECT orders.id,customer_id,customers.name as cust_name,DATE_FORMAT(order_time, '%Y-%m-%dT%H:%i:%s') as order_time,
        payment_type,payment_fee,payment_note,shipping_type,shipping_fee,shipping_note,status,
        product_id, products.name as prod_name,photo_url, price,quantity
    FROM orders JOIN order_items ON orders.id = order_items.order_id
                JOIN customers ON orders.customer_id = customers.id
                JOIN products ON order_items.product_id = products.id
WHERE orders.id=4;