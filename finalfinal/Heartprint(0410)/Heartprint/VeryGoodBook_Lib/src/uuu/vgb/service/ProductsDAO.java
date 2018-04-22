/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;

/**
 *
 * @author Administrator
 */
public class ProductsDAO {

    private static final String SELECT_ALL = "SELECT *FROM products";

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
                p.setDescription(rs.getString("description"));
                p.setPhotoUrl(rs.getString("photo_url"));
                p.setPhotoUrl2(rs.getString("photo_url2"));
                p.setPhotoUrl3(rs.getString("photo_url3"));
                p.setPhotoUrl4(rs.getString("photo_url4"));
                p.setStock(rs.getInt("stock"));
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
            = "SELECT products.id,products.name,unit_price,description,photo_url,photo_url2,photo_url3,photo_url4,style,type,stock,discount "
            + "FROM products "
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
                    p.setDescription(rs.getString("description"));
                    p.setPhotoUrl(rs.getString("photo_url"));
                    p.setPhotoUrl2(rs.getString("photo_url2"));
                    p.setPhotoUrl3(rs.getString("photo_url3"));
                    p.setPhotoUrl4(rs.getString("photo_url4"));
                    p.setStock(rs.getInt("stock"));
                    if (p instanceof Outlet) {
                        ((Outlet) p).setDiscount(rs.getInt("discount"));
                    }
                }
                return p;
            }
        } catch (SQLException ex) {
            throw new VGBException("查詢商品失敗: " + id, ex);
        }
    }
    private static final String SELECT_BY_NAME = "SELECT products.id,products.name,unit_price,description,photo_url,photo_url2,photo_url3,photo_url4,style,type,stock,discount "
            + "FROM products "
            + "WHERE products.name Like ?";

    public List<Product> selectProductByNameAndType(String name, String typeStr) throws VGBException {
        List<Product> list = new ArrayList<>();
        String sql = (typeStr == null || typeStr.length() == 0 ? SELECT_BY_NAME : SELECT_BY_NAME);
        try (
                Connection connection = RDBConnection.getConnection();//建立連線
                PreparedStatement pstmt = connection.prepareStatement(sql);//準備指令
                ) {
            //傳入?值
            pstmt.setString(1, '%' + name + '%');

            System.out.println("name = " + name);
            //4. 執行
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String className = Product.class.getName();
                    Product p = null;
                    try {
                        p = (Product) Class.forName(className).newInstance();
                    } catch (Exception ex) {
                        p = new Product();
                    }
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setUnitPrice(rs.getDouble("unit_price"));
                    p.setDescription(rs.getString("description"));
                    p.setPhotoUrl(rs.getString("photo_url"));

                    if (p instanceof Outlet) {
                        ((Outlet) p).setDiscount(rs.getInt("discount"));
                    }
                    list.add(p);
                }
                return list;
            }
        } catch (SQLException ex) {
            throw new VGBException("用名稱查詢商品失敗: " + name + "," + typeStr, ex);
        }

    }
    private static final String SELECT_BY_STYLE = "SELECT products.id,products.name,unit_price,description,photo_url,photo_url2,photo_url3,photo_url4,style,type,stock,discount "
            + "FROM products "
            + "WHERE products.style Like ?";

    public List<Product> selectProductByStyle(String style) throws VGBException {
        List<Product> list = new ArrayList<>();
        String sql = (style == null || style.length() == 0 ? SELECT_BY_STYLE : SELECT_BY_STYLE);
        try (
                Connection connection = RDBConnection.getConnection();//建立連線
                PreparedStatement pstmt = connection.prepareStatement(sql);//準備指令
                ) {
            //傳入?值
            pstmt.setString(1, '%' + style + '%');

            System.out.println("name = " + style);
            //4. 執行
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String className = Product.class.getName();
                    Product p = null;
                    try {
                        p = (Product) Class.forName(className).newInstance();
                    } catch (Exception ex) {
                        p = new Product();
                    }
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setUnitPrice(rs.getDouble("unit_price"));
                    p.setDescription(rs.getString("description"));
                    p.setPhotoUrl(rs.getString("photo_url"));

                    if (p instanceof Outlet) {
                        ((Outlet) p).setDiscount(rs.getInt("discount"));
                    }
                    list.add(p);
                }
                return list;
            }
        } catch (SQLException ex) {
            throw new VGBException("用名稱查詢商品失敗: " + style, ex);
        }
    }
    private static final String SELECT_BY_RND = "SELECT products.id,products.name,unit_price,photo_url,discount FROM products ORDER BY RAND() LIMIT 3";

    public List<Product> selectProductByRND() throws VGBException {
        List<Product> list = new ArrayList<>();
        try (
                //2. 建立連線
                Connection connection = RDBConnection.getConnection();
                //3.建立指令
                Statement stmt = connection.createStatement();
                //4.執行指令
                ResultSet rs = stmt.executeQuery(SELECT_BY_RND);) {
            //5.處理rs
            while (rs.next()) {
                Product p = null;
                String className = Product.class.getName();
                try {
                    p = (Product) Class.forName(className).newInstance();
                } catch (Exception ex) {
                    p = new Product();
                }
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setUnitPrice(rs.getDouble("unit_price"));
                p.setPhotoUrl(rs.getString("photo_url"));
                if (p instanceof Outlet) {
                    ((Outlet) p).setDiscount(rs.getInt("discount"));
                }
                list.add(p);
            }
        } catch (SQLException ex) {
            throw new VGBException("查詢隨機商品失敗", ex);
        }
        return list;
    }
    private static final String SELECT_STOCK_BY_ID = "SELECT id, products.stock FROM products WHERE id = ?";

    public int selectStockById(int id) throws VGBException {

        try (
                Connection connection = RDBConnection.getConnection(); //2. 建立連線
                PreparedStatement pstmt = connection.prepareStatement(SELECT_STOCK_BY_ID); //3.準備指令
                ) {
            //3.1 傳入?的值
            pstmt.setInt(1, id);
            int stock = 0;
            //4.執行指令
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    stock = rs.getInt("stock");
                }
                return stock;
            }
        } catch (SQLException ex) {
            throw new VGBException("查詢商品庫存失敗: " + id, ex);
        }

    }
    private static final String SELECT_PRICE_BY_ID = "SELECT id,name,unit_price,description,photo_url,photo_url2,photo_url3,photo_url4,style,type,stock,discount "
            + "FROM products WHERE unit_price between  500 and 1000 order by unit_price";

    public List<Product> selectPricetById() throws VGBException {
        List<Product> list = new ArrayList<>();
        try (
                //2. 建立連線
                Connection connection = RDBConnection.getConnection();
                //3.建立指令
                Statement stmt = connection.createStatement();
                //4.執行指令
                ResultSet rs = stmt.executeQuery(SELECT_PRICE_BY_ID);) {
            //5.處理rs
            while (rs.next()) {
                Product p = null;
                String className = Product.class.getName();
                try {
                    p = (Product) Class.forName(className).newInstance();
                } catch (Exception ex) {
                    p = new Product();
                }
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setUnitPrice(rs.getDouble("unit_price"));
                p.setDescription(rs.getString("description"));
                p.setPhotoUrl(rs.getString("photo_url"));
                p.setPhotoUrl2(rs.getString("photo_url2"));
                p.setPhotoUrl3(rs.getString("photo_url3"));
                p.setPhotoUrl4(rs.getString("photo_url4"));
                p.setStock(rs.getInt("stock"));
                if (p instanceof Outlet) {
                    ((Outlet) p).setDiscount(rs.getInt("discount"));
                }
                list.add(p);
            }
        } catch (SQLException ex) {
            throw new VGBException("查詢500到1000由低到高商品失敗", ex);
        }
        return list;
    }
    private static final String SELECT_PRICEE_BY_ID = "SELECT id,name,unit_price,description,photo_url,photo_url2,photo_url3,photo_url4,style,type,stock,discount FROM products WHERE unit_price <500 order by unit_price";

    public List<Product> selectPriceetById() throws VGBException {
        List<Product> list = new ArrayList<>();
        try (
                //2. 建立連線
                Connection connection = RDBConnection.getConnection();
                //3.建立指令
                Statement stmt = connection.createStatement();
                //4.執行指令
                ResultSet rs = stmt.executeQuery(SELECT_PRICEE_BY_ID);) {
            //5.處理rs
            while (rs.next()) {
                Product p = null;
                String className = Product.class.getName();
                try {
                    p = (Product) Class.forName(className).newInstance();
                } catch (Exception ex) {
                    p = new Product();
                }
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setUnitPrice(rs.getDouble("unit_price"));
                p.setDescription(rs.getString("description"));
                p.setPhotoUrl(rs.getString("photo_url"));
                p.setPhotoUrl2(rs.getString("photo_url2"));
                p.setPhotoUrl3(rs.getString("photo_url3"));
                p.setPhotoUrl4(rs.getString("photo_url4"));
                p.setStock(rs.getInt("stock"));
                if (p instanceof Outlet) {
                    ((Outlet) p).setDiscount(rs.getInt("discount"));
                }
                list.add(p);
            }
        } catch (SQLException ex) {
            throw new VGBException("查詢<500由低到高商品失敗", ex);
        }
        return list;
    }
    private static final String SELECT_PRICEEE_BY_ID = "SELECT id,name,unit_price,description,photo_url,photo_url2,photo_url3,photo_url4,style,type,stock,discount FROM products WHERE unit_price >1000 order by unit_price";

    public List<Product> selectPriceeetById() throws VGBException {
        List<Product> list = new ArrayList<>();
        try (
                //2. 建立連線
                Connection connection = RDBConnection.getConnection();
                //3.建立指令
                Statement stmt = connection.createStatement();
                //4.執行指令
                ResultSet rs = stmt.executeQuery(SELECT_PRICEEE_BY_ID);) {
            //5.處理rs
            while (rs.next()) {
                Product p = null;
                String className = Product.class.getName();
                try {
                    p = (Product) Class.forName(className).newInstance();
                } catch (Exception ex) {
                    p = new Product();
                }
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setUnitPrice(rs.getDouble("unit_price"));
                p.setDescription(rs.getString("description"));
                p.setPhotoUrl(rs.getString("photo_url"));
                p.setPhotoUrl2(rs.getString("photo_url2"));
                p.setPhotoUrl3(rs.getString("photo_url3"));
                p.setPhotoUrl4(rs.getString("photo_url4"));
                p.setStock(rs.getInt("stock"));
                if (p instanceof Outlet) {
                    ((Outlet) p).setDiscount(rs.getInt("discount"));
                }
                list.add(p);
            }
        } catch (SQLException ex) {
            throw new VGBException("查詢>1000由低到高商品失敗", ex);
        }
        return list;
    }
//    SELECT product_id, SUM(quantity) as cnt FROM order_items group by product_id order by cnt desc LIMIT 10;
    private static final String SELECT_PRODUCTID_BY_QUANTITY = "SELECT  id,name,unit_price,description,photo_url,photo_url2,photo_url3,photo_url4,style,type,stock,discount, product_id, SUM(quantity) as cnt FROM  order_items JOIN products on order_items.product_id = products.id  group by product_id order by cnt desc LIMIT 10 ;";

    public List<Product> selectProductIdbyQuantity() throws VGBException {
        List<Product> list = new ArrayList<>();
        try (
                //2. 建立連線
                Connection connection = RDBConnection.getConnection();
                //3.建立指令
                Statement stmt = connection.createStatement();
                //4.執行指令
                ResultSet rs = stmt.executeQuery(SELECT_PRODUCTID_BY_QUANTITY);) {
            //5.處理rs
            while (rs.next()) {
                Product p = null;
                String className = Product.class.getName();
                try {
                    p = (Product) Class.forName(className).newInstance();
                } catch (Exception ex) {
                    p = new Product();
                }
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setUnitPrice(rs.getDouble("unit_price"));
                p.setDescription(rs.getString("description"));
                p.setPhotoUrl(rs.getString("photo_url"));
                p.setPhotoUrl2(rs.getString("photo_url2"));
                p.setPhotoUrl3(rs.getString("photo_url3"));
                p.setPhotoUrl4(rs.getString("photo_url4"));
                p.setStock(rs.getInt("stock"));
                if (p instanceof Outlet) {
                    ((Outlet) p).setDiscount(rs.getInt("discount"));
                }
                list.add(p);
            }
        } catch (SQLException ex) {
            throw new VGBException("查詢熱門商品失敗", ex);
        }
        return list;
    }
}