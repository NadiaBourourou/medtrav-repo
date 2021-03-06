package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.sf.dynamicreports.report.exception.DRException;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import reporting.Reporting;
import delegates.HotelServicesDelegate;
import entities.Hotel;
import entities.StateType;

public class ListHotelsAdmin extends JFrame {

	List<Hotel> hotels = new ArrayList<Hotel>();
	Hotel hotel = new Hotel();

	private JPanel contentPane;
	private JTable table;
	private JTextField pricesingle;
	private JTextField pricedouble;
	private JTextField address;
	private JTextField description;
	private JTextField name;
	private JComboBox comboBoxstate;
	private JTextField namesearch;
	private JTextField staars;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListHotelsAdmin frame = new ListHotelsAdmin();
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
	public ListHotelsAdmin() {
		setTitle("Manage Hotel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "List Of Hotels",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);

		JLabel label = new JLabel("Price for single room");

		JLabel label_1 = new JLabel("Price for Suite");

		JLabel label_2 = new JLabel("Name");

		JLabel label_3 = new JLabel("Description");

		JLabel label_4 = new JLabel("Address");

		JLabel label_5 = new JLabel("State");

		JLabel label_6 = new JLabel("Stars");

		pricesingle = new JTextField();
		pricesingle.setColumns(10);

		pricedouble = new JTextField();
		pricedouble.setColumns(10);

		comboBoxstate = new JComboBox();
		comboBoxstate.setModel(new DefaultComboBoxModel(StateType.values()));

		address = new JTextField();
		address.setColumns(10);

		description = new JTextField();
		description.setColumns(10);

		name = new JTextField();
		name.setColumns(10);

		JButton btupdate = new JButton("");
		btupdate.setIcon(new ImageIcon(ListHotelsAdmin.class
				.getResource("/images/update (1).png")));
		btupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hotel = hotels.get(table.getSelectedRow());

					hotel.setPriceSingle(Double.parseDouble(pricesingle
							.getText()));
					hotel.setPriceSuite(Double.parseDouble(pricedouble
							.getText()));
					hotel.setStars(Integer.parseInt(staars.getText()));
					HotelServicesDelegate.doUpdateHotel(hotel);
					hotels = HotelServicesDelegate.doFindAllHotels();
					initDataBindings();
					name.setText(null);
					description.setText(null);
					address.setText(null);
					pricesingle.setText(null);
					pricedouble.setText(null);
					staars.setText(null);

					JOptionPane.showMessageDialog(null,
							"Hotel updated successfully ");
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Please check your information ");
				}
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ListHotelsAdmin.class
				.getResource("/images/hotel_icon4_tns.png")));

		staars = new JTextField();
		staars.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddHotel addHotel = new AddHotel();
				addHotel.setVisible(true);
			}
			
		});
		btnNewButton_1.setIcon(new ImageIcon(ListHotelsAdmin.class.getResource("/images/pluuus.jpg")));
		
		JButton btnReport = new JButton("Report");
		btnReport.setIcon(new ImageIcon(ListHotelsAdmin.class.getResource("/images/modifCancel.png")));
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reporting reporting = new Reporting();
				try {
					reporting.main(null);
				} catch (FileNotFoundException | DRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_2 = new JButton("Services");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				ListServiceHotelAdmin listServices = new ListServiceHotelAdmin();
				listServices.setVisible(true);
			}
		});
		
		JButton button = new JButton("Back to menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminUI retour = new AdminUI();
				retour.setVisible(true);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_5)
						.addComponent(label_6)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(pricesingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pricedouble, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxstate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(staars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnReport, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btupdate, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(38)))
							.addGap(21))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(lblNewLabel)
					.addGap(37))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btupdate, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnReport))
					.addGap(76))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxstate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addGap(9)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(staars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(pricesingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(9)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(pricedouble, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
					.addGap(27))
		);
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ListHotelsAdmin.class
				.getResource("/images/medtraaaaaav.jpg")));

		JLabel lblName = new JLabel("Name");

		namesearch = new JTextField();
		namesearch.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hotels = HotelServicesDelegate.doFindHotelByName(namesearch
							.getText());
					initDataBindings();
				} catch (Exception exc) {
					JOptionPane
							.showMessageDialog(null, "Please choose a name ");

				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(ListHotelsAdmin.class
				.getResource("/images/imagesearchclinic.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(33)
							.addComponent(lblName)
							.addGap(18)
							.addComponent(namesearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(4))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(namesearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblName)))
							.addGap(30)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		hotels = HotelServicesDelegate.doFindAllHotels();
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<Hotel, List<Hotel>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ_WRITE, hotels, table);
		//
		BeanProperty<Hotel, String> hotelBeanProperty = BeanProperty
				.create("name");
		jTableBinding.addColumnBinding(hotelBeanProperty).setColumnName(
				"Name Hotel");
		//
		BeanProperty<Hotel, String> hotelBeanProperty_1 = BeanProperty
				.create("description");
		jTableBinding.addColumnBinding(hotelBeanProperty_1).setColumnName(
				"Description");
		//
		BeanProperty<Hotel, StateType> hotelBeanProperty_2 = BeanProperty
				.create("state");
		jTableBinding.addColumnBinding(hotelBeanProperty_2).setColumnName(
				"State");
		//
		BeanProperty<Hotel, String> hotelBeanProperty_3 = BeanProperty
				.create("address");
		jTableBinding.addColumnBinding(hotelBeanProperty_3).setColumnName(
				"Address");
		//
		BeanProperty<Hotel, Integer> hotelBeanProperty_4 = BeanProperty
				.create("stars");
		jTableBinding.addColumnBinding(hotelBeanProperty_4).setColumnName(
				"Stars");
		//
		BeanProperty<Hotel, Double> hotelBeanProperty_5 = BeanProperty
				.create("priceSingle");
		jTableBinding.addColumnBinding(hotelBeanProperty_5).setColumnName(
				"Price Single");
		//
		BeanProperty<Hotel, Double> hotelBeanProperty_13 = BeanProperty
				.create("priceSuite");
		jTableBinding.addColumnBinding(hotelBeanProperty_13).setColumnName(
				"Price Suite");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty = BeanProperty
				.create("selectedElement.name");
		BeanProperty<Hotel, String> hotelBeanProperty_6 = BeanProperty
				.create("name");
		AutoBinding<JTable, String, Hotel, String> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty, hotel, hotelBeanProperty_6);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty
				.create("selectedElement.description");
		BeanProperty<Hotel, String> hotelBeanProperty_7 = BeanProperty
				.create("description");
		AutoBinding<JTable, String, Hotel, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_1, hotel, hotelBeanProperty_7);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, StateType> jTableBeanProperty_2 = BeanProperty
				.create("selectedElement.state");
		BeanProperty<Hotel, StateType> hotelBeanProperty_8 = BeanProperty
				.create("state");
		AutoBinding<JTable, StateType, Hotel, StateType> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_2, hotel, hotelBeanProperty_8);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_4 = BeanProperty
				.create("selectedElement.priceSingle");
		BeanProperty<Hotel, Double> hotelBeanProperty_10 = BeanProperty
				.create("priceSingle");
		AutoBinding<JTable, Double, Hotel, Double> autoBinding_4 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_4, hotel, hotelBeanProperty_10);
		autoBinding_4.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_5 = BeanProperty
				.create("selectedElement.priceSuite");
		BeanProperty<Hotel, Double> hotelBeanProperty_11 = BeanProperty
				.create("priceSuite");
		AutoBinding<JTable, Double, Hotel, Double> autoBinding_5 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_5, hotel, hotelBeanProperty_11);
		autoBinding_5.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
				.create("text");
		AutoBinding<Hotel, String, JTextField, String> autoBinding_6 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, hotel,
						hotelBeanProperty_6, name, jTextFieldBeanProperty);
		autoBinding_6.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
				.create("text");
		AutoBinding<Hotel, String, JTextField, String> autoBinding_7 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, hotel,
						hotelBeanProperty_7, description,
						jTextFieldBeanProperty_1);
		autoBinding_7.bind();
		//
		BeanProperty<Hotel, String> hotelBeanProperty_12 = BeanProperty
				.create("address");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty
				.create("text");
		AutoBinding<Hotel, String, JTextField, String> autoBinding_8 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, hotel,
						hotelBeanProperty_12, address, jTextFieldBeanProperty_2);
		autoBinding_8.bind();
		//
		BeanProperty<JComboBox, Object> jComboBoxBeanProperty = BeanProperty
				.create("selectedItem");
		AutoBinding<Hotel, StateType, JComboBox, Object> autoBinding_9 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, hotel,
						hotelBeanProperty_8, comboBoxstate,
						jComboBoxBeanProperty);
		autoBinding_9.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty
				.create("text");
		AutoBinding<Hotel, Double, JTextField, String> autoBinding_10 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, hotel,
						hotelBeanProperty_11, pricedouble,
						jTextFieldBeanProperty_3);
		autoBinding_10.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty
				.create("text");
		AutoBinding<Hotel, Double, JTextField, String> autoBinding_11 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, hotel,
						hotelBeanProperty_10, pricesingle,
						jTextFieldBeanProperty_4);
		autoBinding_11.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_6 = BeanProperty
				.create("selectedElement.address");
		AutoBinding<JTable, String, Hotel, String> autoBinding_13 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_6, hotel, hotelBeanProperty_12);
		autoBinding_13.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty_3 = BeanProperty
				.create("selectedElement.stars");
		BeanProperty<Hotel, Integer> hotelBeanProperty_9 = BeanProperty
				.create("stars");
		AutoBinding<JTable, Integer, Hotel, Integer> autoBinding_14 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_3, hotel, hotelBeanProperty_9);
		autoBinding_14.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_5 = BeanProperty
				.create("text");
		AutoBinding<Hotel, Integer, JTextField, String> autoBinding_3 = Bindings
				.createAutoBinding(UpdateStrategy.READ, hotel,
						hotelBeanProperty_9, staars, jTextFieldBeanProperty_5);
		autoBinding_3.bind();
	}
}
