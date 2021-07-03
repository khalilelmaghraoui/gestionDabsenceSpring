package com.ensah.core.dao;

import com.ensah.genericdao.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Role;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

import java.util.List;

@Repository
public class RoleDaoImpl extends HibernateSpringGenericDaoImpl<Role, Long> implements IRoleDao{

	public RoleDaoImpl() {
		super(Role.class);
	}

    public RoleDaoImpl(Class<Role> pPersistentClass) {
        super(pPersistentClass);
    }

    @Override
    public Long create(Role pObject) {
        return super.create(pObject);
    }

    @Override
    public void update(Role pObject) {
        super.update(pObject);
    }

    @Override
    public List<Role> getAll() {
        return super.getAll();
    }

    @Override
    public void delete(Long pId) throws EntityNotFoundException {
        super.delete(pId);
    }

    @Override
    public boolean exists(Long id) {
        return super.exists(id);
    }

    @Override
    public Role findById(Long pId) throws EntityNotFoundException {
        return super.findById(pId);
    }

    @Override
    public List<Role> getAllDistinct() {
        return super.getAllDistinct();
    }

    @Override
    public List<Role> getEntityByColValue(String ClassName, String pColumnName, String pValue) {
        return super.getEntityByColValue(ClassName, pColumnName, pValue);
    }
}
