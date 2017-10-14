import java.util.*;

public class TestingLike {
	public static void main(String[] args) {
		String word;
		int i;
		Scanner sc= new Scanner(System.in);
		String[] a={"p","o","p","c","o","r","n"};
		while (true) {

			System.out.println("Word:");
			word =sc.nextLine();

			if (word.equals("popa")) {
				break;
			}
			for (i=0;i<5;i++){
				if (word.matches(".*"+a[i]+".*"+a[i+1]+".*"+a[i+2]+".*")) {
					System.out.println(a[i] + a[i+1] + a[i+2]);
				}
			}
			if (word.equals("ant")) {
				System.out.println("yayX2");
			}

		}


	}
	public static boolean like( String givenWord, String vocabularyWord){
		boolean sameWord=false;

		if (givenWord.matches(".*a.*n.*t.*")) {
			System.out.println("yay");
		}
		return sameWord;
	}
}