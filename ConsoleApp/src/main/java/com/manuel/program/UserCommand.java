package com.manuel.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.manuel.courier.Courier;
import com.manuel.shipment.Shipment;
import com.manuel.shipment.ShipmentStates;

public class UserCommand {
	private Scanner scanner = new Scanner(System.in);
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public UserCommand(Scanner scanner) {
		this.scanner = scanner;
	}

	private int chiose(String s) {
		int n = 0;
		boolean flag;
		do {
			flag = false;
			try {
				n = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println(e);
				flag = true;
			}
		} while (flag);
		return n;
	}

	public int menu() {
		System.out.println("***MENU***\n1- Aggiungi spedizione \n2- Lista spedizioni \n3- Rimuovi spedizione \n4- Cambia stato spedizione \n5- Aggiungi corriere \n6- Rimuovi corriere \n7- Lista corrieri \n0- Esci");
		return (chiose("Scegli:"));
	}

	public Shipment createShipmentFromUser() throws ParseException {
		Shipment s = new Shipment();

		System.out.println("Inserisci il numero di spedizione:");
		s.setnShipment(scanner.nextInt());
		scanner.nextLine();

		System.out.println("Inserisci il mittente:");
		s.setSender(scanner.nextLine());

		System.out.println("Inserisci il destinatario:");
		s.setRecipient(scanner.nextLine());

		System.out.println("Inserisci la destinazione:");
		s.setDestination(scanner.nextLine());

		System.out.println("Inserisci il luogo di partenza:");
		s.setDeparture(scanner.nextLine());

		System.out.println("Inserisci le dimensioni:");
		s.setDimension(scanner.nextLine());

		System.out.println("Inserisci il peso:");
		s.setWeight(scanner.nextInt());
		scanner.nextLine();

		System.out.println("Inserisci il corriere:");
		s.setCourier(scanner.nextLine());

		System.out.println("Inserisci la data di spedizione (formato dd-MM-yyyy):");
		String departureDate = scanner.nextLine();
		Date parsedDate = sdf.parse(departureDate);
		s.setDepartureDate(parsedDate);
		
		s.setStateList(new ArrayList<ShipmentStates>());

		return s;
	}

	public int searchShipmentFromUser() {
		System.out.println("Inserisci il numero della spedizione da cercare:");
		int shippingNumber = scanner.nextInt();
		scanner.nextLine();
		return shippingNumber;
	}

	public void printShipments(List<Shipment> shipments) {
		System.out.println("Lista spedizioni: \n" + shipments);
	}
	
	public Courier createCourierFromUser() {
		Courier c = new Courier();
		
		System.out.println("Inserisci l'id del corriere:");
		c.setId(scanner.nextInt());
		scanner.nextLine();

		System.out.println("Inserisci il nome del corriere:");
		c.setNome(scanner.nextLine());

		System.out.println("Inserisci l'url del sito del corriere:");
		c.setUrl(scanner.nextLine());
		
		return c;
	}

	public int searchCourierFromUser() {
		System.out.println("Inserisci l'id del corriere da cercare:");
		int idCourier = scanner.nextInt();
		scanner.nextLine();
		return idCourier;
	}

	public void printCouriers(List<Courier> couriers) {
		System.out.println("Lista corrieri: \n" + couriers);
	}
	
}
