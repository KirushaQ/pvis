package ppvis_2;

import java.awt.event.*;
import javax.swing.*;

public class Main {

	JFrame frame;
	JTextField textSeeker;
	ButtonGroup group;
	JRadioButton rButton1;
	JRadioButton rButton2;
    JRadioButton rButton3;
    JRadioButton rButton4;
    JRadioButton rButton5;
    JButton buttonSeeker;
    
	JTextField textDeleter;
	ButtonGroup group2;
	JRadioButton rdButton1;
	JRadioButton rdButton2;
    JRadioButton rdButton3;
    JRadioButton rdButton4;
    JRadioButton rdButton5;
    JButton buttonDeleter;
    
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
        
        textSeeker = new JTextField();
        textSeeker.setBounds(50,20,200,20);
        frame.add(textSeeker);
        
        rButton1 = new JRadioButton("1",true);
     	rButton2 = new JRadioButton("2");
     	rButton3 = new JRadioButton("3");
     	rButton4 = new JRadioButton("4");
     	rButton5 = new JRadioButton("5");
     	group = new ButtonGroup();
     	rButton1.setBounds(50,50,40,40);
     	rButton2.setBounds(100,50,40,40);
     	rButton3.setBounds(150,50,40,40);
     	rButton4.setBounds(200,50,40,40);
     	rButton5.setBounds(250,50,40,40);
     	group.add(rButton1);
     	group.add(rButton2);
     	group.add(rButton3);
     	group.add(rButton4);
     	group.add(rButton5);
     	frame.add(rButton1);
     	frame.add(rButton2);
        frame.add(rButton3);
        frame.add(rButton4);
        frame.add(rButton5);
        
        buttonSeeker = new JButton();
        buttonSeeker.setText("Press to seek");
        buttonSeeker.setBounds(50,100,200,50);
        frame.add(buttonSeeker);
        
        textDeleter = new JTextField();
        textDeleter.setBounds(450,20,200,20);
        frame.add(textDeleter);
        
        rdButton1 = new JRadioButton("1",true);
     	rdButton2 = new JRadioButton("2");
     	rdButton3 = new JRadioButton("3");
     	rdButton4 = new JRadioButton("4");
     	rdButton5 = new JRadioButton("5");
     	group2 = new ButtonGroup();
     	rdButton1.setBounds(450,50,40,40);
     	rdButton2.setBounds(500,50,40,40);
     	rdButton3.setBounds(550,50,40,40);
     	rdButton4.setBounds(600,50,40,40);
     	rdButton5.setBounds(650,50,40,40);
     	group2.add(rdButton1);
     	group2.add(rdButton2);
     	group2.add(rdButton3);
     	group2.add(rdButton4);
     	group2.add(rdButton5);
     	frame.add(rdButton1);
     	frame.add(rdButton2);
        frame.add(rdButton3);
        frame.add(rdButton4);
        frame.add(rdButton5);
        
        buttonDeleter = new JButton();
        buttonDeleter.setText("Press delete");
        buttonDeleter.setBounds(450,100,200,50);
        frame.add(buttonDeleter);
	}
	
	public static void main(String[] args) {
		Main start = new Main();
    }
}
