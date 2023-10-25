package br.edu.atitus.atitusound.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.entities.GenericEntity;

public interface GenericService <TEntidade extends GenericEntity> {

	default void validateSave(ArtistEntity entidade) throws Exception{
	if (entidade.getName() == null || entidade.getName().isEmpty())
		throw new Exception("Campo Name Inválido!");
	if (entidade.getUuid()==null) {
		if (artistRepository.existsByName(entidade.getName()))
			throw new Exception("Ja existe registro com esse nome");
	}else {
	if (!artistRepository.existsById(entidade.getUuid()))
		throw new Exception ("Registro não encontrado com este uuid");
	if (artistRepository.existsByNameAndUuidNot(entidade.getName(),entidade.getUuid()))
			throw new Exception ("Ja existe registro com este nome");
	}
}
	default ArtistEntity save(ArtistEntity entidade) throws Exception {
		validateSave(entidade);
		artistRepository.save(entidade);
		return entidade;
		
	}
	
	default List<ArtistEntity> findAll() throws Exception{
		return artistRepository.findAll();
	}
	
	default void validateFindByName(Pageable pageable, String name)throws Exception{
	}
	

	default Page<List<ArtistEntity>> findByNameContainingIgnoreCase(Pageable pageable, String name) throws Exception {
		validateFindByName(pageable,name);
		return artistRepository.findByNameContainingIgnoreCase(pageable, name);
	}
	
	default void validateFindById (UUID uuid) throws Exception {
		
	}
	public Optional<ArtistEntity> findById (UUID uuid) throws Exception{
		validateFindById (uuid);
		return artistRepository.findById(uuid);
	}
	
	default void validateDeleteById (UUID uuid) throws Exception {
		if (!artistRepository.existsById(uuid))
			throw new Exception ("Registro não encontrado com este UUID");
}
	default void deleteById(UUID uuid) throws Exception {
		validateDeleteById(uuid);
		artistRepository.deleteById(uuid);
		
	}
}
