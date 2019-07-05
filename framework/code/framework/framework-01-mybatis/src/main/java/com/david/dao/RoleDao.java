package com.david.dao;

import com.david.domain.Role;

import java.util.List;

/**
 * @author david
 * @create 2019-06-23 1:53
 */
public interface RoleDao {
    /**
     * 查询所有角色
     * @return
     */
    public List<Role> findAll();

    /**
     * 查询角色下面所有的用户信息
     * many 2 many
     * @return
     */
    public List<Role> findRolesAndUsers();
    /**
     * 查询角色下面所有的用户信息,带延迟加载
     * many 2 many
     * @return
     */
    public List<Role> findRolesAndUsersLazy();
}
