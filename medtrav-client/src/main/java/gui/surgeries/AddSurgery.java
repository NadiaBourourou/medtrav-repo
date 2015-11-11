package gui.surgeries;

import delegates.SurgeryServicesDelegate;
import delegates.TestimonyServicesDelegate;
import entities.Doctor;
import entities.Patient;
import entities.Surgery;
import entities.Testimony;
import entities.User;
import gui.flights.ManageFlights;
import gui.flights.ModifyCancelFlight;
import gui.procedures.AddProcedure;
import gui.procedures.ManageProcedures;
import gui.procedures.SeeProcedures;
import gui.testimonies.AddTestimony;
import gui.testimonies.ListTestimonies;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.SystemColor;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class AddSurgery extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private Integer userId=3;

	private User user;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSurgery frame = new AddSurgery();
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
	public AddSurgery() {
		setTitle("Add a surgery");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddASurgery = new JLabel("Add a surgery");
		lblAddASurgery.setForeground(new Color(135, 206, 250));
		lblAddASurgery.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AddSurgery.class.getResource("/images/smallLogo.png")));
		lblLogo.setBounds(10, 0, 69, 73);		
		JLabel lblTitle = new JLabel("Title ");
		
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description ");
		
		JTextPane textPaneDesc = new JTextPane();
		textPaneDesc.setBackground(SystemColor.menu);
		
		JButton buttonAdd = new JButton("Confirm");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
					Surgery surgery= new Surgery();
					Doctor doctor=SurgeryServicesDelegate.doFindDoctorById(userId);
					System.out.println("nomPatient= "+doctor.getLastName());
					surgery.setDoctor(doctor);	
					surgery.setName(textFieldTitle.getText());
					surgery.setDescription(textPaneDesc.getText().toString());
					surgery.setDate(new Date());
					
					SurgeryServicesDelegate.doAddSurgery(surgery);
					JOptionPane.showMessageDialog(null, "Surgery successfully added");
					AddSurgery.this.setVisible(false);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Error");
				}
					
				SeeAllMySurgeries dispSur= new SeeAllMySurgeries();
				dispSur.setVisible(true);

				AddSurgery.this.setVisible(false);


					
			}
		});
		buttonAdd.setIcon(new ImageIcon(AddSurgery.class.getResource("/images/add.png")));
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSurgeries home = new ManageSurgeries();
				home.setVisible(true);
				AddSurgery.this.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(AddSurgery.class
				.getResource("/images/blue-home-icon.png")));
		button.setBounds(10, 331, 160, 43);

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblTitle)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(76)
								.addComponent(textPaneDesc, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(205)
							.addComponent(lblAddASurgery, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(523, Short.MAX_VALUE)
					.addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAddASurgery, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(17)))
							.addGap(62)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTitle)
								.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(69)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textPaneDesc, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public AddSurgery(User user) {
		setTitle("Add a surgery");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddASurgery = new JLabel("Add a surgery");
		lblAddASurgery.setForeground(new Color(135, 206, 250));
		lblAddASurgery.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AddSurgery.class.getResource("/images/smallLogo.png")));
		lblLogo.setBounds(10, 0, 69, 73);		
		JLabel lblTitle = new JLabel("Title ");
		
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description ");
		
		JTextPane textPaneDesc = new JTextPane();
		textPaneDesc.setBackground(SystemColor.menu);
		
		JButton buttonAdd = new JButton("Confirm");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
					Surgery surgery= new Surgery();
					Doctor doctor=SurgeryServicesDelegate.doFindDoctorById(user.getUserId());
					System.out.println("nomPatient= "+doctor.getLastName());
					surgery.setDoctor(doctor);	
					surgery.setName(textFieldTitle.getText());
					surgery.setDescription(textPaneDesc.getText().toString());
					surgery.setDate(new Date());
					
					SurgeryServicesDelegate.doAddSurgery(surgery);
					JOptionPane.showMessageDialog(null, "Surgery successfully added");
					AddSurgery.this.setVisible(false);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Error");
				}
					
				SeeAllMySurgeries dispSur= new SeeAllMySurgeries();
				dispSur.setVisible(true);

				AddSurgery.this.setVisible(false);


					
			}
		});
		buttonAdd.setIcon(new ImageIcon(AddSurgery.class.getResource("/images/add.png")));

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblTitle)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(76)
								.addComponent(textPaneDesc, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(205)
							.addComponent(lblAddASurgery, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(265, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(523, Short.MAX_VALUE)
					.addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAddASurgery, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(17)))
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textPaneDesc, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
