import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;




public class AddFrame {


JTextField  nam, len;
JLabel b,tl;
JFrame frame;
JButton okcore, notecore;
   
public AddFrame(){
	
	/////////////////
	frame = new JFrame("Frame");
	///////////////
	
	frame.setSize(250,150);
   frame.setLocation(500,100);
   frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setVisible(true);
	
	Box mainBox = Box.createVerticalBox();
	
    Box box1 = Box.createHorizontalBox();
	 b = new JLabel("Name Frame");
 	 nam = new JTextField(15);
 	 box1.add(b);
 	 box1.add(Box.createHorizontalStrut(6));
 	 box1.add(nam);
 	 
 	Box box3 = Box.createHorizontalBox();
	 tl = new JLabel("Length");
	 len = new JTextField(15);
	 box3.add(tl);
	 box3.add(Box.createHorizontalStrut(6));
	 box3.add(len);
 	 
 	Box box2 = Box.createHorizontalBox();
 	okcore = new JButton ("��");
 	notecore = new JButton ("������");
 	box2.add(okcore);
 	box2.add(notecore);
 	
    mainBox.setBorder(new EmptyBorder(12,12,12,12));
    mainBox.add(box1);
    mainBox.add(Box.createVerticalStrut(12));
    mainBox.add (box3);
    mainBox.add(Box.createVerticalStrut(12));
    mainBox.add(box2);

	frame.add(mainBox);
	DDDD AD = new DDDD();
    notecore.addActionListener(AD);
	
}
class DDDD implements ActionListener {

	public void actionPerformed(ActionEvent ev){
		if (ev.getSource() == notecore) {
			 
			 frame.dispose();
			 
		 }
		 
}
}	
}