package dictionary;

public class findLanguage{
	private static String alphabetEn[] = {"a","b","c","d","e","f","g","h","i","j'","k","l","m","n","o","p","q","r","s","t'","u","v","w","x","y","z"};
	private static String alphabetGr[] = {"á", "â", "ã", "ä", "å", "æ", "ç", "è", "é", "ê", "ë", "ì", "í", "î", "ï", "ð", "ñ", "ó", "ô", "õ", "ö", "÷", "ø", "ù", "Ü", "Ý", "ß", "ü", "Þ", "ý", "þ", "ú", "À", "û", "à", "ò"};

	public static void main(String[] args) {
		System.out.println(findLang());
	}
	public static String findLang(){
		String letter= "a";
				//TextSplit.textForCorrection.get((int)Math.random() * TextSplit.textForCorrection.size()).substring(0, 1);
		int i=0;
		String flag="Language not supported";
		while(i<alphabetEn.length && flag == "Language not supported" ){

			if (letter.equals(alphabetEn[i])){
				flag="English";
			}
			i++;
		}
		i=0;

		while(i<alphabetGr.length && flag == "Language not supported"  ){
			if (letter.equals(alphabetGr[i])){
				flag="Greek";
			}
			i++;
		}
			return flag;
	}

}
