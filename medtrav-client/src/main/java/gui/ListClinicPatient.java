package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import delegates.ClinicServicesDelegate;
import entities.Clinic;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.BeanProperty;

import java.awt.Color;

public class ListClinicPatient extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<Clinic> clinics= new ArrayList<Clinic>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListClinicPatient frame = new ListClinicPatient();
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
	public ListClinicPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 377);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		
		clinics = ClinicServicesDelegate.doFindAllClinics();
		
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Clinic, List<Clinic>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, clinics, table);
		//
		BeanProperty<Clinic, String> clinicBeanProperty = BeanProperty.create("name");
		jTableBinding.addColumnBinding(clinicBeanProperty).setColumnName("Name");
		//
		BeanProperty<Clinic, String> clinicBeanProperty_1 = BeanProperty.create("professionalism");
		jTableBinding.addColumnBinding(clinicBeanProperty_1).setColumnName("Professionalism");
		//
		BeanProperty<Clinic, String> clinicBeanProperty_2 = BeanProperty.create("address");
		jTableBinding.addColumnBinding(clinicBeanProperty_2).setColumnName("Address");
		//
		BeanProperty<Clinic, String> clinicBeanProperty_3 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(clinicBeanProperty_3).setColumnName("Email");
		//
		BeanProperty<Clinic, Integer> clinicBeanProperty_4 = BeanProperty.create("phoneNumber");
		jTableBinding.addColumnBinding(clinicBeanProperty_4).setColumnName("Phone");
		//
		BeanProperty<Clinic, Double> clinicBeanProperty_5 = BeanProperty.create("priceSimple");
		jTableBinding.addColumnBinding(clinicBeanProperty_5).setColumnName("Price Simple");
		//
		BeanProperty<Clinic, Double> clinicBeanProperty_6 = BeanProperty.create("priceSingle");
		jTableBinding.addColumnBinding(clinicBeanProperty_6).setColumnName("Price Single");
		//
		jTableBinding.bind();
	}
}
