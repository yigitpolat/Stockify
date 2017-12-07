import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField productCodeField;
	private JTextField brandNameField;
	private JTextField bodySizeField;
	private JTextField purchasePriceField;
	private JTextField salePriceField;
	private JTextField purchaseDateField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JTabbedPane mainPanel = new JTabbedPane(JTabbedPane.TOP);
		mainPanel.setBounds(6, 6, 785, 328);
		contentPane.add(mainPanel);
		
		JPanel addProductPanel = new JPanel();
		mainPanel.addTab("Add Product", null, addProductPanel, null);
		addProductPanel.setLayout(null);
		
		JLabel lblProductCode = new JLabel("Product Code");
		lblProductCode.setBounds(43, 39, 121, 15);
		addProductPanel.add(lblProductCode);
		
		JLabel lblBrandName = new JLabel("Brand Name");
		lblBrandName.setBounds(43, 64, 121, 15);
		addProductPanel.add(lblBrandName);
		
		JLabel lblBodySize = new JLabel("Body Size");
		lblBodySize.setBounds(43, 91, 126, 15);
		addProductPanel.add(lblBodySize);
		
		JLabel lblPurchasePrice = new JLabel("Purchase Price");
		lblPurchasePrice.setBounds(43, 118, 121, 15);
		addProductPanel.add(lblPurchasePrice);
		
		JLabel lblSalePrice = new JLabel("Sale Price");
		lblSalePrice.setBounds(43, 145, 121, 15);
		addProductPanel.add(lblSalePrice);
		
		JLabel lblPurchaseDate = new JLabel("Purchase Date");
		lblPurchaseDate.setBounds(43, 172, 94, 15);
		addProductPanel.add(lblPurchaseDate);
		
		productCodeField = new JTextField();
		productCodeField.setBounds(176, 37, 114, 19);
		addProductPanel.add(productCodeField);
		productCodeField.setColumns(10);
		
		brandNameField = new JTextField();
		brandNameField.setBounds(176, 62, 114, 19);
		addProductPanel.add(brandNameField);
		brandNameField.setColumns(10);
		
		bodySizeField = new JTextField();
		bodySizeField.setBounds(176, 89, 114, 19);
		addProductPanel.add(bodySizeField);
		bodySizeField.setColumns(10);
		
		purchasePriceField = new JTextField();
		purchasePriceField.setBounds(176, 116, 114, 19);
		addProductPanel.add(purchasePriceField);
		purchasePriceField.setColumns(10);
		
		salePriceField = new JTextField();
		salePriceField.setBounds(176, 143, 114, 19);
		addProductPanel.add(salePriceField);
		salePriceField.setColumns(10);
		
		purchaseDateField = new JTextField();
		purchaseDateField.setBounds(176, 170, 114, 19);
		addProductPanel.add(purchaseDateField);
		purchaseDateField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(176, 212, 106, 25);
		addProductPanel.add(btnAdd);
		
		JPanel sellProductPanel = new JPanel();
		mainPanel.addTab("Sell Product", null, sellProductPanel, null);
		
		JPanel changeProductPanel = new JPanel();
		mainPanel.addTab("Change Product", null, changeProductPanel, null);
		
		JPanel refundProductPanel = new JPanel();
		mainPanel.addTab("RefundProduct", null, refundProductPanel, null);
		
		JPanel addBrandPanel = new JPanel();
		mainPanel.addTab("Add Brand", null, addBrandPanel, null);
		
		JPanel showIncomeAndExpPanel = new JPanel();
		mainPanel.addTab("Income & Expenditure", null, showIncomeAndExpPanel, null);
		
		JPanel showProductsPanel = new JPanel();
		mainPanel.addTab("Show Products", null, showProductsPanel, null);
	}
}
