package com.trello.dao;

import javax.inject.Inject;

import org.hibernate.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trello.domain.Account;

@Repository
public class HbnAccountDao extends AbstractHbnDao<Account> implements AccountDao{

	
	//Zapytanie aktualizujace JDBC
	private static final String UPDATE_PASSWORD_SQL = "update account set password = ? where username = ?";
	
	
	//Szablon JDBC
	@Inject private JdbcTemplate jdbcTemplate;
	
	@Override
	public void create(Account account, String password) {
		// TODO Auto-generated method stub
		create(account);
		jdbcTemplate.update(UPDATE_PASSWORD_SQL, password, account.getUsername());		
	}

	
	//Wywołanie zapytania
	@Override
	public Account findByUsername(String username) {
		// TODO Auto-generated method stub
		
		Query q = getSession().getNamedQuery("findAccountByUsername");
		q.setParameter("username", username);
		
		return (Account) q.uniqueResult();
	}

	

}
