package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Members_Trainer extends JPanel {
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtPoints;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBox_search;
	/**
	 * Create the panel.
	 */
	public Members_Trainer() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(42, 130, 101, 31);
		add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtName.setColumns(10);
		txtName.setBounds(253, 130, 271, 31);
		add(txtName);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtEmail.setColumns(10);
		txtEmail.setBounds(253, 190, 271, 31);
		add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmail.setBounds(42, 190, 101, 31);
		add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone#");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPhone.setBounds(42, 261, 101, 31);
		add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setEnabled(false);
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPhone.setColumns(10);
		txtPhone.setBounds(253, 261, 271, 31);
		add(txtPhone);
		
		txtAddress = new JTextField();
		txtAddress.setEnabled(false);
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtAddress.setColumns(10);
		txtAddress.setBounds(253, 338, 271, 31);
		add(txtAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddress.setBounds(42, 338, 101, 31);
		add(lblAddress);
		
		JLabel lblMembershipType = new JLabel("Membership Type");
		lblMembershipType.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMembershipType.setBounds(42, 413, 202, 31);
		add(lblMembershipType);
		
		JRadioButton rdbtnSilver = new JRadioButton("Silver");
		buttonGroup.add(rdbtnSilver);
		rdbtnSilver.setEnabled(false);
		rdbtnSilver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnSilver.setBounds(253, 418, 103, 21);
		add(rdbtnSilver);
		
		JRadioButton rdbtnGold = new JRadioButton("Gold");
		buttonGroup.add(rdbtnGold);
		rdbtnGold.setEnabled(false);
		rdbtnGold.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnGold.setBounds(381, 418, 103, 21);
		add(rdbtnGold);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyValue kv =  (KeyValue)comboBox_search.getSelectedItem();
				String memberid = kv.value;
				DatabaseManager db = new DatabaseManager();
				String sql = "SELECT * FROM member where memberid="+memberid;
				Map<String, String> user = db.executeQuery(sql);
				txtName.setText(user.get("name"));
				txtAddress.setText(user.get("address"));
				txtPhone.setText(user.get("phonenumber"));
				txtEmail.setText(user.get("email"));
				String membershipType = user.get("membershiptype");
				
				if(membershipType.equalsIgnoreCase("gold"))
					rdbtnGold.setSelected(true);
				else
					rdbtnSilver.setSelected(true);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSearch.setBounds(549, 26, 131, 31);
		add(btnSearch);
		
		JLabel lblSearch = new JLabel("Search ID");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSearch.setBounds(42, 26, 160, 31);
		add(lblSearch);
		
		JLabel lblAddPoint = new JLabel("Points");
		lblAddPoint.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddPoint.setBounds(42, 503, 131, 31);
		add(lblAddPoint);
		
		txtPoints = new JTextField();
		txtPoints.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPoints.setColumns(10);
		txtPoints.setBounds(253, 503, 94, 31);
		add(txtPoints);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pointsearned = txtPoints.getText();
				KeyValue kv =  (KeyValue)comboBox_search.getSelectedItem();
				String memberid = kv.value;
				String sql = "INSERT INTO loyaltyprogram (memberid, pointsearned) VALUES (" + memberid + ", " + pointsearned+")";

			    DatabaseManager db = new DatabaseManager();

			    int rowsInserted = db.executeUpdate(sql);
			    if (rowsInserted > 0) {
			        JOptionPane.showMessageDialog(null, "points inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			    } else {
			        JOptionPane.showMessageDialog(null, "Failed to insert points.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			    loadData();
			    db.closeConnection();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAdd.setBounds(393, 503, 131, 31);
		add(btnAdd);
		
		comboBox_search = new JComboBox();
		comboBox_search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_search.setBounds(253, 24, 271, 33);
		add(comboBox_search);

	}

	public void loadData() {
		// TODO Auto-generated method stub
		String query = "SELECT memberid, name from member";
		DatabaseManager db = new DatabaseManager();
		Map<String, List<String>> data = db.executeQueryAsKeyAndArray(query);
		
		List<KeyValue> arr = new ArrayList<KeyValue>();
		for(int i=0; i<data.get("name").size(); i++) {
			arr.add(new KeyValue(data.get("name").get(i), data.get("memberid").get(i)));
		}
		comboBox_search.setModel(new DefaultComboBoxModel(arr.toArray()));
		
		db.closeConnection();
	}
}
