package table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Main {

	private AppController controller;
	JFrame frame;
	Table table;
	
	//Изменения
	private	ArrayList<AppController> changeList;
	int changeCount = 0;
	JScrollPane scrollPane;
	DefaultTableModel model;
	JTable changeTable;
	Object header[] = {"Изменения"};
	
	JButton changeButton;
	
	//Функции
	JButton addButton;
	Add add;
	 
	JButton deleteButton;
	Delete delete;
	 
	JButton seekButton;
	Seek seek;
	 
	JButton saveButton;
	JButton loadButton;

	public Main(AppController controller){
		this.controller = controller;
		start();
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
	}
	
	public void start()
	{
		frame = new JFrame();
		frame.setSize(1280, 800);
		frame.getContentPane().setLayout(null);   
		table = new Table(frame, controller, this);
		
        
        //Добавление
        addButton = new JButton();
        addButton.setText("Add");
        addButton.setBounds(100,500,200,80);
        addButton.addActionListener(new AddListener());
        frame.add(addButton);
		add = new Add(controller, this);
		
		
		//Удаление
		deleteButton = new JButton();
		deleteButton.setText("Delete");
		deleteButton.setBounds(10,20,200,80);
		deleteButton.addActionListener(new DeleteListener());
        frame.add(deleteButton);
		delete = new Delete(controller, this);
		
		//Поиск
		seekButton = new JButton();
		seekButton.setText("Seek");
		seekButton.setBounds(1050,20,200,80);
		seekButton.addActionListener(new SeekListener());
        frame.add(seekButton);
		seek = new Seek(controller);
		
		changeTable = new JTable();
		scrollPane = new JScrollPane();
		
		changeList = new ArrayList<AppController>();
		changeTable = new JTable(new DefaultTableModel(header,0));
		changeTable.setBounds(25,595,500,100);
		model = (DefaultTableModel) changeTable.getModel();
	    scrollPane = new JScrollPane(changeTable);
	    scrollPane.setBounds(20,600,500,100);
	    frame.add(scrollPane); 
		
	    changeButton = new JButton();
	    changeButton.setText("Press to change");
	    changeButton.setBounds(550,610,200,80);
	    changeButton.addActionListener(new ChangeListener());
        frame.add(changeButton);
        
        
        getChange(this.controller, "Начало");
	}
	
	public void update(){
		table.update();
	}
	
	public void getChange(AppController appController, String change)
	{
		changeCount++;
		AppController changeController = new AppController(1);
		changeController.copy(appController);
		changeList.add(changeController);
		Object changeInf[] = {change};
		model.addRow(changeInf);
	}
	
	public void useChange(int i){
		controller.copy(changeList.get(i));
		getChange(this.controller, "Переход к изменению \"" + 
		changeTable.getValueAt(changeTable.getSelectedRow(), changeTable.getSelectedColumn()) + "\"");
		update();
	}
	
	public class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			add.start();
		}
	}
	
	public class DeleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			delete.start();
		}
	}
	
	public class SeekListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			seek.start();
		}
	}
	
	public class ChangeListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int i;
			i = changeTable.getSelectedRow();
			//changeButton.setText(String.valueOf(i));
			useChange(i);
		}
	}
	
	
	
	public static void main(String[] args) {
		AppController contr = new AppController();
		Main main = new Main(contr);
	}

}
