package com.ensah.core.dao;

import com.ensah.core.bo.Absence;
import com.ensah.genericdao.EntityNotFoundException;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IabsenceDaoImpl extends HibernateSpringGenericDaoImpl<Absence,Long> implements IAbsenceDao  {
    /**
     * Constructeur précisant la classe de l'objet métier manipulé
     *
     */
    public IabsenceDaoImpl() {
        super(Absence.class);
    }



    @Override
    public Long create(Absence pObject) {
        return super.create(pObject);
    }

    @Override
    public void update(Absence pObject) {
        super.update(pObject);
    }

    @Override
    public List<Absence> getAll() {
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
    public Absence findById(Long pId) throws EntityNotFoundException {
        return super.findById(pId);
    }

    @Override
    public List<Absence> getAllDistinct() {
        return super.getAllDistinct();
    }

    @Override
    public List<Absence> getEntityByColValue(String ClassName, String pColumnName, String pValue) {
        return super.getEntityByColValue(ClassName, pColumnName, pValue);
    }
}
