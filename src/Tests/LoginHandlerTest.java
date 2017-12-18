package Tests;

import java.awt.event.ActionEvent;

import org.junit.Test;

import Controller.LoginHandler;
import Main.Main;
import View.LoginFrame;

public class LoginHandlerTest {
	
	private LoginHandler handler;
	private Main main = new Main();
    private LoginFrame frame = new LoginFrame(main);
    private ActionEvent e;
    
	public LoginHandlerTest() {
		handler = new LoginHandler(frame);
	}
	
	@Test
	public void createFrame() {
		handler.createMainFrame();
	}	
	
	@Test
	public void action() {
		handler.actionPerformed(e);
	}
	
}
