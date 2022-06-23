package com.brainmentors.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.chatapp.dao.UserDAO;
import com.brainmentors.chatapp.dto.UserDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Change_Password_Screen extends JFrame {

	private JPanel contentPane;
	private JTextField id_txt;
	private JTextField otp_txt;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */	private void submit()throws SQLException, NoSuchAlgorithmException {
			String uid=id_txt.getText();
			char [] passwrd=passwordField.getPassword();
			
			
			UserDAO userDao=new UserDAO();
			UserDTO userdto=new UserDTO(uid,passwrd);
			String message="";
			if(userDao.update(userdto)) {
				message="Password Updated Successfully for " + uid;
				JOptionPane.showMessageDialog(this,message);
				setVisible(true);
				dispose();
				LoginScreen dashboard=new LoginScreen();
				dashboard.setVisible(true);
			}
			
			
			
		}
	
	private void clearFields() {
		id_txt.setText("");
		otp_txt.setText("");
		passwordField.setText("");
		
	}

	/**
	 * Create the frame.
	 */
	public Change_Password_Screen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel change_label = new JLabel("FORGOT PASSWORD");
		change_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		change_label.setHorizontalAlignment(SwingConstants.CENTER);
		change_label.setBounds(5, 5, 424, 24);
		contentPane.add(change_label);
		
		JLabel uid_label = new JLabel("USER_ID");
		uid_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		uid_label.setBounds(68, 40, 80, 14);
		contentPane.add(uid_label);
		
		JLabel otp_label = new JLabel("OTP");
		otp_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		otp_label.setBounds(68, 90, 80, 14);
		contentPane.add(otp_label);
		
		id_txt = new JTextField();
		id_txt.setBackground(Color.WHITE);
		id_txt.setBounds(178, 37, 122, 20);
		contentPane.add(id_txt);
		id_txt.setColumns(10);
		
		otp_txt = new JTextField();
		otp_txt.setBounds(178, 87, 122, 20);
		contentPane.add(otp_txt);
		otp_txt.setColumns(10);
		
		JLabel new_pass_label = new JLabel("PASSWORD");
		new_pass_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		new_pass_label.setBounds(68, 65, 102, 14);
		contentPane.add(new_pass_label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 62, 122, 20);
		contentPane.add(passwordField);
		
		JButton submit_label = new JButton("SUBMIT");
		submit_label.setBackground(Color.PINK);
		submit_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		submit_label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					submit();
				} catch (NoSuchAlgorithmException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submit_label.setBounds(68, 129, 122, 23);
		contentPane.add(submit_label);
		
		JButton clear_txt = new JButton("RESET");
		clear_txt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		clear_txt.setBackground(Color.PINK);
		clear_txt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		clear_txt.setBounds(200, 130, 100, 23);
		contentPane.add(clear_txt);
		setVisible(true);
	}

}
