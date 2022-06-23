package com.brainmentors.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.brainmentors.chatapp.dao.UserDAO;
import com.brainmentors.chatapp.dto.UserDTO;

public class UserScreen extends JFrame {

	private JFrame frame;
	private JTextField userid;
	private JPasswordField password;
	private JTextField email_txt;
	private JTextField phone_txt;
	private JTextField city_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		UserScreen userScreen=new UserScreen();
	}
	
	private void register() throws SQLException, NoSuchAlgorithmException {
		String uid=userid.getText();
		char [] passwrd=password.getPassword();
		String ucity=city_txt.getText();
		String uemail=email_txt.getText();
		String uphone=phone_txt.getText();
		//UserDAO userDao=new UserDAO();
		UserDAO userDao=new UserDAO();
		UserDTO userdto=new UserDTO(uid,passwrd,ucity,uemail,uphone);
		int result=userDao.add(userdto);
		if(result>0) {
			//System.out.println("Record Added Successfully");
			JOptionPane.showMessageDialog(this,"Registration Successfull");
		}
		else
			//System.out.println("Record Not Added Successfully");
			JOptionPane.showMessageDialog(this,"Registration Not Successfull");
		
		
		
	}
	private void clearFields() {
		userid.setText("");
		password.setText("");
		email_txt.setText("");
		phone_txt.setText("");
		city_txt.setText("");
		
	}
//	private void doLogin()throws SQLException, NoSuchAlgorithmException {
//		String uid=userid.getText();
//		char [] passwrd=password.getPassword();
//		String ucity=city_txt.getText();
//		String uemail=email_txt.getText();
//		String uphone=phone_txt.getText();
//		
//		UserDAO userDao=new UserDAO();
//		UserDTO userdto=new UserDTO(uid,passwrd,ucity,uemail,uphone);
//		String message="";
//		if(userDao.isLogin(userdto)) {
//			message="Welcome Back " + uid;
//			JOptionPane.showMessageDialog(this,message);
//			setVisible(true);
//			dispose();
//			Dashboard dashboard=new Dashboard(message);
//			dashboard.setVisible(true);
//		}
//		else
//		{
//			message="Invalid userID or Password";
//			JOptionPane.showMessageDialog(this,message);
//		}
//		
//		
//	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().setBackground(Color.PINK);
		setBounds(100, 100, 523, 390);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);//So that screen will always display in the center.
		
		JLabel lblNewLabel = new JLabel("REGISTRATION");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(135, 11, 243, 43);
		getContentPane().add(lblNewLabel);
		
		JLabel useridtxt = new JLabel("USER_ID");
		useridtxt.setForeground(Color.DARK_GRAY);
		useridtxt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		useridtxt.setBounds(87, 49, 101, 43);
		getContentPane().add(useridtxt);
		
		JLabel pwdlbl = new JLabel("PASSWORD");
		pwdlbl.setForeground(Color.DARK_GRAY);
		pwdlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		pwdlbl.setBounds(87, 103, 101, 28);
		getContentPane().add(pwdlbl);
		
		userid = new JTextField();
		userid.setForeground(Color.BLACK);
		userid.setBounds(198, 62, 184, 20);
		getContentPane().add(userid);
		userid.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginScreen screen=new LoginScreen();
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(87, 271, 113, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGISTER");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					register();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();//Tracking all the exception in stack
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(225, 271, 125, 23);
		getContentPane().add(btnNewButton_1);
		
		password = new JPasswordField();
		password.setBounds(198, 109, 184, 20);
		getContentPane().add(password);
		
		JLabel phone_label = new JLabel("PHONE_NO");
		phone_label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		phone_label.setBounds(85, 183, 103, 20);
		getContentPane().add(phone_label);
		
		email_txt = new JTextField();
		email_txt.setBounds(198, 218, 184, 20);
		getContentPane().add(email_txt);
		email_txt.setColumns(10);
		
		JLabel citylabel = new JLabel("CITY");
		citylabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		citylabel.setBounds(87, 142, 101, 20);
		getContentPane().add(citylabel);
		
		JLabel email_label = new JLabel("EMAIL");
		email_label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		email_label.setBounds(87, 216, 101, 20);
		getContentPane().add(email_label);
		
		phone_txt = new JTextField();
		phone_txt.setColumns(10);
		phone_txt.setBounds(198, 185, 184, 20);
		getContentPane().add(phone_txt);
		
		city_txt = new JTextField();
		city_txt.setColumns(10);
		city_txt.setBounds(198, 144, 184, 20);
		getContentPane().add(city_txt);
		
		JButton clear_button = new JButton("RESET");
		clear_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		clear_button.setBackground(Color.PINK);
		clear_button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		clear_button.setBounds(364, 272, 89, 23);
		getContentPane().add(clear_button);
		setVisible(true);
		//initialize();
	}
}
