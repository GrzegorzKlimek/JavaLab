package model;

import java.time.Month;
import java.util.List;
import java.util.Map;

import logic.Accountant;

public class FinaceReport {
	
	private Accountant accountant;
		
	private Map <Month, MonthlyFinances> yearFinanceReport;
	
	private List<MonthlyFinances> goodMonths;
	
	private List<MonthlyFinances> badMonths;
	
	private Month bestMonth;
	
	private Month worstMonth;

	public FinaceReport() {
		accountant = new Accountant();
	}

	public Map<Month, MonthlyFinances> getYearFinanceReport() {
		return yearFinanceReport;
	}

	public void setYearFinanceReport(Map<Month, MonthlyFinances> yearFinanceReport) {
		this.yearFinanceReport = yearFinanceReport;
	}

	public List<MonthlyFinances> getGoodMonths() {
		return goodMonths;
	}

	public void setGoodMonths(List<MonthlyFinances> goodMonths) {
		this.goodMonths = goodMonths;
	}

	public List<MonthlyFinances> getBadMonths() {
		return badMonths;
	}

	public void setBadMonths(List<MonthlyFinances> badMonths) {
		this.badMonths = badMonths;
	}

	public Month getBestMonth() {
		return bestMonth;
	}

	public void setBestMonth(Month bestMonth) {
		this.bestMonth = bestMonth;
	}

	public Month getWorstMonth() {
		return worstMonth;
	}

	public void setWorstMonth(Month worstMonth) {
		this.worstMonth = worstMonth;
	}

	
	

}
