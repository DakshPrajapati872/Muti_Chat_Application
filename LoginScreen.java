package com.brainmentors.chatapp.views;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.brainmentors.chatapp.dao.UserDAO;
import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.network.Server;
import com.brainmentors.chatapp.utils.UserInfo;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class LoginScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	private JTextField user_txt;
	private JPasswordField pass_txt;
	private void doLogin()throws SQLException, NoSuchAlgorithmException, IOException {
		String uid=user_txt.getText();
		char [] passwrd=pass_txt.getPassword();
		
		
		UserDAO userDao=new UserDAO();
		UserDTO userdto=new UserDTO(uid,passwrd);
		String message="";
		if(userDao.isLogin(userdto)) {
			
			message="Welcome Back " + uid;
			UserInfo.USER_NAME=uid;
			System.out.println(UserInfo.USER_NAME);
			JOptionPane.showMessageDialog(this,message);
			setVisible(true);
			dispose();
			Dashboard dashboard=new Dashboard(message);
			dashboard.setVisible(true);
			
			
		}
		else
		{
			message="Invalid userID or Password";
			JOptionPane.showMessageDialog(this,message);
			LoginScreen dashboard=new LoginScreen();
			dashboard.setVisible(true);
		}
		
		
	}
	private void clearFields() {
		user_txt.setText("");
		pass_txt.setText("");
	}

	public LoginScreen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 331);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 5, 424, 29);
		contentPane.add(lblNewLabel);
		
		JLabel user_label = new JLabel("USER_ID");
		user_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		user_label.setBounds(65, 66, 104, 14);
		contentPane.add(user_label);
		
		JLabel pass_label = new JLabel("PASSWORD");
		pass_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pass_label.setBounds(51, 99, 112, 14);
		contentPane.add(pass_label);
		
		user_txt = new JTextField();
		user_txt.setBounds(165, 63, 200, 20);
		contentPane.add(user_txt);
		user_txt.setColumns(10);
		
		JButton Login_button = new JButton("Login");
		Login_button.setBackground(Color.PINK);
		Login_button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						doLogin();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (NoSuchAlgorithmException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Login_button.setBounds(65, 153, 118, 23);
		contentPane.add(Login_button);
		
		JButton change_password_button = new JButton("Forgot Password");
		change_password_button.setBackground(Color.PINK);
		change_password_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Change_Password_Screen obj=new Change_Password_Screen();
				
			}
		});
		change_password_button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		change_password_button.setBounds(211, 153, 154, 23);
		contentPane.add(change_password_button);
		
		pass_txt = new JPasswordField();
		pass_txt.setBounds(165, 96, 200, 20);
		contentPane.add(pass_txt);
		
		JButton clear_button = new JButton("Reset");
		clear_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		clear_button.setBackground(Color.PINK);
		clear_button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		clear_button.setBounds(375, 153, 89, 23);
		contentPane.add(clear_button);
		setVisible(true);
	}
}
