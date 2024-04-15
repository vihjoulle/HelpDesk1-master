package com.victor.HelpDesk.Repositories;

import com.victor.HelpDesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository; //Este import traz a interface JpaRepository do Spring Data JPA, que fornece métodos para acessar e manipular dados de uma entidade JPA.

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>  //Esta linha declara a interface TecnicoRepository, que estende JpaRepository<Tecnico, Integer>. Isso significa que TecnicoRepository herda todos os métodos definidos em JpaRepository e está associado à entidade Tecnico, usando Integer como o tipo de dado para a chave primária. Essa interface fornece métodos como salvar, excluir, encontrar por ID, encontrar todos, etc., para a entidade Tecnico. Esses métodos são implementados automaticamente pelo Spring Data JPA.
{
}
