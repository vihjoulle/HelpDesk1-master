package com.victor.HelpDesk.domain.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.victor.HelpDesk.domain.Chamado;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;


//public class ChamadoDTO implements Serializable {: Define a classe ChamadoDTO, que implementa a interface Serializable.
public class ChamadoDTO implements Serializable {

    //private static final long serialVersionUID =  1L;: Define o número de versão da classe para fins de serialização.
    private static final long serialVersionUID =  1L;

    //private Integer id;: Declara uma variável id do tipo Integer, que representa o identificador do chamado.
    private Integer id;

    //@JsonFormat(pattern = "dd/MM/yyyy"): Indica que a formatação da data para o campo dataAbertura e dataFechamento será "dd/MM/yyyy" ao serializar para JSON.
    @JsonFormat(pattern = "dd/MM/yyyy")
   // private LocalDate dataAbertura = LocalDate.now();: Declara uma variável dataAbertura do tipo LocalDate, que representa a data de abertura do chamado, inicializada com a data atual.
    private LocalDate dataAbertura = LocalDate.now();

    //private LocalDate dataFechamento;: Declara uma variável dataFechamento do tipo LocalDate, que representa a data de fechamento do chamado.
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;


   // @NotNull(message = "O campo PRIORIDADE é requerido"): Indica que o campo prioridade não pode ser nulo e define uma mensagem de erro personalizada caso seja.
    @NotNull(message = "O campo PRIORIDADE é requerido")
    private Integer prioridade;//: Declara uma variável prioridade do tipo Integer, que representa a prioridade do chamado.
    @NotNull(message = "O campo STATUS é requerido")//Indica que o campo status não pode ser nulo e define uma mensagem de erro personalizada caso seja.
    private Integer status; //Declara uma variável status do tipo Integer, que representa o status do chamado.
    @NotNull(message = "O campo TITULO é requerido")//Indica que o campo titulo não pode ser nulo e define uma mensagem de erro personalizada caso seja.
    private String titulo; //Declara uma variável titulo do tipo String, que representa o título do chamado.
    @NotNull(message = "O campo OBSERVAÇÕES é requerido") //Indica que o campo observacoes não pode ser nulo e define uma mensagem de erro personalizada caso seja.
    private String observacoes; //Declara uma variável observacoes do tipo String, que representa as observações do chamado.
    @NotNull(message = "O campo TECNICO é requerido") //Indica que o campo tecnico não pode ser nulo e define uma mensagem de erro personalizada caso seja.
    private Integer tecnico; //Declara uma variável tecnico do tipo Integer, que representa o técnico responsável pelo chamado.
    @NotNull(message = "O campo CLIENTE é requerido") //Indica que o campo cliente não pode ser nulo e define uma mensagem de erro personalizada caso seja.
    private Integer cliente; //Declara uma variável cliente do tipo Integer, que representa o cliente relacionado ao chamado.
    private String nomeTecnico; //Declara uma variável nomeTecnico do tipo String, que representa o nome do técnico relacionado ao chamado.
    private String nomeCliente; //Declara uma variável nomeCliente do tipo String, que representa o nome do cliente relacionado ao chamado.
    public ChamadoDTO() {
        super();
    } //Declara um construtor padrão para a classe ChamadoDTO.

    public ChamadoDTO(Chamado obj) //Declara um construtor que recebe um objeto Chamado como parâmetro e inicializa os atributos do DTO com os valores do objeto Chamado.
    {
        super();
        this.id = obj.getId();
        this.dataAbertura = obj.getDataAbertura();
        this.dataFechamento = obj.getDataFechamento();
        this.prioridade = obj.getPrioridade().getCodigo();
        this.status = obj.getStatus().getCodigo();
        this.titulo = obj.getTitulo();
        this.observacoes = obj.getObservacoes();
        this.tecnico = obj.getTecnico().getId();
        this.cliente = obj.getCliente().getId();
        this.nomeTecnico = obj.getCliente().getNome();
        this.nomeCliente = obj.getTecnico().getNome();
    }

    //Métodos getters e setters: São métodos para acessar e modificar os atributos da classe. Eles permitem o
    // encapsulamento dos dados e são usados para garantir o princípio de encapsulamento.

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getTecnico() {
        return tecnico;
    }

    public void setTecnico(Integer tecnico) {
        this.tecnico = tecnico;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
