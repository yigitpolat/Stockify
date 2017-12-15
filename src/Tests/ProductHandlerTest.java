package Tests;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import Controller.*;
import Model.*;
import View.*;

public class ProductHandlerTest {

	private MainFrame mainFrame;
	private BrandManager manager = new BrandManager();
	private Date date = new Date();
	private ProductHandler handler;

	public ProductHandlerTest() {
		handler = new ProductHandler(mainFrame);
	}

	@Test
	public void addNewProductWrongBrand() {
		handler.addProduct(9, "product1", "brand3", 35.5f, 25.5f, date, "M");
	}

	@Test
	public void addNewProduct() {
		handler.addProduct(6, "product1", "brand", 35.5f, 25.5f, date, "M");
	}
	
	//BOOM
	@Test
	public void addExistProduct() {
		handler.addProduct(3, "product1", "brand", 35.5f, 25.5f, date, "M");
	}


	@Test
	public void sellProductSold() {
		handler.sellProduct(4, 35.5f, date);
	}
	
	@Test
	public void sellProductExist() {
		handler.addProduct(4, "product1", "brand", 35.5f, 25.5f, date, "M");
		handler.sellProduct(4, 35.5f, date);
	}

	@Test
	public void sellProductNotExist() {
		handler.sellProduct(5, 35.5f, date);
	}
	
	@Test
	public void refundProductNotSold() {
		handler.addProduct(7, "product1", "brand", 35.5f, 25.5f, date, "M");
		handler.refundProduct(7, 55, date.toString());
	}
	
	@Test
	public void refundProductSold() {
		handler.addProduct(8, "product1", "brand", 35.5f, 25.5f, date, "M");
		handler.refundProduct(7, 55, date.toString());
	}
}
