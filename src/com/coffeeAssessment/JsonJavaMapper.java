package com.coffeeAssessment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;

public class JsonJavaMapper {
	private Order[] orders;
	private Payment[] payments;
	private Product[] products;

	/*
	 * This method is used to read data from the json files and map it to the
	 * corresponding Java objects
	 */
	public void readJson() {
		Gson gson = new Gson();
		Reader reader1 = null;
		Reader reader2 = null;
		Reader reader3 = null;

		try {
			reader1 = new FileReader("resources/orders.json");
			orders = gson.fromJson(reader1, Order[].class);
			reader2 = new FileReader("resources/payments.json");
			payments = gson.fromJson(reader2, Payment[].class);
			reader3 = new FileReader("resources/products.json");
			products = gson.fromJson(reader3, Product[].class);
		} catch (FileNotFoundException e) {
			System.out.println("Exception while reading the file : " + e.getMessage());
		} finally {
			if (reader1 != null) {
				try {
					reader1.close();
				} catch (IOException ex) {
					System.out.println("Exception while closing the file reader : " + ex.getMessage());
				}
			}
			if (reader2 != null) {
				try {
					reader2.close();
				} catch (IOException ex) {
					System.out.println("Exception while closing the file reader : " + ex.getMessage());
				}
			}
			if (reader3 != null) {
				try {
					reader3.close();
				} catch (IOException ex) {
					System.out.println("Exception while closing the file reader : " + ex.getMessage());
				}
			}
		}

	}

	public Order[] getOrders() {
		return orders;
	}

	public Payment[] getPayments() {
		return payments;
	}

	public Product[] getProducts() {
		return products;
	}
}
