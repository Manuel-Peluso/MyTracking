package com.manuel.program;

import java.text.ParseException;
import java.util.Scanner;

import com.manuel.shipment.Shipment;
import com.manuel.shipment.ShipmentRepository;

public class RunProgram {
	private UserCommand uCommand;
	private ShipmentRepository shipmentRepo = new ShipmentRepository();
	private Scanner scanner = new Scanner(System.in);

	public void run() {
		boolean ripeti = false;
		int scelta = 0;
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
						removeShipment();
						ripeti = true;
						break;
					case 0:
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

	public void addShipment() {

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

	public void removeShipment() {
		System.out.println("Inserisci il numero della spedizione da rimuovere:");
		int shippingNumber = scanner.nextInt();
		scanner.nextLine();
		for (Shipment shipment : shipmentRepo.getShipments()) {
			if (shipment.getnShipment() == shippingNumber) {
				shipmentRepo.removeShipment(shipment);
				System.out.println("Spedizione rimossa!");
			} else {
				System.out.println("Spedizione non trovata!");
			}
		}
	}

	public void getShipments() {
		uCommand.printShipments(shipmentRepo.getShipments());
	}

}