package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Event_Trainer extends JPanel {
	private JTextField nameTxt;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Event_Trainer() {
		setLayout(null);
		
		JLabel lblAddEvent = new JLabel("Add Event");
		lblAddEvent.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblAddEvent.setBounds(10, 10, 296, 48);
		add(lblAddEvent);
		
		JLabel lblTrainer = new JLabel("Event Name");
		lblTrainer.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTrainer.setBounds(10, 83, 195, 48);
		add(lblTrainer);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblDate.setBounds(10, 128, 102, 48);
		add(lblDate);
		
		JComboBox comboBox_date = new JComboBox();
		comboBox_date.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_date.setBounds(215, 146, 202, 33);
		
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
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTime.setBounds(10, 186, 102, 42);
		
		add(lblTime);
		
		JComboBox comboBox_time = new JComboBox();
		comboBox_time.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_time.setBounds(215, 195, 202, 33);
		comboBox_time.setModel(new DefaultComboBoxModel(new String[] {"09:00:00", "12:00:00", "17:00:00", "19:00:00"}));
		add(comboBox_time);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eventname = nameTxt.getText();
				String date = comboBox_date.getSelectedItem().toString();
				String time = comboBox_time.getSelectedItem().toString();
				
				String sql = "INSERT INTO Event (eventname, Date, Time) VALUES ('" + eventname + "', '" + date + "', '" + time + "')";

			    DatabaseManager db = new DatabaseManager();

			    int rowsInserted = db.executeUpdate(sql);
			    if (rowsInserted > 0) {
			        JOptionPane.showMessageDialog(null, "Event inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			    } else {
			        JOptionPane.showMessageDialog(null, "Failed to insert Event.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			    loadData();
			    db.closeConnection();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(239, 269, 89, 27);
		add(btnAdd);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameTxt.setBounds(215, 99, 206, 33);
		add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel lblGroupFitnessClasses_1 = new JLabel("Events");
		lblGroupFitnessClasses_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblGroupFitnessClasses_1.setBounds(26, 337, 395, 46);
		add(lblGroupFitnessClasses_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(26, 393, 395, 172);
		add(table);

	}

	public void loadData() {
		// TODO Auto-generated method stub
		Util.populateTable(table, Data.events());
		
	}

}
