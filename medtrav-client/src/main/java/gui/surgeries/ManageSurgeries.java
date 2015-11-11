package gui.surgeries;

import entities.User;
import gui.DoctorUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class ManageSurgeries extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSurgeries frame = new ManageSurgeries();
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
	public ManageSurgeries() {
		setTitle("Manage surgeries");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblManageSurgeries = new JLabel("Manage surgeries");
		lblManageSurgeries.setForeground(new Color(135, 206, 250));
		lblManageSurgeries.setFont(new Font("Tahoma", Font.BOLD, 23));

		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(ManageSurgeries.class
				.getResource("/images/smallLogo.png")));
		labelLogo.setBounds(10, 0, 69, 73);

		JButton btnAddASurgery = new JButton("Add a surgery");
		btnAddASurgery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSurgery addSurg = new AddSurgery();
				addSurg.setVisible(true);
				ManageSurgeries.this.setVisible(false);
			}
		});
		btnAddASurgery.setIcon(new ImageIcon(ManageSurgeries.class
				.getResource("/images/addHome.png")));

		JButton btnSeeMySurgeries = new JButton("See my surgeries");
		btnSeeMySurgeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeAllMySurgeries seeSurg = new SeeAllMySurgeries();
				seeSurg.setVisible(true);
				ManageSurgeries.this.setVisible(false);

			}
		});
		btnSeeMySurgeries.setIcon(new ImageIcon(ManageSurgeries.class
				.getResource("/images/see.png")));

		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				DoctorUI doc = new DoctorUI();
				doc.setVisible(true);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				labelLogo,
																				GroupLayout.PREFERRED_SIZE,
																				69,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(121)
																		.addComponent(
																				lblManageSurgeries,
																				GroupLayout.PREFERRED_SIZE,
																				241,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(132)
																		.addComponent(
																				btnAddASurgery,
																				GroupLayout.PREFERRED_SIZE,
																				214,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(28)
																		.addComponent(
																				btnSeeMySurgeries,
																				GroupLayout.PREFERRED_SIZE,
																				189,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				button,
																				GroupLayout.PREFERRED_SIZE,
																				102,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(141, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addComponent(labelLogo,
												GroupLayout.PREFERRED_SIZE, 57,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblManageSurgeries,
												GroupLayout.PREFERRED_SIZE, 96,
												GroupLayout.PREFERRED_SIZE))
						.addGap(105)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAddASurgery,
												GroupLayout.PREFERRED_SIZE, 43,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSeeMySurgeries,
												GroupLayout.PREFERRED_SIZE, 43,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 110,
								Short.MAX_VALUE).addComponent(button)
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	public ManageSurgeries(User user) {
		setTitle("Manage surgeries");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblManageSurgeries = new JLabel("Manage surgeries");
		lblManageSurgeries.setForeground(new Color(135, 206, 250));
		lblManageSurgeries.setFont(new Font("Tahoma", Font.BOLD, 23));

		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(ManageSurgeries.class
				.getResource("/images/smallLogo.png")));
		labelLogo.setBounds(10, 0, 69, 73);

		JButton btnAddASurgery = new JButton("Add a surgery");
		btnAddASurgery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSurgery addSurg = new AddSurgery(user);
				addSurg.setVisible(true);
				ManageSurgeries.this.setVisible(false);
			}
		});
		btnAddASurgery.setIcon(new ImageIcon(ManageSurgeries.class
				.getResource("/images/addHome.png")));

		JButton btnSeeMySurgeries = new JButton("See my surgeries");
		btnSeeMySurgeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeAllMySurgeries seeSurg = new SeeAllMySurgeries(user);
				seeSurg.setVisible(true);
				ManageSurgeries.this.setVisible(false);

			}
		});
		btnSeeMySurgeries.setIcon(new ImageIcon(ManageSurgeries.class
				.getResource("/images/see.png")));

		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				DoctorUI doc = new DoctorUI(user);
				doc.setVisible(true);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				labelLogo,
																				GroupLayout.PREFERRED_SIZE,
																				69,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(121)
																		.addComponent(
																				lblManageSurgeries,
																				GroupLayout.PREFERRED_SIZE,
																				241,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(132)
																		.addComponent(
																				btnAddASurgery,
																				GroupLayout.PREFERRED_SIZE,
																				214,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(28)
																		.addComponent(
																				btnSeeMySurgeries,
																				GroupLayout.PREFERRED_SIZE,
																				189,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				button,
																				GroupLayout.PREFERRED_SIZE,
																				102,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(141, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addComponent(labelLogo,
												GroupLayout.PREFERRED_SIZE, 57,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblManageSurgeries,
												GroupLayout.PREFERRED_SIZE, 96,
												GroupLayout.PREFERRED_SIZE))
						.addGap(105)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAddASurgery,
												GroupLayout.PREFERRED_SIZE, 43,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSeeMySurgeries,
												GroupLayout.PREFERRED_SIZE, 43,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 110,
								Short.MAX_VALUE).addComponent(button)
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
