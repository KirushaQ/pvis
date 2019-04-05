package ppvis_1;

import java.awt.event.*;
import javax.swing.*;

public class All
{
	int countBox1=0;
	Object[] header = {"column 1", "column 2"};
 	Object[][] data = {{null,null},{null,null},{null,null},{null,null},
 			{null,null},{null,null},{null,null},{null,null},{null,null},
 			{null,null},{null,null},{null,null},{null,null},{null,null}};
	JFrame frame;
	JTextField textGroup1;
	JTextField textGroup2;
	JTextField textrButton;
	JTextField textchBox;
	JTextField text_table;
	JButton buttonGroup2Text;
	JButton buttonGroup2Switch;
	JButton buttonGroup1;
	JButton buttonRBgroup;
	JButton buttonChBgroup;
	JButton button_table_add;
	JButton button_table_switch_1_2;
	JButton button_table_switch_2_1;
	ButtonGroup group;
	JRadioButton rButton1;
	JRadioButton rButton2;
	JRadioButton rButton3;
	JComboBox comboBox;
	JCheckBox chBox1;
	JCheckBox chBox2;
	JCheckBox chBox3;
	JOptionPane pane;
	JTable table;
	JScrollPane scrollPane;
    public All()
    {
    	start();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void start()
    {
    	frame = new JFrame();
    	frame.setSize(1080,900);
    	frame.setTitle("Lel");
    	frame.getContentPane().setLayout(null);
    	
    	pane = new JOptionPane();
    	
    	
    	textGroup2 = new JTextField("text");
    	textGroup2.setBounds(50,20,200,20);
    	frame.add(textGroup2);
    	
        buttonGroup1 = new RoundButton();
        buttonGroup1.setText("Press");
        buttonGroup1.setBounds(100,45,75,75);
        buttonGroup1.addActionListener(new ListenerButtonGroup1());
    	frame.add(buttonGroup1);
    	
	    comboBox = new JComboBox();
	    comboBox.setEditable(true);
        comboBox.setBounds(300,20,200,20);
        frame.add(comboBox);
    	
    	textGroup1 = new JTextField();
    	textGroup1.setBounds(50,150,200,20);
    	frame.add(textGroup1);
        
        buttonGroup2Text = new RoundButton();
        buttonGroup2Text.setText("Add");
        buttonGroup2Text.setBounds(300,120,75,75);
        buttonGroup2Text.addActionListener(new ListenerButtonGroup2Text());
    	frame.add(buttonGroup2Text);
        
        buttonGroup2Switch = new RoundButton();
        buttonGroup2Switch.setText("Switch");
        buttonGroup2Switch.setBounds(400,120,75,75);
        buttonGroup2Switch.addActionListener(new ListenerButtonGroup2Switch());
    	frame.add(buttonGroup2Switch);
        
        textrButton = new JTextField();
        textrButton.setBounds(50,220,200,20);
        textrButton.setText("1");
    	frame.add(textrButton);
    	
    	buttonRBgroup = new RoundButton();
        buttonRBgroup.setText("Press to add");
        buttonRBgroup.setBounds(100,250,75,75);
        buttonRBgroup.addActionListener(new ListenerButtonRBgroup());
     	frame.add(buttonRBgroup);
     	
     	rButton1 = new JRadioButton("1",true);
     	rButton2 = new JRadioButton("2");
     	rButton3 = new JRadioButton("3");
     	group = new ButtonGroup();
     	rButton1.setBounds(300,235,40,40);
     	rButton2.setBounds(350,235,40,40);
     	rButton3.setBounds(400,235,40,40);
     	group.add(rButton1);
     	group.add(rButton2);
     	group.add(rButton3);
     	frame.add(rButton1);
     	frame.add(rButton2);
     	frame.add(rButton3);
     	
     	textchBox = new JTextField();
     	textchBox.setBounds(50,350,200,20);
    	frame.add(textchBox);
    	
    	buttonChBgroup = new RoundButton();
        buttonChBgroup.setText("Add");
        buttonChBgroup.setBounds(100,375,75,75);
        buttonChBgroup.addActionListener(new ListenerButtonChBgroup());
     	frame.add(buttonChBgroup);
     	
     	chBox1 = new JCheckBox("1");
     	chBox2 = new JCheckBox("2");
     	chBox3 = new JCheckBox("3");
     	chBox1.setBounds(300,350,40,40);
     	chBox2.setBounds(350,350,40,40);
     	chBox3.setBounds(400,350,40,40);
     	frame.add(chBox1);
     	frame.add(chBox2);
     	frame.add(chBox3);
     	
    	text_table = new JTextField();
    	text_table.setBounds(50,475,200,20);
    	frame.add(text_table);
    	
    	button_table_add = new RoundButton();
    	button_table_add.setText("Add");
    	button_table_add.setBounds(50,500,75,75);
    	button_table_add.addActionListener(
    			new ListenerButton_table_add());
     	frame.add(button_table_add);
     	
    	button_table_switch_1_2 = new RoundButton();
    	button_table_switch_1_2.setText("1->2");
    	button_table_switch_1_2.setBounds(50,590,75,75);
    	button_table_switch_1_2.addActionListener(
    			new Listenerbutton_table_switch_1_2());
     	frame.add(button_table_switch_1_2);
     	
    	button_table_switch_2_1 = new RoundButton();
    	button_table_switch_2_1.setText("2->1");
    	button_table_switch_2_1.setBounds(150,590,75,75);
    	button_table_switch_2_1.addActionListener(
    			new ListenerButton_table_switch_2_1());
     	frame.add(button_table_switch_2_1);
     	
     	table = new JTable(data,header);
     	table.setBounds(305,480,380,235);
     	scrollPane = new JScrollPane(table);
     	scrollPane.setBounds(300,475,400,245);
     	frame.add(scrollPane);
    }
    
    class ListenerButtonGroup2Text implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	buttonGroup2Switch.setText(textGroup1.getText());
        }
    }
    
    class ListenerButtonGroup2Switch implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String s=buttonGroup2Text.getText();
        	buttonGroup2Text.setText(buttonGroup2Switch.getText());
        	buttonGroup2Switch.setText(s);
        }
    }
    
    class ListenerButtonGroup1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           if (countBox1==0) {
        	   comboBox.addItem(textGroup2.getText());
           } else {
        	   int c=0;
        	   for (int i=0; i<countBox1; i++)
        	   {
        		   comboBox.setSelectedIndex(i);
        		 if (textGroup2.getText().contentEquals((String)
        		     comboBox.getSelectedItem())) {
        		    c++; break;
        		 } 
        	   }
                if (c==0) {
                	comboBox.addItem(textGroup2.getText());
                } else {
                	pane.showMessageDialog(frame, "Данный элемент уже существует","Ошибка",2);
                    countBox1--;
                }
           }
           comboBox.setSelectedIndex(0);
           countBox1++;
        }
    }
    
    class ListenerButtonRBgroup implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s=textrButton.getText();
            int i=0;
            if (s.contentEquals(rButton1.getText())) {
            	rButton1.setSelected(true); i++;
            	}
            if (s.contentEquals(rButton2.getText())) {
            	rButton2.setSelected(true); i++;
            	}
            if (s.contentEquals(rButton3.getText())) {
            	rButton3.setSelected(true); i++;
            	}     
            if (i==0) {
            	pane.showMessageDialog(frame, "Данного элемента не существует","Ошибка",2);
            }
        }
    }

	class ListenerButtonChBgroup implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = textchBox.getText();
			int i = 0;
			if (s.contentEquals(chBox1.getText())) {
				chBox1.setSelected(!chBox1.isSelected());
				i++;
			}
			if (s.contentEquals(chBox2.getText())) {
				chBox2.setSelected(!chBox2.isSelected());
				i++;
			}
			if (s.contentEquals(chBox3.getText())) {
				chBox3.setSelected(!chBox3.isSelected());
				i++;
			}
			if (i == 0) {
				pane.showMessageDialog(frame, "Данного элемента не существует","Ошибка",2);
			}
		}
	}

    class ListenerButton_table_add implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	int i=0;
        	while (i<15)
        	{
        		if (table.getValueAt(i, 0)==null
        			&& table.getValueAt(i, 1)==null) {
        			table.setValueAt(text_table.getText(), i, 0); break;
        		} else {
        			i++;
        		}
        	}
        }
    }
    
    class Listenerbutton_table_switch_1_2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if (table.getValueAt(table.getSelectedRow(), 0)!=null) {
        	table.setValueAt(table.getValueAt(table.getSelectedRow(), 0),
        			table.getSelectedRow(), 1);
        	table.setValueAt(null, table.getSelectedRow(), 0);
        	}
        }
    }
    
    class ListenerButton_table_switch_2_1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if (table.getValueAt(table.getSelectedRow(), 1)!=null) {
        	table.setValueAt(table.getValueAt(table.getSelectedRow(), 1),
        			table.getSelectedRow(), 0);
        	table.setValueAt(null, table.getSelectedRow(), 1);
        	}
        }
    }
    
	public static void main(String[] args) {
		All start = new All();
	}
}
