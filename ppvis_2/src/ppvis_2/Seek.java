package ppvis_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ppvis_2.Main.ButtonDeleterListener;
import ppvis_2.Main.ButtonSeekerListener;

public class Seek {
	JFrame frame;
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
    private AppController appController;
    private Main main;
    
    
    public Seek(AppController appController, Main main)
    {
    	this.main = main;
    	this.appController = appController;
    	frame=new JFrame();
    	frame.setSize(500,500);
    	frame.setTitle("Seek");
    	frame.getContentPane().setLayout(null);
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
     	frame.add(rButton1);
     	frame.add(rButton2);
     	frame.add(rButton3);
     	frame.add(rButton4);
     	frame.add(rButton5);
        
        textSeeker = new JTextField();
        textSeeker.setBounds(250,50,200,30);
        frame.add(textSeeker);
        
        textSeeker2 = new JTextField();
        textSeeker2.setBounds(250,100,200,30);
        frame.add(textSeeker2);
        
        textSeeker3 = new JTextField();
        textSeeker3.setBounds(250,150,200,30);
        frame.add(textSeeker3);
        
        buttonSeekStart = new JButton();
        buttonSeekStart.setText("Press to seek");
        buttonSeekStart.setBounds(250,200,200,50);
        buttonSeekStart.addActionListener(new ButtonSeekStartListener());
        frame.add(buttonSeekStart);
        
        seekBox = new JComboBox();
        seekBox.setBounds(50,350,400,50);
        seekBox.setEditable(true);
        frame.add(seekBox);

 
    }
    
    public void start()
    {
    	frame.setVisible(true);
    }
    
    public class ButtonSeekStartListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//собрать параметры
			//вызвать операцию у контроллера с параметрами
			//отобразить результат который вернул контроллер
		}
	}
}
