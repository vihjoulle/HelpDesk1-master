package com.victor.HelpDesk;

import com.victor.HelpDesk.Repositories.ChamadoRepository;
import com.victor.HelpDesk.Repositories.ClienteRepository;
import com.victor.HelpDesk.Repositories.TecnicoRepository;
import com.victor.HelpDesk.domain.Chamado;
import com.victor.HelpDesk.domain.Cliente;
import com.victor.HelpDesk.domain.Tecnico;
import com.victor.HelpDesk.domain.enums.Perfil;
import com.victor.HelpDesk.domain.enums.Prioridade;
import com.victor.HelpDesk.domain.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpDeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;
	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}

	/** @noinspection unused, RedundantExplicitVariableType */
	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Victor Oliveira","77687096754","victor_oliveira@email.com" ,"123");
			tec1.addPerfil(Perfil.ADMIN);

			Cliente cli1 = new Cliente (null, "Linus Torvalds", "70511744013","torvalds@email.com","123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 01","Primeiro chamado",tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
