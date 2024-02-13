package com.ty.hospital_app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	private int addressId;
	private String addressLocation;
	private String adressState;
	private String adressPinCode;
	private long contact;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressLocation() {
		return addressLocation;
	}
	public void setAddressLocation(String addressLocation) {
		this.addressLocation = addressLocation;
	}
	public String getAdressState() {
		return adressState;
	}
	public void setAdressState(String adressState) {
		this.adressState = adressState;
	}
	public String getAdressPinCode() {
		return adressPinCode;
	}
	public void setAdressPinCode(String adressPinCode) {
		this.adressPinCode = adressPinCode;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressLocation=" + addressLocation + ", adressState="
				+ adressState + ", adressPinCode=" + adressPinCode + ", contact=" + contact + "]";
	}

	
}
