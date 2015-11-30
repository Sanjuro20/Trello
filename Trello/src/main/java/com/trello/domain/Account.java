package com.trello.domain;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@NamedQuery(
		name = "findAccountByUsername",
		query = "from Account where username = :username")


@Entity
@Table(name = "account")
public class Account {
	
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private boolean marketingOk = true;
	private boolean acceptTerms = false;
	private boolean enabled = true;
	private Date dateCreated;
	
	
	//=======Gettery=========/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "id")
	public long getId(){
		return id;
	}
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}
	
	@NotNull
	@Size(min = 6, max = 50)
	@Email
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	
	@Column(name = "marketing_ok")
	public boolean isMarketingOk() {
		return marketingOk;
	}
	
	@AssertTrue(message = "{account.acceptTerms.assertTrue.message}")
	@Column(name = "accept_terms")
	public boolean isAcceptTerms() {
		return acceptTerms;
	}
	
	@Column(name = "enabled")
	public boolean isEnabled() {
		return enabled;
	}
	
	@Column(name = "date_created")
	public Date getDateCreated() {
		return dateCreated;
	}
	
	//=======Settery========/
	
	@SuppressWarnings("unused")
	public void setId(Long id){
		this.id = id;
	}


	public void setUsername(String username) {
		this.username = username;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setMarketingOk(boolean marketingOk) {
		this.marketingOk = marketingOk;
	}



	public void setAcceptTerms(boolean acceptTerms) {
		this.acceptTerms = acceptTerms;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}	
	

}
