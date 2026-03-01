package fr.insa.soap;

import jakarta.xml.ws.Endpoint;

public class StudentApp {
	public static String host = "localhost";
	public static short port = 8089;
	
	public void startService() {
		String url = "http://"+host+":"+port+"/";
		Endpoint.publish(url, new StudentWS());
	}
	
	public static void main(String[] args) {
		
		new StudentApp().startService();
		System.out.println("Service started");
	}
}