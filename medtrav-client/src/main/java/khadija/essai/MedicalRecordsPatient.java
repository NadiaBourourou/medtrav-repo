package khadija.essai;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import delegates.MedicalRecordsDelegate;
import entities.Patient;
import java.awt.Color;

public class MedicalRecordsPatient extends JFrame {

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
		btnAdd.setBounds(192, 86, 75, 53);
		btnAdd.setIcon(new ImageIcon(MedicalRecordsPatient.class.getResource("/images/upload.png")));
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
		textField.setBounds(96, 116, 86, 20);
		textField.setColumns(10);

		btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(92, 153, 51, 23);
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
				Patient p = new Patient ();
				p.setUserId(1);
				medicalRecords.setPatient(p);
				medicalRecords.setAnalysis(b);
				MedicalRecordsDelegate.doAddMedicalRecords(medicalRecords);

			}
		});

		lblAnalysis = new JLabel("Analysis");
		lblAnalysis.setBounds(31, 119, 39, 14);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(239, 132, 195, 130);
		label.setIcon(new ImageIcon(MedicalRecordsPatient.class.getResource("/images/medicalrecord.jpg")));
		contentPane.add(label);
		contentPane.add(lblAnalysis);
		contentPane.add(textField);
		contentPane.add(btnAdd);
		contentPane.add(btnAdd_1);
		
		JButton btnDownloadPatientfile = new JButton("Download PatientFile");
		btnDownloadPatientfile.setBounds(26, 215, 156, 23);
		contentPane.add(btnDownloadPatientfile);
	}
}
