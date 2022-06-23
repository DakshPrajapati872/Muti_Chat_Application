package com.brainmentors.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.chatapp.network.Server;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//					Dashboard frame = new Dashboard();
//					frame.setVisible(true);
//			
//	}

	/**
	 * Create the frame.
	 */
	public Dashboard(String message) {
		String s=message;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Chat");
		mnNewMenu.setBackground(Color.PINK);
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenuItem startchat = new JMenuItem("StartChat");
		startchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					new ClientChatScreen();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(startchat);
		
		JButton logout = new JButton("Log Out");
		logout.setBackground(Color.PINK);
		logout.setForeground(Color.BLACK);
		logout.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int a = JOptionPane.showConfirmDialog(logout, "Are you sure?");
	                // JOptionPane.setRootFrame(null);
	                if (a == JOptionPane.YES_OPTION) {
	                    dispose();
	                    LoginScreen obj = new LoginScreen();
	                    obj.setVisible(true);
	                }
	                else if(a == JOptionPane.NO_OPTION) {
	                	dispose();
	                	Dashboard obj = new Dashboard(s);
	                    obj.setVisible(true);
	                	
	                	
	                }
	               
				
		}});
		menuBar.add(logout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle(message);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/volodymyr-hryshchenko-V5vqWC9gyEU-unsplash (3).jpg")));
		contentPane.add(lblNewLabel);
	}

}
