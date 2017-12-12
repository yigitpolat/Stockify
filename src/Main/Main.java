package Main;

import View.LoginFrame;
import javax.swing.*;


public class Main {

    private static void createAndShowGUI(){
        Main m1 = new Main();
        LoginFrame loginFrame = new LoginFrame(m1);
        loginFrame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
