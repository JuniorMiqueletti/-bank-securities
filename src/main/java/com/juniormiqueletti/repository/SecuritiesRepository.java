package com.juniormiqueletti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juniormiqueletti.model.Securities;

import java.util.List;

public interface SecuritiesRepository extends JpaRepository<Securities, Long> {

    public List<Securities> findByDescriptionContaining(String description);
}
