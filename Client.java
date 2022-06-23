package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.brainmentors.chatapp.utils.ConfigReader;

public class Client {
Socket socket;
InputStream in;
OutputStream out;
ClientWorker worker;
JTextArea textArea;
public Client(JTextArea textArea) throws UnknownHostException, IOException {
	int port=Integer.parseInt(ConfigReader.getValue("PortNo"));
	socket=new Socket(ConfigReader.getValue("Server_IP"),port);
	out=socket.getOutputStream();
	in=socket.getInputStream();
	this.textArea=textArea;
	readMessages();
	
//	System.out.println("Client Comes...");
//	System.out.println("Enter the message send to the Server...");
//	Scanner sc=new Scanner(System.in);
//	String message=sc.nextLine();
//	OutputStream out=socket.getOutputStream();//data write karna ka liya use hota hai
//	out.write(message.getBytes());//write bytes on network
//	System.out.println("Message sent to the Server..");
//	sc.close();
//	out.close();
//	socket.close();
}
public void sendMessage(String message) throws IOException {
	
	message=message+"\n";
	out.write(message.getBytes());
	
}
public void readMessages() throws IOException {
	worker=new ClientWorker(in,textArea);//Calling a read thread
	worker.start();
	
}


//public static void main(String[] args) throws UnknownHostException, IOException {
//	Client client=new Client();
//}
}
