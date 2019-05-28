package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioRepository;
import com.example.demo.model.UsuarioRepositoryDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// configura las urls que por defecto estan disponibles sin autenticacion
		http.authorizeRequests()
				// permitimos estas urls sin autenticacion
				// console se usa para poder acceder a la pagina de configuracion de la base de
				// datos
				// permitir que ignore los ficheros de la carpeta css para evitar problemas de redireccion
				// si se anaden mas ficheros como librerias javascripts, anadirlos a la carpeta /lib 
				.antMatchers("/", "/console/**", "/css/**", "/js/**").permitAll().anyRequest().authenticated()

				.and()

				.formLogin().loginPage("/login").permitAll()

				.and()

				.logout().logoutSuccessUrl("/").permitAll();

		// solo usar durante la fase de desarrollo para poder acceder a la pagina de
		// administracion de la base de datos
		// despues comentar estas lineas
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, UsuarioRepositoryDetailsService userDetailsService,
			UsuarioRepository usuarioRepository) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

		// Crear usuario por defecto
		Usuario user = new Usuario("psychys","test","test@test.com",1);
/*		user.setEmail("test@test.com");
		// la contraseña es test (encriptada usando bcrypt)
		// https://www.dailycred.com/article/bcrypt-calculator
		user.setPassword("$2a$04$mhVuX7/zGzhPu7xKCrqY8e7M0RkORqZ4QB/4rCEgYQNddyt1mAKZK");
		user.setFirstName("Alan");
		user.setLastName("Wake");*/
		if (usuarioRepository.FindByEmail(user.getMail()) == null) {
			usuarioRepository.save(user);
		}
	}
}
