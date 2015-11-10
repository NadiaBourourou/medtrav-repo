package gui.questions;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JButton;

import delegates.TestimonyServicesDelegate;
import entities.Administrator;
import entities.Doctor;
import entities.Patient;
import entities.Question;
import entities.User;
import gui.testimonies.AddTestimony;
import gui.testimonies.DisplayTestimony;
import gui.testimonies.ListTestimonies;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayQuestion extends JFrame {

	private JPanel contentPane;
	static Question questionSelected;
	private Integer userId=4;
	private User userConnected;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayQuestion frame = new DisplayQuestion(questionSelected);
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
	 */
	public DisplayQuestion(Question questionSelected) {
		this.questionSelected=questionSelected;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 509);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(94, 94, 500, 331);
		contentPane.add(panel);
		
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
		descriptp.setText((String) null);
		descriptp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descriptp.setEnabled(false);
		descriptp.setBounds(110, 138, 238, 65);
		panel.add(descriptp);
		
		JLabel titletf = new JLabel((String) null);
		titletf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titletf.setEnabled(false);
		titletf.setBounds(60, 89, 238, 24);
		panel.add(titletf);
		
		JLabel nametf = new JLabel((String) null);
		nametf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nametf.setEnabled(false);
		nametf.setBounds(128, 20, 100, 24);
		panel.add(nametf);
		
		JLabel datetf = new JLabel((String) null);
		datetf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		datetf.setEnabled(false);
		datetf.setBounds(327, 20, 173, 24);
		panel.add(datetf);
		
		JLabel responseLabel = new JLabel("Response :");
		responseLabel.setForeground(new Color(0, 128, 128));
		responseLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		responseLabel.setBounds(10, 229, 106, 39);
		panel.add(responseLabel);
		
		JTextPane responseText = new JTextPane();
		responseText.setText((String) null);
		responseText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		responseText.setEnabled(false);
		responseText.setBounds(110, 237, 238, 65);
		panel.add(responseText);
		
		JLabel lblDisplayQuestion = new JLabel("Display question");
		lblDisplayQuestion.setForeground(SystemColor.desktop);
		lblDisplayQuestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDisplayQuestion.setBounds(250, 11, 216, 45);
		contentPane.add(lblDisplayQuestion);
		
		JButton button = new JButton("Return");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListQuestions dispTestimony= new ListQuestions();
				dispTestimony.setLocationRelativeTo(null);
				
				dispTestimony.setVisible(true);
				DisplayQuestion.this.setVisible(false);
			}
		});
		button.setBounds(31, 436, 89, 23);
		contentPane.add(button);

		datetf.setText(questionSelected.getDate().toString());
		nametf.setText(questionSelected.getPatient().getFirstName()+" "+questionSelected.getPatient().getLastName());
		titletf.setText(questionSelected.getTitle());
		descriptp.setText(questionSelected.getDescription());
		
		if(questionSelected.getResponse()!=null)
		{	responseText.setText(questionSelected.getResponse());
		responseText.setVisible(true);
		responseLabel.setVisible(true);
		}
		else {
			responseText.setVisible(false);
			responseLabel.setVisible(false);
			
			
			
		}
		
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public DisplayQuestion(Question questionSelected, User userConnected) {
		this.questionSelected=questionSelected;
		System.out.println("DISPLAY ");
		System.out.println("user co id="+userConnected.getUserId());
		System.out.println("user co name="+userConnected.getFirstName()+userConnected.getLastName());		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 509);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(94, 94, 500, 331);
		contentPane.add(panel);
		
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
		descriptp.setText((String) null);
		descriptp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descriptp.setEnabled(false);
		descriptp.setBounds(110, 138, 238, 65);
		panel.add(descriptp);
		
		JLabel titletf = new JLabel((String) null);
		titletf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titletf.setEnabled(false);
		titletf.setBounds(60, 89, 238, 24);
		panel.add(titletf);
		
		JLabel nametf = new JLabel((String) null);
		nametf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nametf.setEnabled(false);
		nametf.setBounds(128, 20, 100, 24);
		panel.add(nametf);
		
		JLabel datetf = new JLabel((String) null);
		datetf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		datetf.setEnabled(false);
		datetf.setBounds(327, 20, 173, 24);
		panel.add(datetf);
		
		JLabel responseLabel = new JLabel("Response :");
		responseLabel.setForeground(new Color(0, 128, 128));
		responseLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		responseLabel.setBounds(10, 229, 106, 39);
		panel.add(responseLabel);
		
		JTextPane responseText = new JTextPane();
		responseText.setText((String) null);
		responseText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		responseText.setEnabled(false);
		responseText.setBounds(110, 237, 238, 65);
		panel.add(responseText);
		
		JLabel lblDisplayQuestion = new JLabel("Display question");
		lblDisplayQuestion.setForeground(SystemColor.desktop);
		lblDisplayQuestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDisplayQuestion.setBounds(250, 11, 216, 45);
		contentPane.add(lblDisplayQuestion);
		
		JButton button = new JButton("Return");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListQuestions dispTestimony= new ListQuestions(userConnected);
				dispTestimony.setLocationRelativeTo(null);
				
				dispTestimony.setVisible(true);
				DisplayQuestion.this.setVisible(false);
			}
		});
		button.setBounds(31, 436, 89, 23);
		contentPane.add(button);

		datetf.setText(questionSelected.getDate().toString());
		nametf.setText(questionSelected.getPatient().getFirstName()+" "+questionSelected.getPatient().getLastName());
		titletf.setText(questionSelected.getTitle());
		descriptp.setText(questionSelected.getDescription());
		
		if(questionSelected.getResponse()!=null)
		{	responseText.setText(questionSelected.getResponse());
		responseText.setVisible(true);
		responseLabel.setVisible(true);
		}
		else {
			responseText.setVisible(false);
			responseLabel.setVisible(false);
			
			
			
		}
		
	}

}
