package com.capgemini.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="donation_distribution_table")
public class DonationDistribution {
	@Id
	@GeneratedValue
	private int distributionId;
	
	@NotEmpty(message = "Person must not be empty")
	@OneToOne(cascade = { CascadeType.ALL })
	private NeedyPeople person;
	
	@NotEmpty(message = "Item must not be empty")
	@OneToOne(cascade = { CascadeType.ALL })
	private DonationItem item;
	
	@NotEmpty(message = "Employee details must not be empty")
	@OneToOne(cascade = { CascadeType.ALL })
	private Employee distributedBy;
	
	@NotEmpty(message = "Amount distributed must not be empty")
	private double amountDistributed;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@FutureOrPresent(message ="Date must be of Future or Present")
	@NotEmpty(message = "Date of Distribution must not be empty")
	private Date dateOfDistribution;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@FutureOrPresent(message ="Date must be of Future of Present")
	@NotEmpty(message = "Date of Approval or Rejection must not be empty")
	private Date approvalOrRejectedDate;
	
	@NotEmpty(message = "Status must not be empty")
	private DonationDistributionStatus status;

	public DonationDistribution(NeedyPeople person, DonationItem item, Employee distributedBy, double amountDistributed,
			Date dateOfDistribution, Date approvalOrRejectedDate, DonationDistributionStatus status) {
		super();
		this.person = person;
		this.item = item;
		this.distributedBy = distributedBy;
		this.amountDistributed = amountDistributed;
		this.dateOfDistribution = dateOfDistribution;
		this.approvalOrRejectedDate = approvalOrRejectedDate;
		this.status = status;
		
	}

	public DonationDistribution() {
		super();
	}

	public int getDistributionId() {
		return distributionId;
	}

	public NeedyPeople getPerson() {
		return person;
	}

	public DonationItem getItem() {
		return item;
	}

	public Employee getDistributedBy() {
		return distributedBy;
	}

	public double getAmountDistributed() {
		return amountDistributed;
	}

	public Date getDateOfDistribution() {
		return dateOfDistribution;
	}

	public Date getApprovalOrRejectedDate() {
		return approvalOrRejectedDate;
	}

	public DonationDistributionStatus getStatus() {
		return status;
	}

	public void setDistributionId(int distributionId) {
		this.distributionId = distributionId;
	}

	public void setPerson(NeedyPeople person) {
		this.person = person;
	}

	public void setItem(DonationItem item) {
		this.item = item;
	}

	public void setDistributedBy(Employee distributedBy) {
		this.distributedBy = distributedBy;
	}

	public void setAmountDistributed(double amountDistributed) {
		this.amountDistributed = amountDistributed;
	}

	public void setDateOfDistribution(Date dateOfDistribution) {
		this.dateOfDistribution = dateOfDistribution;
	}

	public void setApprovalOrRejectedDate(Date approvalOrRejectedDate) {
		this.approvalOrRejectedDate = approvalOrRejectedDate;
	}

	public void setStatus(DonationDistributionStatus status) {
		this.status = status;
	}
}
