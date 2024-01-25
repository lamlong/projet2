package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriterSymptomDataFromFile implements ISymptomWriter {

	@Override
	public void write(Map<String, Integer> mapSym) throws IOException {
		// TODO Auto-generated method stub
		FileWriter writer = new FileWriter ("result.out");
		
				
		System.out.println("____COMPTEUR DE SYMPTOME_____");
		for (String symptomname : mapSym.keySet()) {
		System.out.println(symptomname + ": "+ mapSym.get(symptomname));
		writer.write (symptomname + ": "+ mapSym.get(symptomname)+"\n");
		
		  	
		}
		
		writer.close();
		
		
		
		
		
		
		
	}

	
		

	
	

}
