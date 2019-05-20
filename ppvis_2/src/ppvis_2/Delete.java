package ppvis_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Delete {
	JFrame frame;
	ButtonGroup group2;
	JRadioButton rdButton1;
	JRadioButton rdButton2;
    JRadioButton rdButton3;
    JRadioButton rdButton4;
    JRadioButton rdButton5;
    JTextField textDeleter;
    JTextField textDeleter2;
    JTextField textDeleter3;
    JButton buttonDeleteStart;
    JButton deleteResult;
    private AppController appController;
    private Main main;
    
    public Delete(AppController appController, Main main)
    {
    	this.main = main;
    	this.appController = appController;
    	frame = new JFrame();
    	frame.setSize(500,500);
    	frame.setTitle("Delete");
    	frame.getContentPane().setLayout(null);
        rdButton1 = new JRadioButton("По турниру",true);
     	rdButton2 = new JRadioButton("По дате");
     	rdButton3 = new JRadioButton("По виду спорта");
     	rdButton4 = new JRadioButton("По Фио");
     	rdButton5 = new JRadioButton("По призовым");
     	group2 = new ButtonGroup();
     	rdButton1.setBounds(20,10,200,40);
     	rdButton2.setBounds(20,80,200,40);
     	rdButton3.setBounds(20,150,200,40);
     	rdButton4.setBounds(20,220,200,40);
     	rdButton5.setBounds(20,290,200,40);
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
        
        textDeleter = new JTextField();
        textDeleter.setBounds(250,50,200,30);
        frame.add(textDeleter);
        
        textDeleter2 = new JTextField();
        textDeleter2.setBounds(250,100,200,30);
        frame.add(textDeleter2);
        
        textDeleter3 = new JTextField();
        textDeleter3.setBounds(250,150,200,30);
        frame.add(textDeleter3);
        
        buttonDeleteStart = new JButton();
        buttonDeleteStart.setText("Press to delete");
        buttonDeleteStart.setBounds(250,200,200,50);
        buttonDeleteStart.addActionListener(new DeleteListener());
        frame.add(buttonDeleteStart);
        
        deleteResult = new JButton();
        deleteResult.setBounds(50,350,400,50);
        frame.add(deleteResult);
    }
    
    public class DeleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			appController.fullRecords--;
			main.update();
		}
	}
    
    public void start()
    {
    	frame.setVisible(true);
    }
}
