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
import delegates.ServiceHotelServicesDelegate;
import entities.Hotel;
import entities.ServiceHotel;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import entities.StateType;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ListHotelAndServicesPatient extends JFrame {

	private JPanel contentPane;
	private JTable tableHotel;
	
	List<Hotel> hotels= new ArrayList<Hotel>();
	Hotel hotel= new Hotel();
	
	List<ServiceHotel> servicesHotels= new ArrayList<ServiceHotel>();
	private JTable tableServiceHotel;
	
	private Integer index;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListHotelAndServicesPatient frame = new ListHotelAndServicesPatient();
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
	public ListHotelAndServicesPatient() {
		setTitle("Hotels & Services");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 446);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Hotels", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Services", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ListHotelAndServicesPatient.class.getResource("/images/hotel services (2).jpg")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addGap(39))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(397))
		);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tableServiceHotel = new JTable();
		tableServiceHotel.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(tableServiceHotel);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tableHotel = new JTable();
		tableHotel.setBackground(Color.WHITE);
		tableHotel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				////////

				hotel = hotels.get(tableHotel.getSelectedRow());	
				index= hotel.getHotelId();
			
				servicesHotels= ServiceHotelServicesDelegate.doFindAllServicesHotelByHotel(index);
				
				initDataBindingss();
			}
		});
		

		hotels = HotelServicesDelegate.doFindAllHotels();
		scrollPane.setViewportView(tableHotel);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
		initDataBindingss();
	}
	protected void initDataBindings() {
		JTableBinding<Hotel, List<Hotel>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, hotels, tableHotel);
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
		BeanProperty<Hotel, Integer> hotelBeanProperty_3 = BeanProperty.create("stars");
		jTableBinding.addColumnBinding(hotelBeanProperty_3).setColumnName("Stars");
		//
		BeanProperty<Hotel, String> hotelBeanProperty_4 = BeanProperty.create("address");
		jTableBinding.addColumnBinding(hotelBeanProperty_4).setColumnName("Address");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty = BeanProperty.create("selectedElement.name");
		BeanProperty<Hotel, String> hotelBeanProperty_5 = BeanProperty.create("name");
		AutoBinding<JTable, String, Hotel, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, tableHotel, jTableBeanProperty, hotel, hotelBeanProperty_5);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty.create("selectedElement.description");
		BeanProperty<Hotel, String> hotelBeanProperty_6 = BeanProperty.create("description");
		AutoBinding<JTable, String, Hotel, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, tableHotel, jTableBeanProperty_1, hotel, hotelBeanProperty_6);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, StateType> jTableBeanProperty_2 = BeanProperty.create("selectedElement.state");
		BeanProperty<Hotel, StateType> hotelBeanProperty_7 = BeanProperty.create("state");
		AutoBinding<JTable, StateType, Hotel, StateType> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, tableHotel, jTableBeanProperty_2, hotel, hotelBeanProperty_7);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty_3 = BeanProperty.create("selectedElement.stars");
		BeanProperty<Hotel, Integer> hotelBeanProperty_8 = BeanProperty.create("stars");
		AutoBinding<JTable, Integer, Hotel, Integer> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, tableHotel, jTableBeanProperty_3, hotel, hotelBeanProperty_8);
		autoBinding_3.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_4 = BeanProperty.create("selectedElement.address");
		BeanProperty<Hotel, String> hotelBeanProperty_9 = BeanProperty.create("address");
		AutoBinding<JTable, String, Hotel, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, tableHotel, jTableBeanProperty_4, hotel, hotelBeanProperty_9);
		autoBinding_4.bind();
	}
	protected void initDataBindingss() {
		//
		JTableBinding<ServiceHotel, List<ServiceHotel>, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, servicesHotels, tableServiceHotel);
		//
		BeanProperty<ServiceHotel, String> serviceHotelBeanProperty = BeanProperty.create("name");
		jTableBinding_1.addColumnBinding(serviceHotelBeanProperty).setColumnName("Name Of Service");
		//
		BeanProperty<ServiceHotel, String> serviceHotelBeanProperty_1 = BeanProperty.create("description");
		jTableBinding_1.addColumnBinding(serviceHotelBeanProperty_1).setColumnName("Details");
		//
		jTableBinding_1.bind();
	}
}
