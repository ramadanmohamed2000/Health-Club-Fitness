package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Goals_Member extends JPanel {

	/**
	 * Create the panel.
	 */
	public Goals_Member() {
		setLayout(null);
		
		JLabel lblAddGoals = new JLabel("Add Goals");
		lblAddGoals.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblAddGoals.setBounds(38, 40, 296, 48);
		add(lblAddGoals);
		
		JLabel lblHealthMetrics = new JLabel("Health Metrics");
		lblHealthMetrics.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblHealthMetrics.setBounds(38, 113, 138, 48);
		add(lblHealthMetrics);
		
		JComboBox cbHM = new JComboBox();
		cbHM.setModel(new DefaultComboBoxModel(new String[] {"Blood Pressure", "Heart Rate", "Cholesterol Level", "Blood Sugar Level", "Body Weight", "Body Fat Percentage", "Resting Metabolic Rate", "Hydration Level"}));
		cbHM.setSelectedIndex(-1);
		cbHM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbHM.setBounds(210, 123, 202, 33);
		add(cbHM);
		
		JLabel lblGoal = new JLabel("Fitness Goal");
		lblGoal.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblGoal.setBounds(38, 158, 162, 48);
		add(lblGoal);
		
		JComboBox cbFG = new JComboBox();
		cbFG.setModel(new DefaultComboBoxModel(new String[] {"Weight Loss", "Muscle Gain", "Endurance Improvement", "Flexibility Enhancement", "Strength Building", "General Fitness"}));
		cbFG.setSelectedIndex(-1);
		cbFG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbFG.setBounds(210, 168, 202, 33);
		add(cbFG);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String email = Data.email;
			    String hm = cbHM.getSelectedItem().toString();
			    String fg = cbFG.getSelectedItem().toString();
			    DatabaseManager db = new DatabaseManager();
			    
			    // Constructing the update query
			    String query = "UPDATE Member SET FitnessGoals = '" + fg + "', HealthMetrics = '" + hm + "' WHERE Email = '" + email + "'";
			    
			    // Executing the update query
			    int rowsAffected = db.executeUpdate(query);

			    if (rowsAffected == 1) {
			        JOptionPane.showMessageDialog(null, "Fitness goals and health metrics updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			    } else {
			        JOptionPane.showMessageDialog(null, "Failed to update fitness goals and health metrics.", "Error", JOptionPane.ERROR_MESSAGE);
			    }

			    db.closeConnection();
			}

		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(323, 236, 89, 27);
		add(btnAdd);

	}
	public void loadData() {
		
	}
}
