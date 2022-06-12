package java8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesJava8 {
	
	public static void main(String[] args) throws IOException {
		Files.list(Paths.get("."))
        .forEach(System.out::println);
		
		System.out.println("----------------");
		
		Files.list(Paths.get("."))
        .filter(Files::isRegularFile)
        .forEach(System.out::println);
		
		System.out.println("----------------");
		
		Files.newDirectoryStream(Paths.get("."))
        .forEach(System.out::println);
		System.out.println("----------------");
		
		Path path = Paths.get("output.txt");
		 
		//Use try-with-resource to get auto-closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(path))
		{
		    writer.write("Hello World2 !!");
		}
		
		String content = "Hello World !!";
		 
		Files.write(Paths.get("output2.txt"), content.getBytes());

	}

}
