package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import delegates.SurgeryServicesDelegate;
import delegates.UserServicesDelegate;
import entities.Doctor;
import entities.Surgery;
import entities.User;

public class WelcomeJframe extends JFrame {
	private User user;
	private JPanel contentPane;
	JComboBox cbProcedure = new JComboBox();
	JComboBox cbTreatment = new JComboBox();
	JLabel lblDescriptionLabel = new JLabel("");
	JLabel lblLoggedAs = new JLabel("");

	private List<Doctor> doctors;
	private Doctor selectedDoctor = new Doctor();
	private JTable table;

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
			Integer index = cbProcedure.getSelectedIndex() + 1;
			JOptionPane.showMessageDialog(null, index);
			System.out.println(index);
			SurgeryServicesDelegate.doFindAllTreatmentsByProcedureId(index);
			int taille = SurgeryServicesDelegate
					.doFindAllTreatmentsByProcedureId(index).size();

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
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		menuBar.add(mntmLogOut);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(34, 12, 69, 57);
		lblLogo.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/smallLogo.png")));
		contentPane.add(lblLogo);

		JLabel label = new JLabel("");
		label.setBounds(128, 41, 0, 0);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(133, 41, 0, 0);
		contentPane.add(label_1);

		JLabel lblProcedure = new JLabel("Select a procedure");
		lblProcedure.setBounds(12, 76, 112, 14);
		contentPane.add(lblProcedure);

		fillProcedureCombo();
		cbProcedure.setBounds(138, 73, 295, 20);
		cbProcedure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTreatmentCombo();
			}
		});

		contentPane.add(cbProcedure);

		JLabel lblTreatment = new JLabel("Select a treatment");
		lblTreatment.setBounds(12, 100, 112, 14);
		contentPane.add(lblTreatment);
		cbTreatment.setBounds(138, 97, 295, 20);
		cbTreatment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblDescriptionLabel.setText(SurgeryServicesDelegate
						.doGetSurgeryDescription(1).toString());
				lblDescriptionLabel.setText("desc1");

			}
		});

		contentPane.add(cbTreatment);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(340, 41, 0, 0);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(345, 41, 0, 0);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(355, 41, 0, 0);
		contentPane.add(label_4);

		JLabel lblDescriptionLabel = new JLabel("");
		lblDescriptionLabel.setBounds(389, 131, 0, 0);
		contentPane.add(lblDescriptionLabel);

		lblLoggedAs.setBounds(298, 12, 387, 29);
		contentPane.add(lblLoggedAs);

		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/user_patient_icon.png")));
		lblUser.setBounds(642, 34, 62, 57);
		contentPane.add(lblUser);

		JLabel lblDoctors = new JLabel("Doctors ");
		lblDoctors.setBounds(12, 149, 91, 14);
		contentPane.add(lblDoctors);
		
		
		

		JButton btnNext = new JButton("Next ");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				

				Surgery surgery = SurgeryServicesDelegate
						.doFindSurgeryById(cbTreatment.getSelectedIndex());
				UserServicesDelegate.doBookSurgery(surgery, "Test", 1);
				
				
				Doctor doctor=UserServicesDelegate.doFindDoctorById(3);
				
			UserServicesDelegate.doChooseDoctor(doctor, 1);
			}
		});
		btnNext.setBounds(596, 353, 89, 23);
		contentPane.add(btnNext);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Doctors - Partners of MedTrav", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Doctors  - Partners of MedTrav", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(69, 174, 544, 186);
		contentPane.add(panel);

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		scrollPane.setViewportView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
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
		contentPane.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(34, 12, 69, 57);
		lblLogo.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/smallLogo.png")));
		contentPane.add(lblLogo);

		JLabel label = new JLabel("");
		label.setBounds(128, 41, 0, 0);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(133, 41, 0, 0);
		contentPane.add(label_1);

		JLabel lblProcedure = new JLabel("Select a procedure");
		lblProcedure.setBounds(12, 76, 112, 14);
		contentPane.add(lblProcedure);

		fillProcedureCombo();
		cbProcedure.setBounds(138, 73, 295, 20);
		cbProcedure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTreatmentCombo();
			}
		});

		contentPane.add(cbProcedure);

		JLabel lblTreatment = new JLabel("Select a treatment");
		lblTreatment.setBounds(12, 100, 112, 14);
		contentPane.add(lblTreatment);
		cbTreatment.setBounds(138, 97, 295, 20);
		cbTreatment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDescriptionLabel.setText(SurgeryServicesDelegate
						.doGetSurgeryDescription(1).toString());
				lblDescriptionLabel.setText("desc1");

			}
		});

		contentPane.add(cbTreatment);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(340, 41, 0, 0);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(345, 41, 0, 0);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(355, 41, 0, 0);
		contentPane.add(label_4);

		JLabel lblDescriptionLabel = new JLabel("");
		lblDescriptionLabel.setBounds(389, 131, 0, 0);
		contentPane.add(lblDescriptionLabel);

		lblLoggedAs.setBounds(298, 12, 387, 29);
		contentPane.add(lblLoggedAs);

		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/user_patient_icon.png")));
		lblUser.setBounds(642, 34, 62, 57);
		contentPane.add(lblUser);

		JLabel lblDoctors = new JLabel("Doctors ");
		lblDoctors.setBounds(12, 149, 91, 14);
		contentPane.add(lblDoctors);

		JPanel panel = new JPanel();
		panel.setBounds(134, 149, 295, 172);
		contentPane.add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								275, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								150, Short.MAX_VALUE).addContainerGap()));

		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		initDataBindings();

	}

	protected void initDataBindings() {
		JTableBinding<Doctor, List<Doctor>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ_WRITE, doctors, table);
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
	}
}
