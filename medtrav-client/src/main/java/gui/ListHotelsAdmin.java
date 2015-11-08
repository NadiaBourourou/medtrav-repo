package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import delegates.HotelServicesDelegate;
import entities.Hotel;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.BeanProperty;

import entities.StateType;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

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
	private JComboBox comboBoxstars;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 441);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
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
		
		comboBoxstars = new JComboBox();
		comboBoxstars.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
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
		
		JButton btdelete = new JButton("Delete");
		btdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hotel = hotels.get(table.getSelectedRow());
				HotelServicesDelegate.doDeleteHotel(hotel);
				hotels = HotelServicesDelegate.doFindAllHotels();
				initDataBindings();
				name.setText("");
				address.setText("");
				description.setText("");
				pricesingle.setText("");
				pricedouble.setText("");
			}
		});
		
		JButton btupdate = new JButton("update");
		btupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hotel = hotels.get(table.getSelectedRow());
				HotelServicesDelegate.doUpdateHotel(hotel);
				hotels = HotelServicesDelegate.doFindAllHotels();
				initDataBindings();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 414, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_5)
						.addComponent(label_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxstars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pricesingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pricedouble, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxstate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(138)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btdelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btupdate, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
					.addGap(171))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 198, Short.MAX_VALUE)
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
						.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btupdate))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(comboBoxstate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btdelete))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(comboBoxstars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(pricesingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(pricedouble, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
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
		JTableBinding<Hotel, List<Hotel>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, hotels, table);
		//
		BeanProperty<Hotel, String> hotelBeanProperty = BeanProperty.create("name");
		jTableBinding.addColumnBinding(hotelBeanProperty).setColumnName("Name Hotel");
		//
		BeanProperty<Hotel, String> hotelBeanProperty_1 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(hotelBeanProperty_1).setColumnName("Description");
		//
		BeanProperty<Hotel, StateType> hotelBeanProperty_2 = BeanProperty.create("state");
		jTableBinding.addColumnBinding(hotelBeanProperty_2).setColumnName("State");
		//
		BeanProperty<Hotel, String> hotelBeanProperty_3 = BeanProperty.create("address");
		jTableBinding.addColumnBinding(hotelBeanProperty_3).setColumnName("Address");
		//
		BeanProperty<Hotel, Integer> hotelBeanProperty_4 = BeanProperty.create("stars");
		jTableBinding.addColumnBinding(hotelBeanProperty_4).setColumnName("Stars");
		//
		BeanProperty<Hotel, Double> hotelBeanProperty_5 = BeanProperty.create("priceSingle");
		jTableBinding.addColumnBinding(hotelBeanProperty_5).setColumnName("Price Single");
		//
		BeanProperty<Hotel, Double> hotelBeanProperty_13 = BeanProperty.create("priceSuite");
		jTableBinding.addColumnBinding(hotelBeanProperty_13).setColumnName("Price Suite");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty = BeanProperty.create("selectedElement.name");
		BeanProperty<Hotel, String> hotelBeanProperty_6 = BeanProperty.create("name");
		AutoBinding<JTable, String, Hotel, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty, hotel, hotelBeanProperty_6);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty.create("selectedElement.description");
		BeanProperty<Hotel, String> hotelBeanProperty_7 = BeanProperty.create("description");
		AutoBinding<JTable, String, Hotel, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_1, hotel, hotelBeanProperty_7);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, StateType> jTableBeanProperty_2 = BeanProperty.create("selectedElement.state");
		BeanProperty<Hotel, StateType> hotelBeanProperty_8 = BeanProperty.create("state");
		AutoBinding<JTable, StateType, Hotel, StateType> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_2, hotel, hotelBeanProperty_8);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_4 = BeanProperty.create("selectedElement.priceSingle");
		BeanProperty<Hotel, Double> hotelBeanProperty_10 = BeanProperty.create("priceSingle");
		AutoBinding<JTable, Double, Hotel, Double> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_4, hotel, hotelBeanProperty_10);
		autoBinding_4.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_5 = BeanProperty.create("selectedElement.priceSuite");
		BeanProperty<Hotel, Double> hotelBeanProperty_11 = BeanProperty.create("priceSuite");
		AutoBinding<JTable, Double, Hotel, Double> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_5, hotel, hotelBeanProperty_11);
		autoBinding_5.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Hotel, String, JTextField, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_6, name, jTextFieldBeanProperty);
		autoBinding_6.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Hotel, String, JTextField, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_7, description, jTextFieldBeanProperty_1);
		autoBinding_7.bind();
		//
		BeanProperty<Hotel, String> hotelBeanProperty_12 = BeanProperty.create("address");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		AutoBinding<Hotel, String, JTextField, String> autoBinding_8 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_12, address, jTextFieldBeanProperty_2);
		autoBinding_8.bind();
		//
		BeanProperty<JComboBox, Object> jComboBoxBeanProperty = BeanProperty.create("selectedItem");
		AutoBinding<Hotel, StateType, JComboBox, Object> autoBinding_9 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_8, comboBoxstate, jComboBoxBeanProperty);
		autoBinding_9.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty.create("text");
		AutoBinding<Hotel, Double, JTextField, String> autoBinding_10 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_11, pricedouble, jTextFieldBeanProperty_3);
		autoBinding_10.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty.create("text");
		AutoBinding<Hotel, Double, JTextField, String> autoBinding_11 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_10, pricesingle, jTextFieldBeanProperty_4);
		autoBinding_11.bind();
		//
		BeanProperty<Hotel, Integer> hotelBeanProperty_9 = BeanProperty.create("stars");
		AutoBinding<Hotel, Integer, JComboBox, Object> autoBinding_12 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_9, comboBoxstars, jComboBoxBeanProperty);
		autoBinding_12.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_6 = BeanProperty.create("selectedElement.address");
		AutoBinding<JTable, String, Hotel, String> autoBinding_13 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_6, hotel, hotelBeanProperty_12);
		autoBinding_13.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty_3 = BeanProperty.create("selectedElement.stars");
		AutoBinding<JTable, Integer, Hotel, Integer> autoBinding_14 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_3, hotel, hotelBeanProperty_9);
		autoBinding_14.bind();
	}
}
