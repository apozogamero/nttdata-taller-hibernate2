package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "hibernate_contract")
public class Contract extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ID;
	private Date startDate, expireDate;
	private Double price;
	private Customer customer;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	@Column(name = "START_DATE", nullable = false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "EXPIRE_DATE", nullable = true)
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "PRICE", nullable = true)
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

	@Override
	public String toString() {
		return "Contract [ID=" + ID + ", startDate=" + startDate + ", expireDate=" + expireDate + ", price=" + price
		        + ", customer=" + customer + "]";
	}

}
