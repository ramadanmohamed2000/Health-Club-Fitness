package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sessions_Trainer extends JPanel {
	private JTextField txtNote;
	private JTable table;
	private JComboBox comboBox_session;

	/**
	 * Create the panel.
	 */
	public Sessions_Trainer() {
		setLayout(null);
		
		JLabel lblPersonalTrainingSessions_1_1 = new JLabel("Personal Training Sessions");
		lblPersonalTrainingSessions_1_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblPersonalTrainingSessions_1_1.setBounds(10, 10, 395, 46);
		add(lblPersonalTrainingSessions_1_1);
		
		JLabel lblDate = new JLabel("Session");
		lblDate.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblDate.setBounds(10, 66, 79, 48);
		add(lblDate);
		
		comboBox_session = new JComboBox();
		comboBox_session.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_session.setBounds(99, 76, 648, 33);
		add(comboBox_session);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNote.setBounds(10, 143, 79, 37);
		add(lblNote);
		
		txtNote = new JTextField();
		txtNote.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNote.setBounds(99, 151, 646, 29);
		add(txtNote);
		txtNote.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyValue kv = (KeyValue)comboBox_session.getSelectedItem();
				String sessionid = kv.value;
				String note = txtNote.getText();
				String sql = "UPDATE PersonalTrainingSession SET notes = '" + note + "' WHERE sessionid = " + sessionid;
				DatabaseManager db = new DatabaseManager();

			    int rowsInserted = db.executeUpdate(sql);
			    if (rowsInserted > 0) {
			        JOptionPane.showMessageDialog(null, "Equipment update successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			    } else {
			        JOptionPane.showMessageDialog(null, "Failed to update equipment.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			    loadData();
			    db.closeConnection();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(617, 194, 130, 37);
		add(btnUpdate);
		
		JLabel lblSessions = new JLabel("Sessions");
		lblSessions.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblSessions.setBounds(10, 301, 395, 46);
		add(lblSessions);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(10, 357, 737, 172);
		add(table);

	}

	public void loadData() {
		// TODO Auto-generated method stub
		
		
		Map<String, List<String>> data = Data.sessionTrainerId();
		Util.populateTable(table, Data.sessionTrainer());
		List<KeyValue> arr = new ArrayList<KeyValue>();
		for(int i=0; i<data.get("name").size(); i++) {
			String name = data.get("name").get(i);
			String date = data.get("date").get(i);
			String time = data.get("time").get(i);
			arr.add(new KeyValue(name+", "+date+" "+time, data.get("sessionid").get(i)));
		}
		comboBox_session.setModel(new DefaultComboBoxModel(arr.toArray()));
	}

}
