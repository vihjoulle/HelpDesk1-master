package com.victor.HelpDesk.domain.DTO;

//import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.victor.HelpDesk.domain.Cliente;
import com.victor.HelpDesk.domain.Tecnico;
import com.victor.HelpDesk.domain.enums.Perfil;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;


/** @noinspection Convert2Diamond, UnnecessarySemicolon , LambdaCanBeReplacedWithAnonymous */
public class TecnicoDTO implements Serializable //Declaração da classe TecnicoDTO, que implementa a interface Serializable.
{
    private static final long serialVersionUID = 1L; //Define o número de versão da classe para fins de serialização.


    //Declaração de variáveis de instância que representam os atributos de um técnico, como id, nome, cpf, email, senha e perfis.
    // Algumas dessas variáveis possuem anotações de validação, como @NotNull e @CPF.

    protected Integer id;
    @NotNull(message = "O campo NOME é requerido")
    protected String nome;
    @NotNull(message = "O campo CPF é requerido")
    @CPF
    protected String cpf;
    @NotNull(message = "O campo EMAIL é requerido")
    protected String email;
    @NotNull(message = "O campo SENHA é requerido")
    protected String senha;
    protected Set<Integer> perfis = new HashSet<>();

    //Anotação que indica o formato de serialização para o campo dataCriacao.
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    //Construtor padrão que inicializa a lista de perfis com o perfil de técnico.
    public TecnicoDTO() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    //Construtor que recebe um objeto Tecnico como parâmetro e inicializa os atributos do DTO com os valores do objeto Tecnico.

    public TecnicoDTO(Tecnico obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
        addPerfil(Perfil.CLIENTE);
    }

    //Métodos getter e setter.

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Métodos para obter a lista de perfis do técnico DTO e adicionar um perfil à lista de perfis.

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }


    //Métodos getter e setter para o atributo dataCriacao.

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}