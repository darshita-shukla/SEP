package getpageobjects;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;

import org.testng.annotations.Test;


public class ObjectFileReader {
	static String filepath = "src" + File.separator + "test" + File.separator + "resources" + File.separator
			+ "pageObjectRepository" + File.separator + "LoginPage.txt";
	@Test
	public void FileReader() throws Exception {
		BufferedReader br;
		String matchingLine="";
		File file=new File(filepath);
		br=new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while(line.split(":",3)[1].equalsIgnoreCase("elementName")) {
			matchingLine=line;
		}
		System.out.print(matchingLine.split(":",3)[0]);
		
	}
	
}
