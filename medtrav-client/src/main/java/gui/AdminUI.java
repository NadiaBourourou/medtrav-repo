package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AdminUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
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
	public AdminUI() {
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
		mntmLogOut.setIcon(new ImageIcon(AdminUI.class.getResource("/images/logout-icon.png")));
		menuBar.add(mntmLogOut);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AdminUI.class.getResource("/images/smallLogo.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogo.setBounds(10, 11, 69, 74);
		contentPane.add(lblLogo);
		
		JButton btnHotels = new JButton("Hotels");
		btnHotels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHotels.setBounds(154, 345, 144, 34);
		contentPane.add(btnHotels);
		
		JButton btnClinics = new JButton("Hospitals & clinics");
		btnClinics.setBounds(154, 152, 144, 34);
		contentPane.add(btnClinics);
		
		JButton btnForum = new JButton("Forum");
		btnForum.setBounds(387, 345, 135, 34);
		contentPane.add(btnForum);
		
		JLabel lblClinic = new JLabel("");
		lblClinic.setIcon(new ImageIcon(AdminUI.class.getResource("/images/admin-hospital-icon.png")));
		lblClinic.setBounds(154, 28, 144, 113);
		contentPane.add(lblClinic);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminUI.class.getResource("/images/admin-hotel-icon.png")));
		label.setBounds(164, 197, 113, 137);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AdminUI.class.getResource("/images/forum.png")));
		label_1.setBounds(393, 217, 113, 116);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AdminUI.class.getResource("/images/admin_icon_doctors.png")));
		label_2.setBounds(393, 15, 118, 126);
		contentPane.add(label_2);
		
		JButton btnDoctors = new JButton("Doctors");
		btnDoctors.setBounds(387, 152, 135, 34);
		contentPane.add(btnDoctors);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(AdminUI.class.getResource("/images/User_administrator-icon.png")));
		label_3.setBounds(653, 0, 51, 50);
		contentPane.add(label_3);
	}
}
