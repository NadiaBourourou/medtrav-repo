package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegates.HotelServicesDelegate;
import entities.Hotel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.BeanProperty;

import entities.StateType;

import java.awt.Window.Type;

import javax.swing.border.TitledBorder;
import javax.swing.Icon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListHotels extends JFrame {

	List< Hotel> hotels= new ArrayList<Hotel>();
	Hotel hotel= new Hotel();
	

	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JTextField description;
	private JTextField address;
	private JTextField pricesingle;
	private JTextField pricesuite;
	private JComboBox comboBoxstate;
	private JComboBox comboBoxstars;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListHotels frame = new ListHotels();
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
	public ListHotels() {
		setType(Type.POPUP);
		setTitle("Manage Hotels");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 467, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "List Of Hotels", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 424, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(9))
		);
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblDescription = new JLabel("Description");
		
		JLabel lblAddress = new JLabel("Address");
		
		JLabel lblState = new JLabel("State");
		
		JLabel lblStars = new JLabel("Stars");
		
		JLabel lblPriceForSingle = new JLabel("Price for single room");
		
		JLabel lblPriceForSuite = new JLabel("Price for Suite");
		
		name = new JTextField();
		name.setColumns(10);
		
		description = new JTextField();
		description.setColumns(10);
		
		address = new JTextField();
		address.setColumns(10);
		
		pricesingle = new JTextField();
		pricesingle.setColumns(10);
		
		pricesuite = new JTextField();
		pricesuite.setColumns(10);
		
		comboBoxstate = new JComboBox();
		comboBoxstate.setModel(new DefaultComboBoxModel(StateType.values()));
		
		comboBoxstars = new JComboBox();
		comboBoxstars.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		JButton update = new JButton("update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hotel = hotels.get(table.getSelectedRow());				
				HotelServicesDelegate.doUpdateHotel(hotel);
				hotels = HotelServicesDelegate.doFindAllHotels();
				initDataBindings();
			}
		});
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotel = hotels.get(table.getSelectedRow());				
				HotelServicesDelegate.doDeleteHotel(hotel);
				hotels = HotelServicesDelegate.doFindAllHotels();
				initDataBindings();
				name.setText("");
				address.setText("");
				description.setText("");
				pricesingle.setText("");
				pricesuite.setText("");
			}
		});
		
		JLabel picture = new JLabel("");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPriceForSingle)
						.addComponent(lblPriceForSuite)
						.addComponent(lblName)
						.addComponent(lblDescription)
						.addComponent(lblAddress)
						.addComponent(lblState)
						.addComponent(lblStars))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(comboBoxstars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(pricesingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(pricesuite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBoxstate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(delete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(update, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(63))
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addComponent(picture, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(21))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescription)
						.addComponent(description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblState)
						.addComponent(comboBoxstate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStars)
						.addComponent(comboBoxstars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPriceForSingle)
						.addComponent(pricesingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPriceForSuite)
						.addComponent(pricesuite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addComponent(picture, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(update)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(delete)
					.addGap(24))
		);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				hotel = hotels.get(table.getSelectedRow());
				
			    name.setText(hotel.getName());
			    address.setText(hotel.getAddress());
				description.setText(hotel.getDescription());
				ImageIcon icon=new ImageIcon(getClass().getResource("medtrav.JPG"));
				picture.setIcon((Icon) icon);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImageIcon icon=new ImageIcon(getClass().getResource("medTrav.JPG"));
				picture.setIcon((Icon) icon);	
			}
		});

		
		hotels = HotelServicesDelegate.doFindAllHotels();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Hotel, List<Hotel>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, hotels, table);
		//
		BeanProperty<Hotel, String> hotelBeanProperty = BeanProperty.create("name");
		jTableBinding.addColumnBinding(hotelBeanProperty).setColumnName("Name");
		//
		BeanProperty<Hotel, String> hotelBeanProperty_1 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(hotelBeanProperty_1).setColumnName("Description");
		//
		BeanProperty<Hotel, StateType> hotelBeanProperty_2 = BeanProperty.create("state");
		jTableBinding.addColumnBinding(hotelBeanProperty_2).setColumnName("State");
		//
		BeanProperty<Hotel, Integer> hotelBeanProperty_3 = BeanProperty.create("stars");
		jTableBinding.addColumnBinding(hotelBeanProperty_3).setColumnName("Stars");
		//
		BeanProperty<Hotel, String> hotelBeanProperty_4 = BeanProperty.create("address");
		jTableBinding.addColumnBinding(hotelBeanProperty_4).setColumnName("Address");
		//
		BeanProperty<Hotel, Double> hotelBeanProperty_5 = BeanProperty.create("priceSingle");
		jTableBinding.addColumnBinding(hotelBeanProperty_5).setColumnName("Price for single room");
		//
		BeanProperty<Hotel, Double> hotelBeanProperty_6 = BeanProperty.create("priceSuite");
		jTableBinding.addColumnBinding(hotelBeanProperty_6).setColumnName("Price for suite");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty = BeanProperty.create("selectedElement.name");
		BeanProperty<Hotel, String> hotelBeanProperty_7 = BeanProperty.create("name");
		AutoBinding<JTable, String, Hotel, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty, hotel, hotelBeanProperty_7);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty.create("selectedElement.description");
		BeanProperty<Hotel, String> hotelBeanProperty_8 = BeanProperty.create("description");
		AutoBinding<JTable, String, Hotel, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_1, hotel, hotelBeanProperty_8);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, StateType> jTableBeanProperty_2 = BeanProperty.create("selectedElement.state");
		BeanProperty<Hotel, StateType> hotelBeanProperty_9 = BeanProperty.create("state");
		AutoBinding<JTable, StateType, Hotel, StateType> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_2, hotel, hotelBeanProperty_9);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty_3 = BeanProperty.create("selectedElement.stars");
		BeanProperty<Hotel, Integer> hotelBeanProperty_10 = BeanProperty.create("stars");
		AutoBinding<JTable, Integer, Hotel, Integer> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_3, hotel, hotelBeanProperty_10);
		autoBinding_3.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_4 = BeanProperty.create("selectedElement.address");
		BeanProperty<Hotel, String> hotelBeanProperty_11 = BeanProperty.create("address");
		AutoBinding<JTable, String, Hotel, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_4, hotel, hotelBeanProperty_11);
		autoBinding_4.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_5 = BeanProperty.create("selectedElement.priceSingle");
		BeanProperty<Hotel, Double> hotelBeanProperty_12 = BeanProperty.create("priceSingle");
		AutoBinding<JTable, Double, Hotel, Double> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_5, hotel, hotelBeanProperty_12);
		autoBinding_5.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_6 = BeanProperty.create("selectedElement.priceSuite");
		BeanProperty<Hotel, Double> hotelBeanProperty_13 = BeanProperty.create("priceSuite");
		AutoBinding<JTable, Double, Hotel, Double> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_6, hotel, hotelBeanProperty_13);
		autoBinding_6.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Hotel, String, JTextField, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_7, name, jTextFieldBeanProperty);
		autoBinding_7.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Hotel, String, JTextField, String> autoBinding_8 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_8, description, jTextFieldBeanProperty_1);
		autoBinding_8.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		AutoBinding<Hotel, String, JTextField, String> autoBinding_9 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_11, address, jTextFieldBeanProperty_2);
		autoBinding_9.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty.create("text");
		AutoBinding<JTable, Double, JTextField, String> autoBinding_10 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_5, pricesingle, jTextFieldBeanProperty_3);
		autoBinding_10.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty.create("text");
		AutoBinding<Hotel, Double, JTextField, String> autoBinding_11 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_13, pricesuite, jTextFieldBeanProperty_4);
		autoBinding_11.bind();
		//
		BeanProperty<JComboBox, Object> jComboBoxBeanProperty = BeanProperty.create("selectedItem");
		AutoBinding<JTable, StateType, JComboBox, Object> autoBinding_12 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_2, comboBoxstate, jComboBoxBeanProperty);
		autoBinding_12.bind();
		//
		AutoBinding<JTable, Integer, JComboBox, Object> autoBinding_13 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_3, comboBoxstars, jComboBoxBeanProperty);
		autoBinding_13.bind();
	}
}
