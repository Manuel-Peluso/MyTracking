package com.manuel.shipment;

import java.time.LocalDate;

public class ShipmentStates {

	private State state;
	private LocalDate date;
	private String location;
	
	public ShipmentStates() {
		super();
	}

	public ShipmentStates(State state, LocalDate date, String location) {
		super();
		this.state = state;
		this.date = date;
		this.location = location;
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "ShipmentStates [state=" + state + ", date=" + date + ", location=" + location + "]";
	}
	
}
