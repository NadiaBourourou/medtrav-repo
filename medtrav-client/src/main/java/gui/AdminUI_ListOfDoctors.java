package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

import delegates.UserServicesDelegate;
import entities.Doctor;
import entities.User;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

public class AdminUI_ListOfDoctors extends JFrame {
	private User user;
	private JPanel contentPane;
	
	private List<Doctor> doctors;
	private Doctor selectedDoctor= new Doctor();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI_ListOfDoctors frame = new AdminUI_ListOfDoctors();
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
	public AdminUI_ListOfDoctors() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem menuItem = new JMenuItem("New menu item");
		menuBar.add(menuItem);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_1);

		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setIcon(new ImageIcon(AdminUI.class
				.getResource("/images/logout-icon.png")));
		menuBar.add(mntmLogOut);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addGap(72))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
		
		doctors=UserServicesDelegate.doFindAllDoctors();
		initDataBindings();
		
		
	}
	
	
	public AdminUI_ListOfDoctors(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem menuItem = new JMenuItem("New menu item");
		menuBar.add(menuItem);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_1);

		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setIcon(new ImageIcon(AdminUI.class
				.getResource("/images/logout-icon.png")));
		menuBar.add(mntmLogOut);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	protected void initDataBindings() {
		JTableBinding<Doctor, List<Doctor>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, doctors, table);
		//
		BeanProperty<Doctor, Integer> doctorBeanProperty = BeanProperty.create("userId");
		jTableBinding.addColumnBinding(doctorBeanProperty).setColumnName("Doctor ID");
		//
		BeanProperty<Doctor, String> doctorBeanProperty_1 = BeanProperty.create("firstName");
		jTableBinding.addColumnBinding(doctorBeanProperty_1).setColumnName("First Name");
		//
		BeanProperty<Doctor, String> doctorBeanProperty_2 = BeanProperty.create("lastName");
		jTableBinding.addColumnBinding(doctorBeanProperty_2).setColumnName("Last Name");
		//
		BeanProperty<Doctor, String> doctorBeanProperty_3 = BeanProperty.create("specialty");
		jTableBinding.addColumnBinding(doctorBeanProperty_3).setColumnName("Specialty");
		//
		jTableBinding.bind();
	}
}
