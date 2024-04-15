package com.victor.HelpDesk.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.victor.HelpDesk.domain.enums.Perfil;
import javax.persistence.*;
import org.hibernate.validator.constraints.br.CPF;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity //Esta anotação marca a classe Pessoa como uma entidade JPA, o que significa que ela será mapeada para uma tabela no banco de dados.
public abstract class Pessoa implements Serializable  //Esta linha declara a classe Pessoa como abstrata, o que significa que ela não pode ser instanciada diretamente, apenas por meio de suas subclasses. Ela implementa a interface Serializable,
// o que significa que objetos dessa classe podem ser serializados.
{
    private static final long serialVersionUID = 1L; //Esta linha declara um campo estático que é usado durante a serialização e desserialização de objetos da classe.

    //Estas linhas declaram os atributos da classe Pessoa, incluindo identificador, nome, CPF, e-mail, senha, perfis, e data de criação. As anotações @Id e @GeneratedValue são usadas para indicar
    // que o campo id é a chave primária da entidade e que será gerado automaticamente pelo banco de dados. A anotação @CPF valida se o CPF é válido. As anotações @ElementCollection e @CollectionTable
    // são usadas para mapear a coleção de perfis para uma tabela separada no banco de dados.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nome;

    @CPF
    @Column(unique = true)
    protected String cpf;

    @Column(unique = true)
    protected String email;
    protected String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    protected Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    //Este é o construtor padrão da classe Pessoa. Ele chama o construtor da classe pai (Object) e adiciona o perfil de cliente à pessoa.

    public Pessoa() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    //Este é um construtor sobrecarregado que inicializa os campos da classe Pessoa com os valores fornecidos e adiciona o perfil de cliente à pessoa.

    public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
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

    //Estes são métodos de acesso para obter e definir os perfis da pessoa. O método getPerfis() converte
    // os códigos dos perfis em objetos Perfil, enquanto o método addPerfil() adiciona um perfil à coleção de perfis.

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    //Estes são métodos de acesso para obter e definir a data de criação da pessoa.

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


    //Este método hashCode() é uma implementação padrão para calcular o código de hash de um objeto da classe Pessoa.

    //Esta linha indica que o método está sobrescrevendo o método hashCode() definido na classe Object.
    @Override
    public int hashCode() {
        //Esta linha define um número primo que é usado para calcular o código de hash. Esse número primo é comumente usado na fórmula para evitar colisões de hash.
        final int prime = 31;
        //Esta linha inicializa a variável result, que armazenará o resultado final do cálculo do código de hash.
        int result = 1;
        //Esta linha adiciona ao resultado a contribuição do campo cpf. Se o cpf for nulo, ele contribui com 0 para o código de hash; caso contrário, contribui com o código de hash do cpf.
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        //Esta linha adiciona ao resultado a contribuição do campo id. Se o id for nulo, ele contribui com 0 para o código de hash; caso contrário, contribui com o código de hash do id.
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        //Esta linha retorna o resultado final do cálculo do código de hash.
        return result;
    }

    //Estes são os métodos hashCode() e equals() sobrescritos para garantir que objetos da classe Pessoa sejam comparados
    // corretamente. O método hashCode() calcula um código de hash baseado no id e no cpf da pessoa. O método equals() compara
    // dois objetos Pessoa com base em seus id e cpf.

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}