package ppvis_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Table {

	int page;
	int maxPage;
	int recOnPage;
	int fullRecords;
	int key;
	JFrame frame;
	
    ArrayList <String> tName = new ArrayList<>();
    ArrayList <LocalDate> tDate = new ArrayList<>(); 
    ArrayList <String> sName = new ArrayList<>();
    ArrayList <String> winnerName = new ArrayList<>();
    ArrayList <String> winnerSName = new ArrayList<>();
    ArrayList <String> winnerFName = new ArrayList<>();
    ArrayList <Integer> tPrise = new ArrayList<>();
    ArrayList <Integer> wPrise = new ArrayList<>();

	Object[] header = {"Название турнира", "Дата проведения", "Название вида спорта",
			"ФИО победителя", "Размеры призовых", "Заработок победителя"};
 	Object[] data = {null,null,null,null,null};
	
	
    private AppController appController;
    
    DefaultTableModel model;
    
    JButton button1;
    JButton buttonLeft;
    JButton buttonRight;
    JButton buttonEnd;
    JButton currentPage;
    JButton currentStrings;
    JButton currentAllStrings;
    JTextField textStrings;
    JButton buttonStrings;
    JLabel records;
    JLabel allRecords;
    JLabel allPages;
    JButton currentPages;
    
    
    JTable table;
    JScrollPane scrollPane;
    
    
    Table(int f, JFrame frame, AppController appController){
    	if (f==1) {
    		page = 1;
    		maxPage = 1;
    		recOnPage = 10;
    		fullRecords = 0;
    	}
    	this.appController = appController;
    	key = f;
    	this.frame = frame;
    	start();
    	
    }
    
    public void get(ArrayList <String> tname,  ArrayList <LocalDate> tdate,
    		 ArrayList <String> sname, ArrayList <String> winnername, 
    		 ArrayList <String> winnerSname, ArrayList <String> winnerFname,
    		 ArrayList <Integer> tprise, ArrayList <Integer> wprise)
    {
    	tName = tname;
    	tDate = tdate;
    	sName = sname;
    	winnerName = winnername;
    	winnerSName = winnerSname;
    	winnerFName = winnerFname;
    	tPrise = tprise;
    	wPrise = wprise;
    	fullRecords = tName.size();
    	maxPage = fullRecords/recOnPage+1;
    	if (fullRecords%10==0) maxPage--;
    	model = (DefaultTableModel) table.getModel();
    	int size;
    	if (fullRecords > recOnPage) {
    		size = recOnPage;
    	}
    	else {
    		size = fullRecords;
    	}
    	for (int i=0; i<size; i++) {
    		model.addRow(data);
    	}
    }
    
	public void change(int f)
	{
		int i;
		model = (DefaultTableModel) table.getModel();
		int size;
		if (key == 0) {
			if (appController.page==appController.maxPage) {
				size = appController.tDate.size()-appController.recOnPage*(appController.maxPage-1);
			}
			else {
				size = appController.recOnPage;
			}
			if (f==0) {
				for (i=0; i<size; i++) {
					model.removeRow(0);
				}
			}
			else {
				for (i=0; i<f; i++) {
					model.removeRow(0);
					}
			}
			for (i=0;i<size;i++) {
			model.addRow(data);
			table.setValueAt(appController.tName.get(i+(appController.page-1)*appController.recOnPage), i, 0);
        	table.setValueAt(appController.tDate.get(i+(appController.page-1)*appController.recOnPage), i, 1);
        	table.setValueAt(appController.sName.get(i+(appController.page-1)*appController.recOnPage), i, 2);
        	table.setValueAt(appController.winnerSName.get(i+(appController.page-1)*appController.recOnPage)+" "+
        	appController.winnerName.get(i+(appController.page-1)*appController.recOnPage)+" "+
            appController.winnerFName.get(i+(appController.page-1)*appController.recOnPage), i, 3);
        	table.setValueAt(appController.tPrise.get(i+(appController.page-1)*appController.recOnPage), i, 4);
        	table.setValueAt(appController.wPrise.get(i+(appController.page-1)*appController.recOnPage), i, 5);
			}
		}
		
		if (key == 1) {
			if (page==maxPage) {
				size = tDate.size()-recOnPage*(maxPage-1);
			}
			else {
				size = recOnPage;
			}
			if (fullRecords == 0) {
				size = 0;
			}
			if (f==0 || fullRecords<recOnPage) {
				for (i=0; i<size; i++) {
				model.removeRow(0);
				}
			}
			else {
				for (i=0; i<f; i++) {
					model.removeRow(0);
					}
			}
			for (i=0;i<size;i++) {
				model.addRow(data);
				table.setValueAt(tName.get(i+(page-1)*recOnPage), i, 0);
	        	table.setValueAt(tDate.get(i+(page-1)*recOnPage), i, 1);
	        	table.setValueAt(sName.get(i+(page-1)*recOnPage), i, 2);
	        	table.setValueAt(winnerSName.get(i+(page-1)*recOnPage)+" "+
	        	winnerName.get(i+(page-1)*recOnPage)+" "+
	        	winnerFName.get(i+(page-1)*recOnPage), i, 3);
	        	table.setValueAt(tPrise.get(i+(page-1)*recOnPage), i, 4);
	        	table.setValueAt(wPrise.get(i+(page-1)*recOnPage), i, 5);
			}
		}
	}
	
	
	public void update()
	{
		if (key == 0) {
			appController.maxPage=appController.fullRecords/appController.recOnPage+1;
			if (appController.fullRecords%10==0) {
				appController.maxPage--;
			}
	        buttonEnd.setText(String.valueOf(appController.maxPage));    
	        currentPages.setText(String.valueOf(appController.maxPage)); 
	        currentStrings.setText(String.valueOf(appController.recOnPage)); 
	        currentAllStrings.setText(String.valueOf(appController.fullRecords)); 
	        
	        
	        model = (DefaultTableModel) table.getModel();
	        for (int i=0; i<appController.recOnPage;i++) {
	        model.removeRow(0);
	        }
	       
	        for (int i=0; i<appController.recOnPage;i++) {
	            model.addRow(data);
	            if (appController.tName.size()>i) {
	            	table.setValueAt(appController.tName.get(i), i, 0);
	            	table.setValueAt(appController.tDate.get(i), i, 1);
	            	table.setValueAt(appController.sName.get(i), i, 2);
	            	table.setValueAt(appController.winnerSName.get(i)+" "+
	            	appController.winnerName.get(i)+" "+
	                appController.winnerFName.get(i), i, 3);
	            	table.setValueAt(appController.tPrise.get(i), i, 4);
	            	table.setValueAt(appController.wPrise.get(i), i, 5);
	            }
	        }
		}
		if (key == 1) {
			maxPage=fullRecords/recOnPage+1;
			if (fullRecords%10==0 && fullRecords!=0) {
				maxPage--;
			}
	        buttonEnd.setText(String.valueOf(maxPage));    
	        currentPages.setText(String.valueOf(maxPage)); 
	        currentStrings.setText(String.valueOf(recOnPage)); 
	        currentAllStrings.setText(String.valueOf(fullRecords)); 
	        
	        
	        model = (DefaultTableModel) table.getModel();
	        if (recOnPage < fullRecords) {
		        for (int i=0; i<recOnPage;i++) {
		        	model.removeRow(0);
		        }
	        }
	        else {
	        	 for (int i=0; i<fullRecords;i++) {
			        	model.removeRow(0);
			        }
	        }
	       
	        if(fullRecords != 0) {
	        	if (fullRecords >recOnPage) {
			        for (int i=0; i<recOnPage;i++) {
			            model.addRow(data);
			            if (tName.size()>i) {
			            	table.setValueAt(tName.get(i), i, 0);
			            	table.setValueAt(tDate.get(i), i, 1);
			            	table.setValueAt(sName.get(i), i, 2);
			            	table.setValueAt(winnerSName.get(i)+" "+
			            	winnerName.get(i)+" "+
			            	winnerFName.get(i), i, 3);
			            	table.setValueAt(tPrise.get(i), i, 4);
			            	table.setValueAt(wPrise.get(i), i, 5);
			            }
			        }
	        	}
	        	else {
	        		 for (int i=0; i<fullRecords;i++) {
				            model.addRow(data);
				            if (tName.size()>i) {
				            	table.setValueAt(tName.get(i), i, 0);
				            	table.setValueAt(tDate.get(i), i, 1);
				            	table.setValueAt(sName.get(i), i, 2);
				            	table.setValueAt(winnerSName.get(i)+" "+
				            	winnerName.get(i)+" "+
				            	winnerFName.get(i), i, 3);
				            	table.setValueAt(tPrise.get(i), i, 4);
				            	table.setValueAt(wPrise.get(i), i, 5);
				            }
				        }
	        	}
	        }
		}
	}
    
	public void clear() {
		model = (DefaultTableModel) table.getModel();
		int i;
		if (fullRecords>recOnPage) {
			for (i=0;i<recOnPage;i++) {
				model.removeRow(0);
			}
		}
		else {
			for (i=0;i<fullRecords;i++) {
				model.removeRow(0);
			}
		}
		page = 1;
		maxPage = 1;
		recOnPage = 10;
		fullRecords = 0;
		textStrings.setText(null);
		for (i=0;i<recOnPage;i++) {
			model.addRow(data);
		}
		update();
	}
	
    public void start() {
        table = new JTable(new DefaultTableModel(header,0));

        model = (DefaultTableModel) table.getModel();
        if (key==0) {
        	for (int i=0; i<10; i++)
        		model.addRow(data);
        }
        
     	table.setBounds(25,130,1000,180);
     	scrollPane = new JScrollPane(table);
     	scrollPane.setBounds(20,125,1005,183);
        frame.add(scrollPane);
        button1 = new JButton();
        button1.setText("1");
        button1.setBounds(250,380,50,50);
        button1.addActionListener(new Button1Listener());
        frame.add(button1);
        
        buttonLeft = new JButton();
        buttonLeft.setText("<<");
        buttonLeft.setBounds(350,380,50,50);
        buttonLeft.addActionListener(new ButtonLeftListener());
        frame.add(buttonLeft);
        
        buttonRight = new JButton();
        buttonRight.setText(">>");
        buttonRight.setBounds(550,380,50,50);
        buttonRight.addActionListener(new ButtonRightListener());
        frame.add(buttonRight);
        
        buttonEnd = new JButton();
        buttonEnd.setBounds(650,380,50,50);
        buttonEnd.addActionListener(new ButtonEndListener());
        frame.add(buttonEnd);
        
        currentPage = new JButton();
        currentPage.setBounds(450,380,50,50);
        frame.add(currentPage);
        
        currentStrings = new JButton();
        currentStrings.setBounds(950,380,50,30);
        frame.add(currentStrings);
        
        currentAllStrings = new JButton();
        currentAllStrings.setBounds(950,480,50,30);
        frame.add(currentAllStrings);
               
        currentPages = new JButton();
        currentPages.setBounds(950,430,50,30);
        frame.add(currentPages);
        
        textStrings = new JTextField();
        textStrings.setBounds(250,450,200,50);
        frame.add(textStrings);
        
        buttonStrings = new JButton();
        buttonStrings.setText("Change records amount");
        buttonStrings.setBounds(500,450,200,50);
        buttonStrings.addActionListener(new ButtonStringsListener());
        frame.add(buttonStrings);
        
        records = new JLabel();
        records.setText("Записей на странице");
        records.setBounds(800,380,200,30);
        frame.add(records);
        
        allRecords = new JLabel();
        allRecords.setText("Всего записей");
        allRecords.setBounds(800,480,200,30);
        frame.add(allRecords);
        
        allPages = new JLabel();
        allPages.setText("Всего страниц");
        allPages.setBounds(800,430,200,30);
        frame.add(allPages);
        
        if (key == 0) {
            buttonEnd.setText(String.valueOf(appController.maxPage));
            currentPage.setText(String.valueOf(appController.page));
            currentStrings.setText(String.valueOf(appController.recOnPage));
            currentAllStrings.setText(String.valueOf(appController.fullRecords));
            currentPages.setText(String.valueOf(appController.maxPage));
        }
        
        if (key == 1) {
            buttonEnd.setText(String.valueOf(maxPage));
            currentPage.setText(String.valueOf(page));
            currentStrings.setText(String.valueOf(recOnPage));
            currentAllStrings.setText(String.valueOf(fullRecords));
            currentPages.setText(String.valueOf(maxPage));
        }
        
    }
    
	public class Button1Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (key == 0) {
				appController.page = 1;
				currentPage.setText(String.valueOf(appController.page));
	            change(0);
			}
			if (key == 1) {
				page = 1;
				currentPage.setText(String.valueOf(page));
	            change(0);
			}
		}
	}
	
	public class ButtonLeftListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (key == 0) {
				appController.page--;
				if (appController.page<1) appController.page=1;
				if (appController.page>appController.maxPage) appController.page=appController.maxPage;
				currentPage.setText(String.valueOf(appController.page));
	            change(0);
			}
			if (key == 1) {
				page--;
				if (page<1) page=1;
				if (page>maxPage) page=maxPage;
				currentPage.setText(String.valueOf(page));
	            change(0);
			}
		}
	}
	
	public class ButtonRightListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (key == 0) {
				appController.page++;
				if (appController.page > appController.maxPage) {
					appController.page=appController.maxPage;
				}
				currentPage.setText(String.valueOf(appController.page));
	            change(0);
			}
			if (key == 1) {
				page++;
				if (page > maxPage) {
					page=maxPage;
				}
				currentPage.setText(String.valueOf(page));
	            change(0);
			}
		}
	}
	
	public class ButtonStringsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (key == 0) {
				int f = appController.recOnPage;
				appController.recOnPage  = Integer.valueOf(textStrings.getText());
				appController. maxPage = appController.fullRecords/appController.recOnPage;
	            if (appController.maxPage*appController.recOnPage != appController.fullRecords) appController.maxPage++;
	            currentStrings.setText(String.valueOf(appController.recOnPage));
	            currentPages.setText(String.valueOf(appController.maxPage));
	            currentAllStrings.setText(String.valueOf(appController.fullRecords));
	            buttonEnd.setText(String.valueOf(appController.maxPage));
	            change(f);
			}
			if (key == 1) {
				if (fullRecords!=0) {
					int f = recOnPage;
					recOnPage  = Integer.valueOf(textStrings.getText());
					maxPage = fullRecords/recOnPage+1;
					if (fullRecords%10==0) maxPage--;
		            currentStrings.setText(String.valueOf(recOnPage));
		            currentPages.setText(String.valueOf(maxPage));
		            currentAllStrings.setText(String.valueOf(fullRecords));
		            buttonEnd.setText(String.valueOf(maxPage));
		            change(f);
				}
				else {
					recOnPage  = Integer.valueOf(textStrings.getText());
		            currentStrings.setText(String.valueOf(recOnPage));

				}
			}
            
		}
	}
	
	public class ButtonEndListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (key == 0)
			{
				appController.page = appController.maxPage;
				currentPage.setText(String.valueOf(appController.page));
	            change(0);
			}
			if (key == 1) {
				page = maxPage;
				currentPage.setText(String.valueOf(page));
	            change(0);
			}
				
		}
	}
}
