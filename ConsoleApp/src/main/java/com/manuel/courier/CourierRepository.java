package com.manuel.courier;

import java.util.ArrayList;
import java.util.List;

public class CourierRepository {

	private List<Courier> listCourier = new ArrayList<Courier>();
	
	public List<Courier> getCouriers() {
		return listCourier;
	}
	
	public void addCourier(Courier courier) {
		listCourier.add(courier);		
	}
	
	public boolean removeCourier(int id) {
		listCourier.remove(getCourierById(id));
		return getCourierById(id) != null;
	}

	public Courier getCourierById(int id) {
		Courier courier = getCouriers().stream()
				.filter(c -> c.getId() == id)
				.findFirst()
				.orElse(null);
		return courier;
	}
	
}
