/*Copyright 2017 Triantafylloy-Zenioy/team java autocorrect*/
public class findLanguage{
	TextSplit te = new TextSplit();
	int words = te.arrayLength();
	private String[] firstLetter = new String[words];
	public void firstLetters(){
		String word;
		String letter;
		for(int i=0;i<words;i++){
			word = te.sendWord(i);
			letter = word.substring(0,1);
			firstLetter[i] = letter;
		}
	}
	public String getFirtLetter(int i){
		return firstLetter[i];
	}
}
