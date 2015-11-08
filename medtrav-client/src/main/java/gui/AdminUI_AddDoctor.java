package gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import delegates.UserServicesDelegate;
import entities.Doctor;
import entities.RoleType;
import entities.User;

public class AdminUI_AddDoctor extends JFrame {
	private User user;
	private JFrame frame;
	private JPanel contentpane;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfCin;
	private JTextField tfMail;
	private JTextField tfSpecialty;
	JLabel lblLoggedAs = new JLabel("");


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI_AddDoctor frame = new AdminUI_AddDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminUI_AddDoctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentpane = new JPanel();
		contentpane.setBackground(Color.WHITE);
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AdminUI.class
				.getResource("/images/smallLogo.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogo.setBounds(10, 11, 69, 74);
		contentpane.add(lblLogo);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(334, 98, 69, 14);
		contentpane.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(334, 129, 69, 14);
		contentpane.add(lblLastName);

		JLabel lblCin = new JLabel("CIN");
		lblCin.setBounds(334, 154, 46, 14);
		contentpane.add(lblCin);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(334, 179, 46, 14);
		contentpane.add(lblMail);

		JLabel lblSpecialty = new JLabel("Specialty");
		lblSpecialty.setBounds(334, 204, 69, 14);
		contentpane.add(lblSpecialty);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(334, 229, 69, 14);
		contentpane.add(lblDescription);

		tfFirstName = new JTextField();
		tfFirstName.setBounds(421, 95, 196, 20);
		contentpane.add(tfFirstName);
		tfFirstName.setColumns(10);

		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(421, 126, 196, 20);
		contentpane.add(tfLastName);

		tfCin = new JTextField();
		tfCin.setBounds(421, 151, 196, 20);
		contentpane.add(tfCin);
		tfCin.setColumns(10);

		tfMail = new JTextField();
		tfMail.setBounds(421, 176, 196, 20);
		contentpane.add(tfMail);
		tfMail.setColumns(10);

		tfSpecialty = new JTextField();
		tfSpecialty.setBounds(421, 201, 196, 20);
		contentpane.add(tfSpecialty);
		tfSpecialty.setColumns(10);

		JTextArea tAreaDescription = new JTextArea();
		tAreaDescription.setBackground(Color.WHITE);
		tAreaDescription.setForeground(Color.BLACK);
		tAreaDescription.setBounds(420, 229, 196, 91);
		contentpane.add(tAreaDescription);

		JLabel lblDoctor = new JLabel("");
		lblDoctor.setIcon(new ImageIcon(AdminUI_AddDoctor.class
				.getResource("/images/profile_doctor_icon.png")));
		lblDoctor.setBounds(68, 74, 232, 286);
		contentpane.add(lblDoctor);

		Button btnAdd = new Button("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Doctor newDoc = new Doctor();

				newDoc.setFirstName(tfFirstName.getText());
				newDoc.setLastName(tfLastName.getText());
				newDoc.setCin(tfCin.getText());
				newDoc.setMail(tfMail.getText());
				newDoc.setLogin(tfFirstName.getText() + "."
						+ tfLastName.getText());
				newDoc.setRole(RoleType.DOCTOR);
				newDoc.setPassword("pwd" + tfLastName.getText());
				newDoc.setSpecialty(tfSpecialty.getText());
				newDoc.setDescription(tAreaDescription.getText());

				if (UserServicesDelegate.doaAddDocor(newDoc)) {
					JOptionPane.showMessageDialog(null,
							"Dr " + tfLastName.getText()
									+ " has successfully been added.");
					setVisible(false);
					AdminUI_ListOfDoctors frame=new AdminUI_ListOfDoctors();
					frame.setVisible(true);
					
				}

			}
		});
		btnAdd.setBounds(547, 326, 70, 22);
		contentpane.add(btnAdd);

		Button btnReset = new Button("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCin.setText("");
				tfLastName.setText("");
				tfFirstName.setText("");
				tfMail.setText("");
				tfSpecialty.setText("");
				tAreaDescription.setText("");

			}
		});
		btnReset.setBounds(421, 326, 70, 22);
		contentpane.add(btnReset);

		Button btnBack = new Button("Back to list");
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminUI_ListOfDoctors frame=new AdminUI_ListOfDoctors();
				frame.setVisible(true);
		
			}
		});
		btnBack.setBounds(9, 377, 88, 22);
		contentpane.add(btnBack);
		
	;
		lblLoggedAs.setBounds(547, 11, 141, 20);
		contentpane.add(lblLoggedAs);
		
	}
	
	public AdminUI_AddDoctor(User user) {
		lblLoggedAs.setText(user.getLogin());
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentpane = new JPanel();
		contentpane.setBackground(Color.WHITE);
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AdminUI.class
				.getResource("/images/smallLogo.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogo.setBounds(10, 11, 69, 74);
		contentpane.add(lblLogo);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(334, 98, 69, 14);
		contentpane.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(334, 129, 69, 14);
		contentpane.add(lblLastName);

		JLabel lblCin = new JLabel("CIN");
		lblCin.setBounds(334, 154, 46, 14);
		contentpane.add(lblCin);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(334, 179, 46, 14);
		contentpane.add(lblMail);

		JLabel lblSpecialty = new JLabel("Specialty");
		lblSpecialty.setBounds(334, 204, 69, 14);
		contentpane.add(lblSpecialty);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(334, 229, 69, 14);
		contentpane.add(lblDescription);

		tfFirstName = new JTextField();
		tfFirstName.setBounds(421, 95, 196, 20);
		contentpane.add(tfFirstName);
		tfFirstName.setColumns(10);

		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(421, 126, 196, 20);
		contentpane.add(tfLastName);

		tfCin = new JTextField();
		tfCin.setBounds(421, 151, 196, 20);
		contentpane.add(tfCin);
		tfCin.setColumns(10);

		tfMail = new JTextField();
		tfMail.setBounds(421, 176, 196, 20);
		contentpane.add(tfMail);
		tfMail.setColumns(10);

		tfSpecialty = new JTextField();
		tfSpecialty.setBounds(421, 201, 196, 20);
		contentpane.add(tfSpecialty);
		tfSpecialty.setColumns(10);

		JTextArea tAreaDescription = new JTextArea();
		tAreaDescription.setBackground(Color.WHITE);
		tAreaDescription.setForeground(Color.BLACK);
		tAreaDescription.setBounds(420, 229, 196, 91);
		contentpane.add(tAreaDescription);

		JLabel lblDoctor = new JLabel("");
		lblDoctor.setIcon(new ImageIcon(AdminUI_AddDoctor.class
				.getResource("/images/profile_doctor_icon.png")));
		lblDoctor.setBounds(68, 74, 232, 286);
		contentpane.add(lblDoctor);

		Button btnAdd = new Button("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Doctor newDoc = new Doctor();

				newDoc.setFirstName(tfFirstName.getText());
				newDoc.setLastName(tfLastName.getText());
				newDoc.setCin(tfCin.getText());
				newDoc.setMail(tfMail.getText());
				newDoc.setLogin(tfFirstName.getText() + "."
						+ tfLastName.getText());
				newDoc.setRole(RoleType.DOCTOR);
				newDoc.setPassword("pwd" + tfLastName.getText());
				newDoc.setSpecialty(tfSpecialty.getText());
				newDoc.setDescription(tAreaDescription.getText());

				if (UserServicesDelegate.doaAddDocor(newDoc)) {
					JOptionPane.showMessageDialog(null,
							"Dr " + tfLastName.getText()
									+ " has successfully been added.");
					setVisible(false);
					AdminUI_ListOfDoctors frame=new AdminUI_ListOfDoctors();
					frame.setVisible(true);
					
				}

			}
		});
		btnAdd.setBounds(547, 326, 70, 22);
		contentpane.add(btnAdd);

		Button btnReset = new Button("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCin.setText("");
				tfLastName.setText("");
				tfFirstName.setText("");
				tfMail.setText("");
				tfSpecialty.setText("");
				tAreaDescription.setText("");

			}
		});
		btnReset.setBounds(421, 326, 70, 22);
		contentpane.add(btnReset);

		Button btnBack = new Button("Back to list");
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminUI_ListOfDoctors frame=new AdminUI_ListOfDoctors();
				frame.setVisible(true);
		
			}
		});
		btnBack.setBounds(9, 377, 88, 22);
		contentpane.add(btnBack);
		JLabel UserIcon = new JLabel("");
		UserIcon.setIcon(new ImageIcon(AdminUI_AddDoctor.class.getResource("/images/User_administrator-icon.png")));
		UserIcon.setBounds(641, 42, 63, 53);
		contentpane.add(UserIcon);
	}
}
