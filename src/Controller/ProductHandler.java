package Controller;

import Model.Brand;
import Model.Product;
import Model.Stock;
import View.MainFrame;

import javax.swing.*;
import java.util.Date;

public class ProductHandler {
    private MainFrame mainFrame;
    private Stock stock = new Stock();

    public ProductHandler(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    /*In addProduct function, ProductHandler firstly create the product
    it takes information GUI, then communicate with model
    * */

    public void addProduct(int productId, String name, String brandName, float sellPrice, float purchasePrice, Date purchaseDate, String bodySize){
        boolean isBrandFound = false;
        Brand brand = null;
        for(int i=0;i<stock.getBrandManager().getBrands().size();i++){
            if(brandName.equals(stock.getBrandManager().getBrands().get(i).getName()) ){
                isBrandFound = true;
                brand = stock.getBrandManager().getBrands().get(i);
                break;
            }
        }
        if(isBrandFound){
            Product product = new Product(productId,name,brand,purchasePrice,sellPrice,purchaseDate,bodySize,false);
            stock.addProduct(product);
            /*For Testing
            System.out.println(stock.getProducts().size());
            for(int i=0;i<stock.getProducts().size();i++){
                System.out.println(stock.getProducts().get(i).getId()+" "+stock.getProducts().get(i).getName()+" "+stock.getProducts().get(i).getBrand().getName()+" "+
                        stock.getProducts().get(i).getPurchasePrice()+" "+stock.getProducts().get(i).getSellPrice()+" "+stock.getProducts().get(i).getBodySize()+" "+
                        stock.getProducts().get(i).getPurchaseDate()+" "+stock.getProducts().get(i).isSold());
            }
            */
            JOptionPane.showMessageDialog(mainFrame,"Product Successfully added!");
        }
        else{
            JOptionPane.showMessageDialog(mainFrame,"This brand does not exist!");
        }

    }

    public void sellProduct(int productId, float sellPrice, Date sellDate){
        boolean isProductFound = false;
        Product product = null;
        for(int i=0;i<stock.getProducts().size();i++){
            if(productId == stock.getProducts().get(i).getId()){
                isProductFound = true;
                product = stock.getProducts().get(i);
                break;
            }
        }
        if(isProductFound){
            if(product.isSold()){
                JOptionPane.showMessageDialog(mainFrame,"This product is already sold!");
            }
            else{
                product.setSold(true);product.setSellPrice(sellPrice);product.setPurchaseDate(sellDate);
                JOptionPane.showMessageDialog(mainFrame,"This product is successfully sold!");
            }
        }
        else { JOptionPane.showMessageDialog(mainFrame,"This product does not exist!");}

    }


}
