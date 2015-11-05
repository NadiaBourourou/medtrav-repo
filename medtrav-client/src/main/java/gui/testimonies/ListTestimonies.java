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
import entities.Administrator;
import entities.Doctor;
import entities.Testimony;
import entities.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListTestimonies extends JFrame {

	private JPanel contentPane;
	List <Testimony> testimonies;
	Testimony testimonySelected= new Testimony();
	private JTable table;
	private JTextField testimonyId;
	private JTextField title;
	private JTextPane description;
	private Integer UserId=3;
	

	

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
		setBounds(100, 100, 730, 509);
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
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel.setBounds(89, 60, 473, 148);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(76, 244, 452, 215);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {	
			
			
			
						}
			
			
		});
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int idTableau=(int) table.getValueAt(table.getSelectedRow(), 3);
				System.out.println("id user selectionné = "+idTableau);
				if(idTableau==UserId)
				{panel_1.setVisible(true);}
				else{panel_1.setVisible(false);}	
			}
		});
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		
		
		
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
		

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(328, 92, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(328, 58, 89, 23);
		panel_1.add(btnUpdate);
		
		JLabel lblId = new JLabel("Id testimony");
		lblId.setBounds(10, 66, 82, 14);
		panel_1.add(lblId);
		
		testimonyId = new JTextField();
		testimonyId.setBounds(90, 62, 135, 23);
		panel_1.add(testimonyId);
		testimonyId.setEnabled(false);
		testimonyId.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 101, 46, 14);
		panel_1.add(lblTitle);
		
		title = new JTextField();
		title.setBounds(90, 97, 135, 23);
		panel_1.add(title);
		title.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 142, 70, 14);
		panel_1.add(lblDescription);
		
		description = new JTextPane();
		description.setBounds(90, 141, 197, 63);
		panel_1.add(description);
		
		JLabel lblModification = new JLabel("Modification");
		lblModification.setBounds(10, 11, 108, 23);
		panel_1.add(lblModification);
		lblModification.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JButton btnAddANew = new JButton("Add ");
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				User user=TestimonyServicesDelegate.doFindUsertById(UserId);
				if(user instanceof Patient) {System.out.println("user is PATIENT");
				AddTestimony addTestimony= new AddTestimony();
				addTestimony.setVisible(true);
				ListTestimonies.this.setVisible(false);
				}
				else if (user instanceof Doctor){System.out.println("user is a doctor ");
				JOptionPane.showMessageDialog(null, "Sorry, you are a doctor, you can't add a testimony.");}
				else if (user instanceof Administrator){JOptionPane.showMessageDialog(null, "Sorry, you are an administrator, you can't add a testimony.");}
				else {System.out.println("user normal");}
				
				
				
			}
		});
		btnAddANew.setBounds(570, 168, 130, 23);
		contentPane.add(btnAddANew);
		
		JButton btnSearchTestimonies = new JButton("Search");
		btnSearchTestimonies.setBounds(570, 135, 130, 23);
		contentPane.add(btnSearchTestimonies);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.setBounds(560, 361, 130, 23);
		contentPane.add(btnNewButton_1);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 	btnUpdate.setVisible(false);
				testimonySelected = testimonies.get(table.getSelectedRow());	
				TestimonyServicesDelegate.doUpdateTestimony(testimonySelected);
				testimonies=TestimonyServicesDelegate.doFindAllTestimonies();
				initDataBindings();
				
			}
		});
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
		
		
	
		panel_1.setVisible(false);
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
