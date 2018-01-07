package Comparison;

import java.util.HashMap;
import java.util.Map;

import dictionary.Dictionary_Creator;

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
	public static Map<String, Float> getRange(Map<String,Float> dic2,int start , int finish, String firstLetter) {
		Map<String, Float> temporary = new HashMap<String, Float>();
		for (int i = start; i < finish; i++) {
			temporary.put(firstLetter + i, dic2.get(firstLetter + i));
		}
		return temporary;
	}

}
