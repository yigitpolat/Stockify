package Tests;


import org.junit.Test;

import View.MainFrame;
import Controller.*;
import Model.*;

public class BrandHandlerTest {

    private MainFrame mainFrame;
    private BrandHandler handler;
    private Stock stock = new Stock();

    public BrandHandlerTest() {
        handler = new BrandHandler(mainFrame, stock);
    }

    @Test
    public void addBrandExist() {
        handler.addBrand("brand");
    }

    @Test
    public void addBrandNotExist() {
        handler.addBrand("brand2");
    }
}