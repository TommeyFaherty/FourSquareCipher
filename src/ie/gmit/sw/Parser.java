package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	
	public void parse(String res) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(res));
			
			String line;
			while((line = br.readLine()) != null) {
				line = line.toUpperCase().replaceAll("[^A-Z]", "");
				System.out.println(line);
			}
			br.close();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
