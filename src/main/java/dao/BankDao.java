package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import dto.BankAccount;



public class BankDao {
	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction= entityManager.getTransaction();
	
	public void save(dto.BankAccount bankAccount) {
		entityTransaction.begin();
		entityManager.persist(bankAccount);
		entityTransaction.commit();
		
	}
	public List<BankAccount> fetch_All_Bank_Details() {
		List<BankAccount> list= entityManager.createQuery("select x from BankAccount x").getResultList();
		return list;
	}
	public BankAccount fetchByAccno(long acno) {
		
		
		BankAccount bankAccount=entityManager.find(BankAccount.class, acno);
		
		return bankAccount;
	}
	public void update(BankAccount bankAccount) {
		entityTransaction.begin();
		entityManager.merge(bankAccount);
		entityTransaction.commit();
	}

}
