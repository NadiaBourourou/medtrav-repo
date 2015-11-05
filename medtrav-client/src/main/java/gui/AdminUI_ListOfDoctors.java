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
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminUI_ListOfDoctors extends JFrame {
	private User user;
	private JPanel contentPane;
	
	private List<Doctor> doctors;
	private Doctor selectedDoctor= new Doctor();
	private JTable table;
	private JTextField tfSearch;

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
		panel.setBounds(26, 121, 663, 192);
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Doctors - Partners of MedTrav", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Doctors  - Partners of MedTrav", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnBackToMenu = new JButton("Back to menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnBackToMenu.setIcon(new ImageIcon(AdminUI_ListOfDoctors.class.getResource("/images/Arrow-back.png")));
		btnBackToMenu.setBounds(10, 331, 160, 43);
		
		JButton btnAddNewDoctor = new JButton("Add new doctor");
		btnAddNewDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnAddNewDoctor.setBackground(Color.WHITE);
		btnAddNewDoctor.setIcon(new ImageIcon(AdminUI_ListOfDoctors.class.getResource("/images/Plus.png")));
		btnAddNewDoctor.setBounds(513, 331, 176, 43);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(26, 90, 144, 20);
		tfSearch.setColumns(10);
		
		JButton button = new JButton("");
		button.setBounds(188, 66, 54, 44);
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon(AdminUI_ListOfDoctors.class.getResource("/images/Search.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			doctors=UserServicesDelegate.doFindDoctorsBySpecialty(tfSearch.getText());
			initDataBindings();
			}
		});
		
		JLabel lblSearch = new JLabel("Search by specialty : ");
		lblSearch.setBounds(26, 70, 132, 14);
		lblSearch.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AdminUI_ListOfDoctors.class.getResource("/images/smallLogo.png")));
		lblLogo.setBounds(10, 0, 69, 73);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(null);
		contentPane.add(lblLogo);
		contentPane.add(panel);
		contentPane.add(btnBackToMenu);
		contentPane.add(btnAddNewDoctor);
		contentPane.add(tfSearch);
		contentPane.add(lblSearch);
		contentPane.add(button);
		
		JLabel lblLoggedAs = new JLabel("");
		lblLoggedAs.setBounds(536, 11, 168, 44);
		contentPane.add(lblLoggedAs);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminUI_ListOfDoctors.class.getResource("/images/User_administrator-icon.png")));
		label.setBounds(650, 45, 54, 53);
		contentPane.add(label);
		
		
		
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
