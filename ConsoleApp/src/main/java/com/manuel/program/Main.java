package com.manuel.program;

import java.text.ParseException;
import java.util.Scanner;

import com.manuel.shipment.Shipment;
import com.manuel.shipment.ShipmentRepository;

public class Main {
	private static ShipmentRepository shipmentRepo = new ShipmentRepository();
	private static boolean ripeti;
	private static int scelta = 0;
	private static UserCommand uCommand;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Esecuzione programma
		uCommand = new UserCommand(scanner);

		try {
			do {

				scelta = uCommand.menu();
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
			// Richiesta utente
			Shipment s = uCommand.createShipmentFromUser();

			// Aggiunta a repository
			shipmentRepo.addShipment(s);
			
			System.out.println("Spedizione aggiunta!");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public static void getShipments() {
		uCommand.printShipments(shipmentRepo.getShipments());
	}

	
	

}
