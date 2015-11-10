package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import delegates.ClinicServicesDelegate;
import entities.Clinic;
import entities.User;

public class ListClinicPatient extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<Clinic> clinics = new ArrayList<Clinic>();
	private JTextField name;
	Clinic clinic = new Clinic();

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
		setTitle("List Of Clinics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "List Of Clinics",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);

		JLabel lblName = new JLabel("Name");

		name = new JTextField();
		name.setColumns(10);

		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(ListClinicPatient.class
				.getResource("/images/imagesearchclinic.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clinics = ClinicServicesDelegate.doFindClinicByName(name
							.getText());
					initDataBindings();
				} catch (Exception exc) {
					JOptionPane
							.showMessageDialog(null, "Please choose a name ");

				}
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(
						ListClinicPatient.class
								.getResource("/images/healthcare-and-medical-care-symbol-heart-beat-rate-icon-design-template-vector-illustration_203517067.jpg")));

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ListClinicPatient.class
				.getResource("/images/imagechooseclinic.png")));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ListClinicPatient.class
				.getResource("/images/medtraaaaaav.jpg")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblName)
																		.addGap(51)
																		.addComponent(
																				name,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(26)
																		.addComponent(
																				btnSearch,
																				GroupLayout.PREFERRED_SIZE,
																				32,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																lblNewLabel_1))
										.addGap(204)
										.addComponent(lblNewLabel,
												GroupLayout.PREFERRED_SIZE,
												111, GroupLayout.PREFERRED_SIZE)
										.addGap(49))
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addComponent(panel,
												GroupLayout.DEFAULT_SIZE, 584,
												Short.MAX_VALUE).addGap(9))
						.addGroup(
								Alignment.TRAILING,
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap(475, Short.MAX_VALUE)
										.addComponent(btnNewButton,
												GroupLayout.PREFERRED_SIZE, 75,
												GroupLayout.PREFERRED_SIZE)
										.addGap(39)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(11)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblNewLabel,
																GroupLayout.PREFERRED_SIZE,
																75,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel_1)
																		.addGap(18)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								name,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblName)))
														.addComponent(
																btnSearch,
																GroupLayout.PREFERRED_SIZE,
																29,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addComponent(panel,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(btnNewButton,
												GroupLayout.PREFERRED_SIZE, 68,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(12, Short.MAX_VALUE)));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								553, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								131, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		table = new JTable();

		clinics = ClinicServicesDelegate.doFindAllClinics();

		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	
	
	public ListClinicPatient(User user) {
		setTitle("List Of Clinics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "List Of Clinics",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);

		JLabel lblName = new JLabel("Name");

		name = new JTextField();
		name.setColumns(10);

		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(ListClinicPatient.class
				.getResource("/images/imagesearchclinic.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clinics = ClinicServicesDelegate.doFindClinicByName(name
							.getText());
					initDataBindings();
				} catch (Exception exc) {
					JOptionPane
							.showMessageDialog(null, "Please choose a name ");

				}
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(
						ListClinicPatient.class
								.getResource("/images/healthcare-and-medical-care-symbol-heart-beat-rate-icon-design-template-vector-illustration_203517067.jpg")));

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ListClinicPatient.class
				.getResource("/images/imagechooseclinic.png")));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ListClinicPatient.class
				.getResource("/images/medtraaaaaav.jpg")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblName)
																		.addGap(51)
																		.addComponent(
																				name,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(26)
																		.addComponent(
																				btnSearch,
																				GroupLayout.PREFERRED_SIZE,
																				32,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																lblNewLabel_1))
										.addGap(204)
										.addComponent(lblNewLabel,
												GroupLayout.PREFERRED_SIZE,
												111, GroupLayout.PREFERRED_SIZE)
										.addGap(49))
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addComponent(panel,
												GroupLayout.DEFAULT_SIZE, 584,
												Short.MAX_VALUE).addGap(9))
						.addGroup(
								Alignment.TRAILING,
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap(475, Short.MAX_VALUE)
										.addComponent(btnNewButton,
												GroupLayout.PREFERRED_SIZE, 75,
												GroupLayout.PREFERRED_SIZE)
										.addGap(39)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(11)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblNewLabel,
																GroupLayout.PREFERRED_SIZE,
																75,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel_1)
																		.addGap(18)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								name,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblName)))
														.addComponent(
																btnSearch,
																GroupLayout.PREFERRED_SIZE,
																29,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addComponent(panel,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(btnNewButton,
												GroupLayout.PREFERRED_SIZE, 68,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(12, Short.MAX_VALUE)));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								553, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								131, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		table = new JTable();

		clinics = ClinicServicesDelegate.doFindAllClinics();

		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<Clinic, List<Clinic>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ_WRITE, clinics, table);
		//
		BeanProperty<Clinic, String> clinicBeanProperty = BeanProperty
				.create("name");
		jTableBinding.addColumnBinding(clinicBeanProperty)
				.setColumnName("Name");
		//
		BeanProperty<Clinic, String> clinicBeanProperty_1 = BeanProperty
				.create("professionalism");
		jTableBinding.addColumnBinding(clinicBeanProperty_1).setColumnName(
				"Professionalism");
		//
		BeanProperty<Clinic, String> clinicBeanProperty_2 = BeanProperty
				.create("address");
		jTableBinding.addColumnBinding(clinicBeanProperty_2).setColumnName(
				"Address");
		//
		BeanProperty<Clinic, String> clinicBeanProperty_3 = BeanProperty
				.create("email");
		jTableBinding.addColumnBinding(clinicBeanProperty_3).setColumnName(
				"Email");
		//
		BeanProperty<Clinic, Integer> clinicBeanProperty_4 = BeanProperty
				.create("phoneNumber");
		jTableBinding.addColumnBinding(clinicBeanProperty_4).setColumnName(
				"Phone");
		//
		BeanProperty<Clinic, Double> clinicBeanProperty_5 = BeanProperty
				.create("priceSimple");
		jTableBinding.addColumnBinding(clinicBeanProperty_5).setColumnName(
				"Price Simple");
		//
		BeanProperty<Clinic, Double> clinicBeanProperty_6 = BeanProperty
				.create("priceSingle");
		jTableBinding.addColumnBinding(clinicBeanProperty_6).setColumnName(
				"Price Single");
		//
		jTableBinding.bind();
	}
}
