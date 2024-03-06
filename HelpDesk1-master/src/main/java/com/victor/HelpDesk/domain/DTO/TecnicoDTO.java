package com.victor.HelpDesk.domain.DTO;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.victor.HelpDesk.domain.Tecnico;
import com.victor.HelpDesk.domain.enums.Perfil;


/** @noinspection Convert2Diamond, UnnecessarySemicolon */
public class TecnicoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected Integer id;
    protected String nome;
    protected String cpf;
    protected String Email;
    protected String senha;
    protected Set<Integer> perfis = new HashSet<Integer>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public TecnicoDTO() {
        super();;
    }

    /** @noinspection StreamToLoop, Convert2MethodRef , LambdaParameterTypeCanBeSpecified */
    public TecnicoDTO(Tecnico obj) {
        super();
        this.id = obj.getId();
        this.nome =obj.getNome();
        this.cpf = obj.getCpf();
        this.Email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis =obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
        addPerfil(Perfil.CLIENTE);
        addPerfil(Perfil.CLIENTE);
    }

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
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> {
            try {
                return Perfil.toEnum(x);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}