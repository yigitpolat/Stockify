package Model;

import java.sql.*;
import java.util.Date;
import java.util.*;

public class Stock {
    private Database database;
    private Connection connection;
    private BrandManager brandManager;
    private ArrayList<Product> products = new ArrayList<>();

    public Stock() {
        init();
        updateProducts();
    }

    public void init() {
        brandManager = new BrandManager();
        database = new Database();
        database.connect();
        connection = database.getConnection();
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

    public void sellProduct(int productId, float sellPrice, Date sellDate) {
        // TODO: sellProduct progress via database connection
        updateProducts();
    }

    public void addProduct(int productId, String name, Brand brand, float sellPrice, float purchasePrice, java.util.Date purchaseDate, String bodySize, boolean isSold) {
        // TODO: addProduct progress via database connection
        isSold = false;
        try {
            // This is for testing
            java.sql.Date pd = new java.sql.Date(purchaseDate.getTime());
            String query = "INSERT INTO product (id, name, brand_id, sell_price, purchase_price, body_size, is_sold, sell_date, purchase_date) VALUES" +
                    " ( '"+ productId +"','"+name+"','"+brand.getId()+"','"+sellPrice+"','"+purchasePrice+"','"+bodySize+"',"+isSold+",'"+pd+"','"+pd+"')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updateProducts();
    }

    public void refundProduct(int productId) {
        // TODO: refundProduct progress via database connection
        updateProducts();
    }

    public void changeProduct(int refundedProductId, int soldProductId, float sellPrice, Date sellDate) {
        refundProduct(refundedProductId);
        sellProduct(soldProductId, sellPrice, sellDate);
    }

    public void updateProducts() {
        ArrayList<Product> updatedProducts = new ArrayList<>();
        String query = "SELECT * FROM product";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                updatedProducts.add(getProductFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        products = updatedProducts;
    }

    public Product getProductFromResultSet(ResultSet rs) {
        // Get product information from database
        Product product = null;
        try {
            int id              = rs.getInt("id");
            String name         = rs.getString("name");
            Brand brand         = brandManager.getBrandWithID(rs.getInt("brand_id"));
            String bodySize     = rs.getString("body_size");
            float purchasePrice = rs.getFloat("purchase_price");
            java.sql.Date pd    = rs.getDate("purchase_date");
            Date purchaseDate   =  new java.util.Date(pd.getTime());
            boolean isSold      = rs.getBoolean("is_sold"); // TODO: will change
            float sellPrice     = rs.getFloat("sell_price");
            java.sql.Date sd    = rs.getDate("sell_date");
            Date sellDate       = new java.util.Date(sd.getTime());

            product = new Product(id, name, brand, bodySize, purchasePrice, purchaseDate, isSold, sellPrice, sellDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public BrandManager getBrandManager() {
        return brandManager;
    }
}
