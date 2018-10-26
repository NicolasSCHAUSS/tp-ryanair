package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Flight;
import model.Plane;

public class FlightDAO extends GenericDAO<Flight> {

	public FlightDAO() {
		super(Flight.class);
		
		create(new Flight("0001",Plane.A330,"Montpellier","Paris",LocalDate.of(2018, 10, 25)));
		create(new Flight("0002",Plane.A380,"Montpellier","Toulouse",LocalDate.of(2018, 10, 26)));
		create(new Flight("0003",Plane.B747,"Paris","Toulouse",LocalDate.of(2018, 10, 27)));
	}
	
	public Flight findByNumero(String num)
	{
		EntityManager em = DatabaseHelper.createEntityManager();
		
		TypedQuery<Flight> query = em.createQuery("FROM Flight f WHERE f.number=:n", Flight.class);
		query.setParameter("n", num);
		return query.getSingleResult();
	}
	
	public List<Flight> findByCity(String cityD,String cityA)
	{
		EntityManager em = DatabaseHelper.createEntityManager();
		
		TypedQuery<Flight> query = em.createQuery("FROM Flight f WHERE f.departureCity=:cD AND f.arrivalCity=:c", Flight.class);
		query.setParameter("cD", cityD);
		query.setParameter("cA", cityA);
		
		return query.getResultList();
	}

	public void choiceFromConsole(Scanner scan) {
		boolean exit = false;
		while(exit!=true)
		{
			String leftAlignFormat = "| %-6s | %-52s |%n";
			String fonctions[] = {"Création d’un vol",
									"Liste des vols",
									"Rechercher un avion par numéro",
									"Rechercher un avion par ville de départ et d’arrivée",
									"Retour au menu principal"};
			System.out.format("+--------+------------------------------------------------------+%n");
			System.out.format("| Choice | Fonction name                                        |%n");
			System.out.format("+--------+------------------------------------------------------+%n");
			for (int i = 0; i < fonctions.length; i++) {
			    System.out.format(leftAlignFormat, (i+1)+")", fonctions[i]);
			}
			System.out.format("+--------+------------------------------------------------------+%n");

			int choice = scan.nextInt();
			
			switch (choice)
			{
				case 1:
					Flight f = new Flight();
					System.out.print("Numero de vol :");
					f.setNumber(scan.next());
					System.out.print("Avion (A330,A340,B747,A380):");
					f.setPlane(scan.next());
					System.out.print("Ville de depart :");
					f.setArrivalCity(scan.next());
					System.out.print("Ville d'arrivée :");
					f.setDepartureCity(scan.next());
					System.out.print("Date de depart, année :");
					int y = scan.nextInt();
					System.out.print("Date de depart, mois :");
					int m = scan.nextInt();
					System.out.print("Date de depart, jour :");
					int d = scan.nextInt();
					f.setDepartureDate(LocalDate.of(y, m, d));
					create(f);
					break;
				case 2:
					System.out.println("Liste des vols :");
					System.out.println("Numéro | Type | Place | Départ | Arrivé | Date");
					for(Flight i: findAll())
					{
						System.out.println(i);
					}
					break;
				case 3:
					System.out.print("Recherche depuis numero :");
					System.out.println(findByNumero(scan.next()));
					break;
				case 4:
					System.out.println("Recherche depuis Depart/Destination :");
					System.out.print("Ville de depart :");
					String cD = scan.next();
					System.out.print("Ville de arrivée :");
					String cA = scan.next();
					System.out.println(findByCity(cD, cA));
					break;
				case 5:
					exit = true;
					break;
				default:
					System.out.println("Choix impossible !");
					break;
			}
		}
	}

}
