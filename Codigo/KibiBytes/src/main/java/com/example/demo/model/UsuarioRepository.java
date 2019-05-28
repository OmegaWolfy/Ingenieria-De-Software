package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	Usuario FindByEmail(String email);
}
