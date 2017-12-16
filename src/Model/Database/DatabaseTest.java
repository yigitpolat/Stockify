package Model.Database;

import Model.Brand;
import Model.Product;
import Model.Stock;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

// This file was created for testing.
public class DatabaseTest {
    public static void main(String[] args) throws SQLException {
        Stock stock = new Stock();
        // Add Brand Test
        // stock.getBrandManager().addBrand("test");
        //
        // Add Product Test
        // stock.addProduct(7312227,"XD",new Brand(1,"asd"),12,12,new Date(2016,12,12),"asd",false);
        //
        // Print list of products Test
        ArrayList<Product> products = stock.getProducts();
        for(Product p : products)
            System.out.println(p.toString());
    }
}