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

import delegates.HotelServicesDelegate;
import entities.Hotel;
import entities.HotelBooking;
import entities.RoomType;
import entities.StateType;

public class ChooseTheHotel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Double prix;
	HotelBooking hb = new HotelBooking();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseTheHotel frame = new ChooseTheHotel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JComboBox comboBox = new JComboBox();

	/**
	 * Create the frame.
	 */
	public ChooseTheHotel() {
		setTitle("Choose The Hotel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 334);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblHotel = new JLabel("Hotel");

		textField = new JTextField();
		textField.setColumns(10);

		JDateChooser dateChooser = new JDateChooser();

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(RoomType.values()));

		JButton btnSubmit = new JButton("");
		btnSubmit.setIcon(new ImageIcon(ChooseTheHotel.class
				.getResource("/images/validate.jpg")));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Hotel hotel = new Hotel();

					Integer index = comboBox.getSelectedIndex() + 1;
					
					hotel = HotelServicesDelegate.doFindHotelById(index);

					if (hotel.getState() == StateType.ENABLED) {

						Integer numNights = Integer.parseInt(textField
								.getText());

						RoomType room = (RoomType.valueOf(comboBox_1
								.getSelectedItem().toString()));
						Date date = dateChooser.getDate();
						Integer index2 = comboBox_1.getSelectedIndex() + 1;

						if (index2 == 1) {

							Double prix = hotel.getPriceSingle();
							double price = HotelServicesDelegate.doCalculPrix(
									prix, numNights);

							HotelServicesDelegate.doBookHotel(numNights, price,
									room, date, hotel, 1);

						} else {
							Double prix = hotel.getPriceSuite();
							double price = HotelServicesDelegate.doCalculPrix(
									prix, numNights);

							HotelServicesDelegate.doBookHotel(numNights, price,
									room, date, hotel, 1);
						}

						JOptionPane.showMessageDialog(null,
								"Your choice has been saved ");
					}

					else {
						JOptionPane.showMessageDialog(null,
								"This hotel is disabled! Please choose another one");
					}
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Please check your information ");
				}

			}

		});

		JLabel lblTypeOfRomm = new JLabel("Type of room");

		JLabel lblNumberOfNights = new JLabel("Number of nights");

		Hotel arrival = new Hotel();
		Iterator w = HotelServicesDelegate.doFindAllHotels().iterator();

		comboBox.removeAllItems();
		while (w.hasNext()) {
			arrival = ((Hotel) w.next());
			comboBox.addItem(arrival.getName());
		}

		JLabel lblDate = new JLabel("Date");

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ChooseTheHotel.class
				.getResource("/images/imageshotel.png")));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ChooseTheHotel.class
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
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addContainerGap(
																																				GroupLayout.DEFAULT_SIZE,
																																				Short.MAX_VALUE)
																																		.addComponent(
																																				lblNumberOfNights)
																																		.addGap(24))
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addContainerGap()
																																		.addComponent(
																																				lblTypeOfRomm)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)))
																										.addGroup(
																												gl_contentPane
																														.createSequentialGroup()
																														.addContainerGap()
																														.addComponent(
																																lblDate)
																														.addPreferredGap(
																																ComponentPlacement.RELATED)))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addContainerGap()
																										.addComponent(
																												lblHotel)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)))
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								comboBox_1,
																								GroupLayout.PREFERRED_SIZE,
																								97,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_contentPane
																										.createParallelGroup(
																												Alignment.TRAILING)
																										.addComponent(
																												dateChooser,
																												GroupLayout.PREFERRED_SIZE,
																												128,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												comboBox,
																												GroupLayout.PREFERRED_SIZE,
																												128,
																												GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblNewLabel_1)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)))
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(41)
																		.addComponent(
																				btnSubmit,
																				GroupLayout.PREFERRED_SIZE,
																				43,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				lblNewLabel,
																				GroupLayout.PREFERRED_SIZE,
																				181,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
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
																		.addGap(35)
																		.addComponent(
																				lblNewLabel_1)
																		.addGap(18)
																		.addComponent(
																				lblHotel)
																		.addGap(11)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								comboBox_1,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblTypeOfRomm))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				lblDate))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(50)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblNewLabel,
																								GroupLayout.PREFERRED_SIZE,
																								130,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								comboBox,
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
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				textField,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblNumberOfNights))
														.addComponent(
																btnSubmit,
																GroupLayout.PREFERRED_SIZE,
																39,
																GroupLayout.PREFERRED_SIZE))
										.addGap(50))
						.addGroup(
								Alignment.TRAILING,
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap(165, Short.MAX_VALUE)
										.addComponent(dateChooser,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(100)));
		contentPane.setLayout(gl_contentPane);
	}
}
