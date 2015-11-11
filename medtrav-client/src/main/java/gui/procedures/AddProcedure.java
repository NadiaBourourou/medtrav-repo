package gui.procedures;

import delegates.ProcedureServicesDelegate;
import delegates.SurgeryServicesDelegate;
import entities.Doctor;
import entities.Procedure;
import entities.Surgery;
import entities.User;

import gui.surgeries.AddSurgery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class AddProcedure extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProcedure frame = new AddProcedure();
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
	public AddProcedure() {
		setTitle("Add a procedure");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddAProcedure = new JLabel("Add a procedure");
		lblAddAProcedure.setForeground(new Color(135, 206, 250));
		lblAddAProcedure.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(AddProcedure.class.getResource("/images/smallLogo.png")));
		labelLogo.setBounds(10, 0, 69, 73);	
		
		JLabel lblName = new JLabel("Name");
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);

		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
					Procedure procedure= new Procedure();
					
					procedure.setName(textFieldName.getText());

					
					ProcedureServicesDelegate.doAddProcedure(procedure);
					JOptionPane.showMessageDialog(null, "Procedure successfully added");
					AddProcedure.this.setVisible(false);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Error");
				}
					
				SeeProcedures dispProc= new SeeProcedures();
				dispProc.setVisible(true);

				AddProcedure.this.setVisible(false);
					
			}
		});
		btnConfirm.setIcon(new ImageIcon(AddProcedure.class.getResource("/images/add.png")));
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageProcedures home = new ManageProcedures();
				home.setVisible(true);
				AddProcedure.this.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(AddProcedure.class
				.getResource("/images/blue-home-icon.png")));
		button.setBounds(10, 331, 160, 43);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
							.addComponent(lblAddAProcedure, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addGap(160)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(377)
							.addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddAProcedure, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))
							.addGap(69)
							.addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(149))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public AddProcedure(User user) {
		setTitle("Add a procedure");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddAProcedure = new JLabel("Add a procedure");
		lblAddAProcedure.setForeground(new Color(135, 206, 250));
		lblAddAProcedure.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(AddProcedure.class.getResource("/images/smallLogo.png")));
		labelLogo.setBounds(10, 0, 69, 73);	
		
		JLabel lblName = new JLabel("Name");
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);

		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
					Procedure procedure= new Procedure();
					
					procedure.setName(textFieldName.getText());

					
					ProcedureServicesDelegate.doAddProcedure(procedure);
					JOptionPane.showMessageDialog(null, "Procedure successfully added");
					AddProcedure.this.setVisible(false);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Error");
				}
					
				SeeProcedures dispProc= new SeeProcedures();
				dispProc.setVisible(true);

				AddProcedure.this.setVisible(false);
					
			}
		});
		btnConfirm.setIcon(new ImageIcon(AddProcedure.class.getResource("/images/add.png")));
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageProcedures home = new ManageProcedures(user);
				home.setVisible(true);
				AddProcedure.this.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(AddProcedure.class
				.getResource("/images/blue-home-icon.png")));
		button.setBounds(10, 331, 160, 43);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
							.addComponent(lblAddAProcedure, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addGap(160)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(377)
							.addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddAProcedure, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))
							.addGap(69)
							.addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(149))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
}
