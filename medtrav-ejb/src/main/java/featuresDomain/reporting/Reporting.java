package featuresDomain.reporting;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import services.impl.UserServices;
import entities.RoleType;
import entities.User;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.chart.Bar3DChartBuilder;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.FillerBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
	public class Reporting {
	 
		public static void main(String[] args) throws FileNotFoundException, DRException {
			
			// dynamic report
			JasperReportBuilder report = DynamicReports.report();

			// styles
			StyleBuilder boldStyle = DynamicReports.stl.style().bold();
			StyleBuilder boldCentered = DynamicReports.stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
			StyleBuilder columnHeaderStyle = DynamicReports.stl.style(boldCentered).setBorder(DynamicReports.stl.pen1Point()).setBackgroundColor(Color.LIGHT_GRAY);

			// add title
			TextFieldBuilder<String> title = DynamicReports.cmp.text("Dynamic report tutorial");
			title.setStyle(boldCentered).setHorizontalAlignment(HorizontalAlignment.RIGHT);
			// get image
			InputStream stream = Reporting.class.getResourceAsStream("/smallLogo.png");
			ImageBuilder img = DynamicReports.cmp.image(stream).setFixedDimension(80, 80).setStyle(DynamicReports.stl.style().setHorizontalAlignment(HorizontalAlignment.LEFT));
			FillerBuilder filler = DynamicReports.cmp.filler().setStyle(DynamicReports.stl.style().setTopBorder(DynamicReports.stl.pen2Point())).setFixedHeight(2);
			report.title(DynamicReports.cmp.horizontalFlowList(img, title).newRow().add(filler));

			// add tables
			// add columns
			TextColumnBuilder<String> FirstNameColumn = Columns.column("First Name", "firstName", DynamicReports.type.stringType());
			TextColumnBuilder<String> LastNameColumn = Columns.column("Last Name", "lastName", DynamicReports.type.stringType());
			TextColumnBuilder<String> CINColumn = Columns.column("CIN", "cin", DynamicReports.type.stringType());
			TextColumnBuilder<String> MailColumn = Columns.column("Mail", "mail", DynamicReports.type.stringType());

			
			// row num
			TextColumnBuilder<Integer> rowNumColumn = Columns.reportRowNumberColumn("No.").setFixedColumns(2).setHorizontalAlignment(HorizontalAlignment.CENTER);

			// add columns
			report.columns(rowNumColumn, FirstNameColumn, LastNameColumn, CINColumn,MailColumn);

			// column title style
			report.setColumnTitleStyle(columnHeaderStyle);
			// add data source
			report.setDataSource(getAllUsers());

			// footer
			report.pageFooter(DynamicReports.cmp.pageXofY());

	
			// report.groupBy(itemColumn);

			// higligh rows
			report.highlightDetailEvenRows();

			report.show();
			// pdf
			report.toPdf(new FileOutputStream(new File("d:/report.pdf")));

			// word
			report.toDocx(new FileOutputStream(new File("d:/report.docx")));
			// html
			report.toXhtml(new FileOutputStream(new File("d:/report.html")));

			// text
			report.toText(new FileOutputStream(new File("d:/report.txt")));

			System.out.println("Report completed...");

		}

		private static List<User> getAllUsers() {
			List<User> users = new ArrayList<User>();
			users.add(new User("Bhouri", "Yasmine", "14757510", "Yasmine.bhouri@esprit.tn"));
			users.add(new User("Bouguerra", "Khadija", "41758596", "Khadija.Bouguerra@esprit.tn"));
			users.add(new User("Bouktif", "Asma", "41758596", "asma.bouktif@esprit.tn"));
			users.add(new User("Boo", "Nadia", "14757510", "nadia.bourourou@esprit.tn"));
			users.add(new User("Nouri", "Hajer", "41758596", "Hajer.nouri@esprit.tn"));
		
			return users;

		}
}
