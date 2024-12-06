package org.example.dao;

import org.example.domein.Autosoort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutosoortRepository extends JpaRepository<Autosoort, Long> {

    Optional<Autosoort> findByNaam(String naam);
}
