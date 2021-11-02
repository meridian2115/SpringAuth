package com.example.demoauth.repository;

import com.example.demoauth.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fedor Danilov 01.11.2021
 */
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
