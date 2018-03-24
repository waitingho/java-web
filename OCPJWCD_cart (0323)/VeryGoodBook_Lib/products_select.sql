SELECT products.id,products.name,unit_price,stock,description,photo_url,type,discount,
       authors,publish_date,publisher_id,language,isbn,publishers.name as pub_name
 FROM products
    LEFT JOIN book_details ON products.id = book_details.product_id
    LEFT JOIN publishers ON book_details.publisher_id = publishers.id
    WHERE products.id = 1;


SELECT * FROM book_details 
        RIGHT JOIN publishers ON book_details.publisher_id = publishers.id;

SELECT products.id,products.name,unit_price,stock,description,photo_url,type,discount 
    FROM products WHERE name LIKE '%色鉛筆%' AND type = 'Product';

SELECT distinct type FROM products;
