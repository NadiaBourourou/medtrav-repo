package gui.testimonies;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URL;

import sun.audio.*;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;



public class testVoix extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testVoix frame = new testVoix();
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
	public testVoix() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Voice voice;
				VoiceManager vm = VoiceManager.getInstance();
				voice = vm.getVoice("kevin16");
				voice.allocate();
				try {
					voice.speak("testimonies");
					voice.speak("frequently asked questions");
				}

				catch (Exception en) {
					System.out.println("error");
				}

			}
		});
		btnNewButton.setBounds(114, 119, 89, 23);
		contentPane.add(btnNewButton);
	}
}