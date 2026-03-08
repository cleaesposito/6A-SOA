package fr.insa.ms.ReviewMS.model;

public class Review {
	private int id;
	private int helperId;
	private int demanderId;
	private int requestId; 
	private int rate;
	public Review(int id, int helperId, int demanderId, int requestId, int rate) {
		super();
		this.id = id;
		this.helperId = helperId;
		this.demanderId = demanderId;
		this.requestId = requestId;
		this.rate = rate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHelperId() {
		return helperId;
	}
	public void setHelperId(int helperId) {
		this.helperId = helperId;
	}
	public int getDemanderId() {
		return demanderId;
	}
	public void setDemanderId(int demanderId) {
		this.demanderId = demanderId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
