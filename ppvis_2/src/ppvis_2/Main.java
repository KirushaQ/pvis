package ppvis_2;

import java.awt.event.*;
import javax.swing.*;

public class Main {

	JFrame frame;
	
	 public Main()
	    {
	    	start();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	    public void start()
	    {
	    	frame = new JFrame();
	    	frame.setSize(1080,900);
	    	frame.setTitle("Lel");
	    	frame.getContentPane().setLayout(null);
	    }
	
	public static void main(String[] args) {
        Main start = new Main();

	}

}
