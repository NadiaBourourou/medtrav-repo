package gui.surgeries;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import delegates.SurgeryServicesDelegate;
import delegates.TestimonyServicesDelegate;
import entities.Surgery;
import entities.Testimony;
import entities.User;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeeAllMySurgeries extends JFrame {

	private JPanel contentPane;
	List<Surgery> surgeries;
	Surgery surgerySelected= new Surgery();
	//private Integer userId=3;
	private JTable table;
	private JLabel lblSeeAllMy;
	private JPanel panel_1;
	private JLabel label;
	private JTextField textFieldIdSurgery;
	private JTextField textFieldTitle;
	private JLabel label_1;
	private JLabel label_2;
	private JTextPane textPaneDescription;
	private JButton btnModify;
	private JButton btnDelete;
	private JButton button;
	private JLabel labelLogo;
	
	private User user;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeAllMySurgeries frame = new SeeAllMySurgeries();
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
	public SeeAllMySurgeries() {
		setTitle("See all the surgeries");
		surgeries = SurgeryServicesDelegate.doFindAllSurgeries();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		lblSeeAllMy = new JLabel("See all the surgeries");
		lblSeeAllMy.setForeground(new Color(135, 206, 250));
		lblSeeAllMy.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		panel_1 = new JPanel();
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSurgeries home = new ManageSurgeries();
				home.setVisible(true);
				SeeAllMySurgeries.this.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(SeeAllMySurgeries.class
				.getResource("/images/blue-home-icon.png")));
		button.setBounds(10, 331, 160, 43);
		
		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(SeeAllMySurgeries.class.getResource("/images/smallLogo.png")));
		labelLogo.setBounds(10, 0, 69, 73);	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(176)
							.addComponent(lblSeeAllMy, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(lblSeeAllMy, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 142, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		label = new JLabel("Id testimony");
		
		textFieldIdSurgery = new JTextField();
		textFieldIdSurgery.setEnabled(false);
		textFieldIdSurgery.setColumns(10);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		
		label_1 = new JLabel("Title");
		
		label_2 = new JLabel("Description");
		
		textPaneDescription = new JTextPane();
		
		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				surgerySelected = surgeries.get(table.getSelectedRow());	
				SurgeryServicesDelegate.doUpdateSurgery(surgerySelected);
				surgeries=SurgeryServicesDelegate.doFindAllSurgeries();
				initDataBindings();
			}
		});
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SurgeryServicesDelegate.doDeleteSurgery(surgerySelected);
				surgeries=SurgeryServicesDelegate.doFindAllSurgeries();
				initDataBindings();
				textFieldIdSurgery.setText("");
				textFieldTitle.setText("");
				textPaneDescription.setText("");
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1))
									.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
									.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addGap(22)
									.addComponent(textFieldIdSurgery, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(135)
							.addComponent(textPaneDescription, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnModify)
						.addComponent(btnDelete))
					.addGap(116))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(4)
									.addComponent(label))
								.addComponent(textFieldIdSurgery, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(13)
									.addComponent(label_1)
									.addGap(11)
									.addComponent(label_2))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(18)
									.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPaneDescription, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(23)
							.addComponent(btnModify)
							.addGap(33)
							.addComponent(btnDelete)))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 654, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	

	public SeeAllMySurgeries(User user) {
		setTitle("See all the surgeries");
		surgeries = SurgeryServicesDelegate.doFindAllSurgeries();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		lblSeeAllMy = new JLabel("See all the surgeries");
		lblSeeAllMy.setForeground(new Color(135, 206, 250));
		lblSeeAllMy.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		panel_1 = new JPanel();
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSurgeries home = new ManageSurgeries(user);
				home.setVisible(true);
				SeeAllMySurgeries.this.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(SeeAllMySurgeries.class
				.getResource("/images/blue-home-icon.png")));
		button.setBounds(10, 331, 160, 43);
		
		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(SeeAllMySurgeries.class.getResource("/images/smallLogo.png")));
		labelLogo.setBounds(10, 0, 69, 73);	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(176)
							.addComponent(lblSeeAllMy, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(lblSeeAllMy, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 142, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		label = new JLabel("Id testimony");
		
		textFieldIdSurgery = new JTextField();
		textFieldIdSurgery.setEnabled(false);
		textFieldIdSurgery.setColumns(10);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		
		label_1 = new JLabel("Title");
		
		label_2 = new JLabel("Description");
		
		textPaneDescription = new JTextPane();
		
		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				surgerySelected = surgeries.get(table.getSelectedRow());	
				SurgeryServicesDelegate.doUpdateSurgery(surgerySelected);
				surgeries=SurgeryServicesDelegate.doFindAllSurgeries();
				initDataBindings();
			}
		});
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SurgeryServicesDelegate.doDeleteSurgery(surgerySelected);
				surgeries=SurgeryServicesDelegate.doFindAllSurgeries();
				initDataBindings();
				textFieldIdSurgery.setText("");
				textFieldTitle.setText("");
				textPaneDescription.setText("");
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1))
									.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
									.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addGap(22)
									.addComponent(textFieldIdSurgery, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(135)
							.addComponent(textPaneDescription, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnModify)
						.addComponent(btnDelete))
					.addGap(116))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(4)
									.addComponent(label))
								.addComponent(textFieldIdSurgery, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(13)
									.addComponent(label_1)
									.addGap(11)
									.addComponent(label_2))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(18)
									.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPaneDescription, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(23)
							.addComponent(btnModify)
							.addGap(33)
							.addComponent(btnDelete)))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 654, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	

	
	protected void initDataBindings() {
		JTableBinding<Surgery, List<Surgery>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, surgeries, table);
		//
		BeanProperty<Surgery, Integer> surgeryBeanProperty = BeanProperty.create("surgeryId");
		jTableBinding.addColumnBinding(surgeryBeanProperty).setColumnName("Surgery Id");
		//
		BeanProperty<Surgery, String> surgeryBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(surgeryBeanProperty_1).setColumnName("Title");
		//
		BeanProperty<Surgery, String> surgeryBeanProperty_2 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(surgeryBeanProperty_2).setColumnName("Description");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty = BeanProperty.create("selectedElement.surgeryId");
		BeanProperty<Surgery, Integer> surgeryBeanProperty_3 = BeanProperty.create("surgeryId");
		AutoBinding<JTable, Integer, Surgery, Integer> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty, surgerySelected, surgeryBeanProperty_3);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty.create("selectedElement.description");
		BeanProperty<Surgery, String> surgeryBeanProperty_5 = BeanProperty.create("description");
		AutoBinding<JTable, String, Surgery, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_2, surgerySelected, surgeryBeanProperty_5);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty.create("selectedElement.name");
		BeanProperty<Surgery, String> surgeryBeanProperty_4 = BeanProperty.create("name");
		AutoBinding<JTable, String, Surgery, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_1, surgerySelected, surgeryBeanProperty_4);
		autoBinding_1.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Surgery, Integer, JTextField, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, surgerySelected, surgeryBeanProperty_3, textFieldIdSurgery, jTextFieldBeanProperty);
		autoBinding_3.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Surgery, String, JTextField, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, surgerySelected, surgeryBeanProperty_4, textFieldTitle, jTextFieldBeanProperty_1);
		autoBinding_4.bind();
		//
		BeanProperty<JTextPane, String> jTextPaneBeanProperty = BeanProperty.create("text");
		AutoBinding<Surgery, String, JTextPane, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, surgerySelected, surgeryBeanProperty_5, textPaneDescription, jTextPaneBeanProperty);
		autoBinding_5.bind();
	}
}
