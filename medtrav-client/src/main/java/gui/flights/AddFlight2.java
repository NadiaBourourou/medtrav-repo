package gui.flights;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;

import delegates.FlightServicesDelegate;
import entities.Flight;
import entities.FlightMatching;
import gui.testimonies.TestimonyInterface;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.toedter.calendar.JCalendar;

import java.awt.Color;

import javax.swing.ImageIcon;

public class AddFlight2 extends JFrame {

	private JPanel contentPane;
	private Integer userId=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlight2 frame = new AddFlight2();
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
	public AddFlight2() {
		setTitle("Add a flight");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JCalendar calendarFrom = new JCalendar();
		
		JCalendar calendarTo = new JCalendar();
		
		JComboBox comboBoxFrom = new JComboBox();
		FlightMatching departure = new FlightMatching();
		Iterator j =  FlightServicesDelegate.doFindAllDepartures().iterator();

		comboBoxFrom.removeAllItems();
		while (j.hasNext()) {
			departure = ((FlightMatching) j.next());
			comboBoxFrom.addItem(departure.getDeparture());
//			String flightMatching_id = Integer.toString(departure.getIdFlightMatching());

			// empid_txt.setText(employee_id); //textfield prend l'id de l'employé selectionné
		}
		
		JComboBox comboBoxTo = new JComboBox();
		FlightMatching arrival = new FlightMatching();
		Iterator w =  FlightServicesDelegate.doFindAllArrivals().iterator();

		comboBoxTo.removeAllItems();
		while (w.hasNext()) {
			arrival = ((FlightMatching) w.next());
			comboBoxTo.addItem(arrival.getArrival());
//	String flightMatching_id = Integer.toString(arrival.getIdFlightMatching());

			// empid_txt.setText(employee_id); //textfield prend l'id de l'employé selectionné
		}	
		
		
		JButton btnAdd = new JButton("Confirm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = comboBoxFrom.getSelectedItem().toString();
				System.out.println("from "+from);
				
				String to = comboBoxTo.getSelectedItem().toString();
				System.out.println("to "+to);
				
				Date departureDate = calendarFrom.getDate();
				System.out.println("departure Date "+departureDate);
				
			Date arrivalDate = calendarTo.getDate();
			System.out.println("arrival Date "+arrivalDate);
			
			String dateDepartureString = departureDate.toString();
			
			String jourDep=dateDepartureString.substring(8, 10);
			String moisDep=dateDepartureString.substring(4, 7);
			String anneeDep=dateDepartureString.substring(30, 34);
			
			if(moisDep.equals("Jan")) moisDep="01";
			if(moisDep.equals("Feb")) moisDep="02";
			if(moisDep.equals("Mar")) moisDep="03";
			if(moisDep.equals("Apr")) moisDep="04";
			if(moisDep.equals("May")) moisDep="05";
			if(moisDep.equals("Jun")) moisDep="06";
			if(moisDep.equals("Jul")) moisDep="07";
			if(moisDep.equals("Aug")) moisDep="08";
			if(moisDep.equals("Sep")) moisDep="09";
			if(moisDep.equals("Oct")) moisDep="10";
			if(moisDep.equals("Nov")) moisDep="11";
			if(moisDep.equals("Dec")) moisDep="12";
			
			
		//String dateDepBDD = jourDep+"-"+moisDep+"-"+anneeDep+" "+00+":"+00+":"+00;
			String dateDepBDD = jourDep+"-"+moisDep+"-"+anneeDep;
		System.out.println("date départ en string : " + dateDepBDD); //date départ en string : 09-05-2017 0:0:0
			
			
			
			String dateArrivalString = arrivalDate.toString();
			
			String jourArr=dateArrivalString.substring(8, 10);
			String moisArr=dateArrivalString.substring(4, 7);
			String anneeArr=dateArrivalString.substring(30, 34);
			
			if(moisArr.equals("Jan")) moisArr="01";
			if(moisArr.equals("Feb")) moisArr="02";
			if(moisArr.equals("Mar")) moisArr="03";
			if(moisArr.equals("Apr")) moisArr="04";
			if(moisArr.equals("May")) moisArr="05";
			if(moisArr.equals("Jun")) moisArr="06";
			if(moisArr.equals("Jul")) moisArr="07";
			if(moisArr.equals("Aug")) moisArr="08";
			if(moisArr.equals("Sep")) moisArr="09";
			if(moisArr.equals("Oct")) moisArr="10";
			if(moisArr.equals("Nov")) moisArr="11";
			if(moisArr.equals("Dec")) moisArr="12";
			
			
	//String dateArrivalBDD = jourArr+"-"+moisArr+"-"+anneeArr+" "+00+":"+00+":"+00;
			String dateArrivalBDD = jourArr+"-"+moisArr+"-"+anneeArr;

	System.out.println("date arrivée en string : " + dateArrivalBDD); //date arrivée en string : 09-05-2017 0:0:0
	
	
ChooseFlight2 chooseFlight= new ChooseFlight2(from,to,dateDepBDD,dateArrivalBDD);
chooseFlight.setVisible(true);
AddFlight2.this.setVisible(false);

				/*Flight flight=new Flight();
				flight.setAirline("easyJet");
				flight.setArrivalDate(departureDate);
				flight.setArrivalLocation(to);
				flight.setDepartureDate(arrivalDate);
				flight.setDepartureLocation(from);
				flight.setPrice(280D);

				if(FlightServicesDelegate.doAddFlight(flight))
				{
					JOptionPane.showMessageDialog(null, "Success adding a flight...");
				}
				else{
					System.out.println("Failed to add a flight!");
					JOptionPane.showMessageDialog(null,"Error adding flight");

				}*/
			}
		});
		btnAdd.setIcon(new ImageIcon(AddFlight2.class.getResource("/images/add.png")));
	//	btnAdd.setBounds(10, 331, 160, 43);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AddFlight2.class.getResource("/images/smallLogo.png")));
		lblLogo.setBounds(10, 0, 69, 73);
		
		JButton buttonHome = new JButton("");
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageFlights home= new ManageFlights();
				home.setVisible(true);
				AddFlight2.this.setVisible(false);
			}
		});
		buttonHome.setIcon(new ImageIcon(AddFlight2.class.getResource("/images/blue-home-icon.png")));
		
		JLabel label = new JLabel("Add a flight");
		label.setForeground(new Color(135, 206, 250));
		label.setFont(new Font("Tahoma", Font.BOLD, 23));
	//	buttonHome.setBounds(10, 331, 160, 43);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxFrom, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addComponent(calendarFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFrom, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(comboBoxTo, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(110, Short.MAX_VALUE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(calendarTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(114)))))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonHome, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(59))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(buttonHome))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFrom)
								.addComponent(lblTo))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxFrom, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(calendarFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(calendarTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(75))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(246)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
