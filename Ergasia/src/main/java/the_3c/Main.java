package the_3c;

import dictionary.Dictionary_Creator;
import dictionary.Encoding_Detector;
import dictionary.TextSplit;
public class Main {

	public static void main(String[] args) {
		String txt = null;
		TextSplit.splitIntoWords(txt);
		String languageCode = null;
		try {
			languageCode = Encoding_Detector.encoding_Detector(txt);
		} catch(Exception e) {
			System.out.println(e);
		}
		if (languageCode.equals("ISO-8859-7") || languageCode.equals("WINDOWS-1253")) {
			Dictionary_Creator.createDictionary("Greek");
		} else {
			Dictionary_Creator.createDictionary("English");	
		}
		for (int i = 0; i <TextSplit.textForCorrection.size(); i++) {
			if (i > 0) {
				Dictionary_Creator.opperateDictionary(null, TextSplit.textForCorrection.get(i));
			} else {
				Dictionary_Creator.opperateDictionary(TextSplit.textForCorrection.get(i-1), TextSplit.textForCorrection.get(i));
			}
		}
		
			
		
	}

}
