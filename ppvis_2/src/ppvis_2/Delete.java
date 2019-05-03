package ppvis_2;
import javax.swing.*;

public class Delete extends JFrame {
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
    
    public Delete()
    {
        this.setSize(500,500);
        this.setTitle("Delete");
        this.getContentPane().setLayout(null);
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
     	this.add(rdButton1);
     	this.add(rdButton2);
     	this.add(rdButton3);
     	this.add(rdButton4);
     	this.add(rdButton5);
        
        textDeleter = new JTextField();
        textDeleter.setBounds(250,50,200,30);
        this.add(textDeleter);
        
        textDeleter2 = new JTextField();
        textDeleter2.setBounds(250,100,200,30);
        this.add(textDeleter2);
        
        textDeleter3 = new JTextField();
        textDeleter3.setBounds(250,150,200,30);
        this.add(textDeleter3);
        
        buttonDeleteStart = new JButton();
        buttonDeleteStart.setText("Press to delete");
        buttonDeleteStart.setBounds(250,200,200,50);
        this.add(buttonDeleteStart);
        
        deleteResult = new JButton();
        deleteResult.setBounds(50,350,400,50);
        this.add(deleteResult);
    }
}
