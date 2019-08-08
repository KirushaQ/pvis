package table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;



public class Delete {
	private AppController controller;
	JFrame frame;
	Main main;
	
	ButtonGroup group;
	JRadioButton button1;
	JRadioButton button2;
	JRadioButton button3;
	JRadioButton button4;
	JRadioButton button5;
	JRadioButton button6;
	
	JTextField text;
	JButton delete;
	JButton info;
	
	//вектора
	ArrayList<String> sName;
	ArrayList<String> wName;
	ArrayList<String> wSName;
	ArrayList<String> wFName;
	ArrayList<LocalDate> date;
	ArrayList<Integer> tPrise;
	
	public Delete(AppController controller, Main main){
		this.controller = controller;
		this.main = main;  
	}
	
	public void start(){
		
		
		frame = new JFrame();
		frame.setSize(300, 700);
		frame.getContentPane().setLayout(null);
		
		group = new ButtonGroup();
		
		button1 = new JRadioButton();
		button1.setText("По названию спорта");
		button1.setBounds(50,10,200,50);
        frame.add(button1);
        
		button2 = new JRadioButton();
		button2.setText("По имени");
		button2.setBounds(50,80,200,50);
        frame.add(button2);
        
		button3 = new JRadioButton();
		button3.setText("По фамилии");
		button3.setBounds(50,150,200,50);
        frame.add(button3);
        
		button4 = new JRadioButton();
		button4.setText("По отчеству");
		button4.setBounds(50,220,200,50);
        frame.add(button4);
        
		button5 = new JRadioButton();
		button5.setText("По дате проведения");
		button5.setBounds(50,290,200,50);
        frame.add(button5);
        
		button6 = new JRadioButton();
		button6.setText("По призовым");
		button6.setBounds(50,360,200,50);
		frame.add(button6);
		
		
		group.add(button1);
		group.add(button2);
		group.add(button3);
		group.add(button4);
		group.add(button5);
		group.add(button6);
		
		text = new JTextField();
		text.setBounds(50,430,200,50);
		frame.add(text);
		
        delete = new JButton();
        delete.setText("Press to delete");
        delete.setBounds(50,500,200,50);
        delete.addActionListener(new DeleteListener());
        frame.add(delete);
        
        info = new JButton();
        info.setBounds(20,570,250,50);
        frame.add(info);
		
		
		frame.setVisible(true);
	}
	
	public class DeleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int i,k=0;
			
			
			sName = new ArrayList<String>();
			wName = new ArrayList<String>();
			wSName = new ArrayList<String>();
			wFName = new ArrayList<String>();
			date = new ArrayList<LocalDate>();
			tPrise = new ArrayList<Integer>();
			
			for (i=0; i<controller.allRec; i++){
				if (button1.isSelected() && !text.getText().equals(controller.sName.get(i))){
					k++;
					sName.add(controller.sName.get(i));
					wName.add(controller.wName.get(i));
					wSName.add(controller.wSName.get(i));
					wFName.add(controller.wFName.get(i));
					date.add(controller.date.get(i));
					tPrise.add(controller.tPrise.get(i));
				}
				
				if (button2.isSelected() && !text.getText().equals(controller.wName.get(i))){
					k++;
					sName.add(controller.sName.get(i));
					wName.add(controller.wName.get(i));
					wSName.add(controller.wSName.get(i));
					wFName.add(controller.wFName.get(i));
					date.add(controller.date.get(i));
					tPrise.add(controller.tPrise.get(i));
				}
				
				
				if (button3.isSelected() && !text.getText().equals(controller.wSName.get(i))){
					k++;
					sName.add(controller.sName.get(i));
					wName.add(controller.wName.get(i));
					wSName.add(controller.wSName.get(i));
					wFName.add(controller.wFName.get(i));
					date.add(controller.date.get(i));
					tPrise.add(controller.tPrise.get(i));
				}
				
				
				if (button4.isSelected() && !text.getText().equals(controller.wFName.get(i))){
					k++;
					sName.add(controller.sName.get(i));
					wName.add(controller.wName.get(i));
					wSName.add(controller.wSName.get(i));
					wFName.add(controller.wFName.get(i));
					date.add(controller.date.get(i));
					tPrise.add(controller.tPrise.get(i));
				}
				
				if (button5.isSelected() && !text.getText().equals(String.valueOf(controller.date.get(i)))){
					k++;
					sName.add(controller.sName.get(i));
					wName.add(controller.wName.get(i));
					wSName.add(controller.wSName.get(i));
					wFName.add(controller.wFName.get(i));
					date.add(controller.date.get(i));
					tPrise.add(controller.tPrise.get(i));
				}
				
				
				if (button6.isSelected() && !text.getText().equals(String.valueOf(controller.tPrise.get(i)))){
					k++;
					sName.add(controller.sName.get(i));
					wName.add(controller.wName.get(i));
					wSName.add(controller.wSName.get(i));
					wFName.add(controller.wFName.get(i));
					date.add(controller.date.get(i));
					tPrise.add(controller.tPrise.get(i));
				}
				
			}
			
			controller.sName.clear();
			controller.wName.clear();
			controller.wSName.clear();
			controller.wFName.clear();
			controller.date.clear();
			controller.tPrise.clear();
			
			info.setText("Было удалено "+ String.valueOf(controller.allRec-k)+" записей");
			
			controller.allRec=k;
			
			controller.sName = (ArrayList<String>) sName.clone();
			controller.wName =  (ArrayList<String>) wName.clone();
			controller.wSName =  (ArrayList<String>) wSName.clone();
			controller.wFName =  (ArrayList<String>) wFName.clone();
			controller.date =  (ArrayList<LocalDate>) date.clone();
			controller.tPrise =  (ArrayList<Integer>) tPrise.clone();
			
			sName.clear();
			wName.clear();
			wSName.clear();
			wFName.clear();
			date.clear();
			tPrise.clear();
			
			
			main.getChange(controller, "Удаление информации о " + String.valueOf(k) + " людях");
			main.update();
		}
	}
}
