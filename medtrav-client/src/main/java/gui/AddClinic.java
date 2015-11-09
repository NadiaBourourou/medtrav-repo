package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import delegates.ClinicServicesDelegate;
import delegates.HotelServicesDelegate;
import entities.Clinic;
import entities.Hotel;
import entities.StateType;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.ImageIcon;

public class AddClinic extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField phonenumber;
	private JTextField professionalism;
	private JTextField Email;
	private JTextField priceSimple;
	private JTextField priceSingle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClinic frame = new AddClinic();
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
	public AddClinic() {
		setTitle("Add Clinic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Name");
		
		name = new JTextField();
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		
		address = new JTextField();
		address.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		
		phonenumber = new JTextField();
		phonenumber.setColumns(10);
		professionalism = new JTextField();
		professionalism.setColumns(10);
		
		Email = new JTextField();
		Email.setColumns(10);
		
		priceSimple = new JTextField();
		priceSimple.setColumns(10);
		
		priceSingle = new JTextField();
		priceSingle.setColumns(10);
		
		JButton btnAddClinic = new JButton("");
		btnAddClinic.setIcon(new ImageIcon(AddClinic.class.getResource("/images/add clinic.png")));
		btnAddClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {	Clinic clinic= new Clinic ();
				clinic.setName(name.getText());
				clinic.setAddress(address.getText());
				clinic.setPhoneNumber(new Integer (phonenumber.getText()));
				clinic.setProfessionalism(professionalism.getText());
				clinic.setEmail(Email.getText());
				clinic.setPriceSimple(Double.parseDouble(priceSimple.getText()));
				clinic.setPriceSingle(Double.parseDouble(priceSingle.getText()));
			
			
				ClinicServicesDelegate.doAddClinic(clinic);
				JOptionPane.showMessageDialog(null,
						"Clinic added successfully ");}
			
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						"Please check your information ");
			}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Professionalism");
		
	
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblPriceSimple = new JLabel("Price Simple");
		
		JLabel lblPriceSingle = new JLabel("Price Single");
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(AddClinic.class.getResource("/images/imageclinic ajout.png")));
		lblNewLabel_4.setBounds(26, 70, 132, 14);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblEmail)
						.addComponent(lblPriceSimple)
						.addComponent(lblPriceSingle)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(phonenumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(professionalism, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(priceSimple, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(priceSingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(36)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
									.addComponent(btnAddClinic, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(55))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(phonenumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(professionalism, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(lblNewLabel_4)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(priceSimple, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPriceSimple))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(priceSingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPriceSingle)))
						.addComponent(btnAddClinic, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
