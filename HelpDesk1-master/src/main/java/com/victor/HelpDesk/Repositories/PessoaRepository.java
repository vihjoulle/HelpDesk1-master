package com.victor.HelpDesk.Repositories;

import com.victor.HelpDesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository; //Este import traz a interface JpaRepository do Spring Data JPA, que fornece métodos para acessar e manipular dados de uma entidade JPA.

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>  //Esta linha declara a interface PessoaRepository, que estende JpaRepository<Pessoa, Integer>. Isso significa que PessoaRepository
// herda todos os métodos definidos em JpaRepository e está associado à entidade Pessoa, usando Integer como o tipo de dado para a chave primária. Essa interface fornece métodos como salvar, excluir, encontrar por ID, encontrar todos, etc., para a entidade Pessoa. Esses métodos são implementados automaticamente pelo Spring Data JPA.
{

    //Esses métodos definem consultas personalizadas. findByCpf e findByEmail são métodos de consulta derivados do nome, que serão
    // implementados automaticamente pelo Spring Data JPA. Eles retornam um objeto Optional de Pessoa com base no CPF ou e-mail
    // fornecido, respectivamente. Se nenhum resultado for encontrado, o Optional estará vazio.

  Optional<Pessoa> findByCpf(String cpf);
      Optional<Pessoa> findByEmail(String email);
}
