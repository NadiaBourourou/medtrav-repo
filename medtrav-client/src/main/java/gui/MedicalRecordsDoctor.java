package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import delegates.MedicalRecordsDelegate;
import entities.Patient;
import entities.User;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextArea;

public class MedicalRecordsDoctor extends JFrame {

	List<Patient> patients;
	Patient patient = new Patient();
	User patientSelected = new User();

	private JPanel contentPane;
	private JTextField prenom;
	private JTextField nom;
	private JTextField file;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalRecordsDoctor frame = new MedicalRecordsDoctor();
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
	public MedicalRecordsDoctor() {

		setVisible(true);
		patients = MedicalRecordsDelegate.doListAssignedPatientsToDoctor(3);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 365);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblPatientsFirstName = new JLabel("Patient's First name");
		lblPatientsFirstName.setBounds(15, 161, 124, 14);

		prenom = new JTextField();
		prenom.setBounds(15, 186, 86, 20);
		prenom.setColumns(10);

		JLabel lblPatientsLastName = new JLabel("Patient's Last name");
		lblPatientsLastName.setBounds(16, 217, 123, 14);

		nom = new JTextField();
		nom.setBounds(15, 242, 86, 20);
		nom.setColumns(10);

		JLabel lblPatientFile = new JLabel("Patient File");
		lblPatientFile.setBounds(10, 287, 53, 14);

		file = new JTextField();
		file.setBounds(85, 284, 86, 20);
		file.setColumns(10);

		JButton btnUpload = new JButton("");
		btnUpload.setIcon(new ImageIcon(MedicalRecordsDoctor.class
				.getResource("/images/uploadd.png")));
		btnUpload.setBounds(181, 268, 45, 48);
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				file.setText(filename);
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(210, 90, 301, 155);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(236, 283, 77, 23);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!file.getText().isEmpty()) {
					entities.MedicalRecords medicalRecords = new entities.MedicalRecords();

					File fichier = new File(file.getText());
					FileReader fr = null;
					try {
						fr = new FileReader(fichier);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ArrayList<Byte> list = new ArrayList<Byte>();
					int s;
					try {
						while ((s = fr.read()) != -1) {
							list.add((byte) s);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					byte[] b = new byte[list.size()];
					for (int i = 0; i < b.length; i++) {
						b[i] = list.get(i);
					}
					medicalRecords = MedicalRecordsDelegate
							.doFindMedicalRecordsByPatientId(patient
									.getUserId());
					medicalRecords.setPatientFile(b);
					MedicalRecordsDelegate
							.doUpdateMedicalRecords(medicalRecords);

				} else {
					JOptionPane.showMessageDialog(null,
							"Please choose a patient file to upload");
				}
			}
		});

		JButton btnDownload = new JButton("");
		btnDownload.setIcon(new ImageIcon(MedicalRecordsDoctor.class
				.getResource("/images/arrow-download-icon.png")));
		btnDownload.setBounds(413, 258, 53, 48);
		btnDownload.addActionListener(new ActionListener() {

			private FileOutputStream output;

			public void actionPerformed(ActionEvent e) {

				patient = patients.get(table.getSelectedRow());
				byte[] analysis = MedicalRecordsDelegate
						.doDownloadAnalysis(patient.getUserId());

				try {
					File file = new File(patient.getFirstName() + " "
							+ patient.getLastName() + ".txt");

					output = new FileOutputStream(file);
					output.write(analysis);
					FileReader fileReader = new FileReader(file);
					BufferedReader br = new BufferedReader(fileReader);
					LectureFichier lectureFichier = new LectureFichier();
					lectureFichier.textArea.read(br, null);
					br.close();		
					lectureFichier.setVisible(true);
				
					


				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								284, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel.createSequentialGroup()
						.addContainerGap(12, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								132, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(null);
		contentPane.add(lblPatientsFirstName);
		contentPane.add(prenom);
		contentPane.add(lblPatientsLastName);
		contentPane.add(nom);
		contentPane.add(lblPatientFile);
		contentPane.add(panel);
		contentPane.add(btnUpdate);
		contentPane.add(btnDownload);
		contentPane.add(file);
		contentPane.add(btnUpload);

		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(MedicalRecordsDoctor.class
				.getResource("/images/rechercher.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(prenom.getText().isEmpty()) && !(nom.getText().isEmpty())) {
					try {
						patient = MedicalRecordsDelegate
								.doFindPatientByFirstNameAndLastName(
										prenom.getText(), nom.getText());
						patients.clear();
						patients.add(patient);
						initDataBindings();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"The patient does not exist");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Please fill out all required fields ");
				}

			}
		});
		btnSearch.setBounds(148, 172, 52, 48);
		contentPane.add(btnSearch);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<Patient, List<Patient>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ_WRITE, patients, table);
		//
		BeanProperty<Patient, Integer> userBeanProperty = BeanProperty
				.create("userId");
		jTableBinding.addColumnBinding(userBeanProperty).setColumnName(
				"Patient Id");
		//
		BeanProperty<Patient, String> userBeanProperty_1 = BeanProperty
				.create("firstName");
		jTableBinding.addColumnBinding(userBeanProperty_1).setColumnName(
				"Patient First name");
		//
		BeanProperty<Patient, String> userBeanProperty_2 = BeanProperty
				.create("lastName");
		jTableBinding.addColumnBinding(userBeanProperty_2).setColumnName(
				"Patient Last Name");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty = BeanProperty
				.create("selectedElement.userId");
		BeanProperty<User, Integer> userBeanProperty_3 = BeanProperty
				.create("userId");
		AutoBinding<JTable, Integer, User, Integer> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty, patientSelected, userBeanProperty_3);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty
				.create("selectedElement.firstName");
		BeanProperty<User, String> userBeanProperty_4 = BeanProperty
				.create("firstName");
		AutoBinding<JTable, String, User, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_1, patientSelected,
						userBeanProperty_4);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty
				.create("selectedElement.lastName");
		BeanProperty<User, String> userBeanProperty_5 = BeanProperty
				.create("lastName");
		AutoBinding<JTable, String, User, String> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_2, patientSelected,
						userBeanProperty_5);
		autoBinding_2.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
				.create("text");
		AutoBinding<User, String, JTextField, String> autoBinding_4 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, patientSelected,
						userBeanProperty_4, prenom, jTextFieldBeanProperty_1);
		autoBinding_4.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty
				.create("text");
		AutoBinding<User, String, JTextField, String> autoBinding_5 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, patientSelected,
						userBeanProperty_5, nom, jTextFieldBeanProperty_2);
		autoBinding_5.bind();
	}
}
