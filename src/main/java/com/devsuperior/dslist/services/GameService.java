package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

//       ou '@Component' -> Annotations necessários para a classe de serviços
@Service 
public class GameService { /* Service, ou classe de serviço:
                              Classe que coloca em prática os métodos CRUD do Repository,
                              implementando-as de acordo com as ações do usuário no sistema
                              (ex.: buscar um jogo, salvar, atualizar, etc.)
                              
                              - Normalmente retorna DTOs.					                                 */
	
	
	@Autowired // Aqui, uma instância configurada do Repository é INJETADA para que possamos usar seus métodos
	private GameRepository gameRepository; // Conceito de inversão de controle, não precisar alterar nada aqui
	
	
	public List<GameMinDTO> findAll() { // Método que retornará todos os itens da tabela usando a interface
		
		List<Game> result = gameRepository.findAll(); // 'findAll()' retorna List
		
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		// Converte todos os itens (jogos) no tipo DTO, que só irá conter as colunas desejadas (ver DTO)
		
		return dto;
	}
	
	
	
}
