package com.manuel.shipment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShipmentRepository {

	private List<Shipment> listShipment = new ArrayList<Shipment>();

	public void addShipment(Shipment shipment) {
		listShipment.add(shipment);
	}

	public boolean removeShipment(int shippingNumber) {
		boolean shipmentFound = false;
		Iterator<Shipment> iterator = getShipments().iterator();

		while (iterator.hasNext()) {
			Shipment shipment = iterator.next();

			if (shipment.getnShipment() == shippingNumber) {
				shipmentFound = true;
				listShipment.remove(shipment);
				break;
			}
		}
		if (!shipmentFound) {
			shipmentFound = false;
		}
		return shipmentFound;
	}

	public List<Shipment> getShipments() {
		return listShipment;
	}

}
