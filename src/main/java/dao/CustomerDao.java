package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import dto.CustomerTableDto;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction= entityManager.getTransaction();
	
	public void save(CustomerTableDto customerTableDto) {
		entityTransaction.begin();
		entityManager.persist(customerTableDto);
		entityTransaction.commit();
		System.out.println("Customer data Successfully Incerted in database");
	}
	
public List<CustomerTableDto> fetch(long mob){
		List<CustomerTableDto> list = entityManager.createQuery("select x from CustomerTableDto x where mobile=?1").setParameter(1, mob).getResultList();
		return list;
		
	}
	public List<CustomerTableDto> fetch(String email){
		List<CustomerTableDto> list= entityManager.createQuery("select x from CustomerTableDto x where email=?1").setParameter(1,  email).getResultList();
		
		return list;
		
	}
public CustomerTableDto fetchBycustId(long id){
		
		CustomerTableDto customerTableDto=entityManager.find(CustomerTableDto.class, id);
		return customerTableDto;
		
	}
public void update(CustomerTableDto customerTableDto) {
	entityTransaction.begin();
	entityManager.merge(customerTableDto);
	entityTransaction.commit();
	
}
	
}
