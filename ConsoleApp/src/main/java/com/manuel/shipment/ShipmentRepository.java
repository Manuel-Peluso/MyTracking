package com.manuel.shipment;

import java.util.ArrayList;
import java.util.List;

public class ShipmentRepository {

	private List<Shipment> listShipment = new ArrayList<Shipment>();

	public void addShipment(Shipment shipment) {
		listShipment.add(shipment);
	}

	public boolean removeShipment(int shippingNumber) {
		
		return listShipment.remove(getShipmentbyNumber(shippingNumber));

	}
	
	/*
	 * int shippingNumber; boolean compairShipmentNumber(Shipment s) { return
	 * s.getnShipment() == shippingNumber; }
	 */
	
	public List<Shipment> getShipments() {
		return listShipment;
	}

	public Shipment updateShipment(Shipment shipment) {
		
		Shipment shipment2 = getShipmentbyNumber(shipment.getnShipment());
		
		shipment2.setCourier(shipment.getCourier());
		shipment2.setDeparture(shipment.getDeparture());
		shipment2.setDepartureDate(shipment.getDepartureDate());
		shipment2.setDestination(shipment.getDestination());
		shipment2.setDimension(shipment.getDimension());
		shipment2.setnShipment(shipment.getnShipment());
		shipment2.setRecipient(shipment.getRecipient());
		shipment2.setSender(shipment.getSender());
		shipment2.setStateList(shipment.getStateList());
		shipment2.setWeight(shipment.getWeight());
		
		return shipment2;
	}
	
	public Shipment getShipmentbyNumber(int shippingNumber) {
		Shipment shipment = getShipments().stream()
				.filter(s -> s.getnShipment() == shippingNumber)
				.findFirst()
				.orElse(null);
		return shipment;
	}

}
