import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {

	private JPanel contentPane;

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
