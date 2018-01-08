package dictionary;

/**
 *TextSplit
 *
 *Copyright 2017 Karagianni/team java autocorrect
 */

import java.util.Map;

import Comparison.Suggestion;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 *class TextSplit reads text from user and splits it into words
 *@version 1.0 29 Oct 2017
 *@author Kostantina Karagianni
 */

public class TextSplit {
	/**The following map is used to save the txt document in the same order that it was given.
	 *  This is done because in order to save storage we will be converting all the letters 
	 *  in the given text into lower case. So in order to change the appropriate letters into 
	 *  upper case letters when returning the text corrected it is essential that we same the 
	 *  exact position the dots are.
	 */
	public static Map<Integer,String> textForCorrection = new HashMap<Integer,String>();
	public static Map<String,Suggestion> correctedText= new HashMap<String,Suggestion>();
	public static Character[] symb = {',','.','<','>','?',':',';','\'','"','(',')','{','}','[',']','/','\\','!','@','%','$','#','&','*','~','-','_','`','+','=','0','1','2','3','4','5','6','7','8','9'};
	public static List<Character> symbols = Arrays.asList(symb);
	
	public static void splitIntoWords(String filePath){
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(filePath)));
		    String line;
		    int key=0;
		    while ((line = br.readLine()) != null) {
				textForCorrection.put(key,line.toLowerCase());
				correctedText.put(textForCorrection.get(key), new Suggestion(textForCorrection.get(key).toLowerCase(), null));
				key++;
		    }
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		Arrays.sort(symb);
		
		//MISTAKEN ( the mistake probably is that we don't consider the fact that there might be more than one kind of symbol in a string
		
		for (int i = 0; i <textForCorrection.size(); i++) {
			for(int z = 0; z < symb.length; z++) {
				if (textForCorrection.get(i).contains( ".*" + symb[z] + ".*" )) {
					String[] splt = correctedText.get(textForCorrection.get(i)).getWord().split(String.valueOf(symb[z]));
					String currentWord = textForCorrection.get(i);
					if (!(currentWord.substring(0,1).equals(String.valueOf(symb[z])) || currentWord.substring(currentWord.length()-1,currentWord.length()).equals(String.valueOf(symb[z])))){
						
						Extra(i, splt, symb[z], "middle");
						
					} else if (currentWord.substring(0,1).equals(String.valueOf(symb[z])) && !(currentWord.substring(1,currentWord.length()).contains(".*" + String.valueOf(symb[z]) + ".*"))) {
						
						Extra(i, splt, symb[z], "left");
						
					} else if(currentWord.substring(currentWord.length()-1,currentWord.length()).equals(String.valueOf(symb[z])) && !(currentWord.substring(0,currentWord.length()-1).contains(".*" + String.valueOf(symb[z]) + ".*"))) {
						
						Extra(i, splt, symb[z], "right");
						
					} else if (currentWord.substring(0,1).equals(String.valueOf(symb[z])) && currentWord.substring(1, currentWord.length()).contains( ".*" + String.valueOf(symb[z]) + ".*")) {
						
						Extra(i, splt, symb[z], "midle-left");
						
					} else if(currentWord.substring(currentWord.length()-1,currentWord.length()).equals(String.valueOf(symb[z])) && currentWord.substring(0,currentWord.length()-1).contains(".*" + String.valueOf(symb[z]) + ".*") ) {
						
						Extra(i, splt, symb[z], "midle-right");
						
						
						
						
						//LAHTOS
						
						
					} else if(currentWord.substring(0,1).equals(String.valueOf(symb[z])) && currentWord.substring(1,currentWord.length()-1).equals(String.valueOf(symb[z]))) {
						
						Extra(i, splt, symb[z], "left-right");
						
					} else if(currentWord.substring(0,1).equals(String.valueOf(symb[z])) && currentWord.substring(currentWord.length()-1,currentWord.length()).equals(String.valueOf(symb[z]))) {
						
						Extra(i, splt, symb[z], "left-right");
						
					} else {
						
						Extra(i, splt, symb[z], "everywhere");
					}
					break; 
				}
			}
		}
	}
	
	protected static void Extra(int pointer,String[] array, char containedCharacter, String location) {
			int extraSpace = 1;
			List<String> list = Arrays.asList(array);
		if (location.equals("middle")) {
			
			extraSpace = 2*(array.length) - 1;
			list = addCharacter(extraSpace, list, containedCharacter);
			
		} else if (location.equals("left")) {
			
			list = addCharacterLeftOrRight(extraSpace, list, containedCharacter, "left");
			
		} else if(location.equals("right")) {
			
			list = addCharacterLeftOrRight(extraSpace, list, containedCharacter, "right");
			
		} else if(location.equals("middle-left")) {
			
			extraSpace = 2*(array.length);
			list = addCharacter(extraSpace, list, containedCharacter);
			list = addCharacterLeftOrRight(extraSpace, list, containedCharacter, "left");
			
		} else if(location.equals("middle-right")) {
			
			extraSpace = 2*(array.length);
			list = addCharacter(extraSpace, list, containedCharacter);
			list = addCharacterLeftOrRight(extraSpace, list, containedCharacter, "right");

		} else if (location.equals("left-right")) {
			extraSpace = 2;
			list = addCharacterLeftOrRight(extraSpace, list, containedCharacter, "left");
			list = addCharacterLeftOrRight(extraSpace, list, containedCharacter, "right");
		} else {
			list = addCharacter(extraSpace, list, containedCharacter);
			list = addCharacterLeftOrRight(extraSpace, list, containedCharacter, "left");
			list = addCharacterLeftOrRight(extraSpace, list, containedCharacter, "right");
		}
		for(int i = correctedText.size()+array.length + extraSpace - 1; i>pointer+1; i--) {
			textForCorrection.put(i,textForCorrection.get(i-array.length));
			correctedText.put(textForCorrection.get(i), correctedText.get(textForCorrection.get(i-array.length)));
		}
		for(int i = pointer;i < array.length + extraSpace; i++) {
			textForCorrection.put(i,array[i]);
			correctedText.put(array[i], new Suggestion(array[i], null));
		}
	}
	
	public static List<String> addCharacter(int extraSpace, List<String> list, char containedCharacter) {
		for (int i = 0; i < extraSpace; i++) {
			list.set(i*2,list.get(i));
			if(i!=0) {
				list.set(i * 2 - 1,String.valueOf(containedCharacter));
			}
			
		}
		return list;
	}
	
	public static List<String> addCharacterLeftOrRight(int extraSpace, List<String> list, char containedCharacter, String position) {
		if(position.equals("left")){
			for(int i = list.size(); i>1; i--) {
				list.set(i,list.get(i-1));
			}
			list.set(0,String.valueOf(containedCharacter));
		} else {
			list.add(String.valueOf(containedCharacter));
		}
		return list;		
	}	
}