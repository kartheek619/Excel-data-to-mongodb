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
	
	
	public List<DataLine> readFromExcel(){
		
		
		
		
		List<DataLine> datalines = new ArrayList<DataLine>();
		
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
				
				DataLine dataline = new DataLine();
				for(int i=0; i<columnitems.size(); i++){
					
					
					
					dataline.setID(columnitems.get(0));
					dataline.setFname(columnitems.get(1));
					dataline.setLname(columnitems.get(2));
					dataline.setDOB(columnitems.get(3));
					dataline.setAdd_line1(columnitems.get(4));
					dataline.setAdd_line2(columnitems.get(5));
					dataline.setAdd_City(columnitems.get(6));
					dataline.setAdd_Country(columnitems.get(7));
					dataline.setAdd_Pin(columnitems.get(8));
					dataline.setPhone(columnitems.get(9));
					
				}
				
				datalines.add(dataline);
				
				
			}
			
			
		
				
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return datalines;
		
	}
	

}
