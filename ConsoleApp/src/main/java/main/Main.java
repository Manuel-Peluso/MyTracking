package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.manuel.shipment.Shipment;
import com.manuel.shipment.ShipmentRepository;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private static ShipmentRepository shipmentRepo = new ShipmentRepository();

	public static void main(String[] args) {

		addShipment();
		getShipments();

	}

	public static void addShipment() {

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

			shipmentRepo.addShipment(s);
			System.out.println("Spedizione aggiunta!");
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

	public static void getShipments() {
		System.out.println("Lista spedizioni: \n" + shipmentRepo.getShipments());
	}

}
