package gui.questions;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
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
import entities.User;
import gui.testimonies.DisplayTestimony;
import gui.testimonies.ListTestimonies;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import java.util.Date;

import javax.swing.JButton;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

import java.awt.Button;

public class ListQuestions extends JFrame {

	private JPanel contentPane;
	private JTable table;

	List <Question> questions;
	Question questionSelected= new Question();

	private Integer UserId=1;
	private JTextField title;
	private JTextField questionId;
	private JTextPane description;
	private JTextField recherchetf;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListQuestions frame = new ListQuestions();
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
	public ListQuestions() {
		
		questions=QuestionServicesDelegate.doFindAllQuestions();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 694);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(77, 141, 477, 152);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(77, 335, 477, 206);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idTableau=(int) table.getValueAt(table.getSelectedRow(), 4); 
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
		title.setBounds(97, 100, 121, 20);
		panel_1.add(title);
		title.setColumns(10);
		
		questionId = new JTextField();
		questionId.setEnabled(false);
		questionId.setBounds(97, 55, 121, 20);
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
				
			//	ListQuestions.this.setVisible(false);
			}
		});
		btnBackToMenu_1.setBounds(573, 340, 130, 23);
		contentPane.add(btnBackToMenu_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user=TestimonyServicesDelegate.doFindUsertById(UserId);
				if(user instanceof Patient) {System.out.println("user is PATIENT");
				AddQuestion addQuestion= new AddQuestion(UserId);
				addQuestion.setLocationRelativeTo(null);
				addQuestion.setVisible(true);
				ListQuestions.this.setVisible(false);
				}
				else if (user instanceof Doctor){System.out.println("user is a doctor ");
				JOptionPane.showMessageDialog(null, "Sorry, you are a doctor, you can't add a question.");}
				else if (user instanceof Administrator){JOptionPane.showMessageDialog(null, "Sorry, you are an administrator, you can't add a question.");}
				else {JOptionPane.showMessageDialog(null,"There's no users in the database");}
				
			
			}
		});
		btnAdd.setBounds(573, 168, 130, 23);
		contentPane.add(btnAdd);
		
		JRadioButton rbtitle = new JRadioButton("Title");
		rbtitle.setSelected(true);
		rbtitle.setBackground(Color.WHITE);
		rbtitle.setBounds(353, 77, 58, 23);
		contentPane.add(rbtitle);
		
		JRadioButton rbname = new JRadioButton("Patient's last name");
		rbname.setBackground(Color.WHITE);
		rbname.setBounds(427, 77, 140, 23);
		contentPane.add(rbname);
		
		JCheckBox Answeredcb = new JCheckBox("Answered");
		Answeredcb.setBackground(Color.WHITE);
		Answeredcb.setBounds(77, 111, 97, 23);
		contentPane.add(Answeredcb);
		
		recherchetf = new JTextField();
		recherchetf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(rbtitle.isSelected())
				{	questions=QuestionServicesDelegate.doFindAllQuestionsByTitle(recherchetf.getText());
				}
				else if(rbname.isSelected()){ questions=QuestionServicesDelegate.doFindAllQuestionsByPatientName(recherchetf.getText());
				}else{System.out.println("rien de selectionné");}
				initDataBindings();
			}
		});
		recherchetf.setColumns(10);
		recherchetf.setBounds(77, 77, 183, 23);
		contentPane.add(recherchetf);
		
		JLabel label_1 = new JLabel("Search by:");
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_1.setBounds(286, 81, 58, 14);
		contentPane.add(label_1);
		
		
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Answeredcb.isSelected())
				{questions=QuestionServicesDelegate.doFindAllQuestionsWithResponse();
				initDataBindings();
				}
				else{questions=QuestionServicesDelegate.doFindAllQuestions();
				initDataBindings();
				}
			}
		});
		button.setBounds(573, 102, 130, 23);
		contentPane.add(button);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try{
	questionSelected = questions.get(table.getSelectedRow());
				
				DisplayQuestion dispTestimony= new DisplayQuestion(questionSelected);
				dispTestimony.setLocationRelativeTo(null);
				
				dispTestimony.setVisible(true);
				dispTestimony.setLocationRelativeTo(null);
				ListQuestions.this.setVisible(false);
					
				}
				catch(Exception p){JOptionPane.showMessageDialog(null,"Please select a question.");}
				
				
			}
		});
		btnDisplay.setBounds(573, 202, 127, 23);
		contentPane.add(btnDisplay);
		
		JLabel lblListQuestions = new JLabel("Frequently asked questions");
		lblListQuestions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				

				Voice voice;
				VoiceManager vm = VoiceManager.getInstance();
				voice = vm.getVoice("kevin16");
				voice.allocate();
				try {
					voice.speak("frequently asked questions");
					
				}

				catch (Exception en) {
					System.out.println("error");
				}
			}
		});
		lblListQuestions.setForeground(SystemColor.desktop);
		lblListQuestions.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListQuestions.setBounds(190, 11, 348, 45);
		contentPane.add(lblListQuestions);
		
	
		panel_1.setVisible(false);
		ButtonGroup group = new ButtonGroup();
		group.add(rbtitle);
		group.add(rbname);
		
		JButton btnNewButton = new JButton("Answer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					questionSelected = questions.get(table.getSelectedRow());
					
					
				User user=TestimonyServicesDelegate.doFindUsertById(UserId);
				if(user instanceof Patient) {System.out.println("user is PATIENT");
				
				JOptionPane.showMessageDialog(null, "Sorry, as a patient, you can't add an answer.");
				}
				else if (user instanceof Doctor){System.out.println("user is a doctor ");
				JOptionPane.showMessageDialog(null, "Sorry, as a doctor, you can't add an answer.");}
				else if (user instanceof Administrator){
					AnswerQuestion addTestimony= new AnswerQuestion(questionSelected);
					addTestimony.setLocationRelativeTo(null);
					addTestimony.setVisible(true);
					
					ListQuestions.this.setVisible(false);
				}
				else {System.out.println("user normal");}
				} catch(Exception p){JOptionPane.showMessageDialog(null, "Please select a question");}
				
			}
		});
		btnNewButton.setBounds(573, 236, 127, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblForMoreInformations = new JLabel("For more informations, please visit our web page.");
		lblForMoreInformations.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblForMoreInformations.setBounds(77, 576, 243, 25);
		contentPane.add(lblForMoreInformations);
		
		Button button_1 = new Button("facebook");
		button_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try{
		//		https://twitter.com/MedicalTravelTn
				String url="https://www.facebook.com/MedTrav/?fref=ts";
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				
			}
			catch(Exception es){JOptionPane.showMessageDialog(null, "Error");}
			}
		});
		button_1.setBackground(SystemColor.activeCaption);
		button_1.setForeground(Color.WHITE);
		button_1.setBounds(339, 579, 97, 22);
		contentPane.add(button_1);
		
		JLabel connectedtf = new JLabel("You are connected.");
		//connectedtf.setForeground(new Color(199, 21, 133));
		connectedtf.setBounds(296, 619, 146, 23);
		contentPane.add(connectedtf);
		
		JButton btnVerifyConnection = new JButton("Verify connection");
		btnVerifyConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socket sock= new Socket();
				InetSocketAddress addr=new InetSocketAddress("www.google.com", 80);
				try{
					sock.connect(addr,3000);
					connectedtf.setForeground(new Color(0, 128, 0));
					connectedtf.setText("You are connected.");
					
				}
				catch(Exception a){
					connectedtf.setForeground(new Color(220, 20, 60));
					connectedtf.setText("You are not connected. ");
					
				} finally{
					try{sock.close();}
				catch(Exception h){}
				}
				
				
			}
		});
		btnVerifyConnection.setBounds(120, 619, 140, 23);
		contentPane.add(btnVerifyConnection);
		
		initDataBindings();
		
		Socket sock= new Socket();
		InetSocketAddress addr=new InetSocketAddress("www.google.com", 80);
		try{
			sock.connect(addr,3000);
			connectedtf.setForeground(new Color(0, 128, 0));
			connectedtf.setText("You are connected.");
			
			Button twitterbtn = new Button("twitter");
			twitterbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try{
						
						String url="https://twitter.com/MedicalTravelTn";
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
						
					}
					catch(Exception es){JOptionPane.showMessageDialog(null, "Error");}
					}
			});
			twitterbtn.setForeground(new Color(255, 255, 255));
			twitterbtn.setFont(new Font("Dialog", Font.BOLD, 12));
			twitterbtn.setBackground(new Color(0, 191, 255));
			twitterbtn.setBounds(463, 578, 97, 23);
			contentPane.add(twitterbtn);
			
			JLabel lblWhat = new JLabel("What does medical travel mean?");
			lblWhat.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblWhat.setForeground(new Color(255, 140, 0));
			lblWhat.setBounds(104, 296, 191, 28);
			contentPane.add(lblWhat);
			
			Button button_2 = new Button("Discover it in video!");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

		

				        final EmbeddedMediaPlayerComponent mediaPlayerComponent;

				        
				         NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
				        
				         Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
				       
				         VideoExample vid= new VideoExample(null);
				        ListQuestions.this.dispose();
				
				    
					
				}
			});
			button_2.setForeground(new Color(255, 255, 255));
			button_2.setBackground(new Color(143, 188, 143));
			button_2.setBounds(318, 299, 118, 22);
			contentPane.add(button_2);
			
		}
		catch(Exception a){
			connectedtf.setForeground(new Color(220, 20, 60));
			connectedtf.setText("You are not connected. ");
			
		} finally{
			try{sock.close();}
		catch(Exception h){}
		}
		
		
		
		
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
