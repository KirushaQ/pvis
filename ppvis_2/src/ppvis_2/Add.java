package ppvis_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.*;

public class Add {
	JFrame frame;
    JTextField addFieldTname;
    JTextField addFieldTdate;
    JTextField addFieldSname;
    JTextField addFieldWName;
    JTextField addFieldWSname;
    JTextField addFieldWFname;
    JTextField addFieldtprise;
    JButton buttonAdd;
    private AppController appController;
    private Main main;
    
    public Add(AppController appController, Main main)
    {
    	this.main=main;
    	this.appController = appController;
    	frame = new JFrame();
    	frame.setSize(350,600);
    	frame.setTitle("Add");
    	frame.getContentPane().setLayout(null);
        
    	addFieldTname = new JTextField("Название турнира");
    	addFieldTname.setBounds(50,50,200,30);
        frame.add(addFieldTname);
        
        addFieldTdate = new JTextField("Дата турнира");
        addFieldTdate.setBounds(50,100,200,30);
        frame.add(addFieldTdate);
        
        addFieldSname = new JTextField("Название спорта");
        addFieldSname.setBounds(50,150,200,30);
        frame.add(addFieldSname);
        
        addFieldWName = new JTextField("Имя");
        addFieldWName.setBounds(50,200,200,30);
        frame.add(addFieldWName);
        
        addFieldWSname = new JTextField("Фамилия");
        addFieldWSname.setBounds(50,250,200,30);
        frame.add(addFieldWSname);
            
        addFieldWFname = new JTextField("Отчество");
        addFieldWFname.setBounds(50,300,200,30);
        frame.add(addFieldWFname);
        
        addFieldtprise = new JTextField("Призовые");
        addFieldtprise.setBounds(50,350,200,30);
        frame.add(addFieldtprise);
        
        buttonAdd = new JButton();
        buttonAdd.setText("Press to add");
        buttonAdd.setBounds(50,400,200,50);
        buttonAdd.addActionListener(new AddListener());
        frame.add(buttonAdd);
        
    }
    
    public void start()
    {
    	frame.setVisible(true);
    }
     
	public class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			appController.fullRecords++;
			appController.tName.add(addFieldTname.getText());
			appController.tDate.add(LocalDate.parse(addFieldTdate.getText()));
			appController.sName.add(addFieldSname.getText());
			appController.winnerName.add(addFieldWName.getText());
			appController.winnerSName.add(addFieldWSname.getText());
			appController.winnerFName.add(addFieldWFname.getText());
			appController.tPrise.add(Integer.valueOf(addFieldtprise.getText()));
			appController.wPrise.add(Integer.valueOf(addFieldtprise.getText())*6/10);
			main.update();
		}
	}
	
}
