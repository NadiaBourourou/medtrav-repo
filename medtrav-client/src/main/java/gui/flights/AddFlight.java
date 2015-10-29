package gui.flights;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import khadija.essai.MedicalRecordsPatient;
import com.toedter.calendar.JCalendar;
import datechooser.beans.DateChooserPanel;

public class AddFlight {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlight window = new AddFlight();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddFlight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JComboBox comboBoxFrom = new JComboBox();
		comboBoxFrom.addItem("Ajaccio - Napoléon Bonaparte (AJA)");
		comboBoxFrom.addItem("Belgrade Nikola Tesla (BEG)");
		comboBoxFrom.addItem("Bordeaux Mérignac (BOD)");
		comboBoxFrom.addItem("Fribourg (EAP)");
		comboBoxFrom.addItem("Lyon-Saint-Exupéry (LYS)");
		comboBoxFrom.addItem("Marseille Provence (MRS)");
		comboBoxFrom.addItem("Nice-Côte d'Azur (NCE)");
		comboBoxFrom.addItem("Paris Charles-de-Gaulle (CDG)");
		comboBoxFrom.addItem("Paris Orly (ORY)");
		comboBoxFrom.addItem("Thessalonique-Makédonia (SKG)");
		comboBoxFrom.addItem("Toulouse Blagnac (TLS)");
		comboBoxFrom.addItem("Valencia (VLC)");
		comboBoxFrom.addItem("Vienne-Schwechat (VIE)");

		
		
		JComboBox comboBoxTo = new JComboBox();
		comboBoxTo.addItem("Djerba (DJE)");
		comboBoxTo.addItem("Enfidha (NBE)");
		comboBoxTo.addItem("Gabes (GAE)");
		comboBoxTo.addItem("Gafsa (GAF)");
		comboBoxTo.addItem("Monastir (MIR)");
		comboBoxTo.addItem("Sfax El Maou (SFA)");
		comboBoxTo.addItem("Tabarka (TBJ)");
		comboBoxTo.addItem("Tozeur (TOE)");
		comboBoxTo.addItem("Tunis Carthage (TUN)");

		
		JLabel lblDepart = new JLabel("Depart");
		lblDepart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblReturn = new JLabel("Return");
		lblReturn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnOk = new JButton("OK");
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddFlight.class
				.getResource("/images/plane-icon.png")));
		
		JCalendar calendar_1 = new JCalendar();
		
		JCalendar calendar = new JCalendar();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFrom, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDepart, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxFrom, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
						.addComponent(calendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(39)
									.addComponent(btnOk)))
							.addGap(75)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblReturn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addComponent(calendar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(7))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBoxTo, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(187))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(lblFrom)
							.addGap(18)
							.addComponent(comboBoxFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addComponent(lblDepart)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(49)
									.addComponent(btnOk))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(calendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(29))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblReturn)
							.addGap(18)
							.addComponent(calendar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(48))))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
