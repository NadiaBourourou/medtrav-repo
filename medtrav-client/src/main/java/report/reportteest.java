package report;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import delegates.HotelServicesDelegate;
import entities.Hotel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class reportteest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reportteest frame = new reportteest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public reportteest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	private void showreport2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/medtravdb",
							"root", "");
			String sourceName = "src/main/java/report/asma.jrxml";
			JasperReport report = JasperCompileManager
					.compileReport(sourceName);
			JasperPrint filedReport = JasperFillManager.fillReport(report,
					null, con);
			//JasperViewer.viewReport(filedReport);
			this.getContentPane().add(new JRViewer(filedReport));
			this.pack();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void showreport() {
		try {
			List<Hotel> hotels = new ArrayList<Hotel>();
			hotels = HotelServicesDelegate.doFindAllHotels();
			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
			for (Hotel hotel : hotels) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("id", hotel.getHotelId());
				m.put("adresse", hotel.getAddress());
				m.put("Name", hotel.getName());
				m.put("stars", hotel.getStars());
				System.out.println(hotel);
				datasource.add(m);
			}
			JRDataSource JRdatasource = new JRBeanCollectionDataSource(
					datasource);
			String sourceName = "src/main/java/report/asma.jrxml";
			JasperReport report = JasperCompileManager
					.compileReport(sourceName);
			JasperPrint filedReport = JasperFillManager.fillReport(report,
					null, JRdatasource);
			this.getContentPane().add(new JRViewer(filedReport));
			this.pack();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
