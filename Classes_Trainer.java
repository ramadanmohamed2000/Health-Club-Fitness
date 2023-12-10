package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Classes_Trainer extends JPanel {
	private JTextField nameTxt;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Classes_Trainer() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(21, 83, 101, 31);
		add(lblNewLabel);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameTxt.setColumns(10);
		nameTxt.setBounds(132, 83, 271, 31);
		add(nameTxt);
		
		JLabel lblGroupFitnessClasses = new JLabel("Group Fitness Classes");
		lblGroupFitnessClasses.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGroupFitnessClasses.setBounds(21, 10, 359, 31);
		add(lblGroupFitnessClasses);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblDate.setBounds(21, 125, 102, 48);
		add(lblDate);
		
		JComboBox comboBox_date = new JComboBox();
		comboBox_date.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_date.setBounds(133, 135, 202, 33);
		
		LocalDate currentDate = LocalDate.now();

        // Create a DateTimeFormatter to format the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Create a string array to store dates of the next five days
        String[] nextFiveDays = new String[5];

        // Populate the array with the dates of the next five days
        for (int i = 0; i < 5; i++) {
            nextFiveDays[i] = currentDate.plusDays(i).format(formatter);
        }
        comboBox_date.setModel(new DefaultComboBoxModel(nextFiveDays));
		
		add(comboBox_date);
		
		JComboBox comboBox_time = new JComboBox();
		comboBox_time.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_time.setBounds(133, 184, 202, 33);
		comboBox_time.setModel(new DefaultComboBoxModel(new String[] {"09:00:00", "12:00:00", "17:00:00", "19:00:00"}));
		add(comboBox_time);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTime.setBounds(21, 183, 102, 42);
		add(lblTime);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String time = comboBox_time.getSelectedItem().toString();
			    String date = comboBox_date.getSelectedItem().toString();
			    String className = nameTxt.getText();
			    
			    String trainerID = Data.user().get("trainerid");
			    
			    String sql = "INSERT INTO GroupFitnessClass (classname, Date, Time, TrainerID) VALUES ('" + className + "', '" + date + "', '" + time + "', '" + trainerID + "')";

			    DatabaseManager db = new DatabaseManager();

			    int rowsInserted = db.executeUpdate(sql);
			    if (rowsInserted > 0) {
			        JOptionPane.showMessageDialog(null, "Class inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			    } else {
			        JOptionPane.showMessageDialog(null, "Failed to insert Class.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			    loadData();
			    db.closeConnection();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(250, 278, 89, 27);
		add(btnAdd);
		
		JLabel lblGroupFitnessClasses_1 = new JLabel("Group Fitness Classes");
		lblGroupFitnessClasses_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblGroupFitnessClasses_1.setBounds(21, 309, 395, 46);
		add(lblGroupFitnessClasses_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(21, 365, 395, 172);
		add(table);

	}

	public void loadData() {
		// TODO Auto-generated method stub
		Util.populateTable(table, Data.myClasses());
	}

}
