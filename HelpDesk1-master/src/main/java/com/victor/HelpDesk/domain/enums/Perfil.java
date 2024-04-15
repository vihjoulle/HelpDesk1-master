package com.victor.HelpDesk.domain.enums;

public enum Perfil //Esta linha inicia a declaração do enum Perfil.
{

    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO"); //Esta linha enumera os diferentes perfis possíveis, cada um com um código e uma descrição associada. O perfil ADMIN possui código 0 e descrição "ROLE_ADMIN", o perfil CLIENTE possui código 1 e descrição "ROLE_CLIENTE", e o perfil TECNICO possui código 2 e descrição "ROLE_TECNICO".

    //Estas linhas declaram as variáveis de instância codigo e descricao, que representam o código e a descrição associados a cada perfil.

    private Integer codigo;
    private String descricao;

    //Este é o construtor privado do enum Perfil, que recebe um código e uma descrição e inicializa as variáveis de instância correspondentes.

    private Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    //Estes são métodos de acesso que permitem obter o código e a descrição de um perfil.

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    //Este é um método estático que converte um código inteiro em um enum Perfil. Ele verifica se o código fornecido corresponde a
    // algum dos códigos dos perfis e, se correspondido, retorna o enum correspondente. Se o código não corresponder a nenhum perfil,
    // ele lança uma exceção IllegalArgumentException com a mensagem "Perfil inválido".

    public static Perfil toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Perfil x : Perfil.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Perfil inválido");
    }
}