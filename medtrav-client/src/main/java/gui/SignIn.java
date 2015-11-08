package gui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.type.IntegerType;

import delegates.FeaturesDomainDelegate;
import delegates.UserServicesDelegate;
import entities.Patient;
import entities.UserSexe;

public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField cin;
	private JTextField country;
	private JTextField mail;
	JLabel lblError = new JLabel("");
	Patient newPatient = new Patient();
	Choice choice = new Choice();
	private JTextField passport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(24, 99, 141, 14);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(24, 127, 113, 14);

		JLabel lblNewLabel = new JLabel("CIN");
		lblNewLabel.setBounds(24, 205, 74, 14);

		JLabel lblNewLabel_1 = new JLabel("Country");
		lblNewLabel_1.setBounds(24, 230, 74, 14);

		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setBounds(24, 155, 113, 14);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(24, 288, 113, 14);

		firstName = new JTextField();
		firstName.setBounds(195, 96, 213, 20);
		firstName.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblMail);
		contentPane.add(lblFirstName);
		contentPane.add(firstName);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblLastName);
		contentPane.add(lblNewLabel);
		contentPane.add(lblDateOfBirth);

		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(195, 124, 213, 20);
		contentPane.add(lastName);

		cin = new JTextField();
		cin.setColumns(10);
		cin.setBounds(195, 202, 213, 20);
		contentPane.add(cin);

		country = new JTextField();
		country.setColumns(10);
		country.setBounds(195, 227, 213, 20);
		contentPane.add(country);

		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(195, 285, 213, 20);
		contentPane.add(mail);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SignIn.class
				.getResource("/images/smallLogo.png")));
		label.setBounds(29, 11, 69, 57);
		contentPane.add(label);

		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setBounds(24, 180, 94, 14);
		contentPane.add(lblSexe);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SignIn.class
				.getResource("/images/patientIconBig.jpg")));
		label_1.setBounds(456, 60, 213, 268);
		contentPane.add(label_1);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstName.getText().length() == 0
						|| lastName.getText().length() == 0
						|| cin.getText().length() == 0
						|| mail.getText().length() == 0
						|| country.getText().length() == 0) {
					lblError.setText("Missing info. ");
				} else {

					newPatient.setFirstName(firstName.getText());
					newPatient.setLastName(lastName.getText());
					if (choice.getSelectedIndex() == 0) {
						newPatient.setSexe(UserSexe.Male);
					} else if (choice.getSelectedIndex() == 1) {
						newPatient.setSexe(UserSexe.Female);
					} else if (choice.getSelectedIndex() == 2) {
						newPatient.setSexe(UserSexe.Other);
					}
					newPatient.setNumPassport(Integer.parseInt(passport.getText()));
					newPatient.setCin(cin.getText());
					newPatient.setMail(mail.getText());
					// mail.getText().contains('@');
					newPatient.setCountry(country.getText());
					newPatient.setLogin(firstName.getText() + "."
							+ lastName.getText());
					newPatient.setPassword("pwd" + firstName.getText());

					UserServicesDelegate.doAddPatient(newPatient);
					String message = FeaturesDomainDelegate
							.doPatientLoginAndPassword(newPatient.getLogin(),
									newPatient.getPassword());

					String[] to = { newPatient.getMail() };

					if (FeaturesDomainDelegate.doSendEmail(
							"medtrav.gtech@gmail.com", "pidevgtech", message,
							to)) {
						System.out.println("Email sent successfully");
						JOptionPane
								.showConfirmDialog(null,
										"Please check your mail to get your credentials.");
					} else
						System.out.println("Some error occured");

				}
			}
		});
		btnRegister.setBounds(319, 336, 89, 23);
		contentPane.add(btnRegister);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstName.setText("");
				lastName.setText("");
				cin.setText("");
				country.setText("");
				mail.setText("");
				lblError.setText("");

			}
		});
		btnReset.setBounds(191, 336, 89, 23);
		contentPane.add(btnReset);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(9, 375, 89, 23);
		contentPane.add(btnBack);
		lblError.setForeground(Color.RED);

		lblError.setBounds(10, 313, 185, 23);
		contentPane.add(lblError);

		choice.add("Male");
		choice.add("Female");
		choice.add("3rd gender");
		choice.setBounds(195, 176, 213, 20);
		contentPane.add(choice);
		
		JLabel lblPassportNumber = new JLabel("Passport Number");
		lblPassportNumber.setBounds(24, 263, 113, 14);
		contentPane.add(lblPassportNumber);
		
		passport = new JTextField();
		passport.setColumns(10);
		passport.setBounds(195, 258, 213, 20);
		contentPane.add(passport);
	}
}
