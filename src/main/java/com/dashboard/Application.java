package com.dashboard;

public class Application {
	
	public static void main(String [] args){
		
		System.out.println("Kartheek");
		
		ExcelData data = new ExcelData();
		ObjectConversion con = new ObjectConversion();
		con.objectToJson(data.readFromExcel());
		
		
	}

}
