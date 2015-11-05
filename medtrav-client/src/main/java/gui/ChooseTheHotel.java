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
import delegates.TreatmentServicesDelegate;
import entities.Hotel;
import entities.HotelBooking;

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

	JCheckBox Singleroom = new JCheckBox("Single Room");
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
				Double numNights=Double.parseDouble(textField.getText());
				
				 System.out.println("ok");
				 
				 if ( Singleroom.isSelected()){
					 
					Double pri= h.getPriceSingle();
					double o=HotelBookingServicesDelegate.doCalculPrix(pri, numNights);
					hb.setPrice(o);
				 }
				 else {Double pri= h.getPriceSuite();
					double u=HotelBookingServicesDelegate.doCalculPrix(pri, numNights);
					hb.setPrice(u); }
				 
		
		 System.out.println("ok");	
		
		 hb.setNumNights(numNights);
		 
		 hb.setHotel(h);
			HotelBookingServicesDelegate.doAddHotelBooking(hb);
					 
					
				}
			
		});
		
		JLabel lblTypeOfRomm = new JLabel("Type of room");
		
		JLabel lblNumberOfNights = new JLabel("Number of nights");
		
		Hotel arrival = new Hotel();
		Iterator w =  HotelServicesDelegate.doFindAllHotels().iterator();

		comboBox.removeAllItems();
		while (w.hasNext()) {
			arrival = ((Hotel) w.next());
			comboBox.addItem(arrival.getName());
		}
		
		
		JCheckBox suiteroom = new JCheckBox("Suite Room");
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
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(37))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(Singleroom)
									.addGap(18)
									.addComponent(suiteroom)
									.addGap(64))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
									.addComponent(btnSubmit)
									.addGap(90))))))
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
						.addComponent(Singleroom)
						.addComponent(suiteroom))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumberOfNights))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addGap(38))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
