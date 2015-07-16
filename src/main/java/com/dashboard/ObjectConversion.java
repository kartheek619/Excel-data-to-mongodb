package com.dashboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class ObjectConversion {
	
	List<String> jsondocs = new ArrayList<String>();
	
	public List<String> objectToJson(List<DataLine> datalines ){
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

		
		for(DataLine dataline: datalines){
			
			
			try {
				String json = ow.writeValueAsString(dataline);
				
				System.out.println(json);
				jsondocs.add(json);
				
				
				
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return jsondocs;
		
		
		
	}
	
	

}
