package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
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

import net.sf.dynamicreports.report.exception.DRException;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import reporting.Reporting;
import reporting.ReportingClinic;
import delegates.ClinicServicesDelegate;
import entities.Clinic;
import entities.User;

public class ListClinics extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<Clinic> clinics = new ArrayList<Clinic>();
	Clinic clinic = new Clinic();
	private JTextField name;
	private JTextField professionalism;
	private JTextField address;
	private JTextField phoneNumber;
	private JTextField email;
	private JTextField pricesimple;
	private JTextField pricesingle;
	private JTextField namesearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListClinics frame = new ListClinics();
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
	public ListClinics() {
		setTitle("Manage Clinics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 527);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "List Of Clinics",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ListClinics.class
				.getResource("/images/medtraaaaaav.jpg")));

		JLabel lblName_1 = new JLabel("Name");

		namesearch = new JTextField();
		namesearch.setColumns(10);

		JButton btSearch = new JButton("");
		btSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clinics = ClinicServicesDelegate
							.doFindClinicByName(namesearch.getText());
					initDataBindings();
				} catch (Exception exc) {
					JOptionPane
							.showMessageDialog(null, "Please choose a Name ");

				}

			}
		});
		btSearch.setIcon(new ImageIcon(ListClinics.class
				.getResource("/images/imagesearchclinic.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(34)
									.addComponent(lblName_1)
									.addGap(18)
									.addComponent(namesearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btSearch, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btSearch, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblName_1)
									.addComponent(namesearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);

		JLabel lblName = new JLabel("Name");

		JLabel lblProfessionalism = new JLabel("Professionalism");

		JLabel lblAddress = new JLabel("Address");

		JLabel lblPhoneNumber = new JLabel("Phone Number");

		name = new JTextField();
		name.setColumns(10);

		professionalism = new JTextField();
		professionalism.setColumns(10);

		address = new JTextField();
		address.setColumns(10);

		phoneNumber = new JTextField();
		phoneNumber.setColumns(10);

		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(ListClinics.class
				.getResource("/images/updateclinic.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clinic = clinics.get(table.getSelectedRow());

					clinic.setPriceSingle(Double.parseDouble(pricesingle
							.getText()));
					clinic.setPriceSimple(Double.parseDouble(pricesimple
							.getText()));
					clinic.setPhoneNumber(Integer.parseInt(phoneNumber
							.getText()));
					ClinicServicesDelegate.doUpdateClinic(clinic);
					clinics = ClinicServicesDelegate.doFindAllClinics();
					initDataBindings();
					name.setText(null);
					professionalism.setText(null);
					address.setText(null);
					phoneNumber.setText(null);
					email.setText(null);
					pricesimple.setText(null);
					pricesingle.setText(null);

					JOptionPane.showMessageDialog(null,
							"Clinic updated successfully ");
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Please check your information ");
				}
			}
		});

		JLabel lblEmail = new JLabel("Email");

		JLabel lblPriceSimple = new JLabel("Price Simple");

		JLabel lblPriceSingle = new JLabel("Price Single");

		email = new JTextField();
		email.setColumns(10);

		pricesimple = new JTextField();
		pricesimple.setColumns(10);

		pricesingle = new JTextField();
		pricesingle.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				AddClinic addclinic = new AddClinic();
				addclinic.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ListClinics.class.getResource("/images/add clinic.png")));
		
		JButton btnReports = new JButton("Reports");
		btnReports.setIcon(new ImageIcon(ListClinics.class.getResource("/images/modifCancel.png")));
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportingClinic reporting = new ReportingClinic();
				try {
					reporting.main(null);
				} catch (FileNotFoundException | DRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnBackToMenu = new JButton("Back to menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminUI retour = new AdminUI();
				retour.setVisible(true);
				
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblEmail)
						.addComponent(lblPhoneNumber)
						.addComponent(lblPriceSimple)
						.addComponent(lblProfessionalism)
						.addComponent(lblAddress)
						.addComponent(lblPriceSingle))
					.addGap(45)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(pricesingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
							.addComponent(btnReports, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(56))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(professionalism, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(phoneNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(pricesimple, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(103)
									.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(241)
									.addComponent(btnBackToMenu, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(198, Short.MAX_VALUE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(professionalism, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProfessionalism))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAddress))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(phoneNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPhoneNumber))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmail))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(pricesimple, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPriceSimple))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(pricesingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPriceSingle)))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnNewButton, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(btnUpdate, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(163)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnReports)
								.addComponent(btnBackToMenu))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);

		table = new JTable();

		clinics = ClinicServicesDelegate.doFindAllClinics();

		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}

	public ListClinics(User user) {
		setTitle("Manage Clinics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 527);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "List Of Clinics",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ListClinics.class
				.getResource("/images/medtraaaaaav.jpg")));

		JLabel lblName_1 = new JLabel("Name");

		namesearch = new JTextField();
		namesearch.setColumns(10);

		JButton btSearch = new JButton("");
		btSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clinics = ClinicServicesDelegate
							.doFindClinicByName(namesearch.getText());
					initDataBindings();
				} catch (Exception exc) {
					JOptionPane
							.showMessageDialog(null, "Please choose a Name ");

				}

			}
		});
		btSearch.setIcon(new ImageIcon(ListClinics.class
				.getResource("/images/imagesearchclinic.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(34)
									.addComponent(lblName_1)
									.addGap(18)
									.addComponent(namesearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btSearch, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btSearch, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblName_1)
									.addComponent(namesearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);

		JLabel lblName = new JLabel("Name");

		JLabel lblProfessionalism = new JLabel("Professionalism");

		JLabel lblAddress = new JLabel("Address");

		JLabel lblPhoneNumber = new JLabel("Phone Number");

		name = new JTextField();
		name.setColumns(10);

		professionalism = new JTextField();
		professionalism.setColumns(10);

		address = new JTextField();
		address.setColumns(10);

		phoneNumber = new JTextField();
		phoneNumber.setColumns(10);

		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(ListClinics.class
				.getResource("/images/updateclinic.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clinic = clinics.get(table.getSelectedRow());

					clinic.setPriceSingle(Double.parseDouble(pricesingle
							.getText()));
					clinic.setPriceSimple(Double.parseDouble(pricesimple
							.getText()));
					clinic.setPhoneNumber(Integer.parseInt(phoneNumber
							.getText()));
					ClinicServicesDelegate.doUpdateClinic(clinic);
					clinics = ClinicServicesDelegate.doFindAllClinics();
					initDataBindings();
					name.setText(null);
					professionalism.setText(null);
					address.setText(null);
					phoneNumber.setText(null);
					email.setText(null);
					pricesimple.setText(null);
					pricesingle.setText(null);

					JOptionPane.showMessageDialog(null,
							"Clinic updated successfully ");
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Please check your information ");
				}
			}
		});

		JLabel lblEmail = new JLabel("Email");

		JLabel lblPriceSimple = new JLabel("Price Simple");

		JLabel lblPriceSingle = new JLabel("Price Single");

		email = new JTextField();
		email.setColumns(10);

		pricesimple = new JTextField();
		pricesimple.setColumns(10);

		pricesingle = new JTextField();
		pricesingle.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				AddClinic addclinic = new AddClinic(user);
				addclinic.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ListClinics.class.getResource("/images/add clinic.png")));
		
		JButton btnReports = new JButton("Reports");
		btnReports.setIcon(new ImageIcon(ListClinics.class.getResource("/images/modifCancel.png")));
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportingClinic reporting = new ReportingClinic();
				try {
					reporting.main(null);
				} catch (FileNotFoundException | DRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnBackToMenu = new JButton("Back to menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminUI retour = new AdminUI(user);
				retour.setVisible(true);
				
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblEmail)
						.addComponent(lblPhoneNumber)
						.addComponent(lblPriceSimple)
						.addComponent(lblProfessionalism)
						.addComponent(lblAddress)
						.addComponent(lblPriceSingle))
					.addGap(45)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(pricesingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
							.addComponent(btnReports, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(56))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(professionalism, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(phoneNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(pricesimple, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(103)
									.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(241)
									.addComponent(btnBackToMenu, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(198, Short.MAX_VALUE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(professionalism, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProfessionalism))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAddress))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(phoneNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPhoneNumber))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmail))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(pricesimple, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPriceSimple))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(pricesingle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPriceSingle)))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnNewButton, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(btnUpdate, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(163)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnReports)
								.addComponent(btnBackToMenu))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);

		table = new JTable();

		clinics = ClinicServicesDelegate.doFindAllClinics();

		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	
	protected void initDataBindings() {
		JTableBinding<Clinic, List<Clinic>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ_WRITE, clinics, table);
		//
		BeanProperty<Clinic, String> clinicBeanProperty = BeanProperty
				.create("name");
		jTableBinding.addColumnBinding(clinicBeanProperty).setColumnName(
				"Name ");
		//
		BeanProperty<Clinic, String> clinicBeanProperty_1 = BeanProperty
				.create("professionalism");
		jTableBinding.addColumnBinding(clinicBeanProperty_1).setColumnName(
				"Professionalism");
		//
		BeanProperty<Clinic, String> clinicBeanProperty_2 = BeanProperty
				.create("address");
		jTableBinding.addColumnBinding(clinicBeanProperty_2).setColumnName(
				"Address");
		//
		BeanProperty<Clinic, Integer> clinicBeanProperty_3 = BeanProperty
				.create("phoneNumber");
		jTableBinding.addColumnBinding(clinicBeanProperty_3).setColumnName(
				"Phone Number");
		//
		BeanProperty<Clinic, String> clinicBeanProperty_8 = BeanProperty
				.create("email");
		jTableBinding.addColumnBinding(clinicBeanProperty_8).setColumnName(
				"Email");
		//
		BeanProperty<Clinic, Double> clinicBeanProperty_9 = BeanProperty
				.create("priceSimple");
		jTableBinding.addColumnBinding(clinicBeanProperty_9).setColumnName(
				"Price Simple");
		//
		BeanProperty<Clinic, Double> clinicBeanProperty_10 = BeanProperty
				.create("priceSingle");
		jTableBinding.addColumnBinding(clinicBeanProperty_10).setColumnName(
				"Price Single");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty = BeanProperty
				.create("selectedElement.name");
		BeanProperty<Clinic, String> clinicBeanProperty_4 = BeanProperty
				.create("name");
		AutoBinding<JTable, String, Clinic, String> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty, clinic, clinicBeanProperty_4);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty
				.create("selectedElement.professionalism");
		BeanProperty<Clinic, String> clinicBeanProperty_5 = BeanProperty
				.create("professionalism");
		AutoBinding<JTable, String, Clinic, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_1, clinic, clinicBeanProperty_5);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty
				.create("selectedElement.address");
		BeanProperty<Clinic, String> clinicBeanProperty_6 = BeanProperty
				.create("address");
		AutoBinding<JTable, String, Clinic, String> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_2, clinic, clinicBeanProperty_6);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty_3 = BeanProperty
				.create("selectedElement.phoneNumber");
		BeanProperty<Clinic, Integer> clinicBeanProperty_7 = BeanProperty
				.create("phoneNumber");
		AutoBinding<JTable, Integer, Clinic, Integer> autoBinding_3 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_3, clinic, clinicBeanProperty_7);
		autoBinding_3.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
				.create("text");
		AutoBinding<Clinic, String, JTextField, String> autoBinding_4 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, clinic,
						clinicBeanProperty_4, name, jTextFieldBeanProperty);
		autoBinding_4.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
				.create("text");
		AutoBinding<Clinic, String, JTextField, String> autoBinding_5 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, clinic,
						clinicBeanProperty_5, professionalism,
						jTextFieldBeanProperty_1);
		autoBinding_5.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty
				.create("text");
		AutoBinding<Clinic, String, JTextField, String> autoBinding_6 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, clinic,
						clinicBeanProperty_6, address, jTextFieldBeanProperty_2);
		autoBinding_6.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty
				.create("text");
		AutoBinding<Clinic, Integer, JTextField, String> autoBinding_7 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, clinic,
						clinicBeanProperty_7, phoneNumber,
						jTextFieldBeanProperty_3);
		autoBinding_7.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_4 = BeanProperty
				.create("selectedElement.email");
		BeanProperty<Clinic, String> clinicBeanProperty_11 = BeanProperty
				.create("email");
		AutoBinding<JTable, String, Clinic, String> autoBinding_8 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_4, clinic, clinicBeanProperty_11);
		autoBinding_8.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_5 = BeanProperty
				.create("selectedElement.priceSimple");
		BeanProperty<Clinic, Double> clinicBeanProperty_12 = BeanProperty
				.create("priceSimple");
		AutoBinding<JTable, Double, Clinic, Double> autoBinding_9 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_5, clinic, clinicBeanProperty_12);
		autoBinding_9.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_6 = BeanProperty
				.create("selectedElement.priceSingle");
		BeanProperty<Clinic, Double> clinicBeanProperty_13 = BeanProperty
				.create("priceSingle");
		AutoBinding<JTable, Double, Clinic, Double> autoBinding_10 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_6, clinic, clinicBeanProperty_13);
		autoBinding_10.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty
				.create("text");
		AutoBinding<Clinic, String, JTextField, String> autoBinding_11 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, clinic,
						clinicBeanProperty_11, email, jTextFieldBeanProperty_4);
		autoBinding_11.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_5 = BeanProperty
				.create("text");
		AutoBinding<Clinic, Double, JTextField, String> autoBinding_12 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, clinic,
						clinicBeanProperty_12, pricesimple,
						jTextFieldBeanProperty_5);
		autoBinding_12.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_6 = BeanProperty
				.create("text");
		AutoBinding<Clinic, Double, JTextField, String> autoBinding_13 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, clinic,
						clinicBeanProperty_13, pricesingle,
						jTextFieldBeanProperty_6);
		autoBinding_13.bind();
	}
}
