package com.example.demoauth.repository;

import com.example.demoauth.models.EMenu;
import com.example.demoauth.models.MenuPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Fedor Danilov 01.11.2021
 */
@Repository
public interface MenuPositionRepository extends JpaRepository<MenuPosition, Long> {
    Optional<MenuPosition> findByName(EMenu name);
}
