package gui.testimonies;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Testimony;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayTestimony extends JFrame {

	private JPanel contentPane;
	static Testimony testimonySelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayTestimony frame = new DisplayTestimony(testimonySelected);
					 frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param testimonySelected 
	 */
	public DisplayTestimony(Testimony testimonySelected) {
		this.testimonySelected=testimonySelected;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 509);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(83, 100, 500, 283);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Patient Name :");
		label.setForeground(new Color(0, 128, 128));
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(10, 11, 140, 39);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Date :");
		label_1.setForeground(new Color(0, 128, 128));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(271, 11, 61, 39);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Description :");
		label_2.setForeground(new Color(0, 128, 128));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(10, 130, 106, 39);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Title :");
		label_3.setForeground(new Color(0, 128, 128));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(10, 81, 61, 39);
		panel.add(label_3);
		
		JTextPane descriptp = new JTextPane();
		descriptp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descriptp.setEnabled(false);
		descriptp.setBounds(110, 138, 238, 96);
		panel.add(descriptp);
		
		JLabel titletf = new JLabel("");
		titletf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titletf.setEnabled(false);
		titletf.setBounds(60, 89, 238, 24);
		panel.add(titletf);
		
		JLabel nametf = new JLabel("");
		nametf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nametf.setEnabled(false);
		nametf.setBounds(128, 20, 100, 24);
		panel.add(nametf);
		
		JLabel datetf = new JLabel("");
		datetf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		datetf.setEnabled(false);
		datetf.setBounds(327, 20, 173, 24);
		panel.add(datetf);
		
		datetf.setText(testimonySelected.getDate().toString());
		nametf.setText(testimonySelected.getPatient().getFirstName()+" "+testimonySelected.getPatient().getLastName());
		titletf.setText(testimonySelected.getTitle());
		descriptp.setText(testimonySelected.getDescription());
		
		JLabel lblDisplayTestimony = new JLabel("Display testimony");
		lblDisplayTestimony.setForeground(SystemColor.desktop);
		lblDisplayTestimony.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDisplayTestimony.setBounds(239, 17, 216, 45);
		contentPane.add(lblDisplayTestimony);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListTestimonies dispTestimony= new ListTestimonies();
				dispTestimony.setLocationRelativeTo(null);
				
				dispTestimony.setVisible(true);
				DisplayTestimony.this.setVisible(false);
			}
		});
		btnReturn.setBounds(38, 417, 89, 23);
		contentPane.add(btnReturn);
		
		
	}
}
