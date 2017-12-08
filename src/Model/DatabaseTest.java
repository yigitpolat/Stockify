package Model;

import java.util.ArrayList;

// This file was created for testing.
public class DatabaseTest {
    public static void main(String[] args){
        Stock stock = new Stock();
        ArrayList<Product> products = stock.getProducts();
        for(Product p : products)
            System.out.println(p.toString());
    }
}
