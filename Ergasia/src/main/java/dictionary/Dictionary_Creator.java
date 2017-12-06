package dictionary;

import java.util.Scanner;

import Comparison.RunComparison;
import audio.RunIou;
import suggestion.Suggestion;
import textSplit.TextSplit;

import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;


public class Dictionary_Creator {
	public static final Map<String, String> dic1 = new HashMap<String, String>();
	public static final Map<String, Float> dic2 = new HashMap<String, Float>();
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
			int letter = 0;
			int previous = 0;
			while ((line = br.readLine()) != null) {
				dic1.put(line.substring(0,1) + i,line);
				dic2.put(line.substring(0,1) + i, (float)0);
				if(!(line.substring(0,1).equals(previousLetter)) && (i!=0)) {
					numberOfWords.put(previousLetter ,new Integer[] {previous, i});
					letter++;
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
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("give language");
		String language = sc.nextLine();
		sc.close();
		createDictionary(language);
	}
	public static boolean opperateDictionary(String  givenWord) {
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
				String[] suggest = Suggestion.findSuggestions(dic2, letter, numberOfWords.get(letter)[0] , numberOfWords.get(letter)[1]);
				TextSplit.correctedText.get(givenWord).setSuggestion1(suggest[0]);
				TextSplit.correctedText.get(givenWord).setSuggestion2(suggest[1]);;
				TextSplit.correctedText.get(givenWord).setSuggestion3(suggest[2]);;
	
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
