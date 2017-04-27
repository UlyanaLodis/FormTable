
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.DefaultIntervalCategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.Task;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class PieChart  extends JFrame {
	private static final long serialVersionUID = 1L;
	protected static final PlotOrientation VERTICAL = null;
	private JPanel contentPane;
	 private static Date date(final int day, final int month, final int year) {

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
	public PieChart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCreatePlot = new JButton("Create Plot");
		btnCreatePlot.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			/**	DefaultIntervalCategoryDataset s1 = new DefaultIntervalCategoryDataset();*/
				TaskSeriesCollection s1 = new TaskSeriesCollection();
				TaskSeries d1 = new TaskSeries("Plot");
				Task t1 = new Task("CPU1", date(3), date(20));
				t1.addSubtask(new Task("Task1", date(3), date(5)));
				t1.addSubtask(new Task("Task2", date(6), date(9)));
				d1.add(t1);
				Task t2 = new Task("CPU2", date(3), date(20));
				t2.addSubtask(new Task("Task3", date(4), date(7)));
				t2.addSubtask(new Task("Task4", date(8), date(12)));
				d1.add(t2);
				s1.add(d1);
				
				JFreeChart jchart = ChartFactory.createGanttChart("Graph", "CPU", "Tasks", s1, true, true, true);
				ChartFrame chartFrm = new ChartFrame("oo",jchart,true);
				chartFrm.setVisible(true);;
				chartFrm.setSize(500,400);
				chartFrm.validate();
				
			}
		});
		panel_1.add(btnCreatePlot);
		contentPane.setLayout(gl_contentPane);
	}
   /* public PieChart(final String title) {

        super(title);
        

        final IntervalCategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
 
    public static IntervalCategoryDataset createDataset() {

        final TaskSeries s1 = new TaskSeries("Scheduled");
        s1.add(new Task("Write Proposal",
               new SimpleTimePeriod(date(1, Calendar.APRIL, 2001),
                                    date(5, Calendar.APRIL, 2001))));
        s1.add(new Task("Obtain Approval",
               new SimpleTimePeriod(date(9, Calendar.APRIL, 2001),
                                    date(9, Calendar.APRIL, 2001))));
        s1.add(new Task("Requirements Analysis",
               new SimpleTimePeriod(date(10, Calendar.APRIL, 2001),
                                    date(5, Calendar.MAY, 2001))));
        s1.add(new Task("Design Phase",
               new SimpleTimePeriod(date(6, Calendar.MAY, 2001),
                                    date(30, Calendar.MAY, 2001))));
        s1.add(new Task("Design Signoff",
               new SimpleTimePeriod(date(2, Calendar.JUNE, 2001),
                                    date(2, Calendar.JUNE, 2001))));
        s1.add(new Task("Alpha Implementation",
               new SimpleTimePeriod(date(3, Calendar.JUNE, 2001),
                                    date(31, Calendar.JULY, 2001))));
        s1.add(new Task("Design Review",
               new SimpleTimePeriod(date(1, Calendar.AUGUST, 2001),
                                    date(8, Calendar.AUGUST, 2001))));
        s1.add(new Task("Revised Design Signoff",
               new SimpleTimePeriod(date(10, Calendar.AUGUST, 2001),
                                    date(10, Calendar.AUGUST, 2001))));
        s1.add(new Task("Beta Implementation",
               new SimpleTimePeriod(date(12, Calendar.AUGUST, 2001),
                                    date(12, Calendar.SEPTEMBER, 2001))));
        s1.add(new Task("Testing",
               new SimpleTimePeriod(date(13, Calendar.SEPTEMBER, 2001),
                                    date(31, Calendar.OCTOBER, 2001))));
        s1.add(new Task("Final Implementation",
               new SimpleTimePeriod(date(1, Calendar.NOVEMBER, 2001),
                                    date(15, Calendar.NOVEMBER, 2001))));
        s1.add(new Task("Signoff",
               new SimpleTimePeriod(date(28, Calendar.NOVEMBER, 2001),
                                    date(30, Calendar.NOVEMBER, 2001))));

        final TaskSeries s2 = new TaskSeries("Actual");
        s2.add(new Task("Write Proposal",
               new SimpleTimePeriod(date(1, Calendar.APRIL, 2001),
                                    date(5, Calendar.APRIL, 2001))));
        s2.add(new Task("Obtain Approval",
               new SimpleTimePeriod(date(9, Calendar.APRIL, 2001),
                                    date(9, Calendar.APRIL, 2001))));
        s2.add(new Task("Requirements Analysis",
               new SimpleTimePeriod(date(10, Calendar.APRIL, 2001),
                                    date(15, Calendar.MAY, 2001))));
        s2.add(new Task("Design Phase",
               new SimpleTimePeriod(date(15, Calendar.MAY, 2001),
                                    date(17, Calendar.JUNE, 2001))));
        s2.add(new Task("Design Signoff",
               new SimpleTimePeriod(date(30, Calendar.JUNE, 2001),
                                    date(30, Calendar.JUNE, 2001))));
        s2.add(new Task("Alpha Implementation",
               new SimpleTimePeriod(date(1, Calendar.JULY, 2001),
                                    date(12, Calendar.SEPTEMBER, 2001))));
        s2.add(new Task("Design Review",
               new SimpleTimePeriod(date(12, Calendar.SEPTEMBER, 2001),
                                    date(22, Calendar.SEPTEMBER, 2001))));
        s2.add(new Task("Revised Design Signoff",
               new SimpleTimePeriod(date(25, Calendar.SEPTEMBER, 2001),
                                    date(27, Calendar.SEPTEMBER, 2001))));
        s2.add(new Task("Beta Implementation",
               new SimpleTimePeriod(date(27, Calendar.SEPTEMBER, 2001),
                                    date(30, Calendar.OCTOBER, 2001))));
        s2.add(new Task("Testing",
               new SimpleTimePeriod(date(31, Calendar.OCTOBER, 2001),
                                    date(17, Calendar.NOVEMBER, 2001))));
        s2.add(new Task("Final Implementation",
               new SimpleTimePeriod(date(18, Calendar.NOVEMBER, 2001),
                                    date(5, Calendar.DECEMBER, 2001))));
        s2.add(new Task("Signoff",
               new SimpleTimePeriod(date(10, Calendar.DECEMBER, 2001),
                                    date(11, Calendar.DECEMBER, 2001))));

        final TaskSeriesCollection collection = new TaskSeriesCollection();
        collection.add(s1);
        collection.add(s2);

        return collection;
    }

    
    private static Date date(final int day, final int month, final int year) {

        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        final Date result = calendar.getTime();
        return result;

    }
        
    
    private JFreeChart createChart(final IntervalCategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createGanttChart(
            "Gantt Chart Demo",  // chart title
            "Task",              // domain axis label
            "Date",              // range axis label
            dataset,             // data
            true,                // include legend
            true,                // tooltips
            false                // urls
        );    
//        chart.getCategoryPlot().getDomainAxis().setMaxCategoryLabelWidthRatio(10.0f);
        return chart;    
    }*/
}



