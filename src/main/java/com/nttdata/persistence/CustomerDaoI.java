package com.nttdata.persistence;

import java.util.List;

public interface CustomerDaoI extends CommonDaoI<Customer>{
	
	public List<Customer> searchByFullName(String name, String lastname1, String lastname2);
}
