package com.victor.HelpDesk.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.victor.HelpDesk.domain.enums.Prioridade;
import com.victor.HelpDesk.domain.enums.Status;
import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/** @noinspection ALL*/
@Entity //Esta anotação marca a classe Chamado como uma entidade JPA, o que significa que ela será mapeada para uma tabela no banco de dados.
public class Chamado implements Serializable //Esta linha inicia a declaração da classe Chamado, que implementa a interface Serializable, indicando
// que os objetos dessa classe podem ser serializados.
{
    private static final long serialVersionUID =  1L; //Esta linha declara um campo estático que é usado durante a serialização e desserialização de objetos da
    // classe.

    //Estas linhas declaram o identificador da entidade (id) e especificam que ele é gerado automaticamente pelo banco de dados com a estratégia IDENTITY,
    // o que geralmente significa que é uma chave primária autoincrementada.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Estas linhas declaram campos para a data de abertura e fechamento do chamado, utilizando a anotação @JsonFormat para formatar a data durante a serialização.
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    //Estas linhas declaram campos para a prioridade, status, título e observações do chamado.
    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacoes;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    //Estas linhas declaram associações muitos-para-um com as entidades Tecnico e Cliente, indicando que um chamado pertence a um técnico e a um cliente.
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //Este é o construtor padrão da classe Chamado.

    public Chamado(){
        super();
    }

    //Este é um construtor sobrecarregado que inicializa os campos da classe com os valores fornecidos.

    public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    //Estes são os métodos equals() e hashCode() que são sobrepostos para garantir a consistência dos objetos Chamado quando são usados em estruturas
    // de dados que dependem desses métodos, como conjuntos (Set). O método equals() compara os objetos com base em seus identificadores, enquanto o
    // método hashCode() gera um código de hash com base no identificador.

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

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chamado chamado = (Chamado) o;
        return Objects.equals(id, chamado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
