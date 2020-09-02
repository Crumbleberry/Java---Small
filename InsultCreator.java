package insultCreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



/**
 * @author Tyler Crum
 *
 *	A class that creates an insult from randomly generated words :)
 *	September 2020

 */
public class InsultCreator {

	
	public static void main(String[] args) {
		
		ArrayList<String> adjectives = readToList("Very large Adjective List.txt");
		Random rand = new Random();
		int randNum = rand.nextInt(adjectives.size());
		
		String currentAdjective = adjectives.get(randNum);
		
		ArrayList<String> nouns = readToList("3syllablenouns.txt");
		int randNum2 = rand.nextInt(nouns.size());
		
		String currentNoun = nouns.get(randNum2);
		
		System.out.print(currentAdjective + " " + currentNoun);
	
	}
	
 
	/**
	 * 	Reads in the file and creates an array list of the words that the file contains
	 * 
	 * @param fileName The name of the file to read in
	 * @return A list of words that the file contains
	 */
	public static ArrayList<String> readToList(String fileName) {
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<String> returnList = new ArrayList<String>();
		
		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		while(s.hasNext()) {
			lines.add(s.next());
		}
		
		for(String line : lines) {
			line = line.replace(".", "");
			try {
				Integer.parseInt(line);
			} catch (Exception e) {
				returnList.add(line);
			}
		}
		
		return returnList;
		
		
	}
}
