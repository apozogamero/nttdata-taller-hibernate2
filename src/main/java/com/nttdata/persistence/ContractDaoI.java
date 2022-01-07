package com.nttdata.persistence;

import java.util.List;

public interface ContractDaoI extends CommonDaoI<Contract>{
	
	public List<Contract> searchByCustomer(Customer customer);
	
}
