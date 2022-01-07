package com.nttdata;

import com.nttdata.persistence.*;
import com.nttdata.services.*;
import java.util.List;
import java.util.Date;
import org.hibernate.Session;

public class CustomerApp{
	
	public static void main(String[] args) {
		
		final Session session = Util.getSessionFactory().openSession();
		
		final CustomerServiceI customerServiceI = new CustomerServiceImpl(session);
		final ContractServiceI contractServiceI = new ContractServiceImpl(session);
		
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		
		c1.setName("Marco");
		c1.setLastName1("Palmero");
		c1.setLastName2("Monroy");
		c1.setIdn("01223333E");
		c1.setUpdatedUser("APOZGAM");
		c1.setUpdatedDate(new Date());
		
		c2.setName("Jorge");
		c2.setLastName1("Dayoub");
		c2.setLastName2("Dayoub");
		c2.setIdn("21122012F");
		c2.setUpdatedUser("APOZGAM");
		c2.setUpdatedDate(new Date());
		
		c3.setName("Bruno");
		c3.setLastName1("Cruz");
		c3.setLastName2("Luque");
		c3.setIdn("55555558L");
		c3.setUpdatedUser("APOZGAM");
		c3.setUpdatedDate(new Date());
		
		customerServiceI.insertCustomer(c1);
		customerServiceI.insertCustomer(c2);
		customerServiceI.insertCustomer(c3);
		
		
		
		Contract t1 = new Contract();
		Contract t2 = new Contract();
		Contract t3 = new Contract();
		Contract t4 = new Contract();
		
		t1.setStartDate(new Date());
		t1.setPrice(49.99);
		t1.setCustomer(c1);
		t1.setUpdatedUser("APOZGAM");
		t1.setUpdatedDate(new Date());
		
		t2.setStartDate(new Date());
		t2.setPrice(39.99);
		t2.setCustomer(c2);
		t2.setUpdatedUser("APOZGAM");
		t2.setUpdatedDate(new Date());
		
		t3.setStartDate(new Date());
		t3.setPrice(29.99);
		t3.setCustomer(c2);
		t3.setUpdatedUser("APOZGAM");
		t3.setUpdatedDate(new Date());
		
		t4.setStartDate(new Date());
		t4.setPrice(19.99);
		t4.setCustomer(c3);
		t4.setUpdatedUser("APOZGAM");
		t4.setUpdatedDate(new Date());
		
		contractServiceI.insertContract(t1);
		contractServiceI.insertContract(t2);
		contractServiceI.insertContract(t3);
		contractServiceI.insertContract(t4);
		
		
		
		List<Contract> list1 = contractServiceI.searchAll();
		if (list1 != null && list1.size() > 0) {
			System.out.println("Total de contratos registrados: " + list1.size());
			for (Contract contract : list1) {
				System.out.println(contract.toString());
			}
		}

		List<Contract> list2 = contractServiceI.searchByCustomer(c3);
		if (list2 != null && list2.size() > 0) {
			System.out.println("Total de contratos asociados al cliente con ID " + c3.getID() + ": " + list2.size());
			for (Contract contract : list2) {
				System.out.println(contract.toString());
			}
		}

		session.close();
		
	}

}
