package gui.testimonies;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import delegates.TestimonyServicesDelegate;
import entities.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Thread extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thread frame = new Thread();
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
	public Thread() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTestimonies = new JButton("Testimonies");
		btnTestimonies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		User userConnected=TestimonyServicesDelegate.doFindUsertById(2);
		System.out.println("THREAD TESTIMONY ");
		System.out.println("user co id="+userConnected.getUserId());
		System.out.println("user co name="+userConnected.getFirstName()+userConnected.getLastName());		
		
		
				ListTestimonies test=new ListTestimonies(userConnected);
				test.setVisible(true);
			
			}
		});
		btnTestimonies.setBounds(181, 109, 89, 23);
		contentPane.add(btnTestimonies);
	}
}
