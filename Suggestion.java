public class Suggestion {

	private String word, suggestion1, suggestion2, suggestion3;
	private int percentage;

	public Suggestion(String word, int percentage) {
		this.word = word;
		this.percentage = percentage;
	}
	public Suggestion(String word, String suggestion1, String suggestion2, String suggestion3) {
			this.suggestion1 = suggestion1;
			this.suggestion2 = suggestion2;
			this.suggestion3 = suggestion3;
			this.percentage = percentage;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setPercentage(int percentage) {
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
	public int getPercentage() {
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




}