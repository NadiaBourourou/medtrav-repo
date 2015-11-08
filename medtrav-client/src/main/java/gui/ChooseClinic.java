package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;

import com.toedter.calendar.JCalendar;

import datechooser.beans.DateChooserCombo;
import delegates.ClinicServicesDelegate;
import delegates.HotelServicesDelegate;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import entities.Clinic;
import entities.ClinicBooking;
import entities.Hotel;
import entities.RoomClinicType;
import entities.RoomType;
import entities.StateType;

import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

public class ChooseClinic extends JFrame {

	private ClinicBooking hb= new ClinicBooking();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox comboBoxClinic = new JComboBox();
		Clinic c = new Clinic();
		Iterator w =  ClinicServicesDelegate.doFindAllClinics().iterator();

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
		btnSubmit.setIcon(new ImageIcon(ChooseClinic.class.getResource("/images/validate.jpg")));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer index = comboBoxClinic.getSelectedIndex() + 1;
				System.out.println(index);

			Clinic	clinic= ClinicServicesDelegate.doFindClinicById(index);
			System.out.println(index);
				String com= commentaire.getText();
				System.out.println(index);
				//hb.setTypeRoom(RoomClinicType.valueOf(comboBoxTRC.getSelectedItem()
					//	.toString()));
				Date date = dateChooser.getDate();
				//String strDate = DateFormat.getDateInstance().format(date);
			//	hb.setDate(strDate);
				System.out.println(index);
				
				hb.setCommentaire(com);
			//	ClinicBookingServicesDelegate.doAddClinicBookingAndAffectClinic(hb, index);
				RoomClinicType r= (RoomClinicType.valueOf(comboBoxTRC.getSelectedItem()
						.toString()));
				System.out.println(index);
				
				ClinicServicesDelegate.doBookClinic(r, date, com, clinic, 1);
				System.out.println("ok");
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ChooseClinic.class.getResource("/images/imagesante.jpg")));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCommentaire)
						.addComponent(lblDate)
						.addComponent(lblTypeOfRoom)
						.addComponent(lblClinic))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBoxTRC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(comboBoxClinic, Alignment.LEADING, 0, 112, Short.MAX_VALUE)
										.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
									.addGap(18)))
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(commentaire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(100)
							.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblClinic)
								.addComponent(comboBoxClinic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxTRC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTypeOfRoom)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDate)
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(commentaire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCommentaire))))
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
