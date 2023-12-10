package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class Classes_Member extends JPanel {
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public Classes_Member() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(723, 24, 0, 0);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(table);
		
		JLabel lblClassName = new JLabel("Class Name");
		lblClassName.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblClassName.setBounds(36, 88, 152, 48);
		add(lblClassName);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1_1_1.setBounds(198, 98, 202, 33);
		add(comboBox_1_1_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setBounds(424, 94, 130, 37);
		add(btnRegister);
		
		JLabel lblGroupFitnessClasses = new JLabel("Group Fitness Classes");
		lblGroupFitnessClasses.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblGroupFitnessClasses.setBounds(36, 305, 395, 46);
		add(lblGroupFitnessClasses);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_1.setBounds(36, 361, 395, 172);
		add(table_1);
		
		JLabel lblPersonalTrainingSessions_1_1 = new JLabel("Register Class");
		lblPersonalTrainingSessions_1_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblPersonalTrainingSessions_1_1.setBounds(36, 32, 395, 46);
		add(lblPersonalTrainingSessions_1_1);

	}
	public void loadData() {
		
	}

}
