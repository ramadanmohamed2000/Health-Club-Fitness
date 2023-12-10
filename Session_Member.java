package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Session_Member extends JPanel {
	private JTable table;
	
	private JComboBox comboBox_time;
	private JComboBox comboBox_date;
	private JComboBox comboBox_trainer;
	/**
	 * Create the panel.
	 */
	public Session_Member() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Sessions");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblNewLabel.setBounds(40, 35, 296, 48);
		add(lblNewLabel);
		
		JLabel lblTrainer = new JLabel("Trainer");
		lblTrainer.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTrainer.setBounds(40, 108, 102, 48);
		add(lblTrainer);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblDate.setBounds(40, 153, 102, 48);
		add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTime.setBounds(40, 211, 102, 42);
		add(lblTime);
		
		comboBox_time = new JComboBox();
		comboBox_time.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_time.setModel(new DefaultComboBoxModel(new String[] {"09:00:00", "12:00:00", "17:00:00", "19:00:00"}));
		comboBox_time.setBounds(152, 212, 202, 33);
		add(comboBox_time);
		
		
		LocalDate currentDate = LocalDate.now();

        // Create a DateTimeFormatter to format the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Create a string array to store dates of the next five days
        String[] nextFiveDays = new String[5];

        // Populate the array with the dates of the next five days
        for (int i = 0; i < 5; i++) {
            nextFiveDays[i] = currentDate.plusDays(i).format(formatter);
        }
		
		
		comboBox_date = new JComboBox();
		
		comboBox_date.setModel(new DefaultComboBoxModel(nextFiveDays));
		comboBox_date.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_date.setBounds(152, 163, 202, 33);
		add(comboBox_date);
		
		JLabel lblPersonalTrainingSessions = new JLabel("Personal Training Sessions");
		lblPersonalTrainingSessions.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblPersonalTrainingSessions.setBounds(40, 325, 395, 46);
		add(lblPersonalTrainingSessions);
		
		table = new JTable();
		table.setEnabled(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(40, 381, 833, 172);
		add(table);
		
		
		
		comboBox_trainer = new JComboBox();
		comboBox_trainer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_trainer.setBounds(152, 120, 202, 33);
		add(comboBox_trainer);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String time = comboBox_time.getSelectedItem().toString();
			    String date = comboBox_date.getSelectedItem().toString();
			    KeyValue kv = (KeyValue) comboBox_trainer.getSelectedItem();
			    String trainerID = kv.value;
			    String memberID = Data.user().get("memberid");
			    String sql = "INSERT INTO PersonalTrainingSession (TrainerID, MemberID, Date, Time) " +
			                 "VALUES (" + trainerID + ", " + memberID + ", '" + date + "', '" + time + "')";
			    DatabaseManager db = new DatabaseManager();

			    int rowsInserted = db.executeUpdate(sql);
			    if (rowsInserted > 0) {
			        JOptionPane.showMessageDialog(null, "Personal Training Session inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			    } else {
			        JOptionPane.showMessageDialog(null, "Failed to insert Personal Training Session.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			    loadData();
			    db.closeConnection();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(269, 294, 89, 27);
		add(btnNewButton);

	}
	public void loadData() {
		String query = "SELECT trainerid, name from trainer";
		DatabaseManager db = new DatabaseManager();
		Map<String, List<String>> data = db.executeQueryAsKeyAndArray(query);
		
		List<KeyValue> arr = new ArrayList<KeyValue>();
		for(int i=0; i<data.get("name").size(); i++) {
			arr.add(new KeyValue(data.get("name").get(i), data.get("trainerid").get(i)));
		}
		comboBox_trainer.setModel(new DefaultComboBoxModel(arr.toArray()));
		db.closeConnection();
		Util.populateTable(table, Data.session());
	}
}
