package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

public class Event_Member extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Event_Member() {
		setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setBounds(435, 103, 130, 37);
		add(btnRegister);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1_1_1.setBounds(209, 107, 202, 33);
		add(comboBox_1_1_1);
		
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblEventName.setBounds(47, 97, 152, 48);
		add(lblEventName);
		
		JLabel lblPersonalTrainingSessions_1_1 = new JLabel("Register Event");
		lblPersonalTrainingSessions_1_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblPersonalTrainingSessions_1_1.setBounds(47, 41, 395, 46);
		add(lblPersonalTrainingSessions_1_1);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblEvents.setBounds(47, 314, 395, 46);
		add(lblEvents);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(47, 370, 395, 172);
		add(table);

	}
	public void loadData() {
		
	}
}
