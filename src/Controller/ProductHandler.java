package Controller;

import Model.Brand;
import Model.BrandManager;
import Model.Product;
import Model.Stock;
import View.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class ProductHandler {
    private MainFrame mainFrame;
    private Stock stock = new Stock();
    private BrandManager brandManager;

    public ProductHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.brandManager = stock.getBrandManager();
    }

    /*In addProduct function, ProductHandler firstly create the product
    it takes information GUI, then communicate with model
    * */

    public void addProduct(int productId, String name, String brandName, float sellPrice, float purchasePrice, Date purchaseDate, String bodySize) {
        Brand brand = brandManager.getBrandWithName(brandName);
        if (brand != null) {
            stock.addProduct(productId, name, brand, purchasePrice, sellPrice, purchaseDate, bodySize, false);
            JOptionPane.showMessageDialog(mainFrame, "Product Successfully added!");
        } else {
            JOptionPane.showMessageDialog(mainFrame, "This brand does not exist!");
        }
    }

    public void sellProduct(int productId, float sellPrice, Date sellDate) {
        Product product = stock.getProductWithId(productId);
        if (product != null) {
            if (product.isSold()) {
                JOptionPane.showMessageDialog(mainFrame, "This product is already sold!");
            } else {
                stock.sellProduct(productId, sellPrice, sellDate);
                JOptionPane.showMessageDialog(mainFrame, "This product is successfully sold!");
            }
        } else {
            JOptionPane.showMessageDialog(mainFrame, "This product does not exist!");
        }

    }


}

/* For Testing
System.out.println(stock.getProducts().size());
for(int i=0;i<stock.getProducts().size();i++){
    System.out.println(stock.getProducts().get(i).getId()+" "+stock.getProducts().get(i).getName()+" "+stock.getProducts().get(i).getBrand().getName()+" "+
            stock.getProducts().get(i).getPurchasePrice()+" "+stock.getProducts().get(i).getSellPrice()+" "+stock.getProducts().get(i).getBodySize()+" "+
            stock.getProducts().get(i).getPurchaseDate()+" "+stock.getProducts().get(i).isSold());
}
*/