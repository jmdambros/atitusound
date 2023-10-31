package br.edu.atitus.atitusound.servicesimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.atitus.atitusound.entities.PlaylistEntity;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import br.edu.atitus.atitusound.repositories.PlaylistRepository;
import br.edu.atitus.atitusound.services.PlaylistService;
@Service                                                                                                               
public class PlaylistServiceImpl implements PlaylistService{
	private final PlaylistRepository playlistRepository;

	public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
		super();
		this.playlistRepository = playlistRepository;
	}

	@Override
	public GenericRepository<PlaylistEntity> getRepository() {
		return playlistRepository;
	}

}