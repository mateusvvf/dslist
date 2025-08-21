package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

//       ou '@Component' -> Annotations necessários para a classe de serviços
@Service 
public class GameService { /* Service, ou classe de serviço:
                              Classe que coloca em prática os métodos CRUD do Repository,
                              implementando-os de acordo com as ações do usuário no sistema
                              (ex.: buscar um jogo, salvar, atualizar, etc.)
                              
                              - Normalmente retorna DTOs.					                                 */
	
	
	@Autowired // Aqui, uma instância configurada do Repository é INJETADA para que possamos usar seus métodos
	private GameRepository gameRepository; // Conceito de inversão de controle, não precisar alterar nada aqui
	
	
	
	@Transactional(readOnly = true) /*     *1: De 'transação' em Banco de Dados. Garante que ou tudo dá certo, ou nada ocorre.
	      *1              *2               *2: Spring não abre uma transação de escrita sem necessidade -> mais performance 
	                                           - Só usado em operações que busca e leitura.                                  */ 
											 
	
	public List<GameMinDTO> findAll() { // Método que retornará todos os itens da tabela usando a interface
		
		List<Game> result = gameRepository.findAll(); // 'findAll()' retorna List
		
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		// Converte todos os itens (jogos) no tipo DTO, que só irá conter as colunas desejadas (ver DTO)
		
		return dto;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) { // Método que retornará um item (jogo) de acordo com seu ID
		
		Game result = gameRepository.findById(id).get(); /* 'findById' retorna Optional pela chance de não haver nenhum Id.
		                                                    Como o .get() força o valor, seria ideal um tratamento de excessão.     */
		
		GameDTO dto = new GameDTO(result);
		
		return dto;
		
	}
	
	
	
}
