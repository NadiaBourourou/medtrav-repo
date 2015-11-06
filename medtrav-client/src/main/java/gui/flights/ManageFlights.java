package gui.flights;

import gui.testimonies.AddTestimony;
import gui.testimonies.ListTestimonies;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManageFlights extends JFrame {

	private JPanel contentPane;
	private Integer userId=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageFlights frame = new ManageFlights();
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
	public ManageFlights() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Manage flights");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setForeground(new Color(135, 206, 250));
		
		JButton btnAddAFlight = new JButton("Add a flight");
		btnAddAFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFlight2 addFlight= new AddFlight2();
				addFlight.setVisible(true);
			}
		});
		
		JButton btnSeeAllFlights = new JButton("See all flights");
		btnSeeAllFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	SeeAllFlights seeAllFlights = new SeeAllFlights();
				//seeAllFlights.setVisible(true);
			}
		});
		
		JButton btnModifyMyFlights = new JButton("Modify/Cancel my flight");
		btnModifyMyFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModifyCancelFlight modifCancelFlight= new ModifyCancelFlight();
				modifCancelFlight.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("See my flights");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeMyFlights seeMyFlights=new SeeMyFlights();
				seeMyFlights.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnModifyMyFlights, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAddAFlight, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
							.addGap(37)
							.addComponent(btnSeeAllFlights, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addGap(65))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddAFlight)
						.addComponent(btnSeeAllFlights))
					.addGap(18)
					.addComponent(btnModifyMyFlights)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(45))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
