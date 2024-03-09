package com.victor.HelpDesk.Service;

import com.victor.HelpDesk.Repositories.TecnicoRepository;
import com.victor.HelpDesk.Service.Exceptions.ObjectnotFoundException;
import com.victor.HelpDesk.domain.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id:" + id));
    }

    public List<Tecnico> findAll() {

        return repository.findAll();
    }
}
