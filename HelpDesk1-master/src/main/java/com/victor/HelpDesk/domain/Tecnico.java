package com.victor.HelpDesk.domain;

//import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.victor.HelpDesk.domain.DTO.TecnicoDTO;
import com.victor.HelpDesk.domain.enums.Perfil;

/** @noinspection ALL */
@Entity //Esta anotação indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.
public class Tecnico extends Pessoa //Esta linha declara a classe Tecnico como uma subclasse da classe Pessoa. Isso significa que Tecnico herda todos os campos e métodos de Pessoa.
{
    private static final long serialVersionUID = 1L; //Esta linha declara um campo de serialização estática que é usado para garantir a compatibilidade entre diferentes versões da classe durante a serialização.

    //Essas anotações configuram o relacionamento entre Tecnico e Chamado. Indica que um técnico pode ter vários chamados e configura o mapeamento bidirecional entre as entidades.

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    //Este é o construtor padrão da classe Tecnico. Ele chama o construtor da superclasse Pessoa e adiciona o perfil de cliente ao técnico.

    public Tecnico() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    //Este é um construtor sobrecarregado da classe Tecnico. Ele chama o construtor da superclasse Pessoa e adiciona o perfil de cliente ao técnico.

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

    /** @noinspection StreamToLoop, Convert2MethodRef , LambdaParameterTypeCanBeSpecified */

    //Este construtor converte um objeto TecnicoDTO em um objeto Tecnico, inicializando os campos correspondentes. Ele usa a API de stream para mapear os perfis do DTO para os códigos de perfil da enumeração Perfil.
    public Tecnico(TecnicoDTO obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }

        //Retorna a lista de chamados deste Tecnico
    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    } //Esta linha atribui a lista de chamados passada como argumento ao campo chamados do objeto atual (this). Isso atualiza a lista de chamados associada a este técnico com a lista fornecida como argumento.

}