package ppvis_2;

import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

import ppvis_2.Main.ButtonSeekerListener;

public class Main {

	Object[] header = {"Название турнира", "Дата проведения", "Название вида спорта",
			"ФИО победителя", "Размеры призовых", "Заработок победителя"};
 	Object[][] data = {{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null}};
 	int page = 1;
 	int maxPage = 5;
 	int recOnPage = 10;
 	int fullRecords = 50;
	
	JFrame frame;

    JButton buttonSeeker;
    Seek seek;
    
    JButton buttonDeleter;
    Delete delete;
 
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
    Add add;

    JButton saveButton;
    JButton loadButton;
    
    JTable table;
    JScrollPane scrollPane;
    
    ArrayList <String> tName;
    ArrayList <LocalDate> tDate; 
    ArrayList <String> sName;
    ArrayList <String> tWinner;
    ArrayList <Integer> tPrise;
    ArrayList <Integer> wPrise;
    
	public Main()
	{
		start();
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void start()
	{
		frame = new JFrame();
    	frame.setSize(1080,600);
    	frame.setTitle("Lel");
        frame.getContentPane().setLayout(null);
        
        
        seek = new Seek();
        buttonSeeker = new JButton();
        buttonSeeker.setText("Press to seek");
        buttonSeeker.setBounds(50,20,200,50);
        buttonSeeker.addActionListener(new ButtonSeekerListener());
        frame.add(buttonSeeker);	
            
 
        delete = new Delete();
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
     
        add = new Add();
       
        addButton = new JButton();
        addButton.setText("Add record");
        addButton.setBounds(30,380,180,50);
        addButton.addActionListener(new AddButtonListener());
        frame.add(addButton);
        
        saveButton = new JButton();
        saveButton.setText("save");
        saveButton.setBounds(320,30,200,50);
        frame.add(saveButton);
        
        loadButton = new JButton();
        loadButton.setText("load");
        loadButton.setBounds(540,30,200,50);
        frame.add(loadButton);
        
        tName = new ArrayList<>();
        tDate = new ArrayList<>();
        sName = new ArrayList<>();
        tWinner = new ArrayList<>();
        tPrise = new ArrayList<>();
        wPrise = new ArrayList<>();
	}
	
	public class ButtonSeekerListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            seek.setVisible(true);
		}
	}
	
	public class ButtonDeleterListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            delete.setVisible(true);
		}
	}
	
	public class AddButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            add.setVisible(true);
		}
	}
	
	public class Button1Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			page = 1;
			currentPage.setText(String.valueOf(page));
		}
	}
	
	public class ButtonLeftListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			page--;
			if (page<1) page=1;
			currentPage.setText(String.valueOf(page));
		}
	}
	
	public class ButtonRightListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			page++;
			if (page > maxPage) page=maxPage;
			currentPage.setText(String.valueOf(page));
		}
	}
	
	public class ButtonStringsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			recOnPage  = Integer.valueOf(textStrings.getText());
            maxPage = fullRecords/recOnPage;
            if (maxPage*recOnPage != fullRecords) maxPage++;
            currentStrings.setText(String.valueOf(recOnPage));
            currentPages.setText(String.valueOf(maxPage));
            currentAllStrings.setText(String.valueOf(fullRecords));
            
		}
	}
	
	public class ButtonEndListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			page = maxPage;
			currentPage.setText(String.valueOf(page));
		}
	}
	
	public static void main(String[] args) {
		Main start = new Main();
    }
}
