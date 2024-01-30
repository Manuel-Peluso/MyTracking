package com.manuel.shipment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.manuel.courier.Courier;

public class Shipment {

	private int nShipment;
	private String sender;
	private String recipient;
	private String destination;
	private String departure;
	private String dimension;
	private int weight;
	private Courier courier;
	private Date departureDate;
	private List<ShipmentStates> stateList;

	public Shipment() {
		super();
	}

	public Shipment(int nShipment, String sender, String recipient, String destination, String departure,
			String dimension, int weight, Courier courier, Date departureDate, List<ShipmentStates> stateList) {
		super();
		this.nShipment = nShipment;
		this.sender = sender;
		this.recipient = recipient;
		this.destination = destination;
		this.departure = departure;
		this.dimension = dimension;
		this.weight = weight;
		this.courier = courier;
		this.departureDate = departureDate;
		this.stateList = new ArrayList<ShipmentStates>();
	}

	public int getnShipment() {
		return nShipment;
	}

	public void setnShipment(int nShipment) {
		this.nShipment = nShipment;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Courier getCourier() {
		return courier;
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public List<ShipmentStates> getStateList() {
		return stateList;
	}

	public void setStateList(List<ShipmentStates> stateList) {
		this.stateList = stateList;
	}

	public void addState(ShipmentStates state) {
		stateList.add(state);
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = (departureDate != null) ? sdf.format(departureDate) : "";
		return "Shipment [nShipment=" + nShipment + ", sender=" + sender + ", recipient=" + recipient + ", destination="
				+ destination + ", departure=" + departure + ", dimension=" + dimension + ", weight=" + weight
				+ ", courier=" + courier + ", departureDate=" + formattedDate + ", state=" + stateList + "]\n";
	}

}
