package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

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

import delegates.HotelServicesDelegate;
import delegates.ServiceHotelServicesDelegate;
import entities.Hotel;
import entities.ServiceHotel;

public class AddServiceHotel extends JFrame {

	ServiceHotel hotelService = new ServiceHotel();
	private JPanel contentPane;
	private JTextField txtname;
	private JTextField textdescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddServiceHotel frame = new AddServiceHotel();
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
	public AddServiceHotel() {
		setTitle("Add Hotel Services");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 384);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JComboBox comboBox = new JComboBox();
		Hotel hotel = new Hotel();
		Iterator w = HotelServicesDelegate.doFindAllHotels().iterator();

		comboBox.removeAllItems();
		while (w.hasNext()) {
			hotel = ((Hotel) w.next());
			comboBox.addItem(hotel.getName());
		}

		JLabel lblHotel = new JLabel("Hotel");

		JLabel lblName = new JLabel("Name");

		txtname = new JTextField();
		txtname.setColumns(10);

		JLabel lblDescription = new JLabel("Description");

		textdescription = new JTextField();
		textdescription.setColumns(10);

		JButton btnSubmit = new JButton("");
		btnSubmit.setIcon(new ImageIcon(AddServiceHotel.class
				.getResource("/images/pluuus.jpg")));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Integer index = comboBox.getSelectedIndex() + 1;
					
					String name = txtname.getText();
					String description = textdescription.getText();

					hotelService.setName(name);
					hotelService.setDescription(description);
					ServiceHotelServicesDelegate.doAssignServiceHotelToHotel(
							hotelService, index);

					JOptionPane.showMessageDialog(null,
							"Service added successfully ");
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Please check your information ");
				}
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddServiceHotel.class
				.getResource("/images/serviceshotels.jpg")));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AddServiceHotel.class
				.getResource("/images/medtraaaaaav.jpg")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(29)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel)
																		.addContainerGap())
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblDescription)
																						.addComponent(
																								lblName)
																						.addComponent(
																								lblHotel))
																		.addGap(55)
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
																														.addComponent(
																																textdescription,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																txtname,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												92,
																												Short.MAX_VALUE)
																										.addComponent(
																												btnSubmit,
																												GroupLayout.PREFERRED_SIZE,
																												51,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(58))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												comboBox,
																												GroupLayout.PREFERRED_SIZE,
																												148,
																												GroupLayout.PREFERRED_SIZE)
																										.addContainerGap())))))
						.addGroup(
								gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblNewLabel_1)
										.addContainerGap(368, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addGroup(
																Alignment.TRAILING,
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(20)
																		.addComponent(
																				lblNewLabel_1)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								comboBox,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblHotel))
																		.addGap(18)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								txtname,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblName))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								textdescription,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblDescription)))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(116)
																		.addComponent(
																				btnSubmit,
																				GroupLayout.PREFERRED_SIZE,
																				34,
																				GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												ComponentPlacement.RELATED, 20,
												Short.MAX_VALUE)
										.addComponent(lblNewLabel,
												GroupLayout.PREFERRED_SIZE,
												152, GroupLayout.PREFERRED_SIZE)));
		contentPane.setLayout(gl_contentPane);
	}
}
