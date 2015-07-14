package com.dashboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelData {
	
	@SuppressWarnings("rawtypes")
	public List readFromExcel(){
		
		
		List<List<String>> rows = new ArrayList<List<String>>();
		
		
		
		try {
			
			FileInputStream file = new FileInputStream(new File("data.xls"));
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.iterator();  //iterates through different rows in excel sheet
			while(rowIterator.hasNext()){
				
				
				
				Row row = rowIterator.next();
				
				if(row.getRowNum()==0){
					
					continue;
					
				}
				
				
				Iterator<Cell> cellIterator = row.cellIterator();
				List<String> columnitems = new ArrayList<String>();
				
				
				
				while(cellIterator.hasNext()){         // iterates through different cells in each row
					
					Cell cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					columnitems.add(cell.toString());
					
				
				}
				
				rows.add(columnitems);
				
			}
			
			
		
				
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
		
	}
	

}
