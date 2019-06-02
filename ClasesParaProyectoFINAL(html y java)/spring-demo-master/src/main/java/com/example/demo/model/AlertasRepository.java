package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertasRepository extends JpaRepository<Alertas, String> {
	Alertas findBytrafico(String idalertas);

	
}