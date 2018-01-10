package the_3c;


import dictionary.Dictionary_Creator;
import dictionary.TextSplit;
import dictionary.findLanguage;
public class Main {

	public static void StartCorrection(String filePath) {
		
		TextSplit.splitIntoWords(filePath);
		String languageCode;
		languageCode = findLanguage.findLang();

		if (languageCode.equals("Greek")) {
			Dictionary_Creator.createDictionary("Greek");
		} else {
			Dictionary_Creator.createDictionary("English");	
		}
		for (int i = 0; i <TextSplit.textForCorrection.size(); i++) {
			if (i == 0) {
				Dictionary_Creator.opperateDictionary(null, TextSplit.textForCorrection.get(i));
			} else {
				Dictionary_Creator.opperateDictionary(TextSplit.textForCorrection.get(i-1), TextSplit.textForCorrection.get(i));
			}
		}
		
			
		
	}

}
