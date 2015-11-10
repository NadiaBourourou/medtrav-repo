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

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import entities.User;
import gui.questions.ListQuestions;
import gui.testimonies.ListTestimonies;

public class PatientUi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientUi frame = new PatientUi();
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
	public PatientUi() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Begin my travel process");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				WelcomeJframe begin = new WelcomeJframe();
				begin.setVisible(true);
			}
		});
		btnNewButton.setBounds(111, 110, 195, 86);
		getContentPane().add(btnNewButton);
		
		JButton btnMyPersonalSpace = new JButton("My personal space");
		btnMyPersonalSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MedicalRecordsPatient myspace = new MedicalRecordsPatient();
				myspace.setVisible(true);
			}
		});
		btnMyPersonalSpace.setBounds(111, 207, 195, 86);
		getContentPane().add(btnMyPersonalSpace);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 28, 46, 14);
		getContentPane().add(label);
		
		JButton btnTestimonies = new JButton("Testimonies");
		btnTestimonies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListTestimonies testimonies=new ListTestimonies();
				testimonies.setVisible(true);
				
			}
		});
		btnTestimonies.setBounds(340, 110, 195, 86);
		getContentPane().add(btnTestimonies);
		
		JButton btnFaq = new JButton("F.A.Q.");
		btnFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListQuestions questions=new ListQuestions();
				questions.setVisible(true);
			}
		});
		btnFaq.setBounds(340, 207, 195, 86);
		getContentPane().add(btnFaq);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/logout-icon.png")));
		
		
		
		
	}
	
	public PatientUi(User user) {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Begin my travel process");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				WelcomeJframe begin = new WelcomeJframe(user);
				begin.setVisible(true);
			}
		});
		btnNewButton.setBounds(111, 110, 195, 86);
		getContentPane().add(btnNewButton);
		
		JButton btnMyPersonalSpace = new JButton("My personal space");
		btnMyPersonalSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MedicalRecordsPatient myspace = new MedicalRecordsPatient(user);
				myspace.setVisible(true);
			}
		});
		btnMyPersonalSpace.setBounds(111, 207, 195, 86);
		getContentPane().add(btnMyPersonalSpace);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 28, 46, 14);
		getContentPane().add(label);
		
		JButton btnTestimonies = new JButton("Testimonies");
		btnTestimonies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListTestimonies testimonies=new ListTestimonies(user);
				testimonies.setVisible(true);
				
			}
		});
		btnTestimonies.setBounds(340, 110, 195, 86);
		getContentPane().add(btnTestimonies);
		
		JButton btnFaq = new JButton("F.A.Q.");
		btnFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListQuestions questions=new ListQuestions(user);
				questions.setVisible(true);
			}
		});
		btnFaq.setBounds(340, 207, 195, 86);
		getContentPane().add(btnFaq);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/logout-icon.png")));
		
		
		
		
	}


}
