package Model;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Date;
import java.util.*;

public class Stock {
    private DatabaseManager databaseManager;
    private BrandManager brandManager;
    private ArrayList<Product> products = new ArrayList<>();

    public Stock() {
        init();
        updateProducts();
    }

    public void init() {
        databaseManager = new DatabaseManager();
        brandManager = new BrandManager(this);
    }

    public DatabaseManager getDatabaseManager(){
        return databaseManager;
    }
    public ArrayList<Product> getProducts() {
        updateProducts();
        return products;
    }

    public Product getProductWithId(int id) {
        for (Product product : products) {
            if (id == product.getId())
                return product;
        }
        return null;
    }

    public void sellProduct(int productId, float sellPrice, java.util.Date sellDate) {
        java.sql.Date sd = new java.sql.Date(sellDate.getTime());
        String query = "UPDATE product SET is_sold= true, sell_price=" + sellPrice + ", sell_date='" + sd + "' where id=" + productId;
        databaseManager.executeUpdate(query);
        updateProducts();
    }

    public void addProduct(int productId, String name, Brand brand, float sellPrice, float purchasePrice,
                           java.util.Date purchaseDate, String bodySize, boolean isSold) {
        isSold = false;
        java.sql.Date pd = new java.sql.Date(purchaseDate.getTime());
        String query = "INSERT INTO product (id, name, brand_id, sell_price, purchase_price, body_size, is_sold, sell_date, purchase_date) VALUES"
                + " ( '" + productId + "','" + name + "','" + brand.getId() + "','" + sellPrice + "','"
                + purchasePrice + "','" + bodySize + "'," + isSold + ",'" + pd + "','" + pd + "')";
        databaseManager.executeUpdate(query);
        updateProducts();
    }

    public void refundProduct(int productId) {
        String query = "UPDATE product SET sell_price = 0, is_sold = false where id =" + productId;
        databaseManager.executeUpdate(query);
        updateProducts();
    }

    public void changeProduct(int refundedProductId, int soldProductId, float sellPrice, Date sellDate) {
        refundProduct(refundedProductId);
        sellProduct(soldProductId, sellPrice, sellDate);
        updateProducts();
    }

    public void updateProducts() {
        String query = "SELECT * FROM product";
        ResultSet rs = databaseManager.executeQuery(query);
        updateProductsFromResultSet(rs);
    }

    public void updateProductsFromResultSet(ResultSet rs) {
        // Get product information from databaseConnection
        ArrayList<Product> updatedProducts = new ArrayList<>();
        Product product = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Brand brand = brandManager.getBrandWithID(rs.getInt("brand_id"));
                String bodySize = rs.getString("body_size");
                float purchasePrice = rs.getFloat("purchase_price");
                java.sql.Date pd = rs.getDate("purchase_date");
                Date purchaseDate = new java.util.Date(pd.getTime());
                boolean isSold = rs.getBoolean("is_sold"); // TODO: will change
                float sellPrice = rs.getFloat("sell_price");
                java.sql.Date sd = rs.getDate("sell_date");
                Date sellDate = new java.util.Date(sd.getTime());
                product = new Product(id, name, brand, bodySize, purchasePrice, purchaseDate, isSold, sellPrice, sellDate);
                updatedProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        products = updatedProducts;
    }

    public BrandManager getBrandManager() {
        return brandManager;
    }
}



