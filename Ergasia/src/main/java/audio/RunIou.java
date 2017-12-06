package audio;
import javazoom.jl.player.*;
import java.io.FileInputStream;

public class RunIou {
	public static void playIou() {
		try{
			String filePath = "C:\\Users\\anton\\ant\\Ergasia\\javaiou.mp3";
			FileInputStream fis = new FileInputStream(filePath);
			Player playMP3 = new Player(fis);
            playMP3.play();

		} catch(Exception e) {
            System.out.println(e);
		}
	}
	public static void main(String[] args) {
		for(int i = 0 ; i < 10; i++) {
			playIou();
		}
	}
}
