package com.manuel.shipment;

import java.util.ArrayList;
import java.util.List;

public class ShipmentRepository {
	
	private List<Shipment> listShipment = new ArrayList<Shipment>();
	
	public void addShipment(Shipment shipment) {
		listShipment.add(shipment);
	}
	
	public void removeShipment(Shipment shipment) {
		listShipment.remove(shipment);
	}
	
	public List<Shipment> getShipments() {
		return listShipment;
	}

}
