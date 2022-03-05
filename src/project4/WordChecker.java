package project4;

public class WordChecker {
	
	/**
	 * This method assume that the word is missing a letter and add a-z letter at each possible 
	 * index of the string.
	 * @param missingLetter 
	 * @param alphbet a-z
	 * @param indexLetter
	 * @return string contains a-z char added at each position
	 */
	String addletters(String missingLetter, char alphbet ,int indexLetter) {
		return addChar(missingLetter, alphbet, indexLetter);
	}
	
	/**
	 * This method assume that the word has an extra letter and remove one letter each iteration.
	 * @param exLetter word with extra letter
	 * @param indx
	 * @return string word with all possible one letter removed 
	 */
	String extraLetter(String exLetter, int indx) {
		return exLetter.substring(0, indx) + exLetter.substring(indx+1);

	}
	
	/**
	 * This method assume that the word is miss spelled and do swapping in place.
	 * @param toSwap word 
	 * @param indx of the word
	 * @return all possible swapped 
	 */
	String swapLetter(String toSwap, int indx) {
		if(toSwap == null || toSwap.isEmpty()) {
			return toSwap;
		}
		char[] letter = toSwap.toCharArray();
		char temp = letter[indx];
		letter[indx] = letter[indx+1];
		letter[indx+1] = temp;
		return new String(letter);

	}
	
	// ------------------------- helper method
	
	/**
	 * This is a helper method to addletters that return string with added letters at position/index
	 * zero to the length of the passed string.
	 * 
	 * @param str words that are miss spelled
	 * @param singleLetter a-z letters
	 * @param position index 
	 * @return contacting string with added letters
	 */
	private String addChar(String str, char singleLetter, int position) {
		return str.substring(0, position) + singleLetter + str.substring(position);
	}
	
}
