public class findLanguage2 {
	findLanguage fl = new findLanguage();
	String alphabeten[] = {"a","b","c","d","e","f","g","h","i","j'","k","l","m","n","o","p","q","r","s","t'","u","v","w","x","y","z"};
	String alphabetgr[] = {"á","â","ã","ä","å","æ","ç","è","é","ê","ë","ì","í","î","ï","ð","ñ","ó","ô","õ","ö","÷","ø","ù","Ü","Ý","ß","ü","Þ","ý","þ","ú","û","ò"};
	public int fLang(int j){
		String letter= fl.getFirtLetter(j);
		int i=0;
		int flag=0;
		while(letter != alphabeten[i] && i<alphabeten.length ){
			i++;
		}
		if (letter==alphabeten[i]){
			flag=1;
			}
		i=0;
		while(letter != alphabetgr[i] && i<alphabetgr.length ){
			i++;
		}
		if (letter==alphabeten[i]){
			flag=2;
			}
			return flag;
	}
	TextSplit te = new TextSplit();
	private int words = te.arrayLength();
	int [] languages = new int[words];
	public void createArrayLang(){
		for(int i=0;i<words;i++){
		languages[i] = fLang(i);
		}
	}
	public int getArrayLang(int i){
		return languages[i];
		}

}