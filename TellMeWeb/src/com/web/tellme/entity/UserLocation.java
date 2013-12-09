package com.web.tellme.entity;

import java.io.Serializable;

public class UserLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1996729894538778495L;
	public enum LocationType{Gps,Cell,NetWork};
	public Gps gps;
	public long sendtime;
	public Cell cell;
	public NetWork network;
	public LocationType locaty;
	public long getSendtime() {
		return sendtime;
	}
	public void setSendtime(long sendtime) {
		this.sendtime = sendtime;
	}
	public LocationType getLocaty() {
		return locaty;
	}
	public void setLocaty(LocationType locaty) {
		this.locaty = locaty;
	}
	public Gps getGps() {
		return gps;
	}
	public void setGps(Gps gps) {
		this.gps = gps;
	}
	public Cell getCell() {
		return cell;
	}
	public void setCell(Cell cell) {
		this.cell = cell;
	}
	public NetWork getNetwork() {
		return network;
	}
	public void setNetwork(NetWork network) {
		this.network = network;
	}


}
