//Add word "lathos" in array list.
import java.util.ArrayList;
public class AddLathos {
	//ArrayList<String> keimeno = new ArrayList<String>();
	String j = "-LATHOS-";
	public void addWord(boolean t, ArrayList<String> keimeno,String word) {
		for(int i = 0; i < keimeno.size(); i++) {
			if(t == false) {
				keimeno.set(i,word+j);
			}
		}
	}
}

//Ousiastika i set xrisimopiite gia na kamei update to excisting word me ti leksi Lathos dipla tou,xoris na ayksanetai h lista.