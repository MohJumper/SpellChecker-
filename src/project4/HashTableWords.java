package project4;


import java.io.File;
import java.util.Scanner;

public class HashTableWords {
	
	private final int TABLE_ARR_SIZE = 61403; // choice prime size number.
	private WordToHash[] table = new WordToHash[TABLE_ARR_SIZE];
	private final int MAKE_POSITIVE = -1;
	private final int ZERO = 0;
	
	class WordToHash {
		
		String word;
		WordToHash next;
		
		public WordToHash(String str, WordToHash nxt) {
			word = str;
			next = nxt;
		}
		
	} // ------------- end of word to hash
	
	
	/**
	 * This method takes each word in txt file and hash it into table. 
	 * The method makes call to insert method and hash word return an index of the table
	 * @param passDic dictionary of word in txt format
	 */
	protected void loadDicToTable(String passDic) {
		Scanner scnr;
		try {
			scnr = new Scanner(new File(passDic));
			while (scnr.hasNext()) {
				String line = scnr.next();
				insert(line, hashWord(line));
			}
			scnr.close();
		} catch (Exception e) {
			//
		}
	}
	
	private void insert(String word, int position) {
		WordToHash temp = new WordToHash(word, table[position]);
		table[position] = temp;
	}
	

	/**
	 * This method return int in range of array hash table to be used as indices to map 
	 * string words into the array.
	 * @param st dict word to be hashed
	 * @return an int in range of the array hash table
	 */
	private int hashWord(String st) {
		int hashTotal = 0;
		int stLength = st.length(); 
		
		for(int indx =0; indx < stLength; indx++) {
			hashTotal += st.charAt(indx) ;
		}
		
		hashTotal *= (st.charAt(stLength -1)) - (stLength * stLength);
		if( hashTotal < ZERO) {
			hashTotal = MAKE_POSITIVE * hashTotal;
		}
		return hashTotal % TABLE_ARR_SIZE;
	}
	
	/**
	 * This method takes a word to search it in the hashtable and return true orfalse.
	 * @param key word to search in the hashtable
	 * @return boolean
	 */
	protected Boolean lookUp(String key) {
		for(int i =0; i < TABLE_ARR_SIZE; i++) {
			WordToHash curr = table[i];
		
			while(curr != null) {
				if(curr.word.equals(key)) {
					return true;
				}
				curr = curr.next;
			
			}
		}
		return false;
	}

}
