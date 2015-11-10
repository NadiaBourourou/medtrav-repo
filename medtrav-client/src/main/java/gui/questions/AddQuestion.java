package gui.questions;

import delegates.QuestionServicesDelegate;
import delegates.TestimonyServicesDelegate;
import entities.Patient;
import entities.Question;
import entities.Testimony;
import entities.User;
import gui.testimonies.AddTestimony;
import gui.testimonies.ListTestimonies;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.awt.SystemColor;

import javax.swing.ImageIcon;

public class AddQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
private User userConnected;
	static Integer userId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestion frame = new AddQuestion(userId);
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
	public AddQuestion(Integer userId) {
		this.userId=userId;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Title :");
		label.setBounds(217, 109, 46, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(294, 105, 231, 23);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Description :");
		label_1.setBounds(217, 192, 91, 33);
		contentPane.add(label_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setBounds(293, 192, 232, 103);
		contentPane.add(textPane);
		
		JButton button = new JButton("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
					Question question= new Question();
					Patient patient=TestimonyServicesDelegate.doFindPatientById(userId);
					System.out.println("nomPatient= "+patient.getLastName());
					question.setPatient(patient);		
					question.setTitle(textField.getText());
					question.setDescription(textPane.getText().toString());
					question.setDate(new Date());
					QuestionServicesDelegate.doAddQuestion(question);
					JOptionPane.showMessageDialog(null, "Successfully added..");
					AddQuestion.this.setVisible(false);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Error");
				}
					
				ListQuestions dispTestimony= new ListQuestions();
				dispTestimony.setLocationRelativeTo(null);
				dispTestimony.setVisible(true);
				AddQuestion.this.setVisible(false);
					
				
				
				
			}
		});
		button.setBounds(238, 343, 89, 23);
		contentPane.add(button);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListTestimonies dispTestimony= new ListTestimonies();
				dispTestimony.setLocationRelativeTo(null);
				dispTestimony.setVisible(true);
				AddQuestion.this.setVisible(false);
				
			}
		});
		btnReturn.setBounds(37, 343, 89, 23);
		contentPane.add(btnReturn);
		
		JLabel lblAskAQuestion = new JLabel("Ask a question");
		lblAskAQuestion.setForeground(SystemColor.desktop);
		lblAskAQuestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAskAQuestion.setBounds(221, 11, 216, 45);
		contentPane.add(lblAskAQuestion);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AddQuestion.class.getResource("/images/quest.png")));
		label_2.setBounds(37, 100, 142, 180);
		contentPane.add(label_2);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				textField.setText("");
			}
		});
		btnCancel.setBounds(390, 343, 89, 23);
		contentPane.add(btnCancel);
	}
	/**
	 * @wbp.parser.constructor
	 */
	public AddQuestion(User userConnected) {
		
		this.userId=userConnected.getUserId();
		System.out.println("ADD ");
		System.out.println("user co id="+userConnected.getUserId());
		System.out.println("user co name="+userConnected.getFirstName()+userConnected.getLastName());		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Title :");
		label.setBounds(217, 109, 46, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(294, 105, 231, 23);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Description :");
		label_1.setBounds(217, 192, 91, 33);
		contentPane.add(label_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setBounds(293, 192, 232, 103);
		contentPane.add(textPane);
		
		JButton button = new JButton("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
					Question question= new Question();
					Patient patient=TestimonyServicesDelegate.doFindPatientById(userId);
					System.out.println("nomPatient= "+patient.getLastName());
					question.setPatient(patient);		
					question.setTitle(textField.getText());
					question.setDescription(textPane.getText().toString());
					question.setDate(new Date());
					QuestionServicesDelegate.doAddQuestion(question);
					JOptionPane.showMessageDialog(null, "Successfully added..");
					AddQuestion.this.setVisible(false);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Error");
				}
					
				ListQuestions dispTestimony= new ListQuestions(userConnected);
				dispTestimony.setLocationRelativeTo(null);
				dispTestimony.setVisible(true);
				AddQuestion.this.setVisible(false);
					
				
				
				
			}
		});
		button.setBounds(238, 343, 89, 23);
		contentPane.add(button);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListTestimonies dispTestimony= new ListTestimonies(userConnected);
				dispTestimony.setLocationRelativeTo(null);
				dispTestimony.setVisible(true);
				AddQuestion.this.setVisible(false);
				
			}
		});
		btnReturn.setBounds(37, 343, 89, 23);
		contentPane.add(btnReturn);
		
		JLabel lblAskAQuestion = new JLabel("Ask a question");
		lblAskAQuestion.setForeground(SystemColor.desktop);
		lblAskAQuestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAskAQuestion.setBounds(221, 11, 216, 45);
		contentPane.add(lblAskAQuestion);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AddQuestion.class.getResource("/images/quest.png")));
		label_2.setBounds(37, 100, 142, 180);
		contentPane.add(label_2);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				textField.setText("");
			}
		});
		btnCancel.setBounds(390, 343, 89, 23);
		contentPane.add(btnCancel);
	}
	
}
