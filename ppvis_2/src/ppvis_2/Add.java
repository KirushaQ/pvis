package ppvis_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Add extends JFrame {
    JTextField addField1;
    JTextField addField2;
    JTextField addField3;
    JTextField addField4;
    JTextField addField5;
    JButton buttonAdd;
    
    public Add()
    {
        this.setSize(350,500);
        this.setTitle("Add");
        this.getContentPane().setLayout(null);
        
        addField1 = new JTextField();
        addField1.setBounds(50,50,200,30);
        this.add(addField1);
        
        addField2 = new JTextField();
        addField2.setBounds(50,100,200,30);
        this.add(addField2);
        
        addField3 = new JTextField();
        addField3.setBounds(50,150,200,30);
        this.add(addField3);
        
        addField4 = new JTextField();
        addField4.setBounds(50,200,200,30);
        this.add(addField4);
        
        addField5 = new JTextField();
        addField5.setBounds(50,250,200,30);
        this.add(addField5);
        
        buttonAdd = new JButton();
        buttonAdd.setText("Press to add");
        buttonAdd.setBounds(50,300,200,50);
        buttonAdd.addActionListener(new AddListener());
        this.add(buttonAdd);
        
    }
     
	public class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

		}
	}
	
}
