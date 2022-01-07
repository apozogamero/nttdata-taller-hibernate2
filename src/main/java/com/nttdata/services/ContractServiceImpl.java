package com.nttdata.services;

import com.nttdata.persistence.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class ContractServiceImpl implements ContractServiceI {
	
	private ContractDaoI contractDao;
	
	public ContractServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertContract(Contract contract) {
		
		contractDao.insert(contract);
		
	}

	@Override
	public Contract searchById(Long id) {
		
		Contract result = contractDao.searchById(id);
		return result;
		
	}

	@Override
	public List<Contract> searchByCustomer(Customer customer) {
		
		List<Contract> result = contractDao.searchByCustomer(customer);
		return result;
		
	}

	@Override
	public List<Contract> searchAll() {
		
		List<Contract> result = contractDao.searchAll();
		return result;
		
	}

	@Override
	public void updateContract(Contract contract) {

		contractDao.update(contract);
		
	}

	@Override
	public void deleteContract(Contract contract) {
		
		contractDao.delete(contract);
		
	}

}
