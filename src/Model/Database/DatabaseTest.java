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
        System.out.println("Products");
        for(Product p : products)
            System.out.println(p.toString());
        // Print list of brands Test
        ArrayList<Brand> brands = stock.getBrandManager().getBrands();
        System.out.println("Brands");
        for(Brand b : brands)
            System.out.println(b.toString());
        // Print income&expenditure tests
        System.out.println("Income : " + stock.getIncomeBetween(new java.util.Date(117,11,15),new java.util.Date(117,11,17)));
        System.out.println("Expenditure : " + stock.getExpenditureBetween(new java.util.Date(117,11,15),new java.util.Date(117,11,17)));
        System.out.println("Profilt : " + stock.getProfitBetween(new java.util.Date(117,11,15),new java.util.Date(117,11,17)));
    }
}