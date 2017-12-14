package audio;
import javazoom.jl.player.*;
import java.io.FileInputStream;

/**
 * class RunIou contains a method that utilizes the javazoom libraries
 * which are used to run mp3 files.
 * version 0.1 Dec 11 2017
 * Authors: Antonis Liadopoulos(AM:8160060) and Maria Kassita(AM:8160041)
 */

public class RunIou {
	
	/**
	 * This method is used to run the mp3 contained in the specified file path usind
	 * classes contained in the javazoom library
	 */
	
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
}
