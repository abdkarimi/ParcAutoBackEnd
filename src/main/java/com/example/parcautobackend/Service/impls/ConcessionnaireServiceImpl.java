package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Concessionnaire;
import com.example.parcautobackend.model.repositories.ConcessionnaireRepository;
import com.example.parcautobackend.Service.ConcessionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcessionnaireServiceImpl implements ConcessionnaireService {

    @Autowired
    private ConcessionnaireRepository concessionnaireRepository;

    @Override
    public Concessionnaire saveConcessionnaire(Concessionnaire concessionnaire) {
        return concessionnaireRepository.save(concessionnaire);
    }

    @Override
    public Optional<Concessionnaire> getConcessionnaireById(Long id) {
        return concessionnaireRepository.findById(id);
    }

    @Override
    public List<Concessionnaire> getAllConcessionnaires() {
        return concessionnaireRepository.findAll();
    }

    @Override
    public Concessionnaire updateConcessionnaire(Long id, Concessionnaire concessionnaire) {
        if (concessionnaireRepository.existsById(id)) {
            concessionnaire.setIdConcessionnaire(id);
            return concessionnaireRepository.save(concessionnaire);
        }
        return null;
    }

    @Override
    public void deleteConcessionnaire(Long id) {
        concessionnaireRepository.deleteById(id);
    }
}
