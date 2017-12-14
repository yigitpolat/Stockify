package Model;

import java.util.ArrayList;
import java.util.Date;

// This file was created for testing.
public class DatabaseTest {
    public static void main(String[] args){
        Stock stock = new Stock();
        stock.addProduct(1,"",new Brand(1,"asd"),12,12,new Date(),"asd",false);
        ArrayList<Product> products = stock.getProducts();
        for(Product p : products)
            System.out.println(p.toString());
    }
}
