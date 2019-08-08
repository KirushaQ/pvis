package table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.*;



public class Add {
	private AppController controller;
	JFrame frame;
	Main main;
	
	JTextField sport;
	JTextField name;
	JTextField sName;
	JTextField fName;
	JTextField date;
	JTextField prise;
	JButton addButton;
	
	public Add(AppController controller, Main main){
		this.controller = controller;
		this.main = main;  
	}
	public void start(){
		
		frame = new JFrame();
		frame.setSize(300, 600);
		frame.getContentPane().setLayout(null);   
		
		sport = new JTextField();
		sport.setText("Название спорта");
		sport.setBounds(50,10,200,50);
        frame.add(sport);
        
        name = new JTextField();
        name.setText("Имя");
        name.setBounds(50,80,200,50);
        frame.add(name);
        
        sName = new JTextField();
        sName.setText("Фамилия");
        sName.setBounds(50,150,200,50);
        frame.add(sName);
        
        fName = new JTextField();
        fName.setText("Отчество");
		fName.setBounds(50,220,200,50);
        frame.add(fName);
        
        date = new JTextField();
        date.setText("Дата проведения");
        date.setBounds(50,290,200,50);
        frame.add(date);
        
        prise = new JTextField();
        prise.setText("Призовые");
        prise.setBounds(50,360,200,50);
        frame.add(prise);
        
        addButton = new JButton();
        addButton.setText("Press to add");
        addButton.setBounds(50,430,200,50);
        addButton.addActionListener(new AddListener());
        frame.add(addButton);
		
		frame.setVisible(true);
	}
	
	public class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			controller.sName.add(sport.getText());
			controller.wName.add(name.getText());
			controller.wSName.add(sName.getText());
			controller.wFName.add(fName.getText());
			controller.date.add(LocalDate.parse(date.getText()));
			controller.tPrise.add(Integer.valueOf(prise.getText()));
			controller.allRec++;
			main.getChange(controller, "Добавление информации о " + sName.getText() + " " +
					name.getText() + " " + fName.getText());
			main.update();
		}
	}
}
