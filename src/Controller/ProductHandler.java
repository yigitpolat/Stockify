package Controller;

import Model.Brand;
import Model.BrandManager;
import Model.Product;
import Model.Stock;
import View.MainFrame;

import javax.swing.*;
import java.util.Date;

public class ProductHandler {
    private MainFrame mainFrame;
    private Stock stock;
    private BrandManager brandManager;
    private BrandHandler brandHandler;

    public ProductHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.stock= new Stock();
        this.brandManager = stock.getBrandManager();
        this.brandHandler = new BrandHandler(mainFrame,stock);
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

    public void refundProduct(int productId, int salePriceField3Text, String refundDateFieldText){
        Product product = stock.getProductWithId(productId);
        if(product != null){
            if(!product.isSold()){
                JOptionPane.showMessageDialog(mainFrame, "This product is not sold!");
            }
            else{
                stock.refundProduct(productId);
                JOptionPane.showMessageDialog(mainFrame, "This product refunded successfully!");
            }
        }
        else{
            JOptionPane.showMessageDialog(mainFrame,"This product does not exist!");
        }
    }

    public BrandHandler getBrandHandler(){
        return brandHandler;
    }

    public void changeProduct(int refundedId, int soldId, int salePrice, Date sellDate) {
        stock.changeProduct(refundedId,soldId,salePrice,sellDate);
    }
}
