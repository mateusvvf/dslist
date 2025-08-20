package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Faz com que a classe seja uma tabela num banco de dados
@Table(name = "tb_game") // Nomeia a tabela como quiser (não obrigatório)
public class Game {
	
	@Id /* Define qual atributo será a chave primária
	       (será sempre o primeiro que estiver abaixo, no caso, 'id')*/
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Faz a chave primária ser 'Auto Increment'
	private Long id;
	
	
	private String title;
	
	@Column(name = "game_year") // Renomeia a coluna como quiser (não obrigatório)
	private Integer year;       // - Tudo que estiver em camelCase receberá underline (ex.: camel_Case)
	
	
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	
	@Column(columnDefinition = "TEXT") // Por padrão, String vai para a tabela como 'varchar(255)'.
	private String shortDescription; //   Portanto, convertemos campos com textos maiores para 'text'.
	
	@Column(columnDefinition = "TEXT")
	private String longDescription;
	
	
	public Game() {
		
	}


	public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl,
			String shortDescription, String longDescription) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
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


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
