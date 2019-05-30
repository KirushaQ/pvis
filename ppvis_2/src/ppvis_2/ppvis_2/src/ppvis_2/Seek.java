package ppvis_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ppvis_2.Main.Button1Listener;
import ppvis_2.Main.ButtonDeleterListener;
import ppvis_2.Main.ButtonEndListener;
import ppvis_2.Main.ButtonLeftListener;
import ppvis_2.Main.ButtonRightListener;
import ppvis_2.Main.ButtonSeekerListener;
import ppvis_2.Main.ButtonStringsListener;

public class Seek {
	JFrame frame;
	ButtonGroup group;
	JRadioButton rButton1;
	JRadioButton rButton2;
    JRadioButton rButton3;
    JTextField textSeeker;
    JTextField textSeeker2;
    JTextField textSeeker3;
    JTextField textSeeker4;
    JButton buttonSeekStart;
    JComboBox seekBox;
    JButton deleteResult;
    private AppController appController;
    private Main main;
    int type;
    
    //table
	Object[] header = {"Название турнира", "Дата проведения", "Название вида спорта",
			"ФИО победителя", "Размеры призовых", "Заработок победителя"};
 	Object[][] data = {{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null},
 			{null,null,null,null,null,null},{null,null,null,null,null,null}};

 
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
    
	int page;
	int maxPage;
	int recOnPage;
	int fullRecords;
    
    
    public Seek(AppController appController, Main main, int type)
    {
    	this.page = appController.page;
    	this.maxPage = appController.maxPage;
    	this.recOnPage = appController.recOnPage;
    	this.fullRecords = appController.fullRecords;
    	
    	this.type = type;
    	this.main = main;
    	this.appController = appController;
    	frame=new JFrame();
    	frame.getContentPane().setLayout(null);
    	
        rButton1 = new JRadioButton("По турниру или дате",true);
     	rButton2 = new JRadioButton("По спорту или ФИО");
     	rButton3 = new JRadioButton("По призовым или заработку");
     	group = new ButtonGroup();

     	rButton1.addActionListener(new Buttonr1Listener());
     	rButton2.addActionListener(new Buttonr2Listener());
     	rButton3.addActionListener(new Buttonr3Listener());
     	group.add(rButton1);
     	group.add(rButton2);
     	group.add(rButton3);
     	frame.add(rButton1);
     	frame.add(rButton2);
     	frame.add(rButton3);
        
            textSeeker = new JTextField("Турнир");
            frame.add(textSeeker);     
            textSeeker2 = new JTextField("Дата");
            frame.add(textSeeker2);       
            textSeeker3 = new JTextField();
            frame.add(textSeeker3);       
            textSeeker4 = new JTextField();
            frame.add(textSeeker4);
            
       
        buttonSeekStart = new JButton();
        frame.add(buttonSeekStart);
        
        if (type == 0) {
    		frame.setSize(1080,600);
    		frame.setTitle("Seek");
    		
     		rButton1.setBounds(20,0,180,40);
     	    rButton2.setBounds(210,0,180,40);
     	    rButton3.setBounds(400,0,200,40);
     	    
	    	textSeeker.setBounds(20,50,200,30);
	        textSeeker2.setBounds(230,50,200,30);
	        textSeeker3.setBounds(0,0,0,0);
	        textSeeker4.setBounds(0,0,0,0);
	        
        	buttonSeekStart.setText("Press to seek");
            buttonSeekStart.setBounds(30,380,180,50);
            
           	buttonSeekStart.addActionListener(new ButtonSeekStartListener());
           	
           	//table
           	
            
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
        }
        
        if (type == 1) {
       		frame.setSize(500,500);
    		frame.setTitle("Delete");
    		
     		rButton1.setBounds(20,10,200,40);
     	    rButton2.setBounds(20,80,200,40);
     	    rButton3.setBounds(20,150,200,40);
     	    
            textSeeker.setBounds(250,50,200,30);
            textSeeker2.setBounds(250,100,200,30);
            textSeeker3.setBounds(0,0,0,0);
            textSeeker4.setBounds(0,0,0,0);
            
        	buttonSeekStart.setText("Press to delete");
            buttonSeekStart.setBounds(250,250,200,50);
            
        	buttonSeekStart.addActionListener(new DeleteListener());
        	
            deleteResult = new JButton();
            deleteResult.setBounds(50,350,400,50);
            frame.add(deleteResult);
        }
    }
    
    public void start()
    {
    	frame.setVisible(true);
    }
    
    public class ButtonSeekStartListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//собрать параметры
			//вызвать операцию у контроллера с параметрами
			//отобразить результат который вернул контроллер
		}
	}
    
    public class DeleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			appController.fullRecords--;
			main.update();
		}
	}
    
    public class Buttonr1Listener implements ActionListener{
  		public void actionPerformed(ActionEvent e) {
  	       if (type == 1) {
  	    	   textSeeker.setBounds(250,50,200,30);
  	           textSeeker2.setBounds(250,100,200,30);
  	           textSeeker3.setBounds(0,0,0,0);
  	           textSeeker4.setBounds(0,0,0,0);
  	       }
  	     if (type == 0) {
  	    	 textSeeker.setBounds(20,50,200,30);
	         textSeeker2.setBounds(230,50,200,30);
	         textSeeker3.setBounds(0,0,0,0);
	         textSeeker4.setBounds(0,0,0,0);
  	     }
  	   textSeeker.setText("Турнир");
  	   textSeeker2.setText("Дата");
  		}
  	}
    
    public class Buttonr2Listener implements ActionListener{
  		public void actionPerformed(ActionEvent e) {
  			if (type == 1) {
  	            textSeeker.setBounds(250,50,200,30);
  	            textSeeker2.setBounds(250,100,200,30);
  	            textSeeker3.setBounds(250,150,200,30);
  	            textSeeker4.setBounds(250,200,200,30);
  			}
  	  	     if (type == 0) {
  	  	    	 textSeeker.setBounds(20,50,200,30);
  		         textSeeker2.setBounds(230,50,200,30);
  		         textSeeker3.setBounds(440,50,200,30);
  		         textSeeker4.setBounds(650,50,200,30);
  	  	     }
  	  	   textSeeker.setText("Название спорта");
  	  	   textSeeker2.setText("Имя");
  	  	   textSeeker3.setText("Фамилия");
  	  	   textSeeker4.setText("Отчество");
  		}
  	}
    
    public class Buttonr3Listener implements ActionListener{
  		public void actionPerformed(ActionEvent e) {
  			if (type == 1) {
  	            textSeeker.setBounds(250,50,200,30);
  	            textSeeker2.setBounds(250,100,200,30);
  	            textSeeker3.setBounds(0,0,0,0);
  	            textSeeker4.setBounds(0,0,0,0);
  			}
  	  	     if (type == 0) {
  	  	    	 textSeeker.setBounds(20,50,200,30);
  		         textSeeker2.setBounds(230,50,200,30);
  		         textSeeker3.setBounds(0,0,0,0);
  		         textSeeker4.setBounds(0,0,0,0);
  	  	     }
  	  	   textSeeker.setText("Призовые");
  	  	   textSeeker2.setText("Заработок");
  		}
  	}
    
    //table
    
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
			if (page>maxPage) page=maxPage;
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
            buttonEnd.setText(String.valueOf(maxPage));
            
		}
	}
	
	public class ButtonEndListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			page = maxPage;
			currentPage.setText(String.valueOf(page));
		}
	}
    
}
