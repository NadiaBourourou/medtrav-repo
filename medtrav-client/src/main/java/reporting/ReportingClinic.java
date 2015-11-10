package reporting;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.FillerBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import delegates.ClinicServicesDelegate;

public class ReportingClinic {

	public static void main(String[] args) throws FileNotFoundException,
			DRException {

		// dynamic report
		JasperReportBuilder report = DynamicReports.report();

		// styles
		StyleBuilder boldStyle = DynamicReports.stl.style().bold();
		StyleBuilder boldCentered = DynamicReports.stl.style(boldStyle)
				.setHorizontalAlignment(HorizontalAlignment.CENTER);
		StyleBuilder columnHeaderStyle = DynamicReports.stl.style(boldCentered)
				.setBorder(DynamicReports.stl.pen1Point())
				.setBackgroundColor(Color.LIGHT_GRAY);

		// add title
		TextFieldBuilder<String> title = DynamicReports.cmp
				.text("Clinics : Partners of MedTrav .");
		title.setStyle(boldCentered).setHorizontalAlignment(
				HorizontalAlignment.RIGHT);
		// get image
		InputStream stream = Reporting.class
				.getResourceAsStream("/smallLogo.png");
		ImageBuilder img = DynamicReports.cmp
				.image(stream)
				.setFixedDimension(80, 80)
				.setStyle(
						DynamicReports.stl.style().setHorizontalAlignment(
								HorizontalAlignment.LEFT));
		FillerBuilder filler = DynamicReports.cmp
				.filler()
				.setStyle(
						DynamicReports.stl.style().setTopBorder(
								DynamicReports.stl.pen2Point()))
				.setFixedHeight(2);
		report.title(DynamicReports.cmp.horizontalFlowList(img, title).newRow()
				.add(filler));

		// add tables
		// add columns
		TextColumnBuilder<String> NameColumn = Columns.column("Clinic", "name",
				DynamicReports.type.stringType());
		TextColumnBuilder<String> ProfessionalismColumn = Columns.column(
				"Professionalism", "professionalism",
				DynamicReports.type.stringType());
		TextColumnBuilder<String> AddressColumn = Columns.column("Address",
				"address", DynamicReports.type.stringType());
		TextColumnBuilder<Integer> PhoneNumberColumn = Columns.column(
				"Phone Number", "phoneNumber",
				DynamicReports.type.integerType());
		TextColumnBuilder<String> EmailColumn = Columns.column("Email",
				"email", DynamicReports.type.stringType());
		TextColumnBuilder<Double> PriceSRColumn = Columns.column(
				"Single Room $ ", "priceSingle",
				DynamicReports.type.doubleType());
		TextColumnBuilder<Double> PriceSimpleColumn = Columns.column(
				"Simple Room $ ", "priceSimple",
				DynamicReports.type.doubleType());

		// row num
		TextColumnBuilder<Integer> rowNumColumn = Columns
				.reportRowNumberColumn("No.").setFixedColumns(2)
				.setHorizontalAlignment(HorizontalAlignment.CENTER);

		// add columns
		report.columns(rowNumColumn, NameColumn, ProfessionalismColumn,
				AddressColumn, PhoneNumberColumn, EmailColumn, PriceSRColumn,
				PriceSimpleColumn);

		// column title style
		report.setColumnTitleStyle(columnHeaderStyle);
		// add data source
		report.setDataSource(ClinicServicesDelegate.doFindAllClinics());

		// footer
		report.pageFooter(DynamicReports.cmp.pageXofY());

		// higligh rows
		report.highlightDetailEvenRows();

		
		report.show();
		// pdf
		report.toPdf(new FileOutputStream(new File(
				"C:/medTrav/reportClinic.pdf")));

		// word
		report.toDocx(new FileOutputStream(new File(
				"C:/medTrav/reportClinic.docx")));
		// html
		report.toXhtml(new FileOutputStream(new File(
				"C:/medTrav/reportClinic.html")));

		// text
		report.toText(new FileOutputStream(new File(
				"C:/medTrav/reportClinic.txt")));

		// System.out.println("Report completed...");

	}

}
