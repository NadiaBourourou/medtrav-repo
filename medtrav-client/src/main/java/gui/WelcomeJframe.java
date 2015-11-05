package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import delegates.TreatmentServicesDelegate;
import entities.Doctor;
import entities.User;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WelcomeJframe extends JFrame {
	private User user;
	private JPanel contentPane;
	JComboBox cbProcedure = new JComboBox();
	JComboBox cbTreatment = new JComboBox();
	JLabel lblDescriptionLabel = new JLabel("");
	JLabel lblLoggedAs = new JLabel("");
	
	private List<Doctor>doctors;
	private Doctor selectedDoctor=new Doctor();
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
			TreatmentServicesDelegate.doFindAllProcedures();
			int taille = TreatmentServicesDelegate.doFindAllProcedures().size();
			for (int i = 0; i < taille; i++) {
				String name = TreatmentServicesDelegate.doFindAllProcedures()
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
			TreatmentServicesDelegate.doFindAllTreatmentsByProcedureId(index);
			int taille = TreatmentServicesDelegate
					.doFindAllTreatmentsByProcedureId(index).size();

			for (int i = 0; i < taille; i++) {
				String name = TreatmentServicesDelegate
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
		mntmLogOut.setIcon(new ImageIcon(WelcomeJframe.class.getResource("/images/logout-icon.png")));
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
				lblDescriptionLabel.setText(TreatmentServicesDelegate
						.doGetTreatmentDescription(1).toString());
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
		lblUser.setIcon(new ImageIcon(WelcomeJframe.class.getResource("/images/user_patient_icon.png")));
		lblUser.setBounds(642, 34, 62, 57);
		contentPane.add(lblUser);
		
		JLabel lblDoctors = new JLabel("Doctors ");
		lblDoctors.setBounds(12, 149, 91, 14);
		contentPane.add(lblDoctors);
		
		JPanel panel = new JPanel();
		panel.setBounds(134, 149, 295, 172);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);

	}

	public WelcomeJframe(User user) {
		JOptionPane.showMessageDialog(null,
				user.getFirstName() + user.getLastName());

		lblLoggedAs.setText("You are logged in as: \n" + user.getLastName()
				+ " " + user.getFirstName());
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmLogOut = new JMenuItem("Log Out");
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
				lblDescriptionLabel.setText(TreatmentServicesDelegate
						.doGetTreatmentDescription(1).toString());
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

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(138, 121, 207, 20);
		contentPane.add(dateChooser);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(138, 145, 207, 20);
		contentPane.add(dateChooser_1);

		lblLoggedAs.setBounds(151, 12, 534, 29);
		contentPane.add(lblLoggedAs);


	}
}
