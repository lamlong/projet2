package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public Map<String,Integer> getSymptomsMap()
	{
		Map<String,Integer> mapSymptomsRetour = new TreeMap<String, Integer>();
		
		for (String symptom : this.GetSymptoms()) {
			Integer compteur = 1;
			if(mapSymptomsRetour.get(symptom) != null){
				compteur = mapSymptomsRetour.get(symptom) +1;
			}
			
			mapSymptomsRetour.put(symptom, compteur);
		}
		
		return mapSymptomsRetour;
	}

	@Override
	public Map<String,Integer> countSymptoms(List<String> symtoms) {
		// TODO Compter les symptomes
		return new HashMap<String,Integer>();
		//return null;
	}
	
	

}
