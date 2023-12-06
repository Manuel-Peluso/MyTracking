package com.manuel.model;

import java.util.Date;

public class Shipment {
	
	String sender;
	String recipient;
	String destination;
	String departure;
	String dimension;
	int weight;
	String courier;
	Date departureDate;
	
	public Shipment() {
		super();
	}

	public Shipment(String sender, String recipient, String destination, String departure, String dimension, int weight,
			String courier, Date departureDate) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.destination = destination;
		this.departure = departure;
		this.dimension = dimension;
		this.weight = weight;
		this.courier = courier;
		this.departureDate = departureDate;
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

	@Override
	public String toString() {
		return "Shipment [sender=" + sender + ", recipient=" + recipient + ", destination=" + destination
				+ ", departure=" + departure + ", dimension=" + dimension + ", weight=" + weight + ", courier="
				+ courier + ", departureDate=" + departureDate + "]";
	}	
	
}
