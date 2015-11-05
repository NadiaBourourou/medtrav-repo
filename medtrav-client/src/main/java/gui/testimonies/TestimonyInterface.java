package gui.testimonies;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestimonyInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestimonyInterface frame = new TestimonyInterface();
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
	public TestimonyInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 686, 457);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add testimony");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddTestimony addTestimony= new AddTestimony();
				addTestimony.setVisible(true);
				TestimonyInterface.this.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(256, 160, 137, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("List testimonies");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListTestimonies listTestimonies = new ListTestimonies();
				listTestimonies.setVisible(true);
				TestimonyInterface.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(256, 229, 137, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTestimonies = new JLabel("Testimonies");
		lblTestimonies.setForeground(new Color(32, 178, 170));
		lblTestimonies.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTestimonies.setBounds(243, 45, 179, 45);
		contentPane.add(lblTestimonies);
	}
}
