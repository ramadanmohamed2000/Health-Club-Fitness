package HealthAndFitnessClub;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField emailTxt;
	private JTextField passwordTxt;
	static Main frame;
	Dashboard_Member dashboard_member;
	Dashboard_Trainer dashboard_trainer;
	JFrame signup_page;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Main();
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
	public Main() {
		dashboard_member = new Dashboard_Member();
		dashboard_trainer = new Dashboard_Trainer();
		signup_page = new SignUp();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(165, 180, 127, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblPassword.setBounds(165, 256, 127, 44);
		contentPane.add(lblPassword);
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 27));
		emailTxt.setBounds(329, 180, 303, 44);
		contentPane.add(emailTxt);
		emailTxt.setColumns(10);
		
		passwordTxt = new JTextField();
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 27));
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(329, 256, 303, 44);
		contentPane.add(passwordTxt);
		
		
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup_page.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnSignUp.setBounds(329, 385, 127, 44);
		contentPane.add(btnSignUp);
		
		JRadioButton adminRB = new JRadioButton("Admin");
		buttonGroup.add(adminRB);
		adminRB.setFont(new Font("Tahoma", Font.PLAIN, 25));
		adminRB.setBounds(317, 329, 109, 37);
		contentPane.add(adminRB);
		
		JRadioButton rdbtnTrainer = new JRadioButton("Trainer");
		buttonGroup.add(rdbtnTrainer);
		rdbtnTrainer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnTrainer.setBounds(451, 329, 147, 37);
		contentPane.add(rdbtnTrainer);
		
		JRadioButton rdbtnMember = new JRadioButton("Member");
		rdbtnMember.setSelected(true);
		buttonGroup.add(rdbtnMember);
		rdbtnMember.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnMember.setBounds(600, 329, 160, 37);
		contentPane.add(rdbtnMember);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblRole.setBounds(165, 322, 127, 44);
		contentPane.add(lblRole);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = emailTxt.getText();
				String password = passwordTxt.getText();
				String table_name = "";
				DatabaseManager db = new DatabaseManager();
				if(adminRB.isSelected()) {
					table_name = "admin";
				}
				else if(rdbtnMember.isSelected()) {
					table_name = "member";
				}
				else if(rdbtnTrainer.isSelected()) {
					table_name = "trainer";
				}
				boolean found = db.isLoginExist(table_name, email, password);
				if(found) {
					Data.role = table_name;
					Data.email = email;
					if(rdbtnMember.isSelected()) {
						
						dashboard_member.setVisible(true);
						dashboard_member.loadData();
						frame.setVisible(false);
					}
					else{
						dashboard_trainer.setVisible(true);
						dashboard_trainer.loadData();
						frame.setVisible(false);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Login failed! Invalid email or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				db.closeConnection();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNewButton.setBounds(505, 385, 127, 44);
		contentPane.add(btnNewButton);
	}
}
