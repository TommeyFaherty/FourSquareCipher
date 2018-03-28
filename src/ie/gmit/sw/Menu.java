package ie.gmit.sw;

import java.util.Scanner;
import java.util.Random;

public class Menu {
	Scanner console = new Scanner(System.in);
	
	public void go() {
		int option = 0;
		String key1 = "";
		String key2 = "";
		char tpRight[][] = new char [5][5];
		char btmLeft[][] = new char [5][5];
		
		System.out.println("Welcome to the Four Square Cipher:");
		System.out.println("To randomly generate a key press 1\nor press 2 to enter your own");
		
		option = console.nextInt();
		
		System.out.println("You selected " + option);
		
		switch(option)
		{
		case 1:
			key1 = generateKey(key1);
			key2 = generateKey(key2);
			System.out.println(key1+"\n"+key2);

			break;
			
		case 2:
			System.out.print("Enter key1: ");
			key1 = console.nextLine();
			key1 = console.nextLine();
			while(key1.length() != 25)
			{
				System.out.println("There must be 25 characters, try again:");
				key1 = console.nextLine();
			}
			
			System.out.println("Enter key2: ");
			key2 = console.nextLine();
			while(key2.length() != 25)
			{
				System.out.println("There must be 25 characters, try again:");
				key2 = console.nextLine();
			}
			break;
		}
		
		tpRight = populateQuad(tpRight, key1);
		System.out.println();
		btmLeft = populateQuad(btmLeft, key2);
	}
	
	public static String generateKey(String key)
	{
		int array1[] = new int [25];
		String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		int rNum = -1;
		int n = alphabet.length();
		Random r = new Random();
		boolean checker = false;
		
		//Set all positions in array to 0
		for(int i=0 ;i<=24; i++)
		{
			array1[i] = 0;
		}
		
		for(int i=0; i<=24; i++)
		{
			while(checker == false)
			{
				rNum = r.nextInt(n);

				if(array1[rNum] == 0)
				{
					checker = true;
				}
			}	
			checker = false;
			array1[rNum] = 1;
			key += alphabet.charAt(rNum);
		}
		return key;
	}
	
	public static char[][] populateQuad(char array[][],String key)
	{
		int counter = 0;
		
		//Outer for loop
		for(int i=0;i<5;i++)
		{
			System.out.print("\n");
			//inner for loop
			for(int j=0;j<5;j++)
			{
				array[i][j] = key.toUpperCase().charAt(counter);
				counter++;
				System.out.print(array[i][j]);
			}
		}
		return array;
	}
}

