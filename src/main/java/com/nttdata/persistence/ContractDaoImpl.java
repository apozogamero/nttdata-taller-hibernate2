package com.nttdata.persistence;

import java.util.List;
import org.hibernate.Session;


public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	private Session session;

	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByCustomer(Customer customer) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}


		List<Contract> result = session.createQuery("FROM Contract WHERE customer.ID=" + customer.getID()).list();
		return result;
	}

}
