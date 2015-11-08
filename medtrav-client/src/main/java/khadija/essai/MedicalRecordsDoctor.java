package khadija.essai;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import delegates.MedicalRecordsDelegate;
import delegates.UserServicesDelegate;
import entities.Patient;
import entities.User;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class MedicalRecordsDoctor extends JFrame {

	List<Patient> patients;
	User patientSelected = new User();

	private JPanel contentPane;
	private JTextField id;
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
		patients = UserServicesDelegate.doListAllPatient();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblPatientId = new JLabel("Patient Id");

		id = new JTextField();
		id.setEnabled(false);
		id.setColumns(10);

		JLabel lblPatientsFirstName = new JLabel("Patient's First name");

		prenom = new JTextField();
		prenom.setEnabled(false);
		prenom.setColumns(10);

		JLabel lblPatientsLastName = new JLabel("Patient's Last name");

		nom = new JTextField();
		nom.setEnabled(false);
		nom.setColumns(10);

		JLabel lblPatientFile = new JLabel("Patient File");

		file = new JTextField();
		file.setColumns(10);

		JButton btnUpload = new JButton("Upload");
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

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						.doFindMedicalRecordsByPatientId(Integer.parseInt(id
								.getText()));
				medicalRecords.setPatientFile(b);
				MedicalRecordsDelegate.doUpdateMedicalRecords(medicalRecords);

			}
		});

		JButton btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			private Blob b;
			private FileOutputStream output;

			public void actionPerformed(ActionEvent e) {
				byte[] analysis = MedicalRecordsDelegate
						.doDownloadAnalysis(1);
				b = null;
				try {

					File file = new File("KAD.docx");
					output = new FileOutputStream(file);	
					output.write(analysis);
					
					System.out.println(output.getFD()); 
					
					System.out.println(111);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPatientId)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPatientsFirstName)
						.addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPatientsLastName)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblPatientFile)
								.addGap(41))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnUpdate)
										.addComponent(btnDownload))
									.addGap(22))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(file, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpload)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(lblPatientId)
							.addGap(11)
							.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblPatientsFirstName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPatientsLastName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPatientFile)
								.addComponent(file, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpload)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDownload)
							.addGap(18)
							.addComponent(btnUpdate)))
					.addContainerGap(123, Short.MAX_VALUE))
		);

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
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								132, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(12, Short.MAX_VALUE)));

		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
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
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
				.create("text");
		AutoBinding<User, Integer, JTextField, String> autoBinding_3 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, patientSelected,
						userBeanProperty_3, id, jTextFieldBeanProperty);
		autoBinding_3.bind();
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
