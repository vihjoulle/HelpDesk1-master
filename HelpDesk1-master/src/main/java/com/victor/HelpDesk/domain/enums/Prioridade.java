package com.victor.HelpDesk.domain.enums;

@SuppressWarnings({"unused", "UnnecessaryModifier"})
public enum Prioridade //Esta linha inicia a declaração do enum Prioridade.
{

    //Esta linha enumera os diferentes níveis de prioridade, cada um com um código
    // e uma descrição associada. O nível BAIXA possui código 0 e descrição "BAIXA",
    // o nível MEDIA possui código 1 e descrição "MEDIA", e o nível ALTA possui código 2 e descrição "ALTA".

    BAIXA (0, "BAIXA"), MEDIA (1, "MEDIA"), ALTA (2, "ALTA");

    //Estas linhas declaram as variáveis finais de instância codigo e descricao, que representam o código e a
    // descrição associados a cada nível de prioridade.

    private final int codigo;
    private final String descricao;

    //Este é o construtor privado do enum Prioridade, que recebe um código e uma descrição e inicializa as
    // variáveis finais de instância correspondentes.

    private Prioridade(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    //Estes são métodos de acesso que permitem obter o código e a descrição de um nível de prioridade.

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    //Este é um método estático que converte um código inteiro em um enum Prioridade. Ele verifica se o código
    // fornecido corresponde a algum dos códigos dos níveis de prioridade e, se correspondido, retorna o enum correspondente.
    // Se o código não corresponder a nenhum nível de prioridade, ele lança uma exceção IllegalAccessException com a mensagem
    // "Prioridade inválida".

    public static Prioridade toEnum(Integer cod) throws IllegalAccessException {
        if(cod == null) {
            return null;
        }
        for (Prioridade x: Prioridade.values()){
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalAccessException("Prioridade inválida");
    }
}


