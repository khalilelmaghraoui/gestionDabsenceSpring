package com.ensah.core.dao;


import com.ensah.core.bo.Etudiant;
import com.ensah.genericdao.EntityNotFoundException;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EtudiantDaoImpl extends HibernateSpringGenericDaoImpl<Etudiant,Long> {
    /**
     * Constructeur précisant la classe de l'objet métier manipulé
     *
     *  la classe de l'objet métier manipulé
     */
    public EtudiantDaoImpl() {
        super(Etudiant.class);
    }

    @Override
    public Long create(Etudiant pObject) {
        return super.create(pObject);
    }

    @Override
    public void update(Etudiant pObject) {
        super.update(pObject);
    }

    @Override
    public List<Etudiant> getAll() {
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
    public Etudiant findById(Long pId) throws EntityNotFoundException {
        return super.findById(pId);
    }

    @Override
    public List<Etudiant> getAllDistinct() {
        return super.getAllDistinct();
    }

    @Override
    public List<Etudiant> getEntityByColValue(String ClassName, String pColumnName, String pValue) {
        return super.getEntityByColValue(ClassName, pColumnName, pValue);
    }
}
