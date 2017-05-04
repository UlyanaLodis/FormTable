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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

 class Edit_cpu extends JFrame{
	 
	
	 
	 JTextField  nam, cor, bus;
	 JComboBox comboBox, comboBox1, comboBox2;
	 JButton button1, button2, save, add, delete, deletetask, deleteframe, otchot, addcore, addtask, addframe;
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
	 
	 ///////////////////////
	 String[] taskName = {
				"Task 1", 
				"Task 2",
				"Task 3",
				"Task 4",
				"Task 5",
				"Task 6",
				"Task 7",
				"Task 8"
				};
	
	    int [] nn ={1, 5, 8, 3, 5, 2, 9, 10};
	    int [] nk = {2, 8, 12, 7, 12, 20, 17,24};
	    Task[] t1;
	    TaskSeries [] t2;
	    ////////////////////////////////////
	    
	public Edit_cpu (String name){
		
		/////////////////
		frame = new JFrame(name);
		///////////////
		
		frame.setSize(1000, 500);
        frame.setLocation(100,100);
        //frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
        
		
		ScrollPane sc = new ScrollPane();
        //Создание кнопок и прикрепление иконок
            
		 toolBar = new JToolBar("Панель инструментов");      
        //////////////////////
        otchot=new JButton("Отчёт");
        otchot.setToolTipText("Графики");
        toolBar.add(otchot);
        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.NORTH);
        DDDD AD = new DDDD();
        otchot.addActionListener(AD);
         ///////////////////////////////
        
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new TitledBorder("Core"));
        Box box1 = Box.createHorizontalBox();
		b = new JLabel("Core");
     	box1.add(b);
     	
		headers = new Object[]{"№", "Tasks"};
        Object[][] data = {
       	        { "1", "Core 1"},
       	        { "2", "Core 2"},
       	        { "3", "Core 3"},
       	    };
        
        model = new DefaultTableModel(data, headers);
        books = new JTable(model);
        scroll = new JScrollPane(books);
        books.setGridColor(Color.BLUE);
        Box box2 = Box.createHorizontalBox();
		box2.add(scroll);
		
		/////////////////////////////
		Box boxcore = Box.createHorizontalBox();
		addcore = new JButton("Добавить");
		boxcore.add(addcore);
		addcore.addActionListener(AD);
	    delete = new JButton("Удалить");
	    delete.setToolTipText("Удалить компонент");
	    boxcore.add(delete);
	    ////////////////////////////
		
		Box box3 = Box.createHorizontalBox();
		JButton button1 = new JButton("OK");
		JButton button2 = new JButton("Отмена");
		box3.add(button1);
		box3.add(button2); 
		
		mainBox.add(box1);
		mainBox.add(box2);
		
		//////////////////////
		mainBox.add(boxcore);
		///////////////////////
		
		frame.add(mainBox, BorderLayout.WEST);

		Box mainBoxC = Box.createVerticalBox();
		Box mainBoxC1 = Box.createVerticalBox();
		mainBoxC1.setBorder(new TitledBorder("Task"));
        Box boxC = Box.createHorizontalBox();
		bC = new JLabel("Task");
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
		
		///////////////////////////
		Box boxtask = Box.createHorizontalBox();
		addtask = new JButton("Добавить");
		boxtask.add(addtask); 
		deletetask = new JButton("Удалить");
		deletetask.setToolTipText("Удалить компонент");
		boxtask.add(deletetask);     
		mainBoxC1.add(boxC);
		mainBoxC1.add(boxC1);
		mainBoxC1.add(boxtask);
		mainBoxC.add(mainBoxC1);
		///////////////////////////
		
		frame.add(mainBoxC, BorderLayout.CENTER);
		
		Box mainBoxF = Box.createVerticalBox();
		mainBoxF.setBorder(new TitledBorder("Frame"));
        Box boxF = Box.createHorizontalBox();
		bF = new JLabel("Frame");
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
		
		Box boxframe = Box.createHorizontalBox();
		addframe = new JButton("Добавить");
		boxframe.add(addframe);
		deleteframe = new JButton("Удалить");
		deleteframe.setToolTipText("Удалить компонент");
		boxframe.add(deleteframe);
		            		
		mainBoxF.add(boxF);
		mainBoxF.add(boxF1);
		mainBoxF.add(boxframe);
		mainBoxC.add(mainBoxF);

		
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
		private Date date(int hour) {
	        final Calendar calendar = Calendar.getInstance();
	        calendar.set(2009, Calendar.DECEMBER, 1, hour, 0, 0);
	        return calendar.getTime();
	    }
		public void actionPerformed(ActionEvent ev){
			 
			 /////////////////////////////////////////////////////////////////////////
			 if (ev.getSource() == otchot) {
				 if (books.getSelectedRow() != -1) {
				 TaskSeriesCollection s1 = new TaskSeriesCollection();
				 	t1=new Task [taskName.length];
				 	t2=new TaskSeries [taskName.length];
				 	
				 	
				 for (int k=0; k<taskName.length; k++)
				 {
					    t2[k] = new TaskSeries(taskName[k]);
						t1[k] = new Task(taskName[k], date(1), date(24));
						
						t1[k].addSubtask(new Task("Task", date(nn[k]), date(nk[k])));
						t2[k].add(t1[k]);

				s1.add(t2[k]);
				 }
				 			 								
					JFreeChart jchart = ChartFactory.createGanttChart("Diagram", (String) model.getValueAt(books.getSelectedRow(), 1), "Tasks", s1, true, true, true);
					ChartFrame chartFrm = new ChartFrame("ModEAS diagram",jchart,true);
					chartFrm.setVisible(true);;
					chartFrm.setSize(800,500);
					chartFrm.setLocation(300,100);
					chartFrm.validate();
	            }
				 else
				 {JOptionPane.showMessageDialog(frame, "Вы не выбрали CORE");}
			 }
			 
			 if (ev.getSource() == addcore) {
				 
				 
				 AddCore oop = new AddCore(); 
				 
			 }
			 ///////////////////////////////////////////////////////////////////////////
			 
	}
 }	

}