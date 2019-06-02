package ppvis_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    
    
    
    public Seek(AppController appController, Main main, int type)
    {
	
    	this.type = type;
    	this.main = main;
    	this.appController = appController;
    	frame=new JFrame();
    	frame.getContentPane().setLayout(null);
    	
    	tab = new Table(1,frame,appController);
    	
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
    
}
