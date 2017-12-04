package suggestion;

import java.util.Map;

public class Suggestion {

	private String word, suggestion1, suggestion2, suggestion3;
	private float percentage;

	public Suggestion(String word, float percentage) {
		this.word = word;
		this.percentage = percentage;
	}
	public Suggestion(String word, String suggestion1, String suggestion2, String suggestion3) {
			this.suggestion1 = suggestion1;
			this.suggestion2 = suggestion2;
			this.suggestion3 = suggestion3;
			this.word = word;
	}


	public void setWord(String word) {
		this.word = word;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public void setSuggestion1(String suggestion1) {
		this.suggestion1 = suggestion1;
	}
	public void setSuggestion2(String suggestion2) {
		this.suggestion2 = suggestion2;
	}
	public void setSuggestion3(String suggestion3) {
		this.suggestion3 = suggestion3;
	}


	public String getWord() {
		return this.word;
	}
	public float getPercentage() {
		return this.percentage;
	}
	public String getSuggestion1() {
		return this.suggestion1;
	}
	public String getSuggestion2() {
		return this.suggestion2;
	}
	public String getSuggestion3() {
		return this.suggestion3;
	}

	public static String[] findSuggestions(Map<String,Float> dic2, String firstLetter, int start , int finish){
		String[] a = new String[3];
		String key;
		float max1 = 0, max2 = 0, max3 = 0;
		for(int i = start; i < finish; i++) {
			key = firstLetter + i;
			if( dic2.get(key) > max1) {
				max1 = dic2.get(key);
				a[0] = key;
			} else if(dic2.get(key) > max2 ) {
				max2 = dic2.get(key);
				a[1] = key;
			} else if(dic2.get(key) > max3 ){
				max3 = dic2.get(key);
				a[2] = key;
			}
		}
		
		return a;
	}

}
