package dictionary;

import textSplit.TextSplit;

public class Test {
	public static void main(String[] args) {
		String givenWord = "1";
		System.out.println(TextSplit.symbols.contains(givenWord.charAt(0)));
	}
}
