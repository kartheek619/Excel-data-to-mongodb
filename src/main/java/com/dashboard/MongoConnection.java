package com.dashboard;

import java.util.List;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class MongoConnection {
	
	private List<String> jsondocs;
	
	public void setJsonDocs(List<String> jsondocs){
		
		this.jsondocs =jsondocs;
		
	}
	
	
	
	public void connectToMongo(){
		
		
		MongoClient mongo = new MongoClient("localhost",27017);
		DB db = mongo.getDB("sample");
		DBCollection collection = db.getCollection("dashboard");
		collection.drop();
				
		for(String json: jsondocs){
			
			DBObject dbObject = (DBObject)JSON.parse(json);
			//Document doc = (Document) JSON.parse(json);
			collection.insert(dbObject);
			
		}
		
		mongo.close();
		
		
		
	}
	

}
