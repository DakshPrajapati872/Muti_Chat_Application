package com.brainmentors.chatapp.views;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;



public class UserView extends JFrame{
	int counter;
	public UserView() {
		counter=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);//Screen Size
		setResizable(false);//we will not be able maximize the window
		setTitle("Login");//Title for the window
		//setLocation(500,150);//If we dont want to make our window to start from (0,0)coordinates
		//setLocationRelativeTo(null);//center ma hoga har bar jab bhi open hoga 
		JLabel welcome=new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		Container container=this.getContentPane();
		container.setLayout(null);//By Default it will start from the default poition. To remove it we are using this
		welcome.setBounds(100,70,200,60);//null karna ka baad we are giving the (x,y,width,height).
		container.add(welcome);//For showing the Login in the container
		JButton button=new JButton("Count");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				counter++;
				welcome.setText("Count "+counter);
			}
		});
		button.setBounds(100,300,200,50);
		container.add(button);
		setVisible(true);//we are using it because it will display the window.
	}
	public static void main(String [] args) {
		UserView userView=new UserView();
	}

}
