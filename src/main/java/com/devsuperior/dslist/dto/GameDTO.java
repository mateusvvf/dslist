package com.devsuperior.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.devsuperior.dslist.entities.Game;

public class GameDTO { /* Classe DTO com TODOS os atributos de Game, que serão mostrados ao clicar em/expandir um jogo

                          - Mesmo com a classe 'Game' completa já existindo, é recomendado fazer esse DTO.
                          - Por boas práticas, Controladores só devem retornar DTOs pro front-end                           */
	
	private Long id;
	private String title;
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;
	
	
	public GameDTO() {
		
	}
	
	public GameDTO(Game entity) { // Construtor pegando todos os atributos de 'Game' (nesse caso, sem exceção)
		
		BeanUtils.copyProperties(entity, this);
/*	       *1          *2         *2.1    *2.2             *1: Classe utilitária do Spring Framework
                                                           *2: Método que copia todos os valores de atributos:
                                                               *2.1: De uma outra classe...
                                                               *2.2: Para a classe em que estiver sendo utilizada.
                                                               
                                                               --> Os nomes dos atributos precisam ser iguais!
                                                               --> São necessários Getters E SETTERS para funcionar!        */
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	
	
	
}
