package getpageobjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;


public class ObjectProperties {
	static Map<String, Object> property;
	static String filepath = "src" + File.separator + "test" + File.separator + "resources" + File.separator
			+ "testdata" + File.separator + "data.yml";
	public static void initializeObjectProperty()
	 {
	  try {
	   Reader rd = new FileReader(filepath);
	   Yaml yaml = new Yaml();
	   property = (Map <String,Object> ) yaml.load(rd);
	   rd.close();
	  } catch (FileNotFoundException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	 }
	public static String getElementProperty(String objectstring)
	 {  
	Map<String,Object> map = (Map<String,Object>) property.get(objectstring.split("\\.")[0]); 
	  return map.get(objectstring.split("\\.")[0]).toString();

	 }
}
