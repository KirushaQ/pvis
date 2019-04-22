package ppvis_2;

import java.awt.event.*;
import javax.swing.*;

public class Main {

	Object[] header = {"Название турнира", "Дата проведения", "Название вида спорта",
			"ФИО победителя", "Размеры призовых", "Заработок победителя"};
 	Object[][] data = {{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null}};
 	int page = 1;
 	int maxPage = 5;
	
	JFrame frame;
	JFrame frameSeek;
	ButtonGroup group;
	JRadioButton rButton1;
	JRadioButton rButton2;
    JRadioButton rButton3;
    JRadioButton rButton4;
    JRadioButton rButton5;
    JButton buttonSeeker;
    JTextField textSeeker;
    JTextField textSeeker2;
    JTextField textSeeker3;
    JButton buttonSeekStart;
    JComboBox seekBox;
    
	JFrame frameDelete;
	ButtonGroup group2;
	JRadioButton rdButton1;
	JRadioButton rdButton2;
    JRadioButton rdButton3;
    JRadioButton rdButton4;
    JRadioButton rdButton5;
    JButton buttonDeleter;
    JTextField textDeleter;
    JTextField textDeleter2;
    JTextField textDeleter3;
    JButton buttonDeleteStart;
    JButton deleteResult;
    
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
    JFrame frameAdd;
    JTextField addField1;
    JTextField addField2;
    JTextField addField3;
    JTextField addField4;
    JTextField addField5;
    JButton buttonAdd;
    
    
    JButton saveButton;
    JButton loadButton;
    
    JTable table;
    JScrollPane scrollPane;
    
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
 
        frameSeek = new JFrame();
        frameSeek.setSize(500,500);
        frameSeek.setTitle("Seek");
        frameSeek.getContentPane().setLayout(null);
        rButton1 = new JRadioButton("По турниру",true);
     	rButton2 = new JRadioButton("По дате");
     	rButton3 = new JRadioButton("По виду спорта");
     	rButton4 = new JRadioButton("По Фио");
     	rButton5 = new JRadioButton("По призовым");
     	group = new ButtonGroup();
     	rButton1.setBounds(20,10,200,40);
     	rButton2.setBounds(20,80,200,40);
     	rButton3.setBounds(20,150,200,40);
     	rButton4.setBounds(20,220,200,40);
     	rButton5.setBounds(20,290,200,40);
     	group.add(rButton1);
     	group.add(rButton2);
     	group.add(rButton3);
     	group.add(rButton4);
     	group.add(rButton5);
     	frameSeek.add(rButton1);
     	frameSeek.add(rButton2);
        frameSeek.add(rButton3);
        frameSeek.add(rButton4);
        frameSeek.add(rButton5);
        
        textSeeker = new JTextField();
        textSeeker.setBounds(250,50,200,30);
        frameSeek.add(textSeeker);
        
        textSeeker2 = new JTextField();
        textSeeker2.setBounds(250,100,200,30);
        frameSeek.add(textSeeker2);
        
        textSeeker3 = new JTextField();
        textSeeker3.setBounds(250,150,200,30);
        frameSeek.add(textSeeker3);
        
        buttonSeekStart = new JButton();
        buttonSeekStart.setText("Press to seek");
        buttonSeekStart.setBounds(250,200,200,50);
        frameSeek.add(buttonSeekStart);
        
        seekBox = new JComboBox();
        seekBox.setBounds(50,350,400,50);
        seekBox.setEditable(true);
        frameSeek.add(seekBox);
        
        buttonSeeker = new JButton();
        buttonSeeker.setText("Press to seek");
        buttonSeeker.setBounds(50,20,200,50);
        buttonSeeker.addActionListener(new ButtonSeekerListener());
        frame.add(buttonSeeker);
        
        
        
        frameDelete = new JFrame();
        frameDelete.setSize(500,500);
        frameDelete.setTitle("Delete");
        frameDelete.getContentPane().setLayout(null);
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
     	frameDelete.add(rdButton1);
     	frameDelete.add(rdButton2);
        frameDelete.add(rdButton3);
        frameDelete.add(rdButton4);
        frameDelete.add(rdButton5);
        
        textDeleter = new JTextField();
        textDeleter.setBounds(250,50,200,30);
        frameDelete.add(textDeleter);
        
        textDeleter2 = new JTextField();
        textDeleter2.setBounds(250,100,200,30);
        frameDelete.add(textDeleter2);
        
        textDeleter3 = new JTextField();
        textDeleter3.setBounds(250,150,200,30);
        frameDelete.add(textDeleter3);
        
        buttonDeleteStart = new JButton();
        buttonDeleteStart.setText("Press to delete");
        buttonDeleteStart.setBounds(250,200,200,50);
        frameDelete.add(buttonDeleteStart);
        
        deleteResult = new JButton();
        deleteResult.setBounds(50,350,400,50);
        frameDelete.add(deleteResult);
        
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
        frame.add( currentPages);
        
        textStrings = new JTextField();
        textStrings.setBounds(250,450,200,50);
        frame.add(textStrings);
        
        buttonStrings = new JButton();
        buttonStrings.setText("Change records amount");
        buttonStrings.setBounds(500,450,200,50);
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
     
        
        frameAdd = new JFrame();
        frameAdd.setSize(350,500);
        frameAdd.setTitle("Add");
        frameAdd.getContentPane().setLayout(null);
        
        addButton = new JButton();
        addButton.setText("Add record");
        addButton.setBounds(30,380,180,50);
        addButton.addActionListener(new AddButtonListener());
        frame.add(addButton);
        
        addField1 = new JTextField();
        addField1.setBounds(50,50,200,30);
        frameAdd.add(addField1);
        
        addField2 = new JTextField();
        addField2.setBounds(50,100,200,30);
        frameAdd.add(addField2);
        
        addField3 = new JTextField();
        addField3.setBounds(50,150,200,30);
        frameAdd.add(addField3);
        
        addField4 = new JTextField();
        addField4.setBounds(50,200,200,30);
        frameAdd.add(addField4);
        
        addField5 = new JTextField();
        addField5.setBounds(50,250,200,30);
        frameAdd.add(addField5);
        
        buttonAdd = new JButton();
        buttonAdd.setText("Press to add");
        buttonAdd.setBounds(50,300,200,50);
        frameAdd.add(buttonAdd);
        
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
            frameSeek.setVisible(true);
		}
	}
	
	public class ButtonDeleterListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            frameDelete.setVisible(true);
		}
	}
	
	public class AddButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            frameAdd.setVisible(true);
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
