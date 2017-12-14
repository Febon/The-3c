package Comparison;

/*
 *Comparison
 *
 *Copyright 2017 Liadopoulos, Kassita/team java autocorrect
 */

import java.util.*;
import java.lang.Object;

import dictionary.Dictionary_Creator;

/**
 * class Comparison contains methods that compare words from the text with words
 * from the dictionary version 0.1 Nov 12 2017 authors Antonis
 * Liadopoulos(AM:8160060) and Maria Kassita(AM:8160041)
 */

public class RunComparison {

	/**
	 * This method is used to find out which words are misspelled in order to
	 * proceed to the next stage of the comparison. Parameters: givenWord: This
	 * parameter will contain a word from the text that is to be corrected
	 * vocubularyWord: This parameter will contain a word from the dictionary
	 */

	public static boolean totalComparison(String givenWord) {
		boolean check = Dictionary_Creator.dic1.containsValue(givenWord);
		return check;
	}

	/**
	 * This method is used to compare the word from the text an the word from the
	 * dictionary in order to calculate how match the word from the text resembles
	 * the word from the dictionary. This is done by breaking the smaller word in an
	 * array and using the creatingComparisonConditionMethod to find out how many of
	 * its letters are contained in the other word.
	 *  Parameters: 
	 *  givenWord: a word from the text that is to be corrected. vocubularyWord: A word from the
	 * 	dictionary.
	 */

	public static float partialComparison(String givenWord, String vocabularyWord) {
		List<String> ConditionList = new ArrayList<String>();
		String word1, word2;
		if (givenWord.length() > vocabularyWord.length()) {
			word1 = givenWord;
			word2 = vocabularyWord;
		} else {
			word2 = givenWord;
			word1 = vocabularyWord;

		}
		String[] SplitWord2 = methodForSpliting(word2);
		ConditionList = creatingConditionList(SplitWord2.length);
		float precision = 0;
		int[][] LetterCombinations = createLetterCombinations(SplitWord2.length);
		String[] CombinationArray = convertIntToString(LetterCombinations);
		String check = "false";
		String flag = "false";
		int i = 0;
		if ((creatingComparisonConditionMethod(ConditionList.get(SplitWord2.length - 2), word2, word1, CombinationArray[i]) + "").equals("true") && word1.length() != word2.length()) {
			check = "true";
			flag = "true";

		}
		while (i < SplitWord2.length && check.equals("false")) {
			Object a = creatingComparisonConditionMethod(ConditionList.get(SplitWord2.length - 2), word2, word1,
					CombinationArray[i]);
			check = a + "";
			i++;
		}
		if (check.equals("true") && flag.equals("false")) {
			return ((float) word2.length() - 1) / (float) word1.length();
		} else if (flag.equals("true")) {
			return ((float) word2.length()) / (float) word1.length();
		}

		return precision;
	}

	/**
	 * This method is used to convert an int two-dimensional array int a
	 * one-dimensional String array. Parameters: a: All the possible combination of
	 * a words' letters in the form of a two-dimensional array.
	 */

	public static String[] convertIntToString(int[][] a) {
		String[] b = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = "" + a[i][0];
			for (int j = 1; j < a[i].length; j++) {
				b[i] += ", " + a[i][j];
			}
		}
		return b;
	}

	/**
	 * This method created a two-dimentional array containing all the possible
	 * compinations of a words letters keeping the letters hierarchy. Parameters:
	 * length: An int variable containing the length of the word whose letetr
	 * combinations we want to create.
	 */

	public static int[][] createLetterCombinations(int length) {

		int[][] letterCombinations = new int[length][length - 1];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - 1; j++) {
				letterCombinations[i][j] = j;
			}
		}
		for (int i = 1; i < length; i++) {
			letterCombinations[i][length - i - 1]++;
			for (int j = 0; j < letterCombinations[i][length - i - 1]; j++) {
				letterCombinations[i + j][length - i - 1] = letterCombinations[i][length - i - 1];
			}
		}
		return letterCombinations;

	}

	/**
	 * This method splits a word in letters and places it in a one-dimensional array
	 * Parameters: word: A string variable we want to split
	 */

	public static String[] methodForSpliting(String word) {
		String[] SplitWord = word.split("");
		return SplitWord;

	}

	/**
	 * This method creates the apropriate code for the creation of the
	 * ComparisonCondition class which contains the runComparisonCondition method.
	 * Parameters: comparedCombination : A string variable used in the
	 * runComparisonCondition in which it's compared with the variable named "word"
	 * through the usage of the .matches() method. word1: A word which will be
	 * compared as a whole. word2: A word which will be compared as a compination o
	 * letters. combination: A combination of array indexes in the form of a String.
	 */

	public static Object creatingComparisonConditionMethod(String comparedCombination, String word1, String word2,
			String combination) {
		String classNameA = "ComparisonCondition";
		String codeA = "import java.util.*;" + "\n" + "public class ComparisonCondition {" + "\n"
				+ "    public static Boolean runComparisonCondition(String word2) {" + "\n"
				+ "		 int[] combination = {" + combination + "};" + "\n" + "		 String word = \"" + word1 + "\";"
				+ "\n" + "        return word.matches(" + comparedCombination + ");" + "\n" + "    }" + "\n" + "}"
				+ "\n";

		RuntimeCompiler r = new RuntimeCompiler();
		r.addClass(classNameA, codeA);
		r.compile();

		Object a = MethodInvocationUtils.invokeStaticMethod(r.getCompiledClass(classNameA), "runComparisonCondition",
				word2);
		return a;
	}

	/**
	 * This method creates a list containing the appropriate conditions needed in
	 * the reatingComparisonconditionMethod Parameters: length: this variable is of
	 * type int and represents the length of the smallest word.This length is used
	 * to determine the length of the list that is to be returned.
	 */

	public static List<String> creatingConditionList(int length) {
		List<String> ConditionList = new ArrayList<String>();
		ConditionList.add("\".*\" +  Comparison.methodForSpliting(word2)[combination[0");
		for (int i = 1; i < length - 1; i++) {
			ConditionList.add(ConditionList.get(i - 1) + "]] + " + ConditionList.get(0) + " + " + i);
		}

		for (int i = 0; i < length - 1; i++) {
			ConditionList.set(i, ConditionList.get(i) + "]] + \".*\"");
		}
		ConditionList.add("\".*\" +  Comparison.methodForSpliting(word2)[0");
		for (int i = 1; i < length - 1; i++) {
			ConditionList.set(length - 1, (ConditionList.get(length - 1) + "]] + " + ConditionList.get(0) + " + " + i));
		}

		return ConditionList;

	}
}
