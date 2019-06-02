package ppvis_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;


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
    
    Table tab;
    
    ArrayList <String> tName = new ArrayList<>();
    ArrayList <LocalDate> tDate = new ArrayList<>(); 
    ArrayList <String> sName = new ArrayList<>();
    ArrayList <String> winnerName = new ArrayList<>();
    ArrayList <String> winnerSName = new ArrayList<>();
    ArrayList <String> winnerFName = new ArrayList<>();
    ArrayList <Integer> tPrise = new ArrayList<>();
    ArrayList <Integer> wPrise = new ArrayList<>();
    
    
    public Seek(AppController appController, Main main, int type)
    {
	
    	this.type = type;
    	this.main = main;
    	this.appController = appController;
    	frame=new JFrame();
    	frame.getContentPane().setLayout(null);
    	
    	if (type == 0) {
    		tab = new Table(1,frame,appController);
    	}
    	
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
    	if (type == 1) {
    		deleteResult.setText(null);
    	}
    	if (type == 0) {
    		tab.clear();
    	}
    	frame.setVisible(true);
    }
    
    public class ButtonSeekStartListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int i;
			tab.clear();
			tName.clear();
			tDate.clear();
			sName.clear();
			winnerName.clear();
			winnerSName.clear();
			winnerFName.clear();
			tPrise.clear();
			wPrise.clear();
			if (rButton1.isSelected()) {
				String tname = textSeeker.getText();
				LocalDate tdate = LocalDate.parse(textSeeker2.getText());
				for (i=0; i<appController.tName.size();i++)
					if(appController.tName.get(i).equals(tname) ||
					   appController.tDate.get(i).equals(tdate)) {
						tName.add(appController.tName.get(i));
						tDate.add(appController.tDate.get(i));
						sName.add(appController.sName.get(i));
						winnerName.add(appController.winnerName.get(i));
						winnerSName.add(appController.winnerSName.get(i));
						winnerFName.add(appController.winnerFName.get(i));
						tPrise.add(appController.tPrise.get(i));
						wPrise.add(appController.wPrise.get(i));
					}
			}
			
			if (rButton2.isSelected()) {
				String sname = textSeeker.getText();
				String winnername = textSeeker2.getText();
				String winnerSname = textSeeker3.getText();
				String winnerFname = textSeeker4.getText();
				for (i=0; i<appController.tName.size();i++)
					if(appController.sName.get(i).equals(sname) ||
					   appController.winnerName.get(i).equals(winnername) ||
					   appController.winnerSName.get(i).equals(winnerSname)||
					   appController.winnerFName.get(i).equals(winnerFname)) {
						tName.add(appController.tName.get(i));
						tDate.add(appController.tDate.get(i));
						sName.add(appController.sName.get(i));
						winnerName.add(appController.winnerName.get(i));
						winnerSName.add(appController.winnerSName.get(i));
						winnerFName.add(appController.winnerFName.get(i));
						tPrise.add(appController.tPrise.get(i));
						wPrise.add(appController.wPrise.get(i));
					}
			}
			
			if (rButton3.isSelected()) {
				int tprise = Integer.valueOf(textSeeker.getText());
				int wprise = Integer.valueOf(textSeeker2.getText());
				for (i=0; i<appController.tName.size();i++)
					if(appController.tPrise.get(i).equals(tprise) ||
					   appController.wPrise.get(i).equals(wprise)) {
						tName.add(appController.tName.get(i));
						tDate.add(appController.tDate.get(i));
						sName.add(appController.sName.get(i));
						winnerName.add(appController.winnerName.get(i));
						winnerSName.add(appController.winnerSName.get(i));
						winnerFName.add(appController.winnerFName.get(i));
						tPrise.add(appController.tPrise.get(i));
						wPrise.add(appController.wPrise.get(i));
					}
			}
			tab.get(tName,tDate,sName,winnerName,winnerSName,winnerFName,tPrise,wPrise);
			tab.update();
		}
	}
    
    public class DeleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int k=0, i;
			
			if (rButton1.isSelected()) {
				String tname = textSeeker.getText();
				LocalDate tdate = LocalDate.parse(textSeeker2.getText());
				for (i=0; i<appController.tName.size();i++)
					if(!appController.tName.get(i).equals(tname) &&
					   !appController.tDate.get(i).equals(tdate)) {
						tName.add(appController.tName.get(i));
						tDate.add(appController.tDate.get(i));
						sName.add(appController.sName.get(i));
						winnerName.add(appController.winnerName.get(i));
						winnerSName.add(appController.winnerSName.get(i));
						winnerFName.add(appController.winnerFName.get(i));
						tPrise.add(appController.tPrise.get(i));
						wPrise.add(appController.wPrise.get(i));
					}
					else {
						k++;
					}
			}
			
			if (rButton2.isSelected()) {
				String sname = textSeeker.getText();
				String winnername = textSeeker2.getText();
				String winnerSname = textSeeker3.getText();
				String winnerFname = textSeeker4.getText();
				for (i=0; i<appController.tName.size();i++)
					if(!appController.sName.get(i).equals(sname) &&
					   !appController.winnerName.get(i).equals(winnername) &&
					   !appController.winnerSName.get(i).equals(winnerSname)&&
					   !appController.winnerFName.get(i).equals(winnerFname)) {
						tName.add(appController.tName.get(i));
						tDate.add(appController.tDate.get(i));
						sName.add(appController.sName.get(i));
						winnerName.add(appController.winnerName.get(i));
						winnerSName.add(appController.winnerSName.get(i));
						winnerFName.add(appController.winnerFName.get(i));
						tPrise.add(appController.tPrise.get(i));
						wPrise.add(appController.wPrise.get(i));
					}
					else {
						k++;
					}
			}
			
			if (rButton3.isSelected()) {
				int tprise = Integer.valueOf(textSeeker.getText());
				int wprise = Integer.valueOf(textSeeker2.getText());
				for (i=0; i<appController.tName.size();i++)
					if(!appController.tPrise.get(i).equals(tprise) &&
					   !appController.wPrise.get(i).equals(wprise)) {
						tName.add(appController.tName.get(i));
						tDate.add(appController.tDate.get(i));
						sName.add(appController.sName.get(i));
						winnerName.add(appController.winnerName.get(i));
						winnerSName.add(appController.winnerSName.get(i));
						winnerFName.add(appController.winnerFName.get(i));
						tPrise.add(appController.tPrise.get(i));
						wPrise.add(appController.wPrise.get(i));
					}
					else {
						k++;
					}
			}
			
			appController.tName=tName;
			appController.tDate=tDate;
			appController.sName=sName;
			appController.winnerName=winnerName;
			appController.winnerSName=winnerSName;
			appController.winnerFName=winnerFName;
			appController.tPrise=tPrise;
			appController.wPrise=wPrise;
			
			deleteResult.setText("Было удалено "+k+" записей!");
			
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
  	   deleteResult.setText(null);
  		}
  	}
    
    public class Buttonr2Listener implements ActionListener{
  		public void actionPerformed(ActionEvent e) {
  			if (type == 1) {
  	            textSeeker.setBounds(250,50,200,30);
  	            textSeeker2.setBounds(250,100,200,30);
  	            textSeeker3.setBounds(250,150,200,30);
  	            textSeeker4.setBounds(250,200,200,30);
 		  	    deleteResult.setText(null);
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
 	  	  	     deleteResult.setText(null);
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
    
}
