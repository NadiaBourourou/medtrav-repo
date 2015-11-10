package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import delegates.ClinicServicesDelegate;
import entities.Clinic;
import entities.ClinicBooking;
import entities.RoomClinicType;
import entities.User;

public class ChooseClinic extends JFrame {

	private ClinicBooking hb = new ClinicBooking();
	private JPanel contentPane;
	private JTextField commentaire;

	private JDateChooser dateChooser = new JDateChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseClinic frame = new ChooseClinic();
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
	public ChooseClinic() {
		setTitle("Choose The Clinic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JComboBox comboBoxClinic = new JComboBox();
		Clinic c = new Clinic();
		Iterator w = ClinicServicesDelegate.doFindAllClinics().iterator();

		comboBoxClinic.removeAllItems();
		while (w.hasNext()) {
			c = ((Clinic) w.next());
			comboBoxClinic.addItem(c.getName());
		}

		JComboBox comboBoxTRC = new JComboBox();
		comboBoxTRC.setModel(new DefaultComboBoxModel(RoomClinicType.values()));

		commentaire = new JTextField();
		commentaire.setColumns(10);

		JLabel lblClinic = new JLabel("Clinic");

		JLabel lblTypeOfRoom = new JLabel("Type Of room");

		JLabel lblDate = new JLabel("Date");

		JLabel lblCommentaire = new JLabel("Commentaire");

		JButton btnSubmit = new JButton("");
		btnSubmit.setIcon(new ImageIcon(ChooseClinic.class
				.getResource("/images/validate.jpg")));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Integer index = comboBoxClinic.getSelectedIndex() + 1;

					Clinic clinic = ClinicServicesDelegate
							.doFindClinicById(index);

					String comme = commentaire.getText();

					Date date = dateChooser.getDate();
					RoomClinicType room = (RoomClinicType.valueOf(comboBoxTRC
							.getSelectedItem().toString()));
					ClinicServicesDelegate.doBookClinic(room, date, comme,
							clinic, 1);

					JOptionPane.showMessageDialog(null,
							"Your choice has been saved ");

					setVisible(false);
					ListHotelAndServicesPatient next = new ListHotelAndServicesPatient();
					next.setVisible(true);
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Please check your information ");
				}
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ChooseClinic.class
				.getResource("/images/imagesante.jpg")));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ChooseClinic.class
				.getResource("/images/medtraaaaaav.jpg")));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
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
																		.addGap(24)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblCommentaire)
																						.addComponent(
																								lblTypeOfRoom)
																						.addComponent(
																								lblClinic)
																						.addComponent(
																								lblDate)))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblNewLabel_1)))
										.addGap(39)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
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
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addComponent(
																																comboBoxClinic,
																																Alignment.LEADING,
																																0,
																																112,
																																Short.MAX_VALUE)
																														.addComponent(
																																dateChooser,
																																GroupLayout.DEFAULT_SIZE,
																																112,
																																Short.MAX_VALUE))
																										.addGap(18))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												comboBoxTRC,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)))
																		.addComponent(
																				lblNewLabel,
																				GroupLayout.DEFAULT_SIZE,
																				155,
																				Short.MAX_VALUE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				commentaire,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(100)
																		.addComponent(
																				btnSubmit,
																				GroupLayout.PREFERRED_SIZE,
																				40,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(21)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblNewLabel,
																GroupLayout.PREFERRED_SIZE,
																126,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel_1)
																		.addGap(18)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblClinic)
																						.addComponent(
																								comboBoxClinic,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblTypeOfRoom)
																						.addComponent(
																								comboBoxTRC,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(
												ComponentPlacement.RELATED, 13,
												Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblDate,
																Alignment.TRAILING)
														.addComponent(
																dateChooser,
																Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(2)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																btnSubmit,
																GroupLayout.PREFERRED_SIZE,
																37,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				commentaire,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblCommentaire)))
										.addGap(42)));
		contentPane.setLayout(gl_contentPane);
	}
	
	public ChooseClinic(User user) {
		setTitle("Choose The Clinic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JComboBox comboBoxClinic = new JComboBox();
		Clinic c = new Clinic();
		Iterator w = ClinicServicesDelegate.doFindAllClinics().iterator();

		comboBoxClinic.removeAllItems();
		while (w.hasNext()) {
			c = ((Clinic) w.next());
			comboBoxClinic.addItem(c.getName());
		}

		JComboBox comboBoxTRC = new JComboBox();
		comboBoxTRC.setModel(new DefaultComboBoxModel(RoomClinicType.values()));

		commentaire = new JTextField();
		commentaire.setColumns(10);

		JLabel lblClinic = new JLabel("Clinic");

		JLabel lblTypeOfRoom = new JLabel("Type Of room");

		JLabel lblDate = new JLabel("Date");

		JLabel lblCommentaire = new JLabel("Commentaire");

		JButton btnSubmit = new JButton("");
		btnSubmit.setIcon(new ImageIcon(ChooseClinic.class
				.getResource("/images/validate.jpg")));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Integer index = comboBoxClinic.getSelectedIndex() + 1;

					Clinic clinic = ClinicServicesDelegate
							.doFindClinicById(index);

					String comme = commentaire.getText();

					Date date = dateChooser.getDate();
					RoomClinicType room = (RoomClinicType.valueOf(comboBoxTRC
							.getSelectedItem().toString()));
					ClinicServicesDelegate.doBookClinic(room, date, comme,
							clinic, user.getUserId());

					JOptionPane.showMessageDialog(null,
							"Your choice has been saved ");

					setVisible(false);
					ListHotelAndServicesPatient next = new ListHotelAndServicesPatient(user);
					next.setVisible(true);
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Please check your information ");
				}
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ChooseClinic.class
				.getResource("/images/imagesante.jpg")));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ChooseClinic.class
				.getResource("/images/medtraaaaaav.jpg")));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
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
																		.addGap(24)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblCommentaire)
																						.addComponent(
																								lblTypeOfRoom)
																						.addComponent(
																								lblClinic)
																						.addComponent(
																								lblDate)))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblNewLabel_1)))
										.addGap(39)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
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
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addComponent(
																																comboBoxClinic,
																																Alignment.LEADING,
																																0,
																																112,
																																Short.MAX_VALUE)
																														.addComponent(
																																dateChooser,
																																GroupLayout.DEFAULT_SIZE,
																																112,
																																Short.MAX_VALUE))
																										.addGap(18))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												comboBoxTRC,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)))
																		.addComponent(
																				lblNewLabel,
																				GroupLayout.DEFAULT_SIZE,
																				155,
																				Short.MAX_VALUE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				commentaire,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(100)
																		.addComponent(
																				btnSubmit,
																				GroupLayout.PREFERRED_SIZE,
																				40,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(21)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblNewLabel,
																GroupLayout.PREFERRED_SIZE,
																126,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel_1)
																		.addGap(18)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblClinic)
																						.addComponent(
																								comboBoxClinic,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblTypeOfRoom)
																						.addComponent(
																								comboBoxTRC,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(
												ComponentPlacement.RELATED, 13,
												Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblDate,
																Alignment.TRAILING)
														.addComponent(
																dateChooser,
																Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(2)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																btnSubmit,
																GroupLayout.PREFERRED_SIZE,
																37,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				commentaire,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblCommentaire)))
										.addGap(42)));
		contentPane.setLayout(gl_contentPane);
	}
}
