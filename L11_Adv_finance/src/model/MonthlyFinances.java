package model;

import java.time.Month;

public class MonthlyFinances {
	
	public static final double TAX_RATE = 0.19;
	
	private Month month;
	private double revenue;
	private double costs;
	private double income;
	private double taxedIncome;
	private double marginOfIncome;
	
	public MonthlyFinances (Month month, double revenue, double costs) {
		this.month = month;
		this.revenue = revenue;
		this.costs = costs;
		
		income = calcIncome(revenue, costs);
		taxedIncome = calcTaxedIncome(income, TAX_RATE);
		marginOfIncome = calcMarginOfIncome(income, revenue);
	}
	
	public Month getMonth() {
		return month;
	}

	public double getRevenue() {
		return revenue;
	}

	public double getCosts() {
		return costs;
	}

	public double getIncome() {
		return income;
	}

	public double getTaxedIncome() {
		return taxedIncome;
	}

	public double getMarginOfIncome() {
		return marginOfIncome;
	}

	private double calcTaxedIncome ( double incomeBeforeTaxation, double taxRate) {
		return (1 - taxRate) * incomeBeforeTaxation;
	}
	
	private double calcIncome (double revenue, double costs) {
		return revenue - costs;
	}
	private double calcMarginOfIncome (double income, double revenue) {
		return income / revenue * 100;
	}
	

}
