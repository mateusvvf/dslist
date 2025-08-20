package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

/* CONTROLADOR: intermediário ou ponte entre o Front-End e o Back-End (mas tbm faz parte do back-end)
                
                - Recebe pedidos "de fora" (ou seja, ações do usuário no front-end) e aciona o back-end.
                - Aciona a camada de Serviços, que aciona a camada de Acesso a Dados (entidades, repository etc).      
                - Devolve resposta.                                                                                     */


@RestController /* Indica justamente que a classe é um Controlador REST
 				   Diz "Essa classe é uma API que responde com dados, não páginas (ex.: HTML)."                         */

@RequestMapping(value = "/games") // Indica o caminho das requisições/pedidos que essa classe vai atender ('/games')
public class GameController { 
	
	@Autowired
	private GameService gameService; // Aqui, é INJETADA a classe de serviços (ou apenas service) p/ usarmos seus métodos
	
	
	/* Requisições HTTP: "pedidos"/requisições feitas pelo usuário, que usam Métodos HTTP (GET, POST, PUT, DELETE)      */
	
	@GetMapping // Usado aqui pois o método é uma BUSCA e, portanto, responde a uma requisição HTTP do *tipo GET*
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
	

}
