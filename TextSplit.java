/*
 *TextSplit
 *
 *Copyright 2017 Karagianni/team java autocorrect
 */

import java.util.*;
import java.util.ArrayList;
import java.util.List;
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
		String text = input.nextLine();                  //user's text


	}
	protected static void splitIntoWords(String txt){

		ArrayList<String> words = new ArrayList<String>();
		String[] a;
		a = txt.split(" ");

		for (int i=0; i<a.length; i++) {

			words.add(a[i]);
		}
		char[] symb = {',','.','<','>','?',':',';','\'','"','(',')','{','}','[',']','/','\\','!','@','%','$','#','&','*','~','-','_','`','+','=','0','1','2','3','4','5','6','7','8','9'};

		for (int i = 0; i<words.size(); i++) {
			for (int j = 0; j<words.get(i).length(); j++) {
				for (int z = 0;  z<symb.length; z++) {

					if (words.get(i).charAt(j) == symb[z]) {

						String[] splt = words.get(i).split(String.valueOf(symb[z]));
						words = moveWords(words,i,splt[0],splt[1]);
						break;
					}
				}
			}
		}
	}
	protected static ArrayList<String> moveWords(ArrayList<String> arr,int pointer,String word1,String word2) {

		for(int i = arr.size()+1; i>pointer+1; i--) {

			arr.add(i,arr.get(i-1));
		}
		arr.add(pointer,word1);
		arr.add(pointer+1,word2);
		return arr;
	}



}