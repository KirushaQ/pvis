package ppvis_1;

import java.awt.event.*;
import javax.swing.*;
/*import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;*/


@SuppressWarnings("serial")
public class All extends JFrame
{
	private JTextField text1;
	JButton button1, button2;
    public All()
    {
    	start();
    }
    public void start()
    {
    	this.setSize(1080,720);
    	this.setTitle("Lel");
    	this.getContentPane().setLayout(null);
    	text1=new JTextField();
    	text1.setBounds(50,30,200,35);
    	text1.setText("Input text");
    	this.add(text1);
    	
        button1=new JButton();
        button1.setText("Button 1");
        button1.setBounds(300,30,250,35);
        button1.addActionListener(new ListenerAction1());
       // button1.addChangeListener(new ListenerChange());
    	this.add(button1);
        
        button2=new JButton();
        button2.setText("Button 2");
        button2.setBounds(300,80,250,35);
        button2.addActionListener(new ListenerAction2());
    	this.add(button2);
    	
    }
    
    class ListenerAction1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	button1.setText(text1.getText());
        }
    }//при нажатии на кнопку
    
    class ListenerAction2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String s=button1.getText();
        	button1.setText(button2.getText());
        	button2.setText(s);
        }
    }
    
  /*  class ListenerChange implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            Object src = e.getSource();
            System.out.println("Cообщение о смене состояния объекта : " 
                                + src.getClass());
        }
    }*/ //При наведении на кнопку



	public static void main(String[] args) {
		All test = new All();
		test.setVisible(true);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
