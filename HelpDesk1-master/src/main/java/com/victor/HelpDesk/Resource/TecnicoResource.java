package com.victor.HelpDesk.Resource;

import com.victor.HelpDesk.Service.TecnicoService;
import com.victor.HelpDesk.domain.DTO.TecnicoDTO;
import com.victor.HelpDesk.domain.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

    //localhost:8080/tecnicos/1

    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findbyId(@PathVariable Integer id) {
    Tecnico obj = service.findById(id);
    return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }
}
