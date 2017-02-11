package com.juniormiqueletti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juniormiqueletti.model.Securities;

public interface SecuritiesRepository extends JpaRepository<Securities, Long> {

}
