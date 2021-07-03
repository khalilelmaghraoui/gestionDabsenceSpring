package com.ensah.core.services;


import com.ensah.core.bo.Etudiant;
import com.ensah.core.bo.Person;
import com.ensah.core.dao.IEnseignantDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService implements IEnseignantService {


    private IEnseignantDao iEnseignantDao;



    @Override
    public List<Etudiant> getAllEtudiants() {

return null;
    }

    @Override
    public String getSeance() {
        return null;
    }

    @Override
    public Boolean setAbsence(Etudiant etudiant) {

        return null;
    }

    @Override
    public Person getEtudiantById(Long id) {
        return null;
    }

    @Override
    public List getEtudiantHistory(long id) {
        return null;
    }
}
