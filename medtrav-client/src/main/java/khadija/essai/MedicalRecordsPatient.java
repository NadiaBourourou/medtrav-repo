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

		JButton btnAdd = new JButton("upload");
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
		textField.setColumns(10);

		btnAdd_1 = new JButton("Add");
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAnalysis)
							.addGap(35)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnAdd))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(83)
							.addComponent(btnAdd_1)))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(135, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAnalysis)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addGap(46)
					.addComponent(btnAdd_1)
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
