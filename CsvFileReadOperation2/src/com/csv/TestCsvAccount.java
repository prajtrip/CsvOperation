package com.csv;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TestCsvAccount {
 public static final String path="account.csv";
 public static Map<String,Double> mapFirstFile;
 public static Map<String,Double> mapSecondFile;
	public static void firstFile()throws Exception {
		
		List<Account> list=new ArrayList<>();
		File file=new File(path);
		Scanner scanner=new Scanner(file);
		scanner.next();
		while(scanner.hasNext())
		{
			String data=scanner.next();
			String[] str=data.split(",");
			Account account=new Account();
			account.setAccountNumber(str[0]);
			account.setTransactionValue(Double.parseDouble(str[1]));
			list.add(account);
		}
		
		mapFirstFile=list.stream().collect(Collectors.groupingBy(Account::getAccountNumber,Collectors.summingDouble(Account::getTransactionValue)));
		
		System.out.println(mapFirstFile);
	}
		
	public static void secondFile()throws Exception {
		
		List<Account> list=new ArrayList<>();
		File file=new File(path);
		Scanner scanner=new Scanner(file);
		scanner.next();
		while(scanner.hasNext())
		{
			String data=scanner.next();
			String[] str=data.split(",");
			Account account=new Account();
			account.setAccountNumber(str[0]);
			account.setTransactionValue(Double.parseDouble(str[1]));
			list.add(account);
		}
		
		mapSecondFile=list.stream().collect(Collectors.groupingBy(Account::getAccountNumber,Collectors.summingDouble(Account::getTransactionValue)));
		System.out.println(mapSecondFile);
		
	}
	public static boolean mapsAreEqual(Map<String, Double> mapA, Map<String, Double> mapB) {

	    try{
	        for (String k : mapB.keySet())
	        {
	            if (mapA.get(k).equals(mapB.get(k))) {
	                return false;
	            }
	        } 
	      
	    } catch (NullPointerException np) {
	        return false;
	    }
	    return true;
	}
	public static void main(String[] args) throws Exception {
		 firstFile();
		 secondFile();
		 boolean b = mapFirstFile.entrySet().stream().filter(value -> 
         mapSecondFile.entrySet().stream().anyMatch(value1 -> 
         (value1.getKey().equals(value.getKey()) && 
value1.getValue().equals(value.getValue())))).findAny().isPresent(); 
		 System.out.println(b);
		 if(b)
			 System.out.println("two file are equal");
		 else
			 System.out.println("not equal");
	
}
}
