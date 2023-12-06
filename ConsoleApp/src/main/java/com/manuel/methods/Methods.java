package com.manuel.methods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.manuel.view.Shipment;

public class Methods {

	private List<Shipment> listShipments = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public void addShipment() {

		try {
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

			listShipments.add(s);
			System.out.println("Spedizione aggiunta!");
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

	public void getShipments() {
		System.out.println("Lista spedizioni:");
		for (int i = 0; i < listShipments.size(); i++) {
			Shipment s = listShipments.get(i);
			System.out.println(s.toString());
		}
	}

}
