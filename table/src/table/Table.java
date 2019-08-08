package table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Table {

	private AppController controller;
	 JScrollPane scrollPane;
	 JFrame frame;
	 DefaultTableModel model;
	 JTable table;
	 Table main;
	 Add add;
	 Main cMain;
	 int seekFlag = 0;
	 //________________________________________________________________________________
	 Object[] header = {"Спорт","ФИО победителя","Дата","Приз"};
	 Object[] inf = {null,null,null,null};
	 //________________________________________________________________________________
	 
	 //Переключение страниц
	 JButton first;
	 JButton left;
	 JButton current;
	 JButton right;
	 JButton end;
	 
	 //Показатели
	 JButton allRec;
	 JButton allPages;
	 JButton recOnPage;
	 JLabel allrec;
	 JLabel allpages;
	 JLabel reconpage;
	 
	 //Изменить
	 JTextField text;
	 JButton change;
	 

	 //_______________________________________________________
	 
	public Table(JFrame frame, AppController controller, Main main){
		this.controller = controller;
		this.frame = frame;
		cMain = main;
		start();
	}
	
	public Table(JFrame frame, AppController controller){
		this.controller = controller;
		this.frame = frame;
		start();
		seekFlag = 1;
	}
	
	public void start(){
		 table = new JTable(new DefaultTableModel(header,0));
		 table.setBounds(125,130,1000,180);
		/* model = (DefaultTableModel) table.getModel();
		 for (int i=0; i<20; i++)
		 model.addRow(inf);*/
	     	scrollPane = new JScrollPane(table);
	     	scrollPane.setBounds(100,125,1005,183);
	        frame.add(scrollPane);      
    
	        first = new JButton();
	        first.setText("1");
	        first.setBounds(225,380,100,100);
	        first.addActionListener(new FirstListener());
	        frame.add(first);
	        
	        left = new JButton();
	        left.setText("<<");
	        left.setBounds(365,380,100,100);
	        left.addActionListener(new LeftListener());
	        frame.add(left);
	        
	        current = new JButton();
	        current.setText("1");
	        current.setBounds(505,380,100,100);
	        frame.add(current);
	        
	        right = new JButton();
	        right.setText(">>");
	        right.setBounds(645,380,100,100);
	        right.addActionListener(new RigthListener());
	        frame.add(right);
	        
	        end = new JButton();
	        end.setText(String.valueOf(controller.pages));
	        end.setBounds(785,380,100,100);
	        end.addActionListener(new EndListener());
	        frame.add(end);
	        
	        allrec = new JLabel();
	        allrec.setText("Всего записей");
	        allrec.setBounds(950,380,100,100);
	        frame.add(allrec);
	        
	        allRec = new JButton();
	        allRec.setText(String.valueOf(controller.allRec));
	        allRec.setBounds(1105,380,100,100);
	        frame.add(allRec);
	        
	        allpages = new JLabel();
	        allpages.setText("Всего страниц");
	        allpages.setBounds(950,500,100,100);
	        frame.add(allpages);
	        
	        allPages = new JButton();
	        allPages.setText(String.valueOf(controller.pages));
	        allPages.setBounds(1105,500,100,100);
	        frame.add(allPages);
	        
	        reconpage = new JLabel();
	        reconpage.setText("Записей на странице");
	        reconpage.setBounds(950,620,150,100);
	        frame.add(reconpage);
	        
	        recOnPage = new JButton();
	        recOnPage.setText(String.valueOf(controller.recOnPage));
	        recOnPage.setBounds(1105,620,100,100);
	        frame.add(recOnPage);
	        
	        text = new JTextField();
	        text.setBounds(365,500,200,80);
	        frame.add(text);
	        
	        change = new JButton();
	        change.setText("Change recOnPage");
	        change.setBounds(600,500,200,80);
	        change.addActionListener(new ChangeListener());
	        frame.add(change);
	}
	
	public void update(){
		int i, startR, endR, count;
		
		controller.pages=controller.allRec/controller.recOnPage;
		if(controller.allRec%controller.recOnPage!=0) controller.pages++;
		allPages.setText(String.valueOf(controller.pages));
		recOnPage.setText(String.valueOf(controller.recOnPage));
		end.setText(String.valueOf(controller.pages));
		
		model = (DefaultTableModel) table.getModel();
		count=model.getRowCount();
		for (i=0; i<count; i++){
			model.removeRow(0);
		}
		startR=controller.recOnPage*(controller.current-1);
		endR=startR+controller.recOnPage;
		if (endR>controller.allRec){
			endR=controller.allRec;
		}
		for (i=startR; i<endR; i++){
			Object[] row={controller.sName.get(i),controller.wSName.get(i)+" "+controller.wName.get(i)+
					" "+controller.wFName.get(i),String.valueOf(controller.date.get(i)),String.valueOf(controller.tPrise.get(i))};
			model.addRow(row);
		}
		
		allRec.setText(String.valueOf(controller.allRec));
		recOnPage.setText(String.valueOf(controller.recOnPage));
		allPages.setText(String.valueOf(controller.pages));
	}
	
	
	
	public class FirstListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (controller.current!=1){
				int x = controller.current;
				controller.current=1;
				current.setText("1");
				if (seekFlag==0){
					cMain.getChange(controller, "Переход со страницы " +String.valueOf(x)+
						" на " + String.valueOf(controller.current) + " страницу");
				}
				update();
			}
		}
	}
	
	
	public class LeftListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (controller.current>1){
				int x = controller.current;
				controller.current--;
				current.setText(String.valueOf(controller.current));
				if (seekFlag==0){
					cMain.getChange(controller, "Переход со страницы " +String.valueOf(x)+
						" на " + String.valueOf(controller.current) + " страницу");
				}
				update();
			}
		}
	}
	
	
	public class RigthListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (controller.current<controller.pages){
				int x = controller.current;
				controller.current++;
				current.setText(String.valueOf(controller.current));
				if (seekFlag==0){
					cMain.getChange(controller, "Переход со страницы " +String.valueOf(x)+
						" на " + String.valueOf(controller.current) + " страницу");
				}
				update();
			}
		}
	}
	
	public class EndListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (controller.current!=controller.pages){
				int x = controller.current;
				controller.current=controller.pages;
				current.setText(String.valueOf(controller.current));
				if (seekFlag==0){
					cMain.getChange(controller, "Переход со страницы " +String.valueOf(x)+
						" на " + String.valueOf(controller.current) + " страницу");
				}
				update();
			}
		}
	}
	
	public class ChangeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int x = controller.recOnPage;
			controller.recOnPage=Integer.valueOf(text.getText());
			controller.current=1;
			current.setText("1");
			if (seekFlag==0){
				cMain.getChange(controller, "Изменение числа записей на странице с " +String.valueOf(x)+
					" на " + String.valueOf(controller.recOnPage));
			}
			update();
		}
	}
}
