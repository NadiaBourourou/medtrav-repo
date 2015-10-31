package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import delegates.UserServicesDelegate;
import entities.Administrator;
import entities.Doctor;
import entities.Patient;
import entities.User;

import java.awt.Color;

import javax.swing.JMenuBar;

public class HelloMedtrav {

	private JFrame frmWelcomeToMedtrav;
	private JTextField tfLogin;
	private JPasswordField tfPassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloMedtrav window = new HelloMedtrav();
					window.frmWelcomeToMedtrav.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelloMedtrav() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcomeToMedtrav = new JFrame();
		frmWelcomeToMedtrav.getContentPane().setBackground(Color.WHITE);
		frmWelcomeToMedtrav.setTitle("Welcome to MedTrav");
		frmWelcomeToMedtrav.setBounds(100, 100, 730, 447);
		frmWelcomeToMedtrav.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToMedtrav.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(482, 162, 181, 59);
		frmWelcomeToMedtrav.getContentPane().add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblLogin = new JLabel("Login");
		panel.add(lblLogin, "2, 2");

		tfLogin = new JTextField();
		panel.add(tfLogin, "6, 2");
		tfLogin.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		panel.add(lblPassword, "2, 4");

		tfPassword = new JPasswordField();
		panel.add(tfPassword, "6, 4, fill, default");

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String username = tfLogin.getText();
					String password = new String(tfPassword.getPassword());
					User flen = UserServicesDelegate.doUserIdentification(
							username, password);
					if (flen == null) {
						JOptionPane.showMessageDialog(null,
								"Invalid crendentials ! ");

					} else {
						if (flen instanceof Administrator)
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										AdminUI frame = new AdminUI();
										frame.setVisible(true);
										frmWelcomeToMedtrav.setVisible(false);
									} catch (Exception e) {
							e.printStackTrace();
									}
								}
						});
						else if (flen instanceof Patient)
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										WelcomeJframe frame = new WelcomeJframe();
										frame.setVisible(true);
										frmWelcomeToMedtrav.setVisible(false);
									} catch (Exception e) {
							e.printStackTrace();
									}
								}
						});
						
						else if (flen instanceof Doctor)
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										WelcomeJframe frame = new WelcomeJframe();
										frame.setVisible(true);
										frmWelcomeToMedtrav.setVisible(false);
									} catch (Exception e) {
							e.printStackTrace();
									}
								}
						});
						
						
						
						
						
						
						
						
					/*	WelcomeJframe welcomeJframe = new WelcomeJframe();
						welcomeJframe.Welcome(username);
						welcomeJframe.setVisible(true);
						frmWelcomeToMedtrav.setVisible(false);
*/
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnLogin.setBounds(562, 232, 98, 23);
		frmWelcomeToMedtrav.getContentPane().add(btnLogin);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(HelloMedtrav.class.getResource("/images/medtrav.JPG")));
		logo.setBounds(75, 11, 350, 360);
		frmWelcomeToMedtrav.getContentPane().add(logo);
		
		JLabel Copyright = new JLabel("This project is brought to you by GTech\u00A9 2015 Sigma.  All rights reserved");
		Copyright.setForeground(Color.DARK_GRAY);
		Copyright.setBounds(28, 384, 532, 14);
		frmWelcomeToMedtrav.getContentPane().add(Copyright);
	}
}
