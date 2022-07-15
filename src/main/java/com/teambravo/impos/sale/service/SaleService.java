package com.teambravo.impos.sale.service;

import java.util.List;

import com.teambravo.impos.sale.dao.SaleDao;

public class SaleService {
	private SaleDao saleDao = new SaleDao();

	public SaleService() {

	}

	public List<Sale> findAllSale() {
		return saleDao.findAllSale();
	}

	public Double findAllSaPrice() {
		return saleDao.findAllSaPrice();
	}

	public List<Sale> findCategorySale(String saCategory) {
		return saleDao.findCategorySale(saCategory);
	}

	public Double findCategorySaPrice(String saCategory) {
		return saleDao.findCategorySaPrice(saCategory);
	}

	public List<Sale> findYearSale(String saYear) {
		return saleDao.findYearSale(saYear);
	}

	public Double findYearSaPrice(String saYear) {
		return saleDao.findYearSaPrice(saYear);
	}

	public List<Sale> findMonthSale(String saMonth) {
		return saleDao.findMonthSale(saMonth);
	}

	public Double findMonthSaPrice(String monthDate) {
		return saleDao.findMonthSaPrice(monthDate);
	}

	public List<Sale> findDaySale(String saDay) {
		return saleDao.findDaySale(saDay);
	}

	public Double findDaySaPrice(String saDay) {
		return saleDao.findDaySaPrice(saDay);
	}

	public List<Sale> findDateSale(String saYear, String saMonth, String saDay) {
		return saleDao.findDateSale(saYear, saMonth, saDay);
	}

	public Double findDateSaPrice(String saYear, String saMonth, String saDay) {
		return saleDao.findDateSaPrice(saYear, saMonth, saDay);
	}
}
