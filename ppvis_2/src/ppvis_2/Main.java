package ppvis_2;

import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ppvis_2.Main.ButtonSeekerListener;

public class Main {

	JFrame frame;
    Add sAdd;
	Seek sSeek;
	Seek sDelete;
    JButton buttonSeeker;  
    JButton buttonDeleter;
    JButton addButton;
    
    JButton saveButton;
    JButton loadButton;
    
	private AppController appController;
	
	Table tab;;
	
    
	public Main(AppController appController)
	{
		this.appController = appController;
		start();
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void update() {
		tab.update();
	}
	
	
	public void start()
	{
		frame = new JFrame();
    	frame.setSize(1080,600);
    	frame.setTitle("Lel");
        frame.getContentPane().setLayout(null);        

        tab = new Table(0,frame,appController);
        
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
	

	
	public static void main(String[] args) {
		Data data = new Data();
		AppController appController = new AppController(data); 
		Main start = new Main(appController);
    }
}
