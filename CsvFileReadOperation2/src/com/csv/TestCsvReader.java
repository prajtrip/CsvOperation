package com.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestCsvReader {

	public static void main(String[] args) throws FileNotFoundException {
		String Path="book.csv";
		File file=new File(Path);
		Scanner inputstream=new Scanner(file);
		inputstream.next();
		Map<String, String> map=new HashMap<>();
		while(inputstream.hasNext())
		{
			String data=inputstream.next();
			String[] str=data.split(",");
			
			
			map.put(str[0], str[2]);
		}
		System.out.println(map);
		System.out.println("prajanu");

	}

}
