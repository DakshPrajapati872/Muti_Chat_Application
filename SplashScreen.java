package com.brainmentors.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Color;


public class SplashScreen extends JWindow {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					frame.runProgress();
			
	}
	private Timer timer;
	//Initialize with null value
	private void runProgress() {
		
		timer=new Timer(15 ,new ActionListener(){ 
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				progressBar.setValue(count);
				count++;
				if(count>100) {
					if(timer!=null) {
						timer.stop();
						SplashScreen.this.setVisible(false);
						SplashScreen.this.dispose();
						UserScreen userscreen=new UserScreen();
						userscreen.setVisible(true);
					}
				}
				
			}
				
			});
		timer.start();
		
	}
	private int count=0;
	JProgressBar progressBar = new JProgressBar();
	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		progressBar.setBackground(new Color(255, 51, 51));
		progressBar.setForeground(new Color(0, 51, 0));
		progressBar.setFont(new Font("Times New Roman", Font.BOLD, 16));
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 256, 353, 21);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/Images/chat-benefits.png")));
		lblNewLabel.setBounds(0, 0, 623, 300);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}
}
