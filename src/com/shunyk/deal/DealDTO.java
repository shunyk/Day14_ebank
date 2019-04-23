package com.shunyk.deal;

public class DealDTO {
	private String bnum;
	private int kind;
	private String dealdate;
	private int deal;
	private int balance;
	
	
	
	public int getDeal() {
		return deal;
	}
	public void setDeal(int deal) {
		this.deal = deal;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public String getDealdate() {
		return dealdate;
	}
	public void setDealdate(String daaldate) {
		this.dealdate = dealdate;
	}
	
	
}
