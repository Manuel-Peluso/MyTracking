package com.manuel.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.manuel.shipment.Shipment;

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
		System.out.println("***MENU***\n1- Aggiungi spedizione \n2- Lista spedizioni \n3- Esci");
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
		
		return s;
	}	
	
	public void printShipments(List<Shipment> shipments) {
		System.out.println("Lista spedizioni: \n" + shipments);
	}
}
