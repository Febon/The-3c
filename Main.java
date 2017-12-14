package main;
import dictionary.Dictionary_Creator;
import textSplit.TextSplit;
import detectEncoding.DetectEncoding;
public class Main {

	public static void main(String[] args) {
		String languageCode = DetectEncoding.detectEncoding;
		if (languageCode.equals("ISO-8859-7") || languageCode.equals("WINDOWS-1253")) {
			Dictionary_Creator.createDictionary("Greek");
		} else {
			Dictionary_Creator.createDictionary("English");	
		}
		String txt;
		TextSplit.splitIntoWords(txt);
		for (int i = 0; i <TextSplit.textForCorrection.size(); i++) {
			Dictionary_Creator.opperateDictionary(TextSplit.textForCorrection.get(i));
		}
		
			
		
	}

}
