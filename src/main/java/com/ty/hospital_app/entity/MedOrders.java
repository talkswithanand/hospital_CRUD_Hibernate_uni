package com.ty.hospital_app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class MedOrders {
	@Id
	private int medOrdersId;
	private String invoice;
	private int bill;
	private String paymentMode;
	private String orderDate;
	
	@ManyToMany
	List<Item> items;

	public int getMedOrdersId() {
		return medOrdersId;
	}

	public void setMedOrdersId(int medOrdersId) {
		this.medOrdersId = medOrdersId;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "MedOrders [medOrdersId=" + medOrdersId + ", invoice=" + invoice + ", bill=" + bill + ", paymentMode="
				+ paymentMode + ", orderDate=" + orderDate + "]";
	}
	
}
