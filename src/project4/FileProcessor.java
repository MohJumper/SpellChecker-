package project4;

/*********************************************************************** 
Name: Moe
File Name: 
number: Final Project #4

Note: This program works as should be and produce the desired result. However further optimization is possible by 
reducing the number of comparison and optimize the three methods that alter the misspelled words.
************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FileProcessor {
	
	private static HashTableWords htw;
	private static WordChecker wordCh;
	private Set<String> sugesstedWords;
	private List<String> wordsToProcess;
	
	private final char PUNC_DOT = '.';
	private final char PUNC_COMMA = ',';
	
	public static void main(String[] args) {
		FileProcessor fp = new FileProcessor();
		fp.readFile("test.txt");
		fp.displaySugession();
	} // ---------------------------------- end of main
	
	public FileProcessor() {
		htw = new HashTableWords();
		htw.loadDicToTable("dictionary.txt");
		wordCh = new WordChecker();
		sugesstedWords = new HashSet<String>();
		wordsToProcess = new ArrayList<String>();
	}
	
	private void readFile(String file) {
		Scanner scnr;
		try {
			scnr = new Scanner(new File(file));
			while(scnr.hasNext()) {
				String line = scnr.nextLine();
				String[] expr = line.split(" ");
				for(int i = 0; i < expr.length; i++) {
					String wordTolook = removePunct(expr, i).toLowerCase();
					if(!htw.lookUp(wordTolook)) {
//						System.out.print(wordTolook + " ");
						wordsToProcess.add(wordTolook);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	} // ------------------- end of readFile method
	
	/**
	 * This method display the final result of the spell checkers based of the dictionary txt file.
	 * The method also makes a call to processWordSugesst method that in itself make calls to three method 
	 * to process each word by @method 1. add a-z letters at each index of a string 
	 * @method 2. remove one letter at the time @method 3. in place swapping letters
	 */
	private void displaySugession() {
		for(int idxWrod=0; idxWrod < wordsToProcess.size(); idxWrod++) {
			processWordSugesst(wordsToProcess.get(idxWrod), idxWrod);
		}
		System.out.println(sugesstedWords);
	}
	
	/**
	 * This method makes call to three methods from class WordChecker. @method 1. add a-z letters at each index of a string 
	 * @method 2. remove one letter at the time @method 3. in place swapping letters.
	 * @param wordTolook word that possible missing word dictionary to be processed
	 * @param idx index of each word in the list
	 */
	private void processWordSugesst(String wordTolook, int idx) {
		
		for(idx=0; idx <= wordTolook.length(); idx++) {
			for(char alpha= 'a'; alpha <= 'z'; alpha++) {
				if(htw.lookUp(wordCh.addletters(wordTolook, alpha,idx))) {
					sugesstedWords.add(wordCh.addletters(wordTolook, alpha,idx));
				}
			}
		}
		// ------------ this work no issues
		for(idx=0; idx < wordTolook.length(); idx++) {
			if(htw.lookUp(wordCh.extraLetter(wordTolook, idx))) {
				sugesstedWords.add(wordCh.extraLetter(wordTolook, idx));
			}
		}
		
		for(idx=0; idx < wordTolook.length() -1; idx++) {
			if(htw.lookUp(wordCh.swapLetter(wordTolook, idx))) {
				sugesstedWords.add(wordCh.swapLetter(wordTolook, idx));
			}
		}
		
	}
	
	// ---------------------- helper method for read file
	/**
	 * This method takes array of words to remove any '.' or ','s and return just words.
	 * @param arrOfwords takes array of words
	 * @param wordIndx 
	 * @return string word after removing the punctuation
	 */
	String removePunct(String[] arrOfwords, int wordIndx) {
		if(arrOfwords[wordIndx].charAt(arrOfwords[wordIndx].length() -1) == PUNC_DOT 
				|| arrOfwords[wordIndx].charAt(arrOfwords[wordIndx].length() -1) == PUNC_COMMA) {
			return arrOfwords[wordIndx].substring(0, arrOfwords[wordIndx].length() -1);
		} else {
			return arrOfwords[wordIndx];
		}
	}

}
