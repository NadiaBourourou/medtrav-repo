package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorUI frame = new DoctorUI();
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
	public DoctorUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 714, 21);
		contentPane.add(menuBar);
		
		JMenuItem menuLogout = new JMenuItem("Log Out");
		menuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorUI.this.setVisible(false);
				HelloMedtrav back = new HelloMedtrav();
				back.setVisible(true);
			
			}
		});
		menuLogout.setIcon(new ImageIcon(DoctorUI.class.getResource("/images/logout-icon.png")));
		menuBar.add(menuLogout);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(DoctorUI.class.getResource("/images/smallLogo.png")));
		logo.setBounds(10, 32, 69, 71);
		contentPane.add(logo);
		
		JLabel doctorIcon = new JLabel("");
		doctorIcon.setIcon(new ImageIcon(DoctorUI.class.getResource("/images/user_doctor_icon.png")));
		doctorIcon.setBounds(651, 65, 63, 57);
		contentPane.add(doctorIcon);
		
		JLabel lblLoggedAs = new JLabel("");
		lblLoggedAs.setBounds(536, 32, 168, 22);
		contentPane.add(lblLoggedAs);
	}
}
