package com.dashboard;

import java.util.List;

public class Application {
	
 ;
	
	public static void main(String [] args){
		
		List<String> jsondocs;
		
		System.out.println("Kartheek");
		
		ExcelData data = new ExcelData();
		ObjectConversion convert = new ObjectConversion();
		jsondocs = convert.objectToJson(data.readFromExcel());
		
		MongoConnection conn = new MongoConnection();
		conn.setJsonDocs(jsondocs);
		conn.connectToMongo();
		
		
		
		
	}

}
