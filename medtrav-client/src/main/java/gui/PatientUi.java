package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.JLabel;

import entities.User;
import gui.questions.ListQuestions;
import gui.testimonies.ListTestimonies;

public class PatientUi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientUi frame = new PatientUi();
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
	public PatientUi() {
		getContentPane().setBackground(Color.WHITE);

		JButton btnNewButton = new JButton("Begin my travel process");
		btnNewButton.setBounds(111, 110, 195, 86);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				WelcomeJframe begin = new WelcomeJframe();
				begin.setVisible(true);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton);

		JButton btnMyPersonalSpace = new JButton("My personal space");
		btnMyPersonalSpace.setBounds(111, 207, 195, 86);
		btnMyPersonalSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MedicalRecordsPatient myspace = new MedicalRecordsPatient();
				myspace.setVisible(true);
			}
		});
		getContentPane().add(btnMyPersonalSpace);

		JLabel label = new JLabel("");
		label.setBounds(10, 28, 46, 14);
		getContentPane().add(label);

		JButton btnTestimonies = new JButton("Testimonies");
		btnTestimonies.setBounds(340, 110, 195, 86);
		btnTestimonies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListTestimonies testimonies = new ListTestimonies();
				testimonies.setVisible(true);

			}
		});
		getContentPane().add(btnTestimonies);

		JButton btnFaq = new JButton("F.A.Q.");
		btnFaq.setBounds(340, 207, 195, 86);
		btnFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListQuestions questions = new ListQuestions();
				questions.setVisible(true);
			}
		});
		getContentPane().add(btnFaq);

		JButton btnContactUs = new JButton("Contact us");
		btnContactUs.setBounds(546, 336, 122, 23);
		btnContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFrame test = new JFrame("Google Maps");

				try {
					String latitude = "36.8997598";
					String longitude = "10.1878506";

					String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
							+ latitude
							+ ","
							+ longitude
							+ "&zoom=16&size=612x612&scale=2&maptype=roadmap";
					String destinationFile = "image.jpg";

					// read the map image from Google
					// then save it to a local file: image.jpg
					//
					URL url = new URL(imageUrl);
					InputStream is = url.openStream();
					OutputStream os = new FileOutputStream(destinationFile);

					byte[] b = new byte[2048];
					int length;

					while ((length = is.read(b)) != -1) {
						os.write(b, 0, length);
					}

					is.close();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}

				// create a GUI component that loads the image: image.jpg
				//
				ImageIcon imageIcon = new ImageIcon(
						(new ImageIcon("image.jpg")).getImage()
								.getScaledInstance(630, 600,
										java.awt.Image.SCALE_SMOOTH));
				test.getContentPane().add(new JLabel(imageIcon));

				// show the GUI window
				test.setVisible(true);
				test.pack();
			}

		});
		getContentPane().add(btnContactUs);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PatientUi.class.getResource("/images/smallLogo.png")));
		label_1.setBounds(10, 11, 65, 60);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(PatientUi.class.getResource("/images/user_patient_icon.png")));
		label_2.setBounds(639, 11, 65, 60);
		getContentPane().add(label_2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmLogOut_1 = new JMenuItem("Log Out");
		mntmLogOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			HelloMedtrav quit = new HelloMedtrav();
			quit.setVisible(true);
			
			}
		});
		menuBar.add(mntmLogOut_1);

		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/logout-icon.png")));

	}

	public PatientUi(User user) {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Begin my travel process");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				WelcomeJframe begin = new WelcomeJframe(user);
				begin.setVisible(true);
			}
		});
		btnNewButton.setBounds(111, 110, 195, 86);
		getContentPane().add(btnNewButton);

		JButton btnMyPersonalSpace = new JButton("My personal space");
		btnMyPersonalSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MedicalRecordsPatient myspace = new MedicalRecordsPatient(user);
				myspace.setVisible(true);
			}
		});
		btnMyPersonalSpace.setBounds(111, 207, 195, 86);
		getContentPane().add(btnMyPersonalSpace);

		JLabel label = new JLabel("");
		label.setBounds(10, 28, 46, 14);
		getContentPane().add(label);

		JButton btnTestimonies = new JButton("Testimonies");
		btnTestimonies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListTestimonies testimonies = new ListTestimonies(user);
				testimonies.setVisible(true);

			}
		});
		btnTestimonies.setBounds(340, 110, 195, 86);
		getContentPane().add(btnTestimonies);

		JButton btnFaq = new JButton("F.A.Q.");
		btnFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListQuestions questions = new ListQuestions(user);
				questions.setVisible(true);
			}
		});
		btnFaq.setBounds(340, 207, 195, 86);
		getContentPane().add(btnFaq);

		JButton btnContactUs = new JButton("Contact us");
		btnContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFrame test = new JFrame("Google Maps");

				try {
					String latitude = "36.8511153";
					String longitude = "10.2247553";

					String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
							+ latitude
							+ ","
							+ longitude
							+ "&zoom=15&size=612x612&scale=2&maptype=roadmap";
					String destinationFile = "image.jpg";

					// read the map image from Google
					// then save it to a local file: image.jpg
					//
					URL url = new URL(imageUrl);
					InputStream is = url.openStream();
					OutputStream os = new FileOutputStream(destinationFile);

					byte[] b = new byte[2048];
					int length;

					while ((length = is.read(b)) != -1) {
						os.write(b, 0, length);
					}

					is.close();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}

				// create a GUI component that loads the image: image.jpg
				//
				ImageIcon imageIcon = new ImageIcon(
						(new ImageIcon("image.jpg")).getImage()
								.getScaledInstance(630, 600,
										java.awt.Image.SCALE_SMOOTH));
				test.getContentPane().add(new JLabel(imageIcon));

				// show the GUI window
				test.setVisible(true);
				test.pack();
			}

		});
		btnContactUs.setBounds(579, 336, 89, 23);
		getContentPane().add(btnContactUs);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PatientUi.class.getResource("/images/smallLogo.png")));
		label_1.setBounds(10, 11, 65, 60);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(PatientUi.class.getResource("/images/user_patient_icon.png")));
		label_2.setBounds(639, 11, 65, 60);
		getContentPane().add(label_2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmLogOut_1 = new JMenuItem("Log Out");
		mntmLogOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			HelloMedtrav quit = new HelloMedtrav();
			quit.setVisible(true);
			
			}
		});
		menuBar.add(mntmLogOut_1);

		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setIcon(new ImageIcon(WelcomeJframe.class
				.getResource("/images/logout-icon.png")));

	}
}
