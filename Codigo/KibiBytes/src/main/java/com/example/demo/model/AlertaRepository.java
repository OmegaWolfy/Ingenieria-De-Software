package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta,String>{

	Alerta FindByNombre(String alertaname);

}
