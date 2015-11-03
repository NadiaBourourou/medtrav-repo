package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import entities.User;

public class WelcomeJframe extends JFrame {
	private User user;
	private JPanel contentPane;
	JComboBox cbProcedure = new JComboBox();
	JComboBox cbTreatment = new JComboBox();
	JLabel lblDescriptionLabel = new JLabel("");
	JLabel lblLoggedAs = new JLabel("");

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

	public WelcomeJframe(User user) {
		JOptionPane.showMessageDialog(null,
				user.getFirstName() + user.getLastName());

		lblLoggedAs.setText("You are logged in as: \n" + user.getLastName()
				+ " " + user.getFirstName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);

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
