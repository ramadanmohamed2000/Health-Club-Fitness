package HealthAndFitnessClub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile_Trainer extends JPanel {
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JRadioButton rdbtnSC;
	private JRadioButton rdbtnWL;
	private JRadioButton rdbtnSST;
	private JLabel lblSpecilization;
	/**
	 * Create the panel.
	 */
	public Profile_Trainer() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(36, 32, 101, 31);
		add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtName.setColumns(10);
		txtName.setBounds(247, 32, 271, 31);
		add(txtName);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtEmail.setColumns(10);
		txtEmail.setBounds(247, 92, 271, 31);
		add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmail.setBounds(36, 92, 101, 31);
		add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone#");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPhone.setBounds(36, 163, 101, 31);
		add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPhone.setColumns(10);
		txtPhone.setBounds(247, 163, 271, 31);
		add(txtPhone);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				
				String phone = txtPhone.getText();
				String email = txtEmail.getText();
				String membershiptype = "";
				DatabaseManager db = new DatabaseManager();
				JRadioButton cb = null;
				if(rdbtnSC.isSelected())
					cb = rdbtnSC;
				else if(rdbtnWL.isSelected())
					cb = rdbtnWL;
				else
					cb = rdbtnSST;
				String query = "";
				if(Data.role.equalsIgnoreCase("trainer"))
				query = "UPDATE Trainer SET Name = '" + name +
	                       "', PhoneNumber = '" + phone + "', Specialization = '" + cb.getText() +
	                       "' WHERE Email = '" + email + "'";
				else
					query = "UPDATE Admin SET Name = '" + name +
		                       "', PhoneNumber = '" + phone+
		                       "' WHERE Email = '" + email + "'";
				int rowsAffected = db.executeUpdate(query);
				if (rowsAffected == 1) {
			        JOptionPane.showMessageDialog(null, "Information updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			    } else {
			        JOptionPane.showMessageDialog(null, "Failed to update information.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
				db.closeConnection();
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnOK.setBounds(608, 395, 101, 31);
		add(btnOK);
		
		lblSpecilization = new JLabel("Specilization");
		lblSpecilization.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblSpecilization.setBounds(36, 312, 128, 31);
		add(lblSpecilization);
		
		rdbtnSC = new JRadioButton("Strength and Conditioning");
		buttonGroup.add(rdbtnSC);
		rdbtnSC.setFont(new Font("Dialog", Font.PLAIN, 20));
		rdbtnSC.setBounds(247, 317, 259, 21);
		add(rdbtnSC);
		
		rdbtnWL = new JRadioButton("Weight Loss");
		buttonGroup.add(rdbtnWL);
		rdbtnWL.setFont(new Font("Dialog", Font.PLAIN, 20));
		rdbtnWL.setBounds(503, 317, 157, 21);
		add(rdbtnWL);
		
		rdbtnSST = new JRadioButton("Sports-Specific Training");
		buttonGroup.add(rdbtnSST);
		rdbtnSST.setFont(new Font("Dialog", Font.PLAIN, 20));
		rdbtnSST.setBounds(658, 317, 243, 21);
		add(rdbtnSST);

	}

	public void loadData() {
		// TODO Auto-generated method stub
		Map<String, String> user = Data.user();
		txtName.setText(user.get("name"));
		txtEmail.setText(user.get("email"));
		txtPhone.setText(user.get("phonenumber"));
		if(Data.role.equalsIgnoreCase("trainer")) {
			String specialization = user.get("specialization");
			if(rdbtnSC.getText().equalsIgnoreCase(specialization)) {
				rdbtnSC.setSelected(true);
			}
			else if(rdbtnWL.getText().equalsIgnoreCase(specialization)) {
				rdbtnWL.setSelected(true);
			}
			else {
				rdbtnSST.setSelected(true);
			}
		}
		else {
			this.remove(lblSpecilization);
			this.remove(rdbtnSC);
			this.remove(rdbtnSST);
			this.remove(rdbtnWL);
		}
	}
}
