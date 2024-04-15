package com.victor.HelpDesk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.victor.HelpDesk.domain.DTO.ClienteDTO;
import com.victor.HelpDesk.domain.enums.Perfil;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** @noinspection DataFlowIssue*/
@Entity //Esta anotação marca a classe Cliente como uma entidade JPA, o que significa que ela será mapeada para uma tabela no banco de dados.

//Esta linha indica que a classe Cliente estende a classe Pessoa, o que significa que Cliente herda todos os campos e métodos de Pessoa.
public class Cliente extends Pessoa {
    private static final long serialVersionUID = 1L; //Esta linha declara um campo estático que é usado durante a serialização e desserialização de objetos da classe.

    //Estas linhas declaram uma lista de chamados associados a este cliente. A anotação @JsonIgnore indica que esta propriedade deve ser ignorada durante a serialização
    // JSON. A anotação @OneToMany indica que um cliente pode ter vários chamados associados a ele, e o atributo mappedBy = "cliente" especifica que a relação é mapeada pelo campo cliente na classe Chamado.
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    //Este é o construtor padrão da classe Cliente. Ele chama o construtor da classe pai (Pessoa) e adiciona o perfil de cliente ao cliente.

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    //Este é um construtor sobrecarregado que inicializa os campos da classe Cliente com os valores fornecidos.

    /** @noinspection SillyAssignment*/
    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        this.chamados = chamados;
    }

    //Este é um construtor que aceita um objeto ClienteDTO como argumento e inicializa os campos da classe Cliente com os valores correspondentes do objeto ClienteDTO.

    public Cliente(ClienteDTO obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }

    //Estes são métodos de acesso para obter e definir a lista de chamados associados a este cliente.

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
