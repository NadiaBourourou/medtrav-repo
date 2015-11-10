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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import delegates.MedicalRecordsDelegate;
import delegates.UserServicesDelegate;
import entities.Patient;

public class MedicalRecordsPatient extends JFrame {

	Patient patient = new Patient();
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAdd_1;
	private JLabel lblAnalysis;

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
	public MedicalRecordsPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAdd = new JButton("");
		btnAdd.setBounds(203, 72, 52, 51);
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
		textField.setBounds(85, 84, 86, 20);
		textField.setColumns(10);

		btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(70, 163, 75, 23);
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
		lblAnalysis.setBounds(36, 87, 39, 14);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(239, 143, 195, 130);
		label.setIcon(new ImageIcon(MedicalRecordsPatient.class
				.getResource("/images/medicalrecord.jpg")));
		contentPane.add(label);
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
		btnDownloadPatientfile.setBounds(26, 215, 156, 23);
		contentPane.add(btnDownloadPatientfile);
	}
}
