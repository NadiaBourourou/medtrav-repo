package gui.assignedPatients;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import delegates.AssigedPatientsServicesDelegate;
import entities.Patient;
import entities.User;
import gui.DoctorUI;

public class ListAssignedPatientsToDoctor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Integer doctorId = 3;
	List<Patient> patients;
	Patient patientSelected = new Patient();
	private User userConnected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListAssignedPatientsToDoctor frame = new ListAssignedPatientsToDoctor();
					frame.setLocationRelativeTo(null);
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
	public ListAssignedPatientsToDoctor() {
		patients = AssigedPatientsServicesDelegate
				.doFindAllPatientsByDoctorId(doctorId);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 342);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(43, 99, 477, 140);
		contentPane.add(panel);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								544, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								118, Short.MAX_VALUE).addContainerGap()));

		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);

		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					patientSelected = patients.get(table.getSelectedRow());
					AssigedPatientsServicesDelegate
							.doAcceptPatient(patientSelected);
					patients = AssigedPatientsServicesDelegate
							.doFindAllPatientsByDoctorId(doctorId);
					initDataBindings();
				}

				catch (Exception p) {
					JOptionPane.showMessageDialog(null,
							"Please select a patient.");
				}

			}
		});
		btnAccept.setBounds(568, 113, 100, 23);
		contentPane.add(btnAccept);

		JButton btnRefuse = new JButton("Refuse");
		btnRefuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					patientSelected = patients.get(table.getSelectedRow());

					AssigedPatientsServicesDelegate.doRefusePatient(
							patientSelected, doctorId);
					AssigedPatientsServicesDelegate.doDeleteAssignPatient(
							patientSelected.getUserId(), doctorId);
					patients = AssigedPatientsServicesDelegate
							.doFindAllPatientsByDoctorId(doctorId);
					initDataBindings();
				}

				catch (Exception p) {
					JOptionPane.showMessageDialog(null,
							"Please select a patient.");
				}

			}
		});
		btnRefuse.setBounds(568, 147, 100, 23);
		contentPane.add(btnRefuse);

		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					patientSelected = patients.get(table.getSelectedRow());

					DisplayPatientAssigned dispPatient = new DisplayPatientAssigned(
							patientSelected);
					dispPatient.setLocationRelativeTo(null);

					dispPatient.setVisible(true);
					ListAssignedPatientsToDoctor.this.setVisible(false);

				} catch (Exception p) {
					JOptionPane.showMessageDialog(null,
							"Please select a patient.");
				}

			}
		});
		btnDisplay.setBounds(568, 181, 100, 23);
		contentPane.add(btnDisplay);

		JLabel lblListAssignedPatients = new JLabel("List assigned patients");
		lblListAssignedPatients.setForeground(SystemColor.desktop);
		lblListAssignedPatients.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListAssignedPatients.setBounds(172, 11, 326, 45);
		contentPane.add(lblListAssignedPatients);
		
		JButton backTobtn = new JButton("Back to menu");
		backTobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		backTobtn.setBounds(541, 241, 127, 23);
		contentPane.add(backTobtn);
		initDataBindings();
	}

	// ===

	public ListAssignedPatientsToDoctor(User userConnected) {
		System.out.println("LIST ASSIGNED PATIENTS ");
		System.out.println("user co id=" + userConnected.getUserId());
		System.out.println("user co name=" + userConnected.getFirstName()
				+ userConnected.getLastName());

		patients = AssigedPatientsServicesDelegate
				.doFindAllPatientsByDoctorId(userConnected.getUserId());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 342);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(43, 99, 477, 140);
		contentPane.add(panel);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								544, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								118, Short.MAX_VALUE).addContainerGap()));

		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);

		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					patientSelected = patients.get(table.getSelectedRow());
					AssigedPatientsServicesDelegate
							.doAcceptPatient(patientSelected);
					patients = AssigedPatientsServicesDelegate
							.doFindAllPatientsByDoctorId(userConnected
									.getUserId());
					initDataBindings();
				}

				catch (Exception p) {
					JOptionPane.showMessageDialog(null,
							"Please select a patient.");
				}

			}
		});
		btnAccept.setBounds(568, 113, 100, 23);
		contentPane.add(btnAccept);

		JButton btnRefuse = new JButton("Refuse");
		btnRefuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					patientSelected = patients.get(table.getSelectedRow());

					AssigedPatientsServicesDelegate.doRefusePatient(
							patientSelected, userConnected.getUserId());
					AssigedPatientsServicesDelegate.doDeleteAssignPatient(
							patientSelected.getUserId(),
							userConnected.getUserId());
					patients = AssigedPatientsServicesDelegate
							.doFindAllPatientsByDoctorId(userConnected
									.getUserId());
					initDataBindings();
				}

				catch (Exception p) {
					JOptionPane.showMessageDialog(null,
							"Please select a patient.");
				}

			}
		});
		btnRefuse.setBounds(568, 147, 100, 23);
		contentPane.add(btnRefuse);

		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					patientSelected = patients.get(table.getSelectedRow());

					DisplayPatientAssigned dispPatient = new DisplayPatientAssigned(
							patientSelected);
					dispPatient.setLocationRelativeTo(null);

					dispPatient.setVisible(true);
					ListAssignedPatientsToDoctor.this.setVisible(false);

				} catch (Exception p) {
					JOptionPane.showMessageDialog(null,
							"Please select a patient.");
				}

			}
		});
		btnDisplay.setBounds(568, 181, 100, 23);
		contentPane.add(btnDisplay);

		JLabel lblListAssignedPatients = new JLabel("List assigned patients");
		lblListAssignedPatients.setForeground(SystemColor.desktop);
		lblListAssignedPatients.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListAssignedPatients.setBounds(172, 11, 326, 45);
		contentPane.add(lblListAssignedPatients);

		JButton backTobtn = new JButton("Back to menu");
		backTobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DoctorUI choixMenu= new DoctorUI(userConnected);
				choixMenu.setVisible(true);
				
			}
		});
		backTobtn.setBounds(541, 241, 127, 23);
		contentPane.add(backTobtn);
		
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<Patient, List<Patient>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ_WRITE, patients, table);
		//
		BeanProperty<Patient, Integer> patientBeanProperty = BeanProperty
				.create("userId");
		jTableBinding.addColumnBinding(patientBeanProperty).setColumnName(
				"Id patient");
		//
		BeanProperty<Patient, String> patientBeanProperty_1 = BeanProperty
				.create("firstName");
		jTableBinding.addColumnBinding(patientBeanProperty_1).setColumnName(
				"First name");
		//
		BeanProperty<Patient, String> patientBeanProperty_2 = BeanProperty
				.create("lastName");
		jTableBinding.addColumnBinding(patientBeanProperty_2).setColumnName(
				"Last name");
		//
		BeanProperty<Patient, String> patientBeanProperty_3 = BeanProperty
				.create("mail");
		jTableBinding.addColumnBinding(patientBeanProperty_3).setColumnName(
				"Mail");
		//
		jTableBinding.bind();
	}
}
