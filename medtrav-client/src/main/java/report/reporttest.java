package report;

import java.sql.DriverManager;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import com.mysql.jdbc.Connection;

public class reporttest {
	
public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/medtravdb",
							"root", "");
			String sourceName = "src/main/java/report/report1.jrxml";
			JasperReport report = JasperCompileManager
					.compileReport(sourceName);
			JasperPrint filedReport = JasperFillManager.fillReport(report,
					null, con);
			//JasperViewer.viewReport(filedReport);
		//	this.getContentPane().add(new JRViewer(filedReport));
			//this.pack();
		} catch (Exception e) {
}
}
}
