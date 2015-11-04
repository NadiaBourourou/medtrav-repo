package gui.testimonies;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.util.List;

import javax.swing.JTable;

import delegates.TestimonyServicesDelegate;
import entities.Testimony;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import entities.Patient;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ObjectProperty;
import java.util.Date;

public class ListTestimonies extends JFrame {

	private JPanel contentPane;
	List <Testimony> testimonies;
	Testimony testimonySelected= new Testimony();
	private JTable table;
	private JTextField testimonyId;
	private JTextField title;
	private JTextPane description;
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListTestimonies frame = new ListTestimonies();
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
	public ListTestimonies() {
		testimonies=TestimonyServicesDelegate.doFindAllTestimonies();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListTestimonies = new JLabel("List testimonies");
		lblListTestimonies.setForeground(new Color(32, 178, 170));
		lblListTestimonies.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListTestimonies.setBounds(240, 11, 216, 45);
		contentPane.add(lblListTestimonies);
		
		JPanel panel = new JPanel();
		panel.setBounds(89, 60, 473, 148);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				testimonySelected = testimonies.get(table.getSelectedRow());	
				TestimonyServicesDelegate.doUpdateTestimony(testimonySelected);
				testimonies=TestimonyServicesDelegate.doFindAllTestimonies();
				initDataBindings();
			}
		});
		btnUpdate.setBounds(414, 261, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestimonyServicesDelegate.doDeleteTestimony(testimonySelected);
				testimonies=TestimonyServicesDelegate.doFindAllTestimonies();
				initDataBindings();
				testimonyId.setText("");
				description.setText("");
				title.setText("");
			}
		});
		btnNewButton.setBounds(414, 295, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnMenu = new JButton("Back to menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestimonyInterface testInt= new TestimonyInterface();
				testInt.setVisible(true);
				ListTestimonies.this.setVisible(false);
			}
		});
		btnMenu.setBounds(560, 400, 130, 23);
		contentPane.add(btnMenu);
		
		JLabel lblModification = new JLabel("Modification");
		lblModification.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblModification.setBounds(89, 235, 108, 23);
		contentPane.add(lblModification);
		
		JLabel lblId = new JLabel("Id testimony");
		lblId.setBounds(99, 269, 82, 14);
		contentPane.add(lblId);
		
		testimonyId = new JTextField();
		testimonyId.setEnabled(false);
		testimonyId.setBounds(179, 265, 135, 23);
		contentPane.add(testimonyId);
		testimonyId.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(99, 304, 46, 14);
		contentPane.add(lblTitle);
		
		title = new JTextField();
		title.setBounds(179, 300, 135, 23);
		contentPane.add(title);
		title.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(99, 345, 70, 14);
		contentPane.add(lblDescription);
		
		description = new JTextPane();
		description.setBounds(179, 344, 197, 63);
		contentPane.add(description);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Testimony, List<Testimony>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, testimonies, table);
		//
		BeanProperty<Testimony, Integer> testimonyBeanProperty = BeanProperty.create("testimonyId");
		jTableBinding.addColumnBinding(testimonyBeanProperty).setColumnName("Id testimony");
		//
		BeanProperty<Testimony, String> testimonyBeanProperty_1 = BeanProperty.create("title");
		jTableBinding.addColumnBinding(testimonyBeanProperty_1).setColumnName("Title");
		//
		BeanProperty<Testimony, String> testimonyBeanProperty_2 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(testimonyBeanProperty_2).setColumnName("Description");
		//
		BeanProperty<Testimony, Integer> testimonyBeanProperty_3 = BeanProperty.create("patient.userId");
		jTableBinding.addColumnBinding(testimonyBeanProperty_3).setColumnName("Id patient");
		//
		BeanProperty<Testimony, Date> testimonyBeanProperty_7 = BeanProperty.create("date");
		jTableBinding.addColumnBinding(testimonyBeanProperty_7).setColumnName("Date");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty = BeanProperty.create("selectedElement.testimonyId");
		BeanProperty<Testimony, Integer> testimonyBeanProperty_4 = BeanProperty.create("testimonyId");
		AutoBinding<JTable, Integer, Testimony, Integer> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty, testimonySelected, testimonyBeanProperty_4);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty.create("selectedElement.title");
		BeanProperty<Testimony, String> testimonyBeanProperty_5 = BeanProperty.create("title");
		AutoBinding<JTable, String, Testimony, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_1, testimonySelected, testimonyBeanProperty_5);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty.create("selectedElement.description");
		BeanProperty<Testimony, String> testimonyBeanProperty_6 = BeanProperty.create("description");
		AutoBinding<JTable, String, Testimony, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_2, testimonySelected, testimonyBeanProperty_6);
		autoBinding_2.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Testimony, Integer, JTextField, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, testimonySelected, testimonyBeanProperty_4, testimonyId, jTextFieldBeanProperty);
		autoBinding_3.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Testimony, String, JTextField, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, testimonySelected, testimonyBeanProperty_5, title, jTextFieldBeanProperty_1);
		autoBinding_4.bind();
		//
		BeanProperty<JTextPane, String> jTextPaneBeanProperty = BeanProperty.create("text");
		AutoBinding<Testimony, String, JTextPane, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, testimonySelected, testimonyBeanProperty_6, description, jTextPaneBeanProperty);
		autoBinding_5.bind();
	}
}
