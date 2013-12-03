package com.server.tellme.entity;

import java.io.Serializable;

public class UserLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1996729894538778495L;
	public Gps gps;
	public Cell cell;
	public NetWork network;
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
