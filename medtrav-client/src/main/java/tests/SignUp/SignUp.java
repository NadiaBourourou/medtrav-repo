package tests.SignUp;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import datechooser.beans.DateChooserCombo;
import delegates.UserServicesDelegate;
import entities.Patient;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField Cin;
	private JTextField passport;
	private JTextField country;
	private JTextField mail;
	private JTextField login;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						"C:\\Users\\Asma\\Desktop\\12003953_725152407612606_3945550521548834012_n.jpg"));
		setForeground(UIManager.getColor("Button.shadow"));
		setType(Type.POPUP);
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 377);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		setContentPane(contentPane);

		JLabel lblFirstName = new JLabel("First Name");

		JLabel lblLastName = new JLabel("Last Name");

		JLabel lblCin = new JLabel("CIN");

		JLabel lblPassportNumber = new JLabel("Passport Number");

		JLabel lblDateOfBirth = new JLabel("Date Of Birth");

		JLabel lblCountry = new JLabel("Country");

		JLabel lblMail = new JLabel("Mail");

		JLabel lblLogin = new JLabel("Login");

		JLabel lblPassword = new JLabel("Password");

		FirstName = new JTextField();
		FirstName.setColumns(10);

		LastName = new JTextField();
		LastName.setColumns(10);

		Cin = new JTextField();
		Cin.setColumns(10);

		passport = new JTextField();
		passport.setColumns(10);

		country = new JTextField();
		country.setColumns(10);

		mail = new JTextField();
		mail.setColumns(10);

		login = new JTextField();
		login.setColumns(10);

		passwordField = new JPasswordField();

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient p = new Patient();
				p.setFirstName(FirstName.getText());
				p.setLastName(LastName.getText());

				Integer cinI = new Integer(Cin.getText());
				Integer i = cinI.intValue();
				p.setCin(i);
				p.setLogin(login.getText());
				p.setPassword(new String(passwordField.getPassword()));
				// p.setDateOfBirth(DateChooserCombo);
				p.setMail(mail.getText());
				p.setCountry(country.getText());
				Integer ger = new Integer(passport.getText());
				Integer i2 = ger.intValue();
				p.setNumPassport(i2);

				UserServicesDelegate.doAddPatient(p);

			}
		});

		DateChooserCombo dateChooserCombo = new DateChooserCombo();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(38)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblLastName)
														.addComponent(
																lblDateOfBirth)
														.addComponent(
																lblFirstName)
														.addComponent(
																lblCin,
																GroupLayout.PREFERRED_SIZE,
																31,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblLogin)
														.addComponent(lblMail)
														.addComponent(
																lblCountry)
														.addComponent(
																lblPassportNumber)
														.addComponent(
																lblPassword))
										.addGap(41)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								country)
																						.addComponent(
																								passwordField)
																						.addComponent(
																								FirstName)
																						.addComponent(
																								login)
																						.addComponent(
																								mail)
																						.addComponent(
																								passport)
																						.addComponent(
																								Cin)
																						.addComponent(
																								LastName))
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				102,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnSubmit)
																		.addGap(20))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				dateChooserCombo,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap()))));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(45)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																FirstName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblFirstName))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblLastName)
														.addComponent(
																LastName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblDateOfBirth)
														.addComponent(
																dateChooserCombo,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																Cin,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblCin))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																passport,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblPassportNumber))
										.addGap(8)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblCountry)
														.addComponent(
																country,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																mail,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblMail))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																login,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblLogin))
										.addPreferredGap(
												ComponentPlacement.RELATED, 7,
												Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblPassword)
														.addComponent(
																passwordField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18).addComponent(btnSubmit)
										.addGap(19)));
		contentPane.setLayout(gl_contentPane);
	}
}
