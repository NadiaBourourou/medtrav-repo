package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import delegates.ServiceHotelServicesDelegate;
import entities.ServiceHotel;

public class ListServiceHotelAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table;

	List<ServiceHotel> serviceHotels = new ArrayList<ServiceHotel>();
	ServiceHotel hotelService = new ServiceHotel();
	private Integer index;
	private JTextField name;
	private JTextField description;
	private JTextField txtnameHotel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListServiceHotelAdmin frame = new ListServiceHotelAdmin();
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
	public ListServiceHotelAdmin() {
		setTitle("Manage Services");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblHotel = new JLabel("Hotel");

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "List Of Services",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);

		txtnameHotel = new JTextField();
		txtnameHotel.setColumns(10);

		JButton btSearch = new JButton("");
		btSearch.setIcon(new ImageIcon(ListServiceHotelAdmin.class
				.getResource("/images/imagesearchclinic.png")));
		btSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					serviceHotels = ServiceHotelServicesDelegate
							.doFindHotelServiceByHotelName(txtnameHotel
									.getText());
					initDataBindings();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null,
							"Please choose the hotel's name ");

				}
			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ListServiceHotelAdmin.class
				.getResource("/images/hotel services (2).jpg")));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ListServiceHotelAdmin.class
				.getResource("/images/medtraaaaaav.jpg")));
		
		JButton button = new JButton("Back to menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminUI retour = new AdminUI();
				retour.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblHotel)
									.addGap(32)
									.addComponent(txtnameHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btSearch, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(9)
									.addComponent(lblNewLabel_2))
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 134, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(11)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtnameHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHotel))))
							.addGap(23))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btSearch)
							.addGap(18)))
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		JLabel lblNewLabel = new JLabel("Name");

		JLabel lblDescription = new JLabel("Description");

		name = new JTextField();
		name.setColumns(10);

		description = new JTextField();
		description.setColumns(10);

		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(ListServiceHotelAdmin.class
				.getResource("/images/update (1).png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hotelService = serviceHotels.get(table.getSelectedRow());
					ServiceHotelServicesDelegate
							.doUpdateServiceHotel(hotelService);
					serviceHotels = ServiceHotelServicesDelegate
							.doFindAllServicesHotel();
					initDataBindings();
					name.setText(null);
					description.setText(null);

					JOptionPane.showMessageDialog(null,
							"Service updated successfully ");
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Please check your information ");
				}
			}
		});

		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(ListServiceHotelAdmin.class
				.getResource("/images/Recycle_Bin_Full.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hotelService = serviceHotels.get(table.getSelectedRow());
					ServiceHotelServicesDelegate
							.doDeleteServiceHotel(hotelService);
					serviceHotels = ServiceHotelServicesDelegate
							.doFindAllServicesHotel();
					initDataBindings();

					name.setText(null);
					description.setText(null);
					JOptionPane.showMessageDialog(null, "Service deleted ");
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Please check your information ");
				}
			}
		});
		
		JButton btnAddService = new JButton("");
		btnAddService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddServiceHotel addService = new AddServiceHotel();
				addService.setVisible(true);
			}
		});
		btnAddService.setIcon(new ImageIcon(ListServiceHotelAdmin.class.getResource("/images/pluuus.jpg")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblDescription))
					.addGap(53)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(btnAddService, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAddService, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDescription)
								.addComponent(description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		table = new JTable();
		serviceHotels = ServiceHotelServicesDelegate.doFindAllServicesHotel();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<ServiceHotel, List<ServiceHotel>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ_WRITE, serviceHotels,
						table);
		//
		BeanProperty<ServiceHotel, String> serviceHotelBeanProperty = BeanProperty
				.create("name");
		jTableBinding.addColumnBinding(serviceHotelBeanProperty).setColumnName(
				"Name");
		//
		BeanProperty<ServiceHotel, String> serviceHotelBeanProperty_1 = BeanProperty
				.create("description");
		jTableBinding.addColumnBinding(serviceHotelBeanProperty_1)
				.setColumnName("Description");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty = BeanProperty
				.create("selectedElement.name");
		BeanProperty<ServiceHotel, String> serviceHotelBeanProperty_2 = BeanProperty
				.create("name");
		AutoBinding<JTable, String, ServiceHotel, String> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty, hotelService,
						serviceHotelBeanProperty_2);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty
				.create("selectedElement.description");
		BeanProperty<ServiceHotel, String> serviceHotelBeanProperty_3 = BeanProperty
				.create("description");
		AutoBinding<JTable, String, ServiceHotel, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_1, hotelService,
						serviceHotelBeanProperty_3);
		autoBinding_1.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
				.create("text");
		AutoBinding<ServiceHotel, String, JTextField, String> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, hotelService,
						serviceHotelBeanProperty_2, name,
						jTextFieldBeanProperty);
		autoBinding_2.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
				.create("text");
		AutoBinding<ServiceHotel, String, JTextField, String> autoBinding_3 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, hotelService,
						serviceHotelBeanProperty_3, description,
						jTextFieldBeanProperty_1);
		autoBinding_3.bind();
	}
}
