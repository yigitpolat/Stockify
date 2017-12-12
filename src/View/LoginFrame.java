package View;

import Main.*;
import Controller.LoginHandler;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

    private Main main;
	private JTextField usernameField;
	private JTextField passwordField;

	/**
	 * Create the LoginFrame.
     *
     */
	public LoginFrame(Main main) {
	    this.main = main;
	    initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(97, 97, 93, 16);
		this.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(97, 136, 66, 16);
		this.getContentPane().add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(202, 92, 130, 26);
		this.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(202, 131, 130, 26);
		this.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginHandler(this));
		btnLogin.setBounds(202, 169, 117, 29);
		this.getContentPane().add(btnLogin);
	}

	public JTextField getUsernameField(){
	    return usernameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }
}
