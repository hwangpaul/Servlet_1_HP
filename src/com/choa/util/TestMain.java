package com.choa.util;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnector dbConnector = new DBConnector();
		try {
			dbConnector.getConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
