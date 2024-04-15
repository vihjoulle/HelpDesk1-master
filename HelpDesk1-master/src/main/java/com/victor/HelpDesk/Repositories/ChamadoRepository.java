package com.victor.HelpDesk.Repositories;

import com.victor.HelpDesk.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository; //Este import traz a interface JpaRepository do Spring Data JPA, que fornece métodos para acessar e manipular dados de uma entidade JPA.

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>  //Esta linha declara a interface ChamadoRepository, que estende JpaRepository<Chamado, Integer>. Isso significa que ChamadoRepository
// herda todos os métodos definidos em JpaRepository e está associado à entidade Chamado, usando Integer como o tipo de dado para a chave primária. Essa interface fornece métodos como salvar, excluir, encontrar por ID, encontrar todos, etc., para a entidade Chamado. Esses métodos são implementados automaticamente pelo Spring Data JPA.
{
}
