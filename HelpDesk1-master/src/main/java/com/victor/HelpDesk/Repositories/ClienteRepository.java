package com.victor.HelpDesk.Repositories;

import com.victor.HelpDesk.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository; //Este import traz a interface JpaRepository do Spring Data JPA, que fornece métodos para acessar e manipular dados de uma entidade JPA.

public interface ClienteRepository extends JpaRepository<Cliente, Integer> //Esta linha declara a interface ClienteRepository, que estende JpaRepository<Cliente, Integer>. Isso significa que ClienteRepository
// herda todos os métodos definidos em JpaRepository e está associado à entidade Cliente, usando Integer como o tipo de dado para a chave primária. Essa interface fornece métodos como salvar, excluir, encontrar por ID, encontrar todos, etc., para a entidade Cliente. Esses métodos são implementados automaticamente pelo Spring Data JPA.
{
}