package HealthAndFitnessClub;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField nameTxt;
	private JTextField emailTxt;
	private JTextField phoneTxt;
	private JTextField addressTxt;
	private JTextField passwordTxt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1017, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(89, 79, 101, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmail.setBounds(89, 139, 101, 31);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone#");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPhone.setBounds(89, 210, 101, 31);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddress.setBounds(89, 287, 101, 31);
		contentPane.add(lblAddress);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPassword.setBounds(89, 545, 128, 31);
		contentPane.add(lblPassword);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRole.setBounds(88, 349, 128, 31);
		contentPane.add(lblRole);
		
		JRadioButton memberRB = new JRadioButton("Member");
		memberRB.setSelected(true);
		buttonGroup.add(memberRB);
		memberRB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		memberRB.setBounds(89, 393, 103, 21);
		contentPane.add(memberRB);
		
		JRadioButton trainerRB = new JRadioButton("Trainer");
		buttonGroup.add(trainerRB);
		trainerRB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		trainerRB.setBounds(87, 464, 103, 21);
		contentPane.add(trainerRB);
		
		JLabel lblMembershipType = new JLabel("Membership Type");
		lblMembershipType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMembershipType.setBounds(132, 420, 128, 31);
		contentPane.add(lblMembershipType);
		
		JRadioButton goldRB = new JRadioButton("Gold");
		goldRB.setSelected(true);
		buttonGroup_1.add(goldRB);
		goldRB.setBounds(284, 427, 103, 21);
		contentPane.add(goldRB);
		
		JRadioButton silverRB = new JRadioButton("Silver");
		buttonGroup_1.add(silverRB);
		silverRB.setBounds(396, 427, 103, 21);
		contentPane.add(silverRB);
		
		JLabel lblSpecilization = new JLabel("Specilization");
		lblSpecilization.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpecilization.setBounds(132, 491, 128, 31);
		contentPane.add(lblSpecilization);
		
		JRadioButton strengthRB = new JRadioButton("Strength and Conditioning");
		buttonGroup_2.add(strengthRB);
		strengthRB.setBounds(284, 491, 166, 21);
		contentPane.add(strengthRB);
		
		JRadioButton weightRB = new JRadioButton("Weight Loss");
		weightRB.setSelected(true);
		buttonGroup_2.add(weightRB);
		weightRB.setBounds(452, 491, 103, 21);
		contentPane.add(weightRB);
		
		JRadioButton sportsRB = new JRadioButton("Sports-Specific Training");
		buttonGroup_2.add(sportsRB);
		sportsRB.setBounds(567, 491, 160, 21);
		contentPane.add(sportsRB);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nameTxt.setBounds(284, 79, 271, 31);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		emailTxt.setColumns(10);
		emailTxt.setBounds(284, 139, 271, 31);
		contentPane.add(emailTxt);
		
		phoneTxt = new JTextField();
		phoneTxt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(284, 210, 271, 31);
		contentPane.add(phoneTxt);
		
		addressTxt = new JTextField();
		addressTxt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		addressTxt.setColumns(10);
		addressTxt.setBounds(284, 287, 271, 31);
		contentPane.add(addressTxt);
		
		passwordTxt = new JTextField();
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(284, 545, 271, 31);
		contentPane.add(passwordTxt);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.setVisible(true);
				close();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(749, 601, 114, 31);
		contentPane.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseManager db = new DatabaseManager();
				String name = nameTxt.getText();
				String email = emailTxt.getText();
				String phone = phoneTxt.getText();
				String address = addressTxt.getText();
				String password = passwordTxt.getText();
				
				if (memberRB.isSelected()) {
			        String membershipType = "";
			        if (goldRB.isSelected()) {
			            membershipType = "Gold";
			        } else if (silverRB.isSelected()) {
			            membershipType = "Silver";
			        }
			        // Inserting data into the Member table
			        String insertQuery = "INSERT INTO Member(Name, Email, PhoneNumber, Address, Password, MembershipType) "
			                + "VALUES('" + name + "', '" + email + "', '" + phone + "', '" + address + "', '" + password + "', '" + membershipType + "')";
			        db.executeUpdate(insertQuery);
			    }
				else if(trainerRB.isSelected()){
					String specialization = "";
					if(strengthRB.isSelected()) {
						specialization = "Strength and Conditioning";
					} else if(weightRB.isSelected()) {
						specialization = "Weight Loss";
					}
					else if(sportsRB.isSelected()) {
						specialization = "Sports-Specific Training";
					}
					String insertQuery = "INSERT INTO Trainer(Name, Email, PhoneNumber, Password, Specialization) "
			                + "VALUES('" + name + "', '" + email + "', '" + phone + "', '" + password + "', '" + specialization + "')";
					db.executeUpdate(insertQuery);
				}
				db.closeConnection();
				Main.frame.setVisible(true);
				close();
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSubmit.setBounds(873, 601, 114, 31);
		contentPane.add(btnSubmit);
	}
	public void close() {
		this.setVisible(false);
	}
}
