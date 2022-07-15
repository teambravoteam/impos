package com.teambravo.impos.sale.service;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Sale implements Serializable {
	private String saCode;
	private String saName;
	private double saPrice;
	private String saCategory;
	private int saCount;
	private double saAllPrice;
	private Date regDate;

	public Sale() {

	}

	public String getSaCode() {
		return saCode;
	}

	public void setSaCode(String saCode) {
		this.saCode = saCode;
	}

	public String getSaName() {
		return saName;
	}

	public void setSaName(String saName) {
		this.saName = saName;
	}

	public double getSaPrice() {
		return saPrice;
	}

	public void setSaPrice(double saPrice) {
		this.saPrice = saPrice;
	}

	public String getSaCategory() {
		return saCategory;
	}

	public void setSaCategory(String saCategory) {
		this.saCategory = saCategory;
	}

	public int getSaCount() {
		return saCount;
	}

	public void setSaCount(int saCount) {
		this.saCount = saCount;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public double getSaAllPrice() {
		return saAllPrice;
	}

	public void setSaAllPrice(double saAllPrice) {
		this.saAllPrice = saAllPrice;
	}

	@Override
	public String toString() {
		return saCategory + "," + saCode + "," + saName + "," + saPrice + "," + saCount + "," + saAllPrice + "," + regDate;
	}

}
