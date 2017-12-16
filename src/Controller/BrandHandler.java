package Controller;

import Model.Brand;
import Model.Stock;
import View.MainFrame;

import javax.swing.*;
import java.sql.SQLException;

public class BrandHandler {
    private MainFrame mainFrame;
    private Stock stock;
        public BrandHandler(MainFrame mainFrame, Stock stock){
            this.mainFrame = mainFrame;
            this.stock = stock;
        }

        public void addBrand(String brandName){
            stock.getBrandManager().addBrand(brandName);
            JOptionPane.showMessageDialog(mainFrame, "Brand Successfully added!");
        }
}
