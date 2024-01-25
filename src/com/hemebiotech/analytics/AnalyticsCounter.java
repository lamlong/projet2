package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	private ISymptomReader attributsreader;
	private ISymptomWriter attributswriter;
	 public <Reader> AnalyticsCounter(ISymptomReader reader,
			 ISymptomWriter writer) throws IOException {
		 attributsreader=reader;	 		 
		 attributswriter = writer;
	 }     
	 
	 
	        Map<String,Integer> countSymptoms(){
	    	   
		 //TODO : récupérer la liste des symptomes ( de type List<String>) pour la passer en paramètre de count symptoms
	        	
	        	List<String> countSymptoms = new ArrayList<>();
	        	
	        	return attributsreader.countSymptoms(null);
	 }
	 
	public static void main(String args[]) throws Exception {
		// first get input
		String filepath = "C:\\Users\\sonyl\\long1\\src\\com\\hemebiotech\\analytics\\symptoms.txt";
		BufferedReader reader = new BufferedReader (new FileReader(filepath));
		String line = reader.readLine();

	/*	int i = 0;	// set i to 0
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}*/
	    
				
		
		// next generate output
		
		
		
		
		ISymptomReader readerSymp = new ReadSymptomDataFromFile(filepath);
		Map<String,Integer> mapSympt = readerSymp.getSymptomsMap();
	    ISymptomWriter writer=new WriterSymptomDataFromFile();
	    
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(readerSymp, writer);
		Map<String,Integer> mapCount = analyticsCounter.countSymptoms();	
		
		System.out.println(mapCount.toString());
		
		//writer.write(mapSympt);
			
	}
}
