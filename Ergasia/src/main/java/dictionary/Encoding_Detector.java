package dictionary;
import java.io.FileInputStream;

import org.mozilla.universalchardet.UniversalDetector;

/**
 *class Encoding_Detector reads text from user and splits it into words
 *@version 1.0 29 Oct 2017
 *@author Kostantina Karagianni
 */

public class Encoding_Detector {
	 public static String encoding_Detector(String path) throws java.io.IOException {
		 byte[] buf = new byte[4096];
		
		 String fileName = path;
		 FileInputStream fis = new FileInputStream(fileName);

		 UniversalDetector detector = new UniversalDetector(null);
			
		 int nread;
		 while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
			 detector.handleData(buf, 0, nread);
		 }
		 fis.close();
		 detector.dataEnd();
		
		 String encoding = detector.getDetectedCharset();
		 detector.reset();
		 if (encoding != null) {
			return encoding;
		 } else {
			return null;
		 }	
	 }
	 
}
