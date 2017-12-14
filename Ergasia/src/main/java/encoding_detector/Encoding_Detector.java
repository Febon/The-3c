package encoding_detector;
import java.io.FileInputStream;

import org.mozilla.universalchardet.UniversalDetector;

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
