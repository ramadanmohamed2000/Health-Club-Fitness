package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
public class Profile_Member extends JPanel {
	private JTextField nameTxt;
	private JTextField emailTxt;
	private JTextField phoneTxt;
	private JTextField addressTxt;
	private JRadioButton rdbtnGold;
	private JRadioButton rdbtnSilver;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public Profile_Member() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(107, 48, 101, 31);
		add(lblNewLabel);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nameTxt.setColumns(10);
		nameTxt.setBounds(318, 48, 271, 31);
		add(nameTxt);
		
		emailTxt = new JTextField();
		emailTxt.setEnabled(false);
		emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		emailTxt.setColumns(10);
		emailTxt.setBounds(318, 108, 271, 31);
		add(emailTxt);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmail.setBounds(107, 108, 101, 31);
		add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone#");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPhone.setBounds(107, 179, 101, 31);
		add(lblPhone);
		
		phoneTxt = new JTextField();
		phoneTxt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(318, 179, 271, 31);
		add(phoneTxt);
		
		addressTxt = new JTextField();
		addressTxt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		addressTxt.setColumns(10);
		addressTxt.setBounds(318, 256, 271, 31);
		add(addressTxt);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddress.setBounds(107, 256, 101, 31);
		add(lblAddress);
		
		JLabel lblMembershipType = new JLabel("Membership Type");
		lblMembershipType.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMembershipType.setBounds(107, 331, 202, 31);
		add(lblMembershipType);
		
		rdbtnSilver = new JRadioButton("Silver");
		buttonGroup.add(rdbtnSilver);
		rdbtnSilver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnSilver.setBounds(318, 336, 103, 21);
		add(rdbtnSilver);
		
		rdbtnGold = new JRadioButton("Gold");
		buttonGroup.add(rdbtnGold);
		rdbtnGold.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnGold.setBounds(446, 336, 103, 21);
		add(rdbtnGold);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTxt.getText();
				String address = addressTxt.getText();
				String phone = phoneTxt.getText();
				String email = emailTxt.getText();
				String membershiptype = "";
				DatabaseManager db = new DatabaseManager();
				if(rdbtnGold.isSelected())
					membershiptype = "Gold";
				else
					membershiptype = "silver";
				String query = "UPDATE Member SET Name = '" + name + "', Address = '" + address +
	                       "', PhoneNumber = '" + phone + "', MembershipType = '" + membershiptype +
	                       "' WHERE Email = '" + email + "'";
				int rowsAffected = db.executeUpdate(query);
				if (rowsAffected == 1) {
			        JOptionPane.showMessageDialog(null, "Member information updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			    } else {
			        JOptionPane.showMessageDialog(null, "Failed to update member information.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
				db.closeConnection();
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnOK.setBounds(679, 411, 101, 31);
		add(btnOK);
		
		
		
	}
	public void loadData() {
		Map<String, String> user = Data.user();
		nameTxt.setText(user.get("name"));
		addressTxt.setText(user.get("address"));
		phoneTxt.setText(user.get("phonenumber"));
		emailTxt.setText(user.get("email"));
		String membershipType = user.get("membershiptype");
		System.out.println("Type = "+ membershipType);
		if(membershipType.equalsIgnoreCase("gold"))
			rdbtnGold.setSelected(true);
		else
			rdbtnSilver.setSelected(true);
	}

}
