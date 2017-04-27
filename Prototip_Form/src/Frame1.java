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
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.DefaultIntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.ui.RefineryUtilities;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Frame1 {
 
	public static void main(String[] args) {

					Login window = new Login();
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
	class Frame extends JFrame{

		JComboBox comboBox;
		 private JFrame frame, frame1;
		    private DefaultTableModel model,model1;
		    private JButton save, open, add, delete, pac, otchot;
		    private JToolBar toolBar;
		    private JScrollPane scroll,scroll1;
		    private JTable books,books1;
		    private JComboBox author;
		    private JTextField bookName;
		    private JButton filter;
		    private JLabel sortingLabel;
		    String elements[];
		    Object headers[],headers1[];
		    Object data[][],data1[][];
		    String sorting[];
		    String str = new String("");
		    JLabel b,b1, b2;
		    org.w3c.dom.Document doc;
		public Frame() {
		 frame = new JFrame();
		frame.setSize(1000, 300);
        frame.setLocation(100,100);
        frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
        
		
		 ScrollPane sc = new ScrollPane();
        //�������� ������ � ������������ ������
        save = new JButton("���������");
        save.setToolTipText("��������� ������ �����������");
        toolBar = new JToolBar("������ ������������");
        toolBar.add(save);
        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.NORTH);

        open = new JButton("���������");
        open.setToolTipText("��������� � ��");
        toolBar.add(open);
        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.NORTH);

        add = new JButton("��������");
        add.setToolTipText("�������� ���������");
        toolBar.add(add);
        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.NORTH);

        delete = new JButton("�������");
        delete.setToolTipText("������� ���������");
        toolBar.add(delete);
        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.NORTH);
     
         pac = new JButton("�����������");
         pac.setToolTipText("�������� � �����������");
         toolBar.add(pac);
         frame.setLayout(new BorderLayout());
         frame.add(toolBar, BorderLayout.NORTH);
        
         otchot=new JButton("�����");
         otchot.setToolTipText("�������");
         toolBar.add(otchot);
         frame.setLayout(new BorderLayout());
         frame.add(toolBar, BorderLayout.NORTH);
          
         Box mainBox = Box.createVerticalBox();
         Box box1 = Box.createHorizontalBox();
 		 b = new JLabel("BUS Parameter");
      	 box1.add(b);
 		 headers = new Object[]{"�", "Name", "Speed"};
         Object[][] data = {
        	        { "1", "Bus1", "6.2 mk" },
        	        { "2", "Bus2", "6.1 mk" },
        	        { "3", "Bus3", "5.0 mk" },
        	    };
         
         model = new DefaultTableModel(data, headers);
         books = new JTable(model);
         scroll = new JScrollPane(books);
         books.setGridColor(Color.BLUE);
         Box box2 = Box.createHorizontalBox();
 		 box2.add(scroll);
 		 mainBox.add(box1);
		 mainBox.add(box2);
		 frame.add(mainBox, BorderLayout.EAST);
		 books.setCellSelectionEnabled(false);
		 Box mainBox1 = Box.createVerticalBox();
         Box box3 = Box.createHorizontalBox();
 		 b1 = new JLabel("ECU Parameter");
      	 box3.add(b1);
         headers1 = new Object[]{"�", "Name"};
         Object[][] data1 = {
        	        { "1", "ECU1" },
        	        { "2", "ECU2" },
        	        { "3", "ECU3" },
        	        { "4", "ECU4" },
        	        { "5", "ECU5" },
        	        { "6", "ECU6", },
        	        { "7", "ECU7"},
        	        { "8", "ECU8" },
        	    };

         model1 = new DefaultTableModel(data1, headers1);
         books1 = new JTable(model1);
         scroll1 = new JScrollPane(books1);
         books1.setGridColor(Color.BLUE);
         //���������� ������� � �������
         Box box4 = Box.createHorizontalBox();
 		 box4.add(scroll1);
 		 mainBox1.add(box3);
		 mainBox1.add(box4);
		 frame.add(mainBox1, BorderLayout.WEST);
		 
		 
         JPanel panel = new JPanel();
         frame.add(panel, BorderLayout.CENTER);
         String[] elements = new String[] {"System1", "System2", "System3"};
         comboBox = new JComboBox(elements);
         comboBox.setBounds(149, 31, 111, 39);
         comboBox.setAlignmentX(LEFT_ALIGNMENT);
         panel.add(comboBox,BorderLayout.CENTER); 
         DDDD AD = new DDDD();
         pac.addActionListener(AD);
         otchot.addActionListener(AD);

		 }


	class DDDD implements ActionListener {
		 private Date date(final int day, final int month, final int year) {

		        final Calendar calendar = Calendar.getInstance();
		        calendar.set(year, month, day);
		        final Date result = calendar.getTime();
		        return result;

		    }
		 private Date date(int hour) {
		        final Calendar calendar = Calendar.getInstance();
		        calendar.set(2009, Calendar.DECEMBER, 1, hour, 0, 0);
		        return calendar.getTime();
		    }
		public void actionPerformed(ActionEvent ev){
			 if (ev.getSource() == pac) {
	                
	                if (books1.getSelectedRow() != -1) {
	                	Edit_cpu oop = new Edit_cpu((String) model1.getValueAt(books1.getSelectedRow(), 1));
	                   // oop.setVisible(true);
	                } else {
	                    JOptionPane.showMessageDialog(frame, "�� �� ������� ECU");
	                }
	            }
			 if (ev.getSource() == otchot) {
				
				 //DefaultIntervalCategoryDataset s1 = new DefaultIntervalCategoryDataset();*/
					TaskSeriesCollection s1 = new TaskSeriesCollection();
					TaskSeries d1 = new TaskSeries("Task 1");
					Task t1 = new Task("Core1", date(1), date(24));
					t1.addSubtask(new Task("Task1", date(3), date(5)));
					t1.addSubtask(new Task("Task2", date(6), date(9)));
					d1.add(t1);
					Task t2 = new Task("Core2", date(1), date(24));
					t2.addSubtask(new Task("Task1", date(4), date(7)));
					t2.addSubtask(new Task("Task2", date(8), date(12)));
					d1.add(t2);
					Task t3 = new Task("Core3", date(1), date(24));
					t3.addSubtask(new Task("Task1", date(9), date(11)));
					t3.addSubtask(new Task("Task2", date(10), date(12)));
					d1.add(t3);
					Task tg = new Task("Core4", date(1), date(24));
					tg.addSubtask(new Task("Task1", date(16), date(17)));
					tg.addSubtask(new Task("Task2", date(18), date(19)));
					d1.add(tg);
					Task tk = new Task("Core5", date(1), date(24));
					tk.addSubtask(new Task("Task1", date(2), date(3)));
					tk.addSubtask(new Task("Task2", date(4), date(8)));
					d1.add(tk);
					s1.add(d1);
					
					TaskSeries d2 = new TaskSeries("Task2");
					Task t4 = new Task("Core1", date(1), date(24));
					t4.addSubtask(new Task("Task1", date(1), date(5)));
					t4.addSubtask(new Task("Task2", date(22), date(23)));
					d2.add(t4);
					Task t5 = new Task("Core2", date(1), date(24));
					t5.addSubtask(new Task("Task1", date(7), date(12)));
					t5.addSubtask(new Task("Task2", date(0), date(2)));
					d2.add(t5);
					Task t6 = new Task("Core3", date(1), date(24));
					t6.addSubtask(new Task("Task1", date(5), date(15)));
					t6.addSubtask(new Task("Task2", date(8), date(13)));
					d2.add(t6);
					s1.add(d2);
					
					JFreeChart jchart = ChartFactory.createGanttChart("Graphic", "ECU1", "Tasks", s1, true, true, true);
					ChartFrame chartFrm = new ChartFrame("ModEAS Graphic",jchart,true);
					chartFrm.setVisible(true);;
					chartFrm.setSize(500,400);
					chartFrm.validate();

						 
	            }
	}
		}

	}