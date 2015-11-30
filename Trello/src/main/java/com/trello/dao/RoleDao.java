package com.trello.dao;

import com.trello.domain.Role;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface RoleDao extends Dao<Role> {
	
	Role findByName(String name);
}
