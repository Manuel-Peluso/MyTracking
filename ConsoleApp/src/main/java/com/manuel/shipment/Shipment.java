package com.manuel.shipment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Shipment {

	private int nShipment;
	private String sender;
	private String recipient;
	private String destination;
	private String departure;
	private String dimension;
	private int weight;
	private String courier;
	private Date departureDate;
	private State state;

	public Shipment() {
		super();
	}

	public Shipment(int nShipment, String sender, String recipient, String destination, String departure,
			String dimension, int weight, String courier, Date departureDate, State state) {
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
		this.state = state;
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

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = (departureDate != null) ? sdf.format(departureDate) : "";
		return "Shipment [nShipment=" + nShipment + ", sender=" + sender + ", recipient=" + recipient + ", destination="
				+ destination + ", departure=" + departure + ", dimension=" + dimension + ", weight=" + weight
				+ ", courier=" + courier + ", departureDate=" + formattedDate + ", state=" + state + "]\n";
	}

}
