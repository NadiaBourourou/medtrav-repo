package gui.flights;

import gui.AdminUI;
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

import javax.swing.ImageIcon;
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
		setTitle("Manage flights");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
				ManageFlights.this.setVisible(false);
			}
		});
		btnAddAFlight.setIcon(new ImageIcon(ManageFlights.class.getResource("/images/addHome.png")));
		btnAddAFlight.setBounds(10, 331, 160, 43);
		
		JButton btnSeeAllFlights = new JButton("See all flights");
		btnSeeAllFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SeeAllFlights seeAllFlights = new SeeAllFlights();
			seeAllFlights.setVisible(true);
			ManageFlights.this.setVisible(false);
			}
		});
		btnSeeAllFlights.setIcon(new ImageIcon(ManageFlights.class.getResource("/images/see.png")));
		btnSeeAllFlights.setBounds(10, 331, 160, 43);
		
		JButton btnModifyMyFlights = new JButton("Modify/Cancel my flight");
		btnModifyMyFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModifyCancelFlight modifCancelFlight= new ModifyCancelFlight();
				modifCancelFlight.setVisible(true);
				ManageFlights.this.setVisible(false);
			}
		});
		btnModifyMyFlights.setIcon(new ImageIcon(ManageFlights.class.getResource("/images/modifCancelHome.png")));
	    btnModifyMyFlights.setBounds(10, 331, 160, 43);
		
		JButton btnNewButton = new JButton("See my flights");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeMyFlights seeMyFlights=new SeeMyFlights();
				seeMyFlights.setVisible(true);
				ManageFlights.this.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ManageFlights.class.getResource("/images/see.png")));
		btnNewButton.setBounds(10, 331, 160, 43);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(AddFlight2.class.getResource("/images/smallLogo.png")));
		labelLogo.setBounds(10, 0, 69, 73);
		
		JButton btnStatistics = new JButton("See statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistiques stat = new Statistiques("Airline partners");
				stat.setVisible(true);
			}
		});
		btnStatistics.setIcon(new ImageIcon(ManageFlights.class.getResource("/images/stat.png")));
		
		JButton btnNewButton_1 = new JButton("Generate an image of the statistics");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateImageStatistics gImage= new GenerateImageStatistics();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(labelLogo)
							.addGap(183)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnModifyMyFlights, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
									.addComponent(btnAddAFlight, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)))
							.addGap(82)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnStatistics, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSeeAllFlights, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(labelLogo)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAddAFlight, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnModifyMyFlights, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSeeAllFlights, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnStatistics, GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE))
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
