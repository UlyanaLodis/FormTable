import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.glassfish.jersey.client.ClientConfig;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URI;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

 class Edit_cpu extends JFrame{
	 
	
	 
	 JTextField  nam, cor, bus;
	 JComboBox comboBox, comboBox1, comboBox2;
	 JButton button1, button2, save, add, delete, prosm,prosm1 ;
	 JToolBar toolBar;
	 JFrame frame;
	 JButton ok,cancel;
	 JLabel b,b1, b2, bC, bF;
	 Object headers[],headers1[],headers2[];
	 Object data[][],data1[][],data2[][];
	 private JScrollPane scroll,scroll1,scroll2;
	 private JTable books,books1,books2;
	 private DefaultTableModel model,model1,model2;
	 String bu="", cores="";
	public Edit_cpu (String name){
		frame = new JFrame();
		frame.setSize(1000, 300);
        frame.setLocation(100,100);
        frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
        
		
		ScrollPane sc = new ScrollPane();
        //Создание кнопок и прикрепление иконок
        save = new JButton("Сохранить");
        save.setToolTipText("Сохранить список компонентов");
        toolBar = new JToolBar("Панель инструментов");
        toolBar.add(save);
        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.NORTH);

        add = new JButton("Добавить");
        add.setToolTipText("Добавить компонент");
        toolBar.add(add);
        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.NORTH);

        delete = new JButton("Удалить");
        delete.setToolTipText("Удалить компонент");
        toolBar.add(delete);
        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.NORTH); 
        
        prosm = new JButton("Просмотреть Core");
        prosm.setToolTipText("Просмотреть Core");
        toolBar.add(prosm);
        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.NORTH); 
        prosm1 = new JButton("Просмотреть Task");
        prosm1.setToolTipText("Просмотреть Task");
        toolBar.add(prosm1);
        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.NORTH); 
        DDDD AD = new DDDD();
        prosm.addActionListener(AD);
         
        Box mainBox = Box.createVerticalBox();
        Box box1 = Box.createHorizontalBox();
		b = new JLabel(name);
     	box1.add(b);
     	
		headers = new Object[]{"№", "Tasks"};
        Object[][] data = {
       	        { "1", "Task1"},
       	        { "2", "Task2"},
       	        { "3", "Task3"},
       	    };
        
        model = new DefaultTableModel(data, headers);
        books = new JTable(model);
        scroll = new JScrollPane(books);
        books.setGridColor(Color.BLUE);
        Box box2 = Box.createHorizontalBox();
		box2.add(scroll);
		
		Box box3 = Box.createHorizontalBox();
		JButton button1 = new JButton("OK");
		JButton button2 = new JButton("Отмена");
		box3.add(button1);
		box3.add(button2); 
		
		mainBox.add(box1);
		mainBox.add(box2);
		
		frame.add(mainBox, BorderLayout.WEST);

		Box mainBoxC = Box.createVerticalBox();
        Box boxC = Box.createHorizontalBox();
		bC = new JLabel("Task parametr");
     	boxC.add(bC);
     	headers1 = new Object[]{"№", "Name", "Type", "Offset", "Length", "Period","Frame"};
        Object[][] data1 = {
       	        { "1", "Task1", "","","","",""},
       	        { "2", "Task2", "","","","",""},
       	        { "3", "Task3", "","","","",""},
       	    };
        
        model1 = new DefaultTableModel(data1, headers1);
        books1 = new JTable(model1);
        scroll1 = new JScrollPane(books1);
        books1.setGridColor(Color.BLUE);
        Box boxC1 = Box.createHorizontalBox();
		boxC1.add(scroll1);
		            		
		mainBoxC.add(boxC);
		mainBoxC.add(boxC1);
		frame.add(mainBoxC, BorderLayout.CENTER);
		
		Box mainBoxF = Box.createVerticalBox();
        Box boxF = Box.createHorizontalBox();
		bF = new JLabel("Frame parametr");
     	boxF.add(bF);
     	headers2 = new Object[]{"№", "Name", "Length"};
        Object[][] data2 = {
       	        { "1", "Frame1", ""},
       	        { "2", "Frame2", ""},
       	        { "3", "Frame3", ""},
       	    };
        
        model2 = new DefaultTableModel(data2, headers2);
        books2 = new JTable(model2);
        scroll2 = new JScrollPane(books2);
        books2.setGridColor(Color.BLUE);
        Box boxF1 = Box.createHorizontalBox();
		boxF1.add(scroll2);
		            		
		mainBoxC.add(boxF);
		mainBoxC.add(boxF1);
		mainBoxC.add(box3);
		frame.add(mainBoxF, BorderLayout.EAST);
		
		button1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	           	 frame.setVisible(false);
	             dispose();

	             }

	    });
	     
	     button2.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.setVisible(false);
	             dispose();

	             }

	    });
	        		
}
	class DDDD implements ActionListener {
		public void actionPerformed(ActionEvent ev){
			 if (ev.getSource() == prosm) {
	                
	                if (books.getSelectedRow() != -1) {
	                	//Edit_cpu oop = new Edit_cpu((String) model1.getValueAt(books1.getSelectedRow(), 1));
	                   // oop.setVisible(true);
	                	
	                } else {
	                    JOptionPane.showMessageDialog(frame, "Вы не выбрали Tasks");
	                }
	            }
	}
 }	

}