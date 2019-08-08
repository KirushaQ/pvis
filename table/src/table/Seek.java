package table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

import table.Main.SeekListener;


public class Seek {
	private AppController controller;
	private AppController seekController;
	JFrame frame;
	Table table;
	
	ButtonGroup group;
	JRadioButton button1;
	JRadioButton button2;
	JRadioButton button3;
	JRadioButton button4;
	JRadioButton button5;
	JRadioButton button6;
	
	JButton base;
	
	JTextField text;
	JButton seek;
	
	public Seek(AppController controller){
		this.controller = controller;
	}
	
	public void start(){
		
		seekController = new AppController(1);
		seekController.copy(controller);
		
		frame = new JFrame();
		frame.setSize(1280, 800);
		frame.getContentPane().setLayout(null);   
		table = new Table(frame, seekController);
		table.update();
		
		group = new ButtonGroup();
		
		button1 = new JRadioButton();
		button1.setText("По названию спорта");
		button1.setBounds(10,20,150,50);
        frame.add(button1);
        
		button2 = new JRadioButton();
		button2.setText("По имени");
		button2.setBounds(200,20,100,50);
        frame.add(button2);
        
		button3 = new JRadioButton();
		button3.setText("По фамилии");
		button3.setBounds(330,20,110,50);
        frame.add(button3);
        
		button4 = new JRadioButton();
		button4.setText("По отчеству");
		button4.setBounds(450,20,110,50);
        frame.add(button4);
        
		button5 = new JRadioButton();
		button5.setText("По дате проведения");
		button5.setBounds(570,20,150,50);
        frame.add(button5);
        
		button6 = new JRadioButton();
		button6.setText("По призовым");
		button6.setBounds(740,20,120,50);
		frame.add(button6);
		
		
		group.add(button1);
		group.add(button2);
		group.add(button3);
		group.add(button4);
		group.add(button5);
		group.add(button6);
		
		text = new JTextField();
		text.setBounds(50,620,200,50);
		frame.add(text);
		
        seek = new JButton();
        seek.setText("Press to seek");
        seek.setBounds(50,550,200,50);
        seek.addActionListener(new SeekListener());
        frame.add(seek);
        
		base = new JButton();
		base.setText("Return to all");
		base.setBounds(1050,20,200,80);
		base.addActionListener(new BaseListener());
        frame.add(base);
        
		frame.setVisible(true);
	}
	
	public class BaseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			seekController.copy(controller);
			table.update();
		}
	}
	
	public class SeekListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int i;
			seekController.current = 1;
			seekController.recOnPage = 5;
			seekController.pages = 1;
			seekController.allRec = 0;
			
			seekController.sName.clear();
			seekController.wName.clear();
			seekController.wSName.clear();
			seekController.wFName.clear();
			seekController.date.clear();
			seekController.tPrise.clear();
			
			for (i=0; i<controller.allRec; i++){
				if (button1.isSelected() && text.getText().equals(controller.sName.get(i))){
					seekController.allRec++;
					seekController.sName.add(controller.sName.get(i));
					seekController.wName.add(controller.wName.get(i));
					seekController.wSName.add(controller.wSName.get(i));
					seekController.wFName.add(controller.wFName.get(i));
					seekController.date.add(controller.date.get(i));
					seekController.tPrise.add(controller.tPrise.get(i));
				}
				
				if (button2.isSelected() && text.getText().equals(controller.wName.get(i))){
					seekController.allRec++;
					seekController.sName.add(controller.sName.get(i));
					seekController.wName.add(controller.wName.get(i));
					seekController.wSName.add(controller.wSName.get(i));
					seekController.wFName.add(controller.wFName.get(i));
					seekController.date.add(controller.date.get(i));
					seekController.tPrise.add(controller.tPrise.get(i));
				}
				
				
				if (button3.isSelected() && text.getText().equals(controller.wSName.get(i))){
					seekController.allRec++;
					seekController.sName.add(controller.sName.get(i));
					seekController.wName.add(controller.wName.get(i));
					seekController.wSName.add(controller.wSName.get(i));
					seekController.wFName.add(controller.wFName.get(i));
					seekController.date.add(controller.date.get(i));
					seekController.tPrise.add(controller.tPrise.get(i));
				}
				
				
				if (button4.isSelected() && text.getText().equals(controller.wFName.get(i))){
					seekController.allRec++;
					seekController.sName.add(controller.sName.get(i));
					seekController.wName.add(controller.wName.get(i));
					seekController.wSName.add(controller.wSName.get(i));
					seekController.wFName.add(controller.wFName.get(i));
					seekController.date.add(controller.date.get(i));
					seekController.tPrise.add(controller.tPrise.get(i));
				}
				
				if (button5.isSelected() && text.getText().equals(String.valueOf(controller.date.get(i)))){
					seekController.allRec++;
					seekController.sName.add(controller.sName.get(i));
					seekController.wName.add(controller.wName.get(i));
					seekController.wSName.add(controller.wSName.get(i));
					seekController.wFName.add(controller.wFName.get(i));
					seekController.date.add(controller.date.get(i));
					seekController.tPrise.add(controller.tPrise.get(i));
				}
				
				
				if (button6.isSelected() && text.getText().equals(String.valueOf(controller.tPrise.get(i)))){
					seekController.allRec++;
					seekController.sName.add(controller.sName.get(i));
					seekController.wName.add(controller.wName.get(i));
					seekController.wSName.add(controller.wSName.get(i));
					seekController.wFName.add(controller.wFName.get(i));
					seekController.date.add(controller.date.get(i));
					seekController.tPrise.add(controller.tPrise.get(i));
				}
				
			}
			table.update();
		}
	}
}
