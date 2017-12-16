package View;

import Controller.ProductHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainFrame extends JFrame {

	//test
	private JPanel contentPane;
	private JTextField productCodeField;
	private JTextField productNameField;
	private JTextField brandNameField;
	private JTextField bodySizeField;
	private JTextField purchasePriceField;
	//	private JTextField salePriceField;
	private JTextField purchaseDateField;
	private JTextField productCodeField2;
	private JTextField salePriceField2;
	private JTextField saleDateField2;
	private JTextField brandNameField2;
	private JTextField productCodeField3;
	//	private JTextField SalePriceField3;
	private JTextField refundDateField;
	private JTextField startDateField;
	private JTextField EndDateField;
	private JTextField refundedProductCodeField;
	private JTextField soldProductCodeField;
	private JTextField salePriceField4;
	private JTextField saleDateField4;
	private ProductHandler productHandler = new ProductHandler(this);

	private JTabbedPane mainPanel;
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mainPanel = new JTabbedPane(JTabbedPane.TOP);
		mainPanel.setBounds(6, 6, 785, 328);
		contentPane.add(mainPanel);

		createAddProductPanel();
		createSellProductPanel();
		createAddBrandPanel();
		createChangeProductPanel();
		createRefundProductPanel();
		createShowIncomePanel();
		createProductListPanel();
	}

	private void createProductListPanel() {
		JPanel productListPanel = new JPanel();
		mainPanel.addTab("Show Products", null, productListPanel, null);
		productListPanel.setLayout(null);

		JButton btnShowList = new JButton("Show List");
		btnShowList.setBounds(102, 74, 106, 25);
		productListPanel.add(btnShowList);

		JButton btnSortList = new JButton("Sort List");
		btnSortList.setBounds(102, 131, 106, 25);
		productListPanel.add(btnSortList);
	}

	private void createShowIncomePanel() {
		JPanel showIncomeAndExpPanel = new JPanel();
		mainPanel.addTab("Income & Expenditure", null, showIncomeAndExpPanel, null);
		showIncomeAndExpPanel.setLayout(null);

		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(44, 34, 102, 15);
		showIncomeAndExpPanel.add(lblStartDate);

		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(44, 70, 102, 15);
		showIncomeAndExpPanel.add(lblEndDate);

		startDateField = new JTextField();
		startDateField.setBounds(164, 32, 114, 19);
		showIncomeAndExpPanel.add(startDateField);
		startDateField.setColumns(10);

		EndDateField = new JTextField();
		EndDateField.setBounds(164, 68, 114, 19);
		showIncomeAndExpPanel.add(EndDateField);
		EndDateField.setColumns(10);

		JButton btnList = new JButton("List");
		btnList.setBounds(164, 160, 106, 25);
		showIncomeAndExpPanel.add(btnList);
	}

	private void createRefundProductPanel() {
		JPanel refundProductPanel = new JPanel();
		mainPanel.addTab("RefundProduct", null, refundProductPanel, null);
		refundProductPanel.setLayout(null);

		JLabel lblProductCode3 = new JLabel("Product Code");
		lblProductCode3.setBounds(66, 67, 83, 15);
		refundProductPanel.add(lblProductCode3);

		//will change coordinates
		//will delete
//		JLabel lblSalePrice3 = new JLabel("Sale Price");
//		lblSalePrice3.setBounds(66, 94, 83, 15);
//		refundProductPanel.add(lblSalePrice3);

		JLabel lblRefundDate = new JLabel("Refund Date");
		lblRefundDate.setBounds(66, 121, 83, 15);
		refundProductPanel.add(lblRefundDate);

		productCodeField3 = new JTextField();
		productCodeField3.setBounds(182, 65, 114, 19);
		refundProductPanel.add(productCodeField3);
		productCodeField3.setColumns(10);

		//will change coordinates
		//will delete
//		SalePriceField3 = new JTextField();
//		SalePriceField3.setBounds(182, 93, 114, 17);
//		refundProductPanel.add(SalePriceField3);
//		SalePriceField3.setColumns(10);

		refundDateField = new JTextField();
		refundDateField.setBounds(182, 119, 114, 19);
		refundProductPanel.add(refundDateField);
		refundDateField.setColumns(10);

		JButton btnRefund = new JButton("Refund");
		btnRefund.setBounds(182, 155, 106, 25);
		refundProductPanel.add(btnRefund);
		btnRefund.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int productId = Integer.parseInt(productCodeField3.getText());
				int salePrice = 0;
				productHandler.refundProduct(productId,salePrice,refundDateField.getText());
			}
		});
	}

	private void createChangeProductPanel() {
		JPanel changeProductPanel = new JPanel();
		mainPanel.addTab("Change Product", null, changeProductPanel, null);
		changeProductPanel.setLayout(null);

		JLabel lblRefundedProductCode = new JLabel("Refunded Product Code");
		lblRefundedProductCode.setBounds(50, 55, 168, 15);
		changeProductPanel.add(lblRefundedProductCode);

		JLabel lblSoldProductCode = new JLabel("Sold Product Code");
		lblSoldProductCode.setBounds(50, 82, 168, 15);
		changeProductPanel.add(lblSoldProductCode);

		JLabel lblSalePrice4 = new JLabel("Sale Price");
		lblSalePrice4.setBounds(50, 109, 60, 15);
		changeProductPanel.add(lblSalePrice4);

		JLabel lblSaleDate = new JLabel("Sale Date");
		lblSaleDate.setBounds(50, 136, 145, 15);
		changeProductPanel.add(lblSaleDate);

		refundedProductCodeField = new JTextField();
		refundedProductCodeField.setBounds(236, 53, 114, 19);
		changeProductPanel.add(refundedProductCodeField);
		refundedProductCodeField.setColumns(10);

		soldProductCodeField = new JTextField();
		soldProductCodeField.setBounds(236, 80, 114, 19);
		changeProductPanel.add(soldProductCodeField);
		soldProductCodeField.setColumns(10);

		salePriceField4 = new JTextField();
		salePriceField4.setBounds(236, 107, 114, 19);
		changeProductPanel.add(salePriceField4);
		salePriceField4.setColumns(10);

		saleDateField4 = new JTextField();
		saleDateField4.setBounds(236, 134, 114, 19);
		changeProductPanel.add(saleDateField4);
		saleDateField4.setColumns(10);

		JButton changeProductButton = new JButton("Change");
		changeProductButton.setBounds(200,164,106,25);
		changeProductPanel.add(changeProductButton);
		changeProductButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int refundedId = Integer.parseInt(refundedProductCodeField.getText());
				int soldId = Integer.parseInt(soldProductCodeField.getText());
				int salePrice = Integer.parseInt(salePriceField4.getText());
				DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
				java.util.Date sellDate = null;
				try {
					sellDate = format.parse(saleDateField4.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				productHandler.changeProduct(refundedId,soldId,salePrice,sellDate);
			}
		});

	}

	private void createAddBrandPanel() {
		JPanel addBrandPanel = new JPanel();
		mainPanel.addTab("Add Brand", null, addBrandPanel, null);
		addBrandPanel.setLayout(null);

		JLabel lblBrandName2 = new JLabel("Brand Name");
		lblBrandName2.setBounds(73, 133, 93, 15);
		addBrandPanel.add(lblBrandName2);

		brandNameField2 = new JTextField();
		brandNameField2.setBounds(184, 131, 114, 19);
		addBrandPanel.add(brandNameField2);
		brandNameField2.setColumns(10);

		JButton btnAdd2 = new JButton("Add");
		btnAdd2.setBounds(184, 162, 106, 25);
		addBrandPanel.add(btnAdd2);
		btnAdd2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productHandler.getBrandHandler().addBrand(brandNameField2.getText());
			}
		});
	}

	private void createSellProductPanel() {
		JPanel sellProductPanel = new JPanel();
		mainPanel.addTab("Sell Product", null, sellProductPanel, null);
		sellProductPanel.setLayout(null);

		JLabel lblProductCode2 = new JLabel("Product Code");
		lblProductCode2.setBounds(53, 42, 101, 15);
		sellProductPanel.add(lblProductCode2);

		JLabel lblSalePrice2 = new JLabel("Sale Price");
		lblSalePrice2.setBounds(53, 69, 101, 15);
		sellProductPanel.add(lblSalePrice2);

		JLabel lblSaleDate2 = new JLabel("Sale Date");
		lblSaleDate2.setBounds(53, 96, 105, 15);
		sellProductPanel.add(lblSaleDate2);

		productCodeField2 = new JTextField();
		productCodeField2.setBounds(172, 40, 114, 19);
		sellProductPanel.add(productCodeField2);
		productCodeField2.setColumns(10);

		salePriceField2 = new JTextField();
		salePriceField2.setBounds(172, 67, 114, 19);
		sellProductPanel.add(salePriceField2);
		salePriceField2.setColumns(10);

		saleDateField2 = new JTextField();
		saleDateField2.setBounds(172, 94, 114, 19);
		sellProductPanel.add(saleDateField2);
		saleDateField2.setColumns(10);

		JButton btnSell = new JButton("Sell");
		btnSell.setBounds(172, 138, 106, 25);
		sellProductPanel.add(btnSell);
		btnSell.addActionListener(new ActionListener() {
			@Override

            /*
            * Sell Operation starts here
            * */
			public void actionPerformed(ActionEvent e) {
				int productId = Integer.parseInt(productCodeField2.getText());
				float salePrice = Float.parseFloat(salePriceField2.getText());
				DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
				java.util.Date sellDate;
				try {
					sellDate = format.parse(saleDateField2.getText());
					productHandler.sellProduct(productId,salePrice,sellDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	public void createAddProductPanel() {
		JPanel addProductPanel = new JPanel();
		mainPanel.addTab("Add Product", null, addProductPanel, null);
		addProductPanel.setLayout(null);

		JLabel lblProductCode = new JLabel("Product Code");
		lblProductCode.setBounds(43, 39, 121, 15);
		addProductPanel.add(lblProductCode);

		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(43, 64, 121, 15);
		addProductPanel.add(lblProductName);

		JLabel lblBrandName = new JLabel("Brand Name");
		lblBrandName.setBounds(43, 91, 121, 15);
		addProductPanel.add(lblBrandName);

		JLabel lblBodySize = new JLabel("Body Size");
		lblBodySize.setBounds(43, 118, 126, 15);
		addProductPanel.add(lblBodySize);

		JLabel lblPurchasePrice = new JLabel("Purchase Price");
		lblPurchasePrice.setBounds(43, 145, 121, 15);
		addProductPanel.add(lblPurchasePrice);

		//will change coordinates
		//will delete
//		JLabel lblSalePrice = new JLabel("Sale Price");
//		lblSalePrice.setBounds(43, 172, 121, 15);
//		addProductPanel.add(lblSalePrice);

		JLabel lblPurchaseDate = new JLabel("Purchase Date");
		lblPurchaseDate.setBounds(43, 199, 94, 15);
		addProductPanel.add(lblPurchaseDate);

		productCodeField = new JTextField();
		productCodeField.setBounds(176, 39, 114, 19);
		addProductPanel.add(productCodeField);
		productCodeField.setColumns(10);

		productNameField = new JTextField();
		productNameField.setBounds(176, 64, 114, 19);
		addProductPanel.add(productNameField);
		productNameField.setColumns(10);

		brandNameField = new JTextField();
		brandNameField.setBounds(176, 91, 114, 19);
		addProductPanel.add(brandNameField);
		brandNameField.setColumns(10);

		bodySizeField = new JTextField();
		bodySizeField.setBounds(176, 118, 114, 19);
		addProductPanel.add(bodySizeField);
		bodySizeField.setColumns(10);

		purchasePriceField = new JTextField();
		purchasePriceField.setBounds(176, 145, 114, 19);
		addProductPanel.add(purchasePriceField);
		purchasePriceField.setColumns(10);

		//will change coordinates
		//will delete
//		salePriceField = new JTextField();
//		salePriceField.setBounds(176, 172, 114, 19);
//		addProductPanel.add(salePriceField);
//		salePriceField.setColumns(10);

		purchaseDateField = new JTextField();
		purchaseDateField.setBounds(176, 199, 114, 19);
		addProductPanel.add(purchaseDateField);
		purchaseDateField.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(176, 230, 106, 25);
		addProductPanel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
            /*
            Add Operation starts here
            */

			public void actionPerformed(ActionEvent e){
				int productId = Integer.parseInt(productCodeField.getText());
				float purchasePrice = Float.parseFloat(purchasePriceField.getText());
				float sellPrice = 0;
				DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
				java.util.Date purchaseDate;
				try {
					purchaseDate = format.parse(purchaseDateField.getText());
					productHandler.addProduct(productId,productNameField.getText(),brandNameField.getText(),
							purchasePrice,sellPrice,purchaseDate,bodySizeField.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
	}

}
