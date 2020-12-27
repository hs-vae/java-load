/**   
 * @公司   青软实训QST
 * @作者 zhaokl
 */
package com.hs_vae.Experiment.Demo2.Demo2.entity;

import java.io.Serializable;
import java.util.Date;

//数据基础类

public class DataBase  implements Serializable{
	// ID标识
	private int id;
	// 时间
	private Date time;
	// 地点
	private String address;
	// 状态
	private int type;
	// 状态常量
	public static final int GATHER=1;//"采集"
	public static final int MATHCH=2;//"匹配";
	public static final int RECORD=3;//"记录";
	public static final int SEND=4;//"发送";
	public static final int RECIVE=5;//"接收";
	public static final int WRITE=6;//"归档";
	public static final int SAVE=7;//"保存";

	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}


	public Date getTime() {
		return time;
	}

	
	public void setTime(Date time) {
		this.time = time;
	}


	public String getAddress() {
		return address;
	}

	
	public void setAddress(String address) {
		this.address = address;
	}

	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	public DataBase() {
	}

	public DataBase(int id, Date time, String address, int type) {
		this.id = id;
		this.time = time;
		this.address = address;
		this.type = type;
	}

	public String toString() {
		return id + "," + time + "," + address + "," + type;
	}

}
