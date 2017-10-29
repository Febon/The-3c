/*
 *TextSplit
 *
 *Copyright 2017 Karagianni/team java autocorrect
 */

import java.util.Scanner;

/**
 *class TextSplit reads text from user and splits it into words
 *@version 1.0 29 Oct 2017
 *@author Kostantina Karagianni
 */

public class TextSplit {

	protected static void reader() {

		Scanner input = new Scanner(System.in);           //scanner object
		System.out.println("Γράψτε το κείμενό σας εδώ:");
		String text = input.nextLine();
	}
	protected static void splitIntoWords(String txt){

		String[] symbols={",","/","'",".","[","]","(",")","!","<",">",";",":","-"};
		String[] temp = txt.split(" ");
		String[] words;                                                             //Array for the separate words
		for (int i=0; i<symbols.length; i++) {
			words=splitString(temp, symbols[i]);
		}

	}
	    /**Splits string where symb is found*/
		protected static String[] splitString(String[] arr,String symb) {
			String[] splt=null;
			for (int i=0; i<arr.length; i++) {

				splt=arr[i].split(symb);
			}
			return splt;
		}
}