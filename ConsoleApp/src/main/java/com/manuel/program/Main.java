package com.manuel.program;

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
	private static boolean ripeti;
	private static int scelta = 0;

	public static void main(String[] args) {

		try {
			do {

				scelta = menu();
				{
					switch (scelta) {
					case 1:
						addShipment();
						ripeti = true;
						break;
					case 2:
						getShipments();
						ripeti = true;
						break;
					case 3:
						System.out.println("Arrivederci");
						ripeti = false;
						break;
					}
				}

			} while (ripeti);
		} finally {
			scanner.close();
		}

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
		}

	}

	public static void getShipments() {
		System.out.println("Lista spedizioni: \n" + shipmentRepo.getShipments());
	}

	public static int chiose(String s) {
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

	public static int menu() {

		System.out.println("***MENU***\n1- Aggiungi spedizione \n2- Lista spedizioni \n3- Esci");
		return (chiose("Scegli:"));
	}
}
