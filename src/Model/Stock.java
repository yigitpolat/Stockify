package Model;

import java.sql.*;
import java.util.ArrayList;

public class Stock {
    private Database database;
    private Connection connection;
    private BrandManager brandManager;
    private ArrayList<Product> products;

    public Stock() {
        init();
        updateProducts();
    }

    public void init(){
        brandManager = new BrandManager();
        database = new Database();
        database.connect();
        connection = database.getConnection();
    }

    public ArrayList<Product> getProducts() {
        updateProducts();
        return products;
    }

    public void sellProduct(Product product) {
        // TODO: sellProduct progress via database connection
        updateProducts();
    }

    public void addProduct(Product product) {
        // TODO: addProduct progress via database connection
        updateProducts();
    }

    public void refundProduct(Product product) {
        // TODO: refundProduct progress via database connection
        updateProducts();
    }

    public void changeProduct(Product product) {
        refundProduct(product);
        sellProduct(product);
    }

    public void updateProducts() {
        ArrayList<Product> updatedProducts = new ArrayList<>();
        String query = "SELECT * FROM product";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                // Get product information from database
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Brand brand = brandManager.getBrandWithID(rs.getInt("brand_id"));
                float sellPrice = rs.getFloat("sell_price");
                float purchasePrice = rs.getFloat("purchase_price");
                Date date = new Date(2017, 12, 3);
                String bodySize = rs.getString("body_size");
                boolean isSold = false; // TODO: will change

                // Add product to updated products
                updatedProducts.add(new Product(id, name, brand, sellPrice, purchasePrice, date, bodySize, isSold));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        products = updatedProducts;
    }
}
