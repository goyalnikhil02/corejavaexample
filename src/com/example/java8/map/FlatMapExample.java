package com.example.java8.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlatMapExample {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("C:\\Users\\Administrator\\Documents\\workspace-sts-3.9.5.RELEASE\\CoreJavaPractice\\src\\com\\example\\java8\\map\\data.txt");

		printUniqueWords(path);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>");
		printUniqueWordsUsingFlatMap(path);
		
		

	}

	private static void printUniqueWordsUsingFlatMap(Path path) throws IOException {
		int count=(int) Files.lines(path).map( e -> e.split("\\s+") )  
				//Returns a stream consisting of the results of applying the given function to the elements of this stream. 
				//Returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.
				//Each mapped stream is closed after its contents have been placed into this stream. (If a mapped stream is null an empty stream is used, instead.) 


		.flatMap(Arrays:: stream)
		.distinct()
		.count();		
		System.out.println(count);
		
		//.forEach(System.out::println);
	}

	private static void printUniqueWords(Path path) {
		Set<String> setoFwords = new HashSet<>();
		try {
			List<String> lines = Files.readAllLines(path);
			for (String line : lines) {
				String[] words = line.split("\\s+");
				for (String word : words) {
					setoFwords.add(word);
				}
				setoFwords.forEach(System.out::println);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
