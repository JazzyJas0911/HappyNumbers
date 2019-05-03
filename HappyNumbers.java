/* Jasmin Agustin
 * CECS 274 - 05
 * Project 3 - Happy Numbers
 * 10/18/2016
 */

import java.util.ArrayList;
import java.util.Scanner;
public class HappyNumbers {
	
	static ArrayList <Integer> List = new ArrayList<Integer>();

	public static void main(String[] args) {
		int Choice = 0;
		Scanner keyboard = new Scanner(System.in);
		while(Choice != 3){
			Choice = Menu();
			switch (Choice){
				case 1:
					System.out.println("Please enter a positive number.");
					int number = positiveNumber();
					int temp = number;
					while(!inHappyList(temp, List) && !isHappy(temp)){
						List.add(temp);
						temp = SumOfDigitsSquared(temp);
					}
					List.add(temp); 
					displayList(temp);
					List.clear();
					break;
				case 2:
					System.out.println("Please enter 2 integers and I will output the Happy Numbers between those numbers.");
					System.out.print("Number 1: ");
					int num1 = positiveNumber();
					System.out.print("Number 2: ");
					int num2 = positiveNumber();
					displayRange(num1, num2);
					System.out.println("\n");
					break;
				case 3:
					System.out.println("You have chosen to exit the code.");
					break;
				default:
					System.out.println("Error. Invalid input please try again.");
					break;
			}
		}
		
	}//end of main
	
	public static int Menu(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Menu:\n"
			+ "1. Show Happy Sequence for a number\n"
			+ "2. Show all Happy Numbers in a range\n"
			+ "3. Exit\n");
		int UserInput = keyboard.nextInt();
		return UserInput;
	}
	
	public static int positiveNumber(){
		Scanner keyboard = new Scanner(System.in);
		int positive = 0;
		while(positive < 1){
			positive = keyboard.nextInt();
			if(positive < 1)
				System.out.println("Error. Please enter a positive number.");
		}
		return positive;
	}
	
	public static boolean isHappy(int x){
		boolean happy = false;
		if (x == 1)
			happy = true;
		return happy;
	}
	
	public static boolean inHappyList(int x, ArrayList <Integer> List){
		return List.contains(x);
	}
	
	public static int SumOfDigitsSquared(int x){
		if(x < 10)
			return x * x;
		else
			return SumOfDigitsSquared(x / 10) + SumOfDigitsSquared(x % 10);
	}
	
	public static void displayList(int x){
		System.out.println("List: " + List);
		if(isHappy(x) == true)
			System.out.println(" - Happy\n");
		else
			System.out.println(" - Not Happy\n");
	}
	
	public static void displayRange(int x, int y){
		int counter = 0;
		while(x <= y){
			int temp = x;
			int nIntegers = x;
			while(!inHappyList(temp, List) && !isHappy(temp)){
				List.add(temp);
				temp = SumOfDigitsSquared(temp);
			}
			if(isHappy(temp) == true){
				System.out.print(x);
				while(nIntegers > 0){
					nIntegers = nIntegers / 10;
					counter++;
				}
			}
			else{
				System.out.print(".");
				counter++;
			}
			List.clear();
			if (counter > 74){
				counter = 0;
				System.out.println();
			} 
			x++;
		}
	}

}//end of class