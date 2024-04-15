package com.victor.HelpDesk.domain.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.victor.HelpDesk.domain.Cliente;
import com.victor.HelpDesk.domain.Tecnico;
import com.victor.HelpDesk.domain.enums.Perfil;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

//import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class ClienteDTO implements Serializable //Define a classe ClienteDTO, que implementa a interface Serializable.
{
    private static final long serialVersionUID = 1L; //Define o número de versão da classe para fins de serialização.

    //Declaração de variáveis de instância para representar os atributos de um cliente, como id, nome, cpf, email, senha, perfis e dataCriacao.

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

    @JsonFormat(pattern = "dd/MM/yyyy") //Indica que a formatação da data para o campo dataCriacao será "dd/MM/yyyy" ao serializar para JSON.
    protected LocalDate dataCriacao = LocalDate.now();

    public ClienteDTO() //Declara um construtor padrão para a classe ClienteDTO, inicializando a lista de perfis com o perfil de cliente.
    {
        super(); //Isso chama o construtor da classe pai. No contexto deste código, super() está chamando o construtor da classe Object, pois ClienteDTO não está explicitamente estendendo outra classe. No entanto, essa chamada é redundante porque o construtor padrão de Object
        // é chamado automaticamente se não houver chamada explícita a super().

        addPerfil(Perfil.CLIENTE); //Isso adiciona um perfil à lista de perfis do cliente DTO. Aqui, está adicionando o perfil de cliente à lista de perfis. Presumivelmente, addPerfil() é um método definido
        // dentro da classe ClienteDTO para adicionar perfis à lista de perfis do cliente. O perfil de cliente (Perfil.CLIENTE) é adicionado aqui durante a criação de um novo objeto ClienteDTO, garantindo que ele sempre tenha esse perfil padrão.
    }

    public ClienteDTO(Cliente obj) //Declara um construtor que recebe um objeto Cliente como parâmetro e inicializa os atributos do DTO com os valores do objeto Cliente.
    {
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

    //Métodos getters e setters: São métodos para acessar e modificar os atributos da classe. Eles permitem o encapsulamento dos dados
    // e são usados para garantir o princípio de encapsulamento.

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

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }//Adiciona um perfil à lista de perfis do cliente DTO.

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    } //Obtém a lista de perfis do cliente DTO convertendo os códigos de perfil em objetos de enumeração Perfil.

}