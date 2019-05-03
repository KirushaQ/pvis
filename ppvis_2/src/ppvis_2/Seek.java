package ppvis_2;
import javax.swing.*;

import ppvis_2.Main.ButtonSeekerListener;

public class Seek extends JFrame {
	ButtonGroup group;
	JRadioButton rButton1;
	JRadioButton rButton2;
    JRadioButton rButton3;
    JRadioButton rButton4;
    JRadioButton rButton5;
    JTextField textSeeker;
    JTextField textSeeker2;
    JTextField textSeeker3;
    JButton buttonSeekStart;
    JComboBox seekBox;
    
    public Seek()
    {
        this.setSize(500,500);
        this.setTitle("Seek");
        this.getContentPane().setLayout(null);
        rButton1 = new JRadioButton("По турниру",true);
     	rButton2 = new JRadioButton("По дате");
     	rButton3 = new JRadioButton("По виду спорта");
     	rButton4 = new JRadioButton("По Фио");
     	rButton5 = new JRadioButton("По призовым");
     	group = new ButtonGroup();
     	rButton1.setBounds(20,10,200,40);
     	rButton2.setBounds(20,80,200,40);
     	rButton3.setBounds(20,150,200,40);
     	rButton4.setBounds(20,220,200,40);
     	rButton5.setBounds(20,290,200,40);
     	group.add(rButton1);
     	group.add(rButton2);
     	group.add(rButton3);
     	group.add(rButton4);
     	group.add(rButton5);
     	this.add(rButton1);
     	this.add(rButton2);
     	this.add(rButton3);
     	this.add(rButton4);
     	this.add(rButton5);
        
        textSeeker = new JTextField();
        textSeeker.setBounds(250,50,200,30);
        this.add(textSeeker);
        
        textSeeker2 = new JTextField();
        textSeeker2.setBounds(250,100,200,30);
        this.add(textSeeker2);
        
        textSeeker3 = new JTextField();
        textSeeker3.setBounds(250,150,200,30);
        this.add(textSeeker3);
        
        buttonSeekStart = new JButton();
        buttonSeekStart.setText("Press to seek");
        buttonSeekStart.setBounds(250,200,200,50);
        this.add(buttonSeekStart);
        
        seekBox = new JComboBox();
        seekBox.setBounds(50,350,400,50);
        seekBox.setEditable(true);
        this.add(seekBox);
 
    }
}
