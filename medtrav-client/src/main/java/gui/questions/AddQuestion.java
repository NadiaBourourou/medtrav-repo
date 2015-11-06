package gui.questions;

import delegates.QuestionServicesDelegate;
import delegates.TestimonyServicesDelegate;
import entities.Patient;
import entities.Question;
import entities.Testimony;
import gui.testimonies.AddTestimony;
import gui.testimonies.TestimonyInterface;

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

public class AddQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Integer userId=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestion frame = new AddQuestion();
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
	public AddQuestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Title :");
		label.setBounds(293, 125, 46, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(369, 116, 231, 33);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Description :");
		label_1.setBounds(293, 208, 91, 33);
		contentPane.add(label_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(369, 208, 232, 103);
		contentPane.add(textPane);
		
		JButton button = new JButton("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
					Question question= new Question();
					Patient patient=TestimonyServicesDelegate.doFindPatientById(userId);
					System.out.println("nomPatient= "+patient.getFirstName());
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
					
					TestimonyInterface testInt= new TestimonyInterface();
					testInt.setVisible(true);
					
				
				
				
			}
		});
		button.setBounds(335, 377, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(512, 377, 89, 23);
		contentPane.add(button_1);
		
		JLabel lblAddQuestion = new JLabel("Ask a question");
		lblAddQuestion.setForeground(new Color(32, 178, 170));
		lblAddQuestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAddQuestion.setBounds(355, 33, 188, 45);
		contentPane.add(lblAddQuestion);
	}
}
