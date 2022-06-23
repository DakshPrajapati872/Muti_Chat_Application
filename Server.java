package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.brainmentors.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers=new ArrayList<>();
	public Server() throws IOException {
		int port=Integer.parseInt(ConfigReader.getValue("PortNo"));
		serverSocket=new ServerSocket(port);
		System.out.println("Server Started and waiting for the Client Connection...");
		handleClientRequest();
	}//Multiple client Handshaking
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket=serverSocket.accept();//HandShaking
			//Per Client per thread
			ServerWorker serverWorker=new ServerWorker(clientSocket,this);
			workers.add(serverWorker);
			serverWorker.start();
			}
	}
	
	
	
	
	
	
	
	//Single Client
	/*ServerSocket serverSocket;
	public Server() throws IOException  {
		int port=Integer.parseInt(ConfigReader.getValue("PortNo"));
		serverSocket=new ServerSocket(port);
		System.out.println("Server Started and waiting for the Client Connection...");
		Socket socket=serverSocket.accept();//HandShaking
		System.out.println("Client Joins the Server");
		InputStream in=socket.getInputStream();//read bytes from the network
		byte arr[]=in.readAllBytes();//sari bytes read kar le
		String str=new String(arr);//converting bytes to string
		System.out.println("Message received from the client : "+str);
		in.close();
		socket.close();
	}*/
	public static void main(String[] args) throws IOException {
		Server server=new Server();
	}
}
