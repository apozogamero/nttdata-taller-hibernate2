package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "hibernate_customer")
public class Customer extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long ID;
	private String name, lastName1, lastName2, idn, updatedUser;
	private Date updatedDate;
	private List<Contract> contractList;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Column(name = "LASTNAME1", nullable = false)
	public String getLastName1() {
		return lastName1;
	}

	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	
	@Column(name = "LASTNAME2", nullable = false)
	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	
	@Column(name = "IDN", nullable = false, length = 9, unique = true)
	public String getIdn() {
		return idn;
	}

	public void setIdn(String idn) {
		this.idn = idn;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	public List<Contract> getContractList() {
		return contractList;
	}

	public void setContractList(List<Contract> contractList) {
		this.contractList = contractList;
	}
	
	@Transient
	public Class<?> getClase() {
		return Customer.class;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", name=" + name + ", lastName1=" + lastName1 + ", lastName2=" + lastName2
				+ ", idn=" + idn + ", updatedUser=" + updatedUser + ", updatedDate=" + updatedDate + "]";
	}
}