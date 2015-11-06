package gui.flights;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ModifyFlight extends JPanel {

	/**
	 * Create the panel.
	 */
	public ModifyFlight() {
		
		JButton btnModify = new JButton("Modify");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(123)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
						.addComponent(btnModify, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
					.addGap(122))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(136)
					.addComponent(btnCancel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnModify)
					.addContainerGap(107, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
