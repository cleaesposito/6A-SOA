package com.example.OrchestratorMS.model;

import java.time.LocalDateTime;

public class Request {
	private int id;
	private String title;
	private String description;
	private int demanderId;
	private int helperId;
	private LocalDateTime date;
	private EnumStatus status;
	public Request(int id, String title, String description, int demanderId, int helperId, LocalDateTime date,
			EnumStatus status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.demanderId = demanderId;
		this.helperId = helperId;
		this.date = date;
		this.status = status;
	}
	public Request(){}
	
	public Request(String title, String description, int demanderId, int helperId, LocalDateTime date,
			EnumStatus status) {
		super();
		this.title = title;
		this.description = description;
		this.demanderId = demanderId;
		this.helperId = helperId;
		this.date = date;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDemanderId() {
		return demanderId;
	}
	public void setDemanderId(int demanderId) {
		this.demanderId = demanderId;
	}
	public int getHelperId() {
		return helperId;
	}
	public void setHelperId(int helperId) {
		this.helperId = helperId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public EnumStatus getStatus() {
		return status;
	}
	public void setStatus(EnumStatus status) {
		this.status = status;
	}	

}

