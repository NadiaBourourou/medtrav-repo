package tests.FacilityServices;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import delegates.HotelServicesDelegate;
import entities.Hotel;
import entities.StateType;

public class AddHotel extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField priceSingle;
	private JTextField Pricedouble;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddHotel frame = new AddHotel();
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
	public AddHotel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Name");

		name = new JTextField();
		name.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Address");

		address = new JTextField();
		address.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Description");

		JTextPane description = new JTextPane();

		JLabel lblNewLabel_3 = new JLabel("Stars");

		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(5);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5" }));
		comboBox.setSelectedIndex(0);

		JLabel lblState = new JLabel("State");

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(StateType.values()));
		JButton btnNewButton = new JButton("Add new Hotel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Hotel hotel = new Hotel();

				hotel.setName(name.getText());
				hotel.setAddress(address.getText());
				hotel.setDescription(description.getText());
				hotel.setPriceSingle(Double.parseDouble(priceSingle.getText()));
				hotel.setPriceSuite(Double.parseDouble(Pricedouble.getText()));
				hotel.setStars(new Integer(comboBox.getSelectedItem()
						.toString()));
				hotel.setState(StateType.valueOf(comboBox_1.getSelectedItem()
						.toString()));
				File fichier = new File(textField.getText());
			/*	FileInputStream fis = null;
				try {
					fis = new FileInputStream(fichier);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				FileReader fr = null;
				try {
					fr = new FileReader(fichier);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<Byte> list = new ArrayList<Byte>();
				int s;
				try {
					while ((s = fr.read()) != -1) {
						list.add((byte) s);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				byte[] b = new byte[list.size()];
				for (int i = 0; i < b.length; i++) {
					b[i] = list.get(i);
				}
*/
			//s	hotel.setPic(img);

				HotelServicesDelegate.doAddHotel(hotel);
			}
		});

		JLabel lblPriceForSingle = new JLabel("Price for Single Room");

		JLabel lblPriceForSuite = new JLabel("Price for Suite");

		priceSingle = new JTextField();
		priceSingle.setColumns(10);

		Pricedouble = new JTextField();
		Pricedouble.setColumns(10);

		JButton btnNewButton_1 = new JButton("Upload picture");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				textField.setText(filename);
			}
		});

		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);

		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblPriceForSingle)
														.addComponent(lblState)
														.addComponent(
																lblPriceForSuite)
														.addComponent(
																lblNewLabel_2)
														.addComponent(
																lblNewLabel_1)
														.addComponent(
																lblNewLabel)
														.addComponent(
																lblNewLabel_3))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				name,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.LEADING)
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addComponent(
																								address,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addContainerGap(
																								246,
																								Short.MAX_VALUE))
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addComponent(
																								description,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addContainerGap())
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addComponent(
																								textField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addGap(18)
																						.addComponent(
																								btnNewButton_1)
																						.addGap(139))
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addComponent(
																								Pricedouble,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addContainerGap(
																								246,
																								Short.MAX_VALUE))
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addGroup(
																								gl_contentPane
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												comboBox,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												comboBox_1,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGap(134)
																						.addComponent(
																								btnNewButton)
																						.addContainerGap())
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addComponent(
																								priceSingle,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addContainerGap(
																								246,
																								Short.MAX_VALUE))))));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(27)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																name,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																address,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_1))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblNewLabel_2)
														.addComponent(
																description,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																comboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_3))
										.addGap(3)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																comboBox_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblState))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblPriceForSingle)
														.addComponent(
																priceSingle,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblPriceForSuite)
														.addComponent(
																Pricedouble,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnNewButton_1))
										.addPreferredGap(
												ComponentPlacement.RELATED, 10,
												Short.MAX_VALUE)
										.addComponent(btnNewButton)
										.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
