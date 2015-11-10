package gui;

import java.awt.Color;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.skype.Skype;
import com.skype.SkypeException;

import delegates.MedicalRecordsDelegate;
import delegates.UserServicesDelegate;
import entities.Patient;
import entities.User;
import featuresDomain.chat.Constants;

public class MedicalRecordsPatient extends JFrame {

	Patient patient = new Patient();
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAdd_1;
	private JLabel lblAnalysis;
	private JLabel logo;
	private JLabel userIcon;
	private JButton btnCallMyDoctor;
	private JLabel skypelogo;
	public  String SKYPE_FRIEND_NICKNAME = "naddoouu011108";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalRecordsPatient frame = new MedicalRecordsPatient();
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
	public MedicalRecordsPatient(User user) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAdd = new JButton("");
		btnAdd.setBounds(367, 273, 52, 51);
		btnAdd.setIcon(new ImageIcon(MedicalRecordsPatient.class
				.getResource("/images/uploadd.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				textField.setText(filename);
			}
		});

		textField = new JTextField();
		textField.setBounds(191, 271, 156, 20);
		textField.setColumns(10);

		btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(186, 302, 161, 23);
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entities.MedicalRecords medicalRecords = new entities.MedicalRecords();
				File fichier = new File(textField.getText());
				FileReader fr = null;
				try {
					fr = new FileReader(fichier);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
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
				Patient p = new Patient();
				p.setUserId(user.getUserId());
				;
				medicalRecords.setPatient(p);
				medicalRecords.setAnalysis(b);
				MedicalRecordsDelegate.doAddMedicalRecords(medicalRecords);
				JOptionPane.showMessageDialog(null, "Analysis Uploaded successfully");

			}
		});

		lblAnalysis = new JLabel("Analysis");
		lblAnalysis.setBounds(46, 273, 105, 17);
		contentPane.setLayout(null);
		contentPane.add(lblAnalysis);
		contentPane.add(textField);
		contentPane.add(btnAdd);
		contentPane.add(btnAdd_1);

		JButton btnDownloadPatientfile = new JButton("Download PatientFile");
		btnDownloadPatientfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				patient = UserServicesDelegate.doFindPatientById(user
						.getUserId());
				byte[] patientFile = MedicalRecordsDelegate
						.doDownloadPatientFile(patient.getUserId());
				try {
					File file = new File(patient.getFirstName() + " "
							+ patient.getLastName() + ".txt");
					FileOutputStream output = new FileOutputStream(file);
					output.write(patientFile);
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
		btnDownloadPatientfile.setBounds(191, 334, 156, 23);
		contentPane.add(btnDownloadPatientfile);

		logo = new JLabel("");
		logo.setIcon(new ImageIcon(MedicalRecordsPatient.class
				.getResource("/images/smallLogo.png")));
		logo.setBounds(10, 11, 85, 84);
		contentPane.add(logo);

		userIcon = new JLabel("");
		userIcon.setIcon(new ImageIcon(MedicalRecordsPatient.class
				.getResource("/images/user_patient_icon.png")));
		userIcon.setBounds(652, 11, 52, 62);
		contentPane.add(userIcon);

		btnCallMyDoctor = new JButton("CALL MY DOCTOR!");
		btnCallMyDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
					try {
						Skype.call(SKYPE_FRIEND_NICKNAME);
					} catch (SkypeException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "sorry");
					}
			
		
			}
		});
		btnCallMyDoctor.setBounds(468, 262, 215, 62);
		contentPane.add(btnCallMyDoctor);

		skypelogo = new JLabel("");
		skypelogo.setIcon(new ImageIcon(MedicalRecordsPatient.class
				.getResource("/images/skype.png")));
		skypelogo.setBounds(495, 92, 187, 159);
		contentPane.add(skypelogo);
	}

	public MedicalRecordsPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAdd = new JButton("");
		btnAdd.setBounds(367, 273, 52, 51);
		btnAdd.setIcon(new ImageIcon(MedicalRecordsPatient.class
				.getResource("/images/uploadd.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				textField.setText(filename);
			}
		});

		textField = new JTextField();
		textField.setBounds(191, 271, 156, 20);
		textField.setColumns(10);

		btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(186, 302, 161, 23);
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entities.MedicalRecords medicalRecords = new entities.MedicalRecords();
				File fichier = new File(textField.getText());
				FileReader fr = null;
				try {
					fr = new FileReader(fichier);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
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
				Patient p = new Patient();
				p.setUserId(1);
				medicalRecords.setPatient(p);
				medicalRecords.setAnalysis(b);
				MedicalRecordsDelegate.doAddMedicalRecords(medicalRecords);

			}
		});

		lblAnalysis = new JLabel("Analysis");
		lblAnalysis.setBounds(46, 273, 105, 17);
		contentPane.setLayout(null);
		contentPane.add(lblAnalysis);
		contentPane.add(textField);
		contentPane.add(btnAdd);
		contentPane.add(btnAdd_1);

		JButton btnDownloadPatientfile = new JButton("Download PatientFile");
		btnDownloadPatientfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				patient = UserServicesDelegate.doFindPatientById(1);
				byte[] patientFile = MedicalRecordsDelegate
						.doDownloadPatientFile(patient.getUserId());
				try {
					File file = new File(patient.getFirstName() + " "
							+ patient.getLastName() + ".txt");
					FileOutputStream output = new FileOutputStream(file);
					output.write(patientFile);
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
		btnDownloadPatientfile.setBounds(191, 334, 156, 23);
		contentPane.add(btnDownloadPatientfile);

		logo = new JLabel("");
		logo.setIcon(new ImageIcon(MedicalRecordsPatient.class
				.getResource("/images/smallLogo.png")));
		logo.setBounds(10, 11, 85, 84);
		contentPane.add(logo);

		userIcon = new JLabel("");
		userIcon.setIcon(new ImageIcon(MedicalRecordsPatient.class
				.getResource("/images/user_patient_icon.png")));
		userIcon.setBounds(652, 11, 52, 62);
		contentPane.add(userIcon);

		btnCallMyDoctor = new JButton("CALL MY DOCTOR!");
		btnCallMyDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
					try {
						Skype.call(SKYPE_FRIEND_NICKNAME);
					} catch (SkypeException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "sorry");
					}
			
		
			}
		});

		btnCallMyDoctor.setBounds(468, 262, 215, 62);
		contentPane.add(btnCallMyDoctor);

		skypelogo = new JLabel("");
		skypelogo.setIcon(new ImageIcon(MedicalRecordsPatient.class
				.getResource("/images/skype.png")));
		skypelogo.setBounds(495, 92, 187, 159);
		contentPane.add(skypelogo);
	}
}
