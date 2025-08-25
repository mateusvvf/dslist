package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
	
	@Modifying /* Annotation usada para operações que ALTERAM o banco de dados (UPDATE, DELETE, INSERT...)
	
	 			  - Essa query, por exemplo, trocará as posições (coluna Position) de jogos/itens na tabela                        */
	
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

}
