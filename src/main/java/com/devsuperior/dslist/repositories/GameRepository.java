package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;


/* Interface de 'Game' que permitirá executar ações CRUD (no banco de dados/tabela de Game)
   em forma de métodos prontos por meio da interface JpaRepository, que é estendida aqui.                 */

public interface GameRepository extends JpaRepository<Game,Long>{
//	                                                         * ---> Tipo da chave primária da tabela de Game

	
	
	// @Query: Usado para fazer BUSCAS PERSONALIZADAS e mais específicas que os métodos de JpaRepository não cubram
	
	/* - A busca específica abaixo* envolve uma variável (':listId'), então exibirá diferentes resultados de acordo com ela
	     
	     *Faz um SELECT que mostrará apenas jogos que estiverem em uma lista X (':listId') 
	     
	   - O resultado de uma Query/consulta com 'nativeQuery=true' precisa ser do tipo Projection (INTERFACE)*/
	
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game															
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId); // Método que fará a busca (no caso, com base no parâmetro 'listId')
	
}
