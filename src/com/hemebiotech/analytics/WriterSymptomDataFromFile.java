package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterSymptomDataFromFile implements ISymptomWriter {

	/**
	 * Commenter le code. A quoi il sert ?
	 * pour imprimer le contenu du  mapsym sur le console et sorti du résultat dans le fichier résult.out
	 * boucle for pour parcourir les éléments d’un tableau
	 *la class writer close  utilisée pour fermer l’enregistreur
	 */
	@Override
	public void write(Map<String, Integer> mapSym) throws IOException {
		
		//ecrire le nouveau fichier r�sult.out
		FileWriter writer = new FileWriter ("result.out");
		// afficher ecran compteur de symptome	
		System.out.println("____COMPTEUR DE SYMPTOME_____");
		
		for (String symptomname : mapSym.keySet()) {
			System.out.println(symptomname + ": "+ mapSym.get(symptomname));
			writer.write (symptomname + ": "+ mapSym.get(symptomname)+"\n");
		}
		
		writer.close();
	}
}