package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StructureRepository extends JpaRepository<Structure, Long> {
    @Query(value = "WITH RECURSIVE structure_hierarchy AS (" +
            "    SELECT " +
            "        id_structure, " +
            "        nom_structure, " +
            "        structure_parent " +
            "    FROM " +
            "        structure " +
            "    WHERE " +
            "        id_structure = (SELECT structure_id FROM users WHERE id = :userId) " +
            "    UNION ALL " +
            "    SELECT " +
            "        s.id_structure, " +
            "        s.nom_structure, " +
            "        s.structure_parent " +
            "    FROM " +
            "        structure s " +
            "    JOIN " +
            "        structure_hierarchy sh ON s.id_structure = sh.structure_parent " +
            ")" +
            "SELECT " +
            "    sh.id_structure, " +
            "    sh.nom_structure " +
            "FROM " +
            "    structure_hierarchy sh " +
            "WHERE " +
            "    sh.structure_parent IS NOT NULL " +
            "ORDER BY id_structure " +
            "LIMIT 1", nativeQuery = true)
    Object findTopParentStructureByUserId(@Param("userId") Long userId);
}
