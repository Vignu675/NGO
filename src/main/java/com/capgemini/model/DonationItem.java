package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "donation_item_table")
public class DonationItem {
	@Id
	@GeneratedValue
	private int itemId;

	@NotEmpty(message = "Donation Item must not be empty")
	private DonationType item;

	@NotEmpty(message = "Item Description must not be empty")
	private String itemDescription;

	public DonationItem(DonationType item, String itemDescription) {
		super();
		this.item = item;
		this.itemDescription = itemDescription;
	}

	public DonationItem() {
		super();
	}

	public int getItemId() {
		return itemId;
	}

	public DonationType getItem() {
		return item;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setItem(DonationType item) {
		this.item = item;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

}
