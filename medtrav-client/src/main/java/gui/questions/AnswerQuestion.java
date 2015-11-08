package gui.questions;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.SystemColor;

import javax.swing.JButton;

import delegates.QuestionServicesDelegate;
import delegates.TestimonyServicesDelegate;
import entities.Patient;
import entities.Question;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.ImageIcon;

public class AnswerQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static Question questionSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnswerQuestion frame = new AnswerQuestion(questionSelected);
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
	public AnswerQuestion(Question questionSelected) {
		this.questionSelected=questionSelected;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Title :");
		label.setBounds(226, 109, 46, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(303, 105, 231, 23);
		contentPane.add(textField);
		
		JLabel lblResponse = new JLabel("Response :");
		lblResponse.setBounds(226, 192, 91, 33);
		contentPane.add(lblResponse);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(302, 192, 232, 103);
		contentPane.add(textPane);
		
		JButton button = new JButton("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
					
					
					
					questionSelected.setResponse(textPane.getText().toString());
					
					QuestionServicesDelegate.doUpdateQuestion(questionSelected);
					JOptionPane.showMessageDialog(null, "Answer successfully added..");
				AnswerQuestion.this.setVisible(false);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Error");
				}
					
				ListQuestions dispTestimony= new ListQuestions();
				dispTestimony.setLocationRelativeTo(null);
				
				dispTestimony.setVisible(true);
				AnswerQuestion.this.setVisible(false);
					
				
			}
		});
		button.setBounds(247, 343, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Return");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListQuestions dispTestimony= new ListQuestions();
				dispTestimony.setLocationRelativeTo(null);
				
				dispTestimony.setVisible(true);
				AnswerQuestion.this.setVisible(false);
			}
		});
		button_1.setBounds(46, 343, 89, 23);
		contentPane.add(button_1);
		
		JLabel lblAnswerTheQuestion = new JLabel("Answer the question");
		lblAnswerTheQuestion.setForeground(SystemColor.desktop);
		lblAnswerTheQuestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAnswerTheQuestion.setBounds(247, 11, 268, 45);
		contentPane.add(lblAnswerTheQuestion);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(AnswerQuestion.class.getResource("/images/accept.png")));
		label_3.setBounds(47, 87, 126, 180);
		contentPane.add(label_3);
		
		JButton button_2 = new JButton("Cancel");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
			
			}
		});
		button_2.setBounds(399, 343, 89, 23);
		contentPane.add(button_2);
		textField.setText(questionSelected.getTitle());
	}

}
