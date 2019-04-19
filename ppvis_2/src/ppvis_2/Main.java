package ppvis_2;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Main {

	Object[] header = {"Название турнира", "Дата проведения", "Название вида спорта",
			"ФИО победителя", "Размеры призовых", "Заработок победителя"};
 	Object[][] data = {{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null}};
	
	JFrame frame;
	ButtonGroup group;
	JRadioButton rButton1;
	JRadioButton rButton2;
    JRadioButton rButton3;
    JRadioButton rButton4;
    JRadioButton rButton5;
    JButton buttonSeeker;
    
	ButtonGroup group2;
	JRadioButton rdButton1;
	JRadioButton rdButton2;
    JRadioButton rdButton3;
    JRadioButton rdButton4;
    JRadioButton rdButton5;
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
 
      /*  rButton1 = new JRadioButton("1",true);
     	rButton2 = new JRadioButton("2");
     	rButton3 = new JRadioButton("3");
     	rButton4 = new JRadioButton("4");
     	rButton5 = new JRadioButton("5");
     	group = new ButtonGroup();
     	rButton1.setBounds(20,10,40,40);
     	rButton2.setBounds(20,60,40,40);
     	rButton3.setBounds(20,110,40,40);
     	rButton4.setBounds(20,160,40,40);
     	rButton5.setBounds(20,210,40,40);
     	group.add(rButton1);
     	group.add(rButton2);
     	group.add(rButton3);
     	group.add(rButton4);
     	group.add(rButton5);
     	frame.add(rButton1);
     	frame.add(rButton2);
        frame.add(rButton3);
        frame.add(rButton4);
        frame.add(rButton5);*/
        
        buttonSeeker = new JButton();
        buttonSeeker.setText("Press to seek");
        buttonSeeker.setBounds(50,20,200,50);
        frame.add(buttonSeeker);
        
        
       /* rdButton1 = new JRadioButton("1",true);
     	rdButton2 = new JRadioButton("2");
     	rdButton3 = new JRadioButton("3");
     	rdButton4 = new JRadioButton("4");
     	rdButton5 = new JRadioButton("5");
     	group2 = new ButtonGroup();
     	rdButton1.setBounds(450,50,40,40);
     	rdButton2.setBounds(500,50,40,40);
     	rdButton3.setBounds(550,50,40,40);
     	rdButton4.setBounds(600,50,40,40);
     	rdButton5.setBounds(650,50,40,40);
     	group2.add(rdButton1);
     	group2.add(rdButton2);
     	group2.add(rdButton3);
     	group2.add(rdButton4);
     	group2.add(rdButton5);
     	frame.add(rdButton1);
     	frame.add(rdButton2);
        frame.add(rdButton3);
        frame.add(rdButton4);
        frame.add(rdButton5);*/
        
        buttonDeleter = new JButton();
        buttonDeleter.setText("Press to delete");
        buttonDeleter.setBounds(800,20,200,50);
        frame.add(buttonDeleter);
        
    	table = new JTable(data,header);
     	table.setBounds(25,130,1000,180);
     	scrollPane = new JScrollPane(table);
     	scrollPane.setBounds(20,125,1005,183);
        frame.add(scrollPane);
        
        button1 = new JButton();
        button1.setText("1");
        button1.setBounds(250,380,50,50);
        frame.add(button1);
        
        buttonLeft = new JButton();
        buttonLeft.setText("<<");
        buttonLeft.setBounds(350,380,50,50);
        frame.add(buttonLeft);
        
        buttonRight = new JButton();
        buttonRight.setText(">>");
        buttonRight.setBounds(550,380,50,50);
        frame.add(buttonRight);
        
        buttonEnd = new JButton();
        buttonEnd.setText("5");
        buttonEnd.setBounds(650,380,50,50);
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
	}
	
	public static void main(String[] args) {
		Main start = new Main();
    }
}
