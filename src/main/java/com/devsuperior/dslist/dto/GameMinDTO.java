package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;

public class GameMinDTO { /* Versão resumida de Game. Mostra apenas o "essencial"/desejado no front-end

                             - Uma classe DTO não está mapeada com o banco, é independente dele.        */
	
	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	
	public GameMinDTO() {
		
	}

//                    ***********
	public GameMinDTO(Game entity) { /* Aqui, GameMinDTO é instanciado/construído tendo como parâmetro
	                                    um objeto Game, que é justamente sua versão completa/mais detalhada  */ 

		id = entity.getId();
		title = entity.getTitle();    // Os atributos são preenchidos com os da Classe/tabela completa
		year = entity.getYear();      // (só não tem 'this.' porque não há ambiguidade nos nomes)
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}

	
	
	// Abaixo, nota-se que APENAS GETTERS são necessários no DTO:
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	
	

}
