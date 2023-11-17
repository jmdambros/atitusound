	package br.edu.atitus.atitusound.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.atitusound.dtos.ArtistDTO;
import br.edu.atitus.atitusound.dtos.PlaylistDTO;
import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.entities.PlaylistEntity;
import br.edu.atitus.atitusound.services.ArtistService;
import br.edu.atitus.atitusound.services.GenericService;
import br.edu.atitus.atitusound.services.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController extends GenericController<PlaylistEntity,PlaylistDTO>{
	private final PlaylistService playlistService;

	public PlaylistController(PlaylistService playlistService) {
		super();
		this.playlistService = playlistService;
	}

	
	protected PlaylistEntity convertDTO2Entity(PlaylistDTO dto) {
		PlaylistEntity playlist = new PlaylistEntity();
		playlist.setName(dto.getName());
		playlist.setPublic_share(dto.getPublic_share());
		return playlist;
	}


	@Override
	protected GenericService<PlaylistEntity> getService() {
		return playlistService;
	}
		
}
