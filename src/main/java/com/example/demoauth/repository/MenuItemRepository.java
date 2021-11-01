package com.example.demoauth.repository;

import com.example.demoauth.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fedor Danilov 01.11.2021
 */
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
