package com.victor.HelpDesk.Service;


import com.victor.HelpDesk.Repositories.ChamadoRepository;
import com.victor.HelpDesk.Service.Exceptions.ObjectnotFoundException;
import com.victor.HelpDesk.domain.Chamado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    public Chamado findById(Integer id){
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID:" + id));
    }
}
