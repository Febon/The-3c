package ui;

import dictionary.TextSplit;

public class Output {
	public static void printCorrectedTxt() {
		for(Integer i = 1; i < TextSplit.correctedText.size(); i++ ) {
			System.out.print(TextSplit.correctedText.get(TextSplit.textForCorrection.get(i)).getWord() + "  " + "(");
			for(int j = 0; j < TextSplit.correctedText.get(TextSplit.textForCorrection.get(i)).getSuggestions().length; j++ ) {
				System.out.print(TextSplit.correctedText.get(TextSplit.textForCorrection.get(i)).getSuggestions()[j] + "  ");
			}
			System.out.println(")");
		}	
	}

}
