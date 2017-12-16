package Tests;

import java.util.Date;

import org.junit.Test;

import Controller.*;
import View.*;

public class ProductHandlerTest {

	private MainFrame mainFrame;
	private Date date = new Date();
	private ProductHandler handler;

	public ProductHandlerTest() {
		handler = new ProductHandler(mainFrame);
//		handler.delete(3);
//		handler.delete(4);
//		handler.delete(6);
//		handler.delete(7);
//		handler.delete(8);
//		handler.delete(5);
//		handler.delete(9);

	}
	@Test
	public void getBrandHandler() {
		BrandHandler brandH = handler.getBrandHandler();
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
		handler.refundProduct(8, 35, date.toString());
	}
	
	@Test
	public void getIncome() {
		float f = handler.getIncome(date, date);
	}
	
	@Test
	public void getExpenditure() {
		float f = handler.getExpenditure(date, date);
	}
	
	@Test
	public void getProfitBetween() {
		float f = handler.getProfitBetween(date, date);
	}
	
	@Test
	public void changeProduct() {
		handler.changeProduct(6, 6, 35, date);
	}
}
