package gui.procedures;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import delegates.ProcedureServicesDelegate;
import delegates.SurgeryServicesDelegate;
import entities.Doctor;
import entities.Procedure;
import entities.Surgery;
import entities.User;
import gui.surgeries.AddSurgery;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextPane;

import java.awt.SystemColor;

public class SeeProcedures extends JFrame {

	List<Procedure> procedures;
	List<Surgery> surgeries= new ArrayList<Surgery>();
	Surgery surgery=new Surgery();
	Procedure proceudreSelected = new Procedure();
	private JPanel contentPane;
	private JTable table;
	private JTextField txtIdProcedure;
	private JTextField textFieldName;
	private User user;
	private JTextField textFieldTitle;
	private JTable table_1;
	private JTextPane textPaneDesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeProcedures frame = new SeeProcedures();
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
	public SeeProcedures() {

		procedures = ProcedureServicesDelegate.doFindAllProcedures();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 729);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblSeeAllThe = new JLabel("See all the procedures");
		lblSeeAllThe.setForeground(new Color(135, 206, 250));
		lblSeeAllThe.setFont(new Font("Tahoma", Font.BOLD, 23));

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Assign surgeries",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(187)
								.addComponent(lblSeeAllThe, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)))
					.addGap(21))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblSeeAllThe, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
		);

		JLabel label = new JLabel("Title ");

		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);

		JLabel label_1 = new JLabel("Description ");

		textPaneDesc = new JTextPane();

		JButton btnModify_1 = new JButton("Add");
		btnModify_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		/*		try{	
					Surgery surgery= new Surgery();
					Doctor doctor=SurgeryServicesDelegate.doFindDoctorById(user.getUserId());
					System.out.println("nomPatient= "+doctor.getLastName());
					surgery.setDoctor(doctor);	
					surgery.setName(textFieldTitle.getText());
					surgery.setDescription(textPaneDesc.getText().toString());
					surgery.setDate(new Date());
					
					SurgeryServicesDelegate.doAddSurgery(surgery);
			//		JOptionPane.showMessageDialog(null, "Surgery successfully added");
				
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Error");
				}*/
					
	//			testimonySelected = testimonies.get(table.getSelectedRow());	

				
				surgeries.add(surgery);
				initDataBindings();
			}
		});

		JButton btnNewButton = new JButton("Modify");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		JPanel panel_3 = new JPanel();
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	proceudreSelected.addProcedureToSurgeries(surgeries);
				ProcedureServicesDelegate.doUpdateProcedure(proceudreSelected);
				procedures=ProcedureServicesDelegate.doFindAllProcedures();
				initDataBindings();
			}
		});
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				surgeries.remove(surgery);
				initDataBindings();
				textFieldTitle.setText("");
				textPaneDesc.setText("");
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(textPaneDesc, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
									.addGap(45)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnDelete_1)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnModify_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnAssign)
							.addGap(121))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnModify_1))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(label)
							.addGap(7)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(textPaneDesc, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete_1)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAssign)
					.addGap(34))
		);

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel_3
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE,
								631, Short.MAX_VALUE).addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_3
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE,
								136, Short.MAX_VALUE).addContainerGap()));

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(gl_panel_2);

		txtIdProcedure = new JTextField();
		txtIdProcedure.setEnabled(false);
		txtIdProcedure.setColumns(10);

		JLabel lblIdProcedure = new JLabel("Procedure Id");

		JLabel lblName = new JLabel("Procedure name");

		textFieldName = new JTextField();
		textFieldName.setColumns(10);

		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proceudreSelected = procedures.get(table.getSelectedRow());
				ProcedureServicesDelegate.doUpdateProcedure(proceudreSelected);
				procedures = ProcedureServicesDelegate.doFindAllProcedures();
				initDataBindings();
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcedureServicesDelegate.doDeleteProcedure(proceudreSelected);
				proceudreSelected = new Procedure();
				procedures = ProcedureServicesDelegate.doFindAllProcedures();
				initDataBindings();
				txtIdProcedure.setText("");
				textFieldName.setText("");

			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblIdProcedure, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtIdProcedure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblName)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDelete)
						.addComponent(btnModify))
					.addContainerGap(378, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnModify)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDelete))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIdProcedure)
								.addComponent(txtIdProcedure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								653, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addGap(13)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 89,
								Short.MAX_VALUE).addContainerGap()));

		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}

	public SeeProcedures(User user) {

		procedures = ProcedureServicesDelegate.doFindAllProcedures();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblSeeAllThe = new JLabel("See all the procedures");
		lblSeeAllThe.setForeground(new Color(135, 206, 250));
		lblSeeAllThe.setFont(new Font("Tahoma", Font.BOLD, 23));

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																Alignment.LEADING,
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				panel_1,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																Alignment.LEADING,
																gl_contentPane
																		.createParallelGroup(
																				Alignment.LEADING,
																				false)
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addGap(187)
																						.addComponent(
																								lblSeeAllThe,
																								GroupLayout.PREFERRED_SIZE,
																								289,
																								GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addContainerGap()
																						.addComponent(
																								panel,
																								GroupLayout.DEFAULT_SIZE,
																								673,
																								Short.MAX_VALUE))))
										.addContainerGap(21, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGap(21)
						.addComponent(lblSeeAllThe, GroupLayout.PREFERRED_SIZE,
								40, GroupLayout.PREFERRED_SIZE)
						.addGap(32)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 157,
								GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 112,
								Short.MAX_VALUE).addContainerGap()));

		txtIdProcedure = new JTextField();
		txtIdProcedure.setEnabled(false);
		txtIdProcedure.setColumns(10);

		JLabel lblIdProcedure = new JLabel("Id Procedure");

		JLabel lblName = new JLabel("Name");

		textFieldName = new JTextField();
		textFieldName.setColumns(10);

		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proceudreSelected = procedures.get(table.getSelectedRow());
				ProcedureServicesDelegate.doUpdateProcedure(proceudreSelected);
				procedures = ProcedureServicesDelegate.doFindAllProcedures();
				initDataBindings();
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcedureServicesDelegate.doDeleteProcedure(proceudreSelected);
				proceudreSelected = new Procedure();
				procedures = ProcedureServicesDelegate.doFindAllProcedures();
				initDataBindings();
				txtIdProcedure.setText("");
				textFieldName.setText("");

			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_1
						.createSequentialGroup()
						.addGap(21)
						.addGroup(
								gl_panel_1
										.createParallelGroup(Alignment.LEADING)
										.addComponent(lblIdProcedure)
										.addComponent(lblName))
						.addGap(18)
						.addGroup(
								gl_panel_1
										.createParallelGroup(Alignment.LEADING)
										.addComponent(txtIdProcedure,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldName,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 242,
								Short.MAX_VALUE)
						.addGroup(
								gl_panel_1
										.createParallelGroup(Alignment.LEADING,
												false).addComponent(btnModify)
										.addComponent(btnDelete))
						.addContainerGap(156, Short.MAX_VALUE)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(27)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblIdProcedure)
														.addComponent(
																txtIdProcedure,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnModify))
										.addPreferredGap(
												ComponentPlacement.RELATED, 28,
												Short.MAX_VALUE)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblName)
														.addComponent(
																textFieldName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnDelete))
										.addGap(23)));
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								653, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addGap(13)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 89,
								Short.MAX_VALUE).addContainerGap()));

		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Procedure, List<Procedure>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, procedures, table);
		//
		BeanProperty<Procedure, Integer> procedureBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(procedureBeanProperty).setColumnName("Id Surgery");
		//
		BeanProperty<Procedure, String> procedureBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(procedureBeanProperty_1).setColumnName("Name");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty = BeanProperty.create("selectedElement.id");
		BeanProperty<Procedure, Integer> procedureBeanProperty_2 = BeanProperty.create("id");
		AutoBinding<JTable, Integer, Procedure, Integer> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty, proceudreSelected, procedureBeanProperty_2);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty.create("selectedElement.name");
		BeanProperty<Procedure, String> procedureBeanProperty_3 = BeanProperty.create("name");
		AutoBinding<JTable, String, Procedure, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_1, proceudreSelected, procedureBeanProperty_3);
		autoBinding_1.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Procedure, Integer, JTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, proceudreSelected, procedureBeanProperty_2, txtIdProcedure, jTextFieldBeanProperty);
		autoBinding_2.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Procedure, String, JTextField, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, proceudreSelected, procedureBeanProperty_3, textFieldName, jTextFieldBeanProperty_1);
		autoBinding_3.bind();
		//
		JTableBinding<Surgery, List<Surgery>, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, surgeries, table_1);
		//
		BeanProperty<Surgery, String> surgeryBeanProperty = BeanProperty.create("name");
		jTableBinding_1.addColumnBinding(surgeryBeanProperty).setColumnName("Name");
		//
		BeanProperty<Surgery, String> surgeryBeanProperty_1 = BeanProperty.create("description");
		jTableBinding_1.addColumnBinding(surgeryBeanProperty_1).setColumnName("Description");
		//
		jTableBinding_1.bind();
		//
		BeanProperty<Surgery, String> surgeryBeanProperty_2 = BeanProperty.create("name");
		AutoBinding<JTable, String, Surgery, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table_1, jTableBeanProperty_1, surgery, surgeryBeanProperty_2);
		autoBinding_4.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty.create("selectedElement.description");
		BeanProperty<Surgery, String> surgeryBeanProperty_3 = BeanProperty.create("description");
		AutoBinding<JTable, String, Surgery, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table_1, jTableBeanProperty_2, surgery, surgeryBeanProperty_3);
		autoBinding_5.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		AutoBinding<Surgery, String, JTextField, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, surgery, surgeryBeanProperty_2, textFieldTitle, jTextFieldBeanProperty_2);
		autoBinding_6.bind();
		//
		BeanProperty<JTextPane, String> jTextPaneBeanProperty = BeanProperty.create("text");
		AutoBinding<Surgery, String, JTextPane, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, surgery, surgeryBeanProperty_3, textPaneDesc, jTextPaneBeanProperty);
		autoBinding_7.bind();
	}
}
