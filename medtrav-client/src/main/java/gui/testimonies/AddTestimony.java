package gui.testimonies;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

import delegates.TestimonyServicesDelegate;
import entities.Patient;
import entities.Testimony;
import entities.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.ImageIcon;

public class AddTestimony extends JFrame {

	private JPanel contentPane;
	private JTextField titletf;
	//private Integer userId=1;
	static Integer userId;
	private User userConnected;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTestimony frame = new AddTestimony(userId);
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
	public AddTestimony(Integer userId) {
		this.userId=userId;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddTestimony = new JLabel("Add testimony");
		lblAddTestimony.setForeground(SystemColor.desktop);
		lblAddTestimony.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAddTestimony.setBounds(248, 11, 179, 45);
		contentPane.add(lblAddTestimony);
		
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setBounds(177, 103, 46, 14);
		contentPane.add(lblTitle);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(177, 186, 91, 33);
		contentPane.add(lblDescription);
		
		titletf = new JTextField();
		titletf.setBounds(253, 99, 214, 23);
		contentPane.add(titletf);
		titletf.setColumns(10);
		
		JTextPane descriptx = new JTextPane();
		descriptx.setBackground(SystemColor.control);
		descriptx.setBounds(253, 186, 214, 103);
		contentPane.add(descriptx);
		
		JButton confirmbtn = new JButton("Confirm");
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				Testimony testimony= new Testimony();
				Patient patient=TestimonyServicesDelegate.doFindPatientById(userId);
				System.out.println("nomPatient= "+patient.getLastName());
				testimony.setPatient(patient);		
				testimony.setTitle(titletf.getText());
				testimony.setDescription(descriptx.getText().toString());
				testimony.setDate(new Date());
				TestimonyServicesDelegate.doAddTestimony(testimony);
				JOptionPane.showMessageDialog(null, "Successfully added..");
				AddTestimony.this.setVisible(false);
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,"Error");
			}
				
			ListTestimonies dispTestimony= new ListTestimonies();
			dispTestimony.setLocationRelativeTo(null);
			
			dispTestimony.setVisible(true);
			AddTestimony.this.setVisible(false);
				
				
			}
		});
		confirmbtn.setBounds(229, 355, 89, 23);
		contentPane.add(confirmbtn);
		
		JButton cancelBtn = new JButton("Return");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListTestimonies dispTestimony= new ListTestimonies();
				dispTestimony.setLocationRelativeTo(null);
				
				dispTestimony.setVisible(true);
				AddTestimony.this.setVisible(false);
				
			}
		});
		cancelBtn.setBounds(38, 355, 89, 23);
		contentPane.add(cancelBtn);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titletf.setText("");
				descriptx.setText("");
			}
		});
		btnCancel.setBounds(395, 355, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddTestimony.class.getResource("/images/temoin.png")));
		label.setBounds(38, 103, 100, 117);
		contentPane.add(label);
	}

//====================
	/**
	 * @wbp.parser.constructor
	 */
	public AddTestimony(User userConnected) {
		System.out.println("ADD TESTIMONY ");
		System.out.println("user co id="+userConnected.getUserId());
		System.out.println("user co name="+userConnected.getFirstName()+userConnected.getLastName());		
		
		this.userId=userConnected.getUserId();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddTestimony = new JLabel("Add testimony");
		lblAddTestimony.setForeground(SystemColor.desktop);
		lblAddTestimony.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAddTestimony.setBounds(248, 11, 179, 45);
		contentPane.add(lblAddTestimony);
		
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setBounds(177, 103, 46, 14);
		contentPane.add(lblTitle);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(177, 186, 91, 33);
		contentPane.add(lblDescription);
		
		titletf = new JTextField();
		titletf.setBounds(253, 99, 214, 23);
		contentPane.add(titletf);
		titletf.setColumns(10);
		
		JTextPane descriptx = new JTextPane();
		descriptx.setBackground(SystemColor.control);
		descriptx.setBounds(253, 186, 214, 103);
		contentPane.add(descriptx);
		
		JButton confirmbtn = new JButton("Confirm");
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				Testimony testimony= new Testimony();
				Patient patient=TestimonyServicesDelegate.doFindPatientById(userId);
				System.out.println("nomPatient= "+patient.getLastName());
				testimony.setPatient(patient);		
				testimony.setTitle(titletf.getText());
				testimony.setDescription(descriptx.getText().toString());
				testimony.setDate(new Date());
				TestimonyServicesDelegate.doAddTestimony(testimony);
				JOptionPane.showMessageDialog(null, "Successfully added..");
				AddTestimony.this.setVisible(false);
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,"Error");
			}
				
			ListTestimonies dispTestimony= new ListTestimonies();
			dispTestimony.setLocationRelativeTo(null);
			
			dispTestimony.setVisible(true);
			AddTestimony.this.setVisible(false);
				
				
			}
		});
		confirmbtn.setBounds(229, 355, 89, 23);
		contentPane.add(confirmbtn);
		
		JButton cancelBtn = new JButton("Return");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListTestimonies dispTestimony= new ListTestimonies(userConnected);
				dispTestimony.setLocationRelativeTo(null);
				
				dispTestimony.setVisible(true);
				AddTestimony.this.setVisible(false);
				
			}
		});
		cancelBtn.setBounds(38, 355, 89, 23);
		contentPane.add(cancelBtn);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titletf.setText("");
				descriptx.setText("");
			}
		});
		btnCancel.setBounds(395, 355, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddTestimony.class.getResource("/images/temoin.png")));
		label.setBounds(38, 103, 100, 117);
		contentPane.add(label);
	}


}
