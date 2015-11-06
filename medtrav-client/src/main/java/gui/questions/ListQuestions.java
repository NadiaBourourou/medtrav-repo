package gui.questions;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import delegates.QuestionServicesDelegate;
import delegates.TestimonyServicesDelegate;
import entities.Administrator;
import entities.Doctor;
import entities.Patient;
import entities.Question;
import entities.Testimony;
import entities.User;
import gui.testimonies.AddTestimony;
import gui.testimonies.ListTestimonies;
import gui.testimonies.TestimonyInterface;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import java.util.Date;

import javax.swing.JButton;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListQuestions extends JFrame {

	private JPanel contentPane;
	private JTable table;

	List <Question> questions;
	Question questionSelected= new Question();

	private Integer UserId=1;
	private JTextField title;
	private JTextField questionId;
	private JTextPane description;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListQuestions frame = new ListQuestions();
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
	public ListQuestions() {
		questions=QuestionServicesDelegate.doFindAllQuestions();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListQuestions = new JLabel("List questions");
		lblListQuestions.setForeground(new Color(32, 178, 170));
		lblListQuestions.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListQuestions.setBounds(203, 11, 216, 45);
		contentPane.add(lblListQuestions);
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 67, 504, 152);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(64, 253, 428, 206);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idTableau=(int) table.getValueAt(table.getSelectedRow(), 4); // peutetre ptob : 3
				System.out.println("id user selectionné = "+idTableau);
				if(idTableau==UserId)
				{panel_1.setVisible(true);}
				else{panel_1.setVisible(false);}	
				
			}
		});
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		
		JLabel label = new JLabel("Modification");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(10, 11, 108, 23);
		panel_1.add(label);
		
		title = new JTextField();
		title.setBounds(123, 100, 121, 20);
		panel_1.add(title);
		title.setColumns(10);
		
		questionId = new JTextField();
		questionId.setEnabled(false);
		questionId.setBounds(123, 55, 121, 20);
		panel_1.add(questionId);
		questionId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id question");
		lblNewLabel.setBounds(20, 58, 93, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setBounds(20, 103, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(20, 134, 85, 14);
		panel_1.add(lblNewLabel_2);
		
		description = new JTextPane();
		description.setBounds(123, 134, 139, 56);
		panel_1.add(description);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	questionSelected = questions.get(table.getSelectedRow());	
				QuestionServicesDelegate.doUpdateQuestion(questionSelected);
				questions=QuestionServicesDelegate.doFindAllQuestions();
				initDataBindings();
			} catch(Exception c){ JOptionPane.showMessageDialog(null, "Please click on the item."); }
			}
		});
		btnUpdate.setBounds(303, 54, 89, 23);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				QuestionServicesDelegate.doDeleteQuestion(questionSelected);
				questions=QuestionServicesDelegate.doFindAllQuestions();
				initDataBindings();
				questionId.setText("");
				description.setText("");
				title.setText("");
			} catch(Exception c){ JOptionPane.showMessageDialog(null, "Please click on the item."); }
				
			}
		});
		btnDelete.setBounds(303, 99, 89, 23);
		panel_1.add(btnDelete);
		
		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.setBounds(723, 475, 117, 23);
		contentPane.add(btnBackToMenu);
		
		JButton btnBackToMenu_1 = new JButton("Back to Menu");
		btnBackToMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestimonyInterface testInt= new TestimonyInterface();
				testInt.setVisible(true);
				ListQuestions.this.setVisible(false);
			}
		});
		btnBackToMenu_1.setBounds(564, 318, 117, 23);
		contentPane.add(btnBackToMenu_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user=TestimonyServicesDelegate.doFindUsertById(UserId);
				if(user instanceof Patient) {System.out.println("user is PATIENT");
				AddQuestion addQuestion= new AddQuestion();
				addQuestion.setVisible(true);
				ListQuestions.this.setVisible(false);
				}
				else if (user instanceof Doctor){System.out.println("user is a doctor ");
				JOptionPane.showMessageDialog(null, "Sorry, you are a doctor, you can't add a question.");}
				else if (user instanceof Administrator){JOptionPane.showMessageDialog(null, "Sorry, you are an administrator, you can't add a question.");}
				else {System.out.println("user normal");}
				
			
			}
		});
		btnAdd.setBounds(592, 147, 89, 23);
		contentPane.add(btnAdd);
		panel_1.setVisible(false);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Question, List<Question>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, questions, table);
		//
		BeanProperty<Question, Integer> questionBeanProperty = BeanProperty.create("questionId");
		jTableBinding.addColumnBinding(questionBeanProperty).setColumnName("Id question");
		//
		BeanProperty<Question, String> questionBeanProperty_1 = BeanProperty.create("title");
		jTableBinding.addColumnBinding(questionBeanProperty_1).setColumnName("Title");
		//
		BeanProperty<Question, String> questionBeanProperty_2 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(questionBeanProperty_2).setColumnName("Description");
		//
		BeanProperty<Question, Date> questionBeanProperty_3 = BeanProperty.create("date");
		jTableBinding.addColumnBinding(questionBeanProperty_3).setColumnName("Date");
		//
		BeanProperty<Question, Integer> questionBeanProperty_4 = BeanProperty.create("patient.userId");
		jTableBinding.addColumnBinding(questionBeanProperty_4).setColumnName("Id patient");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty = BeanProperty.create("selectedElement.questionId");
		BeanProperty<Question, Integer> questionBeanProperty_5 = BeanProperty.create("questionId");
		AutoBinding<JTable, Integer, Question, Integer> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty, questionSelected, questionBeanProperty_5);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty.create("selectedElement.title");
		BeanProperty<Question, String> questionBeanProperty_6 = BeanProperty.create("title");
		AutoBinding<JTable, String, Question, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_1, questionSelected, questionBeanProperty_6);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty.create("selectedElement.description");
		BeanProperty<Question, String> questionBeanProperty_7 = BeanProperty.create("description");
		AutoBinding<JTable, String, Question, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_2, questionSelected, questionBeanProperty_7);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, Date> jTableBeanProperty_3 = BeanProperty.create("selectedElement.date");
		BeanProperty<Question, Date> questionBeanProperty_8 = BeanProperty.create("date");
		AutoBinding<JTable, Date, Question, Date> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_3, questionSelected, questionBeanProperty_8);
		autoBinding_3.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty_4 = BeanProperty.create("selectedElement.patient.userId");
		BeanProperty<Question, Integer> questionBeanProperty_9 = BeanProperty.create("patient.userId");
		AutoBinding<JTable, Integer, Question, Integer> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_4, questionSelected, questionBeanProperty_9);
		autoBinding_4.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Question, Integer, JTextField, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, questionSelected, questionBeanProperty_5, questionId, jTextFieldBeanProperty);
		autoBinding_5.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Question, String, JTextField, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, questionSelected, questionBeanProperty_6, title, jTextFieldBeanProperty_1);
		autoBinding_6.bind();
		//
		BeanProperty<JTextPane, String> jTextPaneBeanProperty = BeanProperty.create("text");
		AutoBinding<Question, String, JTextPane, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, questionSelected, questionBeanProperty_7, description, jTextPaneBeanProperty);
		autoBinding_7.bind();
	}
}
