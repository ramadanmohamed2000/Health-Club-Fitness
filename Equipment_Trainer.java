package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Equipment_Trainer extends JPanel {
	private JTextField nameTxt;
	private JTable table;
	private JComboBox comboBox_status;
	private JComboBox comboBox_name;
	private JComboBox comboBox_status_1;
	
	/**
	 * Create the panel.
	 */
	public Equipment_Trainer() {
		setLayout(null);
		
		JLabel lblAddEquipment = new JLabel("Add Equipment");
		lblAddEquipment.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblAddEquipment.setBounds(25, 21, 296, 48);
		add(lblAddEquipment);
		
		JLabel lblNam = new JLabel("Name");
		lblNam.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNam.setBounds(25, 94, 102, 48);
		add(lblNam);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameTxt.setColumns(10);
		nameTxt.setBounds(137, 102, 206, 33);
		add(nameTxt);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblStatus.setBounds(25, 139, 102, 48);
		add(lblStatus);
		
		comboBox_status = new JComboBox();
		comboBox_status.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_status.setBounds(137, 149, 202, 33);
		add(comboBox_status);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipmentname = nameTxt.getText();
				String maintenancestatus = comboBox_status.getSelectedItem().toString();
				String sql = "INSERT INTO Equipment (equipmentname, maintenancestatus) " +
		                 "VALUES ('" + equipmentname + "', '" + maintenancestatus + "')";
		    DatabaseManager db = new DatabaseManager();

		    int rowsInserted = db.executeUpdate(sql);
		    if (rowsInserted > 0) {
		        JOptionPane.showMessageDialog(null, "Equipment inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		    } else {
		        JOptionPane.showMessageDialog(null, "Failed to insert equipment.", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		    loadData();
		    db.closeConnection();

			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(254, 212, 89, 27);
		add(btnAdd);
		
		JLabel lblGroupFitnessClasses_1 = new JLabel("Equipments");
		lblGroupFitnessClasses_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblGroupFitnessClasses_1.setBounds(41, 348, 395, 46);
		add(lblGroupFitnessClasses_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(41, 404, 395, 172);
		add(table);
		
		JLabel lblUpdateEquipment = new JLabel("Update Equipment");
		lblUpdateEquipment.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblUpdateEquipment.setBounds(508, 21, 296, 48);
		add(lblUpdateEquipment);
		
		JLabel lblId = new JLabel("Name");
		lblId.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblId.setBounds(508, 94, 102, 48);
		add(lblId);
		
		comboBox_name = new JComboBox();
		comboBox_name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_name.setBounds(620, 104, 202, 33);
		add(comboBox_name);
		
		comboBox_status_1 = new JComboBox();
		comboBox_status_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_status_1.setBounds(620, 149, 202, 33);
		add(comboBox_status_1);
		
		JLabel lblStatus_1 = new JLabel("Status");
		lblStatus_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblStatus_1.setBounds(508, 139, 102, 48);
		add(lblStatus_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyValue kv = (KeyValue)comboBox_name.getSelectedItem();
				String equipmentid = kv.value;
				String maintenancestatus = comboBox_status_1.getSelectedItem().toString();
				String sql = "UPDATE Equipment SET maintenancestatus = '" + maintenancestatus + "' WHERE equipmentid = " + equipmentid;
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
		btnUpdate.setBounds(705, 212, 112, 27);
		add(btnUpdate);

	}

	public void loadData() {
		// TODO Auto-generated method stub
		String query = "SELECT equipmentid, equipmentname from equipment";
		DatabaseManager db = new DatabaseManager();
		Map<String, List<String>> data = db.executeQueryAsKeyAndArray(query);
		
		List<KeyValue> arr = new ArrayList<KeyValue>();
		for(int i=0; i<data.get("equipmentname").size(); i++) {
			arr.add(new KeyValue(data.get("equipmentname").get(i), data.get("equipmentid").get(i)));
		}
		comboBox_name.setModel(new DefaultComboBoxModel(arr.toArray()));
		String[] maintenanceStatuses = {
			    "Functional",
			    "Needs Repair",
			    "Under Maintenance",
			    "Out of Order"
			};
		comboBox_status.setModel(new DefaultComboBoxModel(maintenanceStatuses));
		comboBox_status_1.setModel(new DefaultComboBoxModel(maintenanceStatuses));
		
		db.closeConnection();
		Util.populateTable(table, Data.equipments());
	}

}
