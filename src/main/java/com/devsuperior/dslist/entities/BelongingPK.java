package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable /* Necessário ao encapsular mais de um atributo/coluna em uma única classe que será embutida em outra (entidade)

               - Está aqui porque encapsula duas PKs (de Game e GameList) que, unidas, formam a PK de Belonging              */


public class BelongingPK { /* Classe auxiliar que COMBINA duas PKs (IDs de Game e GameList) em um só tipo
                              para que possamos referenciá-lo/utilizá-lo na classe da Entidade Associativa (Belonging)  
                              
                              - Representa a CHAVE PRIMÁRIA COMPOSTA.
                              
                              - No hashCode & Equals da classe, é necessário usar todos os atributos                     */
	
	@ManyToOne /* Especifica que a relação entre a Entidade Associativa Belonging e Game/GameList é Muitos para Um.
	              
	              - MUITOS Belonging apontam para o mesmo (UM) Game porque um jogo pode estar em várias listas diferentes.
																	
                    Muitos Belonging apontam para a mesma GameList porque uma lista pode conter vários jogos diferentes. */
	
	@JoinColumn(name = "game_id") // Coluna com a chave estrangeira (no caso, ID do jogo) e o nome dessa coluna ('name')
	private Game game;            // que será criada na entidade associativa (no caso, Belonging)
	
	@ManyToOne
	@JoinColumn(name = "list_id") // Então, na tabela que relaciona Game e GameList, teremos as PKs (IDs) de cada um
	private GameList list;
	
	
	/* *Mesmo sem especificarmos aqui o atributo que representa a chave primária de Game/GameList (que é Long 'Id'),
	    o JPA sabe qual é ela porque já especificamos isso (qual atributo é a PK) dentro dessas classes. */
	
	
	public BelongingPK() {
		
	}


	public BelongingPK(Game game, GameList list) {
		super();
		this.game = game;
		this.list = list;
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public GameList getList() {
		return list;
	}


	public void setList(GameList list) {
		this.list = list;
	}


	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
	
	
}
