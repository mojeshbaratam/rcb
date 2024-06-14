package com.rcb.bean;

public class ShipBean 
{
	private String shipId;
	private String shipName;
	private int seatingCapacity;
	private int reservationCapacity;
	public String getShipId() {
		return shipId;
	}
	public void setShipId(String shipId) {
		this.shipId = shipId;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public int getReservationCapacity() {
		return reservationCapacity;
	}
	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}
	@Override
	public String toString() {
		return "\nshipId=" + shipId + ", shipName=" + shipName + ", seatingCapacity=" + seatingCapacity
				+ ", reservationCapacity=" + reservationCapacity;
	}
	
}
