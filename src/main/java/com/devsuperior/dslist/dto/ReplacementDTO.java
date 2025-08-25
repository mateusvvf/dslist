package com.devsuperior.dslist.dto;

public class ReplacementDTO { /* Essa DTO recebe e armazena dados/valores vindos do (enviados pelo) front-end

                                 - Recebe os dados necessários para que, em outras áreas do código,
                                   haja trocas de posição entre os itens (jogos) de uma lista no banco de dados.               */ 
	
	private Integer sourceIndex;
	private Integer destinationIndex;
	
	
	public Integer getSourceIndex() {
		return sourceIndex;
	}
	public void setSourceIndex(Integer sourceIndex) {
		this.sourceIndex = sourceIndex;
	}
	public Integer getDestinationIndex() {
		return destinationIndex;
	}
	public void setDestinationIndex(Integer destinationIndex) {
		this.destinationIndex = destinationIndex;
	}
	
	

}
