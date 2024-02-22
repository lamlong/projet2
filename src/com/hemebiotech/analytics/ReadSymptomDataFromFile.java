package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	     public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Commenter le code - A quoi il sert ?
	 * 
	 *  ArrayList est La capacité  de Taille du tableau utilisé pour stocker les éléments de la liste
	    Il est utilisé pour construire une liste de tableaux vide.
	
	 * bufferedReader pour lire les contenu du fichier file path
	   si fichier path est null on essaie utiliser class bufered Reader pour lire le contenu d'un fichier path
	
	 * La boucle while du code ci-dessous va lire le fichier jusqu’à la fin du fichier.
	 
	 * reader.readLine() renvoie une chaîne de caractère. Ensuite, la boucle itérera jusqu’à ce qu’elle ne soit plus nulle.
	 
	 * Si une erreur se produit, nous pouvons l’utiliser pour intercepter l’erreur et exécuter du code pour la gérer :try...catch
	 
	 * return retour au résultat
	 * 
	 */
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
	
	private Map<String, Integer> symptomMap = new HashMap<>();
	
	
	@Override
	public Map<String,Integer> getSymptomsMap()
	{
		return symptomMap;
	}

	@Override
	public Map<String,Integer> countSymptoms(List<String> symtoms) {
		// Variable qui va contenir les symptômes et leur nombre d'occurence.
		Map<String, Integer> retour = symptomMap;
		
		// On parcourt les symptômes qui sont dans la liste en entrée.
		for (int i = 0; i < symtoms.size(); i++) {
			// Si le symptôme existe déjà dans la variable résultat, alors on fait + 1.
			if (retour.get(symtoms.get(i)) != null) {
				retour.put(symtoms.get(i), retour.get(symtoms.get(i)) + 1);
			} else { // Sinon on l'ajoute dans la variable résultat à 1.
				retour.put(symtoms.get(i), 1);
			}
		}
		
		// On retourne le résultat (qui contient pour chaque symptôme le nombre de fois où on l'a vu).
		return retour;
	}
}
