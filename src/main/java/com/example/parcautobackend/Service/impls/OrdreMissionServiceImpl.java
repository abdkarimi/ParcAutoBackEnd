package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.OrdreMission;
import com.example.parcautobackend.model.repositories.OrdreMissionRepository;
import com.example.parcautobackend.Service.OrdreMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdreMissionServiceImpl implements OrdreMissionService {

    @Autowired
    private OrdreMissionRepository ordreMissionRepository;

    @Override
    public OrdreMission saveOrdreMission(OrdreMission ordreMission) {
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
    public void deleteOrdreMission(Long id) {
        ordreMissionRepository.deleteById(id);
    }
}
