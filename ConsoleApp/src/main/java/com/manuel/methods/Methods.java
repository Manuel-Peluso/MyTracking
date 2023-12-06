package com.manuel.methods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.manuel.view.Shipment;

public class Methods {
	
	List<Shipment> listShipments = new ArrayList<>();
	
	public void addShipment() {
		
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		Scanner sc5 = new Scanner(System.in);
		Scanner sc6 = new Scanner(System.in);
		Scanner sc7 = new Scanner(System.in);
		Scanner sc8 = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Shipment s = new Shipment();
			System.out.println("Inserisci il numero di spedizione:");
			s.setnShipment(sc.nextInt());
			System.out.println("Inserisci il mittente:");
			s.setSender(sc1.nextLine());
			System.out.println("Inserisci il destinatario:");
			s.setRecipient(sc2.nextLine());
			System.out.println("Inserisci la destinazone:");
			s.setDestination(sc3.nextLine());
			System.out.println("Inserisci il luogo di partenza:");
			s.setDeparture(sc4.nextLine());
			System.out.println("Inserisci le dimensioni:");
			s.setDimension(sc5.nextLine());
			System.out.println("Inserisci il peso:");
			s.setWeight(sc6.nextInt());
			System.out.println("Inserisci il corriere:");
			s.setCourier(sc7.nextLine());
			System.out.println("Inserisci la data di spedizione:");
			String departureDate = sc8.nextLine();
			Date parsedDate = sdf.parse(departureDate);
			s.setDepartureDate(parsedDate);
			sc.close();
			sc1.close();
			sc2.close();
			sc3.close();
			sc4.close();
			sc5.close();
			sc6.close();
			sc7.close();
			sc8.close();
			listShipments.add(s);
			System.out.println("Spedizione aggiunta!");
		} catch (ParseException e) {
			e.printStackTrace();
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
