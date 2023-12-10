package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class Home_Member extends JPanel {
	private JTable tablePTS;
	private JTable tableGFC;
	private JTable tableEvents;
	private JTable tableBills;
	private JLabel lblEarned;
	private JLabel lblRedeemed;
	private JLabel lblHealthMetrics;
	private JLabel lblFitnessGoal;
	/**
	 * Create the panel.
	 */
	public Home_Member() {
		setLayout(null);
		
		lblEarned = new JLabel("999");
		lblEarned.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblEarned.setBounds(33, 81, 84, 89);
		add(lblEarned);
		
		lblRedeemed = new JLabel("999");
		lblRedeemed.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblRedeemed.setBounds(164, 81, 84, 89);
		add(lblRedeemed);
		
		JLabel lblNewLabel_2 = new JLabel("Earned");
		lblNewLabel_2.setBounds(33, 174, 84, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Redeemed");
		lblNewLabel_2_1.setBounds(164, 174, 84, 13);
		add(lblNewLabel_2_1);
		
		tablePTS = new JTable();
		tablePTS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 String[] columnNames = {"Trainer", "Date", "Time"};
        tablePTS.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Trainer", "Date", "Time"
        	}
        ));
        tablePTS.setBounds(28, 258, 395, 172);
        add(tablePTS);
        
        JLabel lblPersonalTrainingSessions = new JLabel("Personal Training Sessions");
        lblPersonalTrainingSessions.setFont(new Font("Dialog", Font.PLAIN, 30));
        lblPersonalTrainingSessions.setBounds(28, 202, 395, 46);
        add(lblPersonalTrainingSessions);
        
        JLabel lblGroupFitnessCl = new JLabel("Goals");
        lblGroupFitnessCl.setFont(new Font("Dialog", Font.PLAIN, 30));
        lblGroupFitnessCl.setBounds(466, 20, 395, 46);
        add(lblGroupFitnessCl);
        
        tableGFC = new JTable();
        tableGFC.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Trainer", "Class Name", "Date", "Time"
        	}
        ));
        tableGFC.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tableGFC.setBounds(466, 258, 395, 172);
        add(tableGFC);
        
        JLabel lblGroupFitnessClass = new JLabel("Group Fitness Class");
        lblGroupFitnessClass.setFont(new Font("Dialog", Font.PLAIN, 30));
        lblGroupFitnessClass.setBounds(466, 202, 395, 46);
        add(lblGroupFitnessClass);
        
        JLabel lblBills = new JLabel("Bills");
        lblBills.setFont(new Font("Dialog", Font.PLAIN, 30));
        lblBills.setBounds(28, 440, 395, 46);
        add(lblBills);
        
        tableBills = new JTable();
        tableBills.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tableBills.setBounds(28, 484, 395, 87);
        add(tableBills);
        
        JLabel lblEvents = new JLabel("Events");
        lblEvents.setFont(new Font("Dialog", Font.PLAIN, 30));
        lblEvents.setBounds(466, 440, 395, 46);
        add(lblEvents);
        
        tableEvents = new JTable();
        tableEvents.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tableEvents.setBounds(466, 486, 395, 87);
        add(tableEvents);
        
        lblHealthMetrics = new JLabel("999");
        lblHealthMetrics.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblHealthMetrics.setBounds(466, 81, 172, 89);
        add(lblHealthMetrics);
        
        lblFitnessGoal = new JLabel("999");
        lblFitnessGoal.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblFitnessGoal.setBounds(662, 81, 199, 89);
        add(lblFitnessGoal);
        
        JLabel lblPoints = new JLabel("Points");
        lblPoints.setFont(new Font("Dialog", Font.PLAIN, 30));
        lblPoints.setBounds(33, 25, 395, 46);
        add(lblPoints);
        
        JLabel lblNewLabel_2_2 = new JLabel("Health Metric");
        lblNewLabel_2_2.setBounds(466, 174, 172, 13);
        add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_2_3 = new JLabel("Fitness Goal");
        lblNewLabel_2_3.setBounds(662, 174, 199, 13);
        add(lblNewLabel_2_3);

	}
	public void loadData() {
		Map<String, String> loyaltyProgram = Data.loyaltyPoints();
		lblEarned.setText(loyaltyProgram.get("pointsearned"));
		lblRedeemed.setText(loyaltyProgram.get("pointsredeemed"));
		Map<String, String> user = Data.user();
		lblHealthMetrics.setText(user.get("healthmetrics"));
		lblFitnessGoal.setText(user.get("fitnessgoals"));
		Util.populateTable(tablePTS, Data.session());
		Util.populateTable(tableGFC, Data.classes());
		Util.populateTable(tableEvents, Data.events());
		Util.populateTable(tableBills, Data.bills());
	}
}
