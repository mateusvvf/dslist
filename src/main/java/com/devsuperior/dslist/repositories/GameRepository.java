package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;


/* Interface de 'Game' que permitirá executar ações CRUD (no banco de dados/tabela de Game)
   em forma de métodos prontos por meio da interface JpaRepository, que é estendida aqui.                 */

public interface GameRepository extends JpaRepository<Game,Long>{
//	                                                         * ---> Tipo da chave primária da tabela de Game

}
