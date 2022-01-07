package com.nttdata.persistence;

import java.util.List;

import org.hibernate.Session;

public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI {

	private Session session;
	
	public CustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchByFullName(String name, String lastname1, String lastname2) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		List<Customer> result = session
		        .createQuery("FROM Customer WHERE name='" + name + "' AND lastname1='" + lastname1 + "' AND lastname2='" + lastname2 + "'").list();
		return result;
		
	}

}