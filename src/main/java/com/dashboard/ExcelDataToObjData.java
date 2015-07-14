package com.dashboard;

import java.util.ArrayList;
import java.util.List;

public class ExcelDataToObjData {
	
	List<DataLine> datalines = new ArrayList<DataLine>();
	
	public List<DataLine> changeExcelDataToObjects(List<List<String>> datalist){
		
		for(List rows: datalist){
			
			DataLine dataline = new DataLine();
			
			for(int i=0; i<rows.size(); i++){
				
				List<String> row = (List<String>) rows.get(i);
				
				dataline.setID(row.get(0));
				dataline.setFname(row.get(1));
				dataline.setLname(row.get(2));
				dataline.setDOB(row.get(3));
				dataline.setAdd_line1(row.get(4));
				dataline.setAdd_line2(row.get(5));
				dataline.setAdd_City(row.get(6));
				dataline.setAdd_Country(row.get(7));
				dataline.setAdd_Pin(row.get(8));
				dataline.setPhone(row.get(9));
				
			}
			
			datalines.add(dataline);
				
			
		}
		
		return datalines;
		
	}
	
	
	

}
