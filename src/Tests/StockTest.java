package Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import Model.BrandManager;
import Model.Product;
import Model.Stock;
import Model.Database.DatabaseManager;
import Controller.ProductHandler;

public class StockTest {

	private Stock stock;
	private Date date = new Date();

	public StockTest() {
		stock = new Stock();
	}
	
	@Test
	public void getDatabaseManager() {
		DatabaseManager manager = stock.getDatabaseManager();
	}
	
	@Test
	public void getBrandManager() {
		BrandManager manager = stock.getBrandManager();
	}
	
	@Test
	public void getProducts() {
		ArrayList<Product> list = stock.getProducts();
	}

	@Test
	public void getProductWithID() {
		Product product = stock.getProductWithId(11);
		product.toString();
		}
	
	@Test
	public void getIncomeBetween() {
		float f = stock.getIncomeBetween(date, date);
		assertFalse(f==35);
	}
	
	@Test
	public void getExpenditureBetween() {
		float f = stock.getExpenditureBetween(date, date);
		assertFalse(f==25);
	}
	
}
