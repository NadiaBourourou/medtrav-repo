package gui.assignedPatients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegates.AssigedPatientsServicesDelegate;
import entities.Patient;
import entities.Surgery;
import entities.User;
import gui.testimonies.DisplayTestimony;
import gui.testimonies.ListTestimonies;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class DisplayPatientAssigned extends JFrame {

	private JPanel contentPane;
    static Patient patientSelected;
    private User userConnected;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayPatientAssigned frame = new DisplayPatientAssigned(patientSelected);
					frame.setLocationRelativeTo(null);
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
	public DisplayPatientAssigned(Patient patientSelected) {
		this.patientSelected=patientSelected;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDisplayPatient = new JLabel("Display patient");
		lblDisplayPatient.setForeground(SystemColor.desktop);
		lblDisplayPatient.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDisplayPatient.setBounds(270, 11, 216, 45);
		contentPane.add(lblDisplayPatient);
		
		JButton button = new JButton("Return");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListAssignedPatientsToDoctor dispTestimony= new ListAssignedPatientsToDoctor();
				dispTestimony.setLocationRelativeTo(null);
				
				dispTestimony.setVisible(true);
				DisplayPatientAssigned.this.setVisible(false);
			}
		});
		button.setBounds(36, 394, 89, 23);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(114, 94, 500, 278);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Patient Name :");
		label_1.setForeground(new Color(0, 128, 128));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(10, 11, 140, 39);
		panel.add(label_1);
		
		JLabel lblCi = new JLabel("CNI :");
		lblCi.setForeground(new Color(0, 128, 128));
		lblCi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCi.setBounds(289, 11, 45, 39);
		panel.add(lblCi);
		
		JLabel lblMail = new JLabel("Mail :");
		lblMail.setForeground(new Color(0, 128, 128));
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMail.setBounds(10, 108, 50, 39);
		panel.add(lblMail);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setForeground(new Color(0, 128, 128));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(10, 61, 74, 39);
		panel.add(lblGender);
		
		JLabel cin = new JLabel((String) null);
		cin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cin.setEnabled(false);
		cin.setBounds(334, 23, 142, 14);
		panel.add(cin);
		
		JLabel lblConfirmed = new JLabel("Confirmed : ");
		lblConfirmed.setForeground(new Color(0, 128, 128));
		lblConfirmed.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConfirmed.setBounds(10, 209, 106, 39);
		panel.add(lblConfirmed);
		
		JLabel name = new JLabel("");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setEnabled(false);
		name.setBounds(123, 20, 169, 14);
		panel.add(name);
		
		JLabel gender = new JLabel("");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gender.setEnabled(false);
		gender.setBounds(73, 71, 116, 14);
		panel.add(gender);
		
		JLabel mail = new JLabel("");
		mail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mail.setEnabled(false);
		mail.setBounds(55, 120, 210, 14);
		panel.add(mail);
		
		JLabel confirmed = new JLabel("");
		confirmed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirmed.setBounds(104, 209, 74, 26);
		panel.add(confirmed);
		
		if(patientSelected.getConfirmed()==null){
			confirmed.setForeground(new Color(220, 20, 60));
			confirmed.setText("No");}
		else if(patientSelected.getConfirmed()==true){
			confirmed.setForeground(new Color(199, 21, 133));
			confirmed.setText("Yes");	
		}
		else
		{
			confirmed.setForeground(new Color(220, 20, 60));
			confirmed.setText("No");
		}
		JLabel tfsurgery = new JLabel("");
		tfsurgery.setBounds(85, 159, 309, 25);
		panel.add(tfsurgery);
		

		JLabel lblSurgery = new JLabel("Surgery :");
		lblSurgery.setForeground(new Color(0, 128, 128));
		lblSurgery.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSurgery.setBounds(10, 159, 74, 39);
		panel.add(lblSurgery);
		
		cin.setText(patientSelected.getCin().toString());
		name.setText(patientSelected.getFirstName()+" "+patientSelected.getLastName());
mail.setText(patientSelected.getMail());
try{Surgery surgery=AssigedPatientsServicesDelegate.doFindSurgeryByPatientId(patientSelected.getUserId());
System.out.println(surgery.getName());

tfsurgery.setText(surgery.getDate().toString());}

catch(Exception n){lblSurgery.setVisible(false);}
		gender.setText(patientSelected.getSexe().toString());
		
		
	
		
		
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public DisplayPatientAssigned(Patient patientSelected, User userConnected) {
		System.out.println("DISPLAY PATIENT ASSIGNED ");
		System.out.println("user co id="+userConnected.getUserId());
		System.out.println("user co name="+userConnected.getFirstName()+userConnected.getLastName());		
		
		this.patientSelected=patientSelected;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDisplayPatient = new JLabel("Display patient");
		lblDisplayPatient.setForeground(SystemColor.desktop);
		lblDisplayPatient.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDisplayPatient.setBounds(270, 11, 216, 45);
		contentPane.add(lblDisplayPatient);
		
		JButton button = new JButton("Return");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListAssignedPatientsToDoctor dispTestimony= new ListAssignedPatientsToDoctor(userConnected);
				dispTestimony.setLocationRelativeTo(null);
				
				dispTestimony.setVisible(true);
				DisplayPatientAssigned.this.setVisible(false);
			}
		});
		button.setBounds(36, 394, 89, 23);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(114, 94, 500, 278);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Patient Name :");
		label_1.setForeground(new Color(0, 128, 128));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(10, 11, 140, 39);
		panel.add(label_1);
		
		JLabel lblCi = new JLabel("CNI :");
		lblCi.setForeground(new Color(0, 128, 128));
		lblCi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCi.setBounds(289, 11, 45, 39);
		panel.add(lblCi);
		
		JLabel lblMail = new JLabel("Mail :");
		lblMail.setForeground(new Color(0, 128, 128));
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMail.setBounds(10, 108, 50, 39);
		panel.add(lblMail);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setForeground(new Color(0, 128, 128));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(10, 61, 74, 39);
		panel.add(lblGender);
		
		JLabel cin = new JLabel((String) null);
		cin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cin.setEnabled(false);
		cin.setBounds(334, 23, 142, 14);
		panel.add(cin);
		
		JLabel lblConfirmed = new JLabel("Confirmed : ");
		lblConfirmed.setForeground(new Color(0, 128, 128));
		lblConfirmed.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConfirmed.setBounds(10, 209, 106, 39);
		panel.add(lblConfirmed);
		
		JLabel name = new JLabel("");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setEnabled(false);
		name.setBounds(123, 20, 169, 14);
		panel.add(name);
		
		JLabel gender = new JLabel("");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gender.setEnabled(false);
		gender.setBounds(73, 71, 116, 14);
		panel.add(gender);
		
		JLabel mail = new JLabel("");
		mail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mail.setEnabled(false);
		mail.setBounds(55, 120, 210, 14);
		panel.add(mail);
		
		JLabel confirmed = new JLabel("");
		confirmed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirmed.setBounds(104, 209, 74, 26);
		panel.add(confirmed);
		
		if(patientSelected.getConfirmed()==null){
			confirmed.setForeground(new Color(220, 20, 60));
			confirmed.setText("No");}
		else if(patientSelected.getConfirmed()==true){
			confirmed.setForeground(new Color(199, 21, 133));
			confirmed.setText("Yes");	
		}
		else
		{
			confirmed.setForeground(new Color(220, 20, 60));
			confirmed.setText("No");
		}
		JLabel tfsurgery = new JLabel("");
		tfsurgery.setBounds(124, 168, 194, 25);
		panel.add(tfsurgery);
		

		JLabel lblSurgery = new JLabel("Date surgery :");
		lblSurgery.setForeground(new Color(0, 128, 128));
		lblSurgery.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSurgery.setBounds(10, 159, 106, 39);
		panel.add(lblSurgery);
		
		cin.setText(patientSelected.getCin().toString());
		name.setText(patientSelected.getFirstName()+" "+patientSelected.getLastName());
		mail.setText(patientSelected.getMail());
		try{Surgery surgery=AssigedPatientsServicesDelegate.doFindSurgeryByPatientId(patientSelected.getUserId());
		System.out.println(surgery.getName());
		
		tfsurgery.setText(surgery.getDate().toString());}
		
		catch(Exception n){lblSurgery.setVisible(false);}
		gender.setText(patientSelected.getSexe().toString());
		
		
	
		
		
	}
}
