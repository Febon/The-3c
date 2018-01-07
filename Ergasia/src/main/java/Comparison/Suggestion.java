package Comparison;

import java.util.HashMap;
import java.util.Map;

import dictionary.Dictionary_Creator;

/**
 * class Suggestion contains methods used to handle the similarity percentages
 * version 0.1 Jan 01 2018
 * Authors: Maria Kassita(AM:8160041)
 */

public class Suggestion {

	private String word;
	private String[] suggestions;

	public Suggestion(String word, String[] suggestions) {
		this.suggestions = suggestions;
		this.word = word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	public void setSuggestions(String[] suggestions) {
		this.suggestions = suggestions;
	}


	public String getWord() {
		return this.word;
	}
	public String[] getSuggestions() {
		return this.suggestions;
	}
	/**
	 * This method is used to find the N biggest similarity percentages where the N
	 * is the length of the txt word minus one and returns a string array containing the suggestions
	 * Parameters: 
	 *  @firstLetter: the first letter of the word we are currently comparing 
	 *  @start: the first position the @firstletter is located in the dic1 and dic2 maps
	 *  @finish: the final position the @firstletter is located in the dic1 and dic2 maps
	 *  @numberOfSuggestions: the number of suggestions to be presented
	 */
	public static String[] findSuggestions(String firstLetter, int start , int finish, int numberOfSuggestions){
		Map<String, String> temporaryDic1 = Dictionary_Creator.dic1;
		String[] a = new String[numberOfSuggestions];
		Map<String, Float> temporaryDic = getRange(Dictionary_Creator.dic2, start , finish, firstLetter);
		for(int i = 0; i < numberOfSuggestions; i++) {
			Float max = (float)0;
			for(int j = start; i < finish; i++) {
				if(temporaryDic.get(firstLetter + i) > max) {
					max = temporaryDic.get(firstLetter + i);
					a[j] = temporaryDic1.get(firstLetter + i);
				}
			}
		}
		
		return a;
	}
	
	/**
	 * This method is used to create a map from a section of the given map
	 * Parameters: 
	 *  @firstLetter: the first letter of the word we are currently comparing 
	 *  @start: the first position the @firstletter is located in the dic1 and dic2 maps
	 *  @finish: the final position the @firstletter is located in the dic1 and dic2 maps
	 *  @dic1: the given map
	 */
	
	public static Map<String, Float> getRange(Map<String,Float> dic2,int start , int finish, String firstLetter) {
		Map<String, Float> temporary = new HashMap<String, Float>();
		for (int i = start; i < finish; i++) {
			temporary.put(firstLetter + i, dic2.get(firstLetter + i));
		}
		return temporary;
	}

}
