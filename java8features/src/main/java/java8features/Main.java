package java8features;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.stream.Stream;



public class Main {
	public static void main(String args[]) throws FileNotFoundException{
		
	    URL url = Main.class.getClassLoader().getResource("ram.txt");
		File file = new File(url.getPath());
		System.out.println(".....:"+file.getAbsolutePath());
		FileReader reader = new FileReader(file);
		try (BufferedReader bufferedReader = new BufferedReader(reader);){
			Stream<String> lines = bufferedReader.lines();
			lines.forEach(System.out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}