package mailing;

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

import delegates.HotelServicesDelegate;
import delegates.SurgeryServicesDelegate;
import delegates.UserServicesDelegate;
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
			TextFieldBuilder<String> title = DynamicReports.cmp.text("Hotels : Partners of MedTrav .");
			title.setStyle(boldCentered).setHorizontalAlignment(HorizontalAlignment.RIGHT);
			// get image
			InputStream stream = Reporting.class.getResourceAsStream("/smallLogo.png");
			ImageBuilder img = DynamicReports.cmp.image(stream).setFixedDimension(80, 80).setStyle(DynamicReports.stl.style().setHorizontalAlignment(HorizontalAlignment.LEFT));
			FillerBuilder filler = DynamicReports.cmp.filler().setStyle(DynamicReports.stl.style().setTopBorder(DynamicReports.stl.pen2Point())).setFixedHeight(2);
			report.title(DynamicReports.cmp.horizontalFlowList(img, title).newRow().add(filler));

			// add tables
			// add columns
			TextColumnBuilder<String> NameColumn = Columns.column("Hotel", "name", DynamicReports.type.stringType());
			TextColumnBuilder<String> DescriptionColumn = Columns.column("Hotel description", "description", DynamicReports.type.stringType());
			TextColumnBuilder<String> AddressColumn = Columns.column("Address", "address", DynamicReports.type.stringType());
			TextColumnBuilder<Integer> starsColumn = Columns.column("* * * ", "stars", DynamicReports.type.integerType());
			TextColumnBuilder<Double> PriceSRColumn = Columns.column("Single Room $ ", "priceSingle", DynamicReports.type.doubleType());
			TextColumnBuilder<Double> PriceSuiteColumn = Columns.column("Suite $ ", "priceSuite", DynamicReports.type.doubleType());

			
			// row num
			TextColumnBuilder<Integer> rowNumColumn = Columns.reportRowNumberColumn("No.").setFixedColumns(2).setHorizontalAlignment(HorizontalAlignment.CENTER);

			// add columns
			report.columns(rowNumColumn, NameColumn, DescriptionColumn, AddressColumn,starsColumn,PriceSRColumn,PriceSuiteColumn);

			// column title style
			report.setColumnTitleStyle(columnHeaderStyle);
			// add data source
			report.setDataSource(HotelServicesDelegate.doFindAllHotels());

			// footer
			report.pageFooter(DynamicReports.cmp.pageXofY());



			// higligh rows
			report.highlightDetailEvenRows();

			report.show();
			// pdf
			report.toPdf(new FileOutputStream(new File("C:/report.pdf")));

			// word
			report.toDocx(new FileOutputStream(new File("C:/report.docx")));
			// html
			report.toXhtml(new FileOutputStream(new File("C:/report.html")));

			// text
			report.toText(new FileOutputStream(new File("C:/report.txt")));

		//	System.out.println("Report completed...");

		}

	
}
