package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import delegates.AssigedPatientsServicesDelegate;
import delegates.SurgeryServicesDelegate;
import delegates.UserServicesDelegate;
import entities.Doctor;
import entities.Surgery;
import entities.User;

public class WelcomeJframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private User user;
	private JPanel contentPane;
	JComboBox cbProcedure = new JComboBox();
	JComboBox cbTreatment = new JComboBox();
	JLabel lblDescriptionLabel = new JLabel("");
	JLabel lblLoggedAs = new JLabel("");
	JLabel lblError = new JLabel("");

	private List<Doctor> doctors;
	private Doctor selectedDoctor = new Doctor();
	private JTable table;
	private JLabel lblDoctorDescription;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeJframe frame = new WelcomeJframe();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public void fillProcedureCombo() {
		try {
			SurgeryServicesDelegate.doFindAllProcedures();
			int taille = SurgeryServicesDelegate.doFindAllProcedures().size();
			cbProcedure.addItem("...");
			for (int i = 0; i < taille; i++) {
				String name = SurgeryServicesDelegate.doFindAllProcedures()
						.get(i).getName();
				cbProcedure.addItem(name);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public void fillTreatmentCombo() {
		try {
			Integer index = cbProcedure.getSelectedIndex();
			System.out.println(index);
			SurgeryServicesDelegate.doFindAllTreatmentsByProcedureId(index);
			int taille = SurgeryServicesDelegate
					.doFindAllTreatmentsByProcedureId(index).size();
			cbTreatment.addItem("...");
			for (int i = 0; i < taille; i++) {
				String name = SurgeryServicesDelegate
						.doFindAllTreatmentsByProcedureId(index).get(i)
						.getName();
				cbTreatment.addItem(name);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public WelcomeJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/logout-icon.png")));
		menuBar.add(mntmLogOut);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/smallLogo.png")));

		JLabel label = new JLabel("");

		JLabel label_1 = new JLabel("");

		JLabel lblProcedure = new JLabel("Select a procedure");

		fillProcedureCombo();
		cbProcedure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTreatmentCombo();
			}
		});

		JLabel lblTreatment = new JLabel("Select a treatment");
		cbTreatment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblDescriptionLabel.setText(SurgeryServicesDelegate
						.doGetSurgeryDescription(1).toString());
				lblDescriptionLabel.setText("desc1");

				doctors = UserServicesDelegate
						.doFindDoctorsBySpecialty(cbTreatment.getSelectedItem()
								.toString());

				initDataBindings();

			}
		});

		JLabel label_2 = new JLabel("");

		JLabel label_3 = new JLabel("");

		JLabel label_4 = new JLabel("");

		JLabel lblDescriptionLabel = new JLabel("");

		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/user_patient_icon.png")));

		JButton btnNext = new JButton("Next ");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRowCount() == 0)

				{
					lblError.setText("Please select a surgery and a doctor before pursuing.");

				}

				else {

					Surgery surgery = SurgeryServicesDelegate
							.doFindSurgeryById(cbTreatment.getSelectedIndex());
					UserServicesDelegate.doBookSurgery(surgery, "Test", 1);
					System.out.println(surgery.getName());

					selectedDoctor = doctors.get(table.getSelectedRow());

					UserServicesDelegate.doChooseDoctor(selectedDoctor, 1);

				}

			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"Qualified doctors for this surgery", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.DARK_GRAY));

		lblDoctorDescription = new JLabel("");
		lblDoctorDescription.setForeground(Color.BLACK);

		lblError.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblError.setForeground(Color.RED);
		lblError.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
setVisible(false);
PatientUi back=new PatientUi();
back.setVisible(true);

			
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(22)
									.addComponent(lblLogo))
								.addComponent(lblProcedure, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addComponent(label)
							.addGap(5)
							.addComponent(label_1)
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(160)
									.addComponent(lblLoggedAs, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(202)
									.addComponent(label_2))
								.addComponent(cbProcedure, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(207)
									.addComponent(label_3))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(217)
									.addComponent(label_4))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(504)
									.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(384)
							.addComponent(lblDescriptionLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(lblTreatment, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(cbTreatment, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblDoctorDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
									.addGap(191)
									.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(5, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLogo)
							.addGap(7)
							.addComponent(lblProcedure))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(label_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLoggedAs, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_2)
							.addGap(32)
							.addComponent(cbProcedure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(label_3))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(label_4))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(lblUser)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblTreatment))
								.addComponent(cbTreatment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addComponent(lblDescriptionLabel)
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(116)
							.addComponent(lblDoctorDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNext)
						.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(29, Short.MAX_VALUE))
		);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								275, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addGap(13)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								169, Short.MAX_VALUE).addContainerGap()));

		table = new JTable();
		table.setForeground(Color.BLACK);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDoctorDescription.setText(selectedDoctor.getDescription());
			}
		});
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();

	}

	public WelcomeJframe(User user) {
		lblLoggedAs.setText(user.getLogin());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/logout-icon.png")));
		menuBar.add(mntmLogOut);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/smallLogo.png")));

		JLabel label = new JLabel("");

		JLabel label_1 = new JLabel("");

		JLabel lblProcedure = new JLabel("Select a procedure");

		fillProcedureCombo();
		cbProcedure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTreatmentCombo();
			}
		});

		JLabel lblTreatment = new JLabel("Select a treatment");
		cbTreatment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblDescriptionLabel.setText(SurgeryServicesDelegate
						.doGetSurgeryDescription(1).toString());
				lblDescriptionLabel.setText("desc1");

				doctors = UserServicesDelegate
						.doFindDoctorsBySpecialty(cbTreatment.getSelectedItem()
								.toString());

				initDataBindings();

			}
		});

		JLabel label_2 = new JLabel("");

		JLabel label_3 = new JLabel("");

		JLabel label_4 = new JLabel("");

		JLabel lblDescriptionLabel = new JLabel("");

		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/user_patient_icon.png")));

		JButton btnNext = new JButton("Next ");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRowCount() == 0)

				{
					lblError.setText("Please select a surgery and a doctor before pursuing.");

				}

				else {

					Surgery surgery = SurgeryServicesDelegate
							.doFindSurgeryById(cbTreatment.getSelectedIndex());
					UserServicesDelegate.doBookSurgery(surgery, "Test",
							user.getUserId());

					System.out.println(surgery.getName());

					selectedDoctor = doctors.get(table.getSelectedRow());
					UserServicesDelegate.doChooseDoctor(selectedDoctor,
							user.getUserId());

					setVisible(false);
					ListClinicPatient next = new ListClinicPatient(user);
					next.setVisible(true);

				}

			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"Qualified doctors for this surgery", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.DARK_GRAY));

		lblDoctorDescription = new JLabel("");
		lblDoctorDescription.setForeground(Color.BLACK);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
setVisible(false);
PatientUi back=new PatientUi();
back.setVisible(true);

			
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(22)
									.addComponent(lblLogo))
								.addComponent(lblProcedure, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addComponent(label)
							.addGap(5)
							.addComponent(label_1)
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(160)
									.addComponent(lblLoggedAs, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(202)
									.addComponent(label_2))
								.addComponent(cbProcedure, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(207)
									.addComponent(label_3))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(217)
									.addComponent(label_4))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(504)
									.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(384)
							.addComponent(lblDescriptionLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(lblTreatment, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(cbTreatment, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblDoctorDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
									.addGap(191)
									.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(5, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLogo)
							.addGap(7)
							.addComponent(lblProcedure))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(label_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLoggedAs, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_2)
							.addGap(32)
							.addComponent(cbProcedure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(label_3))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(label_4))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(lblUser)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblTreatment))
								.addComponent(cbTreatment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addComponent(lblDescriptionLabel)
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(116)
							.addComponent(lblDoctorDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNext)
						.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(29, Short.MAX_VALUE))
		);


		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								275, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addGap(13)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								169, Short.MAX_VALUE).addContainerGap()));

		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();

	}

	protected void initDataBindings() {
		JTableBinding<Doctor, List<Doctor>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, doctors, table);
		//
		BeanProperty<Doctor, String> doctorBeanProperty = BeanProperty
				.create("firstName");
		jTableBinding.addColumnBinding(doctorBeanProperty).setColumnName(
				"First Name");
		//
		BeanProperty<Doctor, String> doctorBeanProperty_1 = BeanProperty
				.create("lastName");
		jTableBinding.addColumnBinding(doctorBeanProperty_1).setColumnName(
				"Last Name");
		//
		BeanProperty<Doctor, String> doctorBeanProperty_2 = BeanProperty
				.create("specialty");
		jTableBinding.addColumnBinding(doctorBeanProperty_2).setColumnName(
				"Specialty");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty = BeanProperty
				.create("selectedElement.firstName");
		BeanProperty<Doctor, String> doctorBeanProperty_3 = BeanProperty
				.create("firstName");
		AutoBinding<JTable, String, Doctor, String> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty, selectedDoctor,
						doctorBeanProperty_3);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty
				.create("selectedElement.lastName");
		BeanProperty<Doctor, String> doctorBeanProperty_4 = BeanProperty
				.create("lastName");
		AutoBinding<JTable, String, Doctor, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_1, selectedDoctor,
						doctorBeanProperty_4);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty
				.create("selectedElement.specialty");
		BeanProperty<Doctor, String> doctorBeanProperty_5 = BeanProperty
				.create("specialty");
		AutoBinding<JTable, String, Doctor, String> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_2, selectedDoctor,
						doctorBeanProperty_5);
		autoBinding_2.bind();
	}
}
