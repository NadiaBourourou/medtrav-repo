package tests.FacilityServices;

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

import datechooser.beans.pic.Pictures;
import delegates. HotelServicesDelegate;
import entities.Hotel;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ListAllHotels extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List< Hotel> hotels= new ArrayList<Hotel>();
	private JTextField name;
	private JTextField description;
	private JTextField address;
	private JTextField singleroom;
	private JTextField suite;
	Hotel hotel= new Hotel();
	private JTextField idhotel;
	
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListAllHotels frame = new ListAllHotels();
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
	public ListAllHotels() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "List Of Hotels", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Manage Hotels", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 269, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Name");
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		
		JLabel lblNewLabel_3 = new JLabel("State");
		
		JLabel lblPriceForSingle = new JLabel("Price for Single Room");
		
		JLabel lblPriceForSuite = new JLabel("Price for Suite");
		
		JLabel lblStars = new JLabel("Stars");
		
		name = new JTextField();
		name.setColumns(10);
		
		description = new JTextField();
		description.setColumns(10);
		
		address = new JTextField();
		address.setColumns(10);
		
		singleroom = new JTextField();
		singleroom.setColumns(10);
		
		suite = new JTextField();
		suite.setColumns(10);
		
JLabel lblIdHotel = new JLabel("Id Hotel");
		
		idhotel = new JTextField();
		idhotel.setEnabled(false);
		idhotel.setColumns(10);
		
		
		JComboBox state = new JComboBox();
		
		JComboBox stars = new JComboBox();
		JLabel label = new JLabel("New label");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			hotel = hotels.get(table.getSelectedRow());
				idhotel.setText((hotel.getHotelId()).toString());
			    name.setText(hotel.getName());
				stars.setSelectedIndex(hotel.getStars() - 1);
			    address.setText(hotel.getAddress());
				description.setText(hotel.getDescription());
				ImageIcon icon=new ImageIcon(hotel.getPic());
				label.setIcon(icon);
				
				
				
			}
		});
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hotel = hotels.get(table.getSelectedRow());				
				HotelServicesDelegate.doUpdateHotel(hotel);
				hotels = HotelServicesDelegate.doFindAllHotels();
				initDataBindings();

			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotel = hotels.get(table.getSelectedRow());				
				HotelServicesDelegate.doDeleteHotel(hotel);
				hotels = HotelServicesDelegate.doFindAllHotels();
				initDataBindings();
				name.setText("");
			}
		});
		
		
	
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
											.addComponent(lblStars)
											.addComponent(lblPriceForSuite))
										.addGap(38))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblPriceForSingle)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblIdHotel)))
					.addGap(4)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(suite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(singleroom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(idhotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(stars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(state, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
											.addGroup(gl_panel_1.createSequentialGroup()
												.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnDelete))
											.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
												.addComponent(description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(btnUpdate))))
									.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIdHotel)
								.addComponent(idhotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED, 11, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnUpdate))
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2)
										.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(state, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPriceForSingle)
										.addComponent(singleroom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(suite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPriceForSuite))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblStars)
										.addComponent(stars, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnDelete)))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		
		
	
		hotels = HotelServicesDelegate.doFindAllHotels();
		scrollPane.setViewportView(table);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	
	}
	protected void initDataBindings() {
		JTableBinding<Hotel, List<Hotel>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, hotels, table);
		//
		BeanProperty<Hotel, Integer> hotelBeanProperty = BeanProperty.create("hotelId");
		jTableBinding.addColumnBinding(hotelBeanProperty).setColumnName("Id hotel");
		//
		BeanProperty<Hotel, byte[]> hotelBeanProperty_1 = BeanProperty.create("pic");
		jTableBinding.addColumnBinding(hotelBeanProperty_1).setColumnName("picture").setColumnClass(ImageIcon.class);
		//
		BeanProperty<Hotel, String> hotelBeanProperty_2 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(hotelBeanProperty_2).setColumnName("Name");
		//
		BeanProperty<Hotel, String> hotelBeanProperty_3 = BeanProperty.create("address");
		jTableBinding.addColumnBinding(hotelBeanProperty_3).setColumnName("Address");
		//
		BeanProperty<Hotel, String> hotelBeanProperty_5 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(hotelBeanProperty_5).setColumnName("Description");
		//
		BeanProperty<Hotel, Integer> hotelBeanProperty_10 = BeanProperty.create("stars");
		jTableBinding.addColumnBinding(hotelBeanProperty_10).setColumnName("Stars");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty = BeanProperty.create("selectedElement.name");
		BeanProperty<Hotel, String> hotelBeanProperty_4 = BeanProperty.create("name");
		AutoBinding<JTable, String, Hotel, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty, hotel, hotelBeanProperty_4);
		autoBinding.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Hotel, String, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_4, name, jTextFieldBeanProperty);
		autoBinding_1.bind();
		//
		BeanProperty<Hotel, Integer> hotelBeanProperty_6 = BeanProperty.create("hotelId");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Hotel, Integer, JTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, hotelBeanProperty_6, idhotel, jTextFieldBeanProperty_1);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty.create("selectedElement.address");
		BeanProperty<Hotel, String> hotelBeanProperty_7 = BeanProperty.create("address");
		AutoBinding<JTable, String, Hotel, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_1, hotel, hotelBeanProperty_7);
		autoBinding_3.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty.create("selectedElement.description");
		BeanProperty<Hotel, String> hotelBeanProperty_8 = BeanProperty.create("description");
		AutoBinding<JTable, String, Hotel, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_2, hotel, hotelBeanProperty_8);
		autoBinding_4.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty_3 = BeanProperty.create("selectedElement.stars");
		BeanProperty<Hotel, Integer> hotelBeanProperty_9 = BeanProperty.create("stars");
		AutoBinding<JTable, Integer, Hotel, Integer> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_3, hotel, hotelBeanProperty_9);
		autoBinding_5.bind();
	}
	}
