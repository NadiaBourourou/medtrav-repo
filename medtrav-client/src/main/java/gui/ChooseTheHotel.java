package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import delegates.HotelServicesDelegate;
import delegates.SurgeryServicesDelegate;
import delegates.UserServicesDelegate;
import entities.Hotel;
import entities.HotelBooking;
import entities.Patient;
import entities.RoomClinicType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

import entities.StateType;
import entities.RoomType;

import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

public class ChooseTheHotel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
Double prix;
HotelBooking hb= new HotelBooking();
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
		setBounds(100, 100, 450, 300);
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
		btnSubmit.setIcon(new ImageIcon(ChooseTheHotel.class.getResource("/images/validate.jpg")));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Hotel h= new Hotel();
			//	String index  =comboBox.getSelectedItem().toString();
//System.out.println(index);
		//	 h= HotelServicesDelegate.doFindHotelByName(index);
		//.out.println("ok");		 

				Integer index = comboBox.getSelectedIndex() + 1;
				System.out.println(index);
				h= HotelServicesDelegate.doFindHotelById(index);
				System.out.println("ok");
				Integer numNights=Integer.parseInt(textField.getText());
			//	Patient p= UserServicesDelegate.doFindPatientById(1);
				
				 System.out.println("ok");
				 
		//		Patient p= UserServicesDelegate.do
				RoomType r= (RoomType.valueOf(comboBox_1.getSelectedItem()
						.toString()));
				Date date = dateChooser.getDate();
				 Integer index2= comboBox_1.getSelectedIndex() + 1;
				 
				 if (index2==1) {
				 
				 
			//	 if ( Singleroom.isSelected()){
					 
					Double pri= h.getPriceSingle();
					double u=HotelServicesDelegate.doCalculPrix(pri, numNights);
					hb.setPrice(u);

					HotelServicesDelegate.doBookHotel(numNights, u, r,date, h, 1);
					
				 }
				 else {Double pri= h.getPriceSuite();
					double u=HotelServicesDelegate.doCalculPrix(pri, numNights);
					hb.setPrice(u); 

					HotelServicesDelegate.doBookHotel(numNights, u, r,date, h, 1);
					}
				 
		
		 System.out.println("ok");	
		//
		// hb.setNumNights(numNights);
		 
	//	 hb.setHotel(h);
		//	HotelBookingServicesDelegate.doAddHotelBooking(hb);
		 JOptionPane.showMessageDialog(null,
		"Your choice has been saved ");}
				
catch (Exception ex) {
JOptionPane.showMessageDialog(null,
		"Please check your information ");
}
					 
				}
			
		});
		
		JLabel lblTypeOfRomm = new JLabel("Type of room");
		
		JLabel lblNumberOfNights = new JLabel("Number of nights");
		
		Hotel arrival = new Hotel();
		Iterator w =  HotelServicesDelegate.doFindAllHotelsEnabled().iterator();

		comboBox.removeAllItems();
		while (w.hasNext()) {
			arrival = ((Hotel) w.next());
			comboBox.addItem(arrival.getName());
		}
		
		
		JLabel lblDate = new JLabel("Date");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ChooseTheHotel.class.getResource("/images/imageshotel.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHotel)
								.addComponent(lblDate)
								.addComponent(lblNumberOfNights))
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblTypeOfRomm))
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(265, Short.MAX_VALUE)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(127))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHotel)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTypeOfRomm)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDate)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumberOfNights))
					.addGap(18)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
