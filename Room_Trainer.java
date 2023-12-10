package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Room_Trainer extends JPanel {
	private JTable table;
	
	private JComboBox comboBox_room;
	private JComboBox comboBox_availability;
	/**
	 * Create the panel.
	 */
	public Room_Trainer() {
		setLayout(null);
		
		JLabel lblPersonalTrainingSessions_1_1 = new JLabel("Rooms");
		lblPersonalTrainingSessions_1_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblPersonalTrainingSessions_1_1.setBounds(20, 20, 395, 46);
		add(lblPersonalTrainingSessions_1_1);
		
		JLabel lblRoomName = new JLabel("Room Name");
		lblRoomName.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblRoomName.setBounds(20, 76, 152, 48);
		add(lblRoomName);
		
		comboBox_room = new JComboBox();
		comboBox_room.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_room.setBounds(182, 86, 202, 33);
		add(comboBox_room);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblAvailability.setBounds(20, 150, 152, 48);
		add(lblAvailability);
		
		comboBox_availability = new JComboBox();
		comboBox_availability.setModel(new DefaultComboBoxModel(new String[] {"Available", "Not Available"}));
		comboBox_availability.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_availability.setBounds(182, 160, 202, 33);
		add(comboBox_availability);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyValue kv = (KeyValue)comboBox_room.getSelectedItem();
				String roomid = kv.value;
				String availability = comboBox_availability.getSelectedItem().toString();
				String sql = "UPDATE Room SET availability = '" + availability + "' WHERE roomid = " + roomid;
				DatabaseManager db = new DatabaseManager();

			    int rowsInserted = db.executeUpdate(sql);
			    if (rowsInserted > 0) {
			        JOptionPane.showMessageDialog(null, "Room update successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			    } else {
			        JOptionPane.showMessageDialog(null, "Failed to update Room.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			    loadData();
			    db.closeConnection();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(254, 224, 130, 37);
		add(btnUpdate);
		
		JLabel lblRooms = new JLabel("Rooms");
		lblRooms.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblRooms.setBounds(20, 316, 395, 46);
		add(lblRooms);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(20, 372, 395, 172);
		add(table);

	}

	public void loadData() {
		// TODO Auto-generated method stub
		String query = "SELECT roomid, roomname from room";
		DatabaseManager db = new DatabaseManager();
		Map<String, List<String>> data = db.executeQueryAsKeyAndArray(query);
		
		List<KeyValue> arr = new ArrayList<KeyValue>();
		for(int i=0; i<data.get("roomname").size(); i++) {
			arr.add(new KeyValue(data.get("roomname").get(i), data.get("roomid").get(i)));
		}
		comboBox_room.setModel(new DefaultComboBoxModel(arr.toArray()));
		
		db.closeConnection();
		Util.populateTable(table, Data.rooms());
	}

}
