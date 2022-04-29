package com.phonebook6_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookTest {
	public static String help_msg=	"Press:   -  A  Add contact  -  S  Search  - Q  Exit :";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> map=new HashMap<Integer,String>();
		
		System.out.println("\n\n** Welcome to MyPhone Book **\n\n");
		Scanner s=new Scanner(System.in);		
		for(;;){
				System.out.print("[Main Menu] "+help_msg+"\n:");
				String command=s.nextLine().trim();				
 
				//if (command.equalsIgnoreCase("H")){					
					//System.out.println(help_msg);
				if (command.equalsIgnoreCase("A")){
					System.out.print("Type in contact details in the format: name,phone\n:");
					String name=s.nextLine().trim();
					int num = s.nextInt();
					s.nextLine();
					addContact(name,num,map);
 
				}else if (command.equalsIgnoreCase("S")){
					System.out.print("Type in the name you are searching for :\n:");
					String name = s.nextLine();
					System.out.print(searchContact(name,map));
				}else if (command.equalsIgnoreCase("Q")){
					System.out.println("Good Bye User...");
					System.exit(0);
				}else{					
					System.out.print("Unknown command ! Try again \n:");
				}
		}
		
		   
	}
	public static void addContact(String name,int num,Map<Integer,String> map) {
	
		try {
			map.put(num, name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("invalid input, or duplicate number");
		}

	}
	
	public static int searchContact(String name,Map<Integer,String> map) {
		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			if(entry.getValue().equalsIgnoreCase(name)) {
				return entry.getKey();
			}
			
		}
		System.err.println("user not found");
			return -1;
		
	}
	
}