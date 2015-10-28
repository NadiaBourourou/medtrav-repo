package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Box.Filler;
import javax.swing.border.EmptyBorder;

import delegates.TreatmentServicesDelegate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;
import net.miginfocom.swing.MigLayout;

public class WelcomeJframe extends JFrame {

	private JPanel contentPane;
	JComboBox cbProcedure = new JComboBox();
	JComboBox cbTreatment = new JComboBox();
	JLabel lblWelcome = new JLabel(" ");
	JLabel lblDescriptionLabel = new JLabel("");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeJframe frame = new WelcomeJframe();
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public void fillProcedureCombo() {
		try {
			TreatmentServicesDelegate.doFindAllProcedures();
		int taille=TreatmentServicesDelegate.doFindAllProcedures().size();
	for (int i =0; i<taille;i++)
		{
			String name=TreatmentServicesDelegate.doFindAllProcedures().get(i).getName();
		cbProcedure.addItem(name);
		}
		

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}
	
	public void fillTreatmentCombo() {
		try {
			Integer index=cbProcedure.getSelectedIndex()+1;
			JOptionPane.showMessageDialog(null, index);
			System.out.println(index);
		TreatmentServicesDelegate.doFindAllTreatmentsByProcedureId(index);
		int taille=TreatmentServicesDelegate.doFindAllTreatmentsByProcedureId(index).size();
	for (int i =0; i<taille;i++)
		{
			String name=TreatmentServicesDelegate.doFindAllTreatmentsByProcedureId(index).get(i).getName();
	cbTreatment.addItem(name);
		}
		

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public void Welcome(String username) {
		// this.lblWelcome.setText("Helloooo " + username + "! ");
	}

	public WelcomeJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				
			}
		});
		menuBar.add(mntmLogOut);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[112px][1px][1px][198px][1px][1px][1px][1px][][][][][][][][][][][]", "[57px][20px][20px][20px][20px][][][][][][][]"));

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/smallLogo.png")));
		contentPane.add(lblLogo, "cell 0 0,alignx center,aligny top");

		JLabel label = new JLabel("");
		contentPane.add(label, "cell 1 0,alignx left,aligny center");

		JLabel label_1 = new JLabel("");
		contentPane.add(label_1, "cell 2 0,alignx left,aligny center");

		JLabel lblProcedure = new JLabel("Select a procedure");
		contentPane.add(lblProcedure, "cell 0 1,growx,aligny center");
		
		fillProcedureCombo();
		cbProcedure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTreatmentCombo();
			}
		});
		


		contentPane.add(cbProcedure, "cell 3 1,growx,aligny top");
		contentPane.add(lblWelcome, "cell 3 0,alignx center,aligny center");

		
	
		JLabel lblTreatment = new JLabel("Select a treatment");
		contentPane.add(lblTreatment, "cell 0 2,growx,aligny center");
		cbTreatment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lblDescriptionLabel.setText(TreatmentServicesDelegate.doGetTreatmentDescription(1).toString());
			lblDescriptionLabel.setText("desc1");
		
			}
		});


		contentPane.add(cbTreatment, "cell 3 2,growx,aligny top");

		JLabel label_2 = new JLabel("");
		contentPane.add(label_2, "cell 4 0,alignx left,aligny center");

		JLabel label_3 = new JLabel("");
		contentPane.add(label_3, "cell 5 0,alignx left,aligny center");

		JLabel label_4 = new JLabel("");
		contentPane.add(label_4, "cell 7 0,alignx left,aligny center");
		
		JLabel lblDescriptionLabel = new JLabel("");
		contentPane.add(lblDescriptionLabel, "flowx,cell 9 2 9 3");
		
		JDateChooser dateChooser = new JDateChooser();
		contentPane.add(dateChooser, "cell 3 3,growx,aligny top");
		
		JDateChooser dateChooser_1 = new JDateChooser();
		contentPane.add(dateChooser_1, "cell 3 4,growx,aligny top");

	}
}
