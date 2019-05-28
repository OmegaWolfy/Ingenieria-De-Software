package com.example.demo.model;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioRepositoryDetailsService implements UserDetailsService{

	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioRepositoryDetailsService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.FindByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Could not find user " + username);
		}
		String user;
		String clave;
		String mail;
		long id;
		
		user=usuario.getUser();
		clave=usuario.getPass();
		mail=usuario.getMail();
		id=usuario.getId();
		
		return new DetallesUsuario(user,clave,mail,id);
	}
	
	private final static class DetallesUsuario extends Usuario implements UserDetails {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5708084648279451366L;

		private DetallesUsuario(String user, String clave, String mail, long id) {
			super(user,clave,mail,id);
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}

		@Override
		public String getMail() {
			return getMail();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	}
