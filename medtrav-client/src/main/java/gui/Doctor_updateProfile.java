package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import entities.User;

public class Doctor_updateProfile extends JFrame {

	private JPanel contentPane;
	JLabel lblerror = new JLabel("");
	JLabel lblLoggedAs = new JLabel("");
	JButton btnNewButton = new JButton("Update profile");
	private JTextField tfCIN;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField tfMail;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_updateProfile frame = new Doctor_updateProfile();
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
	public Doctor_updateProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Doctor_updateProfile.class
				.getResource("/images/user_doctor_icon.png")));
		label.setBounds(644, 31, 60, 68);
		contentPane.add(label);

		tfCIN = new JTextField();
		tfCIN.setBackground(Color.WHITE);
		tfCIN.setBounds(138, 135, 177, 20);
		tfCIN.setEditable(false);
		contentPane.add(tfCIN);
		tfCIN.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(10, 114, 652, 238);
		contentPane.add(panel);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");

		JLabel lblPassword = new JLabel("Password");

		passwordField_1 = new JPasswordField();

		passwordField = new JPasswordField();

		JLabel lblMail = new JLabel("Mail");

		tfMail = new JTextField();
		tfMail.setColumns(10);

		lblerror.setForeground(Color.RED);

		JLabel lblCin = new JLabel("CIN");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(20)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						lblPassword,
																						GroupLayout.PREFERRED_SIZE,
																						60,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						lblConfirmPassword,
																						GroupLayout.PREFERRED_SIZE,
																						105,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						lblMail,
																						GroupLayout.PREFERRED_SIZE,
																						86,
																						GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.TRAILING,
																				false)
																				.addComponent(
																						lblerror,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						passwordField_1,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE,
																						174,
																						Short.MAX_VALUE)
																				.addComponent(
																						passwordField,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE,
																						174,
																						Short.MAX_VALUE)
																				.addComponent(
																						tfMail,
																						Alignment.LEADING)))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		lblCin,
																		GroupLayout.PREFERRED_SIZE,
																		45,
																		GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(347, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(23)
								.addComponent(lblCin)
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														tfMail,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblMail,
														GroupLayout.PREFERRED_SIZE,
														17,
														GroupLayout.PREFERRED_SIZE))
								.addGap(27)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														passwordField,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblPassword,
														GroupLayout.PREFERRED_SIZE,
														17,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														lblConfirmPassword)
												.addComponent(
														passwordField_1,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblerror)
								.addContainerGap(72, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JButton btnNewButton = new JButton("Update profile");

		btnNewButton.setBounds(460, 363, 159, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Doctor_updateProfile.class
				.getResource("/images/smallLogo.png")));
		lblNewLabel.setBounds(10, 35, 80, 68);
		contentPane.add(lblNewLabel);

		lblLoggedAs.setBounds(532, 11, 130, 23);
		contentPane.add(lblLoggedAs);
	}

	public Doctor_updateProfile(User doc) {

		lblLoggedAs.setText(doc.getLogin());
		tfCIN.setText(doc.getCin());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Doctor_updateProfile.class
				.getResource("/images/user_doctor_icon.png")));
		label.setBounds(644, 31, 60, 68);
		contentPane.add(label);

		tfCIN = new JTextField();
		tfCIN.setBackground(Color.WHITE);
		tfCIN.setBounds(138, 135, 177, 20);
		tfCIN.setEditable(false);
		contentPane.add(tfCIN);
		tfCIN.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(10, 114, 652, 238);
		contentPane.add(panel);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");

		JLabel lblPassword = new JLabel("Password");

		passwordField_1 = new JPasswordField();

		passwordField = new JPasswordField();

		JLabel lblMail = new JLabel("Mail");

		tfMail = new JTextField();
		tfMail.setColumns(10);

		lblerror.setForeground(Color.RED);

		JLabel lblCin = new JLabel("CIN");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(20)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						lblPassword,
																						GroupLayout.PREFERRED_SIZE,
																						60,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						lblConfirmPassword,
																						GroupLayout.PREFERRED_SIZE,
																						105,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						lblMail,
																						GroupLayout.PREFERRED_SIZE,
																						86,
																						GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.TRAILING,
																				false)
																				.addComponent(
																						lblerror,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						passwordField_1,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE,
																						174,
																						Short.MAX_VALUE)
																				.addComponent(
																						passwordField,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE,
																						174,
																						Short.MAX_VALUE)
																				.addComponent(
																						tfMail,
																						Alignment.LEADING)))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		lblCin,
																		GroupLayout.PREFERRED_SIZE,
																		45,
																		GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(347, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(23)
								.addComponent(lblCin)
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														tfMail,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblMail,
														GroupLayout.PREFERRED_SIZE,
														17,
														GroupLayout.PREFERRED_SIZE))
								.addGap(27)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														passwordField,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblPassword,
														GroupLayout.PREFERRED_SIZE,
														17,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														lblConfirmPassword)
												.addComponent(
														passwordField_1,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblerror)
								.addContainerGap(72, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JButton btnNewButton = new JButton("Update profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					if (!passwordField.equals(passwordField_1))
						lblerror.setText("Passwords don't match");
					else if (passwordField.getPassword().toString().length() > 0) {
						doc.setPassword(passwordField.getPassword().toString());
					}

					if (tfMail.getText().length() > 0) {
						doc.setMail(tfMail.getText());}
		}});


		btnNewButton.setBounds(460, 363, 159, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Doctor_updateProfile.class
				.getResource("/images/smallLogo.png")));
		lblNewLabel.setBounds(10, 35, 80, 68);
		contentPane.add(lblNewLabel);

		lblLoggedAs.setBounds(532, 11, 130, 23);
		contentPane.add(lblLoggedAs);
		
	}
		
}
