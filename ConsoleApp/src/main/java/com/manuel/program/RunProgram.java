package com.manuel.program;

import java.text.ParseException;
import java.util.Scanner;

import com.manuel.shipment.Shipment;
import com.manuel.shipment.ShipmentRepository;

public class RunProgram {
	private UserCommand uCommand;
	private ShipmentRepository shipmentRepo = new ShipmentRepository();

	public void run() {
		boolean ripeti = false;
		int scelta = 0;
		Scanner scanner = new Scanner(System.in);
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
	
	public void getShipments() {
		uCommand.printShipments(shipmentRepo.getShipments());
	}
	
}
