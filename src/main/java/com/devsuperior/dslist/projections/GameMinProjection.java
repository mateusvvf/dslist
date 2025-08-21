package com.devsuperior.dslist.projections;

public interface GameMinProjection { /* Interface Projection que permite consultas personalizadas (Query) num Repository
										(ver GameRepository)                                                               */

	
	/*Aqui, é preciso ter GETTERS que correspondam a cada coluna/atributo que a busca/Select quer mostrar
	        
	        - SEMPRE em camelCase
	        - Se, na busca, o nome estiver com apelido ('as'), o getter tem que usar esse apelido.                         */
	
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();

}
