package com.manuel.shipment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShipmentRepository {

	private List<Shipment> listShipment = new ArrayList<Shipment>();

	public void addShipment(Shipment shipment) {
		listShipment.add(shipment);
	}

	public boolean removeShipment(int shippingNumber) {
		Shipment shipment = getShipments().stream()
			.filter(s -> s.getnShipment() == shippingNumber)
			.findFirst()
			.orElse(null);

		listShipment.remove(shipment);

		return shipment != null;
	}
	
	/*
	 * int shippingNumber; boolean compairShipmentNumber(Shipment s) { return
	 * s.getnShipment() == shippingNumber; }
	 */
	
	public boolean updateState(int shippingNumber) {
		for (Shipment shipment : getShipments()) {
            if (shipment.getnShipment() == shippingNumber) {
                List<ShipmentStates> stateList = shipment.getStateList();

                if (stateList == null || stateList.isEmpty()) {
                    // Se la lista degli stati è vuota, imposta lo stato iniziale a "PRESA_IN_CARICO"
                    ShipmentStates initialState = new ShipmentStates(State.PRESA_IN_CARICO, LocalDate.now(), "Luogo Iniziale");
                   shipment.addState(initialState);
                } else {
                    // Altrimenti, attraversa la lista e passa allo stato successivo solo se non è già "CONSEGNATO"
                    ShipmentStates currentState = stateList.get(stateList.size() - 1);
                    if (currentState.getState() != State.CONSEGNATO) {
                        State nextState = getNextState(currentState.getState());
                        ShipmentStates nextStateObject = new ShipmentStates(nextState, LocalDate.now(), "Nuovo Luogo");
                        stateList.add(nextStateObject);
                    }
                }

                shipment.setStateList(stateList);
                return true;
            }
        }

        return false;
	}
	
	private State getNextState(State currentState) {
        switch (currentState) {
            case PRESA_IN_CARICO:
                return State.IN_TRANSITO;
            case IN_TRANSITO:
                return State.ARRIVATO_IN_FILIALE;
            case ARRIVATO_IN_FILIALE:
                return State.IN_CONSEGNA;
            case IN_CONSEGNA:
                return State.CONSEGNATO;
            default:
                return State.PRESA_IN_CARICO;  // Se non c'è lo stato
        }
	}
	
	public List<Shipment> getShipments() {
		return listShipment;
	}

}
