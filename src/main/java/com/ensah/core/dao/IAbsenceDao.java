package com.ensah.core.dao;

import com.ensah.core.bo.Absence;
import com.ensah.genericdao.EntityNotFoundException;
import com.ensah.genericdao.GenericDao;

import java.util.List;

public interface IAbsenceDao extends GenericDao<Absence,Long> {
    @Override
    Long create(Absence o);

    @Override
    void update(Absence o);

    @Override
    List<Absence> getAll();

    @Override
    List<Absence> getAllDistinct();

    @Override
    Absence findById(Long pId) throws EntityNotFoundException;

    @Override
    List<Absence> getEntityByColValue(String ClassName, String pColumnName, String pValue);

    @Override
    void delete(Long pId) throws EntityNotFoundException;

    @Override
    boolean exists(Long pId);
}
