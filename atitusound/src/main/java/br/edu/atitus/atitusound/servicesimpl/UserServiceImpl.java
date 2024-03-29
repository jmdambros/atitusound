package br.edu.atitus.atitusound.servicesimpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.atitus.atitusound.entities.UserEntity;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import br.edu.atitus.atitusound.repositories.UserRepository;
import br.edu.atitus.atitusound.services.UserService;
@Service
public class UserServiceImpl implements UserService,UserDetailsService{
private final UserRepository userRepository;
private final PasswordEncoder encoder;


	public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
	super();
	this.userRepository = userRepository;
	this.encoder = encoder;
}



	@Override
	public GenericRepository<UserEntity> getRepository() {
		// TODO Auto-generated method stub
		return userRepository;
	
	}



	@Override
	public void validateSave(UserEntity entidade) throws Exception {
		UserService.super.validateSave(entidade);
		if (entidade.getUsername() == null ||entidade.getUsername().isEmpty())
			throw new Exception ("Username inválido");
		if (entidade.getPassword() == null ||entidade.getPassword().isEmpty())
			throw new Exception ("Password inválida");
		entidade.setPassword(encoder.encode(entidade.getPassword()));
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com este nome"));
		return user;
	}

}
