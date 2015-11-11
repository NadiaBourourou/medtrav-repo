package gui.procedures;

import entities.User;
import gui.DoctorUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.LayoutStyle.ComponentPlacement;

public class ManageProcedures extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageProcedures frame = new ManageProcedures();
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
	public ManageProcedures() {
		setTitle("Manage procedures");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblManageProcedures = new JLabel("Manage procedures");
		lblManageProcedures.setForeground(new Color(135, 206, 250));
		lblManageProcedures.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(ManageProcedures.class.getResource("/images/smallLogo.png")));
		labelLogo.setBounds(10, 0, 69, 73);
		
		JButton btnAddAProcedure = new JButton("Add a procedure");
		btnAddAProcedure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProcedure addProc= new AddProcedure();
				addProc.setVisible(true);
				ManageProcedures.this.setVisible(false);
			}
		});
		btnAddAProcedure.setIcon(new ImageIcon(ManageProcedures.class.getResource("/images/addHome.png")));
		
		JButton btnSeeMyProcedures = new JButton("See my procedures");
		btnSeeMyProcedures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeProcedures seeProc= new SeeProcedures();
				seeProc.setVisible(true);
				ManageProcedures.this.setVisible(false);
			}
		});
		btnSeeMyProcedures.setIcon(new ImageIcon(ManageProcedures.class.getResource("/images/see.png")));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			DoctorUI doc = new DoctorUI();
			doc.setVisible(true);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(171)
							.addComponent(lblManageProcedures, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(120)
							.addComponent(btnAddAProcedure, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnSeeMyProcedures, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, 0, 0, Short.MAX_VALUE)
					.addGap(592))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblManageProcedures, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddAProcedure, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSeeMyProcedures, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public ManageProcedures(User user) {
		setTitle("Manage procedures");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblManageProcedures = new JLabel("Manage procedures");
		lblManageProcedures.setForeground(new Color(135, 206, 250));
		lblManageProcedures.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(ManageProcedures.class.getResource("/images/smallLogo.png")));
		labelLogo.setBounds(10, 0, 69, 73);
		
		JButton btnAddAProcedure = new JButton("Add a procedure");
		btnAddAProcedure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProcedure addProc= new AddProcedure(user);
				addProc.setVisible(true);
				ManageProcedures.this.setVisible(false);
			}
		});
		btnAddAProcedure.setIcon(new ImageIcon(ManageProcedures.class.getResource("/images/addHome.png")));
		
		JButton btnSeeMyProcedures = new JButton("See my procedures");
		btnSeeMyProcedures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeProcedures seeProc= new SeeProcedures(user);
				seeProc.setVisible(true);
				ManageProcedures.this.setVisible(false);
			}
		});
		btnSeeMyProcedures.setIcon(new ImageIcon(ManageProcedures.class.getResource("/images/see.png")));

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			DoctorUI doc = new DoctorUI(user);
			doc.setVisible(true);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(171)
							.addComponent(lblManageProcedures, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(120)
							.addComponent(btnAddAProcedure, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnSeeMyProcedures, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, 0, 0, Short.MAX_VALUE)
					.addGap(592))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblManageProcedures, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddAProcedure, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSeeMyProcedures, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
