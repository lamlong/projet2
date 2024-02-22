package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
	
	// Méthode principale de l'application.
	public static void main(String args[]) throws Exception {
		String filepath = "C:\\Users\\sonyl\\long1\\src\\com\\hemebiotech\\analytics\\symptoms.txt";
		
		// 1 - On lit le fichier de symptômes.
		ISymptomReader readerSymp = new ReadSymptomDataFromFile(filepath);
		List<String> symptomsList = readerSymp.GetSymptoms();
		
		// 2 - On compte les symptômes.
		Map<String,Integer> mapSympt = readerSymp.countSymptoms(symptomsList);
		
		// 3 - On écrit les symptômes.
	    ISymptomWriter writer=new WriterSymptomDataFromFile();
	    
		writer.write(mapSympt);
			
	}
}
