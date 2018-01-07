package dictionary;

import Comparison.RunComparison;
import Comparison.Suggestion;
import audio.RunIou;

import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Class Comparison contains the apropriate methods that are needed in the 
 * creation of the dictionary that is of the same language. 
 * as the txt file given for correction
 * version 0.1 dec 2 2017 
 * Author Antonis Liadopoulos(AM:8160060)
 */

public class Dictionary_Creator {
	/** The keys of this map are
	 *  comprised of the first letter of the dictionary word and the number of the row the word
	 *  is located at.
	 */
	public static final Map<String, String> dic1 = new HashMap<String, String>();
	/** The following map is used to save the percentage in which the dictionary word is similar
	 *  to the given text word. In order to make the search easier a map with keys that are the 
	 *  dictionary words is essential.
	 */
	public static final Map<String, Float> dic2 = new HashMap<String, Float>();
	/** The following map is used to save the number of words in the dictionary in each letter.
	 *  This map was created in order to parse throw the dic1 map starting by a specified letter.
	 *  This maps value is a two array containing the first an last row each letter is found.
	 */
	public static Map<String, Integer[]>  numberOfWords = new HashMap<String, Integer[]>();

	public static String[] latinLetters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	public static String[] greekLetters = {"á", "Ü", "â", "ã", "ä", "å", "Ý", "æ", "ç", "Þ", "è", "é", "ß", "ê", "ë", "ì", "í", "î", "ï", "ü", "ð", "ñ", "ó", "ô", "õ", "ý", "ö", "÷", "ø", "ù", "þ"};
	static String english = "C:\\Users\\anton\\ant\\Ergasia\\dictionaries\\english_lowercase.txt";
	static String greek = "C:\\Users\\anton\\ant\\Ergasia\\dictionaries\\greek_lowercase.txt";
	public static void  fillMap(String fileName) {
		try {
			if (fileName.equals(english)) {
				
				numberOfWords = fillNumberOfWords(english);
			}else {
				
				numberOfWords = fillNumberOfWords(greek);
			}
			File f1 = new File(fileName);
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			String previousLetter = "";
			int i = 0;
			int previous = 0;
			while ((line = br.readLine()) != null) {
				dic1.put(line.substring(0,1) + i,line);
				dic2.put(line.substring(0,1) + i, (float)0);
				if(!(line.substring(0,1).equals(previousLetter)) && (i!=0)) {
					numberOfWords.put(previousLetter ,new Integer[] {previous, i});
					previous = i;
				}
				previousLetter = line.substring(0,1);
				i++;
			}
			fr.close();
			br.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
	public static void createDictionary(String languageCode) {
		if (languageCode.equals("English")) {
			fillMap(english);
		}else {
			fillMap(greek);
		}
	}
	public static boolean opperateDictionary(String previous, String  givenWord) {
		Boolean answer = false; 
		if(!(TextSplit.symbols.contains(givenWord.charAt(0)))) {
			answer = RunComparison.totalComparison(givenWord);
			if (!answer) {
				RunIou.playIou(); //for fun
				float percentage;
				String letter = givenWord.substring(0,1);
				for (int i = numberOfWords.get(letter)[0] ; i < numberOfWords.get(letter)[1];i++) {
					percentage = RunComparison.partialComparison (givenWord, dic1.get(letter + i));
					dic2.put(letter + i, percentage);
				}
				String[] suggest = Suggestion.findSuggestions(letter, numberOfWords.get(letter)[0], numberOfWords.get(letter)[1], givenWord.length() - 1);
				if(previous.equals(".")) {
					for(int i = 0; i < suggest.length; i++) {
						suggest[i] = suggest[i].substring(0, 1).toUpperCase() + suggest[i].substring(1);
					}
				}
				TextSplit.correctedText.get(givenWord).setSuggestions(suggest);
			}
		}
		return answer;
	}
	public static Map<String,Integer[]> fillNumberOfWords( String languageCode) {
		Map<String, Integer[]>  numberOfWordsTemporary = new HashMap<String, Integer[]>();
		if(languageCode.equals(english)) {
			for(int i = 0; i < latinLetters.length;i++) {
				numberOfWordsTemporary.put(latinLetters[i], new Integer[] {0,0});
			}
		} else if(languageCode.equals(greek)) {
			for(int i = 0; i < greekLetters.length;i++) {
				numberOfWordsTemporary.put(greekLetters[i], new Integer[] {0,0});
			}
		}
		
		return numberOfWordsTemporary;
	}
	
}

