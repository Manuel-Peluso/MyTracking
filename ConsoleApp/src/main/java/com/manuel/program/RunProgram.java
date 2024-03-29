package com.manuel.program;

import java.text.ParseException;
import java.util.Scanner;

import com.manuel.courier.Courier;
import com.manuel.courier.CourierRepository;
import com.manuel.shipment.Shipment;
import com.manuel.shipment.ShipmentRepository;
import com.manuel.shipment.ShipmentStateUpdateService;

public class RunProgram {
	private UserCommand uCommand;
	private ShipmentRepository shipmentRepo = new ShipmentRepository();
	private ShipmentStateUpdateService shipmentStateUpdateService = new ShipmentStateUpdateService(shipmentRepo);
	private Scanner scanner = new Scanner(System.in);
	private CourierRepository courierRepo = new CourierRepository();

	public void run() {
		boolean ripeti = false;
		int scelta = 0;
		// Esecuzione programma
		uCommand = new UserCommand(scanner, courierRepo);

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
					case 4:
						changeState();
						ripeti = true;
						break;
					case 5:
						addCourier();
						ripeti = true;
						break;
					case 6:
						removeCourier();
						ripeti = true;
						break;
					case 7:
						getCouriers();
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

	//Da sistemare OUTPUT
	public void removeShipment() {

		// Richiesta Utente
		int shippingNumber = uCommand.searchShipmentFromUser();

		// Rimossa da repository
		boolean isRemoved = shipmentRepo.removeShipment(shippingNumber);

		if (isRemoved) {
			System.out.println("Spedizione rimossa correttamente!");
		} else {
			System.out.println("Spedizione non trovata!");
		}

	}
	

	public void changeState() {
		int shippingNumber = uCommand.searchShipmentFromUser();

		boolean isChanged = shipmentStateUpdateService.updateState(shippingNumber);

		if (isChanged) {
			System.out.println("Stato aggiornato correttamente!");
		} else {
			System.out.println("Spdizione non trovata.");
		}

	}
	

	public void getShipments() {
		uCommand.printShipments(shipmentRepo.getShipments());
	}

	public void addCourier() {
		
		Courier c = uCommand.createCourierFromUser();
		courierRepo.addCourier(c);
		System.out.println("Corriere aggiunto!");

	}

	//Da sistemare OUTPUT
	public void removeCourier() {
		
		int idCourier = uCommand.searchCourierFromUser();
		
		boolean isRemoved = courierRepo.removeCourier(idCourier);
		
		if (isRemoved) {
			System.out.println("Corriere rimosso correttamente!");
		} else {
			System.out.println("Corriere non trovato!");
		}
		
	}
	
	public void getCouriers() {
		uCommand.printCouriers(courierRepo.getCouriers());
	}
	
}
