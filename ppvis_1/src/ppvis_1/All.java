package ppvis_1;

import java.awt.event.*;
import javax.swing.*;




public class All
{
	private
	int countBox1=0;
 	Object[] header = {"1 column", "2 column"};
 	Object[][] data = {{null,null},{null,null},{null,null},{null,null},
 			{null,null},{null,null},{null,null},{null,null},{null,null},
 			{null,null},{null,null},{null,null},{null,null},{null,null}};
	JTextField textGroup1, textGroup2, textrButton, textchBox, text_table;
	JFrame frame;
	JButton buttonGroup2Text, buttonGroup2Switch, buttonGroup1,
	        buttonRBgroup, buttonChBgroup, button_table_add,
	        button_table_switch1_2, button_table_switch_2_1;
	ButtonGroup group;
	JRadioButton rButton1, rButton2, rButton3;
	JComboBox comboBox;
	JCheckBox chBox1, chBox2, chBox3;
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
    	
    	textGroup1 = new JTextField();
    	textGroup1.setBounds(50,120,200,20);
    	frame.add(textGroup1);
    	
        buttonGroup2Text = new JButton();
        buttonGroup2Text.setText("Button 1");
        buttonGroup2Text.setBounds(300,120,200,20);
        buttonGroup2Text.addActionListener(new ListenerButtonGroup2Text());
    	frame.add(buttonGroup2Text);
        
        buttonGroup2Switch = new JButton();
        buttonGroup2Switch.setText("Button 2");
        buttonGroup2Switch.setBounds(300,150,200,20);
        buttonGroup2Switch.addActionListener(new ListenerButtonGroup2Switch());
    	frame.add(buttonGroup2Switch);
    	
    	textGroup2 = new JTextField();
    	textGroup2.setBounds(50,20,200,20);
    	frame.add(textGroup2);
    	
        buttonGroup1 = new JButton();
        buttonGroup1.setText("Press to add");
        buttonGroup1.setBounds(50,50,200,20);
        buttonGroup1.addActionListener(new ListenerButtonGroup1());
    	frame.add(buttonGroup1);
    	
    	comboBox = new JComboBox();
    	comboBox.setEditable(true);
        comboBox.setBounds(300,20,200,20);
        frame.add(comboBox);
        
        textrButton = new JTextField();
        textrButton.setBounds(50,220,200,20);
        textrButton.setText("1");
    	frame.add(textrButton);
    	
    	buttonRBgroup = new JButton();
        buttonRBgroup.setText("Press to add");
        buttonRBgroup.setBounds(50,250,200,20);
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
     	textchBox.setBounds(50,300,200,20);
    	frame.add(textchBox);
    	
    	buttonChBgroup = new JButton();
        buttonChBgroup.setText("Press to add");
        buttonChBgroup.setBounds(50,330,200,20);
        buttonChBgroup.addActionListener(new ListenerButtonChBgroup());
     	frame.add(buttonChBgroup);
     	
     	chBox1 = new JCheckBox("1");
     	chBox2 = new JCheckBox("2");
     	chBox3 = new JCheckBox("3");
     	chBox1.setBounds(300,315,40,40);
     	chBox2.setBounds(350,315,40,40);
     	chBox3.setBounds(400,315,40,40);
     	frame.add(chBox1);
     	frame.add(chBox2);
     	frame.add(chBox3);
     	
    	text_table = new JTextField();
    	text_table.setBounds(50,400,200,20);
    	frame.add(text_table);
    	
    	button_table_add = new JButton();
    	button_table_add.setText("Press to add");
    	button_table_add.setBounds(50,430,200,20);
    	button_table_add.addActionListener(
    			new ListenerButton_table_add());
     	frame.add(button_table_add);
     	
    	button_table_switch1_2 = new JButton();
    	button_table_switch1_2.setText("Press to switch 1->2");
    	button_table_switch1_2.setBounds(50,460,200,20);
    	button_table_switch1_2.addActionListener(
    			new ListenerButton_table_switch1_2());
     	frame.add(button_table_switch1_2);
     	
    	button_table_switch_2_1 = new JButton();
    	button_table_switch_2_1.setText("Press to switch 2->1");
    	button_table_switch_2_1.setBounds(50,490,200,20);
    	button_table_switch_2_1.addActionListener(
    			new ListenerButton_table_switch_2_1());
     	frame.add(button_table_switch_2_1);
     	
     	table = new JTable(data,header);
     	table.setBounds(305,405,380,235);
     	scrollPane = new JScrollPane(table);
     	scrollPane.setBounds(300,400,400,245);
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
                	pane.showMessageDialog(frame, "������ ������� ��� ����������");
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
            	pane.showMessageDialog(frame, "������� �������� �� ����������");
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
				pane.showMessageDialog(frame, "������� �������� �� ����������");
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
    
    class ListenerButton_table_switch1_2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	table.setValueAt(table.getValueAt(table.getSelectedRow(), 0),
        			table.getSelectedRow(), 1);
        	table.setValueAt(null, table.getSelectedRow(), 0);
        }
    }
    
    class ListenerButton_table_switch_2_1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	table.setValueAt(table.getValueAt(table.getSelectedRow(), 1),
        			table.getSelectedRow(), 0);
        	table.setValueAt(null, table.getSelectedRow(), 1);
        }
    }

	public static void main(String[] args) {
		All start = new All();
	}
}
