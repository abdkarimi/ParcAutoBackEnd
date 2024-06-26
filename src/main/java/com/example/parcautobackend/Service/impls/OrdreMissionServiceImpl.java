package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.Service.StructureService;
import com.example.parcautobackend.Service.UtilisateurService;
import com.example.parcautobackend.model.entities.OrdreMission;
import com.example.parcautobackend.model.entities.Structure;
import com.example.parcautobackend.model.entities.Utilisateur;
import com.example.parcautobackend.model.repositories.OrdreMissionRepository;
import com.example.parcautobackend.Service.OrdreMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdreMissionServiceImpl implements OrdreMissionService {

    @Autowired
    private OrdreMissionRepository ordreMissionRepository;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private StructureService structureService;
    @Override
    public OrdreMission saveOrdreMission(OrdreMission ordreMission) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Utilisateur currentUser = utilisateurService.getUtilisateurByUsername(authentication.getName());

        if (currentUser == null) {
            throw new RuntimeException("Current user not found");
        }
        ordreMission.setStatutOm("En attente d'approbation");
        ordreMission.setDateOm(new Date());
        ordreMission.setAgent(currentUser);

        return ordreMissionRepository.save(ordreMission);
    }


    @Override
    public Optional<OrdreMission> getOrdreMissionById(Long id) {
        return ordreMissionRepository.findById(id);
    }

    @Override
    public List<OrdreMission> getAllOrdreMissions() {
        return ordreMissionRepository.findAll();
    }

    @Override
    public OrdreMission updateOrdreMission(Long id, OrdreMission ordreMission) {
        if (ordreMissionRepository.existsById(id)) {
            ordreMission.setIdOm(id);
            return ordreMissionRepository.save(ordreMission);
        }
        return null;
    }
    @Override
    public List<OrdreMission> getAllOrdreMissionOfDepartement(Long departementId) {
        List<OrdreMission> ordreMissions = new ArrayList<>();
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();

        for (Utilisateur utilisateur : utilisateurs) {
            Structure topParentStructure = (Structure) structureService.findTopParentStructureByUserId(utilisateur.getId());
            if (topParentStructure != null && topParentStructure.getIdStructure().equals(departementId)) {
                ordreMissions.addAll(ordreMissionRepository.findByAgent(utilisateur));
            }
        }

        return ordreMissions;
    }
    @Override
    public void deleteOrdreMission(Long id) {
        ordreMissionRepository.deleteById(id);
    }
}
