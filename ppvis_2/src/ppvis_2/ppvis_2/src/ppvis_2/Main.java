package ppvis_2;

import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

import ppvis_2.Main.ButtonSeekerListener;

public class Main {

	Object[] header = {"�������� �������", "���� ����������", "�������� ���� ������",
			"��� ����������", "������� ��������", "��������� ����������"};
 	Object[][] data = {{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null}};
	
	JFrame frame;
    Add sAdd;
	Seek sSeek;
	Seek sDelete;
    JButton buttonSeeker;  
    JButton buttonDeleter;

 
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
    
    JButton addButton;

    JButton saveButton;
    JButton loadButton;
    
    JTable table;
    JScrollPane scrollPane;
    
    
	private AppController appController;
	
    
	public Main(AppController appController)
	{
		this.appController = appController;
		start();
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void update()
	{
		appController.maxPage=appController.fullRecords/appController.recOnPage;
        buttonEnd.setText(String.valueOf(appController.maxPage));    
        currentPages.setText(String.valueOf(appController.maxPage)); 
        currentStrings.setText(String.valueOf(appController.recOnPage)); 
        currentAllStrings.setText(String.valueOf(appController.fullRecords)); 
        
	}
	
	public void start()
	{
		frame = new JFrame();
    	frame.setSize(1080,600);
    	frame.setTitle("Lel");
        frame.getContentPane().setLayout(null);        

        
        sAdd = new Add(appController, this);      
        addButton = new JButton();
        addButton.setText("Add record");
        addButton.setBounds(30,380,180,50);
        addButton.addActionListener(new AddButtonListener());
        frame.add(addButton);
        
        sSeek = new Seek(appController, this, 0);
        buttonSeeker = new JButton();
        buttonSeeker.setText("Press to seek");
        buttonSeeker.setBounds(50,20,200,50);
        buttonSeeker.addActionListener(new ButtonSeekerListener());
        frame.add(buttonSeeker);	
            
        sDelete = new Seek(appController, this, 1);
        buttonDeleter = new JButton();
        buttonDeleter.setText("Press to delete");
        buttonDeleter.setBounds(800,20,200,50);
        buttonDeleter.addActionListener(new ButtonDeleterListener());
        frame.add(buttonDeleter);
        
               
    	table = new JTable(data,header);
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
        buttonEnd.setText("5");
        buttonEnd.setBounds(650,380,50,50);
        buttonEnd.addActionListener(new ButtonEndListener());
        frame.add(buttonEnd);
        
        currentPage = new JButton();
        currentPage.setText("1");
        currentPage.setBounds(450,380,50,50);
        frame.add(currentPage);
        
        currentStrings = new JButton();
        currentStrings.setText("10");
        currentStrings.setBounds(950,380,50,30);
        frame.add(currentStrings);
        
        currentAllStrings = new JButton();
        currentAllStrings.setText("50");
        currentAllStrings.setBounds(950,480,50,30);
        frame.add(currentAllStrings);
               
        currentPages = new JButton();
        currentPages.setText("5");
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
        records.setText("������� �� ��������");
        records.setBounds(800,380,200,30);
        frame.add(records);
        
        allRecords = new JLabel();
        allRecords.setText("����� �������");
        allRecords.setBounds(800,480,200,30);
        frame.add(allRecords);
        
        allPages = new JLabel();
        allPages.setText("����� �������");
        allPages.setBounds(800,430,200,30);
        frame.add(allPages);
        
        saveButton = new JButton();
        saveButton.setText("save");
        saveButton.setBounds(320,30,200,50);
        frame.add(saveButton);
        
        loadButton = new JButton();
        loadButton.setText("load");
        loadButton.setBounds(540,30,200,50);
        frame.add(loadButton);
        
	}

	
	
	
	public class ButtonSeekerListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            sSeek.start();
		}
	}
	
	public class ButtonDeleterListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	            sDelete.start();
		}
	}
	
	public class AddButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			    sAdd.start();
		}
	}
	
	public class Button1Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			appController.page = 1;
			currentPage.setText(String.valueOf(appController.page));
		}
	}
	
	public class ButtonLeftListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			appController.page--;
			if (appController.page<1) appController.page=1;
			if (appController.page>appController.maxPage) appController.page=appController.maxPage;
			currentPage.setText(String.valueOf(appController.page));
		}
	}
	
	public class ButtonRightListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			appController.page++;
			if (appController.page > appController.maxPage) appController.page=appController.maxPage;
			currentPage.setText(String.valueOf(appController.page));
		}
	}
	
	public class ButtonStringsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			appController.recOnPage  = Integer.valueOf(textStrings.getText());
			appController. maxPage = appController.fullRecords/appController.recOnPage;
            if (appController.maxPage*appController.recOnPage != appController.fullRecords) appController.maxPage++;
            currentStrings.setText(String.valueOf(appController.recOnPage));
            currentPages.setText(String.valueOf(appController.maxPage));
            currentAllStrings.setText(String.valueOf(appController.fullRecords));
            buttonEnd.setText(String.valueOf(appController.maxPage));
            
		}
	}
	
	public class ButtonEndListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			appController.page = appController.maxPage;
			currentPage.setText(String.valueOf(appController.page));
		}
	}
	
	public static void main(String[] args) {
		Data data = new Data();
		AppController appController = new AppController(data); 
		Main start = new Main(appController);
    }
}
