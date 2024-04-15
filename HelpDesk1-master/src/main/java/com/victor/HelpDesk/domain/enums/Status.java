package com.victor.HelpDesk.domain.enums;

@SuppressWarnings({"unused", "UnnecessaryModifier"})
public enum Status //Esta linha inicia a declaração do enum Status.
{


    //Esta linha enumera os diferentes estados de status, cada um com um código e uma descrição associada. O status ABERTO possui
    // código 0 e descrição "ABERTO", o status ANDAMENTO possui código 1 e descrição "ANDAMENTO", e o status ENCERRADO possui código
    // 2 e descrição "ENCERRADO".

    ABERTO (0, "ABERTO"), ANDAMENTO (1, "ANDAMENTO"), ENCERRADO (2, "ENCERRADO");

    //Estas linhas declaram as variáveis finais de instância codigo e descricao, que representam o código e a descrição associados a cada estado de status.

    private final int codigo;
    private final String descricao;

    //Este é o construtor privado do enum Status, que recebe um código e uma descrição e inicializa as variáveis finais de instância correspondentes.

    private Status(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    //Estes são métodos de acesso que permitem obter o código e a descrição de um estado de status.

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    //Este é um método estático que converte um código inteiro em um enum Status. Ele verifica se o
    // código fornecido corresponde a algum dos códigos dos estados de status e, se correspondido,
    // retorna o enum correspondente. Se o código não corresponder a nenhum estado de status, ele
    // lança uma exceção IllegalAccessException com a mensagem "Status inválido".

    public static Status toEnum(Integer cod) throws IllegalAccessException {
        if(cod == null) {
            return null;
        }
        for (Status x: Status.values()){
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalAccessException("Status inválido");
    }
}


