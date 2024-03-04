package com.victor.HelpDesk.Repositories;

import com.victor.HelpDesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
