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
import java.util.List;
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
            = "SELECT products.id,products.name,unit_price,description,photo_url,photo_url2,photo_url3,photo_url4,type,discount,"
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
}
