# Splee Checker
a spell checker program. This program will use  the file dictionary.txt to look up properly spelled words. When the program starts, you will open the dictionary file (name it "Dictionary.txt"). This utilize a hash function I created to hash the words  into an externally-chained hash table you have created. Java has good implementations for hash tables, but, for the sake of practice, I will build My own. The hash table will be of a size that you will determine.
to test an input use file named "testTextFile.txt." When the checking proceeds. Each time you find a word that you cannot match in the dictionary, it will let the user know and you will attempt to generate a list of suggested words.

One letter missing. Assumed that one letter has been left out of the word. This can assemble new words to check by adding letters a..z in each of the positions in the word from the start to the end of the word.
One letter added. Assumed the word has an extra letter. This scan through the word deleting each of the letters in turn, and looking up the word formed by the remaining letters.
Two letters reversed. Swap letters in positions 0..1, 1..2, 2..3, ... , n-2..n-1, to form new words which you look up.
Each time it find a legal word from any of the three methods, it displays on the console. If cannot identify any suggestions, let the user know.
Example file:

`` Hello. My plan is to hav a test fiile that has UPPer and LOWER case words. All three cases of misspellings will be represented. The file will encompass more than one line and will have no other puncktuation than commas, and the dot at hte end of a line.``

## Output

``All output goes to the console. ``
