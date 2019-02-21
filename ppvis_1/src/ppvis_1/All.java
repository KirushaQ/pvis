package ppvis_1;
import java.awt.*;
import javax.swing.*;


public class All extends JFrame
{
    public All()
    {
    	this.setSize(1080,720);
    	this.setTitle("Lel");
    	this.getContentPane().setLayout(null);
    	this.add(getTextField());
    	
    }
    
    private javax.swing.JTextField getTextField()
    {
    	JTextField text=new JTextField();
    	text.setBounds(30, 30, 150, 35);
    	text.setText("Input text");
    	return text;
    }
}
