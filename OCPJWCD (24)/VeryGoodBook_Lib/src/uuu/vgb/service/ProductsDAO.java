/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.service;

import java.util.ArrayList;
import java.util.List;
import uuu.vgb.entity.Product;
import java.sql.*;
import java.time.LocalDate;
import uuu.vgb.entity.Book;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Publisher;
import uuu.vgb.entity.VGBException;

/**
 *
 * @author Patty Tai
 */
public class ProductsDAO {

    private static final String SELECT_ALL = "SELECT * FROM products";

    public List<Product> selectAllProducts() throws VGBException {
        List<Product> list = new ArrayList<>();
        try (
                //2. 建立連線
                Connection connection = RDBConnection.getConnection();
                //3.建立指令
                Statement stmt = connection.createStatement();
                //4.執行指令
                ResultSet rs = stmt.executeQuery(SELECT_ALL);) {
            //5.處理rs
            while (rs.next()) {
                String type = rs.getString("type");
                Product p = null;
                String className = Product.class.getName();
//                System.out.println("className = " + className);
                if (type != null) {
                    className = className.replaceAll("Product", type);
                }
                try {
                    p = (Product) Class.forName(className).newInstance();
                } catch (Exception ex) {
                    p = new Product();
                }
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setUnitPrice(rs.getDouble("unit_price"));
                p.setStock(rs.getInt("stock"));
                p.setDescription(rs.getString("description"));
                p.setPhotoUrl(rs.getString("photo_url"));
                if (p instanceof Outlet) {
                    ((Outlet) p).setDiscount(rs.getInt("discount"));
                }
                list.add(p);
            }
        } catch (SQLException ex) {
            throw new VGBException("查詢全部商品失敗", ex);
        }

        return list;
    }

    private static final String SELECT_BY_ID
            = "SELECT products.id,products.name,unit_price,stock,description,photo_url,type,discount," 
                + "authors,publish_date,publisher_id,language,isbn,publishers.name as pub_name " 
                + "FROM products " 
                + "LEFT JOIN book_details ON products.id = book_details.product_id " 
                + "LEFT JOIN publishers ON book_details.publisher_id = publishers.id " 
                + "WHERE products.id = ?";

    public Product selectProductById(int id) throws VGBException {
        try (
                Connection connection = RDBConnection.getConnection(); //2. 建立連線
                PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID); //3.準備指令
                ) {
            //3.1 傳入?的值
            pstmt.setInt(1, id);

            //4. 執行
            try (ResultSet rs = pstmt.executeQuery()) {
                Product p = null;
                while (rs.next()) {
                    String type = rs.getString("type");                    
                    String className = Product.class.getName();
                    if (type != null) className = className.replaceAll("Product", type);
                    
                    try {
                        p = (Product) Class.forName(className).newInstance();
                    } catch (Exception ex) {
                        p = new Product();
                    }
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setUnitPrice(rs.getDouble("unit_price"));
                    p.setStock(rs.getInt("stock"));
                    p.setDescription(rs.getString("description"));
                    p.setPhotoUrl(rs.getString("photo_url"));
                    if (p instanceof Outlet) ((Outlet) p).setDiscount(rs.getInt("discount"));                    
                    if (p instanceof Book){//authors,publish_date,publisher_id,language,isbn
                        String authors = rs.getString("authors");
                        if(authors!=null){
                            String[] authorArray = authors.split(",");
                            ((Book)p).setAuthors(authorArray);
                        }
                        
                        ((Book)p).setPublishDate(LocalDate.parse(rs.getString("publish_date"))); //yyyy-MM-dd
                        
                        Publisher publisher = new Publisher();
                        publisher.setId(rs.getInt("publisher_id"));
                        publisher.setName(rs.getString("pub_name"));
                        ((Book)p).setPublisher(publisher);
                        
                        ((Book)p).setLanguage(rs.getString("language"));
                        ((Book)p).setIsbn(rs.getString("isbn"));
                    }                   
                    
                }
                return p;
            }
        } catch (SQLException ex) {
            throw new VGBException("查詢商品失敗: " + id, ex);
        }
    }
    
    private static final String SELECT_BY_NAME
            = "SELECT products.id,products.name,unit_price,stock,description,photo_url,type,discount," 
                + "authors,publish_date,publisher_id,language,isbn,publishers.name as pub_name " 
                + "FROM products " 
                + "LEFT JOIN book_details ON products.id = book_details.product_id " 
                + "LEFT JOIN publishers ON book_details.publisher_id = publishers.id " 
                + "WHERE products.name LIKE ?";

    public List<Product> selectProductByNameAndType(String name, String typeStr) throws VGBException {
        List<Product> list = new ArrayList<>();
        String sql = (typeStr==null || typeStr.length()==0?SELECT_BY_NAME:SELECT_BY_NAME+ " AND type=?");
        try (
                Connection connection = RDBConnection.getConnection(); //2. 建立連線
                PreparedStatement pstmt = connection.prepareStatement(sql); //3.準備指令
                ) {
            //3.1 傳入?的值
            pstmt.setString(1, '%'+name+'%');
            if(typeStr!=null && typeStr.length()>0){
                pstmt.setString(2, typeStr);
            }
            
            System.out.println("name = " + name);
            System.out.println("typeStr = " + typeStr);
            //4. 執行
            try (ResultSet rs = pstmt.executeQuery()) {                
                while (rs.next()) {
                    String type = rs.getString("type");                    
                    String className = Product.class.getName();
                    if (type != null) className = className.replaceAll("Product", type);
                    Product p = null;
                    try {
                        p = (Product) Class.forName(className).newInstance();
                    } catch (Exception ex) {
                        p = new Product();
                    }
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setUnitPrice(rs.getDouble("unit_price"));
                    p.setStock(rs.getInt("stock"));
                    p.setDescription(rs.getString("description"));
                    p.setPhotoUrl(rs.getString("photo_url"));
                    if (p instanceof Outlet) ((Outlet) p).setDiscount(rs.getInt("discount"));                    
                    if (p instanceof Book){//authors,publish_date,publisher_id,language,isbn
                        String authors = rs.getString("authors");
                        if(authors!=null){
                            String[] authorArray = authors.split(",");
                            ((Book)p).setAuthors(authorArray);
                        }
                        
                        ((Book)p).setPublishDate(LocalDate.parse(rs.getString("publish_date"))); //yyyy-MM-dd
                        
                        Publisher publisher = new Publisher();
                        publisher.setId(rs.getInt("publisher_id"));
                        publisher.setName(rs.getString("pub_name"));
                        ((Book)p).setPublisher(publisher);
                        
                        ((Book)p).setLanguage(rs.getString("language"));
                        ((Book)p).setIsbn(rs.getString("isbn"));
                    }                   
                    list.add(p);
                }
                return list;
            }
        } catch (SQLException ex) {
            throw new VGBException("用名稱查詢商品失敗: " + name + "," + typeStr, ex);
        }
    }    
}
