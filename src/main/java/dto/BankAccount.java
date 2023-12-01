package dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class BankAccount {
@Id
@SequenceGenerator(initialValue = 123456, allocationSize = 1, sequenceName = "accno", name="accno")
@GeneratedValue(generator = "accno")
long accno;
@Column(nullable = false)
String accountType;
@Column(nullable = false)
double amount;
@Column(nullable = false)
double accountLimit;
@Column(nullable = false)
boolean status;
@ManyToOne
CustomerTableDto customerTableDto;


@OneToMany(cascade = CascadeType.ALL)//Directly we can save the data without et.begin(), em.persist(), et.commit().
List<BankTransaction> bankTransactions;


public long getAccno() {
	return accno;
}


public void setAccno(long accno) {
	this.accno = accno;
}


public String getAccountType() {
	return accountType;
}


public void setAccountType(String accountType) {
	this.accountType = accountType;
}


public double getAmount() {
	return amount;
}


public void setAmount(double amount) {
	this.amount = amount;
}


public double getAccountLimit() {
	return accountLimit;
}


public void setAccountLimit(double accountLimit) {
	this.accountLimit = accountLimit;
}


public boolean isStatus() {
	return status;
}


public void setStatus(boolean status) {
	this.status = status;
}


public CustomerTableDto getCustomerTableDto() {
	return customerTableDto;
}


public void setCustomerTableDto(CustomerTableDto customerTableDto) {
	this.customerTableDto = customerTableDto;
}


public List<BankTransaction> getBankTransactions() {
	return bankTransactions;
}


public void setBankTransactions(List<BankTransaction> bankTransactions) {
	this.bankTransactions = bankTransactions;
}


}
