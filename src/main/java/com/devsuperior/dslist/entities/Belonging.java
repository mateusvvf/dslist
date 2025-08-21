package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")

public class Belonging { // Classe que representa a ENTIDADE ASSOCIATIVA entre Game <--> GameList (Muitos pra Muitos)
	
	
	@EmbeddedId // Identifica que o atributo abaixo é a combinação das chaves primárias (PK composta) das tabelas envolvidas
	

	private BelongingPK id = new BelongingPK(); /* Atributo que combina as duas chaves primárias (os IDs de Game e GameList)
	
	                           						- A classe/tipo auxiliar 'BelongingPK' precisa existir para que aqui
	                             					  essa combinação de múltiplos PKs (IDs) possa ser representada
	                             					  por um ÚNICO ATRIBUTO (obrigatório)  */
	
	private Integer position;
	
	
	public Belonging() {
	
	}
	
	public Belonging(Game game, GameList list, Integer position) { // Aqui se informam o jogo, a lista e a posição
		id.setGame(game);
		id.setList(list);
		this.position = position;
	}
	

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
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
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
