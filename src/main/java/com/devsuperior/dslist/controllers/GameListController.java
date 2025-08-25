package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService; // Está aqui porque há um método que, COM BASE NA TABELA Game List, retorna Game
	
	
	@GetMapping
	public List<GameListDTO> findAll() {
		return gameListService.findAll();
	}
	
	
	@GetMapping(value = "/{listId}/games") /* Será 'lists/{id da lista}/games'
											  ("dentre as LISTAS, na LISTA de Id 'X', temos tais JOGOS")					    */
	
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		return gameService.findByList(listId);
	}
	
	
	
	
	@PostMapping(value = "/{listId}/replacement") /* Usado aqui pois o método responde a uma requisição HTTP do *tipo POST* 
	
	                                                 - Se fosse uma busca e não alterasse o estado da tabela, seria GET         */
	
    /* Método que troca itens (jogos) de posição entre si na respectiva tabela/lista de jogos.
     
       	- Essa operação NÃO É IDEMPOTENTE (quando uma ação executada várias vezes dá no mesmo)
          pois, a cada execução (troca de posição entre itens), a tabela será alterada.                                         */
	
	public void move (@PathVariable Long listId, @RequestBody ReplacementDTO body) {
/*                                                    * -----------------------------> Faz com que o objeto ReplacementDTO seja
 																					   preenchido automaticamente com os dados
 																					   enviados no corpo (body) da requisição HTTP
 																					   (que estará em JSON em "/replacement")       */
		
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex()); /* Pega os valores necessários
		                                                                                    dos atributos de ReplacementDTO     */
		
	}

}
