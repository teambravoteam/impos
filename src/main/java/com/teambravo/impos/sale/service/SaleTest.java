package com.teambravo.impos.sale.service;

import java.util.List;

public class SaleTest {

	public static void main(String[] args) {
		SaleService service = new SaleService();

		List<Sale> sale = service.findAllSale();
		System.out.println(sale);
	}

}
