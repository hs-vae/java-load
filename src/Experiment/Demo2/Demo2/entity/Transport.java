/**   
 * @公司   青软实训QST
 * @作者 zhaokl
 */
package com.hs_vae.Experiment.Demo2.Demo2.entity;

import java.io.Serializable;
import java.util.Date;

//货运物流信息
public class Transport extends DataBase implements  Serializable{
	/**
	 * 经手人
	 */
	private String handler;
	/**
	 * 收货人
	 */
	private String reciver;
	/**
	 * 物流状态
	 */
	private int transportType;
	/**
	 * 物流状态常量:发货中, 送货中, 已签收
	 */
	public static final int SENDDING = 1;// 发货中
	public static final int TRANSPORTING = 2;// 送货中
	public static final int RECIEVED = 3;// 已签收

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public int getTransportType() {
		return transportType;
	}

	public void setTransportType(int transportType) {
		this.transportType = transportType;
	}

	public Transport() {

	}

	public Transport(int id, Date time, String address, int type,
			String handler, String reciver, int transportType) {
		super(id, time, address, type);
		this.handler = handler;
		this.reciver = reciver;
		this.transportType = transportType;
	}

	public String toString() {
		return this.getId() + "," + this.getTime() + "," + this.getAddress()
				+ "," + this.getType() + "," + handler + "," + transportType;
	}
}
