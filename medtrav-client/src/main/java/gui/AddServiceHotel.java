package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import delegates.HotelServicesDelegate;
import delegates.ServiceHotelServicesDelegate;
import entities.Hotel;
import entities.RoomClinicType;
import entities.ServiceHotel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddServiceHotel extends JFrame {

	ServiceHotel hotelService= new ServiceHotel();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox comboBox = new JComboBox();
		Hotel hotel = new Hotel();
		Iterator w =  HotelServicesDelegate.doFindAllHotels().iterator();

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
		btnSubmit.setIcon(new ImageIcon(AddServiceHotel.class.getResource("/images/pluuus.jpg")));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Integer index = comboBox.getSelectedIndex() +1;
				System.out.println(index);
				String name= txtname.getText();
				String description= textdescription.getText();
				
			hotelService.setName(name);
			hotelService.setDescription(description);
				ServiceHotelServicesDelegate.doAssignServiceHotelToHotel(hotelService, index);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddServiceHotel.class.getResource("/images/serviceshotels.jpg")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblName)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblHotel)
										.addComponent(lblDescription))
									.addGap(55)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
										.addComponent(textdescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(58))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblHotel)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(txtname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textdescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescription))
							.addGap(18)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(116)
							.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
