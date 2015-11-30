package com.trello.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.trello.domain.Role;



@Repository
public class HbnRoleDao extends AbstractHbnDao<Role> implements RoleDao {

	public Role findByName(String name) {
		Query q = getSession().getNamedQuery("findRoleByName");
		q.setParameter("name", name);
		return (Role) q.uniqueResult();
	}
}
