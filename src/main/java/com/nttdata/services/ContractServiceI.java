package com.nttdata.services;

import com.nttdata.persistence.Customer;
import com.nttdata.persistence.Contract;
import java.util.List;

public interface ContractServiceI {
	
	public void insertContract(Contract contract);

	public Contract searchById(Long id);

	public List<Contract> searchByCustomer(Customer customer);

	public List<Contract> searchAll();

	public void updateContract(Contract contract);

	public void deleteContract(Contract contract);
}
