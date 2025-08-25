package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService{
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) { // Troca itens/jogos de posição na tabela
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection moved = list.remove(sourceIndex);
		
		list.add(destinationIndex, moved); // Até aqui, atualiza as posições EM MEMÓRIA (na list em Java, ainda não na tabela)
		
		// A partir daqui, usaremos a lista atualizada para também atualizar a tabela no banco de dados
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex; // Define o intervalo de itens que terão suas
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex; // posições afetadas na tabela
		                                                                           // ("jogados pra frente") pela operação.
	
		// Para cada item no intervalo, alterar sua posição usando a query updateBelongingPosition (ver em GameListRepository)
		for (int i = min; i <= max; i++) gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i); 
	}
	

}
