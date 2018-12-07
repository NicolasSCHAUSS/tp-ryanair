package main;

import java.util.Scanner;

import dao.BookingDAO;
import dao.FlightDAO;
//import dao.PassengerDAO;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		FlightDAO fdao = new FlightDAO();
		BookingDAO bdao = new BookingDAO();
		//PassengerDAO pdao = new PassengerDAO();
		
		boolean exit = false;
		while(exit!=true)
		{
			String leftAlignFormat = "| %-6s | %-24s |%n";
			String fonctions[] = {"Gestion des vols","Gestion des réservations","Quitter"};
			System.out.format("+--------+--------------------------+%n");
			System.out.format("| Choice | Fonction name            |%n");
			System.out.format("+--------+--------------------------+%n");
			for (int i = 0; i < fonctions.length; i++) {
			    System.out.format(leftAlignFormat, (i+1)+")", fonctions[i]);
			}
			System.out.format("+--------+--------------------------+%n");
			int choice = scan.nextInt();
			switch (choice)
			{
				case 1:
					fdao.choiceFromConsole(scan);
					break;
				case 2:
					bdao.createFromConsole();
					break;
				case 3:
					exit = true;
					break;
				default:
					System.out.println("Choice not possible !");
					break;
			}
		}
		
		
		scan.close();
	}

}
