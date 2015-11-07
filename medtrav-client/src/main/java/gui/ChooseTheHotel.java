package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import delegates.HotelBookingServicesDelegate;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblHotel = new JLabel("Hotel");
		
		textField = new JTextField();
		textField.setColumns(10);

		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(RoomType.values()));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				 Integer index2= comboBox_1.getSelectedIndex() + 1;
				 
				 if (index2==1) {
				 
				 
			//	 if ( Singleroom.isSelected()){
					 
					Double pri= h.getPriceSingle();
					double u=HotelBookingServicesDelegate.doCalculPrix(pri, numNights);
					hb.setPrice(u);

					HotelBookingServicesDelegate.doBookHotel(numNights, u, r, h, 1);
					
				 }
				 else {Double pri= h.getPriceSuite();
					double u=HotelBookingServicesDelegate.doCalculPrix(pri, numNights);
					hb.setPrice(u); 

					HotelBookingServicesDelegate.doBookHotel(numNights, u, r, h, 1);
					}
				 
		
		 System.out.println("ok");	
		//
		// hb.setNumNights(numNights);
		 
	//	 hb.setHotel(h);
		//	HotelBookingServicesDelegate.doAddHotelBooking(hb);
					 
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumberOfNights)
						.addComponent(lblTypeOfRomm)
						.addComponent(lblHotel))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnSubmit)
							.addGap(90))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(156))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHotel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTypeOfRomm)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfNights)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addGap(38))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
