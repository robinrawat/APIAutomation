package com.testautomation.apitesting.pojos;

public class USD {
	private String code;
	private String symbol;
	private String rate;
	private String description;
	private String rateFloat;
	
	public USD(String code,String symbol,String rate, String description, String rateFloat) {
		setCode(code);
		setSymbol(symbol);
		setRate(rate);
		setDescription(description);
		setRateFloat(rateFloat);
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setRateFloat(String rateFloat) {
		this.rateFloat = rateFloat;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getRate() {
		return rate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getRateFloat() {
		return rateFloat;
	}
	
	

}
