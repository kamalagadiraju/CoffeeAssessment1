package com.coffeeAssessment;

import java.util.HashMap;
import java.util.Map;

public class Amount {

	private JsonJavaMapper jsonJavaMapper;

	Amount() {
		jsonJavaMapper = new JsonJavaMapper();
		jsonJavaMapper.readJson();
	}

	/**
	 * This method calculates the total amount of money to be paid per user for all
	 * the orders of the user. This method retrieves data from orders and products.
	 * 
	 * @return Map with User as Key and Total Amount as value
	 */
	private Map<String, Double> calculateUserTotalAmount() {
		Order[] orders = jsonJavaMapper.getOrders();
		Product[] products = jsonJavaMapper.getProducts();
		Map<String, Map<String, Double>> productsMap = new HashMap<String, Map<String, Double>>();
		for (Product product : products) {
			productsMap.put(product.getDrinkName(), product.getPrices());
		}
		Map<String, Double> userTotalAmount = new HashMap<String, Double>();
		for (Order order : orders) {
			Map<String, Double> drinkPrices = productsMap.get(order.getDrink());
			Double drinkPrice = drinkPrices.getOrDefault(order.getSize(), 0.0);
			Double existingAmount = userTotalAmount.putIfAbsent(order.getUser(), drinkPrice);
			if (existingAmount != null) {
				userTotalAmount.put(order.getUser(), existingAmount + drinkPrice);
			}
		}
		return userTotalAmount;
	}

	/**
	 * This method calculates the total amount already paid by users by retrieving
	 * data from payments
	 * 
	 * @return Map with User as key and amount already paid by user as value
	 */
	private Map<String, Double> getAmountPayedByUser() {
		Map<String, Double> amountAlreadyPaidByUser = new HashMap<String, Double>();
		Payment[] payments = jsonJavaMapper.getPayments();
		for (Payment payment : payments) {
			Double amountPaid = amountAlreadyPaidByUser.putIfAbsent(payment.getUser(), payment.getAmount());
			if (amountPaid != null) {
				amountAlreadyPaidByUser.put(payment.getUser(), payment.getAmount() + amountPaid);
			}

		}
		return amountAlreadyPaidByUser;
	}

	/**
	 * This is the method called by the Main Class to print the desired details
	 * needed for assessment
	 */
	public void displayUserAndAmount() {
		Map<String, Double> totalAmountToBePaid = calculateUserTotalAmount();
		Map<String, Double> amountPaid = getAmountPayedByUser();
		System.out.format("%12s%25s%20s%20s%20s", "USER |", " TOTAL AMOUNT TO BE PAID |", " AMOUNT ALREADY PAID |",
				" AMOUNT OWED BY USER |", " EXCESS AMOUNT PAID |").println();
		System.out.println();
		totalAmountToBePaid.entrySet().forEach(entry -> {
			Double amountPaidByUser = amountPaid.get(entry.getKey());
			if (entry.getValue() > amountPaidByUser) {
				System.out.format("%10s%25s%20s%20s%20s", entry.getKey(), entry.getValue(), amountPaidByUser,
						(entry.getValue() - amountPaidByUser), "0.0").println();
			} else {
				System.out.format("%10s%25s%20s%20s%20s", entry.getKey(), entry.getValue(), amountPaidByUser, "0.0",
						(amountPaidByUser - entry.getValue())).println();
			}
		});
	}
}
