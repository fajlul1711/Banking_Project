package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class CustomerTableDto {
@Id
@SequenceGenerator(initialValue = 349003190, allocationSize = 1, sequenceName = "IBHID", name = "IBHID" )
@GeneratedValue(generator = "IBHID")
long IBHID;
@Column(nullable = false)
String firstname;
@Column(nullable = false)
String lastname;
@Column(nullable = false)
long mobile;
@Column(nullable = false)
String email;
@Column(nullable = false)
String password;
@Column(nullable = false)
String confirmpassword;
@Column(nullable = false)
Date dob;
@Column(nullable = false)
String gender;
@Column(nullable = false)
String country;
@Column(nullable = false)
String terms;

@OneToMany
List<BankAccount> list;
public long getIBHID() {
	return IBHID;
}
public void setIBHID(long iBHID) {
	IBHID = iBHID;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirmpassword() {
	return confirmpassword;
}
public void setConfirmpassword(String confirmpassword) {
	this.confirmpassword = confirmpassword;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getTerms() {
	return terms;
}
public void setTerms(String terms) {
	this.terms = terms;
}
public List<BankAccount> getList() {
	return list;
}
public void setList(List<BankAccount> list) {
	this.list = list;
}



}
