package com.music.store.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/music_directory";
		String username = "musicproduct";
		String pass = "musicproduct";
		
		try {
			
			System.out.println("Connecting Database" + url);
			
			Connection thecon = DriverManager.getConnection(url,username,pass);
			
			System.out.println("Connection successfull" + thecon);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
