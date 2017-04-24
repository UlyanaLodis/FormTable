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

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URI;
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
		 private JFrame frame;
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
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
        Default def = new Default();
        frame.addWindowListener(def);
		
		 ScrollPane sc = new ScrollPane();
        //Создание кнопок и прикрепление иконок
        save = new JButton("Сохранить");
        save.setToolTipText("Сохранить список компонентов");
        toolBar = new JToolBar("Панель инструментов");
        toolBar.add(save);
        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.NORTH);

        open = new JButton("Загрузить");
        open.setToolTipText("Загрузить с бд");
        toolBar.add(open);
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
     
         pac = new JButton("Просмотреть");
         pac.setToolTipText("Сведения о компонентах");
         toolBar.add(pac);
         frame.setLayout(new BorderLayout());
         frame.add(toolBar, BorderLayout.NORTH);
        
         otchot=new JButton("Отчёт");
         otchot.setToolTipText("Графики");
         toolBar.add(otchot);
         frame.setLayout(new BorderLayout());
         frame.add(toolBar, BorderLayout.NORTH);
          
         Box mainBox = Box.createVerticalBox();
         Box box1 = Box.createHorizontalBox();
 		 b = new JLabel("BUS Parameter");
      	 box1.add(b);
 		 headers = new Object[]{"№", "Name", "Speed"};
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
         headers1 = new Object[]{"№", "Name"};
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
         //Размещение таблицы с данными
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

		 }

class Default implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Object[] options = {"Да", "Нет!"};
        int n = JOptionPane
                .showOptionDialog(e.getWindow(), "Закрыть программу?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
        if (n == 0) {
            int i = JOptionPane
                    .showOptionDialog(e.getWindow(), "Сохранить данные?",
                            "Подтверждение", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, options,
                            options[0]);
            e.getWindow().setVisible(false);
            System.exit(0);
        }

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    
	}
	class DDDD implements ActionListener {
		public void actionPerformed(ActionEvent ev){
			 if (ev.getSource() == pac) {
	                
	                if (books1.getSelectedRow() != -1) {
	                	Edit_cpu oop = new Edit_cpu((String) model1.getValueAt(books1.getSelectedRow(), 1));
	                   // oop.setVisible(true);
	                } else {
	                    JOptionPane.showMessageDialog(frame, "Вы не выбрали ECU");
	                }
	            }
	}
		}

	}