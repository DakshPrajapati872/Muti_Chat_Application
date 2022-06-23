package com.brainmentors.chatapp.network;
//Thread==Worker
//Worker need a job to perform
//For job you give runnable
//Once job is created via Runnable so write a job logic inside a run function
//Assign a job to a thread/worker
//Per thread per stack ban raha hai

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread{

private Socket clientSocket;
private InputStream in;
private OutputStream out;
private Server server;
public ServerWorker(Socket clientSocket,Server server) throws IOException {
	this.server=server;
	this.clientSocket=clientSocket;
	in=clientSocket.getInputStream();
	out=clientSocket.getOutputStream();
	System.out.println("New Client Come");
}
@Override
public void run() {
	//Read Data from the client and Broadcast the data to all
	BufferedReader br= new BufferedReader(new InputStreamReader(in));
	String line;
	try {
	while(true) {
	
			line=br.readLine();
			if(line.equalsIgnoreCase("quit")) {
				break;//Client chat end for that particular user
			}
			//out.write(line.getBytes());
			//broadcast to all
			for(ServerWorker serverWorker : server.workers) {
				line=line+"\n";
				System.out.println(line);
				serverWorker.out.write(line.getBytes());
			}
	}
	}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	finally {
		try {
		if(br!=null) {
			br.close();
		}
		if(in!=null) {
			in.close();
		}
		if(out!=null) {
			out.close();
		}
		if(clientSocket!=null) {
			clientSocket.close();
		}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
		}
	
	

public static void main(String args[]) {
	//ServerWorker job=new ServerWorker();
	//Assign the job to a thread/worker
//	Thread worker=new Thread(job);
//	worker.start();//Internally it call run
	//job.start();
	
	
}
}
