package Controller;

import View.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler implements ActionListener{

    /*LoginHandler have a unique id and password which is not connected to database*/
    String id="admin";
    String password="admin";
    LoginFrame frame;


    /*Just for indicate to take 2 string as arguments*/
    public LoginHandler(LoginFrame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(id.equals(frame.getUsernameField().getText()) && password.equals(frame.getPasswordField().getText())){
            JOptionPane.showMessageDialog(frame, "You are successful");
            createMainFrame();
        }
        else{
            JOptionPane.showMessageDialog(frame,"Invalid Id & Password");
        }
    }

    /*User successfully entered the Main.main frame, login frame is closed
					* and new mainFrame is set to visible*/
    public void createMainFrame(){
        frame.setVisible(false);
        MainFrame mainframe = new MainFrame();
        mainframe.setVisible(true);
    }
}
