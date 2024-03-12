package com.victor.HelpDesk.Service;

import com.victor.HelpDesk.Repositories.PessoaRepository;
import com.victor.HelpDesk.Repositories.TecnicoRepository;
import com.victor.HelpDesk.Service.Exceptions.ObjectnotFoundException;
import com.victor.HelpDesk.domain.DTO.TecnicoDTO;
import com.victor.HelpDesk.domain.Pessoa;
import com.victor.HelpDesk.domain.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** @noinspection ALL*/
@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id:" + id));
    }

    public List<Tecnico> findAll() {

        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO) {
        objDTO.setId(null);
        validaPorCpfEEmail(objDTO);
     Tecnico newObj = new Tecnico(objDTO);
     return repository.save(newObj);
    }

    private void validaPorCpfEEmail(TecnicoDTO objDTO) {
    Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
    if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
    throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
    }
    obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }
}
