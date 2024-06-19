package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.Service.RoleService;
import com.example.parcautobackend.model.entities.Role;
import com.example.parcautobackend.model.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Optional<Role> existingRole = roleRepository.findById(id);
        if (existingRole.isPresent()) {
            Role updatedRole = existingRole.get();
            updatedRole.setNom(role.getNom());
            updatedRole.setDescription(role.getDescription());
            return roleRepository.save(updatedRole);
        } else {
            // Handle the case where the role with the given id does not exist
            return null; // Or throw an exception
        }
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
