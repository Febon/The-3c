package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class Read {
	public static void read(String filePath){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(filePath)));
		    String line;
		    while ((line = br.readLine()) != null) {
				
		    }
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
